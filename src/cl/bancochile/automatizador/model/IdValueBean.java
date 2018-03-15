package cl.bancochile.automatizador.model;

import java.io.Serializable;

public class IdValueBean implements Serializable {

	private static final long serialVersionUID = -6082315031770938005L;

	private String id;

	private String nombre;

	public IdValueBean() {
		// Default constructor
	}

	public IdValueBean(String id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}