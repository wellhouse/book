package com.recipebook.recipe.repository;

import com.recipebook.model.Recipe;
import com.recipebook.model.enums.OccasionEnum;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, UUID >, JpaSpecificationExecutor<Recipe> {

    public Slice<Recipe> findByOccasionOrderByTitle(@Param("occasion") OccasionEnum occasion, Pageable page);
}
