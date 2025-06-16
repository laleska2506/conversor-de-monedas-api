import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import io.github.cdimascio.dotenv.Dotenv;

public class Conexion {
    public void realizarConexion(float monedaInicial, float monedaCambio, float montoACambiar) throws Exception {
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
            System.out.println(json);
        } catch (IOException | InterruptedException e) {
           System.out.println(e.getMessage());
        }

    }
}



