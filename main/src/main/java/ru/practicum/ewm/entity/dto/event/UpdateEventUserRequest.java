package ru.practicum.ewm.entity.dto.event;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import ru.practicum.ewm.entity.enums.StateActionEnum;
import ru.practicum.ewm.entity.model.Location;
import ru.practicum.ewm.utils.Constants;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateEventUserRequest {
    private Long category;
    private String annotation;
    private String description;
    @JsonFormat(pattern = Constants.TIME_PATTERN, shape = JsonFormat.Shape.STRING)
    private LocalDateTime eventDate;
    private Location location;
    private Boolean paid;
    private Integer participantLimit;
    private Boolean requestModeration;
    private StateActionEnum stateAction;
    private String title;
}
