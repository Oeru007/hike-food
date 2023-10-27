package ru.oeru.hikefood.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.oeru.hikefood.domain.Recipe;

import java.util.UUID;

public interface RecipeRepository extends JpaRepository<Recipe, UUID> {

    default Recipe getByIdOrThrow(UUID id) {
        if (id == null) {
            throw new RuntimeException("Блюдо не найдено");
        }

        return findById(id).orElseThrow(() -> new RuntimeException(String.format("Блюдо с id %s не найдено", id)));
    }
}
