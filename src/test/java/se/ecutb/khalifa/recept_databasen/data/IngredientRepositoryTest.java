package se.ecutb.khalifa.recept_databasen.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.ecutb.khalifa.recept_databasen.entity.Ingredient;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class IngredientRepositoryTest {
    @Autowired
    private IngredientRepository testObject;

    private Ingredient ingredientTestOne;
    private Ingredient ingredientTestTwo;
    private Ingredient ingredientTestThree;

    @BeforeEach
    void setUp(){
        ingredientTestOne = new Ingredient("juice");
        ingredientTestTwo = new Ingredient("orange juice");
        ingredientTestThree = new Ingredient("apple");

        testObject.save(ingredientTestOne);
        testObject.save(ingredientTestTwo);
        testObject.save(ingredientTestThree);

    }
    @Test
    public void findByNameOne(){
        String name = "apple";
        Optional<Ingredient> result = testObject.findByIngredientNameIgnoreCase(name);

        assertEquals(ingredientTestThree,result.get());
        assertTrue(result.isPresent());
    }
       @Test
    public void findByNameTwo(){
        List<Ingredient> result = testObject.findByIngredientNameContainsIgnoreCase("juice");

        List<Ingredient> expected = new ArrayList<>();
        expected.add(ingredientTestOne);
        expected.add(ingredientTestTwo);

        assertEquals(expected,result);
        assertTrue(result.size() == 2);
        assertNotNull(result);
    }
}
