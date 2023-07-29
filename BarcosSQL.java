package fes.aragon.modelos;

public class BarcosSQL {
	
	private int idBarco;
	private SociosEleccion socio;
	private PatronesEleccion patron;
	private TiposBarcos tipoBarco;
	private DestinoEleccion destino;
	private String numeroAmarre;
	private String nombre;
	
	public BarcosSQL() {
		// TODO Auto-generated constructor stub
	}

	public DestinoEleccion getDestino() {
		return destino;
	}

	public void setDestino(DestinoEleccion destino) {
		this.destino = destino;
	}

	public int getIdBarco() {
		return idBarco;
	}

	public void setIdBarco(int idBarco) {
		this.idBarco = idBarco;
	}

	public SociosEleccion getSocio() {
		return socio;
	}

	public void setSocio(SociosEleccion socio) {
		this.socio = socio;
	}

	public PatronesEleccion getPatron() {
		return patron;
	}

	public void setPatron(PatronesEleccion patron) {
		this.patron = patron;
	}

	public TiposBarcos getTipoBarco() {
		return tipoBarco;
	}

	public void setTipoBarco(TiposBarcos tipoBarco) {
		this.tipoBarco = tipoBarco;
	}

	public String getNumeroAmarre() {
		return numeroAmarre;
	}

	public void setNumeroAmarre(String numeroAmarre) {
		this.numeroAmarre = numeroAmarre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "BarcosSQL [idBarco=" + idBarco + ", socio=" + socio + ", patron=" + patron + ", tipoBarco=" + tipoBarco
				+ ", destino=" + destino + ", numeroAmarre=" + numeroAmarre + ", nombre=" + nombre + "]";
	}
	
}
