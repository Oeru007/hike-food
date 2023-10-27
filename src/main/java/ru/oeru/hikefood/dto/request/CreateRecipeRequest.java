package ru.oeru.hikefood.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Schema(description = "Запрос создания рецепта")
public record CreateRecipeRequest(
        @NotBlank
        String recipeName,
        @NotNull
        @NotEmpty
        @Valid
        Set<ProductWeightCreateRecipe> ProductWeights) {
        public record ProductWeightCreateRecipe(
                @NotNull UUID productId,
                @NotNull Double weight) {
        }
}
