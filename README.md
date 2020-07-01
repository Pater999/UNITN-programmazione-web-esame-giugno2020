## Programmazione web unitn - Soluzione esame giugno 2020

### Testo esame

Si richiede di realizzare una versione on-line del gioco Minesweeper (descritto nel
seguito). Si accede al gioco via web. Il gioco è individuale, ma il server web deve
essere in grado di gestire tanti utenti simultanei (ciascuno gioca da solo,
indipendentemente dagli altri).

<p align="center">
<img src="https://user-images.githubusercontent.com/39135429/86242710-695e3100-bba5-11ea-8d04-0ae482209f38.JPG">
</p>

1. **Operazioni lato WebServer**:
   A. _Inizio:_ Quando arriva un nuovo utente, gli viene offerta una videata iniziale che chiede il nome dell'utente (obbligatorio) e presenta un bottone “start” che è associato all'operazione “crea un nuovo gioco”
   <img src="https://user-images.githubusercontent.com/39135429/86242746-78dd7a00-bba5-11ea-9c5f-a45473c19c9e.JPG">
   B. _Crea nuovo gioco:_

   - definisce (server side) una matrice 9x9 di elementi. Chiameremo
     “cella” ciascuno di questi 81 elementi. La matrice viene definita nel
     seguente modo:
     1. a dieci celle scelte in modo random attribuisce il valore
        “bomba”.
     2. Per ognuna delle altre celle, conta quante celle bomba ci sono
        tra i suoi 8 vicini (2 in verticale, 2 in orizzontale, 4 in diagonale)
        – ovviamente le celle sul bordo hanno meno vicini – ed
        assume come proprio valore il risultato del conto.
        NOTA: in prima battuta può essere conveniente usare una matrice
        di prova predefinita e concentrarsi sul resto del compito, e solo
        successivamente generare dinamicamente la matrice corretta.
   - Manda al client la pagina mostrata all'inizio, comprendente:
     1. Un saluto che include il nome dell'utente
     2. una tabella composta da 9x9 elementi, ciascuno dei quali
        visualizza una cella senza però indicarne il valore (il valore
        delle celle inizialmente NON DEVE essere noto al client).
        Chiameremo questi elementi “CellaVisualizzata”.
     3. un bottone “Test” e due popup menu, in ciascuno dei quali
        scegliere un numero tra 1 e 9 (corrispondente a riga e colonna
        da testare).
     4. un bottone “Restart” che distrugge il gioco in corso e riporta
        l'utente alla videata iniziale.

   C. _“getValue” con parametri i e j_:
   Risponde ad una richiesta asincrona restituendo al client il valore della
   cella(i,j).

2) **Operazioni lato Client**:
   a. Il bottone Test richiama in modo asincrono getValue con i parametri
   selezionati, e mostra il valore ottenuto in un campo della pagina (senza
   ricaricarla)
   b. Un click su una delle CelleVisualizzate richiama in modo asincrono (senza
   ricaricare la pagina) getValue con i parametri i e j corrispondenti alla
   posizione dell'elemento nella matrice, e mostra entro la CellaVisualizzata
   selezionata il valore (ottenuto dal server). Inoltre se il valore è “bomba”,
   viene mostrato un pop-up che dice “hai perso” e mostra un bottone
   “Restart” che crea una nuova partita (senza passare per la pagina iniziale di
   richiesta del nome all'utente, che viene mantenuto).

3. **Uso di CSS**:
   si provveda ad usare i CSS per modificare la CellaVisualizzata, cambiandone l’aspetto
   a seconda che il suo valore sia ignoto, bomba o numerico.

_Nota: il gioco terminerebbe con la vittoria quando tutti gli elementi “non bomba” sono stati
scoperti, ma l’implementazione di questo requisito non è richiesta._

### Alcuni screenshot della mia soluzione

##### Pagina iniziale

<table><td><img src="https://user-images.githubusercontent.com/39135429/86242764-7ed35b00-bba5-11ea-8b70-083f033b7b24.JPG"></td></table>

##### In gioco

<table><td><img src="https://user-images.githubusercontent.com/39135429/86242802-898df000-bba5-11ea-9269-4f28073c9597.JPG"></td></table>

<table><td><img src="https://user-images.githubusercontent.com/39135429/86242819-8f83d100-bba5-11ea-8b4e-5e3bdcb29de4.JPG"></td></table>

##### Partita persa

<table><td><img src="https://user-images.githubusercontent.com/39135429/86242831-96124880-bba5-11ea-91bd-201cd6ea818f.JPG"></td></table>

### Zip con il progetto

Potete scaricare lo zip con il progetto di Netbeans a [QUESTO LINK](https://github.com/Pater999/UNITN-programmazione-web-esame-giugno2020/releases).
