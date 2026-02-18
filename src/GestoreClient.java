import java.io.*;
import java.net.Socket;
public class GestoreClient extends Thread {
    private Socket socket;

    public GestoreClient(Socket socket) {
        this.socket = socket;
    }

    public void run(){
        try {
            //CREAZIONE STREAM LETTURA E SCRITTURA
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            System.out.println("CLIENT GESTITO IN PARALLELO: " + socket);

            //CICLO PER SCAMBIARE MESSAGGI CON IL CLIENT
            while (true) {
                String richiesta = in.readLine(); //LETTURA MESSAGGIO CLIENT
                if (richiesta == null) break; //CLIENT DISCONNESSO
                System.out.println("RICEVUTO: " + richiesta);
                if (richiesta.equalsIgnoreCase("EXIT")){ //SE IL CLIENT CHIUDE
                    out.println("CIAO");
                    break;
                }
                //INVIO RISPOSTA AL CLIENT
                out.println("RICEVUTO: " + richiesta.toUpperCase());
            }
            socket.close(); //CHIUSURA SOCKET CLIENT
            System.out.println("CLIENT CHIUSO: " + socket);
        } catch (IOException e) {
            System.out.println("ERRORE THREAD CLIENT: " + e.getMessage());
        }
    }
}
