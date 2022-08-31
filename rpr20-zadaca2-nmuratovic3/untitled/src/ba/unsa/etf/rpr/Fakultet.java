package ba.unsa.etf.rpr;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;


public class Fakultet {
    public void setCiklusi(List<Ciklus> ciklusi) {
        this.ciklusi = ciklusi;
    }

    public void setPredmeti(List<Predmet> predmeti) {
        this.predmeti = predmeti;
    }

    private List<Ciklus> ciklusi;
    private List<Predmet> predmeti;

    public Fakultet(List<Ciklus> ciklusi, List<Predmet> predmeti) {
        this.ciklusi = ciklusi;
        this.predmeti=predmeti;
    }

    public Fakultet() {
        ciklusi = new ArrayList<>();
        predmeti = new ArrayList<>();
    }

    public List<Predmet> getPredmeti() {
        return predmeti;
    }

    public List<Ciklus> getCiklusi() {
        return ciklusi;
    }

    public List<Profesor> dajProfesoreKojiNemajuNormuUOpsegu(){
        List<Profesor> profesori = new ArrayList<>();
        for(Predmet p: predmeti){
            if((p.getProfesor().getNorma()<120 || p.getProfesor().getNorma()>150) &&
                    !provjeriImaLiOvajProfesor(profesori, p.getProfesor())) profesori.add(p.getProfesor());
        }
        return  profesori;
    }
    private boolean provjeriImaLiOvajProfesor(List<Profesor> profesors, Profesor provjera){
        return profesors.stream().anyMatch(s -> s.equals(provjera));

    }
    public Stream<Profesor> dajSortiraneProfesore(){
        ArrayList<Profesor> profesori = new ArrayList<>();
        for(Predmet p: predmeti){
            if(!provjeriImaLiOvajProfesor(profesori, p.getProfesor())) profesori.add(p.getProfesor());
        }
        return profesori.stream().sorted(Profesor::compareTo);

    }
    public Map<Predmet, Integer> dajPrepisOcjenaZaStudenta(Student s){
        return s.dajOcjene();
    }




}
