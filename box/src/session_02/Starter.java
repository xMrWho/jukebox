package session_02;

import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Starter extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		URL url = getClass().getClassLoader().getResource("test/test.fxml"); 
		FXMLLoader loader = new FXMLLoader(url);
		Parent root = loader.load();		
		Scene scene = new Scene(root);
		stage.setTitle("FXML Welcome");
        stage.setScene(scene);
        stage.show();
	}

}
