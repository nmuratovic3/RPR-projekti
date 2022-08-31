package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Kuhar {
    final private HashMap<String, Recept> mapa = new HashMap<>();

    public HashMap<String, Recept> getMapa() {
        return mapa;
    }
    public void dodajRecept(Recept r){
        mapa.put(r.getNazivJela(), r);
    }
    public Recept dajRecept(String naziv){
        return mapa.get(naziv);
    }
    public int brojRecepata() {
        return mapa.size();
    }

    public Kuhar() {
    }
    public ArrayList<Recept> receptiSaSastojkom(Sastojak sastojak){
        return mapa.values().stream().filter(s->s.getSastojci().stream().anyMatch(sastojak1 ->
                sastojak1.getNaziv().equals(sastojak.getNaziv()))).collect(Collectors.toCollection(ArrayList::new));
    }
    public Set<Sastojak> sviSastojci(){
        Set<Sastojak> svi = new TreeSet<>();
        for(Recept r: mapa.values()){
            System.out.println("Recept "+ r.getNazivJela());
            for(Sastojak s: r.getSastojci()){
                System.out.println("Dodajem sastojak: " +s.getNaziv());
                svi.add(s);
            }
        }return svi;
    }
    public ArrayList<Recept> filtriraj(Predicate<Recept> p) {
        return mapa.values().stream().filter(p).collect(Collectors.toCollection(ArrayList::new));
    }
}
