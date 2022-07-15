package com.recipebook.recipe.controller;

import com.recipebook.model.enums.OccasionEnum;
import com.recipebook.model.enums.RecipeTypeEnum;
import com.recipebook.recipe.dto.RecipeDto;
import com.recipebook.recipe.dto.RecipeFilterDto;
import com.recipebook.recipe.service.RecipeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Slice;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/book/recipe")
public class RecipeController {

    private static final Logger logger = LoggerFactory.getLogger(RecipeController.class);

    @Autowired
    private RecipeService recipeService;

    @ApiOperation(value = "Get a product by id", notes = "Returns a product as per the id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved"),
            @ApiResponse(code = 404, message = "Not found - The product was not found")
    })
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

    @PutMapping("/{id}")
    public ResponseEntity<RecipeDto> updateRecipe(@PathVariable(required = true) UUID id, @Valid @RequestBody RecipeDto recipeDto) {
        recipeDto.setUuid(id);
        RecipeDto saved = recipeService.update(recipeDto);
        return ResponseEntity.ok(saved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UUID> deleteRecipe(@PathVariable(value = "id") UUID id) {
        recipeService.delete(id);
        return ResponseEntity.ok().body(id);
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
