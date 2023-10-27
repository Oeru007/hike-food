package ru.oeru.hikefood.api;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.oeru.hikefood.domain.Recipe;
import ru.oeru.hikefood.dto.request.CreateRecipeRequest;
import ru.oeru.hikefood.service.RecipeService;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/recipe")
public class RecipeController {
    private final RecipeService recipeService;

    @PostMapping("/create")
    public ResponseEntity<Recipe> create(@Valid @RequestBody CreateRecipeRequest request) {
        Recipe recipe = recipeService.create(request);
        return ResponseEntity.ok(recipe);
    }
}
