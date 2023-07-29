package fes.aragon.modelos;

public class PatronesEleccion {

	private int idPatron;
	private String nombre;
	private String apPaterno;
	
	public PatronesEleccion() {
		// TODO Auto-generated constructor stub
	}

	public int getIdPatron() {
		return idPatron;
	}

	public void setIdPatron(int idPatron) {
		this.idPatron = idPatron;
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
