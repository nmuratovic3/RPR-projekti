package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;

class FakultetTest {
    @Test
    void Test1() {
        Fakultet efsa = new Fakultet();
        assertAll(
                () -> assertTrue(efsa.getCiklusi().isEmpty(), "Provjera da li je lista prazna"),
        ()-> assertEquals(0, efsa.dajProfesoreKojiNemajuNormuUOpsegu().size(), "Nema upisanih profesora")
        );
    }
    @Test
    void Test2(){
        Profesor profesor = new Profesor("Omer", "Delic");
        Fakultet efsa = new Fakultet();
        Predmet predmet = new Predmet("Fizika", profesor, 12, 45);
        efsa.getPredmeti().add(predmet);
        assertAll(
                () -> assertEquals(profesor, efsa.dajProfesoreKojiNemajuNormuUOpsegu().get(0), "Profesori koji nemaju normu"),
                () -> assertEquals(0, profesor.getBrojStudenata(), "Provjera ima li upisanih studenata"),
                () -> assertEquals(1,efsa.dajSortiraneProfesore().toArray().length, "Provjera sortiranja")

        );
    }
    @Test
    void Test3(){

        Profesor profesor = new Profesor("Omer", "Delic");
        Fakultet efsa = new Fakultet();
        Predmet predmet = new Predmet("Fizika", profesor, 33, 45);
        efsa.getPredmeti().add(predmet);
        HashMap<Predmet, Integer> obavezni = new HashMap<>();
        obavezni.put(predmet, 5);

            assertAll(
                () -> assertEquals(1,efsa.getPredmeti().size(), "Provjerava da li je predmet zaveden u fakultet"),
                () ->assertEquals(0, efsa.getCiklusi().size(), "Provjera da li ima ciklusa")
        );
    }
    @Test
    void sveobuhvatniTest(){
        Profesor profesor1=new Profesor("Sanjin", "Mitric");
        Profesor profesor2=new Profesor("Selma", "Kvrgic");
        Profesor profesor3=new Profesor("Melika", "Taric");
        Profesor profesor4=new Profesor("Ejmen", "Tihic");
        Semestar prvi = new Semestar();
        Predmet matematika= new Predmet("matematika", profesor1, 12, 45);
        Predmet mehatronika = new Predmet("mehatornika", profesor2, 10, 40);
        Predmet programiranje = new Predmet("programiranje", profesor3, 12, 45);
        Predmet geodezija = new Predmet("geodezija", profesor4, 12, 45);
        PlanStudija planGff = new PlanStudija();
        planGff.getObavezni().put(matematika, 5);
        planGff.getObavezni().put(geodezija, 5);
        planGff.getObavezni().put(mehatronika,5);
        planGff.getIzborni().put(programiranje,5);
        Student student1 = new Student("Elif", "Hodzic", 14578, planGff);
        Student student2 = new Student("Mirza", "Mihic", 13497, planGff);
        Student student3 = new Student("Sejla", "Vicentiljevic", 13796, planGff);
        prvi.dodajStudenta(student1); prvi.dodajStudenta(student2); prvi.dodajStudenta(student3);
        List<Predmet> listaPredmeta = new ArrayList<>();
        listaPredmeta.add(matematika); listaPredmeta.add(mehatronika); listaPredmeta.add(programiranje); listaPredmeta.add(geodezija);
        Ciklus ciklus = new Ciklus();
        ciklus.dodajSemestar(prvi);
        List<Ciklus> cikluses = new ArrayList<>();
        cikluses.add(ciklus);

        Fakultet gradjevina = new Fakultet(cikluses, listaPredmeta);

        student1.getPlan().upisiOcjenu(matematika, 7);


        assertAll(
                () -> assertEquals(7, gradjevina.dajPrepisOcjenaZaStudenta(student1).get(matematika), "Provjer ocjene"),
                () -> assertEquals(matematika, gradjevina.getPredmeti().get(0), "Provjera da li je predmet zaveden"),
                () -> assertEquals(4, gradjevina.dajProfesoreKojiNemajuNormuUOpsegu().size(), "Provjera profesora"),
                () -> assertTrue(gradjevina.dajSortiraneProfesore().anyMatch(s -> s.getBrojStudenata()>=3)),
                () -> assertFalse(student1.dajOcjene().isEmpty(), "Provjera ima li polozenih"),
                () -> assertFalse(ciklus.getSemstriCiklusa().isEmpty(), "Provjera ima li ciklusa"),
                () -> assertEquals(12,programiranje.getEcts(), "Provjera broja ects"),
                () -> assertEquals(45, profesor3.getNorma(), "Provjera norme"),
                () -> assertEquals("Vicentiljevic", student3.getPrezime(), "Provjera prezime"),
                () -> assertEquals("Elif", student1.getIme(), "Provjera imena"),
                () -> assertEquals(46, planGff.dajEcts(), "Provjera plan studiaj"),
                () -> assertEquals(1, planGff.getIzborni().size(), "Provjera izbornih")
        );

    }

}