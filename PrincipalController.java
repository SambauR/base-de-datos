package fes.aragon.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class PrincipalController extends BaseController{

    @FXML
    private Button btnBarcos;

    @FXML
    private Button btnPatrones;

    @FXML
    private Button btnSalir;

    @FXML
    private Button btnSocios;

    @FXML
    void abrirBarcos(ActionEvent event) {
    	this.nuevaVentana("Barcos");
    	this.ventanaEmergente("AVISO", "AVISO", "ANTES DE INGRESAR UN BARCO VERIFIQUE BIEN SU SALIDA");
    }

    @FXML
    void abrirPatrones(ActionEvent event) {
    	this.nuevaVentana("Patrones");
    }

    @FXML
    void abrirSocios(ActionEvent event) {
    	this.nuevaVentana("Socios");
    }

    @FXML
    void cerrarVentana(ActionEvent event) {
    	this.cerrarVentana(btnSalir);
    }

}
