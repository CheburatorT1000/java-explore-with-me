package ru.practicum.ewm.stat.service;

import ru.practicum.EndpointHitDTO;
import ru.practicum.ViewStatsDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface StatService {
    EndpointHitDTO postHit(EndpointHitDTO endpointHitDTO);

    List<ViewStatsDTO> getStats(LocalDateTime parse, LocalDateTime parse1, List<String> uris, boolean unique);
}
