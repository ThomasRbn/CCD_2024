import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class CustomHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        try {
            if ("POST".equals(exchange.getRequestMethod())) {
                // Lecture du fichier CSV envoyé dans la requête POST
                InputStream requestBody = exchange.getRequestBody();
                BufferedReader reader = new BufferedReader(new InputStreamReader(requestBody));
                StringBuilder csvContent = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    csvContent.append(line).append("\n");
                }

                // Envoi de la réponse au client HTTP
                exchange.sendResponseHeaders(200, 0);
                OutputStream os = exchange.getResponseBody();
                os.close();

                // Appel de la fonction qui utilise le contenu du fichier CSV
                processCSV(csvContent.toString());
            } else {
                // Si ce n'est pas une requête POST, renvoyer une réponse 405 (Méthode non autorisée)
                exchange.sendResponseHeaders(405, -1);
            }
        } catch (Exception e) {
            // Gérer les exceptions selon les besoins
            exchange.sendResponseHeaders(500, -1);
            e.printStackTrace();
        }
    }

    private void processCSV(String csvContent) throws IOException {
        // Ici, vous pouvez traiter le contenu du fichier CSV comme vous le souhaitez
        // Vous pouvez par exemple effectuer une requête HTTP vers une autre API
        // Utilisez la classe HttpURLConnection pour cela

        String apiUrl = "https://localhost:8000/api/java/retour";
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        try {
            String csvCalcul = CSVWritter.write(csvContent);
            System.out.println(csvCalcul);
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "text/csv");

            // Envoyer le contenu du fichier CSV à l'API externe
            try (OutputStream os = connection.getOutputStream()) {
                os.write(csvCalcul.getBytes()); // Utiliser csvCalcul au lieu de csvContent
            }

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Lecture de la réponse de l'API externe
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                // Faites quelque chose avec la réponse si nécessaire
                System.out.println("Réponse de l'API : " + response.toString());
            } else {
                // Gérer les erreurs de réponse si nécessaire
                System.out.println("Erreur de réponse de l'API : " + responseCode);
            }
        } finally {
            connection.disconnect();
        }
    }

}
