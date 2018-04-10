package neustt.fourinarow;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 * Creates a Dialog that uses the FXML file for the dialog. 
 * 
 * @author Neil Taylor (nst@aber.ac.uk)
 */
public class FourInARowDialogController implements Initializable {
    
	/** Button to close the dialog. */
    @FXML 
    private Button closeButton;
    
    /**
     * Creates and displays the About dialog. The User interface is specified 
     * in the FXML file. 
     * 
     * @param window The parent window for the dialog. This dialog will be displayed 
     * as a modal dialog in the middle of the window. 
     */
    public void showDialog(Window window) { 
        try { 
           Stage stage = new Stage();
           Parent root = FXMLLoader.load(getClass().getResource("AboutDialog.fxml"));
           
           stage.setScene(new Scene(root));
           stage.setTitle("About");
           stage.initModality(Modality.WINDOW_MODAL);
           stage.initOwner(window);
           stage.show();
        }
        catch(IOException e) { 
            System.err.println("There is something wrong here...");
            e.printStackTrace();
        }
    }
   
    /**
     * Closes the dialog and removes it from the screen. 
     * 
     * @param event The action event. This isn't used by the method.
     */
    @FXML
    public void  handleAboutDialogAction(ActionEvent event) {
        closeButton.getScene().getWindow().hide();
    }

    /** 
     * Used method that is required by the Initializable interface.
     * @param location Required for the Java interface. 
     * @param resources Required for the Java interface. 
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
}
