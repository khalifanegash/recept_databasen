package se.ecutb.khalifa.recept_databasen.data;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.ecutb.khalifa.recept_databasen.entity.RecipeCategory;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class RecipeCategoryRepositoryTest {

    @Autowired
    private RecipeCategoryRepository testObject;

    RecipeCategory recipeCategoryOne;
    RecipeCategory recipeCategoryTwo;

    @BeforeEach
    void setUp(){
        recipeCategoryOne = new RecipeCategory("breakfast",null);
        recipeCategoryTwo = new RecipeCategory("lunch",null);

        testObject.save(recipeCategoryOne);
        testObject.save(recipeCategoryTwo);

    }
    @Test
    public void saveOneRecipeCategory(){
        Optional<RecipeCategory> categoryTest = Optional.of(new RecipeCategory("meat beef", null));
        RecipeCategory result = testObject.save(categoryTest.get());

       assertEquals(categoryTest,testObject.findById(categoryTest.get().getCategoryId()));
        assertNotNull(result.getCategoryId());
        assertTrue(testObject.count() == 3);

    }
    @Test
    public void deleteRecipeCategory(){
        testObject.delete(recipeCategoryOne);
        assertEquals(1,testObject.count());
    }
}
