package ba.unsa.etf.rpr;
import java.util.HashMap;
import java.util.Map;


public class PlanStudija {
    private Map<Predmet, Integer> obavezni;
    private Map<Predmet, Integer> izborni;

    public PlanStudija(Map<Predmet, Integer> obavezni, Map<Predmet, Integer> izborni) {
    
        this.obavezni = new HashMap<>(obavezni);
        this.izborni = new HashMap<>(izborni);
        //if(dajEcts()<MIN) throw new IllegalArgumentException();
    }

    public PlanStudija() {
        this.obavezni=new HashMap<>();
        this.izborni=new HashMap<>();
    }

    public PlanStudija(PlanStudija p){
        this.obavezni = new HashMap<>(p.obavezni);
        this.izborni = new HashMap<>(p.izborni);
    }
    public void upisiOcjenu(Predmet p, int ocjena){
        if(getObavezni().containsKey(p)) getObavezni().put(p, ocjena);
        else if(getIzborni().containsKey(p)) getIzborni().put(p, ocjena);
    }

    public void dodajStudentaNaPredmetima(Map<Predmet, Integer> predmeti){
        for(Map.Entry<Predmet,Integer>entry : predmeti.entrySet())
            entry.getKey().dodajStudenta();
    }

    public Map<Predmet, Integer> getObavezni() {
        return obavezni;
    }

    public void setObavezni(Map<Predmet, Integer> obavezni) {
        this.obavezni = obavezni;
    }

    public Map<Predmet, Integer> getIzborni() {
        return izborni;
    }

    public void setIzborni(Map<Predmet, Integer> izborni) {
        this.izborni = izborni;
    }
    public int dajEcts(){
        int suma=0;
        for(Map.Entry<Predmet,Integer>entry : obavezni.entrySet()){
            suma += entry.getKey().getEcts();
        }
        for(Map.Entry<Predmet,Integer>entry : izborni.entrySet()){
            suma += entry.getKey().getEcts();
        }
        return suma;
    }
}