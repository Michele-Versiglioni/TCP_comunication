import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket serverSocket;
    private Socket socket;
    private int porta;
    private PrintWriter out;
    private BufferedReader in;

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
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            System.out.println("Errore accettazione client");
        }
        return socket;
    }
    public void scrivi(String msg){
        if(out != null){
            out.println(msg);
        }
    }
    public String leggi(){
        try {
            return in.readLine();
        } catch (IOException e) {
            return null;
        }
    }
    public void chiudi(){
        try {
            if(socket != null) socket.close();
        } catch (IOException e) {}
    }
    public void termina(){
        try {
            if(serverSocket != null) serverSocket.close();
            System.out.println("Server terminato");
        } catch (IOException e) {}
    }
}
