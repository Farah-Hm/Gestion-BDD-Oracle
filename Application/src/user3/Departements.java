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
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Departement;
import model.Employe;
import model.Refere;
import school.DbConnect;

public class Departements implements Initializable {
	@FXML
    private TableColumn< Departement,Integer> code_dep;

    @FXML
    private TableColumn< Departement,String> intitule;
    @FXML
    private TableColumn< Departement,String> nom_chef;
    @FXML
    private TableColumn< Departement,String> prenom_chef;

    @FXML
    private TextField searchbar;
    
    @FXML
    private TableView<Departement> table;
    
    
 Connection connection = null;
    ResultSet resultSet = null;
    PreparedStatement preparedStatement;
    public ObservableList<Departement> data= FXCollections.observableArrayList();
@Override
public void initialize(URL arg0, ResourceBundle arg1) {
	 Connection connection=DbConnect.getInstance().getConnection();
	 String sql = "SELECT * from dep1";
	    try {
			preparedStatement = connection.prepareStatement(sql);
			  resultSet = preparedStatement.executeQuery();
			    while(resultSet.next()) {
		    	data.add(new Departement(resultSet.getInt("code_dep"),resultSet.getString("intitulé_dep"),
		    			resultSet.getString("nom_chef"),resultSet.getString("prenom_chef")
		    			));
		    	}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   
	   
	    
	   code_dep.setCellValueFactory(new PropertyValueFactory<Departement,Integer>("code_dep"));	 
	  intitule.setCellValueFactory(new PropertyValueFactory<Departement,String>("intitulé_dep"));
    	 nom_chef.setCellValueFactory(new PropertyValueFactory<Departement,String>("nom_chef"));
    	 prenom_chef.setCellValueFactory(new PropertyValueFactory<Departement,String>("prenom_chef"));
     	
    	 table.setItems(data);
    	 FilteredList<Departement> filteredData= new FilteredList<>(data,  b ->true);
    	 searchbar.textProperty().addListener((observable,oldValue,newValue)->{
    		 filteredData.setPredicate(data->{
    			if(newValue.isEmpty() || newValue.isBlank() ||newValue ==null  ) {
    				return true;
    			}
    			String searchKeyword = newValue.toLowerCase();
    			if (data.getIntitulé_dep().toLowerCase().indexOf(searchKeyword) > -1) {
    				return true;
    			}
    			else if (data.getNom_chef().toLowerCase().indexOf(searchKeyword) > -1) {
    				return true;
    			}
    			else if (data.getPrenom_chef().toLowerCase().indexOf(searchKeyword) > -1) {
    				return true;
    			}
    			
    			else {
    				return false;
    			}
    			
    		 });
    	 });
    	 SortedList<Departement> sortedData = new SortedList<>(filteredData);
    	 sortedData.comparatorProperty().bind(table.comparatorProperty());
    	 table.setItems(sortedData);

	
	
}

}
