package fes.aragon.modelos;

public class TiposBarcos {

	private int idTipoBarco;
	private String nombre;
	
	public TiposBarcos() {
		// TODO Auto-generated constructor stub
	}

	public TiposBarcos(int idTipoBarco, String nombre) {
		super();
		this.idTipoBarco = idTipoBarco;
		this.nombre = nombre;
	}

	public int getIdTipoBarco() {
		return idTipoBarco;
	}

	public void setIdTipoBarco(int idTipoBarco) {
		this.idTipoBarco = idTipoBarco;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return nombre;
	}
	
	
}
