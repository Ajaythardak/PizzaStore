package com.niit.pizzaDetails.controller;

import com.niit.pizzaDetails.exception.PizzaNotFoundException;
import com.niit.pizzaDetails.exception.UserAlreadyExistsException;
import com.niit.pizzaDetails.exception.UserNotFoundException;
import com.niit.pizzaDetails.model.Pizza;
import com.niit.pizzaDetails.model.UserDetails;
import com.niit.pizzaDetails.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v2")
public class PizzaController
{
    PizzaService service;
    private ResponseEntity<?> responseEntity;


    @Autowired
    public PizzaController(PizzaService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public ResponseEntity<?> addUser(@RequestBody UserDetails user) throws UserAlreadyExistsException {
        try {
            responseEntity =  new ResponseEntity<>(service.register(user), HttpStatus.CREATED);
        }
        catch(UserAlreadyExistsException e)
        {
            throw new UserAlreadyExistsException();
        }
        return responseEntity;
    }

    @PostMapping("/order/{userId}/pizza")
    public ResponseEntity<?> addPizzaToList(@RequestBody Pizza pizza, @PathVariable int userId) throws UserNotFoundException {
        try {
            responseEntity = new ResponseEntity<>(service.placeOrder(pizza, userId), HttpStatus.CREATED);
        }
        catch (UserNotFoundException e)
        {
            throw new UserNotFoundException();
        }
        return responseEntity;
    }

    @GetMapping("/order/{userId}/pizzas")
    public ResponseEntity<?> getAllPizzaOrdered(@PathVariable int userId) throws UserNotFoundException {
        try{
            responseEntity = new ResponseEntity<>(service.getOrderDetails(userId), HttpStatus.OK);
        }catch(UserNotFoundException e)
        {
            throw new UserNotFoundException();
        }
        return responseEntity;
    }

    @DeleteMapping("/order/{userId}/{pizzaId}")
    public ResponseEntity<?> deletePizzaFromList(@PathVariable int userId,@PathVariable int pizzaId)
            throws UserNotFoundException, PizzaNotFoundException
    {
        try {
            responseEntity = new ResponseEntity<>(service.removePizza(userId, pizzaId), HttpStatus.OK);
        } catch (UserNotFoundException | PizzaNotFoundException m) {
            throw new PizzaNotFoundException();
        }
        return responseEntity;
    }


}
