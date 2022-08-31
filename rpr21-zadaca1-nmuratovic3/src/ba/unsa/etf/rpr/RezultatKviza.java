package ba.unsa.etf.rpr;

import java.util.Map;

public class RezultatKviza {
    private Kviz kviz;
    private double total;
    private Map<Pitanje, Double> bodovi;

    public Map<Pitanje, Double> getBodovi() {
        return bodovi;
    }

    public void setBodovi(Map<Pitanje, Double> bodovi) {
        this.bodovi = bodovi;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Kviz getKviz() {
        return kviz;
    }

    public void setKviz(Kviz kviz) {
        this.kviz = kviz;
    }

    public RezultatKviza(Kviz k){
        kviz=k;
        total=0;
    }

    @Override
    public String toString() {
        String s = "Na kvizu " + '"' +kviz.getNaziv() + '"' + " ostvarili ste ukupno "+ getTotal() + " poena. Raspored po pitanjima:";
        for(Map.Entry<Pitanje,Double> entry : bodovi.entrySet()){
            s+= "\n" +  entry.getKey().getTekst()+" - "+ entry.getValue()+"b";
        }
        return  s;
    }
}