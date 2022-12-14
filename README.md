# Obligatorisk oppgave 2 i Algoritmer og Datastrukturer

Denne oppgaven er en innlevering i Algoritmer og Datastrukturer. 
Oppgaven er levert av følgende studenter:

-Christoffer Rusek Leegaard, S362069, s362069@oslomet.no

-Nabil Hassen, s336115, s336115@oslomet.no

-Haris Maroof, s362062, s362062@oslomet.no

-Ingrid Lunde, s338231, s338231@oslomet.no

-Magnus Høistad, s362051, s362051@oslomet.no


# Arbeidsfordeling

Chrsitoffer har hatt hovedansvar for oppgave 5 og 10.

Nebil har tatt hovedansvar for oppgave 4 og 9.

Ingrid har tatt hovedansvar for oppgave 1 og 6.

Haris har tatt hovedansvar for oppgave 3 og 8.

Magnus har tatt hovedansvar for oppgave 2 og 7.

# Oppgavebeskrivelse

I oppgave 1 så gikk vi frem ved å sette antallet til 0. Deretter laget jeg en Node current som ble satt til hode.
Dette var for å begynne fra venstre og telle hvor lang den linkede listen var. Den gikk gjennom alle nodene som 
var forskjellig fra null og plusset 1 på antallet for hver gang den gikk inn i while-løkka. Når den gikk inn i lista
flyttet jeg current-pekeren fra current til current sin neste. 

I oppgave 2:
a) Metoden toString() begynner med å deklarere en node "n" = hode og en StringBuilder "ut". Om n er null vil metoden returnere "[]".
Om ikke vil den legge til n.verdi i "ut" og bruke en while-løkke til å legge til alle verdier av n i "ut". Løkken stopper når n.neste == null.
For metoden omvendtString() fungerer på samme måte som toString(), bortsett fra at noden n = hale, og at den jobber seg bakover fra siste node.
Løkken vil stoppe når n.forrige == null.
b) Metoden leggInn(T verdi) begynner med en sjekk av at verdi ikke er null. Deretter sjekkes om listen er tom. Om den er tom så legges en ny node med verdi inn i listen, og hode- og halepekerne peker mot denne. Til slutt økes variabelen endringer og antall og true returneres.
Om listen ikke er tom legges ny node med verdi inn etter hale. Deretter settes halepekeren til å peke mot ny node. Endringer og antall økes og true returneres.

I oppgave 3:
a)
Her starter jeg med å lage en metoden finnNode hvor den skal returnerer noden med den gitte indeksen.
Den starter med å finne ut med en if setning om indeksen er mindre ennn antall/2 og vis den er. 
Dermed starte fra hode og gå mot høyre. hvis ikke else  starter letingen fra halen og går mot venstre.
Begge scenarioene går videre til å bruke while løkke for å ta i bruk neste/forrige pekere avhengig om hvor den starter fra.
Til den er på noden tilsvarende indeksen. While løkke brukes siden løkken kjøres ukjent mange ganger.
Deretter lager metoden T hent(int indeks) hvor jeg foretar indekskontroll. og vis det ikke gis feilmeldinger går den videre
til hente noden til indeksen med finnNode metoden og deretter returnere verdien til noden.
b)
Deretter lager metoden subliste som først skjekker om det er lovlige argumenter i input.
Deretter henter hoden. Deretter med en forløkke flytter noden til fra indeksen med neste pekere her for løkke siden vi vet hvor mange løkken skal kjøres.
Deretter oppretter liste av T[] der nodene lagres.
og til slutt skriver ut verdiene til nodene med forløkke  inn i en ny subliste som returneres.

I oppgave 4:
Her så har jeg begynt med å lage en hjelpevariablen kalt "peker" som iterer seg gjennom beholderen vår fra og med hodet, 
og videre gjennom hvert element i beholderen ved hjelp av en for løkke. Etterhvert som "peker" variablen inkrementerer seg gjennom beholderen,
så bruker jeg .equals-metoden for å sammenligne den noden "peker" variablen har (midlertidig) landet på i itereringen, med noden som har blitt innpassert i metoden, 
og returnerer hhv. indeksplassen til noden som er "gjennfunnet" i sammenligningen, eller -1 hvis noden som er innpassert i medoden ikke kan gjennfinnes. 

I oppgave 5
er det laget en metode som legger verdier inn i listen. den starter med å lage en ny node i plass hode hvis listen er tom.
eller hvis indeks er 0 lager den en ny node til høyre for hode, men hvis hode ikke er null, lager den en ny node til venstre.
metoden tar vare på endringer i antall og endringer, som er helt avgjørende for at ikke oppg 8 skal kjøre i evighjeter.

 
I oppgave 6
Laget jeg boolean fjern(T verdi). Her inistierer jeg en tempverdi som jeg bruker når jeg sjekker om et tall er i listen. 
Bruker ulike if-setninger for å sjekke de ulike scenarioene for når temp er lik verdien. Flytter pekerne alt ettersom det er 
hode, hale eller midt i pekere. Returnerer true hvis jeg fant verdi og fjernet. Returnerer false hvis ikke. i Fjern(indeks) setter jeg
tempverdi til hode. Deretter sjekker jeg om ulike scenarioer om indeks er 0 eller ikke. Bruker en for-løkke for å finne riktig indeks. 
Flytter pekerene alt etter om det er hode, hale eller midt i som fjernes. Sjekker om det er en tom liste etter fjerning. 
Returnerer tilslutt verdien som fjernes. 

Her måtte jeg først inistiere en temp Node for å ha
lagret forrige peker. Når indeks er lik null er det hode som skal fjernes og sjekker om det er en tom liste etter det.
Hvisår jeg inn i for løkken for å finne riktig indeks. Lagrer tallet som skal fjernes i tempvariabel. 
Sjekker deretter om verdien som skal fjernes er halepekeren. temp er forskjellig fra null går inn i while løkke. Hvis verdi er lik verdi går den inn.
Sjekker deretter om den er lik hode, for da flyttes bare hode.neste til hode og prev er fremdeles null. Hvis ikke
flyttes current til current.neste og prev.neste er current sin forrige etter at current har flyttet seg.

Gjern med indeks. Der setter vi current til hode og inistierer T verdi. Har if tester som sjekker ulike scenarioer.
Bruker en for løkke for å traversere gjennom listen til riktig indeks. Pekerne flyttes bort fra noden slik at den
fjernes. Etter at vi har funnet riktig indeks lagres
verdi lik current.verdi og returneres. Pekerne er flyttet så noden forsvinner.

I oppgave 7:
Her synes jeg det var lettest å gjøre det på 1. måte, ved å starte i hode og gå mot hale. Først settes hode til null, deretter bruker jeg en while-løkke til å gå gjennom listen og nulle ut hver verdi. Løkka stopper når n.neste == null. Til slutt settes hale-pekeren til null, "antall" nullstilles og "endringer" økes.
2. måte brukte jeg litt tid på å finne ut av, men fant til slutt ut en måte som var veldig enkel. I starten hadde jeg problem med at antall ble mindre og mindre for hver iterasjon, siden fjern(i) også trekker fra antall. Derfor gikk jeg for en for-løkke der int i = 0 hele tiden, dermed fjerner den første node for hver iterasjon, samtidig som antall også blir mindre for hver iterasjon.
Til slutt tok jeg 10 målinger av hver metode og fikk gjennomsnittet:
1. måte: 0,002183 ms
2. måte: 0,007333 ms
Dette viser at til tross for at 2. måte var en mye enklere kode var den mye treigere enn 1. måte.

I oppgave 8:
a)
lager metoden T next() og med en enkel if test som sammenligner iteratorendringer og endringer og skriver ut en feilmelding
Deretter med en if setning vis det ikke er flere igjen skrive ut en annen feilmelding.
Derettter settes fjernOK til true som oppaven ber om og returnerer verdien til denne og flyttes til neste node
b)
metoden returnerer en instans av iteratorklassen
c)
Samme konstruktør som den ferdig koden bare setter denne til Noden tilsvarende indeksen.
d)
lager til slutt metoden Iterator<T> iterator(int indeks) skjekker først om det er lovlig indeks med indekskontroll og deretter returnerer en instans av iteratorklassen.


I oppgave 9
Her så har jeg begynt med å kode 2 tester i begynnelsen av metoden for å prøve å fange opp noen uønskede brukstilfeller av metoden. 
Deretter så har jeg forsøkt å ta stilling til hvert punkt metoden søker å løse i flere if og else if setninger, der første if
tar stilling til en beholder med 1 elemnt i seg(der koden nuller ut hode- og hale-pekerene), og de påfølgende 3 ifsetningene tar stilling til 
tilfellene hvor noden som skal fjernes hhv. er først, sist eller i midten av beholderen, der hode eller halepekerene blir oppdatert (og deres forrige og neste blir null) ved de første to tilfelene.
Og at omkringliggende noder blir omdirigert til å peke til nye steder i beholderen for å "peke vekk" fra område "rundt" der noden som skal fjernes ligger. 


I oppgave 10
 Her gjør vi en innstikksmetode med comparator og liste.oppdater. Det er gjort på en måte som minner mye om hvoirdan man ville behandlet verdier i en vanlig liste.
 Starter med å si at hvis listen er tom eller bare har èn verdi, så skal den avslutte.
 Kjører igjennom så lenge liste er mindre en antall og bytter om plass på de verdiene til listen er lik "naturalOrder".
 Siden mange av metodene jeg ville brukt i denne oppgaven er satt til privat, eller tuller med endringer i iteratoren, er dette den beste måten jeg kom frem til. 
 Jeg har prøvd mye forskjellig, men dette er det hjeg fikk til å fungere.

Litteraturliste

Delete a Doubly Linked List node at a given position. (2017, juli 6). GeeksforGeeks. 
https://www.geeksforgeeks.org/delete-doubly-linked-list-node-given-position/

Delete a node in a Doubly Linked List. (2010, mai 8). GeeksforGeeks. 
https://www.geeksforgeeks.org/delete-a-node-in-a-doubly-linked-list/

Delete Node with a Given Key. (u.å.). Educative: Interactive Courses for Software Developers. 
Hentet 9. oktober 2022, fra https://www.educative.io/m/delete-node-with-given-key

Doubly Linked Lists in Java: Creation & Nodes. (u.å.). Study.Com. 
Hentet 9. oktober 2022, fra https://study.com/academy/lesson/doubly-linked-lists-in-java-creation-nodes.html

Program to find size of Doubly Linked List. (2018, april 20). GeeksforGeeks. 
https://www.geeksforgeeks.org/program-find-size-doubly-linked-list/

Uttersrud, U. (2021). Delkapittel 3.3  –  En lenket liste   –. 
https://www.cs.hioa.no/~ulfu/appolonius/kap3/3/kap33.html#3.3.3

Implementing a Linked List in Java using Class. (2022, september 01). GeeksforGeeks.
https://www.geeksforgeeks.org/implementing-a-linked-list-in-java-using-class/

Write a function to get Nth node in a Linked List. (2022, august 01). GeeksforGeeks.
https://www.geeksforgeeks.org/write-a-function-to-get-nth-node-in-a-linked-list/




