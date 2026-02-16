import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    private String nome;
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;

    public Client(String nome) {
        this.nome = nome;
    }
    //AVVIO CLIENT E CONNESSIONE AL SERVER
    public int connetti(String nomeServer, int portaServer) {
        try {
            socket = new Socket(nomeServer, portaServer);

            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

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
    //INVIO RICHIESTA AL SERVER
    public void scrivi(String msg) {
        if (out != null) {
            out.println(msg);
        }
    }
    //LETTURA RISPOSTA DAL SERVER
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
    //CHIUSURA CLIENT
    public void chiudi() {
        try {
            if (socket != null) socket.close();
            System.out.println("Client chiuso");
        } catch (IOException e) {
            System.out.println("Errore chiusura client");
        }
    }
}
