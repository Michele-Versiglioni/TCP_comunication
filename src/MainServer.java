import java.io.IOException;
import java.net.BindException;
import java.net.Socket;

public class MainServer {
    public static void main(String[] args)  {
       int porta = 3241;
       try{
           Server server = new Server(porta);
           System.out.println("Il server è in ascolto");
           Socket socket = server.attendi();
           System.out.println("Il server è connesso al client");
           String richiesta = server.leggi();
           System.out.println("Richiesta ricevuta: " + richiesta);
           server.scrivi("Risposta del server ricevuta ");
           server.chiudi();
           System.out.println("Connessione chiusa");
           server.termina();

       }
       catch (BindException e) {
           System.out.println("la porta è occupata");
       }
        catch (IOException e)  {
           System.out.println("Errore di avvio server");
           e.printStackTrace();
           System.exit(1);
       }
    }
}
