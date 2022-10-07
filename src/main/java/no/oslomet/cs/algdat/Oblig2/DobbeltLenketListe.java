package no.oslomet.cs.algdat.Oblig2;


////////////////// class DobbeltLenketListe //////////////////////////////


import java.util.Comparator;
import java.util.Iterator;


public class DobbeltLenketListe<T> implements Liste<T> {

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
        throw new UnsupportedOperationException();
    }

    public DobbeltLenketListe(T[] a) {
        throw new UnsupportedOperationException();
    }

    public Liste<T> subliste(int fra, int til) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int antall() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean tom() {
        throw new UnsupportedOperationException();
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
        throw new UnsupportedOperationException();
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
        throw new UnsupportedOperationException();
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

} // class DobbeltLenketListe


