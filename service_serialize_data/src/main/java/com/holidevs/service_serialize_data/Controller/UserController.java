package com.holidevs.service_serialize_data.Controller;

import com.holidevs.service_serialize_data.Entity.User;
import com.holidevs.service_serialize_data.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/validate")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public User createUser(@RequestBody User user) {
        return userService.createUserWithValidDNI(user);
    }
}
