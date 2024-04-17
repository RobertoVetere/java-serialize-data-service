package com.holidevs.service_serialize_data.Service;
import com.holidevs.service_serialize_data.Entity.User;
import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class SerializerService {

    public byte[] serializeUser(User user) {
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
             ObjectOutputStream out = new ObjectOutputStream(bos)) {
            // Serializar el objeto usuario
            out.writeObject(user);
            out.flush();
            return bos.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException("Error al serializar el usuario a bytes", e);
        }
    }
}
