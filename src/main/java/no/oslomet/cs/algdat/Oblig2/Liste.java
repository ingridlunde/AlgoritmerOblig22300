package no.oslomet.cs.algdat.Oblig2;

import java.util.Iterator;

public interface Liste<T> extends Beholder<T> {
    public boolean leggInn(T verdi);           // Nytt element bakerst

    public void leggInn(int indeks, T verdi);  // Nytt element på plass indeks

    public boolean inneholder(T verdi);        // Er verdi i listen?

    public T hent(int indeks);                 // Hent element på plass indeks

    public int indeksTil(T verdi);             // Hvor ligger verdi?

    public T oppdater(int indeks, T verdi);    // Oppdater på plass indeks

    public boolean fjern(T verdi);             // Fjern objektet verdi

    public T fjern(int indeks);                // Fjern elementet på plass indeks

    public int antall();                       // Antallet i listen

    public boolean tom();                      // Er listen tom?

    public void nullstill();                   // Listen nullstilles (og tømmes)

    public Iterator<T> iterator();             // En iterator

    public default String melding(int indeks)  // Unntaksmelding
    {
        return "Indeks: " + indeks + ", Antall: " + antall();
    }

    public default void indeksKontroll(int indeks, boolean leggInn) {
        if (indeks < 0 ? true : (leggInn ? indeks > antall() : indeks >= antall())) {
            throw new IndexOutOfBoundsException(melding(indeks));
        }
    }
}  // Liste