package ru.oeru.hikefood.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.oeru.hikefood.domain.Recipe;
import ru.oeru.hikefood.domain.Product;
import ru.oeru.hikefood.dto.request.CreateRecipeRequest;
import ru.oeru.hikefood.mapper.ProductWeightMapper;
import ru.oeru.hikefood.mapper.RecipeMapper;
import ru.oeru.hikefood.repository.RecipeRepository;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class RecipeService {
    private final RecipeRepository recipeRepository;

    private final RecipeMapper recipeMapper;
    private final ProductWeightMapper productWeightMapper;

    private final ProductService productService;


    @Transactional
    public Recipe create(CreateRecipeRequest request) {
        Map<UUID, Double> productIdMapWeight = request.ProductWeights()
                .stream()
                .collect(Collectors
                        .toMap(CreateRecipeRequest.ProductWeightCreateRecipe::productId,
                                CreateRecipeRequest.ProductWeightCreateRecipe::weight));

        List<Product> products = productService.getAllByIdIn(productIdMapWeight.keySet());

        if (request.ProductWeights().size() != products.size()) {
            throw new RuntimeException("Не все продукты из списка найдены");
        }

        Recipe recipe = recipeMapper.toEntityFromCreateRequest(
                request,
                products.stream()
                        .map(product -> productWeightMapper
                                .buildEntityFromArgs(
                                        productIdMapWeight.get(product.getId()),
                                        product))
                        .collect(Collectors.toList()));
        recipe.getProductWeights().forEach(productWeight -> productWeight.setRecipe(recipe));
        Recipe recipe1 = recipeRepository.saveAndFlush(recipe);
        return recipe1;
    }
}
