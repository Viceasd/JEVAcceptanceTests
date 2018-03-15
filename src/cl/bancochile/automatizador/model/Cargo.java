package cl.bancochile.automatizador.model;

import java.io.Serializable;

public class Cargo implements Serializable {

	private static final long serialVersionUID = -5928057283119128623L;

	private String codCargo;

	public String getCodCargo() {
		return this.codCargo;
	}

	public void setCodCargo(String codCargo) {
		this.codCargo = codCargo;
	}

	private String nombreCargo;

	public String getNombreCargo() {
		return this.nombreCargo;
	}

	public void setNombreCargo(String nombreCargo) {
		this.nombreCargo = nombreCargo;
	}
}