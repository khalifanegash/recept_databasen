package se.ecutb.khalifa.recept_databasen.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.ecutb.khalifa.recept_databasen.entity.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
public class RecipeRepositoryTest {
    @Autowired
    private RecipeRepository testObject;

    Recipe recipeone;
    Recipe recipetwo;
    RecipeCategory recipeCategoryOne;
    RecipeCategory recipeCategoryTwo;

    @BeforeEach
    public void setUp() {
        Ingredient ingredientOne = new Ingredient("apple juice");
        Ingredient ingredientTwo = new Ingredient("orange juice");

        RecipeIngredient recipeIngredientOne = new RecipeIngredient(ingredientOne,2, Measurement.DL,null);
        RecipeIngredient recipeIngredientTwo = new RecipeIngredient(ingredientTwo,3,Measurement.DL,null);

        recipeCategoryOne = new RecipeCategory("breakfast",null);
        recipeCategoryTwo = new RecipeCategory("lunch",null);

        recipeone = new Recipe("Pasta",new ArrayList<>(Arrays.asList(recipeIngredientOne)),null,Arrays.asList(recipeCategoryOne,recipeCategoryTwo));
        recipetwo = new Recipe("cheese",new ArrayList<>(Arrays.asList(recipeIngredientTwo)),null,Arrays.asList(recipeCategoryTwo));

        testObject.save(recipeone);
        testObject.save(recipetwo);

    }

    @Test
    public void findRecipeName() {
        String name = "Pasta";

        assertEquals(recipeone,testObject.findByRecipeNameContainsIgnoreCase(name).get(0));
        assertTrue(testObject.count() ==2);
    }
      @Test
    public void findAllRecipeIngredient(){
        String ingredientName = "Juice";
        assertNotNull(testObject.findByRecipeIngredientsIngredientIngredientName(ingredientName));
    }
    @Test
    public void findAllRecipeByRecipe(){
        String category = "lunch";
        assertEquals(2,testObject.findByCategoriesCategoryIgnoreCase(category).size());
        assertNotNull(testObject.findByCategoriesCategoryIgnoreCase(category));
    }
    @Test
    public void findAllRecipeByList(){
        List<String> categoryList = Arrays.asList("pasta","cheese");

        assertNotNull(testObject.findByCategoriesCategoryIn(categoryList));
        
    }

}
