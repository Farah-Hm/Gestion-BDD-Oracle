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
import model.Contenir;
import model.Refere;


public class ContenirController implements Initializable {
    @FXML
    private TableColumn<Contenir, Integer> code_pro;

    @FXML
    private TableColumn<Contenir, Integer> num_bco;

    @FXML
    private TableColumn<Contenir, Integer> qte_cde;

    @FXML
    private TableView<Contenir> table;
    Connection connection = null;
    ResultSet resultSet = null;
    PreparedStatement preparedStatement;
    public ObservableList<Contenir> data= FXCollections.observableArrayList();
    @Override
public void initialize(URL arg0, ResourceBundle arg1) {
		 Connection connection=DbConnect.getInstance().getConnection();
		 String sql = "SELECT * from V_CONTENIR";
		    try {
				preparedStatement = connection.prepareStatement(sql);
				  resultSet = preparedStatement.executeQuery();
				    while(resultSet.next()) {
			    	data.add(new Contenir(resultSet.getInt("num_bco"),resultSet.getInt("code_pro"),resultSet.getInt("qte_cde")
			    			));
			    	}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
       
		   
		    
		   num_bco.setCellValueFactory(new PropertyValueFactory<Contenir,Integer>("num_bco"));	 
		  code_pro.setCellValueFactory(new PropertyValueFactory<Contenir,Integer>("code_pro"));
	    	 qte_cde.setCellValueFactory(new PropertyValueFactory<Contenir,Integer>("qte_cde"));
	    	table.setItems(data);
	
}
}
