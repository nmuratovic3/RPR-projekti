package ba.unsa.etf.rpr;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
//        Model model = new Model();
//       model.napuni();
        FXMLLoader loader= new FXMLLoader(getClass().getResource("zadaca2.fxml"));

       // loader.setController(new Controller(model));
        Parent root = loader.load();
        primaryStage.setTitle("Studenti");
        primaryStage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        primaryStage.show();
    }



    public static void main(String[] args) {
        launch(args);
    }
}
