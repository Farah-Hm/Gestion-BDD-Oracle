package login;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainApp extends Application 
{
	  private double xoffset;
	  private double yoffset;
	

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		Parent root = FXMLLoader.load(getClass().getResource("/loginFiles/fxml/login.fxml"));
		root.setOnMousePressed(event ->{
			xoffset=event.getSceneX();
			yoffset=event.getSceneY();
		});
		root.setOnMouseDragged(e->{
			stage.setX(e.getScreenX()-xoffset);
			stage.setY(e.getScreenY()-yoffset);
		});
		Scene scene = new Scene(root);
		
		stage.setScene(scene);
		
		
		stage.initStyle(StageStyle.UTILITY);
		stage.centerOnScreen();
		stage.show();
		
	}

}
