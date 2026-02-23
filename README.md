# Esercitazione C/S TCP Java

# Descrizione
Questo progetto implementa una comunicazione TCP tra un client e un server in Java.
Il client può inviare più richieste al server e leggere le risposte.
Il server riceve le richieste, le elabora e risponde.
E' stato implementato un protocollo semplice testuale dove il client invia messaggi e può chiudere la comunicazione scrivendo EXIT.

Il progetto è organizzato in due rami:
- Il ramo tcp-sequenziale contiene la versione del server che gestisce un client alla volta.
- Il ramo parallelo contiene la versione del server multi-thread che gestisce più client contemporaneamente tramite le classi GestoreClient e MainServerParallelo.

# Utilizzo

Versione tcp-sequenziale
Si avvia MainServer.
Poi si avvia MainClient.
Il server gestisce un solo client alla volta.
Può gestire più client nel tempo, ma non contemporaneamente.
Deve terminare la comunicazione con un client prima di accettarne un altro.

Versione parallelo
Si avvia MainServerParallelo.
Si possono avviare più MainClient.
Ogni client viene gestito da un thread separato.
Il server può comunicare contemporaneamente con più client.

# Scenari implementati

# Scenario 1: avvio server poi client
Il server viene avviato prima e rimane in ascolto.
Il client si connette al server, invia messaggi e riceve le risposte correttamente.
Quando il client scrive EXIT la connessione si chiude.
Nel tcp-sequenziale il server rimane in attesa di un nuovo client.
Nel parallelo può continuare a gestire altri client attivi.

# Scenario 2: avvio client poi server
Se il client viene avviato prima del server, stampa "Server non disponibile" e termina.
Quando poi si avvia il server, i client possono connettersi normalmente.

# Scenario 3: avvio di un secondo server sulla stessa porta
Se si prova ad avviare un secondo server sulla stessa porta, stampa "Porta occupata" e termina.

# Scenario 4: host errato
Se nel client si scrive un nome host sbagliato tipo "locaost", stampa "Host non trovato" e termina.

# Scenario 5: più richieste dal client
Il client può inviare più messaggi senza chiudere la connessione.
Il server elabora ogni messaggio e risponde correttamente.

# Scenario 6: chiusura con comando EXIT
Se il client scrive EXIT, il server risponde con "CIAO" e il client chiude la connessione.

# Differenza tra tcp-sequenziale e parallelo
Nel tcp-sequenziale il server gestisce un client alla volta.
Nel parallelo il server crea un thread per ogni client e può gestire più client contemporaneamente.

# Protocollo
Client invia: messaggio di testo
Server risponde: "RICEVUTO: <messaggio>"
Client scrive EXIT → server risponde "CIAO" -> chiusura connessione
