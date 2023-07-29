package fes.aragon.modelos;

public class Salidas {

	private int idSalidas;
	private String destino;
	private String fecha;
	private String hora;
	
	public Salidas() {
		// TODO Auto-generated constructor stub
	}

	public int getIdSalidas() {
		return idSalidas;
	}

	public void setIdSalidas(int idSalidas) {
		this.idSalidas = idSalidas;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	@Override
	public String toString() {
		return "Salidas [idSalidas=" + idSalidas + ", destino=" + destino + ", fecha=" + fecha + ", hora=" + hora + "]";
	}
	
	
}
