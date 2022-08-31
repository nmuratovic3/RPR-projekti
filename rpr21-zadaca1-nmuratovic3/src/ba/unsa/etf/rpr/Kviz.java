package ba.unsa.etf.rpr;


import java.util.ArrayList;
import java.util.*;
import java.util.Map;

enum SistemBodovanja {BINARNO, PARCIJALNO, PARCIJALNO_SA_NEGATIVNIM}

public class Kviz {
    private String naziv;
    private SistemBodovanja sistem;
    private List<Pitanje> pitanja;

    public Kviz(String naziv, SistemBodovanja sistem){
        this.naziv=naziv;
        this.sistem=sistem;
        pitanja = new ArrayList<Pitanje>();
    }

    public void setSistemBodovanja(SistemBodovanja sistem) {
        this.sistem = sistem;
    }

    public void setPitanja(List<Pitanje> pitanja) {
        this.pitanja = pitanja;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public List<Pitanje> getPitanja() {
        return pitanja;
    }

    public SistemBodovanja getSistemBodovanja() {
        return sistem;
    }

    public String getNaziv() {
        return naziv;
    }
    public void dodajPitanje(Pitanje pitanje){
        int vel = pitanja.size();
        for(int i=0; i<vel; i++){
            if(pitanje.getTekst().equalsIgnoreCase(pitanja.get(i).getTekst()))
                throw new IllegalArgumentException("Ne možete dodati pitanje sa tekstom koji već postoji");

        }
        pitanja.add(pitanje);

    }

    @Override
    public String toString() {
        String povratni="Kviz "+ '"' +getNaziv() + '"';
        if(getSistemBodovanja()==SistemBodovanja.BINARNO) povratni+=" boduje se binarno. Pitanja:\n";
        else if(getSistemBodovanja()==SistemBodovanja.PARCIJALNO) povratni+=" boduje se parcijalno. Pitanja:\n";
        else povratni+=" boduje se parcijalno sa negativnim bodovima. Pitanja:\n";
        int i=1;
        for(Pitanje p : pitanja){
            if(i!=1) povratni+="\n\n";
            povratni+=i+". "+p.getTekst()+"("+p.getBrojPoena()+"b)\n";

            povratni+="\ta: "+ p.getOdgovori().get("a").getTekstOdgovora();
            if(p.getOdgovori().get("a").isTacno()) povratni+="(T)";

            povratni+="\n\tb: "+ p.getOdgovori().get("b").getTekstOdgovora();
            if(p.getOdgovori().get("b").isTacno()) povratni+="(T)";

            povratni+="\n\tc: "+ p.getOdgovori().get("c").getTekstOdgovora();
            if(p.getOdgovori().get("c").isTacno()) povratni+="(T)";


            if(p.getOdgovori().containsKey("d")) {
                povratni+="\n\td: "+ p.getOdgovori().get("d").getTekstOdgovora();
                if(p.getOdgovori().get("d").isTacno()) povratni+="(T)";
            }


            i++;

        }
        return  povratni;
    }

    public RezultatKviza predajKviz(Map<Pitanje, ArrayList<String>> zaokruzeniOdgovori) {
        RezultatKviza k = new RezultatKviza(this);
        double rez=0;
        Map<Pitanje, Double> mapa = new HashMap<>() ;

        for(Map.Entry<Pitanje,ArrayList<String>> entry : zaokruzeniOdgovori.entrySet()) {
            double trenutni = entry.getKey().izracunajPoene(entry.getValue(), getSistemBodovanja());

            rez+=trenutni;

            mapa.put(entry.getKey(), trenutni);
        }
        for(int i=0; i<pitanja.size(); i++){
            if(!mapa.containsKey(pitanja.get(i))) mapa.put(pitanja.get(i), 0.);
        }

        k.setBodovi(mapa);
        k.setTotal(rez);
        return k;
    }
}