import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private ServerSocket serverSocket;
    private Socket socket;
    private int porta;
    private PrintWriter out;
    private BufferedReader in;

    //AVVIO SERVER
    public Server(int porta) throws IOException {
        this.porta = porta;
        serverSocket = new ServerSocket(porta);
        System.out.println("Server avviato su porta " + porta);
    }

    //CONNESSIONE CLIENT
    public Socket attendi() {
        try {
            System.out.println("In attesa client...");
            socket = serverSocket.accept();
            System.out.println("Client connesso: " + socket);

            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

        } catch (IOException e) {
            System.out.println("Errore accept: " + e.getMessage());
        }
        return socket;
    }

    //LETTURA RICHIESTA
    public String leggi() {
        try {
            return in.readLine();
        } catch (IOException e) {
            System.out.println("Errore lettura");
            return null;
        }
    }

    //INVIO RISPOSTA
    public void scrivi(String msg) {
        if (out != null) {
            out.println(msg);
        }
    }

    //CHIUSURA COMUNICAZIONE
    public void chiudi() {
        try {
            if (socket != null) socket.close();
            System.out.println("Connessione client chiusa");
        } catch (IOException e) {
            System.out.println("Errore chiusura socket");
        }
    }

    //CHIUSURA SERVER
    public void termina() {
        try {
            if (serverSocket != null) serverSocket.close();
            System.out.println("Server terminato");
        } catch (IOException e) {
            System.out.println("Errore chiusura server");
        }
    }
}
