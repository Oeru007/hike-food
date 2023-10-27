package ru.oeru.hikefood.dto.request;

import java.util.UUID;

public record ProductWeightCreateRecipe(UUID productId, double weight) {
}
