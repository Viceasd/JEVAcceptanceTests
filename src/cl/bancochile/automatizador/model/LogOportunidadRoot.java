package cl.bancochile.automatizador.model;

import java.io.Serializable;
import java.util.ArrayList;

public class LogOportunidadRoot implements Serializable {

	private static final long serialVersionUID = 450075975483587899L;

	private String idOpoprtunidad;

	public String getIdOpoprtunidad() {
		return this.idOpoprtunidad;
	}

	public void setIdOpoprtunidad(String idOpoprtunidad) {
		this.idOpoprtunidad = idOpoprtunidad;
	}

	private String idBmp;

	public String getIdBmp() {
		return this.idBmp;
	}

	public void setIdBmp(String idBmp) {
		this.idBmp = idBmp;
	}

	private String idProd;

	public String getIdProd() {
		return this.idProd;
	}

	public void setIdProd(String idProd) {
		this.idProd = idProd;
	}

	private String codResponse;

	public String getCodResponse() {
		return this.codResponse;
	}

	public void setCodResponse(String codResponse) {
		this.codResponse = codResponse;
	}

	private String nombServicio;

	public String getNombServicio() {
		return this.nombServicio;
	}

	public void setNombServicio(String nombServicio) {
		this.nombServicio = nombServicio;
	}

	private long fechaLog;

	public long getFechaLog() {
		return this.fechaLog;
	}

	public void setFechaLog(long fechaLog) {
		this.fechaLog = fechaLog;
	}

	private ArrayList<Request> request;

	public ArrayList<Request> getRequest() {
		return this.request;
	}

	public void setRequest(ArrayList<Request> request) {
		this.request = request;
	}

	private ArrayList<Response> response;

	public ArrayList<Response> getResponse() {
		return this.response;
	}

	public void setResponse(ArrayList<Response> response) {
		this.response = response;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codResponse == null) ? 0 : codResponse.hashCode());
		result = prime * result + (int) (fechaLog ^ (fechaLog >>> 32));
		result = prime * result + ((idBmp == null) ? 0 : idBmp.hashCode());
		result = prime * result + ((idOpoprtunidad == null) ? 0 : idOpoprtunidad.hashCode());
		result = prime * result + ((idProd == null) ? 0 : idProd.hashCode());
		result = prime * result + ((nombServicio == null) ? 0 : nombServicio.hashCode());
		result = prime * result + ((request == null) ? 0 : request.hashCode());
		result = prime * result + ((response == null) ? 0 : response.hashCode());
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
		LogOportunidadRoot other = (LogOportunidadRoot) obj;
		if (codResponse == null) {
			if (other.codResponse != null)
				return false;
		} else if (!codResponse.equals(other.codResponse))
			return false;
		if (fechaLog != other.fechaLog)
			return false;
		if (idBmp == null) {
			if (other.idBmp != null)
				return false;
		} else if (!idBmp.equals(other.idBmp))
			return false;
		if (idOpoprtunidad == null) {
			if (other.idOpoprtunidad != null)
				return false;
		} else if (!idOpoprtunidad.equals(other.idOpoprtunidad))
			return false;
		if (idProd == null) {
			if (other.idProd != null)
				return false;
		} else if (!idProd.equals(other.idProd))
			return false;
		if (nombServicio == null) {
			if (other.nombServicio != null)
				return false;
		} else if (!nombServicio.equals(other.nombServicio))
			return false;
		if (request == null) {
			if (other.request != null)
				return false;
		} else if (!request.equals(other.request))
			return false;
		if (response == null) {
			if (other.response != null)
				return false;
		} else if (!response.equals(other.response))
			return false;
		return true;
	}

}
