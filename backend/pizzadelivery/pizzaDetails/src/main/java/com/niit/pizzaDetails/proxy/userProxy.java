package com.niit.pizzaDetails.proxy;

import com.niit.pizzaDetails.model.UserDetails;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "user",url="localhost:8085")
public interface userProxy {
    @PostMapping("api/v1/register")
    public ResponseEntity<?> saveUser(@RequestBody UserDetails user);
}
