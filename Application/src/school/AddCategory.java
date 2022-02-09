package school;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class AddCategory implements Initializable {

	
		    @FXML
	    private TextField code;
	    @FXML
	    private TextField titre;
	   
	    String query = null;
	    private boolean update;
	    Connection connection = null;
	    ResultSet resultSet = null;
	    PreparedStatement preparedStatement;
	    int categoryCode;

		public ObservableList<String> data= FXCollections.observableArrayList();
	    
	    @FXML
	    void clear(MouseEvent event) {
	    	code.clear();
	    	titre.clear();
	    }

	    @FXML
	    void save(MouseEvent event) {
	    	Connection con=DbConnect.getInstance().getConnection();
	        String code1= code.getText();
	        String titre1 = titre.getText();
	        

	        if (code1.isEmpty() || titre1.isEmpty() ) {
	            Alert alert = new Alert(Alert.AlertType.ERROR);
	            alert.setHeaderText(null);
	            alert.setContentText("Please Fill All DATA");
	            alert.showAndWait();

	        } else {
	            getQuery();
	            insert();
	            clean();

	        }

	    }
	    private void clean() {	        
	        code.setText(null);
	        titre.setText(null);

	        
	    }

	    @FXML
	    void update(MouseEvent event) {
	    	
	    	Connection con=DbConnect.getInstance().getConnection();
	        String code1= code.getText();
	        String titre1 = titre.getText();
	        categoryCode=Integer.parseInt(code.getText());
	        if (code1.isEmpty() || titre1.isEmpty()) {
	            Alert alert = new Alert(Alert.AlertType.ERROR);
	            alert.setHeaderText(null);
	            alert.setContentText("Please Fill All DATA");
	            alert.showAndWait();

	        } else {
	            getQueryUpdate();
	            update();
	            clean();

	        }

	    }
	    private void getQuery() {
	            
	            query = "INSERT INTO SYSTEM.categorie ( num_cat, categorie) VALUES (?,?)";

	        
	    }
	    private void getQueryUpdate() {
	    	
	            query = "UPDATE SYSTEM.categorie SET "
	                    + "categorie=?"
	                    +" WHERE num_cat = "+categoryCode;
	       

	    }

	    private void insert() {
	    	Connection connection=DbConnect.getInstance().getConnection();
	        try {
               
	       
	            preparedStatement = connection.prepareStatement(query);
	            preparedStatement.setInt(1,Integer.parseInt(code.getText()));
	            preparedStatement.setString(2, titre.getText());
	            preparedStatement.execute();
	            
	            Alert alert = new Alert(Alert.AlertType.INFORMATION);
	            alert.setHeaderText(null);
	            alert.setContentText("Votre Categorie a ete bien inserer");
	            alert.showAndWait();
//
	        } catch (SQLException ex) {
	            Logger.getLogger(AddProduct.class.getName()).log(Level.SEVERE, null, ex);
	        }

	    }
	    private void update() {
	    	Connection connection=DbConnect.getInstance().getConnection();
	        try {
                
	            preparedStatement = connection.prepareStatement(query);
	            preparedStatement.setString(1, titre.getText());
	            
 	            preparedStatement.execute();
	            Alert alert = new Alert(Alert.AlertType.INFORMATION);
	            alert.setHeaderText(null);
	            alert.setContentText("Votre Categorie a ete bien modifier");
	            alert.showAndWait();
//
	        } catch (SQLException ex) {
	            Logger.getLogger(AddProduct.class.getName()).log(Level.SEVERE, null, ex);
	        }

	    }

	    public void setTextField(int code1, String titre1) {
  
	    	code.setText(String.valueOf(code1));
	    	titre.setText(titre1);
	        
	    }


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
	}

}
