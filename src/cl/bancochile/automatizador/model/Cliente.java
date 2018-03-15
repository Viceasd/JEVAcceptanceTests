package cl.bancochile.automatizador.model;

import java.io.Serializable;

public class Cliente extends Persona implements Serializable {

	private static final long serialVersionUID = -1144142567776273613L;

	private String rut;

	private IdValueBean marca;

	private IdValueBean segmentoCliente;

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public IdValueBean getMarcaCliente() {
		return marca;
	}

	public void setMarcaCliente(IdValueBean marcaCliente) {
		this.marca = marcaCliente;
	}

	public IdValueBean getSegmentoCliente() {
		return segmentoCliente;
	}

	public void setSegmentoCliente(IdValueBean segmentoCliente) {
		this.segmentoCliente = segmentoCliente;
	}

}