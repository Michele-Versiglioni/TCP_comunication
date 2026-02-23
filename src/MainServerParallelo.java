import java.net.ServerSocket;
import java.net.Socket;

/**
 * Server principale che accetta più client contemporaneamente.
 */
public class MainServerParallelo {
    public static void main(String[] args) {
        try {
            // Creazione del server socket
            ServerSocket serverSocket = new ServerSocket(3241);
            System.out.println("SERVER PARALLELO AVVIATO SU PORTA 3241");

            // Ciclo infinito per gestire più client
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("NUOVO CLIENT CONNESSO: " + socket);

                // Avvio di un thread per ogni client
                GestoreClient gc = new GestoreClient(socket);
                gc.start();
            }

        } catch (Exception e) {
            System.out.println("ERRORE SERVER PARALLELO: " + e.getMessage());
        }
    }
}

