import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class MainApplication {

    public static void main(String[] args) {
        try {
            // Création du serveur HTTP sur le port 8000
            HttpServer server = HttpServer.create(new InetSocketAddress(8002), 0);

            // Définition du contexte et du gestionnaire pour "/test"
            server.createContext("/optimisation", new CustomHandler());

            // Démarrage du serveur
            server.start();

            System.out.println("Serveur HTTP démarré sur le port 8002.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

