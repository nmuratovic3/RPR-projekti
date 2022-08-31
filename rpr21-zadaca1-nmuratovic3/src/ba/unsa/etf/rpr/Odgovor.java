package ba.unsa.etf.rpr;
import java.util.Objects;

public class Odgovor {
    private String tacan_odgovor;
    private boolean tacno;

    public boolean isTacno() {
        return tacno;
    }

    public Odgovor(String tacan_odgovor, boolean b) {
        this.tacan_odgovor=tacan_odgovor;
        tacno=b;
    }
    @Override
    public boolean equals(Object o){
        Odgovor odg = (Odgovor) o;
        return tacan_odgovor.equals(odg.getTekstOdgovora()) && isTacno()== odg.isTacno();
    }
    @Override
    public int hashCode(){
        return Objects.hash(tacan_odgovor,isTacno());

    }

    public String getTekstOdgovora(){
        return tacan_odgovor;
    }

    public void setTekstOdgovora(String tacan_odgovor){
        this.tacan_odgovor = tacan_odgovor;
    }


    public void setTacno(boolean tacno) {
        this.tacno = tacno;
    }
}

