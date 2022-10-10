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

I oppgave 1 så gikk vi frem ved å sette antallet til 0. Deretter laget vi en Node current som ble satt til hode.
Dette var for å begynne fra venstre og telle hvor lang den linkede listen var. Den gikk gjennom alle nodene som 
var forskjellig fra null og plusset 1 på antallet for hver gang den gikk inn i while-løkka. Når den gikk inn i lista
flyttet vi current-pekeren fra current til current sin neste. I boolean tom setter vi hode til current og returnerer 
false hvis current ikke er null. Ellers returnes true. I konstruktøren har vi gjort at hvis a.length er 
større enn 0 går den inn i if setningen. Deretter itereres det gjennom Arrayet og lager hode noden. 
Har en for-løkke fordi det kan være null-verdier i starten. Setter hode lik hale. Deretter sjekker jeg om hale ikke er lik null. 
Da går den inn i for løkken og lager ny noder som hale.neste og flytter halepekeren til hale.neste. 

I oppgave 2 så brukte vi en ... til å ...

I oppgave 6 så laget jeg boolean fjern(T verdi). Her måtte jeg først inistiere en current Node og en prev node for å ha
lagret forrige peker. Når current er forskjellig fra null går inn i while løkke. Hvis verdi er lik verdi går den inn. 
Sjekker deretter om den er lik hode, for da flyttes bare hode.neste til hode og prev er fremdeles null. Hvis ikke 
flyttes current til current.neste og prev.neste er current sin forrige etter at current har flyttet seg. 

Gjern med indeks. Der setter vi current til hode og inistierer T verdi. Har if tester som sjekker ulike scenarioer.
Bruker en for løkke for å traversere gjennom listen til riktig indeks. Pekerne flyttes bort fra noden slik at den
fjernes. Etter at vi har funnet riktig indeks lagres 
verdi lik current.verdi og returneres. Pekerne er flyttet så noden forsvinner. 
