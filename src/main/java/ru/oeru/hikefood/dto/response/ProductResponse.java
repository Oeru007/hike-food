package ru.oeru.hikefood.dto.response;

import lombok.Builder;

import java.util.UUID;

@Builder
public record ProductResponse(UUID id, String productName, int calories, Float protein, Float fat, Float carbohydrates) {
}
