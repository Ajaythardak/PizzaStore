package com.niit.pizzaDetails.service;

import com.niit.pizzaDetails.exception.PizzaNotFoundException;
import com.niit.pizzaDetails.exception.UserAlreadyExistsException;
import com.niit.pizzaDetails.exception.UserNotFoundException;
import com.niit.pizzaDetails.model.Pizza;
import com.niit.pizzaDetails.model.UserDetails;

import java.util.List;

public interface PizzaService {

    public UserDetails register(UserDetails user) throws UserAlreadyExistsException;
    public UserDetails placeOrder(Pizza pizza, int userId) throws UserNotFoundException;
    public UserDetails removePizza(int userId, int pizzaId) throws UserNotFoundException, PizzaNotFoundException;
    public List<Pizza> getOrderDetails(int userId) throws UserNotFoundException;


}

