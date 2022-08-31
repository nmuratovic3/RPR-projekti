package ba.unsa.etf.rpr;
import java.util.HashMap;
import java.util.Map;

public class Student {
    private String ime;
    private String prezime;
    private int brojIndeksa;
    private PlanStudija plan;
    private final static int MIN = 30;
    public Student(String ime, String prezime, int indeks, PlanStudija plan) {
        this.ime=ime;
        this.prezime=prezime;
        this.brojIndeksa=indeks;
        this.plan= new PlanStudija(plan);
        plan.dodajStudentaNaPredmetima(plan.getIzborni());
        plan.dodajStudentaNaPredmetima(plan.getObavezni());
        if(plan.dajEcts()<MIN) throw new IllegalArgumentException();
    }

    public PlanStudija getPlan() {

        return plan;
    }


    public void setPlan(PlanStudija plan) {

        this.plan = plan;
    }
    public Map<Predmet, Integer> dajOcjene(){
        HashMap<Predmet, Integer> ocjenePolozenih=new HashMap<>();
        dodajPolozene(plan.getIzborni(),ocjenePolozenih);
        dodajPolozene(plan.getObavezni(), ocjenePolozenih);
        return ocjenePolozenih;
    }
    public void dodajPolozene(Map<Predmet, Integer> pretraga, Map<Predmet, Integer> cilj){

        for(Map.Entry<Predmet,Integer>entry : pretraga.entrySet()){
            if(entry.getValue()==5) continue;
                cilj.put(entry.getKey(), entry.getValue());//NOPMD
        }
    }

    public int getBrojIndeksa() {
        return brojIndeksa;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public void setBrojIndeksa(int brojIndeksa) {
        this.brojIndeksa = brojIndeksa;
    }


}
