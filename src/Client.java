import java.net.Socket;

public class Client {
    private String nome;
    private String colore;
    private Socket socket;

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

        return portaServer;
    }
    public void scrivi(){

    }
    public void leggi(){

    }
    public void chiudi(){

    }
}
