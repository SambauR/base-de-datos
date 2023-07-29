package fes.aragon.modelos;

public class Socios {

	private int idSocios;
	private String membresias;
	private String nombre;
	private String apPaterno;
	private String apMaterno;
	private String telefeno;
	private String correo;
	
	public Socios() {
		// TODO Auto-generated constructor stub
	}

	public Socios(int idSocios, String nombre, String apPaterno) {
		super();
		this.idSocios = idSocios;
		this.nombre = nombre;
		this.apPaterno = apPaterno;
	}

	public int getIdSocios() {
		return idSocios;
	}

	public void setIdSocios(int idSocios) {
		this.idSocios = idSocios;
	}

	public String getMembresias() {
		return membresias;
	}

	public void setMembresias(String membresias) {
		this.membresias = membresias;
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

	public String getApMaterno() {
		return apMaterno;
	}

	public void setApMaterno(String apMaterno) {
		this.apMaterno = apMaterno;
	}

	public String getTelefeno() {
		return telefeno;
	}

	public void setTelefeno(String telefeno) {
		this.telefeno = telefeno;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	@Override
	public String toString() {
		return "Socios [idSocios=" + idSocios + ", membresias=" + membresias + ", nombre=" + nombre + ", apPaterno="
				+ apPaterno + ", apMaterno=" + apMaterno + ", telefeno=" + telefeno + ", correo=" + correo + "]";
	}
	
}
