package neustt.fourinarow;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Main application class. The static main method will start the process 
 * to create the JavaFX application. This will then call start(), which 
 * loads the user interface from the specified fxml file. 
 * 
 * @author Neil Taylor (nst@aber.ac.uk)
 */
public class FourInARow extends Application {
    
	/**
	 * Starts the application by loading the user interface from the 
	 * specified FXML file.
	 */
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FourInARow.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setTitle("Four In a Row");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Creates a new instance of the application.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
