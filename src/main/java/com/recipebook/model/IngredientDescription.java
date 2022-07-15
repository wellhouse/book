//package com.recipebook.model;
//
//import lombok.Data;
//
//import javax.persistence.*;
//import java.io.Serializable;
//import java.util.UUID;
//
//@Data
//@Entity
//@Table(name="INGREDIENT_DESCRIPTION")
//public class IngredientDescription implements Serializable {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "uuid", updatable = false, unique = true, nullable = false)
//    private UUID uuid;
//
//    @Column(nullable = false, name="uuid_user")
//    private UUID uuidUser;
//
//    @Column(nullable = false)
//    private String name;
//
//    @Column(name = "ingredient_type")
//    private String ingredient_type;
//
//    @Column(name = "measure")
//    private String measure;
//
//    @Column(name = "amount")
//    private String amount;
//
//}
