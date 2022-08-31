package ba.unsa.etf.rpr;


public class Profesor {
    private String ime;
    private String prezime;
    private int norma;
    private int brojStudenata;

    public Profesor(String ime, String prezime) {
        this.ime = ime;
        this.prezime = prezime;
        this.norma = 0;
    }

    public int getBrojStudenata() {
        return brojStudenata;
    }

    public void setBrojStudenata(int brojStudenata) {
        this.brojStudenata = brojStudenata;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public int getNorma() {
        return norma;
    }

    public void setNorma(int norma) {
        this.norma = norma;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }




    public int compareTo(Profesor o2) {
        if(getNorma()>o2.getNorma()) return getNorma();
        else if(getNorma()<o2.getNorma()) return -o2.getNorma();
        else if(getBrojStudenata()> o2.getBrojStudenata()) return 1;
        return -1;

    }
}
