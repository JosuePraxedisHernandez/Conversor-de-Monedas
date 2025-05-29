package com.mycompany.convertirdemonedas;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;

public class consultarMoneda {
    
    public Moneda buscarMoneda(String from, String to) {
        URI direccion = URI
                .create("https://v6.exchangerate-api.com/v6/886d0f69c3ba2442b6ff1dda/pair/" + from + "/" + to);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() != 200) {
                System.out.println("Error: No se pudo obtener la información de la API. Código de estado: "
                        + response.statusCode());
                return null;
            }
            return new Gson().fromJson(response.body(), Moneda.class);
        } catch (Exception e) {
            System.out.println("Error al comunicarse con la API: " + e.getMessage());
            return null;
        }
    }
}
