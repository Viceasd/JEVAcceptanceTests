package cl.bancochile.automatizador.model;

import java.io.Serializable;

public class AutorizacionEveris implements Serializable {
	/**
	  * 
	  */
	private static final long serialVersionUID = -7740581087755194090L;

	private String idSolicitud;

	private String rutCliente;

	private String uriDestino;

	private String idAccion;

	private String idEstado;

	private String usuarioAutorizador;

	private String excepcion;

	private String idRespuesta;

	private String fechaSolicitud;

	private String rutEjecutivo;

	private String trxIdOperacion;

	private String comentario;

	public String getIdSolicitud() {
		return idSolicitud;
	}

	public void setIdSolicitud(String idSolicitud) {
		this.idSolicitud = idSolicitud;
	}

	public String getRutCliente() {
		return rutCliente;
	}

	public void setRutCliente(String rutCliente) {
		this.rutCliente = rutCliente;
	}

	public String getUriDestino() {
		return uriDestino;
	}

	public void setUriDestino(String uriDestino) {
		this.uriDestino = uriDestino;
	}

	public String getIdAccion() {
		return idAccion;
	}

	public void setIdAccion(String idAccion) {
		this.idAccion = idAccion;
	}

	public String getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(String idEstado) {
		this.idEstado = idEstado;
	}

	public String getUsuarioAutorizador() {
		return usuarioAutorizador;
	}

	public void setUsuarioAutorizador(String usuarioAutorizador) {
		this.usuarioAutorizador = usuarioAutorizador;
	}

	public String getExcepcion() {
		return excepcion;
	}

	public void setExcepcion(String excepcion) {
		this.excepcion = excepcion;
	}

	public String getIdRespuesta() {
		return idRespuesta;
	}

	public void setIdRespuesta(String idRespuesta) {
		this.idRespuesta = idRespuesta;
	}

	public String getFechaSolicitud() {
		return fechaSolicitud;
	}

	public void setFechaSolicitud(String fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	public String getRutEjecutivo() {
		return rutEjecutivo;
	}

	public void setRutEjecutivo(String rutEjecutivo) {
		this.rutEjecutivo = rutEjecutivo;
	}

	public String getTrxIdOperacion() {
		return trxIdOperacion;
	}

	public void setTrxIdOperacion(String trxIdOperacion) {
		this.trxIdOperacion = trxIdOperacion;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comentario == null) ? 0 : comentario.hashCode());
		result = prime * result + ((excepcion == null) ? 0 : excepcion.hashCode());
		result = prime * result + ((fechaSolicitud == null) ? 0 : fechaSolicitud.hashCode());
		result = prime * result + ((idAccion == null) ? 0 : idAccion.hashCode());
		result = prime * result + ((idEstado == null) ? 0 : idEstado.hashCode());
		result = prime * result + ((idRespuesta == null) ? 0 : idRespuesta.hashCode());
		result = prime * result + ((idSolicitud == null) ? 0 : idSolicitud.hashCode());
		result = prime * result + ((rutCliente == null) ? 0 : rutCliente.hashCode());
		result = prime * result + ((rutEjecutivo == null) ? 0 : rutEjecutivo.hashCode());
		result = prime * result + ((trxIdOperacion == null) ? 0 : trxIdOperacion.hashCode());
		result = prime * result + ((uriDestino == null) ? 0 : uriDestino.hashCode());
		result = prime * result + ((usuarioAutorizador == null) ? 0 : usuarioAutorizador.hashCode());
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
		AutorizacionEveris other = (AutorizacionEveris) obj;
		if (comentario == null) {
			if (other.comentario != null)
				return false;
		} else if (!comentario.equals(other.comentario))
			return false;
		if (excepcion == null) {
			if (other.excepcion != null)
				return false;
		} else if (!excepcion.equals(other.excepcion))
			return false;
		if (fechaSolicitud == null) {
			if (other.fechaSolicitud != null)
				return false;
		} else if (!fechaSolicitud.equals(other.fechaSolicitud))
			return false;
		if (idAccion == null) {
			if (other.idAccion != null)
				return false;
		} else if (!idAccion.equals(other.idAccion))
			return false;
		if (idEstado == null) {
			if (other.idEstado != null)
				return false;
		} else if (!idEstado.equals(other.idEstado))
			return false;
		if (idRespuesta == null) {
			if (other.idRespuesta != null)
				return false;
		} else if (!idRespuesta.equals(other.idRespuesta))
			return false;
		if (idSolicitud == null) {
			if (other.idSolicitud != null)
				return false;
		} else if (!idSolicitud.equals(other.idSolicitud))
			return false;
		if (rutCliente == null) {
			if (other.rutCliente != null)
				return false;
		} else if (!rutCliente.equals(other.rutCliente))
			return false;
		if (rutEjecutivo == null) {
			if (other.rutEjecutivo != null)
				return false;
		} else if (!rutEjecutivo.equals(other.rutEjecutivo))
			return false;
		if (trxIdOperacion == null) {
			if (other.trxIdOperacion != null)
				return false;
		} else if (!trxIdOperacion.equals(other.trxIdOperacion))
			return false;
		if (uriDestino == null) {
			if (other.uriDestino != null)
				return false;
		} else if (!uriDestino.equals(other.uriDestino))
			return false;
		if (usuarioAutorizador == null) {
			if (other.usuarioAutorizador != null)
				return false;
		} else if (!usuarioAutorizador.equals(other.usuarioAutorizador))
			return false;
		return true;
	}

}
