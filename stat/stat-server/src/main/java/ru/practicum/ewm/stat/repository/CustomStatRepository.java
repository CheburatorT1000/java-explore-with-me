package ru.practicum.ewm.stat.repository;

import ru.practicum.ewm.stat.model.ViewStats;

import java.time.LocalDateTime;
import java.util.List;

public interface CustomStatRepository {

    List<ViewStats> getStats(LocalDateTime start, LocalDateTime end, List<String> uris, boolean unique);
}
