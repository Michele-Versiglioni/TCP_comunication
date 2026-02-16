import java.util.Scanner;

public class MainClient {

    public static void main(String[] args) {

        Client client = new Client("Michele");

        int esito = client.connetti("localhost", 3241);
        if (esito != 0) return;

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.print("Inserisci messaggio (EXIT per chiudere): ");
            String msg = sc.nextLine();

            client.scrivi(msg);

            if (msg.equalsIgnoreCase("EXIT")) {
                break;
            }

            String risposta = client.leggi();
            System.out.println("Server -> " + risposta);
        }

        client.chiudi();
    }
}



