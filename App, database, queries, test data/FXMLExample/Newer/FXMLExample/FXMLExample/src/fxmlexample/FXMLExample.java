
package fxmlexample;
 
import java.sql.*;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
 
public class FXMLExample extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("AIFitness Login");
        
        Parent root = FXMLLoader.load(getClass().getResource("GUIStyle.fxml"),
            ResourceBundle.getBundle("fxmlexample.fxml_example"));        
        Scene scene = new Scene(root, 400, 430);
        stage.setScene(scene);
        stage.show();
    }
 
    public static void main(String[] args) {
        launch(args);
    }
}
