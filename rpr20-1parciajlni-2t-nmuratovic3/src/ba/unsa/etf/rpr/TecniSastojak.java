package ba.unsa.etf.rpr;

public class TecniSastojak extends Sastojak{
        public TecniSastojak(String naziv, int kolicina) {
            super(naziv, kolicina);
        }


        @Override
        public int compareTo(Sastojak a){
            return Double.compare(getKolicina(), a.getKolicina());
        }

    @Override
    public String toString() {
        return getKolicina() + " dl " + getNaziv();
    }

}

