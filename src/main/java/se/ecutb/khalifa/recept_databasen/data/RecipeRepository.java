package se.ecutb.khalifa.recept_databasen.data;

import org.springframework.data.repository.CrudRepository;
import se.ecutb.khalifa.recept_databasen.entity.Recipe;
import se.ecutb.khalifa.recept_databasen.entity.RecipeCategory;

import java.util.List;

public interface RecipeRepository extends CrudRepository<Recipe, Integer> {
    List<Recipe> findByRecipeNameContainsIgnoreCase (String recipeName);
    List<Recipe> findByRecipeIngredientsIngredientIngredientName(String ingredintName);
    List<Recipe> findByCategoriesCategoryIgnoreCase (String category);
    List<Recipe> findByCategoriesCategoryIn(List<String> recipeCategories);

}
