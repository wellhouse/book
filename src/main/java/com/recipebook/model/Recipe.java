package com.recipebook.model;

import com.recipebook.model.enums.OccasionEnum;
import com.recipebook.model.enums.RecipeTypeEnum;
import lombok.Data;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.GenericField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;

import javax.persistence.*;
import java.util.UUID;
@Indexed
@Data
@Entity
@Table(name="Recipe")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "uuid", updatable = false, unique = true, nullable = false)
    private UUID uuid;

    @Column(nullable = false, name="uuid_user")
    private UUID uuidUser;

    @FullTextField()
    @Column(name = "title")
    private String title;

    @GenericField
    @Column(name = "prep_time")
    private Integer prepTime;

    @GenericField
    @Column(name = "cook_time")
    private Integer cookTime;

    @GenericField
    @Column(name = "serving")
    private Integer serving;

    @FullTextField()
    @Column(name = "instructions")
    private String instructions;

    @FullTextField()
    @Column(name = "ingredients")
    private String ingredients;

    @Column(name = "notes")
    private String notes;

    @Column(name = "occasion")
    @Enumerated(EnumType.STRING)
    @GenericField
    private OccasionEnum occasion;

    @GenericField
    @Column(name = "recipe_type")
    @Enumerated(EnumType.STRING)
    private RecipeTypeEnum recipeType;

}
