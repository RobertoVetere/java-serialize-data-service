package com.holidevs.service_serialize_data.Controller;
import com.holidevs.service_serialize_data.Entity.User;
import com.holidevs.service_serialize_data.Service.ExternalCallService;
import com.holidevs.service_serialize_data.Service.SerializerService;
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

    @Autowired
    SerializerService serializerService;

    @Autowired
    ExternalCallService externalCallService;

    @PostMapping("/validate")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        if (user.getName() == null || user.getDNI() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Se requiere nombre y DNI");
        }
        try {
            externalCallService.sendSerializedUserToDb
                    (serializerService.serializeUser
                            (userService.createUserWithValidDNI(user)));
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Usuario creado exitosamente");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("DNI inválido");
        }
    }

}
