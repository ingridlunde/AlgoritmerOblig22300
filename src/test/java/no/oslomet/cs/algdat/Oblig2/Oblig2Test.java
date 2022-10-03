package no.oslomet.cs.algdat.Oblig2;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class Oblig2Test {

    ////// Oppgave 1 /////////////////////
    @org.junit.jupiter.api.Test
    void oppgave1() {
        int antallFeil = 0;
        Liste<Integer> liste = new DobbeltLenketListe<>();

        if (liste.antall() != 0) {
            antallFeil++;
            System.out.println("Oppgave 1a: Feil i metoden antall()!");
        }

        if (liste.tom() != true) {
            antallFeil++;
            System.out.println("Oppgave 1b: Feil i metoden tom()!");
        }

        try {
            liste = new DobbeltLenketListe<>(null);
            antallFeil++;
            System.out.println("Oppgave 1c: Det skal kastes en NullPointerExcepiton her!");
        } catch (Exception e) {
            if (!(e instanceof NullPointerException)) {
                System.out.println
                        ("Oppgave 1d: Kaster feil type unntak for null-tabell!");
                antallFeil++;
            }
        }

        liste = new DobbeltLenketListe<>(new Integer[]{});

        if (liste.antall() != 0) {
            antallFeil++;
            System.out.println("Oppgave 1e: Feil i konstruktøren!");
        }

        if (liste.tom() != true) {
            antallFeil++;
            System.out.println("Oppgave 1f: Feil i konstruktøren!");
        }

        liste = new DobbeltLenketListe<>(new Integer[]{1});

        if (liste.antall() != 1) {
            antallFeil++;
            System.out.println("Oppgave 1g: Feil i konstruktøren!");
        }

        if (liste.tom() != false) {
            antallFeil++;
            System.out.println("Oppgave 1h: Feil i konstruktøren!");
        }

        liste = new DobbeltLenketListe<>(new Integer[]{1, 2});

        if (liste.antall() != 2) {
            antallFeil++;
            System.out.println("Oppgave 1i: Feil i konstruktøren!");
        }

        liste = new DobbeltLenketListe<>(new Integer[]{1, 2, 3});

        if (liste.antall() != 3) {
            antallFeil++;
            System.out.println("Oppgave 1j: Feil i konstruktøren!");
        }

        Integer[] a = {1, 2, 3, 4, 5};
        Integer[] b = {1, 2, 3, 4, 5};
        liste = new DobbeltLenketListe<>(a);

        if (!Arrays.equals(a, b)) {
            antallFeil++;
            System.out.println("Oppgave 1k: Konstruktøren endrer parametertabellen!");
        }

        liste = new DobbeltLenketListe<>(new Integer[]{null});

        if (liste.antall() != 0) {
            antallFeil++;
            System.out.println("Oppgave 1l: Feil i konstruktøren!");
        }

        liste = new DobbeltLenketListe<>(new Integer[]{null, null});

        if (liste.antall() != 0) {
            antallFeil++;
            System.out.println("Oppgave 1m: Feil i konstruktøren!");
        }

        liste = new DobbeltLenketListe<>(new Integer[]{null, null});

        if (liste.antall() != 0) {
            antallFeil++;
            System.out.println("Oppgave 1n: Feil i konstruktøren!");
        }

        liste = new DobbeltLenketListe<>(new Integer[]{null, 1, null});

        if (liste.antall() != 1) {
            antallFeil++;
            System.out.println("Oppgave 1o: Feil i konstruktøren!");
        }

        liste = new DobbeltLenketListe<>(new Integer[]{null, 1, null, 2, null, 3, null});

        if (liste.antall() != 3) {
            antallFeil++;
            System.out.println("Oppgave 1p: Feil i konstruktøren!");
        }

        class Test<T> extends DobbeltLenketListe<T> {
            public boolean leggInn(T verdi) {
                super.leggInn(verdi);
                super.leggInn(verdi);
                return true;
            }

            public Test(T[] a) {
                super(a);
            }
        }

        Integer[] tall = {1, 2, 3, 4, 5};
        Test<Integer> testliste = new Test(tall);

        if (testliste.antall() > 5) {
            antallFeil++;
            System.out.println("Oppgave 1q: leggInn-metoden brukes i konstruktøren!");
        }

        assertEquals(0, antallFeil, "Du har for mange feil i oppgave 1");

    }


    ////// Oppgave 2 /////////////////////
    @org.junit.jupiter.api.Test
    void oppgave2() {
        int antallFeil = 0;

        DobbeltLenketListe<Integer> liste = new DobbeltLenketListe<>();

        if (liste.leggInn(1) != true) {
            antallFeil++;
            System.out.println
                    ("Oppgave 2a: leggInn-metoden skal returnere true her!");
        }

        liste.leggInn(2);

        if (liste.antall() != 2) {
            antallFeil++;
            System.out.println("Oppgave 2b: leggInn-metoden oppdaterer ikke antall!");
        }

        try {
            liste.leggInn(null);
            antallFeil++;
            System.out.println
                    ("Oppgave 2c: leggInn skal stoppe null-verdier!");
        } catch (Exception e) {
            if (!(e instanceof NullPointerException)) {
                System.out.println
                        ("Oppgave 2d: Kaster feil type unntak for null-verdier i leggInn!");
                antallFeil++;
            }
        }

        liste = new DobbeltLenketListe<>();

        if (!liste.toString().equals("[]")) {
            antallFeil++;
            System.out.println("Oppgave 2e: Tom liste skal gi []!");
        }

        if (!liste.omvendtString().equals("[]")) {
            antallFeil++;
            System.out.println
                    ("Oppgave 2f: Tom liste skal gi []!");
        }

        liste.leggInn(1);

        String s = liste.toString();
        if (!s.equals("[1]")) {
            antallFeil++;
            System.out.println
                    ("Oppgave 2g: Du har " + s + ", skal være [1]!");
        }

        s = liste.omvendtString();
        if (!s.equals("[1]")) {
            antallFeil++;
            System.out.println
                    ("Oppgave 2h: Du har " + s + ", skal være [1]!");
        }

        liste.leggInn(2);

        s = liste.toString();
        if (!s.equals("[1, 2]")) {
            antallFeil++;
            System.out.println
                    ("Oppgave 2i: Du har " + s + ", skal være [1, 2]!");
        }

        s = liste.omvendtString();
        if (!s.equals("[2, 1]")) {
            antallFeil++;
            System.out.println
                    ("Oppgave 2j: Du har " + s + ", skal være [2, 1]!");
        }

        liste.leggInn(3);
        liste.leggInn(4);

        s = liste.toString();
        if (!s.equals("[1, 2, 3, 4]")) {
            antallFeil++;
            System.out.println
                    ("Oppgave 2k: Du har " + s + ", skal være [1, 2, 3, 4]!");
        }

        s = liste.omvendtString();
        if (!s.equals("[4, 3, 2, 1]")) {
            antallFeil++;
            System.out.println
                    ("Oppgave 2l: Du har " + s + ", skal være [4, 3, 2, 1]!");
        }

        liste = new DobbeltLenketListe<>(new Integer[]{null});
        String t1 = "[]", t2 = liste.toString();

        if (!t1.equals(t2)) {
            antallFeil++;
            System.out.println
                    ("Oppgave 2m: Du har " + t2 + ", men det skal være " + t1);
        }

        liste = new DobbeltLenketListe<>(new Integer[]{null, 1, null, 2, null});
        t1 = "[1, 2]";
        t2 = liste.toString();

        if (!t1.equals(t2)) {
            antallFeil++;
            System.out.println
                    ("Oppgave 2m: Du har " + t2 + ", men det skal være " + t1);
        }

        for (int i = 0; i < 20000; i++) liste.leggInn(i);
        long tid = System.currentTimeMillis();
        liste.toString();
        tid = System.currentTimeMillis() - tid;

        if (tid > 20) {
            antallFeil++;
            System.out.println("Oppgave 2n: Dette (" + tid + " ms) gikk altfor sakte!");
            System.out.println("            Har du kodet toString slik det ble bedt om?");
        }

        assertEquals(0, antallFeil, "Du har for mange feil i oppgave 2");

    }

    ////// Oppgave 3 /////////////////////
    @org.junit.jupiter.api.Test
    void oppgave3() {
        int antallFeil = 0;

        Liste<Integer> testliste = new DobbeltLenketListe<>();
        for (int i = 0; i < 100000; i++) testliste.leggInn(i);
        long tid = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) testliste.hent(99999);
        tid = System.currentTimeMillis() - tid;

        if (tid > 20) {
            antallFeil++;
            System.out.println("Oppgave 3a: Dette (" + tid + " ms) gikk altfor sakte!");
            System.out.println("            Har du kodet metoden finnNode() riktig?");
        }

        DobbeltLenketListe<Integer> liste = new DobbeltLenketListe<>();

        try {
            liste.hent(0);
            antallFeil++;
            System.out.println("Oppgave 3b: En tom liste har ikke indeks lik 0!");
        } catch (Exception e) {
            if (!(e instanceof IndexOutOfBoundsException)) {
                System.out.println("Oppgave 3c: Metoden hent() kaster feil type unntak!");
                antallFeil++;
            }
        }

        liste.leggInn(1);

        try {
            liste.hent(-1);
            antallFeil++;
            System.out.println("Oppgave 3d: Feil i indeks-sjekken!");
        } catch (Exception e) {
            if (!(e instanceof IndexOutOfBoundsException)) {
                System.out.println("Oppgave 3e: Metoden hent() kaster feil type unntak!");
                antallFeil++;
            }
        }

        try {
            liste.hent(1);
            antallFeil++;
            System.out.println("Oppgave 3f: Feil i indeks-sjekken!");
        } catch (Exception e) {
            if (!(e instanceof IndexOutOfBoundsException)) {
                System.out.println("Oppgave 3g: Metoden hent() kaster feil type unntak!");
                antallFeil++;
            }
        }

        if (liste.hent(0) != 1) {
            antallFeil++;
            System.out.println("Oppgave 3h: Metoden hent() gir feil svar!");
        }

        liste.leggInn(2);
        liste.leggInn(3);
        liste.leggInn(4);

        if (liste.hent(3) != 4 || liste.hent(2) != 3
                || liste.hent(1) != 2 || liste.hent(0) != 1) {
            antallFeil++;
            System.out.println("Oppgave 3i: Metoden hent() gir feil svar!");
        }

        try {
            liste.oppdater(3, null);
            antallFeil++;
            System.out.println("Oppgave 3j: Ikke tillatt med nullverdier i oppdater!");
        } catch (Exception e) {
            if (!(e instanceof NullPointerException)) {
                System.out.println(
                        "Oppgave 3k: Feil unntak for nullverdier i oppdater()!");
                antallFeil++;
            }
        }

        try {
            liste.oppdater(4, 5);
            antallFeil++;
            System.out.println
                    ("Oppgave 3l: En liste med fire verdier har ikke indeks lik 4");
        } catch (Exception e) {
            if (!(e instanceof IndexOutOfBoundsException)) {
                System.out.println
                        ("Oppgave 3m: Metoden kaster feil type unntak for indeksfeil!");
                antallFeil++;
            }
        }

        if (liste.oppdater(3, 5) != 4) {
            antallFeil++;
            System.out.println
                    ("Oppgave 3n: Metoden oppdater() returnerer feil verdi!");
        }

        if (liste.antall() != 4) {
            antallFeil++;
            System.out.println
                    ("Oppgave 3o: antallEndringer skal økes, men antall skal ikke endres!");
        }

        if (liste.hent(3) != 5) {
            antallFeil++;
            System.out.println
                    ("Oppgave 3p: Metoden oppdater() setter verdien feil!");
        }

        if (liste.oppdater(0, -1) != 1) {
            antallFeil++;
            System.out.println
                    ("Oppgave 3q: Metoden oppdater() returnerer feil verdi!");
        }

        if (liste.hent(0) != -1) {
            antallFeil++;
            System.out.println
                    ("Oppgave 3r: Metoden oppdater() setter verdien feil!");
        }

        String s = liste.toString();
        if (!s.equals("[-1, 2, 3, 5]")) {
            antallFeil++;
            System.out.println
                    ("Oppgave 3s: Du har " + s + ", skal være [-1, 2, 3, 5]!");
        }

        s = liste.omvendtString();
        if (!s.equals("[5, 3, 2, -1]")) {
            antallFeil++;
            System.out.println
                    ("Oppgave 3t: Du har " + s + ", skal være [5, 3, 2, -1]!");
        }

        Integer[] i = {};
        DobbeltLenketListe<Integer> iliste = new DobbeltLenketListe<>(i);

        if (!iliste.subliste(0, 0).toString().equals("[]")) {
            antallFeil++;
            System.out.println
                    ("Oppgave 3u: Sublisten til en tom liste skal være tom!");
        }

        Character[] c = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',};
        DobbeltLenketListe<Character> cliste = new DobbeltLenketListe<>(c);

        if (!cliste.subliste(0, 1).toString().equals("[A]")) {
            antallFeil++;
            System.out.println
                    ("Oppgave 3v: Sublisten skal inneholde kun første verdi i listen!");
        }

        if (!cliste.subliste(9, 10).toString().equals("[J]")) {
            antallFeil++;
            System.out.println
                    ("Oppgave 3w: Sublisten skal inneholde kun siste verdi i listen!");
        }

        if (!cliste.subliste(0, 2).toString().equals("[A, B]")) {
            antallFeil++;
            System.out.println
                    ("Oppgave 3x: Sublisten skal inneholde kun de to første verdiene!");
        }

        if (!cliste.subliste(8, 10).toString().equals("[I, J]")) {
            antallFeil++;
            System.out.println
                    ("Oppgave 3y: Sublisten skal inneholde kun de to siste verdiene!");
        }

        if (!cliste.subliste(3, 7).toString().equals("[D, E, F, G]")) {
            antallFeil++;
            System.out.println
                    ("Oppgave 3z: Sublisten skal inneholde [D, E, F, G]!");
        }

        try {
            cliste.subliste(9, 11);

            antallFeil++;
            System.out.println
                    ("Oppgave 3æ: Det skal kastes et unntak når til er større enn antall!");
        } catch (Exception e) {
            if (!e.getClass().getName().equals("java.lang.IndexOutOfBoundsException")) {
                antallFeil++;
                System.out.println
                        ("Oppgave 3ø: Skal ha IndexOutOfBoundsException her!");
            }

            if (e.toString().contains("tablengde")) {
                antallFeil++;
                System.out.println
                        ("Oppgave 3å: Bruk ikke tablengde i feilmeldingen! Bruk antall!");
            }
        }

        try {
            cliste.subliste(-1, 1);

            antallFeil++;
            System.out.println
                    ("Oppgave 3å1: Det skal kastes et unntak når fra er negativ!");
        } catch (Exception e) {
            if (!e.getClass().getName().equals("java.lang.IndexOutOfBoundsException")) {
                System.out.println
                        ("Oppgave 3å2: Skal ha IndexOutOfBoundsException her!");
                antallFeil++;
            }
        }

        try {
            cliste.subliste(2, 1);

            antallFeil++;
            System.out.println
                    ("Oppgave 3å3: Det skal kastes et unntak når fra er negativ!");
        } catch (Exception e) {
            if (!e.getClass().getName().equals("java.lang.IllegalArgumentException")) {
                System.out.println
                        ("Oppgave 3å4: Skal ha IllegalArgumentException her!");
                antallFeil++;
            }
        }

        assertEquals(0, antallFeil, "Du har for mange feil i oppgave 3");

    }

    ////// Oppgave 4 /////////////////////
    @org.junit.jupiter.api.Test
    void oppgave4() {
        int antallFeil = 0;

        DobbeltLenketListe<String> sliste = new DobbeltLenketListe<>();
        sliste.leggInn("A");

        if (sliste.indeksTil(new String("A")) != 0) {
            antallFeil++;
            System.out.println("Oppgave 4a: Stygg feil! Du MÅ bruke equals");
            System.out.println("            og ikke == i sammenligningen i indeksTil()!");
        }

        Liste<Integer> liste = new DobbeltLenketListe<>();

        if (liste.indeksTil(2) != -1) {
            antallFeil++;
            System.out.println("Oppgave 4b: En tom liste inneholder ikke noe!");
        }

        liste.leggInn(1);

        if (liste.indeksTil(1) != 0) {
            antallFeil++;
            System.out.println("Oppgave 4c: Verdien 1 har indeks 0!");
        }

        liste.leggInn(3);
        liste.leggInn(5);
        liste.leggInn(7);

        if (liste.indeksTil(10) != -1 || liste.indeksTil(4) != -1) {
            antallFeil++;
            System.out.println("Oppgave 4d: Listen inneholder hverken 4 eller 10!");
        }

        if (liste.indeksTil(1) != 0 || liste.indeksTil(3) != 1
                || liste.indeksTil(5) != 2 || liste.indeksTil(7) != 3) {
            antallFeil++;
            System.out.println("Oppgave 4e: Feil i metoden indeksTil()!");
        }

        try {
            if (liste.indeksTil(null) != -1) {
                antallFeil++;
                System.out.println
                        ("Oppgave 4f: Skal returnere -1 for null-verdier!");
            }
        } catch (Exception e) {
            System.out.println(
                    "Oppgave 4g: Skal ikke kaste unntak, men returnere -1 for null-verdier!");
            antallFeil++;
        }

        if (liste.inneholder(1) != true || liste.inneholder(7) != true
                || liste.inneholder(0) != false || liste.inneholder(6) != false) {
            antallFeil++;
            System.out.println("Oppgave 4h: Feil i metoden inneholder()!");
        }

        sliste = new DobbeltLenketListe<>();
        sliste.leggInn("Kari");
        sliste.leggInn("Kari");

        if (sliste.indeksTil("Kari") != 0) {
            antallFeil++;
            System.out.println
                    ("Oppgave 4i: Skal gi indeks til første forekomst hvis like verdier!");
        }

        assertEquals(0, antallFeil, "Du har for mange feil i oppgave 4");

    }

    ////// Oppgave 5 /////////////////////
    @org.junit.jupiter.api.Test
    void oppgave5() {
        int antallFeil = 0;

        DobbeltLenketListe<Integer> liste = new DobbeltLenketListe<>();

        try {
            liste.leggInn(-1, 1);
            antallFeil++;
            System.out.println(
                    "Oppgave 5a: Kan ikke legge inn på indeks -1!");
        } catch (Exception e) {
            if (!(e instanceof IndexOutOfBoundsException)) {
                System.out.println
                        ("Oppgave 5b: Kaster feil type unntak for indeksfeil!");
                antallFeil++;
            }
        }

        try {
            liste.leggInn(1, 1);
            antallFeil++;
            System.out.println("Oppgave 5c: Kan ikke legge inn på indeks 1 i en tom liste!");
        } catch (Exception e) {
            if (!(e instanceof IndexOutOfBoundsException)) {
                System.out.println("Oppgave 5d: Metoden leggInn() kaster feil type unntak!");
                antallFeil++;
            }
        }

        try {
            liste.leggInn(0, null);
            antallFeil++;
            System.out.println("Oppgave 5e: Ikke tillatt å legge inn null-verdier!");
        } catch (Exception e) {
            if (!(e instanceof NullPointerException)) {
                System.out.println
                        ("Oppgave 5f: Det kastes feil type unntak for null-verdier!");
                antallFeil++;
            }
        }

        liste = new DobbeltLenketListe<>();

        try {
            liste.leggInn(0, 4);
        } catch (Exception e) {
            System.out.println
                    ("Oppgave 5g: Feil i indekssjekken! 0 <= indeks <= antall er tillatt!");

            antallFeil++;
        }

        liste = new DobbeltLenketListe<>();

        liste.leggInn(0, 4);  // ny verdi i tom liste
        liste.leggInn(0, 2);  // ny verdi legges forrest
        liste.leggInn(2, 6);  // ny verdi legges bakerst
        liste.leggInn(1, 3);  // ny verdi nest forrest
        liste.leggInn(3, 5);  // ny verdi nest bakerst
        liste.leggInn(0, 1);  // ny verdi forrest
        liste.leggInn(6, 7);  // ny verdi legges bakerst

        if (liste.antall() != 7) {
            antallFeil++;
            System.out.println(
                    "Oppgave 5h: Feil i antall-oppdateringen i metoden leggInn()!");
        }

        if (!liste.toString().equals("[1, 2, 3, 4, 5, 6, 7]")) {
            antallFeil++;
            System.out.println("Oppgave 5i: Feil i metoden leggInn()!");
        }

        if (!liste.omvendtString().equals("[7, 6, 5, 4, 3, 2, 1]")) {
            antallFeil++;
            System.out.println("Oppgave 5j: Feil i metoden leggInn()!");
        }

        assertEquals(0, antallFeil, "Du har for mange feil i oppgave 5");

    }

    ///////// Oppgave 6 //////////////////////////
    @org.junit.jupiter.api.Test
    void oppgave6() {
        int antallFeil = 0;

        DobbeltLenketListe<String> liste = new DobbeltLenketListe<>();

        try {
            liste.fjern(0);
            antallFeil++;
            System.out.println("Oppgave 6a: Indeks 0 finnes ikke i en tom liste!");
        } catch (Exception e) {
            if (!(e instanceof IndexOutOfBoundsException)) {
                System.out.println
                        ("Oppgave 6b: Indekssjekken kaster feil unntak!");
                antallFeil++;
            }
        }

        liste = new DobbeltLenketListe<>(new String[]{"A", "B", "C", "D", "E", "F", "G"});

        try {
            liste.fjern(7);
            antallFeil++;
            System.out.println("Oppgave 6c: Indeks 7 finnes ikke!");
        } catch (Exception e) {
            if (!(e instanceof IndexOutOfBoundsException)) {
                System.out.println("Oppgave 6d: Indekssjekken kaster feil unntak!!");
                antallFeil++;
            }
        }

        try {
            liste.fjern(-1);
            antallFeil++;
            System.out.println("Oppgave 6e: Indeks -1 finnes ikke!");
        } catch (Exception e) {
            if (!(e instanceof IndexOutOfBoundsException)) {
                System.out.println("Oppgave 6f: Indekssjekken kaster feil unntak!!");
                antallFeil++;
            }
        }

        if (!liste.fjern(3).equals("D")) {
            antallFeil++;
            System.out.println("Oppgave 6ga: Feil returverdi i metoden fjern(indeks)!");
        }

        if (liste.antall() != 6) {
            antallFeil++;
            System.out.println("Oppgave 6gb: Feil i antall-oppdateringen i fjern(indeks)!");
            System.out.println("             Reduseres ikke antall? Reduserers den to ganger!");
        }

        liste.fjern(0);  // fjerner A
        liste.fjern(4);  // fjerner G

        if (liste.antall() != 4) {
            antallFeil++;
            System.out.println("Oppgave 6h: Feil i antall-oppdateringen i fjern(indeks)!");
        }

        if (!liste.toString().equals("[B, C, E, F]")) {
            antallFeil++;
            System.out.println("Oppgave 6i: Feil i fjern(indeks)-metoden!");
        }

        if (!liste.omvendtString().equals("[F, E, C, B]")) {
            antallFeil++;
            System.out.println("Oppgave 6j: Feil i fjern(indeks)-metoden!");
        }

        liste.leggInn("H");
        liste.leggInn("I");

        if (liste.fjern(" ") == true
                || liste.fjern("G") == true
                || liste.fjern("J") == true) {
            antallFeil++;
            System.out.println("Oppgave 6ka: Feil returverdi i metoden fjern(T)!");
        }

        liste.leggInn("B");
        liste.fjern("B");

        if (liste.antall() != 6) {
            antallFeil++;
            System.out.println("Oppgave 6kb: Feil i antall-oppdateringen i fjern(T)!");
            System.out.println("             Reduseres ikke antall? Reduserers den to ganger!");
        }

        if (!liste.toString().equals("[C, E, F, H, I, B]")) {
            antallFeil++;
            System.out.println("Oppgave 6kc: Skal fjerne første forekomst hvis flere like!");
        }

        liste.fjern("B");

        if (liste.fjern("F") != true
                || liste.fjern("I") != true) {
            antallFeil++;
            System.out.println("Oppgave 6l: Feil returverdi i metoden fjern(T)!");
        }

        if (!liste.toString().equals("[C, E, H]")) {
            antallFeil++;
            System.out.println("Oppgave 6m: Feil i metoden fjern(T)!");
        }

        if (!liste.omvendtString().equals("[H, E, C]")) {
            antallFeil++;
            System.out.println("Oppgave 6n: Feil i metoden fjern(T)!");
        }

        liste.fjern("H");
        liste.fjern("C");
        liste.fjern("E");

        if (!liste.toString().equals("[]")) {
            antallFeil++;
            System.out.println("Oppgave 6o: Feil i metoden fjern(T)!");
        }

        if (!liste.omvendtString().equals("[]")) {
            antallFeil++;
            System.out.println("Oppgave 6p: Feil i metoden fjern(T)!");
        }

        if (liste.antall() != 0) {
            antallFeil++;
            System.out.println(
                    "Oppgave 6q: Feil i antall-oppdateringen metoden fjern(T)!");
        }

        try {
            if (liste.fjern(null) != false) {
                antallFeil++;
                System.out.println
                        ("Oppgave 6r: skal returnere false for en null-verdi!");
            }
        } catch (Exception e) {
            System.out.println
                    ("Oppgave 6s: Skal ikke kaste unntak, men returnere false for en null-verdi!");
            antallFeil++;
        }

        liste = new DobbeltLenketListe<>();
        liste.leggInn("A");
        liste.leggInn("B");
        liste.leggInn("C");
        liste.leggInn("D");
        liste.leggInn("E");

        if (liste.fjern(new String("A")) != true
                || liste.fjern(new String("E")) != true
                || liste.fjern(new String("C")) != true
                || liste.fjern(new String("B")) != true
                || liste.fjern(new String("D")) != true) {
            antallFeil++;
            System.out.println("Oppgave 6t: Stygg feil! Du MÅ bruke equals");
            System.out.println("            og ikke == i sammenligningen i fjern(T)!");
        }

        liste = new DobbeltLenketListe<>();
        liste.leggInn("A");

        try {
            liste.fjern(0);
        } catch (Exception e) {
            System.out.println
                    ("Oppgave 6u: Her kastes det et unntak, men det skal ikke skje!!");
            antallFeil++;
        }

        if (!liste.toString().equals("[]")) {
            System.out.println
                    ("Oppgave 6v: Her må det være en pekerfeil!");
            antallFeil++;
        }

        if (!liste.omvendtString().equals("[]")) {
            System.out.println
                    ("Oppgave 6w: Her må det være en pekerfeil!");
            antallFeil++;
        }

        liste.leggInn("A");

        try {
            liste.fjern("A");
        } catch (Exception e) {
            System.out.println
                    ("Oppgave 6x: Her kastes det et unntak, men det skal ikke skje!!");
            antallFeil++;
        }

        if (!liste.toString().equals("[]")) {
            System.out.println
                    ("Oppgave 6y: Her må det være en pekerfeil!");
            antallFeil++;
        }

        if (!liste.omvendtString().equals("[]")) {
            System.out.println
                    ("Oppgave 6z: Her må det være en pekerfeil!");
            antallFeil++;
        }

        liste.leggInn("A");
        liste.leggInn("B");

        try {
            liste.fjern(1);
        } catch (Exception e) {
            System.out.println
                    ("Oppgave 6za: Her kastes det et unntak, men det skal ikke skje!!");
            antallFeil++;
        }

        if (!liste.toString().equals("[A]")) {
            System.out.println
                    ("Oppgave 6zb: Her må det være en pekerfeil!");
            antallFeil++;
        }

        if (!liste.omvendtString().equals("[A]")) {
            System.out.println
                    ("Oppgave 6zc: Her må det være en pekerfeil!");
            antallFeil++;
        }

        liste.leggInn("B");

        try {
            liste.fjern("B");
        } catch (Exception e) {
            System.out.println
                    ("Oppgave 6zd: Her kastes det et unntak, men det skal ikke skje!!");
            antallFeil++;
        }

        if (!liste.toString().equals("[A]")) {
            System.out.println
                    ("Oppgave 6ze: Her må det være en pekerfeil!");
            antallFeil++;
        }

        if (!liste.omvendtString().equals("[A]")) {
            System.out.println
                    ("Oppgave 6zf: Her må det være en pekerfeil!");
            antallFeil++;
        }

        Liste<Integer> nyliste = new DobbeltLenketListe<>();

        for (int i = 1; i <= 100_000; i++) nyliste.leggInn(i);
        long tid1 = System.currentTimeMillis();
        for (int i = 40000; i <= 50000; i++) nyliste.fjern(new Integer(i));
        tid1 = System.currentTimeMillis() - tid1;
        nyliste = new DobbeltLenketListe<>();

        for (int i = 1; i <= 100_000; i++) nyliste.leggInn(i);
        long tid2 = System.currentTimeMillis();
        for (int i = 40000; i <= 50000; i++) nyliste.fjern(i);
        tid2 = System.currentTimeMillis() - tid2;

        long maks = Math.max(tid1, tid2);
        long min = Math.min(tid1, tid2);

        if (maks > 1.5 * min) {
            System.out.println("Oppgave 6zg: Ineffektiv kode! Har du kodet den ene fjern-metoden");
            System.out.println("ved hjelp av den andre? Eller så er en av fjern-metodene dine litt treg.");
            antallFeil++;
        }

        assertEquals(0, antallFeil, "Du har for mange feil i oppgave 6");

    }

    //// Oppgave 7 ////////////////////////////
    @org.junit.jupiter.api.Test
    void oppgave7() {
        int antallFeil = 0;

        DobbeltLenketListe<Integer> liste = new DobbeltLenketListe<>();

        for (int i = 1; i <= 7; i++) {
            liste.leggInn(i);
        }

        liste.nullstill();

        if (liste.antall() != 0) {
            antallFeil++;
            System.out.println
                    ("Oppgave 7a: Feil i antalloppdateringen i nullstill!");
        }

        if (!liste.toString().equals("[]")) {
            antallFeil++;
            System.out.println("Oppgave 7b: Feil i metoden nullstill()!");
        }

        if (!liste.omvendtString().equals("[]")) {
            antallFeil++;
            System.out.println("Oppgave 7c: Feil i metoden nullstill()!");
        }

        if (liste.indeksTil(1) != -1) {
            antallFeil++;
            System.out.println("Oppgave 7d: Feil i metoden nullstill()!");
        }

        assertEquals(0, antallFeil, "Du har for mange feil i oppgave 7");

    }

    //// Oppgave 8 ////////////////////////////
    @org.junit.jupiter.api.Test
    void oppgave8() {
        int antallFeil = 0;

        DobbeltLenketListe<Integer> liste = new DobbeltLenketListe<>();

        try {
            Iterator<Integer> i = liste.iterator();
            i.next();  // kaller next() i en tom liste
            System.out.println(
                    "Oppgave 8a: Skal kastes unntak for next() i en tom liste!");
            antallFeil++;
        } catch (Exception e) {
            if (!(e instanceof NoSuchElementException)) {
                System.out.println("Oppgave 8b: Det kastes feil type unntak!");
                antallFeil++;
            }
        }

        liste.leggInn(1);

        Iterator<Integer> i = liste.iterator();

        if (i.next() != 1) {
            System.out.println
                    ("Oppgave 8c: Metoden next() gir feil verdi!");
            antallFeil++;
        }

        try {
            i.next();  // det er ikke flere i listen

            System.out.println(
                    "Oppgave 8d: Skal kastes unntak for next() her!");
            antallFeil++;
        } catch (Exception e) {
            if (!(e instanceof NoSuchElementException)) {
                System.out.println("Oppgave 8e: Det kastes feil type unntak!");
                antallFeil++;
            }
        }

        for (int k = 2; k <= 7; k++) {
            liste.leggInn(k);
        }

        int k = 1;
        for (Iterator<Integer> j = liste.iterator(); j.hasNext(); ) {
            if (j.next() != k) {
                System.out.println("Oppgave 8f: Metoden next() gir feil verdier!");
                antallFeil++;
            }
            k++;
        }

        i = liste.iterator();
        liste.fjern(0); // bruker fjern(indeks) etter at iteratoren er opprettet

        try {
            i.next();
            antallFeil++;
            System.out.println
                    ("Oppgave 8g: ForventetAntallEndringer ikke endret i fjern(indeks)!");
        } catch (Exception e) {
            if (!(e instanceof ConcurrentModificationException)) {
                System.out.println("Oppgave 8h: Det kastes feil type unntak!");
                antallFeil++;
            }
        }

        i = liste.iterator();
        liste.leggInn(8);  // bruker leggInn(T) etter at iteratoren er opprettet

        try {
            i.next();
            antallFeil++;
            System.out.println
                    ("Oppgave 8i: ForventetAntallEndringer ikke endret i leggInn(T)!");
        } catch (Exception e) {
            if (!(e instanceof ConcurrentModificationException)) {
                System.out.println("Oppgave 8j: Det kastes feil type unntak!");
                antallFeil++;
            }
        }

        i = liste.iterator();
        liste.fjern(new Integer(8));  // bruker fjern(T) etter at iteratoren er opprettet

        try {
            i.next();
            antallFeil++;
            System.out.println
                    ("Oppgave 8k: ForventetAntallEndringer ikke endret i fjern(T)!");
        } catch (Exception e) {
            if (!(e instanceof ConcurrentModificationException)) {
                System.out.println("Oppgave 8l: Det kastes feil type unntak!");
                antallFeil++;
            }
        }

        i = liste.iterator();
        liste.leggInn(0, 1);  // bruker leggInn(indeks,T) etter at iteratoren er opprettet

        try {
            i.next();
            antallFeil++;
            System.out.println
                    ("Oppgave 8m: ForventetAntallEndringer ikke endret i leggInn(indeks,T)!");
        } catch (Exception e) {
            if (!(e instanceof ConcurrentModificationException)) {
                System.out.println("Oppgave 8n: Det kastes feil type unntak!");
                antallFeil++;
            }
        }

        i = liste.iterator();
        liste.oppdater(3, 9);  // oppdaterer etter at iteratoren er opprettet

        try {
            i.next();
            antallFeil++;
            System.out.println
                    ("Oppgave 8o: ForventetAntallEndringer ikke endret i oppdater()!");
        } catch (Exception e) {
            if (!(e instanceof ConcurrentModificationException)) {
                System.out.println("Oppgave 8p: Det kastes feil type unntak!");
                antallFeil++;
            }
        }

        i = liste.iterator();
        liste.nullstill();  // nullstiller etter at iteratoren er opprettet

        try {
            i.next();
            antallFeil++;
            System.out.println
                    ("Oppgave 8q: ForventetAntallEndringer ikke endret i nullstill()!");
        } catch (Exception e) {
            if (!(e instanceof ConcurrentModificationException)) {
                System.out.println("Oppgave 8r: Det kastes feil type unntak!");
                antallFeil++;
            }
        }

        for (int j = 1; j <= 7; j++) liste.leggInn(j);

        try {
            liste.iterator(7);
            System.out.println("Oppgave 8s: Indeks 7 finnes ikke!");
            antallFeil++;
        } catch (Exception e) {
            if (!(e instanceof IndexOutOfBoundsException)) {
                System.out.println("Oppgave 8t: Metoden kaster feil type unntak!");
                antallFeil++;
            }
        }

        try {
            liste.iterator(-1);
            System.out.println("Oppgave 8u: Indeks -1 finnes ikke!");
            antallFeil++;
        } catch (Exception e) {
            if (!(e instanceof IndexOutOfBoundsException)) {
                System.out.println("Oppgave 8v: Metoden kaster feil type unntak!");
                antallFeil++;
            }
        }

        int m = 4;
        i = liste.iterator(3);
        for (; i.hasNext(); ) {
            if (i.next() != m) {
                antallFeil++;
                System.out.println("Oppgave 8w: Feil i metoden next()!");
            }
            m++;
        }

        try {
            i.next();
            antallFeil++;
            System.out.println("Oppgave 8x: Skal kaste unntak for next() her!");
        } catch (Exception e) {
            if (!(e instanceof NoSuchElementException)) {
                System.out.println("Oppgave 8y: Det kastes feil type unntak!");
                antallFeil++;
            }
        }

        assertEquals(0, antallFeil, "Du har for mange feil i oppgave 8");

    }

    ////// Oppgave 9 /////////////////////
    @org.junit.jupiter.api.Test
    void oppgave9() {
        int antallFeil = 0;

        DobbeltLenketListe<Integer> liste = new DobbeltLenketListe<>();

        for (int k = 1; k <= 13; k++) {
            liste.leggInn(k);
        }

        for (Iterator<Integer> i = liste.iterator(); i.hasNext(); ) {
            int verdi = i.next();
            if (verdi % 2 == 1) {
                i.remove(); // fjerner oddetallene
            }
        }

        if (liste.antall() != 6) {
            antallFeil++;
            System.out.println
                    ("Oppgave 9a: Feil i antall-oppdatering i remove()!");
        }

        if (!liste.toString().equals("[2, 4, 6, 8, 10, 12]")) {
            antallFeil++;
            System.out.println("Oppgave 9b: Feil i remove()!");
        }

        if (!liste.omvendtString().equals("[12, 10, 8, 6, 4, 2]")) {
            antallFeil++;
            System.out.println("Oppgave 9c: Feil i remove()!");
        }

        // fjerner alle i listen
        Iterator<Integer> j = liste.iterator();
        for (; j.hasNext(); ) {
            j.next();
            j.remove();
        }

        if (!liste.toString().equals("[]")) {
            antallFeil++;
            System.out.println("Oppgave 9d: Feil når remove() har slettet alle!");
        }

        try {
            Iterator<Integer> i = liste.iterator();
            i.remove();  // kaller remove() i tom liste
            antallFeil++;
            System.out.println("Oppgave 9e: Her skal det kastes unntak");
        } catch (Exception e) {
            if (!(e instanceof IllegalStateException)) {
                System.out.println("Oppgave 9f: Det kastes feil type unntak!");
                antallFeil++;
            }
        }

        for (int k = 1; k <= 5; k++) {
            liste.leggInn(k);
        }
        Iterator<Integer> i1 = liste.iterator();
        Iterator<Integer> i2 = liste.iterator();
        i1.next();
        i1.remove();
        try {
            i2.next();
            System.out.println("Oppgave 9g: Her skal det kastes et unntak!");
            antallFeil++;
        } catch (Exception e) {
            if (!(e instanceof ConcurrentModificationException)) {
                System.out.println("Oppgave 9h: Det kastes feil type unntak!");
                antallFeil++;
            }
        }

        j = liste.iterator();

        try {
            j.next();
            j.remove();
            j.remove();
            System.out.println("Oppgave 9i: Her skal det kastes et unntak!");
            antallFeil++;
        } catch (Exception e) {
            if (!(e instanceof IllegalStateException)) {
                System.out.println("Oppgave 9j: Det kastes feil type unntak!");
                antallFeil++;
            }
        }

        assertEquals(0, antallFeil, "Du har for mange feil i oppgave 9");

    }

    ////// Oppgave 10 /////////////////////
    @org.junit.jupiter.api.Test
    void oppgave10() {
        int antallFeil = 0;

        DobbeltLenketListe<String> liste = new DobbeltLenketListe<>(new String[0]);

        try {
            DobbeltLenketListe.sorter(liste, Comparator.naturalOrder());

            if (!liste.toString().equals("[]")) {
                System.out.println("Oppgave 10a: Feil for tom liste!");
                antallFeil++;
            }
        } catch (Exception e) {
            System.out.println("Oppgave 10b: Ikke unntak for tom liste!");
            antallFeil++;
        }

        liste = new DobbeltLenketListe<>(new String[]{"A"});
        DobbeltLenketListe.sorter(liste, Comparator.naturalOrder());

        if (!liste.toString().equals("[A]")) {
            System.out.println("Oppgave 10c: Feil for liste med ett element!");
            antallFeil++;
        }

        liste = new DobbeltLenketListe<>(new String[]{"C", "B", "A"});
        DobbeltLenketListe.sorter(liste, Comparator.naturalOrder());

        if (!liste.toString().equals("[A, B, C]")) {
            System.out.println("Oppgave 10d: Feil for listen C, B, A!");
            antallFeil++;
        }

        liste = new DobbeltLenketListe<>(new String[]{"G", "B", "F", "C", "E", "D", "A"});
        DobbeltLenketListe.sorter(liste, Comparator.naturalOrder());

        if (!liste.toString().equals("[A, B, C, D, E, F, G]")) {
            System.out.println("Oppgave 10e: Feil for listen G, B, F, C, E, D, A!");
            antallFeil++;
        }

        Integer[] a = {8, 5, 2, 11, 7, 3, 15, 14, 10, 17, 18, 9, 4, 12, 13, 19, 20, 1, 16, 6};
        DobbeltLenketListe<Integer> intliste = new DobbeltLenketListe<>(a);
        DobbeltLenketListe.sorter(intliste, Comparator.naturalOrder());

        if (!intliste.toString().equals(
                "[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20]")) {
            System.out.println("Oppgave 10f: Metoden sorterer feil!");
            antallFeil++;
        }

        assertEquals(0, antallFeil, "Du har for mange feil i oppgave 10");

    }

}