package se.ecutb.khalifa.recept_databasen.data;

import org.springframework.data.repository.CrudRepository;
import se.ecutb.khalifa.recept_databasen.entity.RecipeInstruction;

public interface RecipeInstructionRepository extends CrudRepository<RecipeInstruction, Integer> {
}
