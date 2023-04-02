package ru.practicum.ewm.controllers.private_api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.practicum.ewm.entity.dto.event.EventFullDto;
import ru.practicum.ewm.entity.dto.event.EventShortDto;
import ru.practicum.ewm.entity.dto.event.NewEventDto;
import ru.practicum.ewm.entity.dto.event.UpdateEventUserRequest;
import ru.practicum.ewm.entity.dto.request.EventRequestStatusUpdateRequest;
import ru.practicum.ewm.entity.dto.request.EventRequestStatusUpdateResult;
import ru.practicum.ewm.entity.dto.request.ParticipationRequestDto;
import ru.practicum.ewm.services.event.EventService;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/users/{userId}/events")
@Validated
public class PrivateEventController {

    private final EventService eventService;

    @GetMapping
    public List<EventShortDto> privateGetEventsByUser(@PathVariable Long userId,
                                                      @PositiveOrZero @RequestParam(defaultValue = "0") Integer from,
                                                      @Positive @RequestParam(defaultValue = "10") Integer size) {
        return eventService.privateGetEventsByUser(userId, from, size);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EventFullDto privatePostEvent(@PathVariable Long userId,
                                         @Valid @RequestBody NewEventDto eventDto) {
        return eventService.privatePostEvent(userId, eventDto);
    }

    @GetMapping("/{eventId}")
    public EventFullDto privateGetEventById(@PathVariable Long userId,
                                            @PathVariable Long eventId) {
        return eventService.privateGetEventById(userId, eventId);
    }

    @PatchMapping("/{eventId}")
    public EventFullDto privatePatchEventByUser(@PathVariable Long userId,
                                                @PathVariable Long eventId,
                                                @Valid @RequestBody UpdateEventUserRequest updateEventUserRequest) {
        return eventService.privatePatchEventByUser(userId, eventId, updateEventUserRequest);
    }

    @GetMapping("/{eventId}/requests")
    public List<ParticipationRequestDto> privateGetRequests(@PathVariable Long userId,
                                                            @PathVariable Long eventId) {
        return eventService.privateGetRequests(userId, eventId);
    }

    @PatchMapping("/{eventId}/requests")
    public EventRequestStatusUpdateResult privatePatchRequests(@PathVariable Long userId,
                                                               @PathVariable Long eventId,
                                                               @Valid @RequestBody EventRequestStatusUpdateRequest updateRequest) {
        return eventService.privatePatchRequests(userId, eventId, updateRequest);
    }
}