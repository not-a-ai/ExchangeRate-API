package io.alexiacgc.exchangeapi;

import com.google.gson.Gson;
import io.github.cdimascio.dotenv.Dotenv;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class Moeda {
    private Map<String, Double> conversion_rates;

    public Moeda buscaMoeda(String pais) {
        Dotenv dotenv = Dotenv.load();
        String apiKey = dotenv.get("API_KEY");

        URI endereco = URI.create("https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" + pais);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(endereco)
                .build();
        try {
            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
            Gson gson = new Gson();
            var jsonObject = gson.fromJson(response.body(), com.google.gson.JsonObject.class);

            var conversionRatesJson = jsonObject.getAsJsonObject("conversion_rates");

            Map<String, Double> rates = gson.fromJson(conversionRatesJson, Map.class);

            this.conversion_rates = rates;
            return this;
        } catch (Exception e) {
            throw new RuntimeException("Não consegui obter o endereço apartir desse pais");
        }
    }

    public double converterMoeda(double valor, double taxaDeConversao) {
//        System.out.println("valor e taxa de conversão: " + valor + taxaDeConversao);
       return valor*taxaDeConversao;
    };

    public double buscarTaxa(String pais) {
//        System.out.println(this.conversion_rates.get(pais));
        return this.conversion_rates.get(pais);
    };
}
