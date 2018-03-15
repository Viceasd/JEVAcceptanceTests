package cl.bancochile.automatizador.model;

import java.io.Serializable;
import java.util.Date;

public class OportunidadResumen implements Serializable {

	private static final long serialVersionUID = 5520939601701144690L;

	private int nroReg;

	private String uuidOportunidad;

	private Date fechaCreacion;

	private String canal;

	private String ejecutivo;

	private String codOficina;

	private String estado;

	public int getNroReg() {
		return nroReg;
	}

	public void setNroReg(int nroReg) {
		this.nroReg = nroReg;
	}

	public String getUuidOportunidad() {
		return uuidOportunidad;
	}

	public void setUuidOportunidad(String uuidOportunidad) {
		this.uuidOportunidad = uuidOportunidad;
	}

	public Date getFechaCreacion() {
		return (Date) fechaCreacion.clone();
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = (Date) fechaCreacion.clone();
	}

	public String getCanal() {
		return canal;
	}

	public void setCanal(String canal) {
		this.canal = canal;
	}

	public String getEjecutivo() {
		return ejecutivo;
	}

	public void setEjecutivo(String ejecutivo) {
		this.ejecutivo = ejecutivo;
	}

	public String getCodOficina() {
		return codOficina;
	}

	public void setCodOficina(String codOficina) {
		this.codOficina = codOficina;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
