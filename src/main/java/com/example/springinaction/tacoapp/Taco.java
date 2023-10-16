package com.example.springinaction.tacoapp;

import jakarta.validation.constraints.*;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;
import java.util.List;
@Table
@Data
public class Taco {
    @Id
    private long id;
    private Date createdAt = new Date();
    @NotNull
    @Size(min=5, message = "Name must be at least 5 characters long")
    private String name;

    @NotNull
    @Size(min=1, message = "You must choose at least 1 ingredient")
    private List<IngredientRef> ingredients;
}
