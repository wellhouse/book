package com.recipebook.recipe.dto;

import com.recipebook.model.enums.OccasionEnum;
import com.recipebook.model.enums.RecipeTypeEnum;
import lombok.Data;

@Data
public class RecipeFilterDto {

    private Integer offset;
    private Integer limit;

    private String title;

    private Integer initPrepTime;
    private Integer limitPrepTime;

    private Integer initCookTime;
    private Integer limitCookTime;

    private Integer minServing;
    private Integer maxServing;

    private String instructions;
    private String withIngredientes;
    private String withoutIngredientes;

    private String notes;

    private OccasionEnum occasion;

    private RecipeTypeEnum recipeType;
}
