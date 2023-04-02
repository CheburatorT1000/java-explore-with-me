package ru.practicum.ewm.entity.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import ru.practicum.ewm.entity.enums.RequestStatus;
import ru.practicum.ewm.utils.Constants;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ParticipationRequestDto {
    private Long id;
    @JsonFormat(pattern = Constants.TIME_PATTERN, shape = JsonFormat.Shape.STRING)
    private LocalDateTime created;
    private Long event;
    private Long requester;
    private RequestStatus status;
}
