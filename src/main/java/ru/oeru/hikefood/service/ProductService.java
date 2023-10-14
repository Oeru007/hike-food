package ru.oeru.hikefood.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.oeru.hikefood.domain.Product;
import ru.oeru.hikefood.dto.request.CreateProductRequest;
import ru.oeru.hikefood.dto.response.ProductResponse;
import ru.oeru.hikefood.mapper.ProductMapper;
import ru.oeru.hikefood.repository.ProductRepository;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductResponse getById(UUID id) {
        Product product = productRepository.getByIdOrThrow(id);
        return productMapper.toResponseFromEntity(product);
    }

    public Product create(CreateProductRequest request) {
        return productRepository.saveAndFlush(productMapper.toEntityFromRequest(request));
    }
}
