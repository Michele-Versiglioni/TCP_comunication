public class MainClient {

    public static void main(String[] args){

        Client client = new Client("Michele");

        int esito = client.connetti("localhost", 3241);

        if(esito == 0){
            client.scrivi("Richiesta dal client");
            client.leggi();
            client.chiudi();
        } else {
            System.out.println("Server non disponibile");
        }
    }
}
