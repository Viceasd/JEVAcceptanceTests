package cl.bancochile.automatizador.model;

import java.io.Serializable;

public class IdOportunidad implements Serializable {

	private static final long serialVersionUID = 1L;

	private String uuidOportunidad;

	public String getUuidOportunidad() {
		return uuidOportunidad;
	}

	public void setUuidOportunidad(String uuidOportunidad) {
		this.uuidOportunidad = uuidOportunidad;
	}

}