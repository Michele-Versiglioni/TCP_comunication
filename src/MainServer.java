import java.io.IOException;
import java.net.BindException;

public class MainServer {

    public static void main(String[] args) {

        try {
            Server server = new Server(3241);

            // MULTI CLIENT NON CONTEMPORANEO
            while (true) {

                server.attendi();

                while (true) {

                    String richiesta = server.leggi();
                    if (richiesta == null) break;

                    System.out.println("Ricevuto: " + richiesta);

                    if (richiesta.equalsIgnoreCase("EXIT")) {
                        server.scrivi("CIAO");
                        break;
                    }

                    server.scrivi("RICEVUTO: " + richiesta.toUpperCase());
                }

                server.chiudi();
            }

        } catch (BindException e) {
            System.out.println("Porta occupata");

        } catch (IOException e) {
            System.out.println("Errore avvio server");
        }
    }
}
