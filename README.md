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

I oppgave 2 så brukte vi en ... til å ...

I oppgave 3

I oppgave 4:
Her så har jeg begynt med å lage en hjelpevariablen kalt "peker" som iterer seg gjennom beholderen vår fra og med hodet, 
og videre gjennom hvert element i beholderen ved hjelp av en for løkke. Etterhvert som "peker" variablen inkrementerer seg gjennom beholderen,
så bruker jeg .equals-metoden for å sammenligne den noden "peker" variablen har (midlertidig) landet på i itereringen, med noden som har blitt innpassert i metoden, 
og returnerer hhv. indeksplassen til noden som er "gjennfunnet" i sammenligningen, eller -1 hvis noden som er innpassert i medoden ikke kan gjennfinnes. 

I oppgave 5
 
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

I oppgave 7

I oppgave 8


I oppgave 9
Her så har jeg begynt med å kode 2 tester i begynnelsen av metoden for å prøve å fange opp noen uønskede brukstilfeller av metoden. 
Deretter så har jeg forsøkt å ta stilling til hvert punkt metoden søker å løse i flere if og else if setninger, der første if
tar stilling til en beholder med 1 elemnt i seg(der koden nuller ut hode- og hale-pekerene), og de påfølgende 3 ifsetningene tar stilling til 
tilfellene hvor noden som skal fjernes hhv. er først, sist eller i midten av beholderen, der hode eller halepekerene blir oppdatert (og deres forrige og neste blir null) ved de første to tilfelene.
Og at omkringliggende noder blir omdirigert til å peke til nye steder i beholderen for å "peke vekk" fra område "rundt" der noden som skal fjernes ligger. 


I oppgave 10



