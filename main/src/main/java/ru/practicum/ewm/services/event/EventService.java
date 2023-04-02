package ru.practicum.ewm.services.event;

import ru.practicum.ewm.entity.dto.event.*;
import ru.practicum.ewm.entity.dto.request.EventRequestStatusUpdateRequest;
import ru.practicum.ewm.entity.dto.request.EventRequestStatusUpdateResult;
import ru.practicum.ewm.entity.dto.request.ParticipationRequestDto;
import ru.practicum.ewm.entity.enums.SortEnum;
import ru.practicum.ewm.entity.enums.Status;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;

public interface EventService {
    List<EventFullDto> adminGetByParams(List<Long> users,
                                        List<Status> states,
                                        List<Long> categories,
                                        LocalDateTime rangeStart,
                                        LocalDateTime rangeEnd,
                                        Integer from,
                                        Integer size);

    EventFullDto adminPatchEvent(Long eventId, UpdateEventAdminRequest eventDto);

    List<EventFullDto> publicGetByParams(String text, List<Long> categories, Boolean paid, LocalDateTime rangeStart, LocalDateTime rangeEnd, Boolean onlyAvailable, SortEnum sort, Integer from, Integer size, HttpServletRequest request);

    EventFullDto publicGetEvent(Long eventId, HttpServletRequest request);

    List<EventShortDto> privateGetEventsByUser(Long userId, Integer from, Integer size);

    EventFullDto privatePostEvent(Long userId, NewEventDto eventDto);

    EventFullDto privateGetEventById(Long userId, Long eventId);

    EventFullDto privatePatchEventByUser(Long userId, Long eventId, UpdateEventUserRequest eventFullDto);

    List<ParticipationRequestDto> privateGetRequests(Long userId, Long eventId);

    EventRequestStatusUpdateResult privatePatchRequests(Long userId, Long eventId, EventRequestStatusUpdateRequest updateRequest);
}
