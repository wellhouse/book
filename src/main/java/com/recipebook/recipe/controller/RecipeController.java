package com.recipebook.recipe.controller;

import com.recipebook.model.Recipe;
import com.recipebook.model.enums.OccasionEnum;
import com.recipebook.model.enums.RecipeTypeEnum;
import com.recipebook.recipe.dto.RecipeDto;
import com.recipebook.recipe.dto.RecipeFilterDto;
import com.recipebook.recipe.service.RecipeService;
import com.recipebook.systemexceptions.ExceptionHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Slice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/book/recipe")
public class RecipeController {

    private static final Logger logger = LoggerFactory.getLogger(RecipeController.class);

    @Autowired
    private RecipeService recipeService;

    @GetMapping()
    public ResponseEntity<Slice<RecipeDto>> getIngredientsByOccasion(@RequestParam("occasion") OccasionEnum occasion) {

        Slice<RecipeDto> recipesDto = recipeService.getByOccasion(occasion);

        return ResponseEntity.ok().body(recipesDto);
    }

    @PostMapping
    public ResponseEntity<RecipeDto> addNewRecipe(@Valid @RequestBody RecipeDto recipeDto) {

        RecipeDto saved = recipeService.save(recipeDto);

        return ResponseEntity.ok(saved);
    }

    @GetMapping("/filter")
    public ResponseEntity<List<RecipeDto>> getByFilter(@RequestParam(value = "title", required = false) String title,
                                                        @RequestParam(value = "init-prep-time", required = false) Integer initPrepTime,
                                                        @RequestParam(value = "limit-prep-time", required = false) Integer limitPrepTime,
                                                        @RequestParam(value = "init-cook-time", required = false) Integer initCookTime,
                                                        @RequestParam(value = "limit-cook-time", required = false) Integer limitCookTime,
                                                        @RequestParam(value = "min-serving", required = false) Integer minServing,
                                                        @RequestParam(value = "max-serving", required = false) Integer maxServing,
                                                        @RequestParam(value = "instructions", required = false) String instructions,
                                                        @RequestParam(value = "with-ingredients", required = false) String withIngredients,
                                                        @RequestParam(value = "without-ingredient", required = false) String withoutIngredients,
                                                        @RequestParam(value = "occasion", required = false) OccasionEnum occasion,
                                                        @RequestParam(value = "recipe-type", required = false) RecipeTypeEnum recipeType,
                                                        @RequestParam(value = "offset", required = true) Integer offset,
                                                        @RequestParam(value = "limit", required = true) Integer limit) {

        RecipeFilterDto filter = new RecipeFilterDto();

        filter.setOffset(offset);
        filter.setLimit(limit);
        filter.setTitle(title);
        filter.setInitPrepTime(initPrepTime);
        filter.setLimitPrepTime(limitPrepTime);
        filter.setInitCookTime(initCookTime);
        filter.setLimitCookTime(limitCookTime);
        filter.setMinServing(minServing);
        filter.setMaxServing(maxServing);
        filter.setInstructions(instructions);
        filter.setWithIngredientes(withIngredients);
        filter.setWithoutIngredientes(withoutIngredients);
        filter.setOccasion(occasion);
        filter.setRecipeType(recipeType);

        List<RecipeDto> recipesDto = recipeService.getFilter(filter);

        return ResponseEntity.ok().body(recipesDto);
    }
}
