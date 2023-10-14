package ru.oeru.hikefood.dto.request;

import jakarta.validation.constraints.NotBlank;

public record CreateProductRequest(
        @NotBlank
        String productName,
        int calories,
        Float protein,
        Float fat,
        Float carbohydrates) {
}
