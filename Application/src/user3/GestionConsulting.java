package user3;

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
    private RadioButton employe;

    @FXML
    private RadioButton departement;
    @FXML
   private ToggleGroup table;

    @FXML
    private RadioButton bon_livraison;

   
   @FXML
    private AnchorPane anchor_pane;
    
    private Label label;
    Connection connection = null;
    ResultSet resultSet = null;
    PreparedStatement preparedStatement;
    private final String  path="/user3files/fxml/";
	
   
    
    @FXML
    void getTable(ActionEvent event) throws SQLException, IOException {
       if(employe.isSelected()) {
    	   
    	   DynamiqueView dynamique = new DynamiqueView();
    	   dynamique.Load(anchor_pane,path+"employe.fxml");
			
       }
       else if(departement.isSelected()){
    	   DynamiqueView dynamique = new DynamiqueView();
    	   dynamique.Load(anchor_pane,path+"departement.fxml");  
       }else {
    	   DynamiqueView dynamique = new DynamiqueView();
    	   dynamique.Load(anchor_pane,path+"bon_livraison.fxml");
       }
       
    }

	    

				
	
	public void initialize(URL arg0, ResourceBundle arg1) {
		 
	}
	

}
