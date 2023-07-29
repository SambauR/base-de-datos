package fes.aragon.modelos;

public class SociosEleccion {

	private int idSocios;
	private String nombre;
	private String apPaterno;
	
	public SociosEleccion() {
		// TODO Auto-generated constructor stub
	}

	public int getIdSocios() {
		return idSocios;
	}

	public void setIdSocios(int idSocios) {
		this.idSocios = idSocios;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApPaterno() {
		return apPaterno;
	}

	public void setApPaterno(String apPaterno) {
		this.apPaterno = apPaterno;
	}

	@Override
	public String toString() {
		return nombre + " " + apPaterno;
	}
	
	
}
