import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Classe che rappresenta un server singolo (non parallelo).
 * Gestisce la comunicazione con un client alla volta.
 */
public class Server {

    private ServerSocket serverSocket; // Socket server
    private Socket socket; // Connessione con il client
    private int porta;
    private PrintWriter out;
    private BufferedReader in;

    /**
     * Costruttore del Server
     * @param porta numero di porta su cui aprire il server
     * @throws IOException in caso di errore nella creazione del server
     */
    public Server(int porta) throws IOException {
        this.porta = porta;
        serverSocket = new ServerSocket(porta);
        System.out.println("Server avviato su porta " + porta);
    }

    /**
     * Attende la connessione da parte di un client
     * @return socket collegata al client
     */
    public Socket attendi() {
        try {
            System.out.println("In attesa client...");
            socket = serverSocket.accept();
            System.out.println("Client connesso: " + socket);

            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        } catch (IOException e) {
            System.out.println("Errore accept: " + e.getMessage());
        }
        return socket;
    }

    /**
     * Legge un messaggio dal client
     * @return stringa ricevuta
     */
    public String leggi() {
        try {
            return in.readLine();
        } catch (IOException e) {
            System.out.println("Errore lettura");
            return null;
        }
    }

    /**
     * Invia un messaggio al client
     * @param msg messaggio da inviare
     */
    public void scrivi(String msg) {
        if (out != null) {
            out.println(msg);
        }
    }

    /**
     * Chiude la connessione con il client
     */
    public void chiudi() {
        try {
            if (socket != null) socket.close();
            System.out.println("Connessione client chiusa");
        } catch (IOException e) {
            System.out.println("Errore chiusura socket");
        }
    }

    /**
     * Termina il server e libera la porta
     */
    public void termina() {
        try {
            if (serverSocket != null) serverSocket.close();
            System.out.println("Server terminato");
        } catch (IOException e) {
            System.out.println("Errore chiusura server");
        }
    }
}
