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
import model.Renfermer;

public class RenfermerController implements Initializable{
    @FXML
    private TableColumn<Renfermer,Integer> code_pro;

    @FXML
    private TableColumn<Renfermer,Integer> num_bliv;

    @FXML
    private TableColumn<Renfermer,Integer> qte_liv;

    @FXML
    private TableView<Renfermer> table;
    Connection connection = null;
    ResultSet resultSet = null;
    PreparedStatement preparedStatement;
    public ObservableList<Renfermer> data= FXCollections.observableArrayList();
    @Override
public void initialize(URL arg0, ResourceBundle arg1) {
		 Connection connection=DbConnect.getInstance().getConnection();
		 String sql = "SELECT * from V_RENFERMER";
		    try {
				preparedStatement = connection.prepareStatement(sql);
				  resultSet = preparedStatement.executeQuery();
				    while(resultSet.next()) {
			    	data.add(new Renfermer(resultSet.getInt("num_bliv"),resultSet.getInt("code_pro"),resultSet.getInt("qte_liv")
			    			));
			    	}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
       
		   
		    
		   num_bliv.setCellValueFactory(new PropertyValueFactory<Renfermer,Integer>("num_bliv"));	 
		  code_pro.setCellValueFactory(new PropertyValueFactory<Renfermer,Integer>("code_pro"));
	    	 qte_liv.setCellValueFactory(new PropertyValueFactory<Renfermer,Integer>("qte_liv"));
	    	table.setItems(data);
	
}

}
