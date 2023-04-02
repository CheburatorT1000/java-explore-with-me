package ru.practicum.ewm.services.request;

import ru.practicum.ewm.entity.dto.request.ParticipationRequestDto;

import java.util.List;

public interface RequestService {
    List<ParticipationRequestDto> privateApiGetUserRequests(Long userId);
    ParticipationRequestDto privateApiPostRequest(Long userId, Long eventId);
    ParticipationRequestDto privateApiCancelRequest(Long userId, Long requestId);
}
