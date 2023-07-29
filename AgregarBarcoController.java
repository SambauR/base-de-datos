package fes.aragon.controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import fes.aragon.modelos.BarcosSQL;
import fes.aragon.modelos.DestinoEleccion;
import fes.aragon.modelos.PatronesEleccion;
import fes.aragon.modelos.SociosEleccion;
import fes.aragon.modelos.TiposBarcos;
import fes.aragon.sql.Conexion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class AgregarBarcoController extends BaseController implements Initializable{

    @FXML
    private Button btnAgregar;

    @FXML
    private Button btnCerrar;
    
    @FXML
    private ComboBox<DestinoEleccion> cmbDestino;

    @FXML
    private ComboBox<PatronesEleccion> cmbPatron;

    @FXML
    private ComboBox<SociosEleccion> cmbSocio;

    @FXML
    private ComboBox<TiposBarcos> cmbTipoBarco;

    @FXML
    private TextField txtAmarre;

    @FXML
    private TextField txtNombre;

    @FXML
    void agregarBarco(ActionEvent event) {
    	TiposBarcos tipoBarco = cmbTipoBarco.getValue();
    	SociosEleccion socio = cmbSocio.getValue();
    	PatronesEleccion patron = cmbPatron.getValue();
    	DestinoEleccion destino = cmbDestino.getValue();
    	String numeroAmrarre = txtAmarre.getText();
    	String nombre = txtNombre.getText();
    	
    	BarcosSQL barco = new BarcosSQL();
    	barco.setNombre(nombre);
    	barco.setNumeroAmarre(numeroAmrarre);
    	barco.setTipoBarco(tipoBarco);
    	barco.setSocio(socio);
    	barco.setPatron(patron);
    	
    	try {
			Conexion cnn = new Conexion();
			int id = cnn.insertarBarco(barco);
			barco.setIdBarco(id);
			cnn.insertarBarscosSalidas(barco, destino);
			cnn.cerrarConexion();
			this.ventanaEmergente("AVISO", "EXITO", "SE AGREGO CORRECTAMENTE EL BARCO");
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
		ObservableList<TiposBarcos> itemsTipos = FXCollections.observableArrayList();
		ObservableList<SociosEleccion> itemsSocios = FXCollections.observableArrayList();
		ObservableList<PatronesEleccion> itemsPatrones = FXCollections.observableArrayList();
		ObservableList<DestinoEleccion> itemsDestinos = FXCollections.observableArrayList();
		
		Conexion cnn;
		try {
			cnn = new Conexion();
			
			////////////////////////////////////////////////////////
			ArrayList<TiposBarcos> infoTipos = cnn.eleccionTiposBarcos();
			for (TiposBarcos tiposBarcos : infoTipos) {
				itemsTipos.add(tiposBarcos);
			}
			this.cmbTipoBarco.setItems(itemsTipos);
			this.cmbTipoBarco.getSelectionModel().selectFirst();
			////////////////////////////////////////////////////////
			ArrayList<SociosEleccion> infoSocios = cnn.eleccionSocios();
			for (SociosEleccion socios : infoSocios) {
				itemsSocios.add(socios);
			}
			this.cmbSocio.setItems(itemsSocios);
			this.cmbSocio.getSelectionModel().selectFirst();
			/////////////////////////////////////////////////////////
			ArrayList<PatronesEleccion> infoPatrones = cnn.eleccionPatrones();
			for (PatronesEleccion patrones : infoPatrones) {
				itemsPatrones.add(patrones);
			}
			this.cmbPatron.setItems(itemsPatrones);
			this.cmbPatron.getSelectionModel().selectFirst();
			////////////////////////////////////////////////////////////
			ArrayList<DestinoEleccion> infoDestinos = cnn.eleccionDestinos();
			for (DestinoEleccion destinos : infoDestinos) {
				itemsDestinos.add(destinos);
			}
			this.cmbDestino.setItems(itemsDestinos);
			this.cmbDestino.getSelectionModel().selectFirst();
			
			
			cnn.cerrarConexion();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
