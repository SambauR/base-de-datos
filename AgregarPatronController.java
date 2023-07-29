package fes.aragon.controller;

import java.sql.SQLException;

import fes.aragon.modelos.Patrones;
import fes.aragon.sql.Conexion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AgregarPatronController extends BaseController{

    @FXML
    private Button btnAgregar;

    @FXML
    private Button btnCerrar;

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
    void agregarPatron(ActionEvent event) {
    	String nombre = txtNombre.getText();
    	String paterno = txtPaterno.getText();
    	String materno = txtMaterno.getText();
    	String telefono = txtTelefono.getText();
    	String correo = txtCorreo.getText();
    	Patrones patron = new Patrones();
    	patron.setNombre(nombre);
    	patron.setApPaterno(paterno);
    	patron.setApMaterno(materno);
    	patron.setTelefeno(telefono);
    	patron.setCorreo(correo);
    	
    	try {
			Conexion cn = new Conexion();
			cn.insertarPatron(patron);
			cn.cerrarConexion();
			this.ventanaEmergente("AVISO", "EXITO", "SE AGREGO CORRECTAMENTE EL PATRÓN");
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

}
