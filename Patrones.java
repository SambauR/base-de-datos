package fes.aragon.modelos;

public class Patrones {

	private int idPatrones;
	private String nombre;
	private String apPaterno;
	private String apMaterno;
	private String telefeno;
	private String correo;
	
	public Patrones() {
		// TODO Auto-generated constructor stub
	}

	public int getIdPatrones() {
		return idPatrones;
	}

	public void setIdPatrones(int idPatrones) {
		this.idPatrones = idPatrones;
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
		return "Patrones [idPatrones=" + idPatrones + ", nombre=" + nombre + ", apPaterno=" + apPaterno + ", apMaterno="
				+ apMaterno + ", telefeno=" + telefeno + ", correo=" + correo + "]";
	}

}
