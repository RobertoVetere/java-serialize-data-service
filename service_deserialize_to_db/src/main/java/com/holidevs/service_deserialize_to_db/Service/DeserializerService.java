package com.holidevs.service_deserialize_to_db.Service;
import com.holidevs.service_deserialize_to_db.Entity.User;
import org.springframework.stereotype.Service;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

@Service
public class DeserializerService {

    public void deserializeUser(byte[] serializedUser) {
        try (ByteArrayInputStream bis = new ByteArrayInputStream(serializedUser);
             ObjectInputStream in = new ObjectInputStream(bis)) {
            User user = (User) in.readObject();
            // Hacer algo con el objeto deserializado
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException("Error al deserializar el usuario", e);
        }
    }
}
