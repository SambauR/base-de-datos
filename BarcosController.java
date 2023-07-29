package fes.aragon.controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import fes.aragon.modelos.Barcos;
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

public class BarcosController extends BaseController implements Initializable{

	@FXML
    private Button btnAgregar;
	
	@FXML
    private Button btnSalidas;
	
    @FXML
    private Button btnBuscar;

    @FXML
    private Button btnCerrar;
    
    @FXML
    private TableColumn<Barcos, String> clmDestinos;

    @FXML
    private TableColumn<Barcos, String> clmAmarre;

    @FXML
    private TableColumn<Barcos, Integer> clmIdBarco;

    @FXML
    private TableColumn<Barcos, String> clmNombre;

    @FXML
    private TableColumn<Barcos, String> clmPatron;

    @FXML
    private TableColumn<Barcos, String> clmSocio;

    @FXML
    private TableColumn<Barcos, String> clmTipoBarco;

    @FXML
    private TableView<Barcos> tblBarcos;

    @FXML
    private TextField txtBarco;

    @FXML
    void agregarBarco(ActionEvent event) {
    	this.nuevaVentana("AgregarBarco");
    }
    
    @FXML
    void verSalidas(ActionEvent event) {
    	this.nuevaVentana("Salidas");
    }
    
    @FXML
    void buscarBarco(ActionEvent event) {
    	try {
			Conexion cnn = new Conexion();
			ArrayList<Barcos> barco = cnn.buscarBarco(txtBarco.getText());
			this.tblBarcos.setItems(FXCollections.observableArrayList(barco));
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
		this.clmIdBarco.setCellValueFactory(new PropertyValueFactory<>("idBarco"));
		this.clmSocio.setCellValueFactory(new PropertyValueFactory<>("socio"));
		this.clmPatron.setCellValueFactory(new PropertyValueFactory<>("patron"));
		this.clmTipoBarco.setCellValueFactory(new PropertyValueFactory<>("tipoBarco"));
		this.clmAmarre.setCellValueFactory(new PropertyValueFactory<>("numAmarre"));
		this.clmNombre.setCellValueFactory(new PropertyValueFactory<>("nombreBarco"));
		this.clmDestinos.setCellValueFactory(new PropertyValueFactory<>("destinos"));
		this.tblBarcos.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Object>() {

			@Override
			public void changed(ObservableValue<? extends Object> arg0, Object arg1, Object arg2) {
				Barcos barco = (Barcos)arg2;
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("BARCO");
				alert.setHeaderText("DATOS DEL BARCO:");
				alert.setContentText(barco.toString());
				alert.showAndWait();
			}
		});
	}

}
