package com.niit.user.controller;

import com.niit.user.domain.User;
import com.niit.user.exception.InvalidCredentialsException;
import com.niit.user.exception.UserAlreadyExistsException;
import com.niit.user.security.SecurityTokenGenerator;
import com.niit.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin("*")
@RequestMapping("/api/v1")
public class UserController {

    private ResponseEntity responseEntity;
    private UserService userService;
    private SecurityTokenGenerator securityTokenGenerator;


    @Autowired
    public UserController(UserService userService,SecurityTokenGenerator securityTokenGenerator )
    {
        this.userService = userService;
        this.securityTokenGenerator = securityTokenGenerator;
    }


    @PostMapping("/register")
    public ResponseEntity<?> saveUser(@RequestBody User user) throws UserAlreadyExistsException {
        return new ResponseEntity<>(userService.saveUser(user),HttpStatus.CREATED);
//        User createdUser = userService.saveUser(user);
//        return responseEntity = new ResponseEntity("User is Created successfully." , HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User user) throws InvalidCredentialsException
    {
        User retrievedUser = userService.findByUserEmailAndPassword(user.getUserEmail(),user.getPassword());
        if(retrievedUser==null)
        {
            throw new InvalidCredentialsException();
        }
        Map<String,String> map = securityTokenGenerator.generateToken(user);
        return new ResponseEntity<>(map,HttpStatus.OK);
    }

    @GetMapping("users")
    public ResponseEntity<?> getAllUsers()
    {
        return new ResponseEntity<>(userService.getUsers(),HttpStatus.OK);
    }

}
