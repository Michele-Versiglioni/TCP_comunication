import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;


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

    public int connetti(String nomeServer, int portaServer) {
        try {
            this.socket = new Socket(nomeServer, portaServer);
            this.out = new PrintWriter(socket.getOutputStream(), true);
            this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void scrivi(String msg) {
        if (out != null) {
            out.println(msg);
        }
    }

    public void leggi() {
        try {
            if (in != null) {
                String msg = in.readLine();
                if (msg != null) {
                    System.out.println(msg);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void chiudi() {
        try {
            if (socket != null) socket.close();
        } catch (IOException e) {
            System.out.println("Errore chiusura");
        }
    }
}