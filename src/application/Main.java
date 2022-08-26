package application;
	
import gui.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;


public class Main extends Application {
	
	private static Scene mainScene;
	
	@Override
	public void start(Stage stage) {
		try {
			//Tive que criar um FXMLLoader para poder chamar o Controller e passar o evento de atalho de teclas
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/MainView.fxml"));
			Parent parent = loader.load();
			
			MainController controller = loader.getController();			
			parent.addEventFilter(KeyEvent.KEY_PRESSED, controller.keyShortcut);
			
			mainScene = new Scene(parent);
			stage.setScene(mainScene);
			stage.setTitle("Calculadora - By Rufino");
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Scene getMainScene() {
		return mainScene;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
