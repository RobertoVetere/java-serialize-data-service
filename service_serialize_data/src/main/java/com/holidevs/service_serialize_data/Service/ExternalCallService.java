package com.holidevs.service_serialize_data.Service;

import org.springframework.stereotype.Service;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

@Service
public class ExternalCallService {
    public void sendSerializedUserToDb(byte[] serializedUser) {
        // Crear una instancia de RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        // URL del servicio que va a deserializar el objeto
        String url = "http://localhost:8081/user/save-user";

        // Configurar los encabezados de la solicitud
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);

        try {
            // Realizar la llamada al servicio externo
            restTemplate.postForEntity(url, new HttpEntity<>(serializedUser, headers), Void.class);

            // Si no hay excepciones lanzadas, asumimos que la llamada fue exitosa
            System.out.println("Los bytes serializados se enviaron correctamente al servicio de base de datos.");
        } catch (Exception e) {
            // Manejar la excepción
            System.out.println("Hubo un problema al enviar los bytes serializados al servicio de base de datos: " + e.getMessage());
        }
    }
}
