package com.niit.pizzaDetails.service;

import com.niit.pizzaDetails.exception.PizzaNotFoundException;
import com.niit.pizzaDetails.exception.UserAlreadyExistsException;
import com.niit.pizzaDetails.exception.UserNotFoundException;
import com.niit.pizzaDetails.model.Pizza;
import com.niit.pizzaDetails.model.UserDetails;
import com.niit.pizzaDetails.proxy.userProxy;
import com.niit.pizzaDetails.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class PizzaServiceImpl implements PizzaService
{

    PizzaRepository pizzaRepository;

    @Autowired
    public PizzaServiceImpl(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }
    @Autowired
    private userProxy userProxy;

    @Override
    public UserDetails register(UserDetails user) throws UserAlreadyExistsException {
        if(pizzaRepository.findById(user.getUserId()).isPresent())
        {
            throw new UserAlreadyExistsException();
        }
        UserDetails res= pizzaRepository.save(user);
        ResponseEntity<?> response=userProxy.saveUser(user); // request for other
        System.out.println("\n response : "+response);
        return res;
    }

    @Override
    public UserDetails placeOrder(Pizza pizza, int userId) throws UserNotFoundException {
        if(pizzaRepository.findById(userId).isEmpty())
        {
            throw new UserNotFoundException();
        }
        UserDetails user = pizzaRepository.findById(userId).get();
        if(user.getPizzaList() == null)
        {
            user.setPizzaList(Arrays.asList(pizza));
        }
        else {
            List<Pizza> pizzas = user.getPizzaList();
            pizzas.add(pizza);
            user.setPizzaList(pizzas);
        }
        return pizzaRepository.save(user);
    }

    @Override
    public UserDetails removePizza(int userId, int pizzaId) throws UserNotFoundException, PizzaNotFoundException {
        boolean pizzaIdIsPresent = false;
        if(pizzaRepository.findById(userId).isEmpty())
        {
            throw new UserNotFoundException();
        }
        UserDetails user = pizzaRepository.findById(userId).get();
        List<Pizza> pizzas = user.getPizzaList();
        pizzaIdIsPresent = pizzas.removeIf(x->x.getPizzaId()==pizzaId);
        if(!pizzaIdIsPresent)
        {
            throw new PizzaNotFoundException();
        }
        user.setPizzaList(pizzas);
        return pizzaRepository.save(user);
    }

    @Override
    public List<Pizza> getOrderDetails(int userId) throws UserNotFoundException {
        if(pizzaRepository.findById(userId).isEmpty())
        {
            throw new UserNotFoundException();
        }
        return pizzaRepository.findById(userId).get().getPizzaList();
    }

}
