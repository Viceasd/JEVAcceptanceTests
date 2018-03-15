package cl.bancochile.automatizador.model;

import java.io.Serializable;

public class Agente extends Persona implements Serializable {

	private static final long serialVersionUID = -4752867663778656492L;

	private String numeroEmpleado;

	public String getNumeroEmpleado() {
		return numeroEmpleado;
	}

	public void setNumeroEmpleado(String numeroEmpleado) {
		this.numeroEmpleado = numeroEmpleado;
	}

}