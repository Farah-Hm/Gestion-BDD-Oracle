package school;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import helpers.DynamiqueView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.Product;
import model.Refere;

public class GestionConsulting implements Initializable {
	
	@FXML
    private RadioButton concerner;

    @FXML
    private RadioButton contenir;
    @FXML
   private ToggleGroup table;

    @FXML
    private RadioButton refere;

    @FXML
    private RadioButton renfermer;

  

   @FXML
    private AnchorPane anchor_pane;
    
    
    private final String  path="/resource/fxml/";
	
   
    
    @FXML
    void getTable(ActionEvent event) throws SQLException, IOException {
       if(refere.isSelected()) {
    	   
    	   DynamiqueView dynamique = new DynamiqueView();
    	   dynamique.Load(anchor_pane,path+"se_refere.fxml");
			
       }
       else if(renfermer.isSelected()){
    	   DynamiqueView dynamique = new DynamiqueView();
    	   dynamique.Load(anchor_pane,path+"renfremer.fxml");  
       }else if(concerner.isSelected()) {
    	   DynamiqueView dynamique = new DynamiqueView();
    	   dynamique.Load(anchor_pane,path+"concerner.fxml");
       }
       else  {
    	   DynamiqueView dynamique = new DynamiqueView();
    	   dynamique.Load(anchor_pane,path+"contenir.fxml");
       }
    }

	    

				
	
	public void initialize(URL arg0, ResourceBundle arg1) {
		 
	}
	

}
