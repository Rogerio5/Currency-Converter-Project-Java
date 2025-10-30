package com.rogerio.conversor;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * Classe responsável por realizar chamadas à ExchangeRate-API
 * para buscar taxas de conversão entre moedas.
 */
public class ApiClient {

    // Substitua pela sua chave da ExchangeRate-API
    private static final String API_KEY = "741f083a6ef5cec0aab47740";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/pair/";

    private final HttpClient client;

    public ApiClient() {
        // Cria uma instância única de HttpClient (thread-safe)
        this.client = HttpClient.newHttpClient();
    }

    /**
     * Faz a requisição à API para buscar a taxa de conversão entre duas moedas.
     *
     * @param moedaOrigem Código da moeda de origem (ex: "USD")
     * @param moedaDestino Código da moeda de destino (ex: "BRL")
     * @return JSON em formato String com a resposta da API, ou null em caso de erro
     */
    public String buscarTaxa(String moedaOrigem, String moedaDestino) {
        try {
            String url = BASE_URL + moedaOrigem + "/" + moedaDestino;

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                System.out.println("✅ Requisição bem-sucedida!");
                System.out.println("Resposta da API: " + response.body());
                return response.body();
            } else {
                System.err.println("⚠️ Erro na requisição. Código HTTP: " + response.statusCode());
                return null;
            }

        } catch (Exception e) {
            System.err.println("❌ Erro ao buscar taxa de câmbio: " + e.getMessage());
            return null;
        }
    }
}

