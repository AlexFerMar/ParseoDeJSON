import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Test {
    public static void main(String args[]) throws URISyntaxException, IOException, InterruptedException {

        // creamos la petición
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://jsonplaceholder.typicode.com/todos/1"))
                .GET()
                .build();

        // creamos el cliente
        HttpClient client = HttpClient.newHttpClient();

        // Enviamos la petición y obtenemos la respuesta
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        switch (response.statusCode()) {

            case 200 -> {
                // Mostramos el cuerpo de la respuesta
                System.out.println(response.body());
            }
            case 404 -> {
                System.out.println("Error 404: No se lo que buscas, pero no esta aqui.");
            }
            case 403 -> {
                System.out.println("Error 403: No estas autorizado para ver esto.");
            }
            default -> {
                System.out.println("Error de caracter desconocido");
            }

        }
    }
}