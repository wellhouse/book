package com.recipebook.tests.integration;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.recipebook.model.enums.OccasionEnum;
import com.recipebook.model.enums.RecipeTypeEnum;
import com.recipebook.recipe.dto.RecipeDto;
import com.recipebook.tests.mocks.ClientTemplateLoader;
import org.junit.BeforeClass;
import org.junit.Test;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;
import java.util.UUID;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RecipeIntegrationTest {

    @BeforeClass
    public static void setUp() {
        FixtureFactoryLoader.loadTemplates(ClientTemplateLoader.LOCAL_PACKAGE);
    }

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper = new ObjectMapper();


    @Test
    @Order(1)
    public void saveTest() throws Exception {

        RecipeDto recipe = Fixture.from(RecipeDto.class).gimme(ClientTemplateLoader.VALID_RECIPE);

        this.mockMvc
                .perform(post("/api/book/recipe/")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(recipe))
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Pineaple Pie"))
                .andExpect(jsonPath("$.instructions").value("AAAAAAAAAAAAAAA\nBBBBBBBBBB\nCCCCCCCCC\nDDDDDDDD"))
                .andExpect(jsonPath("$.ingredients").value("AAAAAAAAAAAAAAA\nBBBBBBBBBB\nCCCCCCCCC\nDDDDDDDD"))
                .andExpect(jsonPath("$.uuid-user").isNotEmpty())
                .andExpect(jsonPath("$.uuid-user").value("4ab9a501-0697-4905-a790-8a604391cbf1"))
                .andExpect(jsonPath("$.occasion").value(OccasionEnum.BREAKFAST.toString()))
                .andExpect(jsonPath("$.recipe-type").value(RecipeTypeEnum.DESSERT.toString()))
                .andReturn();
    }

    @Test()
    @Order(2)
    public void updateTest() throws Exception {

        RecipeDto recipe = Fixture.from(RecipeDto.class).gimme(ClientTemplateLoader.VALID_RECIPE);

        recipe.setInstructions("MODIFIED FIELD");

        this.mockMvc
                .perform(put("/api/book/recipe/a416e14c-b077-4c0a-9934-3f34c3307f8a")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(recipe))
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Pineaple Pie"))
                .andExpect(jsonPath("$.instructions").value("MODIFIED FIELD"))
                .andExpect(jsonPath("$.ingredients").value("AAAAAAAAAAAAAAA\nBBBBBBBBBB\nCCCCCCCCC\nDDDDDDDD"))
                .andExpect(jsonPath("$.uuid-user").isNotEmpty())
                .andExpect(jsonPath("$.uuid-user").value("4ab9a501-0697-4905-a790-8a604391cbf1"))
                .andExpect(jsonPath("$.occasion").value(OccasionEnum.BREAKFAST.toString()))
                .andExpect(jsonPath("$.recipe-type").value(RecipeTypeEnum.DESSERT.toString()))
                .andReturn();
    }

    @Test
    @Order(3)
    public void filterTest() throws Exception {

        MvcResult mvcResult = this.mockMvc
                .perform(get("/api/book/recipe/filter?title=Aple Pie&offset=1&limit=20")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk()).andReturn();

        List<RecipeDto> listRecipeDto = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), new TypeReference<List<RecipeDto>>(){});

    }

    @Test
    @Order(4)
    public void deleteNotFoundTest() throws Exception {

        this.mockMvc
                .perform(delete("/api/book/recipe/11111111-e049-4155-8c29-5ad1e6da589b")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                ).andExpect(status().isNotFound()).andReturn();
    }

    @Test
    @Order(5)
    public void deleteTest() throws Exception {

        this.mockMvc
                .perform(delete("/api/book/recipe/fca81ff0-e049-4155-8c29-5ad1e6da589b")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                ).andExpect(status().isOk()).andReturn();

    }
}
