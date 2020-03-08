package se.ecutb.khalifa.recept_databasen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se.ecutb.khalifa.recept_databasen.data.RecipeRepository;
import se.ecutb.khalifa.recept_databasen.entity.Recipe;
import se.ecutb.khalifa.recept_databasen.entity.RecipeCategory;
import se.ecutb.khalifa.recept_databasen.entity.RecipeIngredient;
import se.ecutb.khalifa.recept_databasen.entity.RecipeInstruction;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class CreateRecipeServiceImpl implements CreateRecipeService {
    private RecipeRepository recipeRepository;

    @Autowired
    public CreateRecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public Recipe createAndSave(String recipeName, List<RecipeIngredient> recipeIngredients, RecipeInstruction instruction, List<RecipeCategory> categories) {
              if (hasNull(recipeName,recipeIngredients)){
           throw new RuntimeException(" one or more parameter is null");
       }
        Recipe recipe= recipeRepository.save(new Recipe(recipeName, recipeIngredients,instruction,categories));

        return recipe;
    }

    public static boolean hasNull(Object...objects) {
        return Arrays.stream(objects)
                .anyMatch(object -> Objects.isNull(object));
    }
}
