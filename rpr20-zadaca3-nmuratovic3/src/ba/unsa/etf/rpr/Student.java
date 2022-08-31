package ba.unsa.etf.rpr;

import javafx.beans.property.SimpleStringProperty;

public class Student {
    private SimpleStringProperty name = new SimpleStringProperty("");

    public Student(SimpleStringProperty name) {
        this.name = name;
    }
    public Student(String ime){
        name.set(ime);
    }
    @Override
    public String toString(){
        return name.get();
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }
}
