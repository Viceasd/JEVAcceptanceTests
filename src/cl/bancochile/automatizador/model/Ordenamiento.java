package cl.bancochile.automatizador.model;

import java.io.Serializable;

public class Ordenamiento implements Serializable{

	private static final long serialVersionUID = 4506725595671280514L;
	
	private String ordenadoPor;
	private String orden;

	public String getOrdenadoPor() {
		return ordenadoPor;
	}

	public void setOrdenadoPor(String ordenadoPor) {
		this.ordenadoPor = ordenadoPor;
	}

	public String getOrden() {
		return orden;
	}

	public void setOrden(String orden) {
		this.orden = orden;
	}
}
