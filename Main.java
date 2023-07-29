package fes.aragon;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Pane root = (Pane)FXMLLoader.load(getClass().getResource("/fes/aragon/fxml/Inicio.fxml"));
			Scene scene = new Scene(root);
			Stage escenario = new Stage();
			escenario.setScene(scene);
			escenario.initStyle(StageStyle.UNDECORATED);
			escenario.initModality(Modality.APPLICATION_MODAL);
			// escenario.setX(Screen.getPrimary().getVisualBounds().getMaxX());
			escenario.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void setRoot(String fxml) {
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
