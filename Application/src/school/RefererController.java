package school;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Refere;

public class RefererController implements Initializable {
	 @FXML
	    private TableColumn< Refere,Integer> code;

	    @FXML
	    private TableColumn< Refere,Integer> qte;
	    @FXML
	    private TableView<Refere> table_refere;
	    @FXML
	    private TableColumn<Refere, Integer> code_pro;
	    @FXML
	    private ToggleGroup table;
	 Connection connection = null;
	    ResultSet resultSet = null;
	    PreparedStatement preparedStatement;
	    public ObservableList<Refere> data= FXCollections.observableArrayList();
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		 Connection connection=DbConnect.getInstance().getConnection();
		 String sql = "SELECT * from V_SE_REFERE";
		    try {
				preparedStatement = connection.prepareStatement(sql);
				  resultSet = preparedStatement.executeQuery();
				    while(resultSet.next()) {
			    	data.add(new Refere(resultSet.getInt("num_bso"),resultSet.getInt("code_pro"),resultSet.getInt("qte_sortie")
			    			));
			    	}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
       
		   
		    
		   code.setCellValueFactory(new PropertyValueFactory<Refere,Integer>("num_bso"));	 
		  code_pro.setCellValueFactory(new PropertyValueFactory<Refere,Integer>("code_pro"));
	    	 qte.setCellValueFactory(new PropertyValueFactory<Refere,Integer>("qte_sortie"));
	    	table_refere.setItems(data);
		
		
	}

}
