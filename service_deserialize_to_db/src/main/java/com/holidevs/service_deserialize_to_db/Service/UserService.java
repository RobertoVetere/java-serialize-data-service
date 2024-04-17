package com.holidevs.service_deserialize_to_db.Service;

import com.holidevs.service_deserialize_to_db.Entity.User;
import com.holidevs.service_deserialize_to_db.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    DeserializerService deserializerService;

    @Autowired
    UserRepository userRepository;
    public void saveUserToDb(byte[] user) {
        User newUser = deserializerService.deserializeUser(user);
        userRepository.save(newUser);
    }
}
