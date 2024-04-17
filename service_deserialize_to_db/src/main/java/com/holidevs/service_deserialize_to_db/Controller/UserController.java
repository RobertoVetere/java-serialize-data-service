package com.holidevs.service_deserialize_to_db.Controller;
import com.holidevs.service_deserialize_to_db.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserService userService;

    //@CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/save-user")
    @ResponseStatus(HttpStatus.CREATED)
    public void addNewBank(@RequestBody byte[] user) {
        userService.saveUserToDb(user);
    }
}
