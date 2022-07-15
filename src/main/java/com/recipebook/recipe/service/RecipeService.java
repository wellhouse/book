package com.recipebook.recipe.service;

import com.recipebook.model.enums.OccasionEnum;
import com.recipebook.recipe.dto.RecipeDto;
import com.recipebook.recipe.dto.RecipeFilterDto;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface RecipeService {

    public Slice<RecipeDto> getByOccasion(OccasionEnum occasion);

    public RecipeDto save(RecipeDto recipeDto);

    public List<RecipeDto> getFilter(RecipeFilterDto filter);
}
