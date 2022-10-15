package com.niit.user.service;

import com.niit.user.domain.User;
import com.niit.user.exception.InvalidCredentialsException;
import com.niit.user.exception.UserAlreadyExistsException;
import com.niit.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public User saveUser(User user) throws UserAlreadyExistsException {
        return userRepository.save(user);
    }

    @Override
    public User findByUserEmailAndPassword(String userEmail, String password) throws InvalidCredentialsException {
        User user =  userRepository.findByUserEmailAndPassword(userEmail , password);
        if(user == null){
            throw new InvalidCredentialsException();
        }
        return user;
    }

    @Override
    public List<User> getUsers() {
        List<User> allUsers= userRepository.findAll();
        return allUsers;

    }

}
