package se.ecutb.khalifa.recept_databasen.data;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.ecutb.khalifa.recept_databasen.entity.Ingredient;
import se.ecutb.khalifa.recept_databasen.entity.Measurement;
import se.ecutb.khalifa.recept_databasen.entity.Recipe;
import se.ecutb.khalifa.recept_databasen.entity.RecipeIngredient;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class RecipeIngredientRepositoryTest {
    @Autowired
    private RecipeIngredientRepository testObject;

    private RecipeIngredient recipeIngredientOne;
    private RecipeIngredient recipeIngredientTwo;

    @BeforeEach
    void setUp(){
      recipeIngredientOne = new RecipeIngredient(new Ingredient("spageti"),1, Measurement.KG,new Recipe());
      recipeIngredientTwo = new RecipeIngredient(new Ingredient("pasta"), 1000,Measurement.G,new Recipe());

      testObject.save(recipeIngredientOne);
      testObject.save(recipeIngredientTwo);

    }
    @Test
    public void saveOneRecipeIngredient(){
        RecipeIngredient result = testObject.save(new RecipeIngredient(new Ingredient("salt"),1,Measurement.TSK,new Recipe()));

        assertEquals(3,testObject.count());
        assertNotNull(result);
    }
    @Test
    public void findByIdRecipeIngredient(){
        Optional<RecipeIngredient> result = testObject.findById(recipeIngredientOne.getId());

        assertNotNull(result);
        Assertions.assertTrue(result.isPresent());
    }
}
