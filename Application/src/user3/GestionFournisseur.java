package user3;

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
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import javafx.util.converter.LocalDateStringConverter;
import model.Fournisseur;
import model.Product;
import school.AddProduct;
import school.DbConnect;
import school.GestionProduct;

public class GestionFournisseur implements Initializable {
	 @FXML
	    private TableColumn<Fournisseur, Integer> code_fournisseur;

	    @FXML
	    private TableColumn<Fournisseur, String> nom_fournisseur;

	    @FXML
	    private TableColumn<Fournisseur, Integer> num_compte;
	    @FXML
	    private TableColumn<Fournisseur, Integer> num_tel;
	    @FXML
	    private TableColumn<Fournisseur, String> editCol;
	    @FXML
	    private TextField searchbar;
     private Fournisseur fourniseur;
     ObservableList<Fournisseur> fournisseurSearchModel = FXCollections.observableArrayList();
	   
	    @FXML
	    private TableView<Fournisseur> table;
	    
	    String query = null;
	    private boolean update;
	    Connection connection = null;
	    ResultSet resultSet = null;
	    PreparedStatement preparedStatement;
	    
	    public ObservableList<Fournisseur> data= FXCollections.observableArrayList();

	    private final String path ="/user3files/fxml/";
	    
	    public void initialize(URL arg0, ResourceBundle arg1) {
			
		loadData();
			
		}
	    
	    	    
	 @FXML
	     void refresh() throws SQLException {
		 Connection connection=DbConnect.getInstance().getConnection();
	            fournisseurSearchModel.clear();
	            
	            query = "SELECT * FROM SYSTEM.fournisseur";
	            preparedStatement = connection.prepareStatement(query);
	            resultSet = preparedStatement.executeQuery();
	            
	            while (resultSet.next()){

	                fournisseurSearchModel.add(new Fournisseur(resultSet.getInt("code_fournisseur"),
	                		resultSet.getString("nom_fournisseur"),
	                		resultSet.getInt("num_compte"),
	                		   resultSet.getInt("num_tel")));
		            
	                
	            }
	           
	            }
	 
	    @FXML
	    void inserer(MouseEvent event) throws IOException {
	    	  try {
	              Parent parent = FXMLLoader.load(getClass().getResource(path+"insert_fournisseur.fxml"));
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
	    	 code_fournisseur.setCellValueFactory(new PropertyValueFactory<Fournisseur,Integer>("code_fournisseur"));	 
	    	 nom_fournisseur.setCellValueFactory(new PropertyValueFactory<Fournisseur,String>("nom_fournisseur"));
	    	 num_compte.setCellValueFactory(new PropertyValueFactory<Fournisseur,Integer>("num_compte"));
	    	 num_tel.setCellValueFactory(new PropertyValueFactory<Fournisseur,Integer>("num_tel"));
	    	 Callback<TableColumn<Fournisseur, String>, TableCell<Fournisseur, String>> cellFoctory = (TableColumn<Fournisseur, String> param) -> {
	            // make cell containing buttons
	            final TableCell<Fournisseur, String> cell = new TableCell<Fournisseur, String>() {
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
	                            	Fournisseur fournisseur = table.getSelectionModel().getSelectedItem();
	                                if(fournisseur == null) {
	                             	   Alert alert = new Alert(Alert.AlertType.ERROR);
	                                    alert.setHeaderText(null);
	                                    alert.setContentText("Veuillez selectionner une ligne");
	                                    alert.showAndWait();
	                                }else {
	                             	   
	                                
	                                query = "DELETE FROM SYSTEM.fournisseur WHERE code_fournisseur  ="+fournisseur.getCode_fournisseur();
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
	                            
	                        	Fournisseur fournisseur = table.getSelectionModel().getSelectedItem();
	                            
	                            if(fournisseur == null) {
	                         	   Alert alert = new Alert(Alert.AlertType.ERROR);
	                                alert.setHeaderText(null);
	                                alert.setContentText("Veuillez selectionner une ligne");
	                                alert.showAndWait();
	                         	 
	                            }else {
	                         	   
	                            
	                            FXMLLoader loader = new FXMLLoader ();
	                            loader.setLocation(getClass().getResource(path+"update_fournisseur.fxml"));
	                            try {
	                                loader.load();
	                            } catch (IOException ex) {
	                                Logger.getLogger(GestionProduct.class.getName()).log(Level.SEVERE, null, ex);
	                            }
	                            
	                            AddFournisseur add = loader.getController();
	                            
	                            
	                            
	                            add.setTextField(fournisseur.getCode_fournisseur(), fournisseur.getNom_fournisseur(), 
	                            		fournisseur.getNum_compte(),fournisseur.getNum_tel());
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
         
	    	 table.setItems(fournisseurSearchModel);
	    	 FilteredList<Fournisseur> filteredData= new FilteredList<>(fournisseurSearchModel,  b ->true);
   	    	 searchbar.textProperty().addListener((observable,oldValue,newValue)->{
   	    		 filteredData.setPredicate(fournisseurSearchModel ->{
   	    			if(newValue.isEmpty() || newValue.isBlank() ||newValue ==null  ) {
   	    				return true;
   	    			}
   	    			String searchKeyword = newValue.toLowerCase();
   	    			if (fournisseurSearchModel.getNom_fournisseur().toLowerCase().indexOf(searchKeyword) > -1) {
   	    				return true;
   	    			}
   	    			else {
   	    				return false;
   	    			}
   	    			
   	    		 });
   	    	 });
   	    	 SortedList<Fournisseur> sortedData = new SortedList<>(filteredData);
   	    	 sortedData.comparatorProperty().bind(table.comparatorProperty());
   	    	 table.setItems(sortedData);

	    }

}
