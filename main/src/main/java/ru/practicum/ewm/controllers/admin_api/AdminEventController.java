package ru.practicum.ewm.controllers.admin_api;

import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.practicum.ewm.entity.dto.event.EventFullDto;
import ru.practicum.ewm.entity.dto.event.UpdateEventAdminRequest;
import ru.practicum.ewm.entity.enums.Status;
import ru.practicum.ewm.services.event.EventService;
import ru.practicum.ewm.utils.Constants;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/admin/events")
@Validated
public class AdminEventController {

    private final EventService eventService;

    @GetMapping
    public List<EventFullDto> adminGetByParams(@RequestParam(required = false) List<Long> users,
                                               @RequestParam(required = false) List<Status> states,
                                               @RequestParam(required = false) List<Long> categories,
                                               @RequestParam(required = false) @DateTimeFormat(pattern = Constants.TIME_PATTERN)
                                               LocalDateTime rangeStart,
                                               @RequestParam(required = false) @DateTimeFormat(pattern = Constants.TIME_PATTERN)
                                               LocalDateTime rangeEnd,
                                               @PositiveOrZero @RequestParam(defaultValue = "0") Integer from,
                                               @Positive @RequestParam(defaultValue = "10") Integer size) {
        return eventService.adminGetByParams(users, states, categories, rangeStart, rangeEnd, from, size);
    }

    @PatchMapping("/{eventId}")
    public EventFullDto adminPatchEvent(@Positive @PathVariable Long eventId,
                                        @Valid @RequestBody UpdateEventAdminRequest eventDto) {
        return eventService.adminPatchEvent(eventId, eventDto);
    }
}
