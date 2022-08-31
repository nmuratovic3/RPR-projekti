package ba.unsa.etf.rpr;
import java.util.HashMap;
import java.util.*;



public class Pitanje {
    private String tekst;
    private double brojPoena;
    private HashMap<String, Odgovor> odgovori;
    public Pitanje(String s, double brojPoena) {
        tekst=s;
        this.brojPoena=brojPoena;
        odgovori= new HashMap<>();
    }
    public void dodajOdgovor(String id, String tekst, boolean tacno){
        if(odgovori.containsKey(id))
            throw new IllegalArgumentException("Id odgovora mora biti jedinstven");
        Odgovor a= new Odgovor(tekst, tacno);
        odgovori.put(id, a);
    }

    @Override
    public String toString() {
        String s=getTekst() + "("+getBrojPoena()+"b)\n";
        s+="\ta: "+getOdgovori().get("a").getTekstOdgovora()+"\n";
        s+="\tb: "+getOdgovori().get("b").getTekstOdgovora()+"\n";
        s+="\tc: "+getOdgovori().get("c").getTekstOdgovora();
        if(getOdgovori().containsKey("d")) s+="\n\td: "+odgovori.get("d").getTekstOdgovora();
        return  s;

    }

    public void obrisiOdgovor(String id) throws  IllegalArgumentException{
        if(!odgovori.containsKey(id))
            throw new IllegalArgumentException("Odgovor s ovim id-em ne postoji");
        odgovori.remove(id);

    }
    public ArrayList<Odgovor>  dajListuOdgovora(){
        ArrayList<Odgovor> lista=new ArrayList<>();
        for(Odgovor o: odgovori.values()){

            Odgovor moj_odgovor = new Odgovor(o.getTekstOdgovora(), o.isTacno());
            lista.add(moj_odgovor);
        }

        return  lista;
    }
    public double izracunajPoene(List<String> lista, SistemBodovanja a) throws IllegalArgumentException {

        for (String o : lista) {
            if (!odgovori.containsKey(o)) throw new IllegalArgumentException("Odabran je nepostojeći odgovor");
        }
        for (int i = 0; i < lista.size(); i++)
            for (int j = i + 1; j < lista.size(); j++)
                if (lista.get(i).equals( lista.get(j)))
                    throw new IllegalArgumentException("Postoje duplikati među odabranim odgovorima");


        int broj_tacnih = 0;
        for (int i = 0; i < lista.size(); i++) {
            if (odgovori.get(lista.get(i)).isTacno()) broj_tacnih = broj_tacnih + 1;
            else if(a.equals(SistemBodovanja.PARCIJALNO_SA_NEGATIVNIM)) return (double)-brojPoena/2;
            else return  0;
        }
        int stvarni_broj = 0;
        for (Odgovor o : odgovori.values()) if (o.isTacno()) stvarni_broj = stvarni_broj + 1;
        if (a.equals(SistemBodovanja.BINARNO)) {
            if (broj_tacnih == stvarni_broj) return brojPoena;
        } else if(stvarni_broj==broj_tacnih) return  brojPoena;
        else if (odgovori.size()!=0){
            return (double) brojPoena / odgovori.size() * broj_tacnih;}

        return 0;

    }

    public double getBrojPoena() {
        return brojPoena;
    }

    public String getTekst() {
        return tekst;
    }

    public void setBrojPoena(double i) {
        this.brojPoena=i;
    }

    public HashMap<String, Odgovor> getOdgovori() {
        return odgovori;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }
}