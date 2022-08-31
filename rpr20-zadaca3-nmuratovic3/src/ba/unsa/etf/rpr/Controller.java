package ba.unsa.etf.rpr;

import javafx.beans.property.Property;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;


public class Controller {
    private String operand="";

    public Slider sliderStudents ;
    public ListView<Student> lvStudents;
    public TextField fldText;

    public void setText(TextField fldText) {
        this.fldText = fldText;
    }

    public Slider getSliderStudents() {
        return sliderStudents;
    }

    public void setSliderStudents(Slider sliderStudents) {
        this.sliderStudents = sliderStudents;
    }

    private Model model;
    public Controller(){
        sliderStudents=new Slider();
        model=new Model();
        labela = new SimpleStringProperty();
        model.napuni();



    }
    @FXML
    public void initialize() {


        sliderStudents.valueProperty().addListener((observable, old, newValue) ->{
            lvStudents.setItems(model.obrisiStudente());
                  //  lvStudents.itemsProperty().unbindBidirectional((Property<ObservableList<Student>>) model.getStudents());
                   lvStudents.setItems(model.dodajStudente((Integer)newValue));
        });
        fldText.textProperty().addListener((observable,old, newValue) ->{
            if(old!=null)
                lvStudents.setItems(model.fiksirajZadnji((Integer.parseInt(newValue))));
        } );
    }




    private SimpleStringProperty labela;

    public String getLabela() {
        return labela.get();
    }

    public SimpleStringProperty labelaProperty() {
        return labela;
    }

    public void setLabela(String labela) {
        this.labela.set(labela);
    }

    public void zero(ActionEvent actionEvent) {
        if(!operand.equals("")){
            operand+="0";
            labela.set(operand);
        }
    }
    public void one(ActionEvent actionEvent) {
        operand+="1";
        labela.set(operand);
    }
    public void two(ActionEvent actionEvent) {
        operand+="2";
        labela.set(operand);
    }
    public void three(ActionEvent actionEvent) {
        operand+="3";
        labela.set(operand);
    }
    public void four(ActionEvent actionEvent) {
        operand+="4";
        labela.set(operand);
    }
    public void five(ActionEvent actionEvent) {
        operand+="5";
        labela.set(operand);
    }
    public void six(ActionEvent actionEvent) {
        operand+="6";
        labela.set(operand);
    }
    public void seven(ActionEvent actionEvent) {
        operand+="7";
        labela.set(operand);
    }

    public void eight(ActionEvent actionEvent) {
        operand+="8";
        labela.set(operand);
    }
    public void nine(ActionEvent actionEvent) {
        operand+="9";
        labela.set(operand);
    }



    public void dodaj(ActionEvent actionEvent) throws IOException {

        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("novi.fxml"));
        stage.setTitle("Prozor");
        stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        stage.show();
    }

    public void last(ActionEvent actionEvent) {
    }
}
