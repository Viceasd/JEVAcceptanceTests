package cl.bancochile.automatizador.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "idOpoprtunidad", "idBmp", "idProd", "codResponse", "nombServicio", "fechaLog", "request",
		"response" })
public class LogOportunidad implements Serializable {

	private static final long serialVersionUID = -1292191779250302584L;

	private String idOpoprtunidad;

	private String idProd;

	private String idBmp;

	private transient Object request;

	private String codResponse;

	private transient Object response;

	private String nombServicio;

	private java.util.Date fechaLog;

	public String getIdOpoprtunidad() {
		return idOpoprtunidad;
	}

	public void setIdOpoprtunidad(String idOpoprtunidad) {
		this.idOpoprtunidad = idOpoprtunidad;
	}

	public String getIdProd() {
		return idProd;
	}

	public void setIdProd(String idProd) {
		this.idProd = idProd;
	}

	public Object getRequest() {
		return request;
	}

	public void setRequest(Object request) {
		this.request = request;
	}

	public String getCodResponse() {
		return codResponse;
	}

	public void setCodResponse(String codResponse) {
		this.codResponse = codResponse;
	}

	public Object getResponse() {
		return response;
	}

	public void setResponse(Object response) {
		this.response = response;
	}

	public String getNombServicio() {
		return nombServicio;
	}

	public void setNombServicio(String nombServicio) {
		this.nombServicio = nombServicio;
	}

	public java.util.Date getFechaLog() {
		return (Date) fechaLog.clone();
	}

	public void setFechaLog(java.util.Date fechaLog) {
		this.fechaLog = (Date) fechaLog.clone();
	}

	public String getIdBmp() {
		return idBmp;
	}

	public void setIdBmp(String idBmp) {
		this.idBmp = idBmp;
	}

}
