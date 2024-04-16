package com.holidevs.service_serialize_data.Controller;
import com.holidevs.service_serialize_data.Entity.User;
import com.holidevs.service_serialize_data.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/validate")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        if (user.getName() == null || user.getDNI() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Se requiere nombre y DNI");
        }
        try {
            userService.createUserWithValidDNI(user);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Usuario creado exitosamente");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("DNI inválido");
        }
    }
}
