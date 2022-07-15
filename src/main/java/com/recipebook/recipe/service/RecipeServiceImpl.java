package com.recipebook.recipe.service;

import com.recipebook.exceptions.business.BusinessException;
import com.recipebook.exceptions.business.ResourceNotFoundException;
import com.recipebook.model.Recipe;
import com.recipebook.model.enums.OccasionEnum;
import com.recipebook.recipe.controller.RecipeController;
import com.recipebook.recipe.dto.RecipeDto;
import com.recipebook.recipe.dto.RecipeFilterDto;
import com.recipebook.recipe.repository.RecipeRepository;
import com.recipebook.user.dto.UserDto;
import org.hibernate.search.engine.search.query.SearchResult;
import org.hibernate.search.mapper.orm.Search;
import org.hibernate.search.mapper.orm.session.SearchSession;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class RecipeServiceImpl implements RecipeService {

    private static final Logger logger = LoggerFactory.getLogger(RecipeServiceImpl.class);

    @Autowired
    private RecipeRepository recipeRepository;

    @PersistenceContext
    private EntityManager entityManager;

    private ModelMapper modelMapper = new ModelMapper();

    public RecipeDto save(RecipeDto recipeDto) {

        Recipe recipe = new Recipe();

        modelMapper.map(recipeDto, recipe);

        Recipe saved = recipeRepository.save(recipe);

        recipeDto.setUuid(saved.getUuid());

        return recipeDto;
    }

    public RecipeDto update(RecipeDto recipeDto)throws ResourceNotFoundException, BusinessException {

        Recipe recipe = recipeRepository.findById(recipeDto.getUuid()).orElseThrow(() -> new ResourceNotFoundException("Recipe not found !"));

        modelMapper.map(recipeDto, recipe);

        recipeRepository.save(recipe);

        return recipeDto;
    }

    public void delete(UUID uuid) throws ResourceNotFoundException, BusinessException {

        Recipe recipe = recipeRepository.findById(uuid).orElseThrow(() -> new ResourceNotFoundException("Internal error trying to delete resource: " + uuid));

        recipeRepository.delete(recipe);
    }



    public Slice<RecipeDto> getByOccasion(OccasionEnum occasion) {

        Recipe recipeExample = new Recipe();
        recipeExample.setOccasion(occasion);

        Slice<Recipe> recipeSlice = recipeRepository.findByOccasionOrderByTitle(occasion, Pageable.ofSize(10));

        Slice<RecipeDto> dtoSlice = recipeSlice.map(entity -> {
            RecipeDto userDto = modelMapper.map(entity, RecipeDto.class);
            return userDto;
        });

        return dtoSlice;
    }

    public List<RecipeDto> getFilter(RecipeFilterDto filter) {

        SearchSession searchSession = Search.session(entityManager);

        List<Recipe> hits = searchSession.search(Recipe.class)
                .where( f -> f.bool( b -> {

                    if (Objects.nonNull(filter.getTitle())) {
                        b.must(f.match().field("title").matching(filter.getTitle()).fuzzy(1));
                    }

                    if (Objects.nonNull(filter.getInitPrepTime()) && Objects.nonNull(filter.getLimitPrepTime())) {
                        b.must(f.range().field( "prepTime" )
                                .between(filter.getInitPrepTime(), filter.getLimitPrepTime()));
                    }

                    if (Objects.nonNull(filter.getInitCookTime()) && Objects.nonNull(filter.getLimitCookTime())) {
                        b.must(f.range().field( "cookTime" )
                                .between(filter.getInitCookTime(), filter.getLimitCookTime()));
                    }

                    if (Objects.nonNull(filter.getMinServing()) && Objects.nonNull(filter.getMaxServing())) {
                        b.must(f.range().field( "serving" )
                                .between(filter.getMinServing(), filter.getMaxServing()));
                    }

                    if (Objects.nonNull(filter.getInstructions())) {
                        b.must(f.match().field("instructions").matching(filter.getInstructions()).fuzzy(1));
                    }

                    if (Objects.nonNull(filter.getWithoutIngredientes())) {
                        b.mustNot(f.match().field("ingredients").matching(filter.getWithoutIngredientes()).fuzzy(1));
                    }

                    if (Objects.nonNull(filter.getWithIngredientes())) {
                        b.must(f.match().field("ingredients").matching(filter.getWithIngredientes()).fuzzy(1));
                    }

                    if (Objects.nonNull(filter.getOccasion())) {
                        b.must(f.match().field("occasion").matching(filter.getOccasion()));
                    }

                    if (Objects.nonNull(filter.getRecipeType())) {
                        b.must(f.match().field("recipeType").matching(filter.getRecipeType()));
                    }
                }))
                .fetchHits(filter.getOffset(), filter.getLimit());

        List<RecipeDto> recipeListDto = hits.stream().map(entity -> {
            RecipeDto recipeDto = modelMapper.map(entity, RecipeDto.class);
            return recipeDto;
        }).collect(Collectors.toList());

        return recipeListDto;
    }
}
