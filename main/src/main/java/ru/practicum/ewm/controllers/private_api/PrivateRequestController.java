package ru.practicum.ewm.controllers.private_api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.practicum.ewm.entity.dto.request.ParticipationRequestDto;
import ru.practicum.ewm.services.request.RequestService;

import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/users/{userId}/requests")
@Validated
public class PrivateRequestController {
    private final RequestService requestService;

    @GetMapping
    public List<ParticipationRequestDto> getUserRequests(@Positive @PathVariable Long userId) {
        return requestService.privateApiGetUserRequests(userId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ParticipationRequestDto privatePostRequest(@Positive @PathVariable Long userId,
                                                      @Positive @RequestParam Long eventId) {
        return requestService.privateApiPostRequest(userId, eventId);
    }

    @PatchMapping("/{requestId}/cancel")
    public ParticipationRequestDto privateApiPatchRequest(@Positive @PathVariable Long userId,
                                                          @Positive @PathVariable Long requestId) {
        return requestService.privateApiCancelRequest(userId, requestId);
    }
}
