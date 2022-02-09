package login;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class LoginController  implements Initializable{
    @FXML
    private PasswordField Password;
    
	    @FXML
	    private TextField user;

	    
	    private void clean() {	        
	        user.setText(null);
	        Password.setPromptText("Password");
	        Password.setText(null);

	        
	    }
	    @FXML
	    void login(MouseEvent event) {
               String password1= Password.getText();
               String user1= user.getText();
              
                if(password1.isEmpty() || user1.isEmpty()) {
            	   Alert alert = new Alert(Alert.AlertType.ERROR);
   	            alert.setHeaderText(null);
   	            alert.setContentText("Veuillez remplire tous les champs");
   	            alert.showAndWait();

                }else if(user1.equals("user1")  && password1.equals("12") ) {
            	 try {
        			Parent root= FXMLLoader.load(getClass().getResource("/resource/fxml/Main.fxml"));
        		   Node node=(Node) event.getSource();
        		   Stage stage=(Stage) node.getScene().getWindow();
        		   stage.setScene(new Scene(root));
            	 } catch (IOException e) {
        			// TODO Auto-generated catch block
        			e.printStackTrace();
       		       }
            	 
               }else if(user1.equals("user2")  && password1.equals("1234") ) {
              	 try {
         			Parent root= FXMLLoader.load(getClass().getResource("/school/Employee.fxml"));
         		   Node node=(Node) event.getSource();
         		   Stage stage=(Stage) node.getScene().getWindow();
         		   stage.setScene(new Scene(root));
             	 } catch (IOException e) {
         			// TODO Auto-generated catch block
         			e.printStackTrace();
        		       }
             	 
                }
                else if(user1.equals("user3")  && password1.equals("1235") ) {
               	 try {
           			Parent root= FXMLLoader.load(getClass().getResource("/user3files/fxml/Main.fxml"));
           		   Node node=(Node) event.getSource();
           		   Stage stage=(Stage) node.getScene().getWindow();
           		   stage.setScene(new Scene(root));
               	 } catch (IOException e) {
           			// TODO Auto-generated catch block
           			e.printStackTrace();
          		       }
                  }
               else {
            	   Alert alert = new Alert(Alert.AlertType.ERROR);
            	   alert.setHeaderText(null);
 	            alert.setContentText("Nom d'utilisateur ou Le mot de passe inccorect");
 	            alert.showAndWait();
 	            clean();
 	            }
  
	    }
	@Override
public void initialize(URL arg0, ResourceBundle arg1) {
	// TODO Auto-generated method stub
	
}
}
