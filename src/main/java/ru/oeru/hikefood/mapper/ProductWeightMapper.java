package ru.oeru.hikefood.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.oeru.hikefood.domain.Product;
import ru.oeru.hikefood.domain.ProductWeight;
import ru.oeru.hikefood.domain.Recipe;
import ru.oeru.hikefood.dto.request.CreateRecipeRequest;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductWeightMapper {

    @Mapping(target = "recipe", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "product", source = "product")
    ProductWeight buildEntityFromArgs(double weight, Product product);
}
