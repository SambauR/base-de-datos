package fes.aragon.modelos;

public class DestinoEleccion {

	private int idDestino;
	private String destino;
	
	public DestinoEleccion() {
		// TODO Auto-generated constructor stub
	}

	public int getIdDestino() {
		return idDestino;
	}

	public void setIdDestino(int idDestino) {
		this.idDestino = idDestino;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	@Override
	public String toString() {
		return destino;
	}
	
	
}
