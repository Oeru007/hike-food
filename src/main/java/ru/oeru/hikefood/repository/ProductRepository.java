package ru.oeru.hikefood.repository;

import org.hibernate.ObjectNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.oeru.hikefood.domain.Product;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {

    default Product getByIdOrThrow(UUID id) {
        if (id == null) {
            throw new RuntimeException("Продукт не найден");
        }

        return findById(id).orElseThrow(() -> new RuntimeException(String.format("Продукт с id %s не найден", id)));
    }
}
