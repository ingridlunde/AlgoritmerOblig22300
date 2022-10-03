package no.oslomet.cs.algdat.Oblig2;

import java.util.Iterator;
import java.util.Objects;
import java.util.function.Predicate;

public interface Beholder<T> extends Iterable<T> {
    public boolean leggInn(T t);       // legger inn t i beholderen

    public boolean inneholder(T t);    // sjekker om den inneholder t

    public boolean fjern(T t);         // fjerner t fra beholderen

    public int antall();               // returnerer antallet i beholderen

    public boolean tom();              // sjekker om beholderen er tom

    public void nullstill();           // tømmer beholderen

    public Iterator<T> iterator();     // returnerer en iterator

    default boolean fjernHvis(Predicate<? super T> p)  // betingelsesfjerning
    {
        Objects.requireNonNull(p);                       // kaster unntak

        boolean fjernet = false;
        for (Iterator<T> i = iterator(); i.hasNext(); )  // løkke
        {
            if (p.test(i.next()))                          // betingelsen
            {
                i.remove();                                  // fjerner
                fjernet = true;                              // minst en fjerning
            }
        }
        return fjernet;
    }

} // grensesnitt Beholder
