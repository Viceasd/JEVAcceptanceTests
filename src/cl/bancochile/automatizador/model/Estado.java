package cl.bancochile.automatizador.model;

import java.io.Serializable;

public class Estado implements Serializable {

	private static final long serialVersionUID = -2864957264204461392L;

	private int codigoEstado;

	public int getCodigoEstado() {
		return this.codigoEstado;
	}

	public void setCodigoEstado(int codigoEstado) {
		this.codigoEstado = codigoEstado;
	}

	private String nombreEstado;

	public String getNombreEstado() {
		return this.nombreEstado;
	}

	public void setNombreEstado(String nombreEstado) {
		this.nombreEstado = nombreEstado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigoEstado;
		result = prime * result + ((nombreEstado == null) ? 0 : nombreEstado.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estado other = (Estado) obj;
		if (codigoEstado != other.codigoEstado)
			return false;
		if (nombreEstado == null) {
			if (other.nombreEstado != null)
				return false;
		} else if (!nombreEstado.equals(other.nombreEstado))
			return false;
		return true;
	}

}