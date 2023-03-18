package ru.practicum.ewm.stat.model;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ViewStats {
    String app;
    String uri;
    Long hits;
}