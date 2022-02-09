package school;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Observable;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;


import helpers.DynamiqueView;
import school.DbConnect;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.LinearGradient;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import javafx.util.converter.LocalDateStringConverter;
import model.Product;





public class GestionProduct implements Initializable {
	  @FXML
	    private TableColumn<Product, Integer> code;
	  @FXML
	    private TextField searchbar;
	    @FXML
	    private TableColumn<Product, String> designation;

	    @FXML
	    private TableColumn<Product, Integer> qte_stock;
	    @FXML
	    private TableColumn<Product, String> date_stock;
	    @FXML
	    private TableColumn<Product, String> categorie;
	    @FXML
	    private TableColumn<Product, String> type;
	    @FXML
	    private TableColumn<Product, String> seuil;
	    @FXML
	    private TableColumn<Product, String> editCol;
        private Product product;
        ObservableList<Product> productSearchModel = FXCollections.observableArrayList();
	    @FXML
	    private TableView<Product> table;
	    
	    String query = null;
	    private boolean update;
	    Connection connection = null;
	    ResultSet resultSet = null;
	    PreparedStatement preparedStatement;

	    public ObservableList<Product> data= FXCollections.observableArrayList();
 
	    
	    
	    public void initialize(URL arg0, ResourceBundle arg1) {
			
		loadData();
			
		}
	    
	    	    
	 @FXML
	     void refresh() throws SQLException {
		 Connection connection=DbConnect.getInstance().getConnection();
 	            productSearchModel.clear();
	            
	            query = "SELECT * FROM SYSTEM.produit p,SYSTEM.categorie c WHERE p.num_cat=c.num_cat";
	            preparedStatement = connection.prepareStatement(query);
	            resultSet = preparedStatement.executeQuery();
	            
	            while (resultSet.next()){
	                        
	                        productSearchModel.add(new Product(resultSet.getInt("code_pro"),
	                        		resultSet.getString("designation"), resultSet.getInt("qte_stock"),
	                        		resultSet.getString("date_stock"), resultSet.getString("type"), 
	                        		resultSet.getInt("seuil"), resultSet.getString("categorie")));
	                  
		            
	                
	            }
	           
	            }
	 
	    @FXML
	    void inserer(MouseEvent event) throws IOException {
	    	  try {
	              Parent parent = FXMLLoader.load(getClass().getResource("/resource/fxml/insert_product.fxml"));
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
	    	 code.setCellValueFactory(new PropertyValueFactory<Product,Integer>("code_pro"));	 
   	    	 designation.setCellValueFactory(new PropertyValueFactory<Product,String>("designation"));
   	    	 qte_stock.setCellValueFactory(new PropertyValueFactory<Product,Integer>("qte_stock"));
   	    	 date_stock.setCellValueFactory(new PropertyValueFactory<Product,String>("date_stock"));
   	    	 seuil.setCellValueFactory(new PropertyValueFactory<Product,String>("seuil"));
   	    	 type.setCellValueFactory(new PropertyValueFactory<Product,String>("type"));
   	    	 categorie.setCellValueFactory(new PropertyValueFactory<Product,String>("categorie"));
	    	Callback<TableColumn<Product, String>, TableCell<Product, String>> cellFoctory = (TableColumn<Product, String> param) -> {
	            // make cell containing buttons
	            final TableCell<Product, String> cell = new TableCell<Product, String>() {
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
	                                Product product = table.getSelectionModel().getSelectedItem();
	                                if(product == null) {
	                             	   Alert alert = new Alert(Alert.AlertType.ERROR);
	                                    alert.setHeaderText(null);
	                                    alert.setContentText("Veuillez selectionner une ligne");
	                                    alert.showAndWait();
	                                }else {
	                             	   
	                                
	                                query = "DELETE FROM SYSTEM.produit WHERE code_pro  ="+product.getCode_pro();
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
	                            
	                            Product product = table.getSelectionModel().getSelectedItem();
	                            
	                            if(product == null) {
	                         	   Alert alert = new Alert(Alert.AlertType.ERROR);
	                                alert.setHeaderText(null);
	                                alert.setContentText("Veuillez selectionner une ligne");
	                                alert.showAndWait();
	                         	 
	                            }else {
	                         	   
	                            
	                            FXMLLoader loader = new FXMLLoader ();
	                            loader.setLocation(getClass().getResource("/resource/fxml/update_product.fxml"));
	                            try {
	                                loader.load();
	                            } catch (IOException ex) {
	                                Logger.getLogger(GestionProduct.class.getName()).log(Level.SEVERE, null, ex);
	                            }
	                            
	                            AddProduct add = loader.getController();
	                            
	                            String date2=product.getDate_stock();
	                            LocalDate l = new LocalDateStringConverter().fromString(date2);
	                            add.setTextField(product.getCode_pro(), product.getDesignation(), 
	                                    product.getQte_stock(),l, product.getSeuil(),
	                                    product.getType());
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
            
   	    	 table.setItems(productSearchModel);
   	    	 FilteredList<Product> filteredData= new FilteredList<>(productSearchModel,  b ->true);
   	    	 searchbar.textProperty().addListener((observable,oldValue,newValue)->{
   	    		 filteredData.setPredicate(productSearchModel ->{
   	    			if(newValue.isEmpty() || newValue.isBlank() ||newValue ==null  ) {
   	    				return true;
   	    			}
   	    			String searchKeyword = newValue.toLowerCase();
   	    			if (productSearchModel.getDesignation().toLowerCase().indexOf(searchKeyword) > -1) {
   	    				return true;
   	    			}
   	    			else if (productSearchModel.getDate_stock().toLowerCase().indexOf(searchKeyword) > -1) {
   	    				return true;
   	    			}
   	    			
   	    			else if (productSearchModel.getCategorie().toLowerCase().indexOf(searchKeyword) > -1) {
   	    				return true;
   	    			}
   	    			else if (productSearchModel.getType().toLowerCase().indexOf(searchKeyword) > -1) {
   	    				return true;
   	    			}else {
   	    				return false;
   	    			}
   	    			
   	    		 });
   	    	 });
   	    	 SortedList<Product> sortedData = new SortedList<>(filteredData);
   	    	 sortedData.comparatorProperty().bind(table.comparatorProperty());
   	    	 table.setItems(sortedData);
	    }

        
		
		
		
		
}
