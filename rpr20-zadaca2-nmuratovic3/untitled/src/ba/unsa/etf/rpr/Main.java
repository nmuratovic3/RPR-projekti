package ba.unsa.etf.rpr;

import java.util.*;

public  class Main {//NOPMD
    public static void main(String[] args){
        Profesor p = new Profesor("Davud", "Davic");
        Predmet im1 = new Predmet("Inzenjerska matemaika 1", p, 7, 42);
        Profesor p2 = new Profesor("Dino", "Corovic");
        Predmet if1 = new Predmet("Inzenjerska fizika 1", p2, 5, 36);
        Profesor p3 = new Profesor("Danijel", "Dadic");
        Predmet dm = new Predmet("Diskretna matematika", p3, 7, 42);
        Predmet rpr = new Predmet("Razvoj programskih rjesenja", p, 11, 45);
        HashMap<Predmet,Integer> plan = new HashMap<>();
        plan.put(im1,5);
        plan.put(if1,5);
        plan.put(rpr, 5);
        HashMap<Predmet, Integer> izborni=new HashMap<>();
        izborni.put(dm,5);
        PlanStudija riPrviSem = new PlanStudija(plan, izborni);
        Student s1 = new Student("Senad", "Senadovic", 14578, riPrviSem);
        Student s2 = new Student("Student", "Studentic",14569, riPrviSem);
        Semestar prvi = new Semestar();
        prvi.dodajStudenta(s1);
        prvi.dodajStudenta(s2);
        Ciklus ba = new Ciklus();
        ba.dodajSemestar(prvi);
        List<Ciklus> ciklusi = new ArrayList<>();
        ciklusi.add(ba);
        List<Predmet> predmeti= new ArrayList<>();
        predmeti.add(im1); predmeti.add(if1); predmeti.add(dm);
        Fakultet etf = new Fakultet(ciklusi, predmeti);
        s1.getPlan().upisiOcjenu(im1,10);
        for(Map.Entry<Predmet, Integer> entry : etf.dajPrepisOcjenaZaStudenta(s1).entrySet()){
            System.out.println(entry.getKey().getNazivPredmeta() + " - " + entry.getValue()+"\n");
        }
    }
}
