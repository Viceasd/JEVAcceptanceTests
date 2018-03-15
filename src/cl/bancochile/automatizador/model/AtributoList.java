package cl.bancochile.automatizador.model;

import java.io.Serializable;
import java.util.List;

public class AtributoList implements Serializable {

	private static final long serialVersionUID = -5657317541826784089L;

	private List<Atributo> atributos;

	public List<Atributo> getAtributos() {
		return atributos;
	}

	public void setAtributos(List<Atributo> atributos) {
		this.atributos = atributos;
	}
}
