package ru.oeru.hikefood.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.oeru.hikefood.domain.ProductWeight;
import ru.oeru.hikefood.domain.Recipe;
import ru.oeru.hikefood.domain.Product;
import ru.oeru.hikefood.dto.request.CreateRecipeRequest;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RecipeMapper {

    @Mapping(target = "version", ignore = true)
    @Mapping(target = "modifyDate", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "creationDate", ignore = true)
    Recipe toEntityFromCreateRequest(CreateRecipeRequest request, List<ProductWeight> productWeights);
}
