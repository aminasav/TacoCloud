package com.example.springinaction.tacoapp.data;

import com.example.springinaction.tacoapp.TacoOrder;

public interface OrderRepository {
    TacoOrder save(TacoOrder order);

}
