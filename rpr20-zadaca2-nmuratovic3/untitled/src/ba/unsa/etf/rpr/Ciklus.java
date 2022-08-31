package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.List;

public class Ciklus {
    private List<Semestar> semstriCiklusa;

    public void setSemstriCiklusa(List<Semestar> semstriCiklusa) {
        this.semstriCiklusa = semstriCiklusa;
    }

    public Ciklus(List<Semestar> semstriCiklusa) {
        this.semstriCiklusa = semstriCiklusa;
    }

    public Ciklus() {
        semstriCiklusa = new ArrayList<>();
    }

    public void dodajSemestar(Semestar s){
        semstriCiklusa.add(s);
    }

    public List<Semestar> getSemstriCiklusa() {

        return semstriCiklusa;
    }
    public Semestar dajSemestar(int i){
        return getSemstriCiklusa().get(i);
    }


}
