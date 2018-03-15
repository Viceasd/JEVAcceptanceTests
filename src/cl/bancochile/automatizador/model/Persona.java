package cl.bancochile.automatizador.model;

import java.io.Serializable;

public class Persona implements Serializable {

	private static final long serialVersionUID = 8680378832072321757L;

	private String apellidoPaterno;

	private String apellidoMaterno;

	private String nombres;

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

}