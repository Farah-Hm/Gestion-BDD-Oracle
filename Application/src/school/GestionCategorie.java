package school;

import java.io.IOException;
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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import javafx.util.converter.LocalDateStringConverter;
import model.Category;
import model.Product;

public class GestionCategorie implements Initializable {

	    @FXML
    private TableColumn<Category, Integer> code;
    @FXML
    private TableColumn<Category, String> titre;
    @FXML
    private TableColumn<Category, String> editCol;
    private Product product;

    @FXML
    private TableView<Category> table;
    
    String query = null;
    private boolean update;
    Connection connection = null;
    ResultSet resultSet = null;
    PreparedStatement preparedStatement;

    public ObservableList<Category> data= FXCollections.observableArrayList();

    
    
    public void initialize(URL arg0, ResourceBundle arg1) {
		
	loadData();
		
	}
    
    	    
 @FXML
     void refresh() throws SQLException {
	 Connection connection=DbConnect.getInstance().getConnection();
	            data.clear();
            
            query = "SELECT * FROM SYSTEM.categorie ";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()){
                data.add(new Category(resultSet.getInt("num_cat"),
                        resultSet.getString("categorie")
                  ));
	            
                
            }
           
            }
 
    @FXML
    void inserer(MouseEvent event) throws IOException {
    	  try {
              Parent parent = FXMLLoader.load(getClass().getResource("/resource/fxml/insert_category.fxml"));
              Scene scene = new Scene(parent);
              Stage stage = new Stage();
              stage.setScene(scene);
              stage.initStyle(StageStyle.UTILITY);
              stage.show();
          } catch (IOException ex) {
              Logger.getLogger(GestionProduct.class.getName()).log(Level.SEVERE, null, ex);
          }
          
		  
		  
		
	}
    
    public void loadData() {
    	try {
			refresh();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    	 code.setCellValueFactory(new PropertyValueFactory<Category,Integer>("num_cat"));	 
		     titre.setCellValueFactory(new PropertyValueFactory<Category,String>("categorie"));
		     
		     Callback<TableColumn<Category, String>, TableCell<Category, String>> cellFoctory = (TableColumn<Category, String> param) -> {
	            // make cell containing buttons
	            final TableCell<Category, String> cell = new TableCell<Category, String>() {
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    //that cell created only on non-empty rows
                    if (empty) {
                        setGraphic(null);
                        setText(null);

                    } 
                        Button deleteIcon = new Button();
                        Button editIcon = new Button();
  
                        Image image = new Image(getClass().getResourceAsStream("/resource/image/modifier.png"));
                        
                        ImageView view = new ImageView(image);
                        
                        editIcon.setGraphic(view);
                         Image image1 = new Image(getClass().getResourceAsStream("/resource/image/supprimer.png"));
                        
                        ImageView view1 = new ImageView(image1);
                        
                        deleteIcon.setGraphic(view1);
                        
                        deleteIcon.setOnMouseClicked((MouseEvent event) -> {
                            
                            try {
                            	Category category = table.getSelectionModel().getSelectedItem();
                                if(category == null) {
                             	   Alert alert = new Alert(Alert.AlertType.ERROR);
                                    alert.setHeaderText(null);
                                    alert.setContentText("Veuillez selectionner une ligne");
                                    alert.showAndWait();
                                }else {
                             	   
                                
                                query = "DELETE FROM SYSTEM.categorie WHERE num_cat  ="+category.getNum_cat();
                                Connection connection=DbConnect.getInstance().getConnection();
                                preparedStatement = connection.prepareStatement(query);
                                preparedStatement.execute();
                                refresh();
                                }
                                
                            } catch (SQLException ex) {
                                Logger.getLogger(GestionProduct.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            
                           

                          

                        });
                        editIcon.setOnMouseClicked((MouseEvent event) -> {
                            
                        	Category category = table.getSelectionModel().getSelectedItem();
                            
                            if(category == null) {
                         	   Alert alert = new Alert(Alert.AlertType.ERROR);
                                alert.setHeaderText(null);
                                alert.setContentText("Veuiller selectionner une ligne");
                                alert.showAndWait();
                         	 
                            }else {
                         	   
                            
                            FXMLLoader loader = new FXMLLoader ();
                            loader.setLocation(getClass().getResource("/resource/fxml/update_category.fxml"));
                            try {
                                loader.load();
                            } catch (IOException ex) {
                                Logger.getLogger(GestionProduct.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            
                            AddCategory add = loader.getController();
                           
                            add.setTextField(category.getNum_cat(), category.getCategorie() 
          );
                            Parent parent = loader.getRoot();
                            Stage stage = new Stage();
                            stage.setScene(new Scene(parent));
                            stage.initStyle(StageStyle.UTILITY);
                            stage.show();
                            

                           

                        }});
                        
                        HBox managebtn = new HBox(editIcon, deleteIcon);
                        managebtn.setStyle("-fx-alignment:center");
                        HBox.setMargin(deleteIcon, new Insets(2, 2, 0, 3));
                        HBox.setMargin(editIcon, new Insets(2, 3, 0, 2));

                        setGraphic(managebtn);

                        setText(null);

                    }
                

            };

            return cell;
        };

    	
	    	 editCol.setCellFactory(cellFoctory);
        
	    	 table.setItems(data);
    }
}
