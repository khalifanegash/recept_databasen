package se.ecutb.khalifa.recept_databasen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import se.ecutb.khalifa.recept_databasen.data.*;
import se.ecutb.khalifa.recept_databasen.entity.*;

import java.util.Arrays;

@Component
public class ComandLine implements CommandLineRunner {

   private IngredientRepository ingredientRepository;
   private RecipeCategoryRepository recipeCategoryRepository;
   private RecipeIngredientRepository recipeIngredientRepository;
   private RecipeInstructionRepository recipeInstructionRepository;
   private RecipeRepository recipeRepository;

   @Autowired
    public ComandLine(IngredientRepository ingredientRepository, RecipeCategoryRepository recipeCategoryRepository, RecipeIngredientRepository recipeIngredientRepository, RecipeInstructionRepository recipeInstructionRepository, RecipeRepository recipeRepository) {
        this.ingredientRepository = ingredientRepository;
        this.recipeCategoryRepository = recipeCategoryRepository;
        this.recipeIngredientRepository = recipeIngredientRepository;
        this.recipeInstructionRepository = recipeInstructionRepository;
        this.recipeRepository = recipeRepository;
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void run(String... args) throws Exception {

        Ingredient ingredient = new Ingredient("potatis");
        ingredientRepository.save(ingredient);
        RecipeCategory recipeCategory = new RecipeCategory("onion",null);
        recipeCategoryRepository.save(recipeCategory);
        RecipeIngredient recipeIngredient = new RecipeIngredient(ingredient,6, Measurement.G,null);
        recipeIngredientRepository.save(recipeIngredient);
        RecipeInstruction recipeInstruction = new RecipeInstruction("kokas potatis");
        recipeInstructionRepository.save(recipeInstruction);
        Recipe recipe = new Recipe("potatis lunch", Arrays.asList(recipeIngredient),recipeInstruction,null);
        recipeRepository.save(recipe);
    }
}
