package school;

import java.io.IOException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import javafx.util.converter.LocalDateStringConverter;


public class Main1Controller implements Initializable{

    @FXML
    private GridPane Grid;
    
    @FXML
    private GridPane Grid2;
    
    @FXML
    private GridPane Grid3;

    @FXML
    private GridPane Grid4;
    
    @FXML
    private Button Logout;

    @FXML
    private Label Nom_user;

    @FXML
    private VBox Vbox1;

    @FXML
    private VBox Vbox2;

    @FXML
    private Button but_departement;

    @FXML
    private Button but_employee;
    
    @FXML
    private Button but_bon_affectation;
    
    @FXML
    private Button but_bon_sortie;
    
    @FXML
    private Button but_inserer_dep;
    
    @FXML
    private Button but_modifier_dep;
    
    @FXML
    private Button but_supprimer_dep;
    
    @FXML
    private Button but_sauvegarder_insertion_dep;
    
    @FXML
    private Button but_annuler;
    
    @FXML
    private Button but_annuler1;
    
    @FXML
    private Button but_annuler2;
    
    @FXML
    private Button but_annuler3;
    
    @FXML
    private Button but_annuler4;
    
    @FXML
    private Button but_annuler5;
    
    @FXML
    private Button but_annuler6;
    
    @FXML
    private Button but_annuler7;
    
    @FXML
    private Button but_confirmer_modification;
    
    @FXML
    private Button  but_ajouter_employee;
    
    @FXML
    private Button  but_supprimer_empl;
    
    @FXML
    private Button  but_sauvegarder_insertion_empl;
    
    @FXML
    private Button  but_confirmer_modifier_empl;
    
    @FXML
    private Button  but_modifier_employee;
    
    @FXML
    private Button but_inserer_bon_aff;
    
    @FXML
    private Button but_modifier_bon_aff;
    
    @FXML
    private Button but_supprimer_bon_aff;
    
    @FXML
    private Button sauvegarder_insertion_bon_aff;
    
    @FXML
    private Button sauvegarder_modification_bon_aff;

    @FXML
    private Button but_inserer_bon_sor;
    
    @FXML
    private Button but_modifier_bon_sor;
    
    @FXML
    private Button but_supprimer_bon_sor;
    
    @FXML
    private Button sauvegarder_insertion_bon_sor;
    
    @FXML
    private Button sauvegarder_modification_bon_sor;
    
    @FXML
    private TableColumn<Employee, Integer> Code_empl;

    @FXML
    private TableColumn<Employee, Integer> code_dep;

    @FXML
    private TableColumn<Employee, String> fonction_empl;

    @FXML
    private TableColumn<Employee, String> grade_empl;

    @FXML
    private TableColumn<Employee, String> nom_empl;

    @FXML
    private TableColumn<Employee, String> prenom_empl;

    @FXML
    private TableColumn<Employee, String> Editer;

    @FXML
    private TableView<Employee> tv_employee;

    @FXML
    private TableColumn<Departement, Integer> code_Dep;

    @FXML
    private TableColumn<Departement,String > intitule_dep;

    @FXML
    private TableColumn<Departement,String > nom_chef;

    @FXML
    private TableColumn<Departement,String > prenom_chef;
    
    @FXML
    private TableColumn<Departement, String> Editer1;

    @FXML
    private TableView<Departement> tv_Departement;
    
    @FXML
    private TableView<Bon_Affectation> tv_Bon_Affectation;
    
    @FXML
    private TableColumn<Bon_Affectation,Integer> Num_baf;
    
    @FXML
    private TableColumn<Bon_Affectation,String> Date_aff;
    
    @FXML
    private TableColumn<Bon_Affectation,Integer> Code_emp;
    
    @FXML
    private TableColumn<Bon_Affectation, String> Editer2;
   
    @FXML
    private TableView<Bon_Sortie> tv_Bon_Sortie;
    
    @FXML
    private TableColumn<Bon_Sortie,Integer> Num_bso;
    
    @FXML
    private TableColumn<Bon_Sortie,String> Date_sor;
    
    @FXML
    private TableColumn<Bon_Sortie,Integer> Code_emp1o;
    
    @FXML
    private TableColumn<Bon_Sortie, String> Editer3;
    
    @FXML
    private TextField tf_Code_empl;
    
    @FXML
    private TextField tf_nom_empl;
    
    @FXML
    private TextField tf_prenom_empl;
    
    @FXML
    private TextField tf_grade_empl;
    
    @FXML
    private TextField tf_fonction_empl;
    
    @FXML
    private TextField tf_code_dep;
    
    @FXML
    private TextField tf_Code_empl1;
    
    @FXML
    private TextField tf_nom_empl1;
    
    @FXML
    private TextField tf_prenom_empl1;
    
    @FXML
    private TextField tf_grade_empl1;
    
    @FXML
    private TextField tf_fonction_empl1;
    
    @FXML
    private TextField tf_code_dep1;
    
    @FXML
    private TextField code_dep1;
    
    @FXML
    private TextField tf_intitule;

    @FXML
    private TextField tf_nom_chef;

    @FXML
    private TextField tf_prenom_chef;

    @FXML
    private TextField tf_intitule1;

    @FXML
    private TextField tf_nom_chef1;
   
    @FXML
    private TextField tf_prenom_chef1;
    
    @FXML
    private TextField tf_Num_baf;
    
    @FXML
    private TextField tf_Date_aff;
    
    @FXML
    private TextField tf_Code_emp;
    
    @FXML
    private TextField tf_Num_baf1;
    
    @FXML
    private TextField tf_Date_aff1;
    
    @FXML
    private TextField tf_Code_emp1;

    @FXML
    private TextField tf_Num_bso;
    
    @FXML
    private TextField tf_Date_sor;
    
    @FXML
    private TextField tf_Code_emplo;
    
    @FXML
    private TextField tf_Num_bso1;
    
    @FXML
    private TextField tf_Date_sor1;
    
    @FXML
    private TextField tf_Code_emplo1;  
    @FXML
    private AnchorPane mainpane;

    //public CheckConnection check = new CheckConnection();
    Stage stage;
    Parent root;
    Scene scene;
    String query = null;
    private boolean update;
    Connection connection = null;
    ResultSet resultSet = null;
    PreparedStatement preparedStatement;
    @FXML
    public void Display(ActionEvent event) throws Exception {
    	if(event.getSource()==Logout) {
    		try {
    			Parent root= FXMLLoader.load(getClass().getResource("/loginFiles/fxml/login.fxml"));
    		   Node node=(Node) event.getSource();
    		   Stage stage=(Stage) node.getScene().getWindow();
    		   stage.setScene(new Scene(root));
        	 } catch (IOException e) {
    			e.printStackTrace();
    		}
    	}else if(event.getSource() == but_employee) {
    		root =FXMLLoader.load(getClass().getResource("/school/Employee.fxml"));
    		stage=(Stage)(((Node) event.getSource()).getScene().getWindow());
    		scene = new Scene(root);
    		stage.setScene(scene);
    		stage.show();
    	}else if (event.getSource()== but_departement) {
    		root =FXMLLoader.load(getClass().getResource("/school/Departement.fxml"));
    		stage=(Stage)(((Node) event.getSource()).getScene().getWindow());
    		scene = new Scene(root);
    		stage.setScene(scene);
    		stage.show();
    	}else if(event.getSource()==but_bon_affectation) {
    		root =FXMLLoader.load(getClass().getResource("/school/Bon_Affectation.fxml"));
    		stage=(Stage)(((Node) event.getSource()).getScene().getWindow());
    		scene = new Scene(root);
    		stage.setScene(scene);
    		stage.show();
    	}else if (event.getSource()==but_bon_sortie) {
    		root =FXMLLoader.load(getClass().getResource("/school/Bon_Sortie.fxml"));
    		stage=(Stage)(((Node) event.getSource()).getScene().getWindow());
    		scene = new Scene(root);
    		stage.setScene(scene);
    		stage.show();
    	}
    }
	// Partie Employee
	public ObservableList<Employee> getEmployeeList() throws  Exception{
		ObservableList<Employee> EmployeeList = FXCollections.observableArrayList();
		Connection con = getConnection();
		String query="SELECT * FROM emp1,dep1 where emp1.code_dep=dep1.code_dep";
		Statement st;
		ResultSet rs;
		try {
			st=con.createStatement();
			rs=st.executeQuery(query);
			Employee Employee;
			while(rs.next()) {
				Employee = new Employee(rs.getInt("Code_emp"),
						rs.getString("nom_emp"),
						rs.getString("prenom_emp"),rs.getString("grade_emp"),
						rs.getString("fonction"),
						rs.getInt("code_dep"));
				EmployeeList.add(Employee);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return EmployeeList;
	}
	public void showEmployee() throws Exception {
		ObservableList<Employee> EmployeeList = getEmployeeList();
		Code_empl.setCellValueFactory(new Callback<CellDataFeatures<Employee,Integer>,ObservableValue<Integer>>(){
			@Override
            public ObservableValue<Integer> call(CellDataFeatures<Employee, Integer> param) {
                return new ReadOnlyObjectWrapper<>(param.getValue().getCode_empl());
            }
        });
		nom_empl.setCellValueFactory(new PropertyValueFactory<Employee ,String>("nom_empl"));
		prenom_empl.setCellValueFactory(new PropertyValueFactory<Employee ,String>("prenom_empl"));
		grade_empl.setCellValueFactory(new PropertyValueFactory<Employee ,String>("grade_empl"));
		fonction_empl.setCellValueFactory(new PropertyValueFactory<Employee ,String>("fonction_empl"));
		code_dep.setCellValueFactory(new Callback<CellDataFeatures<Employee,Integer>,ObservableValue<Integer>>(){
			@Override
            public ObservableValue<Integer> call(CellDataFeatures<Employee, Integer> param) {
                return new ReadOnlyObjectWrapper<>(param.getValue().getcode_dep());
            }
        });
		Callback<TableColumn<Employee, String>, TableCell<Employee, String>> cellFoctory = (TableColumn<Employee, String> param) -> {
            // make cell containing buttons
            final TableCell<Employee, String> cell = new TableCell<Employee, String>() {
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
                        
                        deleteIcon.setOnAction((ActionEvent event) -> {
                            
                            try {
                                Employee employee = tv_employee.getSelectionModel().getSelectedItem();
                                if(employee == null) {
                             	   Alert alert = new Alert(Alert.AlertType.ERROR);
                                    alert.setHeaderText(null);
                                    alert.setContentText("Veuiller selecter une ligne");
                                    alert.showAndWait();
                                }else {
                             	   
                                
                                query = "DELETE FROM emp1 WHERE code_emp ="+employee.getCode_empl();
                                executeQuery(query);
                    	    	showEmployee();
                                getEmployeeList();
                                }
                                
                            } catch (SQLException ex) {
                               
                            } catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
                            
                           

                          

                        });
                        editIcon.setOnAction((ActionEvent event) -> {
                            
                        	Employee employee = tv_employee.getSelectionModel().getSelectedItem();
                            
                            if(employee == null) {
                         	   Alert alert = new Alert(Alert.AlertType.ERROR);
                                alert.setHeaderText(null);
                                alert.setContentText("Veuiller selectionner une ligne");
                                alert.showAndWait();
                         	 
                            }else {
                            try {
                            	acceuil_modifier_empl(event);
                            } catch (Exception ex) {
                               
                            }

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

    	
	    	 Editer.setCellFactory(cellFoctory);
        

		tv_employee.setItems(EmployeeList);
	}
	   public   void inserer_empl(ActionEvent event) throws IOException {
		root =FXMLLoader.load(getClass().getResource("/school/Inserer_Employee.fxml"));
 		stage=(Stage)(((Node) event.getSource()).getScene().getWindow());
 		scene = new Scene(root);
 		stage.setScene(scene);
 		stage.show();
	    }
	    
	    @FXML 
	    public   void acceuil_modifier_empl(ActionEvent event) throws IOException{
	    	root =FXMLLoader.load(getClass().getResource("/school/Modifier_Employee.fxml"));
    		stage=(Stage)(((Node) event.getSource()).getScene().getWindow());
    		scene = new Scene(root);
    		stage.setScene(scene);
    		stage.show();
	    	
	    }
	    @FXML
	    public    void Sauvegarder_empl(ActionEvent event) throws Exception {

			String query="INSERT INTO emp1 VALUES ("+ tf_Code_empl.getText()+",'"+tf_nom_empl.getText()+"','"+tf_prenom_empl.getText()+"','"+tf_grade_empl.getText()+"','"+tf_fonction_empl.getText()+"',"+tf_code_dep.getText()+")";
			try {
				executeQuery(query);
				showEmployee();
				}catch(Exception ex) {
					ex.printStackTrace();
				}
			revenir_page_acceuil(event,1);
	    }
	    @FXML
	    private void modifier_empl(ActionEvent event) throws Exception {
	    	String query="UPDATE emp1 set nom_emp='" + tf_nom_empl1.getText() + "',prenom_emp='" + tf_prenom_empl1.getText() + "',grade_emp='"
	    			+ tf_grade_empl1.getText() +"',fonction='" + tf_fonction_empl1.getText() + "' WHERE code_emp ="+ tf_Code_empl1.getText() ;

	    	try {
	    		executeQuery(query);
	    		showEmployee();
	    		
	    	}
	    	catch(Exception ex) { 
	    }
	    	revenir_page_acceuil(event,1);
	   	}
	    
   //Partie Departement
	@FXML
	public void inserer_dep(ActionEvent event) throws Exception {
		root =FXMLLoader.load(getClass().getResource("/school/Inserer_Departement.fxml"));
		stage=(Stage)(((Node) event.getSource()).getScene().getWindow());
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
    }
    @FXML
    public  void modifier_dep(ActionEvent event)throws Exception {
    	root =FXMLLoader.load(getClass().getResource("/school/Modifier_Departement.fxml"));
		stage=(Stage)(((Node) event.getSource()).getScene().getWindow());
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
    }
    @FXML
    public  void Sauvegarder(ActionEvent event) throws Exception {
    	String query="INSERT INTO dep1 VALUES (SYSTEM.SEQ.nextval,'"+ tf_intitule.getText() + "','"+ tf_nom_chef.getText() + "','" + tf_prenom_chef.getText() + "')";
    	executeQuery(query);
    	revenir_page_acceuil(event,2);
    }
    @FXML
    public void Modifier(ActionEvent event) throws Exception {
    	String query="UPDATE dep1 set intitulé_dep='" + tf_intitule1.getText() + "',nom_chef='" + tf_nom_chef1.getText() + "',prenom_chef='"
    			+ tf_prenom_chef1.getText() + "' WHERE code_dep="+ code_dep1.getText() ;
    	try {
    		executeQuery(query);
        	showDepartement();
    		
    	}
    	catch(Exception ex) { 
    }
    	
    	revenir_page_acceuil(event,2);
    }

	public ObservableList<Departement> getDepartementList() throws  Exception{
		ObservableList<Departement> DepartementList = FXCollections.observableArrayList();
		Connection con = getConnection();
		String query="SELECT * from dep1";
		Statement st;
		ResultSet rs;
		
		try {
			st=con.createStatement();
			rs=st.executeQuery(query);
			Departement departement;
			while(rs.next()) {
				departement = new Departement(rs.getInt("code_Dep"),rs.getString("intitulé_dep"),rs.getString("nom_chef"),rs.getString("prenom_chef"));
				DepartementList.add(departement);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return DepartementList;
	}
	public void showDepartement() throws Exception {
		ObservableList<Departement> List = getDepartementList();
		code_Dep.setCellValueFactory(new Callback<CellDataFeatures<Departement,Integer>,ObservableValue<Integer>>(){
			@Override
            public ObservableValue<Integer> call(CellDataFeatures<Departement, Integer> param) {
                return new ReadOnlyObjectWrapper<>(param.getValue().getCode_dep());
            }
		});
		intitule_dep.setCellValueFactory(new PropertyValueFactory<Departement ,String>("intitule_dep"));
		nom_chef.setCellValueFactory(new PropertyValueFactory<Departement ,String>("nom_chef"));
		prenom_chef.setCellValueFactory(new PropertyValueFactory<Departement ,String>("prenom_chef"));
		Callback<TableColumn<Departement, String>, TableCell<Departement, String>> cellFoctory = (TableColumn<Departement, String> param) -> {
            // make cell containing buttons
            final TableCell<Departement, String> cell = new TableCell<Departement, String>() {
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
                        
                        deleteIcon.setOnAction((ActionEvent event) -> {
                            
                            try {
                            	Departement departement = tv_Departement.getSelectionModel().getSelectedItem();
                                if(departement == null) {
                             	   Alert alert = new Alert(Alert.AlertType.ERROR);
                                    alert.setHeaderText(null);
                                    alert.setContentText("Veuiller selecter une ligne");
                                    alert.showAndWait();
                                }else {
                             	   
                                
                                query = "DELETE FROM dep1 WHERE code_dep ="+departement.getCode_dep();
                                executeQuery(query);
                    	    	showDepartement();
                                getDepartementList();
                                }
                                
                            }  catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
                            
                           

                          

                        });
                        editIcon.setOnAction((ActionEvent event) -> {
                            
                        	Departement departement = tv_Departement.getSelectionModel().getSelectedItem();
                            
                            if(departement == null) {
                         	   Alert alert = new Alert(Alert.AlertType.ERROR);
                                alert.setHeaderText(null);
                                alert.setContentText("Veuiller selecter une ligne");
                                alert.showAndWait();
                         	 
                            }else {
                            try {
                            	modifier_dep(event);
                            } catch (Exception ex) {
                               
                            }

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

    	
	    	 Editer1.setCellFactory(cellFoctory);
        
		tv_Departement.setItems(List);
	}
	
	//Partie Bon Affectation
	
	
	public ObservableList<Bon_Affectation> getBon_AffectationList() throws  Exception{
		ObservableList<Bon_Affectation> Bon_AffectationList = FXCollections.observableArrayList();
		Connection con = getConnection();
		String query="SELECT * FROM BA,emp1 WHERE BA.code_emp=emp1.code_emp";
		Statement st;
		ResultSet rs;
		
		try {
			st=con.createStatement();
			rs=st.executeQuery(query);
			Bon_Affectation Bon_Affectation;
			while(rs.next()) {
				Bon_Affectation = new Bon_Affectation(rs.getInt("Num_baf"),rs.getString("Date_aff"),rs.getInt("Code_emp"));
				Bon_AffectationList.add(Bon_Affectation);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return Bon_AffectationList;
	}
	public void showBon_Affectation() throws Exception {
		ObservableList<Bon_Affectation> Bon_Affectation = getBon_AffectationList();
		Num_baf.setCellValueFactory(new PropertyValueFactory<Bon_Affectation ,Integer>("Num_baf"));
		Date_aff.setCellValueFactory(new PropertyValueFactory<Bon_Affectation ,String>("Date_aff"));
		Code_emp.setCellValueFactory(new Callback<CellDataFeatures<Bon_Affectation,Integer>,ObservableValue<Integer>>(){
			@Override
            public ObservableValue<Integer> call(CellDataFeatures<Bon_Affectation, Integer> param) {
                return new ReadOnlyObjectWrapper<>(param.getValue().getCode_empl());
            }
        });
		Callback<TableColumn<Bon_Affectation, String>, TableCell<Bon_Affectation, String>> cellFoctory = (TableColumn<Bon_Affectation, String> param) -> {
            // make cell containing buttons
            final TableCell<Bon_Affectation, String> cell = new TableCell<Bon_Affectation, String>() {
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
                        
                        deleteIcon.setOnAction((ActionEvent event) -> {
                            
                            try {
                                Bon_Affectation bon_aff = tv_Bon_Affectation.getSelectionModel().getSelectedItem();
                                if(bon_aff == null) {
                             	   Alert alert = new Alert(Alert.AlertType.ERROR);
                                    alert.setHeaderText(null);
                                    alert.setContentText("Veuiller selecter une ligne");
                                    alert.showAndWait();
                                }else {
                             	   
                                
                                query = "DELETE FROM BA WHERE Num_baf ="+bon_aff.getNum_baf();
                                executeQuery(query);
                                showBon_Affectation();
                                getBon_AffectationList();
                                }
                                
                            } catch (SQLException ex) {
                               
                            } catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
                            
                           

                          

                        });
                        editIcon.setOnAction((ActionEvent event) -> {
                            
                        	Bon_Affectation bon_aff = tv_Bon_Affectation.getSelectionModel().getSelectedItem();
                            
                            if(bon_aff == null) {
                         	   Alert alert = new Alert(Alert.AlertType.ERROR);
                                alert.setHeaderText(null);
                                alert.setContentText("Veuiller selecter une ligne");
                                alert.showAndWait();
                         	 
                            }else {
                            try {
                            	modifier_bon_aff(event);
                            } catch (Exception ex) {
                               
                            }

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

    	
	    	 Editer2.setCellFactory(cellFoctory);
        
		
		tv_Bon_Affectation.setItems(Bon_Affectation);
	}
	public void inserer_bon_aff(ActionEvent event) throws Exception{
		root =FXMLLoader.load(getClass().getResource("/school/Inserer_Bon_Affectation.fxml"));
		stage=(Stage)(((Node) event.getSource()).getScene().getWindow());
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void modifier_bon_aff(ActionEvent event) throws Exception {
		root =FXMLLoader.load(getClass().getResource("/school/Modifier_Bon_Affectation.fxml"));
		stage=(Stage)(((Node) event.getSource()).getScene().getWindow());
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}	
	public void sauvegarder_insertion_bon_aff(ActionEvent event) throws IOException {
		String query="INSERT INTO BA VALUES ("+ tf_Num_baf.getText()+",'"+tf_Date_aff.getText()+"',"+tf_Code_emp.getText()+")";
		try {
			executeQuery(query);
			showBon_Affectation();
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		revenir_page_acceuil(event,3);
	}
	
	public void sauvegarder_modification_bon_aff(ActionEvent event) throws Exception {
		String query="UPDATE BA set Date_aff='" + tf_Date_aff1.getText() + "',Code_emp='" + tf_Code_emp1.getText() + "' WHERE Num_baf ="+ tf_Num_baf1.getText() ;
		try {
			executeQuery(query);
	    	showBon_Affectation();
    		
    	}
    	catch(Exception ex) { 
    }
		
    	revenir_page_acceuil(event,3);
	}
	
	//Partie Bon Sortie
	
	
	public ObservableList<Bon_Sortie> getBon_SortieList() throws  Exception{
		ObservableList<Bon_Sortie> Bon_SortieList = FXCollections.observableArrayList();
		Connection con = getConnection();
		String query="SELECT * FROM BS";
		Statement st;
		ResultSet rs;
		
		try {
			st=con.createStatement();
			rs=st.executeQuery(query);       
			Bon_Sortie Bon_Sortie;
			while(rs.next()) {
				Bon_Sortie = new Bon_Sortie(rs.getInt("Num_bso"),rs.getString("Date_sor"),rs.getInt("Code_emp"));
				Bon_SortieList.add(Bon_Sortie);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return Bon_SortieList;
	}
	public void showBonSortie() throws Exception {
		ObservableList<Bon_Sortie> Bon_Sortie = getBon_SortieList();
		Num_bso.setCellValueFactory(new PropertyValueFactory<Bon_Sortie ,Integer>("Num_bso"));
		Date_sor.setCellValueFactory(new PropertyValueFactory<Bon_Sortie ,String>("Date_sor"));
		Code_emp1o.setCellValueFactory(new Callback<CellDataFeatures<Bon_Sortie,Integer>,ObservableValue<Integer>>(){
			@Override
            public ObservableValue<Integer> call(CellDataFeatures<Bon_Sortie, Integer> param) {
                return new ReadOnlyObjectWrapper<>(param.getValue().getCode_empl());
            }
        });
		Callback<TableColumn<Bon_Sortie, String>, TableCell<Bon_Sortie, String>> cellFoctory = (TableColumn<Bon_Sortie, String> param) -> {
            // make cell containing buttons
            final TableCell<Bon_Sortie, String> cell = new TableCell<Bon_Sortie, String>() {
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
                        
                        deleteIcon.setOnAction((ActionEvent event) -> {
                            
                            try {
                            	Bon_Sortie bon_sor = tv_Bon_Sortie.getSelectionModel().getSelectedItem();
                                if(bon_sor == null) {
                             	   Alert alert = new Alert(Alert.AlertType.ERROR);
                                    alert.setHeaderText(null);
                                    alert.setContentText("Veuiller selecter une ligne");
                                    alert.showAndWait();
                                }else {
                             	   
                                
                                query = "DELETE FROM BS WHERE Num_bso ="+bon_sor.getNum_bso();
                                executeQuery(query);
                                showBonSortie();
                                getBon_SortieList();
                                }
                                
                            } catch (SQLException ex) {
                               
                            } catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
                            
                           

                          

                        });
                        editIcon.setOnAction((ActionEvent event) -> {
                            
                        	Bon_Sortie bon_sor = tv_Bon_Sortie.getSelectionModel().getSelectedItem();
                            
                            if(bon_sor == null) {
                         	   Alert alert = new Alert(Alert.AlertType.ERROR);
                                alert.setHeaderText(null);
                                alert.setContentText("Veuiller selecter une ligne");
                                alert.showAndWait();
                         	 
                            }else {
                            try {
                            	modifier_bon_sor(event);
                            } catch (Exception ex) {
                               
                            }

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

    	
	    	 Editer3.setCellFactory(cellFoctory);
        
		tv_Bon_Sortie.setItems(Bon_Sortie);
	}
	public void inserer_bon_sor(ActionEvent event) throws IOException{
		root =FXMLLoader.load(getClass().getResource("/school/Inserer_Bon_Sortie.fxml"));
		stage=(Stage)(((Node) event.getSource()).getScene().getWindow());
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void modifier_bon_sor(ActionEvent event) throws IOException {
		root =FXMLLoader.load(getClass().getResource("/school/Modifier_Bon_Sortie.fxml"));
		stage=(Stage)(((Node) event.getSource()).getScene().getWindow());
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	public void sauvegarder_insertion_bon_sor(ActionEvent event) throws IOException {
		String query="INSERT INTO BS VALUES ("+ tf_Num_bso.getText()+",'"+tf_Date_sor.getText()+"',"+tf_Code_emplo.getText()+")";
		try {
			executeQuery(query);
			showBonSortie();
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		revenir_page_acceuil(event,4);
	}
	
	public void sauvegarder_modification_bon_sor(ActionEvent event) throws Exception {
		String query="UPDATE BS set Date_sor='" + tf_Date_sor1.getText() + "',Code_emp='" + tf_Code_emplo1.getText() + "' WHERE Num_bso ="+ tf_Num_bso1.getText() ;
		try {
			executeQuery(query);
	    	showBonSortie();
    		
    	}
    	catch(Exception ex) { 
    }
		
    	revenir_page_acceuil(event,4);
	}
	
	//Partie Commune

	
	
	
	public Connection getConnection() throws  Exception{
		Connection con;
		try {
		Class.forName("oracle.jdbc.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","user2","1234");
		return con;
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			showEmployee();
		} catch (Exception e) {
			
			try {
				showDepartement();
			} catch (Exception e1) {
				
				try {
					showBon_Affectation();
				} catch (Exception e2) {
					
					try {
						showBonSortie();
					} catch (Exception e3) {
						
					}
				}
				
			}
			
		}
		
	}
	   private void executeQuery(String query) throws Exception {
	    	Connection con= getConnection();
	    	Statement st;
	    	try {
	    		st=con.createStatement();
	    		st.executeUpdate(query);
	    	}catch(Exception ex) {
	    		ex.printStackTrace();
	    	}
		}

		@FXML
	    void Annuler(ActionEvent event) throws IOException {
			int ou;
			if(event.getSource()==but_annuler)
			{	ou=2;
				revenir_page_acceuil(event,ou);
			}else if(event.getSource()==but_annuler1)
			{	ou=2;
			revenir_page_acceuil(event,ou);
			}else if(event.getSource()==but_annuler2)
			{	ou=1;
			revenir_page_acceuil(event,ou);
			}else if(event.getSource()==but_annuler3)
			{	ou=1;
			revenir_page_acceuil(event,ou);
			}else if(event.getSource()==but_annuler4)
			{	ou=3;
			revenir_page_acceuil(event,ou);
			}else if(event.getSource()==but_annuler5)
			{	ou=3;
			revenir_page_acceuil(event,ou);
			}else if(event.getSource()==but_annuler6)
			{	ou=4;
			revenir_page_acceuil(event,ou);
			}else if(event.getSource()==but_annuler7)
			{	ou=4;
			revenir_page_acceuil(event,ou);
			}
	    }
	    
	    void revenir_page_acceuil(ActionEvent event,int ou) throws IOException {
	    	if( ou== 1) {
	    		root =FXMLLoader.load(getClass().getResource("/school/Employee.fxml"));
	    		stage=(Stage)(((Node) event.getSource()).getScene().getWindow());
	    		scene = new Scene(root);
	    		stage.setScene(scene);
	    		stage.show();
	    	}else if(ou==2){
	    		root =FXMLLoader.load(getClass().getResource("/school/Departement.fxml"));
	    		stage=(Stage)(((Node) event.getSource()).getScene().getWindow());
	    		scene = new Scene(root);
	    		stage.setScene(scene);
	    		stage.show();
	    	}else if (ou==3) {
	    		root =FXMLLoader.load(getClass().getResource("/school/Bon_Affectation.fxml"));
	    		stage=(Stage)(((Node) event.getSource()).getScene().getWindow());
	    		scene = new Scene(root);
	    		stage.setScene(scene);
	    		stage.show();
	    	}else {
	    		root =FXMLLoader.load(getClass().getResource("/school/Bon_Sortie.fxml"));
	    		stage=(Stage)(((Node) event.getSource()).getScene().getWindow());
	    		scene = new Scene(root);
	    		stage.setScene(scene);
	    		stage.show();
	    	}
	    	}


	}
