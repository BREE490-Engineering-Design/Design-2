package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;

public class controller {

	private Main main;

    // connect main class to controller
    public void setMain(Main main) {
        this.main = main; 
    }
    
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    void initialize() {

    	
    }
}
