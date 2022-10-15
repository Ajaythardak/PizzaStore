package com.niit.pizzaDetails.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.NOT_FOUND, reason = "Pizza Id you typed is Not Found")
public class PizzaNotFoundException extends Exception{


}
