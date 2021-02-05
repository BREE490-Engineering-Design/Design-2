package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	public static Stage primaryStage;
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryS) throws Exception {
		this.primaryStage = primaryS;
		
		Parent root = FXMLLoader.load(getClass().getResource("Sample_2.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add("/application/style.css");
		primaryStage.setScene(scene);
		primaryStage.setFullScreen(true);
		primaryStage.show();
	}
	
	public static void showPopUp(Parent root) {
		
		Scene scene = new Scene(root);
		//scene.getStylesheets().add("/application/style.css");
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.initOwner(primaryStage);
		//stage.initStyle(StageStyle.UTILITY);
		stage.setTitle("Popup");
		stage.setScene(scene);
		//stage.setFullScreen(true);
		stage.show();
	}

}
