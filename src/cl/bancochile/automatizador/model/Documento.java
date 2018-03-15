package cl.bancochile.automatizador.model;

import java.io.Serializable;
import java.util.Date;

public class Documento implements Serializable {

	private static final long serialVersionUID = 8350883350078985552L;

	private String nombre;

	private String tipoMime;

	private Date fechaIngreso;

	private Date fechaExpiracion;

	private String idDocumento;

	private String tipoDocumento;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipoMime() {
		return tipoMime;
	}

	public void setTipoMime(String tipoMime) {
		this.tipoMime = tipoMime;
	}

	public Date getFechaIngreso() {
		return (Date) fechaIngreso.clone();
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = (Date) fechaIngreso.clone();
	}

	public Date getFechaExpiracion() {
		return (Date) fechaExpiracion.clone();
	}

	public void setFechaExpiracion(Date fechaExpiracion) {
		this.fechaExpiracion = (Date) fechaExpiracion.clone();
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDirectorio(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getIdDocumento() {
		return idDocumento;
	}

	public void setIdDocumento(String idDocumento) {
		this.idDocumento = idDocumento;
	}

}
