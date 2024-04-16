package com.holidevs.service_serialize_data.Service;

import org.springframework.stereotype.Service;

@Service
public class UserService {


    // Método para validar un DNI español
    public boolean validarDNI(String dni) {
        // Verificar si la longitud es correcta (debería ser 9, 8 dígitos + 1 letra)
        if (dni.length() != 9) {
            return false;
        }

        // Obtener el número (los primeros 8 caracteres)
        String numeroStr = dni.substring(0, 8);

        // Verificar si el número es un número válido
        try {
            int numero = Integer.parseInt(numeroStr);
        } catch (NumberFormatException e) {
            // Si ocurre una excepción, significa que no es un número válido
            return false;
        }

        // Obtener la letra
        char letra = dni.charAt(8);

        // Calcular la letra esperada
        char letraEsperada = calcularLetra(numeroStr);

        // Verificar si la letra coincide
        return letra == letraEsperada;
    }

    // Método para calcular la letra de un DNI español
    private char calcularLetra(String numeroStr) {
        // Array de letras posibles
        char[] letras = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};

        // Calcular el índice basado en el número (módulo 23)
        int indice = Integer.parseInt(numeroStr) % 23;

        // Devolver la letra correspondiente al índice calculado
        return letras[indice];
    }
}
