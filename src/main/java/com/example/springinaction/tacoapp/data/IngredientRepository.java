package com.example.springinaction.tacoapp.data;

import com.example.springinaction.tacoapp.Ingredient;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IngredientRepository
        extends CrudRepository<Ingredient,String>{
}
