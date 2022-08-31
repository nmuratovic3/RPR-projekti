package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;


import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    void getPlan() {
        Profesor profesor = new Profesor("Hamid", "Hamidovic");
        Predmet predmet = new Predmet("Analiza podataka", profesor, 32, 35);
        HashMap<Predmet, Integer> planObaveznih = new HashMap<>();
        planObaveznih.put(predmet, 5);
        PlanStudija planStudija = new PlanStudija(planObaveznih, new LinkedHashMap<>());
        Student student = new Student("Ema", "Emic", 12345, planStudija);
        assertAll(
                () -> assertNotEquals(student.getPlan(), planStudija, "Provjera je li isti plan"),
                () -> assertEquals(12345, student.getBrojIndeksa(), "Provjera je li isti indeks"),
                () -> assertEquals("Ema",student.getIme(), "Provjera imena"),
                () -> assertEquals("Emic",student.getPrezime(), "Provjera prezimena")
        );

    }

    @Test
    void testStudent(){
        Profesor profesor = new Profesor("Hamid", "Hamidovic");
        Predmet predmet = new Predmet("Analiza podataka", profesor, 32, 35);
        HashMap<Predmet, Integer> planObaveznih = new HashMap<>();
        planObaveznih.put(predmet, 5);
        PlanStudija planStudija = new PlanStudija(planObaveznih, new LinkedHashMap<>());
        Student student = new Student("Ema", "Emic", 12345, planStudija);
        assertAll(
                () -> assertTrue(student.dajOcjene().isEmpty(), "Provjera ima li student upisanih ocjena"),
                ()-> assertEquals(32, student.getPlan().dajEcts(), "Provjera broja ECTS bodova")
        );

    }
}