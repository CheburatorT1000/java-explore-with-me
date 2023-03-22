package ru.practicum.ewm.stat.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.practicum.EndpointHitDTO;
import ru.practicum.ViewStatsDTO;
import ru.practicum.ewm.stat.mapper.EndpointMapper;
import ru.practicum.ewm.stat.mapper.ViewStatsMapper;
import ru.practicum.ewm.stat.model.EndpointHit;
import ru.practicum.ewm.stat.repository.StatRepository;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StatServiceImpl implements StatService {

    private final StatRepository statRepository;

    @Override
    public EndpointHitDTO postHit(EndpointHitDTO endpointHitDTO) {
        EndpointHit endpointHit = EndpointMapper.ENDPOINT_MAPPER.fromDto(endpointHitDTO);
        return EndpointMapper.ENDPOINT_MAPPER.toEndpointHitDto(statRepository.save(endpointHit));
    }

    @Override
    public List<ViewStatsDTO> getStats(LocalDateTime start,
                                       LocalDateTime end,
                                       List<String> uris,
                                       boolean unique) {

        return statRepository.getStats(start, end, uris, unique).stream()
                .map(ViewStatsMapper.VIEW_STATS_MAPPER::toDto)
                .collect(Collectors.toList());
    }
}
