import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    private String nome;
    private String colore;
    private Socket socket;

    private PrintWriter out;
    private BufferedReader in;


    public Client() {
        this.nome = nome;
    }

    public Client(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public Client setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getColore() {
        return colore;
    }

    public Client setColore(String colore) {
        this.colore = colore;
        return this;
    }

    public Socket getSocket() {
        return socket;
    }

    public Client setSocket(Socket socket) {
        this.socket = socket;
        return this;
    }

    public int connetti(String nomeServer, int portaServer){
        try {
            socket = new Socket(nomeServer, portaServer);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("Connesso al server");
            return 0;
        } catch (IOException e) {
            System.out.println("Errore di connessione: " + e.getMessage());
            return -1;
        }
    }
    public void scrivi(String msg){
        if(out != null){
            out.println(msg);
        }
    }
    public void leggi(){
        try {
            String risposta = in.readLine();
            System.out.println("Risposta server: " + risposta);
        } catch (IOException e) {
            System.out.println("Errore lettura");
        }
    }
    public void chiudi() {
        try {
            if (socket != null) socket.close();
            System.out.println("Client chiuso");
        } catch (IOException e) {
            System.out.println("Errore chiusura");
        }
    }
}
