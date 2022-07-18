package com.recipebook.tests.unit;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import com.recipebook.exceptions.business.ResourceNotFoundException;
import com.recipebook.recipe.dto.RecipeDto;
import com.recipebook.recipe.repository.RecipeRepository;
import com.recipebook.recipe.service.RecipeService;
import com.recipebook.tests.mocks.ClientTemplateLoader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class RecipeUnitTests {

    public RecipeUnitTests() {
        FixtureFactoryLoader.loadTemplates(ClientTemplateLoader.LOCAL_PACKAGE);
    }

    @Autowired
    private RecipeService recipeService;

    @Mock
    private RecipeRepository userRepository;

    @Test
    void saveRecipe() {

        RecipeDto recipe = Fixture.from(RecipeDto.class).gimme(ClientTemplateLoader.VALID_RECIPE);

        RecipeDto returnedRecipe = recipeService.save(recipe);

        Assertions.assertNotNull(returnedRecipe, "The saved recipe should not be null");
        Assertions.assertEquals("AAAAAAAAAAAAAAA\nBBBBBBBBBB\nCCCCCCCCC\nDDDDDDDD", returnedRecipe.getIngredients(), "Ingredients must be equal");
    }

    @Test
    void updateRecipe() {

        RecipeDto recipe = Fixture.from(RecipeDto.class).gimme(ClientTemplateLoader.VALID_RECIPE);

        RecipeDto returnedSaved = recipeService.save(recipe);

        recipe.setUuid(returnedSaved.getUuid());
        recipe.setIngredients("MODIFIED FIELD");

        RecipeDto returnModified = recipeService.update(recipe);

        Assertions.assertNotNull(returnModified, "The saved recipe should not be null");
        Assertions.assertEquals("MODIFIED FIELD", returnModified.getIngredients(), "Ingredients must be equal");
    }

    @Test
    void updateNotFoundRecipe() {

        RecipeDto recipe = Fixture.from(RecipeDto.class).gimme(ClientTemplateLoader.VALID_RECIPE);
        recipe.setUuid(UUID.randomUUID());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            recipeService.update(recipe);
        });
        assertTrue(exception.getMessage().contains("Recipe not found !"));
    }

    @Test
    void deleteteRecipe() {

        RecipeDto recipe = Fixture.from(RecipeDto.class).gimme(ClientTemplateLoader.VALID_RECIPE);
        RecipeDto returnedSaved = recipeService.save(recipe);

        recipeService.delete(returnedSaved.getUuid());
    }

    @Test
    void deleteteNotFoundRecipe() {

        UUID uuid = UUID.randomUUID();

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {

            recipeService.delete(uuid);
        });
        assertTrue(exception.getMessage().contains("Resource not found !" + uuid));
    }
}
