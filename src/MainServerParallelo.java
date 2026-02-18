import java.net.ServerSocket;
import java.net.Socket;
public class MainServerParallelo {
    public static void main(String[] args) {
        try {
            //CREAZIONE SERVER SOCKET
            ServerSocket serverSocket = new ServerSocket (3241);
            System.out.println("SERVER PARALLELO AVVIATO SU PORTA 3241");

            while(true) {
                //ACCETTARE NUOVO CLIENT
                Socket socket = serverSocket.accept();
                System.out.println("NUOVO CLIENT CONNESSO: " + socket);
                //CREAZIONE THREAD PER GESTIRE IL CLIENT
                GestoreClient gc = new GestoreClient(socket);
                gc.start(); //PARTE IL THREAD
            }

        } catch (Exception e ) {
            System.out.println("ERRORE SERVER PARALLELO: " + e.getMessage());
        }
    }
}
