package com.recipebook.config;

import com.recipebook.model.Recipe;
import com.recipebook.model.enums.OccasionEnum;
import com.recipebook.model.enums.RecipeTypeEnum;
import com.recipebook.recipe.dto.RecipeDto;
import com.recipebook.recipe.repository.RecipeRepository;
import com.recipebook.recipe.service.RecipeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class RecipeUnitTests {


    @Autowired
    private RecipeService recipeService;

    @Mock
    private RecipeRepository userRepository;

    @Test
    void savedUserHasRegistrationDate() {

        RecipeDto recipe = new RecipeDto();
        recipe.setRecipeType(RecipeTypeEnum.DESSERT);
        recipe.setInstructions("AAAAAAAAAAAAAAA\nBBBBBBBBBB\nCCCCCCCCC\nDDDDDDDD");
        recipe.setOccasion(OccasionEnum.BREAKFAST);
        recipe.setTitle("Pineaple Pie");
        recipe.setCookTime(200);
        recipe.setIngredients("AAAAAAAAAAAAAAA\nBBBBBBBBBB\nCCCCCCCCC\nDDDDDDDD");
        recipe.setNotes("AAAAAAAAAAAAAAA\nBBBBBBBBBB");
        recipe.setPrepTime(200);
        recipe.setServing(10);
        recipe.setUuidUser(UUID.fromString("4ab9a501-0697-4905-a790-8a604391cbf1"));

        RecipeDto returnedWidget = recipeService.save(recipe);

        Assertions.assertNotNull(returnedWidget, "The saved widget should not be null");
        Assertions.assertEquals("AAAAAAAAAAAAAAA\nBBBBBBBBBB\nCCCCCCCCC\nDDDDDDDD", returnedWidget.getIngredients(), "Ingredients must be equal");
    }

}
