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
import javafx.scene.control.cell.PropertyValueFactory;
import model.Concerner;


public class ConcernerController implements Initializable {
	@FXML
	private TableColumn<Concerner, Integer> code_pro;

	@FXML
	private TableColumn<Concerner, Integer> num_baf;

	@FXML
	private TableColumn<Concerner, Integer> qte_aff;

	@FXML
	private TableView<Concerner> table;

	 Connection connection = null;
	    ResultSet resultSet = null;
	    PreparedStatement preparedStatement;
	    public ObservableList<Concerner> data= FXCollections.observableArrayList();
	    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
			 Connection connection=DbConnect.getInstance().getConnection();
			 String sql = "SELECT * from V_CONCERNER";
			    try {
					preparedStatement = connection.prepareStatement(sql);
					  resultSet = preparedStatement.executeQuery();
					    while(resultSet.next()) {
				    	data.add(new Concerner(resultSet.getInt("num_baf"),resultSet.getInt("code_pro"),resultSet.getInt("qte_aff")
				    			));
				    	}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	       
			   
			    
			   num_baf.setCellValueFactory(new PropertyValueFactory<Concerner,Integer>("num_baf"));	 
			  code_pro.setCellValueFactory(new PropertyValueFactory<Concerner,Integer>("code_pro"));
		    	 qte_aff.setCellValueFactory(new PropertyValueFactory<Concerner,Integer>("qte_aff"));
		    	table.setItems(data);
		
	}

}
