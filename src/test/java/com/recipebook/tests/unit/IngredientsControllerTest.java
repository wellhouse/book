package com.recipebook.tests.unit;

import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import com.recipebook.model.enums.OccasionEnum;
import com.recipebook.recipe.service.RecipeService;
import com.recipebook.tests.mocks.ClientTemplateLoader;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class IngredientsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RecipeService recipeService;

    public IngredientsControllerTest() {
        FixtureFactoryLoader.loadTemplates(ClientTemplateLoader.LOCAL_PACKAGE);
    }

    @Test
    void recieveStatus200() throws Exception {
        mockMvc.perform(get("/api/book/recipe")
                        .param("occasion", OccasionEnum.BRUNCH.toString())
                        .contentType("application/json"))
                .andExpect(status().isOk());
    }

    @Test
    void updateRecieveStatus500() throws Exception {
        mockMvc.perform(get("/api/book/recipe/{uuid}","a416e14c-b077-4c0a-9934-3f34c3307f8a")
                        .contentType("application/json"))
                .andExpect(status().isInternalServerError());
    }
}
