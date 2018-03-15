package cl.bancochile.automatizador.model;

import java.io.Serializable;

public class Productos implements Serializable{

	private static final long serialVersionUID = -8749936505711007115L;

	private String idProducto;
	private transient Object reglasBPM;

	public String getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}

	public Object getReglasBPM() {
		return reglasBPM;
	}

	public void setReglasBPM(Object reglasBPM) {
		this.reglasBPM = reglasBPM;
	}  
	
	
}
