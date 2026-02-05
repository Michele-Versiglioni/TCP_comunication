import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket serverSocket;
    private Socket socket;
    private int porta;

    public ServerSocket getServerSocket() {
        return serverSocket;
    }

    public Server setServerSocket(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
        return this;
    }

    public Socket getClientSocket() {
        return socket;
    }

    public Server setClientSocket(Socket clientSocket) {
        this.socket = clientSocket;
        return this;
    }

    public int getPorta() {
        return porta;
    }

    public Server (int porta) throws IOException {
        this.porta = porta;
        serverSocket = new ServerSocket(porta);
    }

    public Socket attendi(){
        try {
            socket = serverSocket.accept();
        } catch (IOException e) {
            //server non riesce ad instaurare la connessione
        }
        return socket;
    }
    public void scrivi(){

    }
    public void leggi(){

    }
    public void chiudi(){

    }
    public void termina(){

    }
}
