package fes.aragon.controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import fes.aragon.modelos.Membresias;
import fes.aragon.modelos.SociosSQL;
import fes.aragon.sql.Conexion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class AgregarSocioController extends BaseController implements Initializable{

    @FXML
    private Button btnAgregar;

    @FXML
    private Button btnCerrar;

    @FXML
    private ComboBox<Membresias> cmbMembresia;

    @FXML
    private TextField txtCorreo;

    @FXML
    private TextField txtMaterno;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtPaterno;

    @FXML
    private TextField txtTelefono;

    @FXML
    void agregarSocio(ActionEvent event) {
    	Membresias membresia = cmbMembresia.getValue();
    	String nombre = txtNombre.getText();
    	String paterno = txtPaterno.getText();
    	String materno = txtMaterno.getText();
    	String telefono = txtTelefono.getText();
    	String correo = txtCorreo.getText();
    	SociosSQL socio = new SociosSQL();
    	socio.setNombre(nombre);
    	socio.setPaterno(paterno);
    	socio.setMaterno(materno);
    	socio.setTelefono(telefono);
    	socio.setCorreo(correo);
    	socio.setMembresia(membresia);
    	
    	try {
			Conexion cnn = new Conexion();
			cnn.insertarSocio(socio);
			cnn.cerrarConexion();
			this.ventanaEmergente("AVISO", "EXITO", "SE AGREGO CORRECTAMENTE EL SOCIO");
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
		ObservableList<Membresias> items = FXCollections.observableArrayList();
		Conexion cn;
		try {
			cn = new Conexion();
			ArrayList<Membresias> info = cn.eleccionMembresias();
			for (Membresias membresias : info) {
				items.add(membresias);
			}
			this.cmbMembresia.setItems(items);
			this.cmbMembresia.getSelectionModel().selectFirst();
			
			cn.cerrarConexion();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
