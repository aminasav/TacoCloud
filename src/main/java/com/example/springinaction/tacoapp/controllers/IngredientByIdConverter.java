package com.example.springinaction.tacoapp.controllers;

import java.util.HashMap;
import java.util.Map;

import com.example.springinaction.tacoapp.Ingredient.*;
import com.example.springinaction.tacoapp.Ingredient;
import com.example.springinaction.tacoapp.data.IngredientRepository;
import org.springframework.core.convert.converter.Converter; import org.springframework.stereotype.Component;

@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {
    private final IngredientRepository ingRepo;

    public IngredientByIdConverter(IngredientRepository ingRepo) {
        this.ingRepo = ingRepo;
    }

    @Override
    public Ingredient convert(String id) {
        return ingRepo.findById(id).orElse(null); }
}
