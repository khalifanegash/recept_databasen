package se.ecutb.khalifa.recept_databasen.service;

import org.springframework.transaction.annotation.Transactional;
import se.ecutb.khalifa.recept_databasen.entity.Recipe;
import se.ecutb.khalifa.recept_databasen.entity.RecipeCategory;
import se.ecutb.khalifa.recept_databasen.entity.RecipeIngredient;
import se.ecutb.khalifa.recept_databasen.entity.RecipeInstruction;

import java.util.List;

public interface CreateRecipeService {
    @Transactional(rollbackFor = RuntimeException.class)
    Recipe createAndSave(String recipeName, List<RecipeIngredient> recipeIngredients, RecipeInstruction instruction, List<RecipeCategory> categories);
}
