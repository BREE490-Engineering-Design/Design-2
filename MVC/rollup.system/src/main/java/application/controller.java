package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.PopupWindow;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class controller implements Initializable {

	private Main main;

    // connect main class to controller
    public void setMain(Main main) {
        this.main = main; 
    }
    
    @FXML
    private void Up1Button(ActionEvent event) throws IOException {
    	//PopupWindow window = PopupWindow.create(main, "javafx", Modality.MORE);
    	//window.setContent(new pop());
    	//window.showWindow();
    	//System.out.println("Hello");
    	Parent root = FXMLLoader.load(getClass().getResource("pop.fxml"));
		/*Scene scene = new Scene(root);
		//scene.getStylesheets().add("/application/style.css");
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.initOwner(primaryStage);
		//stage.initStyle(StageStyle.UTILITY);
		stage.setTitle("Popup");
		stage.setScene(scene);
		stage.setFullScreen(true);
		stage.show();*/
		Main.showPopUp(root);
    	
    }
    
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    

    @FXML
    void initialize() {

    	
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
}
