package ru.practicum.ewm.entity.dto.category;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NewCategoryDto {
    @NotNull
    @NotEmpty
    private String name;
}