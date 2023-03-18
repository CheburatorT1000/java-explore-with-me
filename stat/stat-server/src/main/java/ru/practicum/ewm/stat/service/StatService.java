package ru.practicum.ewm.stat.service;

import org.springframework.http.ResponseEntity;
import ru.practicum.EndpointHitDTO;
import ru.practicum.ViewStatsDTO;
import ru.practicum.ewm.stat.model.EndpointHit;

import java.time.LocalDateTime;
import java.util.List;

public interface StatService {
    EndpointHit postHit(EndpointHitDTO endpointHitDTO);

    List<ViewStatsDTO> getStats(LocalDateTime parse, LocalDateTime parse1, List<String> uris, boolean unique);
}
