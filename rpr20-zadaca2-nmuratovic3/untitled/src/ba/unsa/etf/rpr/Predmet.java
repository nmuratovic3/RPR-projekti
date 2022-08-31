package ba.unsa.etf.rpr;

public class Predmet {
    private String nazivPredmeta;
    private final Profesor profesor;
    private int ects;
    private int brojCasova;
    private int brojStudenata;

    public Predmet(String nazivPredmeta, Profesor profesor, int ects, int brojCasova) {
        this.nazivPredmeta = nazivPredmeta;
        this.profesor = profesor;
        this.ects = ects;
        this.brojCasova = brojCasova;
        this.brojStudenata = 0;
        profesor.setNorma(profesor.getNorma()+brojCasova);
    }

    public int getBrojStudenata() {
        return brojStudenata;
    }

    public void setBrojStudenata(int brojStudenata) {
        this.brojStudenata = brojStudenata;
    }

    public int getBrojCasova() {
        return brojCasova;
    }

    public void setBrojCasova(int brojCasova) {
        this.brojCasova = brojCasova;
    }

    public int getEcts() {
        return ects;
    }

    public void setEcts(int ects) {
        this.ects = ects;
    }

    public String getNazivPredmeta() {
        return nazivPredmeta;
    }

    public void setNazivPredmeta(String nazivPredmeta) {
        this.nazivPredmeta = nazivPredmeta;
    }

    public Profesor getProfesor() {

        return profesor;
    }

    public void dodajStudenta() {
        brojStudenata+=1;
        profesor.setBrojStudenata(profesor.getBrojStudenata()+1);

    }
}
