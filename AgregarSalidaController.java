package fes.aragon.controller;

import java.sql.SQLException;

import fes.aragon.modelos.Salidas;
import fes.aragon.sql.Conexion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AgregarSalidaController extends BaseController {

    @FXML
    private Button btnAgregar;

    @FXML
    private Button btnCerrar;

    @FXML
    private TextField txtDestino;

    @FXML
    private TextField txtFecha;

    @FXML
    private TextField txtHora;

    @FXML
    void agregarSalida(ActionEvent event) {
    	String destino = txtDestino.getText();
    	String fecha = txtFecha.getText();
    	String hora = txtHora.getText();
    	Salidas salida = new Salidas();
    	salida.setDestino(destino);
    	salida.setFecha(fecha);
    	salida.setHora(hora);
    	
    	try {
			Conexion cnn = new Conexion();
			cnn.insertarSalidas(salida);
			cnn.cerrarConexion();
			this.ventanaEmergente("AVISO", "EXITO", "SE AGREGO CORRECTAMENTE LA SALIDA");
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
