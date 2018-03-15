package cl.bancochile.automatizador.model;

import java.io.Serializable;

public class DatosPersona implements Serializable {

	private static final long serialVersionUID = 4992183581045348143L;

	private String rut;

	private String usuario;

	private String nombre;

	private String numeroEmpleado;

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNumeroEmpleado() {
		return numeroEmpleado;
	}

	public void setNumeroEmpleado(String numeroEmpleado) {
		this.numeroEmpleado = numeroEmpleado;
	}
}
