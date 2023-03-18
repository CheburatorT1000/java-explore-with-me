package ru.practicum.ewm.stat.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.practicum.EndpointHitDTO;
import ru.practicum.ViewStatsDTO;
import ru.practicum.ewm.stat.model.EndpointHit;

@Mapper
public interface EndpointMapper {

    EndpointMapper ENDPOINT_MAPPER = Mappers.getMapper(EndpointMapper.class);

    EndpointHit fromDto(EndpointHitDTO endpointHitDTO);

    ViewStatsDTO toDto(EndpointHit endpointHit);
}
