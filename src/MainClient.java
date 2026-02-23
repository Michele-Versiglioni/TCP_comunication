import java.util.Scanner;

/**
 * Programma principale del client.
 * Gestisce l'invio e la ricezione di messaggi da console.
 */
public class MainClient {

    public static void main(String[] args) {
        Client client = new Client("Michele");

        int esito = client.connetti("localhost", 3241);
        if (esito != 0) return;

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Inserisci messaggio (EXIT per chiudere): ");
            String msg = sc.nextLine();

            // Invio messaggio al server
            client.scrivi(msg);

            // Se l'utente vuole uscire, interrompe il ciclo
            if (msg.equalsIgnoreCase("EXIT")) {
                break;
            }

            // Attende risposta dal server
            String risposta = client.leggi();
            System.out.println("Server -> " + risposta);
        }

        client.chiudi();
    }
}




