package ru.practicum.ewm.stat.repository.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.practicum.ewm.stat.model.EndpointHit;
import ru.practicum.ewm.stat.model.ViewStats;
import ru.practicum.ewm.stat.repository.CustomStatRepository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@Transactional
@RequiredArgsConstructor
public class CustomStatRepositoryImpl implements CustomStatRepository {

    private final EntityManager entityManager;

    @Override
    public List<ViewStats> getStats(LocalDateTime start, LocalDateTime end, List<String> uris, boolean unique) {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ViewStats> criteriaQuery = criteriaBuilder.createQuery(ViewStats.class);
        Root<EndpointHit> statsRoot = criteriaQuery.from(EndpointHit.class);
        List<Predicate> predicateList = new ArrayList<>();

        criteriaQuery.select(criteriaBuilder.construct(ViewStats.class,
                statsRoot.get("app"),
                statsRoot.get("uri"),
                unique ? criteriaBuilder.countDistinct(statsRoot.get("ip")) : criteriaBuilder.count(statsRoot.get("ip")))
        );

        criteriaQuery.groupBy(
                statsRoot.get("app"),
                statsRoot.get("uri"),
                statsRoot.get("ip")
        );

        predicateList.add(criteriaBuilder.between(statsRoot.get("timestamp"), start, end));

        if(uris != null)
            predicateList.add(criteriaBuilder.or(uris.stream()
                    .map(uri -> criteriaBuilder.like(statsRoot.get("uri"), uri))
                    .collect(Collectors.toList())
                    .toArray(Predicate[]::new)
            ));

        criteriaQuery.where(predicateList.toArray(Predicate[]::new));

        return entityManager.createQuery(criteriaQuery).getResultList();
    }
}
