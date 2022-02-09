	package helpers;
	import java.io.IOException;
	import java.net.URL;
	import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
	import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import school.GestionProduct;
	
public class DynamiqueView  {


				
			
		    public void Load(AnchorPane anchor,String path) throws IOException {
		    	 anchor.getChildren().clear();
		    	Parent root= FXMLLoader.load(getClass().getResource(path));
		        
				 // List should stretch as anchorPane is resized
			    
			     AnchorPane.setTopAnchor(root,0.0);
			     AnchorPane.setLeftAnchor(root, 0.0);
			     AnchorPane.setRightAnchor(root, 0.0);
			    
			     AnchorPane.setTopAnchor(root, 0.0);
			     AnchorPane.setRightAnchor(root, 0.0);
			     anchor.getChildren().add(root);
			}
		    
		    public void LoadPage(String ressource,MouseEvent event) throws IOException {
		    	
		    	try {
					Parent root= FXMLLoader.load(getClass().getResource("/ressource/fxml/"+ressource));
				   Node node=(Node) event.getSource();
				   Stage stage=(Stage) node.getScene().getWindow();
				   stage.setScene(new Scene(root));
		    	 } catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        
				 // List should stretch as anchorPane is resized
			    
			    
			}
			 
			   public void LoadPageFree(MouseEvent event,String ressource) throws IOException {
			    	  try {
			              Parent parent = FXMLLoader.load(getClass().getResource("/resource/fxml/"+ressource));
			              Scene scene = new Scene(parent);
			              Stage stage = new Stage();
			              stage.setScene(scene);
			              stage.initStyle(StageStyle.UTILITY);
			              stage.show();
			          } catch (IOException ex) {
			              Logger.getLogger(GestionProduct.class.getName()).log(Level.SEVERE, null, ex);
			          }
			          
					  
					  
					
				}

		}




