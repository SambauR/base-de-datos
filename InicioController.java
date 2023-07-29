package fes.aragon.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class InicioController extends BaseController implements Initializable {

    @FXML
    private Button btnAceptar;

    @FXML
    private Button btnCerrar;

    @FXML
    private TextField txtContraseniaInicio;

    @FXML
    private TextField txtCorreoInicio;

    @FXML
    void aceptarInicio(ActionEvent event) {
    	this.nuevaVentana("Principal");
    	this.cerrarVentana(btnAceptar);
    }

    @FXML
    void cerrarInicio(ActionEvent event) {
    	Platform.exit();
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		this.txtCorreoInicio.setText("example.correo@aragon.unam");
		this.txtContraseniaInicio.setText("*****************");
	}

}
