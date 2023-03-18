package ru.practicum.ewm.stat.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.practicum.EndpointHitDTO;
import ru.practicum.ViewStatsDTO;
import ru.practicum.ewm.stat.model.EndpointHit;
import ru.practicum.ewm.stat.service.StatService;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class StatController {

    public static String TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(TIME_PATTERN);
    private final StatService statService;

    @PostMapping("/hit")
    public EndpointHit hit(@RequestBody @Valid EndpointHitDTO endpointHitDTO) {
        return statService.postHit(endpointHitDTO);
    }

    @GetMapping("/stats")
    public List<ViewStatsDTO> getStats(@RequestParam String start,
                                       @RequestParam String end,
                                       @RequestParam(required = false) List<String> uris,
                                       @RequestParam(defaultValue = "false") boolean unique) {
        return statService.getStats(LocalDateTime.parse(start, formatter),
                                    LocalDateTime.parse(end, formatter),
                                    uris,
                                    unique);
    }
}
