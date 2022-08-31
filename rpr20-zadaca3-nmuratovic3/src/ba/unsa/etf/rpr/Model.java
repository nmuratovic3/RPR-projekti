package ba.unsa.etf.rpr;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Model {
   private ObservableList<Student> students;

    public Model() {
        students = FXCollections.observableArrayList();
    }
    public void napuni(){
        for(int i=1; i<=5; i++)
        students.add(new Student("Student"+i));
    }
    public ObservableList<Student> dodajStudente(int vel){

        for(int i=1; i<=vel; i++) students.add(new Student("student"+i));

        return students;
    }
    public ObservableList<Student>obrisiStudente(){
        students=null;
        return students;
    }
    public ObservableList<Student> fiksirajZadnji(int vel){
        students.remove(students.size()-1);
        students.add(new Student("student"+vel));
        return students;
    }

    public ObservableList<Student> getStudents() {
        return students;
    }

    public void setStudents(ObservableList<Student> students) {
        this.students = students;
    }
    public void setStudents(int value){
        students.removeAll();
        for(int i=1; i<value+1; i++)
            students.add(new Student("student"+i));
    }
}
