# Esercitazione C/S TCP Java

# Descrizione
Questo progetto implementa una comunicazione TCP tra un client e un server in Java.
Il client può inviare più richieste al server e leggere le risposte.
Il server riceve le richieste, le elabora e risponde.
E' stato implementato un protocollo semplice testuale dove il client invia messaggi e può chiudere la comunicazione scrivendo EXIT.

# Scenari implementati

# Scenario 1: avvio server poi client
Il server viene avviato prima e rimane in ascolto.
Il client si connette al server, invia messaggi e riceve le risposte correttamente.
Quando il client scrive EXIT la connessione si chiude e il server rimane in ascolto per nuovi client.

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

# Multi-client non contemporaneo
Il server può gestire più client uno alla volta in sequenza.
E' necessario che il client chiuda la connessione prima che il server accetti un nuovo client.

# Protocollo
Client invia: messaggio di testo
Server risponde: "RICEVUTO: <messaggio>"
Client scrive EXIT → server risponde "CIAO" -> chiusura connessione
