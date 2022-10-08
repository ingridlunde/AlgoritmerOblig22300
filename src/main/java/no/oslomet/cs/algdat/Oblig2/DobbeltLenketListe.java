package no.oslomet.cs.algdat.Oblig2;


////////////////// class DobbeltLenketListe //////////////////////////////


import java.util.Comparator;
import java.util.Iterator;


public class DobbeltLenketListe<T> implements Liste<T> {

    public static void main (String [] args) {
        String[] s = {"Ole", null, "Per", "Kari", null};
        Liste<String> liste1 = new DobbeltLenketListe<>(s);
        System.out.println(liste1.antall() + " " + liste1.tom());  
    }
    /**
     * Node class
     *
     * @param <T>
     */
    private static final class Node<T> {
        private T verdi;                   // nodens verdi
        private Node<T> forrige, neste;    // pekere

        private Node(T verdi, Node<T> forrige, Node<T> neste) {
            this.verdi = verdi;
            this.forrige = forrige;
            this.neste = neste;
        }

        private Node(T verdi) {
            this(verdi, null, null);
        }
    }

    // instansvariabler
    private Node<T> hode;          // peker til den første i listen
    private Node<T> hale;          // peker til den siste i listen
    private int antall;            // antall noder i listen
    private int endringer;         // antall endringer i listen

    public DobbeltLenketListe() {
        hode = null;
        hale = null;
        antall = 0;
        endringer = 0; 
    }

    public DobbeltLenketListe(T[] a) {
        //Lager en if setning som kaster en nullpointexception hvis listen er tom
        if (a == null) {
            throw new NullPointerException("Tabell a er null!");
        }

        //Lager en if setning for å plassere hode peker. Viktig å passe på at elementene i starten av array kan
        //være null. Må derfor traversere gjennon med en for-løkke.
        if (a.length > 0) {
            for (int i = 0; i < a.length; i++) {
                if(a[i] != null) {
                    hode = new Node (a[i]);
                    antall ++;
                    break;
                }

                //Setter nodene hale til hode. Hvis det ikke er flere noder vil ikke den gå inn i flere og returnerer
                //en med antall 1, Der både hode og hale peker på samme; 
        /*if (a.length == 1 && a[0] != null) {
            hale = hode;
            break; */
                //Setter hale og hode til å bli lik. Hvis den ikke går inn i mer nå. Returneres 1 og
                // hale og hode peker på samme.
                hale = hode; 

                //Traverserer deretter gjennom resten av arrayet og går bare inn i if-setningen når hale ikke er null.
                if (hale != null) {
                    // Legger til i for å komme på indeks 1 i arrayet.
                    i ++;
                    //Looper gjennom resten av arrayet for å legge det i listen
                    for (; i < a.length; i++) {
                     //Sjekker hvert element for om det er null
                        if (a[i] != null) {
                            //inistierer konstruktøren med å legge inn ny verdi på hale sin neste.
                            //Har satt hale til å være lik hode til å begynne med.
                            //verdi, deretter hale som var forrige og neste er fremdeles null.
                            hale.neste = new Node <> (a[i], hale, null);

                            //FLytter pekeren fra hale til hale sin neste før antalle økes og for løkka looper på nytt
                            hale = hale.neste;
                            antall ++;
                        }

                    }


                }
            }
            
        }

    }

    public Liste<T> subliste(int fra, int til) {
        //skjekker om fra og til er lovlige argumenter og er innenfor listen sin lengde ved fratilKontroll metoden
        //fratilKontroll(antall, fra,til);

        //Henter hode og legger det inn i en objekt av Node<T>
        Node<T> noden = hode;

        //Bruker for løkke siden her vet vi hvor mange ganger løkken skal kjøres
        //flytter hoden til noden til noden med fra indeks
        for (int i = 0; i < fra; i++){
            noden = noden.neste;
        }

        //Oppretter liste av T node class som skal holde node verdiene
        T[] sublisteInn = (T[]) new Object[til-fra];

        int indeks = 0;

        //fyller sublisteInn med verdier [fra-til> noder ved bruk av for løkke
        //etter det oppdaterer noden til neste node for å legge inn, øker også indeks for å bruke til å hente neste node
        for (int i = fra; i < til; i++){
            sublisteInn[indeks] = noden.verdi;
            noden = noden.neste;
            indeks++;
        }

        //oppretter sublisten og fyller den for å returnere
        DobbeltLenketListe<T> subliste = new DobbeltLenketListe<>(sublisteInn);

        return subliste;
    }

    @Override
    public int antall() {
        //Setter antall til 0;
        //antall = 0;

        //Lager en current Nodevariabel
        Node current = hode;
        //Legger inn en if hvis listen har null -- sender nullexception
        if (current == null) {
            //Sender null exception
        }

        //Bruker en while løkke for å gå gjennom dobbel lenket liste helt til pekeren peker på null.
        while (current != null) {
            antall ++;
            //Flytter pekeren fra node til neste node og sjekker om vi skal inn i while-løkka igjen.
            current = current.neste;
        }
         //Må finne ut hvordan jeg løser når listen er 0;

        //returnerer antallet/lengden på listern
      return antall;
    }

    @Override
    public boolean tom() {
        //Sjekke om listen som kommer inn er tom
        Node current = hode;
        //While-løkke for å iterere og sjekke om hode har en peker
        if (current != null) {
            return false;
        }



        // Er listen tom returneres false.
        return true;
    }

    @Override
    public boolean leggInn(T verdi) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void leggInn(int indeks, T verdi) {
        throw new UnsupportedOperationException();
    }


    @Override
    public boolean inneholder(T verdi) {
        if (indeksTil(verdi) > -1) { // linje/krav fra setning 4, oppgave 4
            return true;
        } else  // Else alltid return false.
        return false;
    }

    @Override
    public T hent(int indeks) {
        //Skjekker om indeksen er gyldig eller ugyldig
        indeksKontroll(indeks,false);

        //Finner noden til indeks med finnNode metoden og legger inn i en variabel av Node<T>
        Node<T> returNode = finnNode(indeks);

        //returnere verdien til noden
        return returNode.verdi;
    }

    //private hjelpemetoden for å returnere noden til den gitte indeksen
    private Node<T> finnNode(int indeks){
        Node<T> returNode;

        //Vis indeksen er mindre enn antall/2 starter letingen etter noden fra hodet og går mot høyre ved hjelp av neste-pekere
        if (indeks < antall/2){
            returNode = hode;
            int i = 0;

            //bruker while løkke siden spørringene gjøres ukjent mange ganger
            //Beveger mot høyre og setter neturNode til neste verdi til i ikke er mindre enn indeks
            while (i < indeks){
                returNode = returNode.neste;
                i++;
            }
        }

        //vis indeksen er større eller lik antall/2 starter letingen etter noden fra halen og går mot venstre ved hjelp av forrige-pekere
        else {
            returNode = hale;
            int i = antall-1;

            //bruker while løkke siden spørringene gjøres ukjent mange ganger
            //Beveger mot venstre og setter neturNode til forrige verdi til i ikke er større eller lik indeks
            while (i > indeks){
                returNode = returNode.forrige;
                i--;
            }
        }

        return returNode;
    }


    @Override
    public int indeksTil(T verdi) {
        Node<T> peker = hode;

        for (int i =0; i<antall; i++) {

            if (peker.verdi.equals(verdi)) {
                return i;// vil denne returne oss helt ut av hele greia
            }
            peker=peker.neste;
        }
        return -1; //tilfeldring tall
    }

    @Override
    public T oppdater(int indeks, T nyverdi) {
        //Skjekker om nyverdi er null og kaster unntak vis den er
        if (nyverdi ==  null) {
            throw new NullPointerException("Ny verdi kan ikke være null, gi ny verdi");
        }

        //Skjekker om indeksen er gyldig eller ugyldig
        indeksKontroll(indeks,false);

        //Finner noden til indeks med finnNode metoden og legger inn i en variabel av Node<T>
        Node<T> node = finnNode(indeks);

        //henter nåværende verdi for å returnere og før den oppdateres
        T gammelVerdi = node.verdi;

        //Oppdaterer noden sin verdi til nyverdi som kommer inn som parameter
        node.verdi = nyverdi;

        //legger til en økning i endringer teller variablen med 1
        endringer++;

        //returnerer gammel node verdi altså før den ble oppdatert
        return gammelVerdi;
    }

    @Override
    public boolean fjern(T verdi) {
        throw new UnsupportedOperationException();
    }

    @Override
    public T fjern(int indeks) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void nullstill() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException();
    }

    public String omvendtString() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException();
    }

    public Iterator<T> iterator(int indeks) {
        throw new UnsupportedOperationException();
    }

    private class DobbeltLenketListeIterator implements Iterator<T> {
        private Node<T> denne;
        private boolean fjernOK;
        private int iteratorendringer;

        private DobbeltLenketListeIterator() {
            denne = hode;     // p starter på den første i listen
            fjernOK = false;  // blir sann når next() kalles
            iteratorendringer = endringer;  // teller endringer
        }

        private DobbeltLenketListeIterator(int indeks) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean hasNext() {
            return denne != null;
        }

        @Override
        public T next() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

    } // class DobbeltLenketListeIterator

    public static <T> void sorter(Liste<T> liste, Comparator<? super T> c) {
        throw new UnsupportedOperationException();
    }
    }
    // class DobbeltLenketListe


