package se.ecutb.khalifa.recept_databasen.data;

import org.springframework.data.repository.CrudRepository;
import se.ecutb.khalifa.recept_databasen.entity.RecipeIngredient;

public interface RecipeIngredientRepository extends CrudRepository<RecipeIngredient,String> {
}
