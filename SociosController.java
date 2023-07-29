package fes.aragon.controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import fes.aragon.modelos.Socios;
import fes.aragon.sql.Conexion;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class SociosController extends BaseController implements Initializable{

	@FXML
    private Button btnAgregar;

    @FXML
    private Button btnBuscar;

    @FXML
    private Button btnCerrar;

    @FXML
    private TableColumn<Socios, String> clmApMaterno;

    @FXML
    private TableColumn<Socios, String> clmApPaterno;

    @FXML
    private TableColumn<Socios, String> clmCorreo;

    @FXML
    private TableColumn<Socios, String> clmIdMemb;

    @FXML
    private TableColumn<Socios, Integer> clmIdSocio;

    @FXML
    private TableColumn<Socios, String> clmNombre;

    @FXML
    private TableColumn<Socios, String> clmTelefono;

    @FXML
    private TableView<Socios> tblSocios;

    @FXML
    private TextField txtSocio;

    @FXML
    void agregarNuevoSocio(ActionEvent event) {
    	this.nuevaVentana("AgregarSocio");
    }
    
    @FXML
    void buscarSocio(ActionEvent event) {
    	try {
			Conexion cnn = new Conexion();
			ArrayList<Socios> socio = cnn.buscarSocio(txtSocio.getText());
			this.tblSocios.setItems(FXCollections.observableArrayList(socio));
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
		this.clmIdSocio.setCellValueFactory(new PropertyValueFactory<>("idSocios"));
		this.clmIdMemb.setCellValueFactory(new PropertyValueFactory<>("membresias"));
		this.clmNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		this.clmApPaterno.setCellValueFactory(new PropertyValueFactory<>("apPaterno"));
		this.clmApMaterno.setCellValueFactory(new PropertyValueFactory<>("apMaterno"));
		this.clmTelefono.setCellValueFactory(new PropertyValueFactory<>("telefeno"));
		this.clmCorreo.setCellValueFactory(new PropertyValueFactory<>("correo"));
		this.tblSocios.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Object>() {

			@Override
			public void changed(ObservableValue<? extends Object> arg0, Object arg1, Object arg2) {
				Socios socio = (Socios)arg2;
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("SOCIO");
				alert.setHeaderText("DATOS DEL SOCIO:");
				alert.setContentText(socio.toString());
				alert.showAndWait();
			}
		});
	}

}
