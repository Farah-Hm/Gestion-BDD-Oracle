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
import model.BonLivraison;
import model.Departement;
import model.Refere;
import school.DbConnect;

public class BonsLivraison implements Initializable {
	@FXML
    private TableColumn< BonLivraison,Integer> num_bliv;

    @FXML
    private TableColumn< BonLivraison,String> date_liv;
    @FXML
    private TableColumn<BonLivraison, Integer> quantite;
    
    @FXML
    private TableView<BonLivraison> table;
    @FXML
    private TextField searchbar;
    
 Connection connection = null;
    ResultSet resultSet = null;
    PreparedStatement preparedStatement;
    public ObservableList<BonLivraison> data= FXCollections.observableArrayList();
@Override
public void initialize(URL arg0, ResourceBundle arg1) {
	 Connection connection=DbConnect.getInstance().getConnection();
	 String sql = "SELECT * from bl";
	    try {
			preparedStatement = connection.prepareStatement(sql);
			  resultSet = preparedStatement.executeQuery();
			    while(resultSet.next()) {
		    	data.add(new BonLivraison(resultSet.getInt("num_bliv"),resultSet.getString("date_liv"),resultSet.getInt("quantité")
		    			));
		    	}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   
	   
	    
	   num_bliv.setCellValueFactory(new PropertyValueFactory<BonLivraison,Integer>("num_bliv"));	 
	  date_liv.setCellValueFactory(new PropertyValueFactory<BonLivraison,String>("date_liv"));
    	 quantite.setCellValueFactory(new PropertyValueFactory<BonLivraison,Integer>("quantité"));
    	table.setItems(data);
    	FilteredList<BonLivraison> filteredData= new FilteredList<>(data,b ->true);
   	 searchbar.textProperty().addListener((observable,oldValue,newValue)->{
   		 filteredData.setPredicate(data->{
   			if(newValue.isEmpty() || newValue.isBlank() ||newValue ==null  ) {
   				return true;
   			}
   			String searchKeyword = newValue.toLowerCase();
   			if (data.getDate_liv().toLowerCase().indexOf(searchKeyword) > -1) {
   				return true;
   			}
   			
   			
   			else {
   				return false;
   			}
   			
   		 });
   	 });
   	 SortedList<BonLivraison> sortedData = new SortedList<>(filteredData);
   	 sortedData.comparatorProperty().bind(table.comparatorProperty());
   	 table.setItems(sortedData);

	
	
}

}
