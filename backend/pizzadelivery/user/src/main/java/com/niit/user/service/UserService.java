package com.niit.user.service;

import com.niit.user.domain.User;
import com.niit.user.exception.InvalidCredentialsException;
import com.niit.user.exception.UserAlreadyExistsException;

import java.util.List;

public interface UserService {
    public User saveUser(User user) throws UserAlreadyExistsException;
    public User findByUserEmailAndPassword(String userEmail , String password) throws InvalidCredentialsException;
    public List<User> getUsers();
}
