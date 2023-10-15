package com.example.springinaction.tacoapp.data;

import com.example.springinaction.tacoapp.Ingredient;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class JdbcIngredientRepository implements IngredientRepository{

    private final JdbcTemplate jdbcTemplate;

    public JdbcIngredientRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Iterable<Ingredient> findAll() {
        String sql = "SELECT id,name,type from Ingredient";
        return jdbcTemplate.query(sql, this::mapRowToIngredient);
    }

    @Override
    public Optional<Ingredient> findById(String id) {
        String sql = "SELECT id,name,type from Ingredient WHERE id=?";
        List<Ingredient> result = jdbcTemplate.query(sql, this::mapRowToIngredient,id);
        return result.isEmpty() ? Optional.empty() : Optional.of(result.get(0));
    }

    @Override
    public Ingredient save(Ingredient ingredient) {
        String sql = "INSERT INTO Ingredient(id,name,type) VALUES(?,?,?)";
        jdbcTemplate.update(sql,
                ingredient.getId(),
                ingredient.getName(),
                ingredient.getType());
        return ingredient;
    }
    private Ingredient mapRowToIngredient(ResultSet row, int numRow) throws SQLException {
        return new Ingredient(
                row.getString("id"),
                row.getString("name"),
                Ingredient.Type.valueOf(row.getString("type")));
    }
}
