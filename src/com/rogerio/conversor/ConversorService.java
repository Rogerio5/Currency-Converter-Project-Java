package com.rogerio.conversor;

import com.google.gson.Gson;
import com.rogerio.conversor.models.ExchangeResponse;

public class ConversorService {

    private final ApiClient apiClient = new ApiClient();
    private final Gson gson = new Gson();

    /**
     * Método principal que recebe a opção escolhida no menu e o valor a converter.
     */
    public void converter(int opcao, double valor) {
        String moedaOrigem = "";
        String moedaDestino = "";

        switch (opcao) {
            case 1 -> { moedaOrigem = "USD"; moedaDestino = "BRL"; }
            case 2 -> { moedaOrigem = "BRL"; moedaDestino = "USD"; }
            case 3 -> { moedaOrigem = "USD"; moedaDestino = "EUR"; }
            case 4 -> { moedaOrigem = "EUR"; moedaDestino = "USD"; }
            case 5 -> { moedaOrigem = "USD"; moedaDestino = "ARS"; }
            case 6 -> { moedaOrigem = "ARS"; moedaDestino = "USD"; }
            case 7 -> { moedaOrigem = "USD"; moedaDestino = "CLP"; }
            case 8 -> { moedaOrigem = "CLP"; moedaDestino = "USD"; }
            case 9 -> { moedaOrigem = "USD"; moedaDestino = "COP"; }
            case 10 -> { moedaOrigem = "COP"; moedaDestino = "USD"; }
            default -> {
                System.out.println("⚠️ Opção inválida.");
                return;
            }
        }

        realizarConversao(moedaOrigem, moedaDestino, valor);
    }

    /**
     * Método que consulta a API, obtém a taxa e calcula o valor convertido.
     */
    private void realizarConversao(String moedaOrigem, String moedaDestino, double valor) {
        String respostaJson = apiClient.buscarTaxa(moedaOrigem, moedaDestino);

        if (respostaJson != null) {
            ExchangeResponse exchange = gson.fromJson(respostaJson, ExchangeResponse.class);
            double taxa = exchange.getConversion_rate();
            double convertido = calcular(valor, taxa);

            System.out.printf("💱 Resultado: %.2f %s = %.2f %s%n",
                    valor, moedaOrigem, convertido, moedaDestino);
        } else {
            System.out.println("❌ Não foi possível obter a taxa de câmbio.");
        }
    }

    /**
     * Método utilitário para calcular a conversão.
     */
    public double calcular(double valor, double taxa) {
        return valor * taxa;
    }
}


