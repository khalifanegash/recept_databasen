package se.ecutb.khalifa.recept_databasen.data;

import org.springframework.data.repository.CrudRepository;
import se.ecutb.khalifa.recept_databasen.entity.RecipeCategory;

public interface RecipeCategoryRepository extends CrudRepository<RecipeCategory,Integer> {
}
