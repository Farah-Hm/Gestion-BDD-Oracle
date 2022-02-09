package school;


import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.util.converter.LocalDateStringConverter;
import model.Category;
import model.Product;


public class AddProduct implements Initializable {
	 @FXML
	    private ComboBox<String> category;

	    @FXML
	    private DatePicker date1;

	    @FXML
	    private TextField designation1;
	    @FXML
	    private TextField code1;

	    @FXML
	    private TextField qte_stock1;

	    @FXML
	    private TextField seuil1;

	    @FXML
	    private TextField type1;

	    @FXML
	    private TextField date;
	    private int mini=10;
	    String query = null;
	    private boolean update;

	    Connection connection = null;
	    ResultSet resultSet = null;
	    PreparedStatement preparedStatement;
	    int productCode;

		public ObservableList<String> data= FXCollections.observableArrayList();
	    
	    @FXML
	    void clear(MouseEvent event) {
	    	designation1.clear();
	    	qte_stock1.clear();
	    	seuil1.clear();
	    	type1.clear();
	    	

	    }
     private void verifieQte(int minimal) {
    	
	    
	    	Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Veuillez inserer Quantite Superieur que "+minimal);
            alert.showAndWait();
            
	    
      }
	    @FXML
	    void save(MouseEvent event) {
	    	
	    	Connection con=DbConnect.getInstance().getConnection();
	        String designation= designation1.getText();
	        String code= code1.getText();
	        int qte_stock = Integer.parseInt(qte_stock1.getText());
	        String seuil = seuil1.getText();
	        String date=date1.getEditor().getText();
	        String type = type1.getText();
	        String s = category.getValue();

	        if (code.isEmpty() || designation.isEmpty() || qte_stock1.getText().isEmpty() || seuil .isEmpty() || type.isEmpty() || date.isEmpty()) {
	            Alert alert = new Alert(Alert.AlertType.ERROR);
	            alert.setHeaderText(null);
	            alert.setContentText("Please Fill All DATA");
	            alert.showAndWait();

	        }
	        else if(qte_stock > 0 && qte_stock < mini){
	            verifieQte(mini);	        	
	        }
	        else {
	            getQuery();
	            insert();
	            clean();

	        }

	    }
	    private void clean() {
	        designation1.setText(null);
//	        qte_stock1.setValue(null);
	         
	        qte_stock1.setText(null);
	        seuil1.setText(null);
	        date1.setValue(null);
	        type1.setText(null);
	        code1.setText(null);
	        
	    }

	    
	    @FXML
	    void update(MouseEvent event) {
	    	
	    	Connection con=DbConnect.getInstance().getConnection();
	        String designation= designation1.getText();
	        int qte_stock = Integer.parseInt(qte_stock1.getText());
	        String seuil = seuil1.getText();
	        String date=date1.getEditor().getText();
	        String type = type1.getText();
	        String code = code1.getText();
	        String s = category.getValue();
	        productCode=Integer.parseInt(code1.getText());
	        if (designation.isEmpty() || qte_stock <=0 || seuil .isEmpty() || type.isEmpty() || date.isEmpty()|| code.isEmpty()) {
	            Alert alert = new Alert(Alert.AlertType.ERROR);
	            alert.setHeaderText(null);
	            alert.setContentText("Please Fill All DATA");
	            alert.showAndWait();

	        } 
	        else if(qte_stock > 0 && qte_stock < mini){
	            verifieQte(mini);	        	
	        }else {
	            getQueryUpdate();
	            update();
	            clean();

	        }

	    }
	    private void getQuery() {
	            
	            query = "INSERT INTO SYSTEM.produit( code_pro,designation, qte_stock, date_stock, seuil,type,num_cat) VALUES (?,?,?,?,?,?,?)";

	        
	    }
	    private void getQueryUpdate() {
	    	
	            query = "UPDATE SYSTEM.produit SET designation=?,qte_stock=?,date_stock=?,seuil= ?,type=?,num_cat=? WHERE code_pro = "+productCode;
	       

	    }

	    private void insert() {
	    	Connection connection=DbConnect.getInstance().getConnection();
	        try {
                   int c= category.getSelectionModel().getSelectedIndex();
                   
	            preparedStatement = connection.prepareStatement(query);
	            preparedStatement.setInt(1, Integer.parseInt(code1.getText()));
	            preparedStatement.setString(2, designation1.getText());
	            preparedStatement.setInt(3, Integer.parseInt(qte_stock1.getText()));
	            preparedStatement.setString(4, ((TextField)date1.getEditor()).getText());
	            preparedStatement.setInt(5, Integer.parseInt(seuil1.getText()));
	            preparedStatement.setString(6, type1.getText());
	            preparedStatement.setInt(7, c+1);
	            preparedStatement.execute();
	            Alert alert = new Alert(Alert.AlertType.INFORMATION);
	            alert.setHeaderText(null);
	            alert.setContentText("Votre Produit a ete bien inserer");
	            alert.showAndWait();
//
	        } catch (SQLException ex) {
	            Logger.getLogger(AddProduct.class.getName()).log(Level.SEVERE, null, ex);
	        }

	    }
	    private void update() {
	    	Connection connection=DbConnect.getInstance().getConnection();
	        try {
                   int c= category.getSelectionModel().getSelectedIndex();
                   
	            preparedStatement = connection.prepareStatement(query);
	            preparedStatement.setString(1, designation1.getText());
	            preparedStatement.setInt(2, Integer.parseInt(qte_stock1.getText()));
	            preparedStatement.setString(3, ((TextField)date1.getEditor()).getText());
	            preparedStatement.setInt(4, Integer.parseInt(seuil1.getText()));
	            preparedStatement.setString(5, type1.getText());
	            preparedStatement.setInt(6, c+1);
//	           
	            preparedStatement.execute();
	            Alert alert = new Alert(Alert.AlertType.INFORMATION);
	            alert.setHeaderText(null);
	            alert.setContentText("Votre Produit a ete bien modifier");
	            alert.showAndWait();
//
	        } catch (SQLException ex) {
	            Logger.getLogger(AddProduct.class.getName()).log(Level.SEVERE, null, ex);
	        }

	    }

	    public void setTextField(int code, String designation, int qte_stock, LocalDate date_stock, int seuil,String type) {
     
	    	code1.setText(String.valueOf(code));
	        designation1.setText(designation);
	        qte_stock1.setText(String.valueOf(qte_stock));
	        date1.setValue(date_stock);
	        seuil1.setText(String.valueOf(seuil));
	        type1.setText(type);
	    }


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		try {
 	    	Connection con=DbConnect.getInstance().getConnection();
 		    String sql = "select * from SYSTEM.categorie";
 		    PreparedStatement status= con.prepareStatement(sql);
 		    ResultSet rs=status.executeQuery();
 		    while(rs.next()) {
 		    	data.add(rs.getString("categorie"));
 		    }
 	    }catch(Exception ex) {
 	    	
 	    }
		
	 
		category.setItems(null);
		category.setItems(data);
		
	}

	
}
