package fes.aragon.modelos;

public class Membresias {

	private int idMembresia;
	private String nombreMembresia;
	
	public Membresias() {
		// TODO Auto-generated constructor stub
	}

	public Membresias(int idMembresia, String nombreMembresia) {
		super();
		this.idMembresia = idMembresia;
		this.nombreMembresia = nombreMembresia;
	}

	public int getIdMembresia() {
		return idMembresia;
	}

	public void setIdMembresia(int idMembresia) {
		this.idMembresia = idMembresia;
	}

	public String getNombreMembresia() {
		return nombreMembresia;
	}

	public void setNombreMembresia(String nombreMembresia) {
		this.nombreMembresia = nombreMembresia;
	}

	@Override
	public String toString() {
		return nombreMembresia;
	}
	
}
