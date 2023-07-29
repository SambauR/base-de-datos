package fes.aragon.controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import fes.aragon.modelos.Patrones;
import fes.aragon.sql.Conexion;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

public class PatronesController extends BaseController implements Initializable{

	@FXML
    private Button btnAgregar;
	
    @FXML
    private Button btnBuscar;

    @FXML
    private Button btnCerrar;

    @FXML
    private TableColumn<Patrones, String> clmApMaterno;

    @FXML
    private TableColumn<Patrones, String> clmApPaterno;

    @FXML
    private TableColumn<Patrones, String> clmCorreo;

    @FXML
    private TableColumn<Patrones, Integer> clmIdPatron;

    @FXML
    private TableColumn<Patrones, String> clmNombre;

    @FXML
    private TableColumn<Patrones, String> clmTelefono;

    @FXML
    private TableView<Patrones> tblPatrones;

    @FXML
    private TextField txtPatrones;
    
    @FXML
    void agregarNuevoPatron(ActionEvent event) {
    	this.nuevaVentana("AgregarPatron");
    }

    @FXML
    void buscarPatron(ActionEvent event) {
    	try {
			Conexion cnn = new Conexion();
			ArrayList<Patrones> patron = cnn.buscarPatron(txtPatrones.getText());
			this.tblPatrones.setItems(FXCollections.observableArrayList(patron));
			cnn.cerrarConexion();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void cerrarVentana(ActionEvent event) {
    	this.cerrarVentana(btnCerrar);
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.clmIdPatron.setCellValueFactory(new PropertyValueFactory<>("idPatrones"));
		this.clmNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		this.clmApPaterno.setCellValueFactory(new PropertyValueFactory<>("apPaterno"));
		this.clmApMaterno.setCellValueFactory(new PropertyValueFactory<>("apMaterno"));
		this.clmTelefono.setCellValueFactory(new PropertyValueFactory<>("telefeno"));
		this.clmCorreo.setCellValueFactory(new PropertyValueFactory<>("correo"));
		this.tblPatrones.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Object>() {

			@Override
			public void changed(ObservableValue<? extends Object> arg0, Object arg1, Object arg2) {
				Patrones patron = (Patrones)arg2;
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("PATRÓN");
				alert.setHeaderText("DATOS DEL PATRÓN:");
				alert.setContentText(patron.toString());
				alert.showAndWait();
			}
		});
	}

}
