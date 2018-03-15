package cl.bancochile.automatizador.model;

import java.io.Serializable;
import java.util.Date;

public class TarjetaAdicional implements Serializable {

	private static final long serialVersionUID = -6142294185960243699L;

	private String rut;

	private String nombres;

	private String apellidoPaterno;

	private String apellidoMaterno;

	private Date fechaNacimiento;

	private String nombreCompleto;

	private String tipoTarjeta;

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public Date getFechaNacimiento() {
		return (Date) fechaNacimiento.clone();
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = (Date) fechaNacimiento.clone();
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public String getTipoTarjeta() {
		return tipoTarjeta;
	}

	public void setTipoTarjeta(String tipoTarjeta) {
		this.tipoTarjeta = tipoTarjeta;
	}

}