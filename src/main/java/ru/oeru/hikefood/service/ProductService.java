package ru.oeru.hikefood.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.oeru.hikefood.domain.Product;
import ru.oeru.hikefood.repository.ProductRepository;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Product getById(UUID id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Продукт не найден"));
    }
}
