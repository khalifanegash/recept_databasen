package se.ecutb.khalifa.recept_databasen.data;

import org.springframework.data.repository.CrudRepository;
import se.ecutb.khalifa.recept_databasen.entity.Ingredient;

import java.util.List;
import java.util.Optional;

public interface IngredientRepository extends CrudRepository <Ingredient, Integer> {
    Optional<Ingredient> findByIngredientNameIgnoreCase(String ingredientName);
    List<Ingredient> findByIngredientNameContainsIgnoreCase(String name);
}
