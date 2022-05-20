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

        // Mostramos el cuerpo de la respuesta
        System.out.println(response.body());
    }
}