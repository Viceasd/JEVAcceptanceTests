package cl.bancochile.automatizador.model;

import java.io.Serializable;

public class Autorizadores implements Serializable {

	private static final long serialVersionUID = -1662021140191246997L;

	private int idAutorizador;

	public int getIdAutorizador() {
		return this.idAutorizador;
	}

	public void setIdAutorizador(int idAutorizador) {
		this.idAutorizador = idAutorizador;
	}

	private Object idSolicitud;

	public Object getIdSolicitud() {
		return this.idSolicitud;
	}

	public void setIdSolicitud(Object idSolicitud) {
		this.idSolicitud = idSolicitud;
	}

	private String rut;

	public String getRut() {
		return this.rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	private String nombreCompleto;

	public String getNombreCompleto() {
		return this.nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	private Cargo cargo;

	public Cargo getCargo() {
		return this.cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	private String cui;

	public String getCui() {
		return this.cui;
	}

	public void setCui(String cui) {
		this.cui = cui;
	}

	private boolean estadoAutorizacion;

	public boolean getEstadoAutorizacion() {
		return this.estadoAutorizacion;
	}

	public void setEstadoAutorizacion(boolean estadoAutorizacion) {
		this.estadoAutorizacion = estadoAutorizacion;
	}
}