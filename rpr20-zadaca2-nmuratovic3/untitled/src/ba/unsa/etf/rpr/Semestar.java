package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.List;


public class Semestar {
    private List<Student> semestralniStudenti;

    public Semestar() {
        this.semestralniStudenti = new ArrayList<>();
    }

    public List<Student> getSemestralniStudenti() {
        return semestralniStudenti;
    }

    public void setSemestralniStudenti(List<Student> semestralniStudenti) {
        this.semestralniStudenti = semestralniStudenti;
    }
    public void dodajStudenta(Student s){
        semestralniStudenti.add(s);
    }
}
