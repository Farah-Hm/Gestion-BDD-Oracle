package user3;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Employe;
import model.Fournisseur;
import school.DbConnect;

public class Employes implements Initializable  {
	@FXML
    private TableColumn< Employe,Integer> code_emp;

    @FXML 
    private TableColumn< Employe,String> nom_emp;
    @FXML 
    private TableColumn< Employe,String> prenom_emp;
    @FXML 
    private TableColumn< Employe,String> grade_emp;
    @FXML 
    private TableColumn< Employe,String> fonction;
    @FXML 
    private TableColumn< Employe,String> intitule;
    
    @FXML
    private TextField searchbar;
    
    
    @FXML
    private TableView<Employe> table;
 
 Connection connection = null;
    ResultSet resultSet = null;
    PreparedStatement preparedStatement;
    public ObservableList<Employe> data= FXCollections.observableArrayList();
@Override
public void initialize(URL arg0, ResourceBundle arg1) {
	 Connection connection=DbConnect.getInstance().getConnection();
	 String sql = "SELECT * from emp1 ,dep1 WHERE emp1.code_dep=dep1.code_dep";
	    try {
			preparedStatement = connection.prepareStatement(sql);
			  resultSet = preparedStatement.executeQuery();
			    while(resultSet.next()) {
		    	data.add(new Employe(resultSet.getInt("code_emp"),resultSet.getString("nom_emp"),
		    			resultSet.getString("prenom_emp"),resultSet.getString("grade_emp"),
		    			resultSet.getString("fonction"),resultSet.getString("intitulé_dep")
		    			));
		    	}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   
	   
	    
	   code_emp.setCellValueFactory(new PropertyValueFactory<Employe,Integer>("code_emp"));	 
	  nom_emp.setCellValueFactory(new PropertyValueFactory<Employe,String>("nom_emp"));
    	 prenom_emp.setCellValueFactory(new PropertyValueFactory<Employe,String>("prenom_emp"));
    	 grade_emp.setCellValueFactory(new PropertyValueFactory<Employe,String>("grade_emp"));
    	 fonction.setCellValueFactory(new PropertyValueFactory<Employe,String>("fonction"));
    	 intitule.setCellValueFactory(new PropertyValueFactory<Employe,String>("intitulé_dep"));
    	table.setItems(data);
    	FilteredList<Employe> filteredData= new FilteredList<>(data,  b ->true);
	    	 searchbar.textProperty().addListener((observable,oldValue,newValue)->{
	    		 filteredData.setPredicate(data->{
	    			if(newValue.isEmpty() || newValue.isBlank() ||newValue ==null  ) {
	    				return true;
	    			}
	    			String searchKeyword = newValue.toLowerCase();
	    			if (data.getNom_emp().toLowerCase().indexOf(searchKeyword) > -1) {
	    				return true;
	    			}
	    			else if (data.getPrenom_emp().toLowerCase().indexOf(searchKeyword) > -1) {
	    				return true;
	    			}
	    			else if (data.getGrade_emp().toLowerCase().indexOf(searchKeyword) > -1) {
	    				return true;
	    			}
	    			else if (data.getFonction().toLowerCase().indexOf(searchKeyword) > -1) {
	    				return true;
	    			}
	    			else if (data.getIntitulé_dep().toLowerCase().indexOf(searchKeyword) > -1) {
	    				return true;
	    			}
	    			
	    			
	    			else {
	    				return false;
	    			}
	    			
	    		 });
	    	 });
	    	 SortedList<Employe> sortedData = new SortedList<>(filteredData);
	    	 sortedData.comparatorProperty().bind(table.comparatorProperty());
	    	 table.setItems(sortedData);


	
	
}

}
