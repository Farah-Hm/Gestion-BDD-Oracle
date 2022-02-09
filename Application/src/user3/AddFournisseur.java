package user3;

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
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import school.AddProduct;
import school.DbConnect;

public class AddFournisseur implements Initializable {


	    @FXML
	    private TextField code_fournisseur;
	    @FXML
	    private TextField nom_fournisseur;

	    @FXML
	    private TextField num_compte;
	    
	    @FXML
	    private TextField num_tel;
	    
	    String query = null;
	    private boolean update;

	    Connection connection = null;
	    ResultSet resultSet = null;
	    PreparedStatement preparedStatement;
	    int fournisseurCode;

		public ObservableList<String> data= FXCollections.observableArrayList();
	    
	    @FXML
	    void clear(MouseEvent event) {
	    	code_fournisseur.clear();
	    	nom_fournisseur.clear();
	    	num_compte.clear();
	    	num_tel.clear();
	    	

	    }

	    @FXML
	    void save(MouseEvent event) {
	    	Connection con=DbConnect.getInstance().getConnection();
	        String code_fournisseur1= code_fournisseur.getText();
	        String nom_fournisseur1 = nom_fournisseur.getText();
	        String num_compte1 = num_compte.getText();
	        String num_tel1=num_tel.getText();
	        
	        if (code_fournisseur1.isEmpty() || nom_fournisseur1.isEmpty() ||
	        		num_compte1.isEmpty() || num_tel1.isEmpty() ) {
	            Alert alert = new Alert(Alert.AlertType.ERROR);
	            alert.setHeaderText(null);
	            alert.setContentText("Veuillez remplire tout les champs");
	            alert.showAndWait();

	        } else {
	            getQuery();
	            insert();
	            clean();

	        }

	    }
	    private void clean() {
	        code_fournisseur.setText(null);
 	        nom_fournisseur.setText(null);
	        num_compte.setText(null);
	        num_tel.setText(null);
	        
	    }

	    
	    @FXML
	    void update(MouseEvent event) {
	    	
	    	Connection con=DbConnect.getInstance().getConnection();
	        String code_fournisseur1= code_fournisseur.getText();
	        String nom_fournisseur1 = nom_fournisseur.getText();
	        int num_compte1 = Integer.parseInt(num_compte.getText());
	        int num_tel1=Integer.parseInt(num_tel.getText());
	        fournisseurCode=Integer.parseInt(code_fournisseur.getText());
	        if (code_fournisseur1.isEmpty() || num_compte1 <=0 || nom_fournisseur1.isEmpty() ||  num_tel1 <=0) {
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
	            
	            query = "INSERT INTO SYSTEM.fournisseur( code_fournisseur, nom_fournisseur, num_compte, num_tel) VALUES (?,?,?,?)";

	        
	    }
	    private void getQueryUpdate() {
	    	
	            query = "UPDATE SYSTEM.fournisseur SET "
	            		+ "nom_fournisseur =?,"
	                    + "num_compte=?,"
	                    + "num_tel=?"                    
	                    +" WHERE code_fournisseur = "+fournisseurCode;
	       

	    }

	    private void insert() {
	    	Connection connection=DbConnect.getInstance().getConnection();
	        try {
                
                
	            preparedStatement = connection.prepareStatement(query);
	            preparedStatement.setInt(1, Integer.parseInt(code_fournisseur.getText()));
	            preparedStatement.setString(2, nom_fournisseur.getText());
	            preparedStatement.setInt(3, Integer.parseInt(num_compte.getText()));
	            preparedStatement.setInt(4, Integer.parseInt(num_tel.getText()));
	           
	            preparedStatement.execute();
	            Alert alert = new Alert(Alert.AlertType.INFORMATION);
	            alert.setHeaderText(null);
	            alert.setContentText("Votre Fournisseur a ete bien inserer");
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
	            
	            preparedStatement.setString(1, nom_fournisseur.getText());
	            preparedStatement.setInt(2, Integer.parseInt(num_compte.getText()));
	            preparedStatement.setInt(3, Integer.parseInt(num_tel.getText()));
	            
	            preparedStatement.execute();
	            Alert alert = new Alert(Alert.AlertType.INFORMATION);
	            alert.setHeaderText(null);
	            alert.setContentText("Votre Fournisseur a ete bien modifier");
	            alert.showAndWait();
//
	        } catch (SQLException ex) {
	            Logger.getLogger(AddProduct.class.getName()).log(Level.SEVERE, null, ex);
	        }

	    }

	    public void setTextField(int code, String nom, int compte,  int tel) {
  
	    	code_fournisseur.setText(String.valueOf(code));
	        nom_fournisseur.setText(nom);
	        num_compte.setText(String.valueOf(compte));
	        num_tel.setText(String.valueOf(tel));
	        
	    }


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
}
