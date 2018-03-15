package cl.bancochile.automatizador.model;

import java.io.Serializable;

public class ContOportunidades implements Serializable {

	private static final long serialVersionUID = -8541625720056949563L;

	private int cantOportunidades = 0;

	public int getCantOportunidades() {
		return cantOportunidades;
	}

	public void setCantOportunidades(int cantOportunidades) {
		this.cantOportunidades = cantOportunidades;
	}
}
