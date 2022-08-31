package ba.unsa.etf.rpr;

public abstract class Sastojak implements Comparable<Sastojak>{
    private String naziv;
    private int kolicina=0;

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public String getNaziv() {
        return naziv;
    }

    public int getKolicina() {
        return kolicina;
    }

    public Sastojak(String naziv, int kolicina) {
        this.naziv = naziv;
        this.kolicina = kolicina;
    }

}
