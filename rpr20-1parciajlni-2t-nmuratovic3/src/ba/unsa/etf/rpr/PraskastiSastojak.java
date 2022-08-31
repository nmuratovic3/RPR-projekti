package ba.unsa.etf.rpr;

public class PraskastiSastojak extends Sastojak{
    public PraskastiSastojak(String naziv, int kolicina) {
        super(naziv, kolicina);
    }
    @Override
    public String toString() {
        return getKolicina() + " g " + getNaziv();
    }



    @Override
    public int compareTo(Sastojak a){
        return Double.compare(getKolicina(), a.getKolicina());
    }
}
