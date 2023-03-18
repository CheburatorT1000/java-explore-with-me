package ru.practicum.ewm.stat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.practicum.ewm.stat.model.EndpointHit;
import ru.practicum.ewm.stat.model.ViewStats;

import java.time.LocalDateTime;
import java.util.List;

public interface StatRepository extends JpaRepository<EndpointHit, Long> {
    @Query("select new ru.practicum.ewm.stat.model.ViewStats(eh.app, eh.uri, count(distinct(eh.ip))) " +
            "from EndpointHit as eh " +
            "where eh.timestamp between :start and :end " +
            "and eh.uri in (:uris) " +
            "group by eh.uri " +
            "order by count(distinct(eh.ip)) desc ")
    List<ViewStats> customFindAllByTimestampBetweenUnique(@Param("start")LocalDateTime start,
                                                          @Param("end")LocalDateTime end,
                                                          @Param("uris")List<String> uris);

    @Query("select new ru.practicum.ewm.stat.model.ViewStats(eh.app, eh.uri, count(eh.uri)) " +
            "from EndpointHit as eh " +
            "where eh.timestamp between :start and :end " +
            "and eh.uri in (:uris) " +
            "group by eh.uri " +
            "order by count(eh.uri) desc ")
    List<ViewStats> customFindAllByTimestampBetween(@Param("start")LocalDateTime start,
                                                    @Param("end")LocalDateTime end,
                                                    @Param("uris")List<String> uris);
}
