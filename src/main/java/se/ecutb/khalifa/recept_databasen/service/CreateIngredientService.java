package se.ecutb.khalifa.recept_databasen.service;

import org.springframework.transaction.annotation.Transactional;
import se.ecutb.khalifa.recept_databasen.entity.Ingredient;

public interface CreateIngredientService {
    @Transactional(rollbackFor = RuntimeException.class)
    Ingredient createAndSave(String IngredientName);
}
