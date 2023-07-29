package fes.aragon.controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import fes.aragon.modelos.Salidas;
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

public class SalidasController extends BaseController implements Initializable{

	@FXML
    private Button btnAgregar;
	
    @FXML
    private Button btnBuscar;

    @FXML
    private Button btnCerrar;

    @FXML
    private TableColumn<Salidas, String> clmDestino;

    @FXML
    private TableColumn<Salidas, String> clmFecha;

    @FXML
    private TableColumn<Salidas, String> clmHora;

    @FXML
    private TableColumn<Salidas, Integer> clmIdPSalida;

    @FXML
    private TableView<Salidas> tblSalidas;

    @FXML
    private TextField txtSalida;
    
    @FXML
    void agregarNuevaSalida(ActionEvent event) {
    	this.nuevaVentana("AgregarSalida");
    }

    @FXML
    void buscarSalida(ActionEvent event) {
    	try {
			Conexion cnn = new Conexion();
			ArrayList<Salidas> salida = cnn.buscarSalida(txtSalida.getText());
			this.tblSalidas.setItems(FXCollections.observableArrayList(salida));
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
		this.clmIdPSalida.setCellValueFactory(new PropertyValueFactory<>("idSalidas"));
		this.clmDestino.setCellValueFactory(new PropertyValueFactory<>("destino"));
		this.clmFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
		this.clmHora.setCellValueFactory(new PropertyValueFactory<>("hora"));
		this.tblSalidas.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Object>() {

			@Override
			public void changed(ObservableValue<? extends Object> arg0, Object arg1, Object arg2) {
				Salidas salida = (Salidas)arg2;
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("SALIDAS");
				alert.setHeaderText("DATOS DE LA SALIDA:");
				alert.setContentText(salida.toString());
				alert.showAndWait();
			}
		});
	}

}
