package cl.bancochile.automatizador.model;

import java.io.Serializable;

public class Caso implements Serializable {

	private static final long serialVersionUID = -5423141608681860947L;
	private String Valor;

	public String getValor() {
		return Valor;
	}

	public void setValor(String Valor) {
		this.Valor = Valor;
	}

}
