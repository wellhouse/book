package com.recipebook.recipe.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.recipebook.custom.annotations.validators.UUID;
import com.recipebook.model.enums.OccasionEnum;
import com.recipebook.model.enums.RecipeTypeEnum;
import lombok.Data;

import javax.validation.constraints.*;


@Data
public class RecipeDto {

    private java.util.UUID uuid;

    @NotNull(message = "User identification cannot be null")
    @JsonProperty("uuid-user")
    @UUID()
    private java.util.UUID uuidUser;

    @NotNull(message = "Title cannot be null")
    @NotBlank(message ="Title cannot be blank")
    @Size(min=5, max=50, message = "Title must must be between {min} and {max}")
    private String title;

    @NotNull(message = "Preparation time cannot be null")
    @Min(value=5, message = "Preparation time cannot be less than {mmin}")
    @Max(value=600, message = "Preparation time cannot be less than {max}")
    @JsonProperty("prep-time")
    private Integer prepTime;

    @NotNull(message = "Cooking time cannot be null")
    @Min(value=5, message = "Cooking time cannot be less than {mmin}")
    @Max(value=600, message = "Cooking time cannot be less than {max}")
    @JsonProperty("cook-time")
    private Integer cookTime;

    @Min(value=1, message = "Serving cannot be less than 1")
    private Integer serving;

    @NotNull(message = "Instructions cannot be null")
    @NotBlank(message ="Instructions cannot be blank")
    private String instructions;

    @NotNull(message = "Ingredients cannot be null")
    @NotBlank(message ="Ingredients cannot be blank")
    private String ingredients;

    private String notes;

    @NotNull(message = "Occasion cannot be null")
    private OccasionEnum occasion;


    @NotNull(message = "Recipe Type cannot be null")
    @JsonProperty("recipe-type")
    private RecipeTypeEnum recipeType;

}
