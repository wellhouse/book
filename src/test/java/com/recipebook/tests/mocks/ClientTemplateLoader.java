package com.recipebook.tests.mocks;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.recipebook.model.enums.OccasionEnum;
import com.recipebook.model.enums.RecipeTypeEnum;
import com.recipebook.recipe.dto.RecipeDto;

import java.util.UUID;

public class ClientTemplateLoader implements TemplateLoader {

    public static String LOCAL_PACKAGE = "com.recipebook.tests.mocks";
    public static String VALID_RECIPE = "valid-recipe";

    @Override
    public void load() {

        String instructions = """
                AAAAAAAAAAAAAAA\nBBBBBBBBBB\nCCCCCCCCC\nDDDDDDDD""";

        String ingredients = """
                AAAAAAAAAAAAAAA\nBBBBBBBBBB\nCCCCCCCCC\nDDDDDDDD""";

        String notes = """
                AAAAAAAAAAAAAAA\n
                BBBBBBBBBB
                """;

        Fixture.of(RecipeDto.class)
                .addTemplate("valid-recipe", new Rule(){{
                    add("recipeType", RecipeTypeEnum.DESSERT);
                    add("instructions", instructions);
                    add("occasion", OccasionEnum.BREAKFAST);
                    add("title", "Pineaple Pie");
                    add("cookTime", 200);
                    add("ingredients", ingredients);
                    add("notes", notes);
                    add("prepTime", 200);
                    add("serving", 10);
                    add("uuidUser", UUID.fromString("4ab9a501-0697-4905-a790-8a604391cbf1"));
                }});

    }
}
