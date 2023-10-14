package ru.oeru.hikefood.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.oeru.hikefood.domain.Product;
import ru.oeru.hikefood.dto.request.CreateProductRequest;
import ru.oeru.hikefood.dto.response.ProductResponse;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductResponse toResponseFromEntity(Product product);

    @Mapping(target = "version", ignore = true)
    @Mapping(target = "modifyDate", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "creationDate", ignore = true)
    Product toEntityFromRequest(CreateProductRequest request);
}
