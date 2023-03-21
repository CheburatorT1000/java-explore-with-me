package ru.practicum.ewm.stat.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.practicum.ViewStatsDTO;
import ru.practicum.ewm.stat.model.ViewStats;

@Mapper
public interface ViewStatsMapper {

    ViewStatsMapper VIEW_STATS_MAPPER = Mappers.getMapper(ViewStatsMapper.class);

    ViewStatsDTO toDto(ViewStats viewStats);
}
