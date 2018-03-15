package cl.bancochile.automatizador.model;

import java.io.Serializable;

public class Ejecutivo extends Persona implements Serializable {

	private static final long serialVersionUID = 1L;

	private String numeroEmpleado;

	private IdValueBean marca;

	public String getNumeroEmpleado() {
		return numeroEmpleado;
	}

	public void setNumeroEmpleado(String numeroEmpleado) {
		this.numeroEmpleado = numeroEmpleado;
	}

	public IdValueBean getMarca() {
		return marca;
	}

	public void setMarca(IdValueBean marca) {
		this.marca = marca;
	}

}