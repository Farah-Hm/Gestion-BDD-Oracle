package school;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import helpers.DynamiqueView;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.stage.Stage;

public class MainController  implements Initializable {
 @FXML
 private AnchorPane anchor;
 @FXML
 private TextField password;

 private TextField user;
 @FXML
 private Button logout;
 private final String path ="/resource/fxml/";
 private double xoffset;
 private double yoffset;
 @FXML
 void referer(MouseEvent event) throws IOException {
	 DynamiqueView dynamique = new DynamiqueView();
 	dynamique.Load(anchor, path+"se_refere.fxml");
 }
    @FXML
    void logout(MouseEvent event) throws IOException {

    
    	try {
			Parent root= FXMLLoader.load(getClass().getResource("/loginFiles/fxml/login.fxml"));
		   Node node=(Node) event.getSource();
		   Stage stage=(Stage) node.getScene().getWindow();
		   stage.setScene(new Scene(root));
    	 } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
        

    }
    @FXML
	   public void category(MouseEvent event) throws IOException {
    	DynamiqueView dynamique = new DynamiqueView();
    	dynamique.Load(anchor, path+"categories.fxml");
	    }

	    @FXML
	  public void consulte(MouseEvent event) throws IOException {
	    	DynamiqueView dynamique = new DynamiqueView();
	    	dynamique.Load(anchor, path+"consulter.fxml");

	    }
	    @FXML
      public void product(MouseEvent event) throws IOException {
	    	DynamiqueView dynamique = new DynamiqueView();
	    	dynamique.Load(anchor,path+"products.fxml");
	    }
	    @FXML
	    void fermer(MouseEvent event) {
           System.exit(0);
	    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
	}
	

}
