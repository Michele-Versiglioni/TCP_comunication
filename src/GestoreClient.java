import java.io.*;
import java.net.Socket;

/**
 * Thread che gestisce un singolo client in parallelo.
 * Si occupa di ricevere e inviare messaggi al client.
 */
public class GestoreClient extends Thread {

    /** Socket associata al client */
    private Socket socket;

    /**
     * Costruttore del thread gestore
     * @param socket connessione con il client
     */
    public GestoreClient(Socket socket) {
        this.socket = socket;
    }

    /**
     * Esecuzione del thread: mantiene la comunicazione con il client
     */
    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            System.out.println("CLIENT GESTITO IN PARALLELO: " + socket);

            while (true) {
                String richiesta = in.readLine();
                if (richiesta == null) break;

                System.out.println("RICEVUTO: " + richiesta);

                if (richiesta.equalsIgnoreCase("EXIT")) {
                    out.println("CIAO");
                    break;
                }

                out.println("RICEVUTO: " + richiesta.toUpperCase());
            }

            socket.close();
            System.out.println("CLIENT CHIUSO: " + socket);

        } catch (IOException e) {
            System.out.println("ERRORE THREAD CLIENT: " + e.getMessage());
        }
    }
}

