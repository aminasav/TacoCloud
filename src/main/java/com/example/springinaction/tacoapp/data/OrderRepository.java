package com.example.springinaction.tacoapp.data;

import com.example.springinaction.tacoapp.TacoOrder;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<TacoOrder,Long> {
}
