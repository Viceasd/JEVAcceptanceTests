package cl.bancochile.automatizador.model;

import java.io.Serializable;

public class Atributo implements Serializable {

	private static final long serialVersionUID = -5503766539516219089L;
	private String idAtributo;
	private String nombre;
	private String valor;
	private String entrada;

	public String getIdAtributo() {
		return idAtributo;
	}

	public void setIdAtributo(String idAtributo) {
		this.idAtributo = idAtributo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getEntrada() {
		return entrada;
	}

	public void setEntrada(String entrada) {
		this.entrada = entrada;
	}

}