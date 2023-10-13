package ru.oeru.hikefood.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.oeru.hikefood.domain.Product;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
}
