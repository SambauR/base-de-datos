package fes.aragon.modelos;

public class SociosSQL {

	private int id;
	private Membresias membresia;
	private String nombre;
	private String paterno;
	private String materno;
	private String telefono;
	private String correo;
	
	public SociosSQL() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Membresias getMembresia() {
		return membresia;
	}

	public void setMembresia(Membresias membresia) {
		this.membresia = membresia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPaterno() {
		return paterno;
	}

	public void setPaterno(String paterno) {
		this.paterno = paterno;
	}

	public String getMaterno() {
		return materno;
	}

	public void setMaterno(String materno) {
		this.materno = materno;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	@Override
	public String toString() {
		return "SociosSQL [id=" + id + ", membresia=" + membresia + ", nombre=" + nombre + ", paterno=" + paterno
				+ ", materno=" + materno + ", telefono=" + telefono + ", correo=" + correo + "]";
	}
	
}
