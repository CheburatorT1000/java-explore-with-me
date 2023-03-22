package ru.practicum.ewm.stat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.practicum.ewm.stat.model.EndpointHit;

public interface StatRepository extends JpaRepository<EndpointHit, Long>, CustomStatRepository {
}
