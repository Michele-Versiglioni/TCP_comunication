import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Classe che rappresenta il Client.
 * Si connette al Server e permette di inviare e ricevere messaggi.
 */
public class Client {

    /** Nome del client */
    private String nome;

    /** Socket per la connessione al server */
    private Socket socket;

    /** Stream di output per inviare messaggi al server */
    private PrintWriter out;

    /** Stream di input per ricevere messaggi dal server */
    private BufferedReader in;

    /**
     * Costruttore del client
     * @param nome nome dell'utente
     */
    public Client(String nome) {
        this.nome = nome;
    }

    /**
     * Connessione al server
     * @param nomeServer indirizzo del server
     * @param portaServer porta su cui il server è in ascolto
     * @return 0 se la connessione è riuscita, -1/-2 in caso di errore
     */
    public int connetti(String nomeServer, int portaServer) {
        try {
            socket = new Socket(nomeServer, portaServer);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            System.out.println("Client connesso al server");
            return 0;

        } catch (UnknownHostException e) {
            System.out.println("Host non trovato");
            return -1;

        } catch (IOException e) {
            System.out.println("Server non disponibile");
            return -2;
        }
    }

    /**
     * Invio di un messaggio al server
     * @param msg messaggio da inviare
     */
    public void scrivi(String msg) {
        if (out != null) {
            out.println(msg);
        }
    }

    /**
     * Lettura della risposta inviata dal server
     * @return messaggio ricevuto dal server
     */
    public String leggi() {
        try {
            if (in != null) {
                return in.readLine();
            }
        } catch (IOException e) {
            System.out.println("Errore lettura risposta");
        }
        return null;
    }

    /**
     * Chiusura della connessione con il server
     */
    public void chiudi() {
        try {
            if (socket != null) socket.close();
            System.out.println("Client chiuso");
        } catch (IOException e) {
            System.out.println("Errore chiusura client");
        }
    }
}

