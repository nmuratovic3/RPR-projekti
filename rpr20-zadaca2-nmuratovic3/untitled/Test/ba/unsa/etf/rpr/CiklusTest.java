package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CiklusTest {

    @Test
    void Test1() {
        Ciklus c = new Ciklus();
        Semestar s = new Semestar();
        Predmet p = new Predmet("Matematika", new Profesor("Ivica", "Ivkovic"), 31, 40);
        HashMap<Predmet, Integer> mapa = new HashMap<>();
        mapa.put(p, 5);
        PlanStudija plan = new PlanStudija(mapa, new HashMap<>());
        Student s1 = new Student("Hanifa", "Hanific", 12456, plan);
        s.dodajStudenta(s1);
        c.dodajSemestar(s);
        assertAll(
                () -> assertFalse(c.getSemstriCiklusa().isEmpty(), "Provjera prazne kolekcije"),
                () -> assertEquals(c.getSemstriCiklusa().get(0), s, "Provjera da li je isti semestar"),
                () ->assertEquals(1,c.getSemstriCiklusa().get(0).getSemestralniStudenti().size(), "Provjera broja studenata u semestru")
        );
    }

    @Test
    void Test2(){
        Semestar s = new Semestar();
        Predmet p = new Predmet("Matematika", new Profesor("Ivona", "Ivkovic"), 31, 40);
        HashMap<Predmet, Integer> mapa = new HashMap<>();
        mapa.put(p, 5);
        PlanStudija plan = new PlanStudija(mapa, new HashMap<>());
        Student s1 = new Student("Lejla", "Hanific", 12856, plan);
        s.dodajStudenta(s1);
        List<Semestar> semestars=new ArrayList<>();
        semestars.add(s);
        Ciklus c = new Ciklus(semestars);
        assertAll(
                () -> assertFalse(c.getSemstriCiklusa().isEmpty(), "Provjera da li je prazna kolekcija"),
                () -> assertEquals(s1, c.getSemstriCiklusa().get(0).getSemestralniStudenti().get(0), "Provjera da li je isti student"),
                () ->assertEquals(1,c.getSemstriCiklusa().get(0).getSemestralniStudenti().size(), "Provjera broja studenata")
        );
    }
}