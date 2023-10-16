package com.example.springinaction.tacoapp;

import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Table
@Data
public class TacoOrder {
    @Id
    private long id;
    private Date placedAt;

    @NotBlank(message = "Delivery name is required")
    public String deliveryName;
    @NotBlank(message = "Delivery street is required")
    public String deliveryStreet;
    @NotBlank(message = "Delivery city is required")
    public String deliveryCity;
    @NotBlank(message = "State  is required")
    public String deliveryState;
    @NotBlank(message = "Zip is required")
    public String deliveryZip;
    @CreditCardNumber(message = "Not a valid credit card number")
    public String ccNumber;
    @Pattern(regexp="^(0[1-9]|1[0-2])([\\ /])([2-9][0-9])$",
            message="Must be formatted MM/YY")
    public String ccExpiration;
    @Digits(integer =3, fraction = 0, message = "Invalid CVV")
    public String ccCVV;

    private List<Taco> tacos = new ArrayList<>();
    public void addTaco(Taco taco){
        this.tacos.add(taco);
    }
}
