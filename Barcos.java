package fes.aragon.modelos;

public class Barcos {

	private int idBarco;
	private String socio;
	private String patron;
	private String tipoBarco;
	private String numAmarre;
	private String nombreBarco;
	private String destinos;

	public String getDestinos() {
		return destinos;
	}

	public void setDestinos(String destinos) {
		this.destinos = destinos;
	}

	public Barcos() {
		// TODO Auto-generated constructor stub
	}

	public int getIdBarco() {
		return idBarco;
	}

	public void setIdBarco(int idBarco) {
		this.idBarco = idBarco;
	}

	public String getSocio() {
		return socio;
	}

	public void setSocio(String socio) {
		this.socio = socio;
	}

	public String getPatron() {
		return patron;
	}

	public void setPatron(String patron) {
		this.patron = patron;
	}

	public String getTipoBarco() {
		return tipoBarco;
	}

	public void setTipoBarco(String tipoBarco) {
		this.tipoBarco = tipoBarco;
	}

	public String getNumAmarre() {
		return numAmarre;
	}

	public void setNumAmarre(String numAmarre) {
		this.numAmarre = numAmarre;
	}

	public String getNombreBarco() {
		return nombreBarco;
	}

	public void setNombreBarco(String nombreBarco) {
		this.nombreBarco = nombreBarco;
	}

	@Override
	public String toString() {
		return "Barcos [idBarco=" + idBarco + ", socio=" + socio + ", patron=" + patron + ", tipoBarco=" + tipoBarco
				+ ", numAmarre=" + numAmarre + ", nombreBarco=" + nombreBarco + ", destinos=" + destinos + "]";
	}

}
