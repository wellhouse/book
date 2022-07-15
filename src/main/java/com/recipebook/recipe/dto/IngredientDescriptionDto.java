package com.recipebook.recipe.dto;

import lombok.Data;

@Data
public class IngredientDescriptionDto {

    private String name;

    private String ingredient_type;

    private String measure;

    private String amount;
}
