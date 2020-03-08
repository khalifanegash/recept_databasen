package se.ecutb.khalifa.recept_databasen.data;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.ecutb.khalifa.recept_databasen.entity.RecipeInstruction;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class RecipeInstructionRepositoryTest {

    @Autowired
    private RecipeInstructionRepository testObject;
    private RecipeInstruction recipeInstruction;

    @BeforeEach
    void setUp(){
        recipeInstruction = new RecipeInstruction("test instruction");
        testObject.save(recipeInstruction);
    }

    @Test

    void saveOneNameInstruction() {
        RecipeInstruction result = testObject.save(new RecipeInstruction("instructionOne") );

        assertEquals(2,testObject.count());
        assertNotNull(result);
    }
}
