package api;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.github.cdimascio.dotenv.Dotenv;
import modelos.Moneda;
import modelos.MonedaRecord;

public class Conexion {
    private Gson gson = new Gson();

    public Conexion(){
        gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
    }


    public Moneda obtenerCambio(String monedaInicial, String monedaCambio, double montoACambiar) throws IOException, InterruptedException{
        Dotenv dotenv = Dotenv.load();
        String apiKey = dotenv.get("apiKey");

        String direccion = "https://v6.exchangerate-api.com/v6/"
                + apiKey + "/pair/" + monedaInicial + "/" + monedaCambio + "/" + montoACambiar;

        try {
            HttpClient cliente = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(direccion))
                    .build();

            HttpResponse<String> response = cliente
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();

            MonedaRecord modeloRecord = gson.fromJson(json, MonedaRecord.class);
            return new Moneda(modeloRecord);

        } catch (IOException | InterruptedException e) {
            System.out.println(e.getMessage());
            return null;
        }

    }
}



