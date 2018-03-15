package cl.bancochile.automatizador.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Response implements Serializable {

	private static final long serialVersionUID = 3412509279891029848L;

	private int idSolicitud;

	public int getIdSolicitud() {
		return this.idSolicitud;
	}

	public void setIdSolicitud(int idSolicitud) {
		this.idSolicitud = idSolicitud;
	}

	private Estado estado;

	public Estado getEstado() {
		return this.estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	private String accion;

	public String getAccion() {
		return this.accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

	private String trxIdOperacion;

	public String getTrxIdOperacion() {
		return this.trxIdOperacion;
	}

	public void setTrxIdOperacion(String trxIdOperacion) {
		this.trxIdOperacion = trxIdOperacion;
	}

	private String oficinaOrigen;

	public String getOficinaOrigen() {
		return this.oficinaOrigen;
	}

	public void setOficinaOrigen(String oficinaOrigen) {
		this.oficinaOrigen = oficinaOrigen;
	}

	private String codigoTipoOperacion;

	public String getCodigoTipoOperacion() {
		return this.codigoTipoOperacion;
	}

	public void setCodigoTipoOperacion(String codigoTipoOperacion) {
		this.codigoTipoOperacion = codigoTipoOperacion;
	}

	private String glosaTipoOperacion;

	public String getGlosaTipoOperacion() {
		return this.glosaTipoOperacion;
	}

	public void setGlosaTipoOperacion(String glosaTipoOperacion) {
		this.glosaTipoOperacion = glosaTipoOperacion;
	}

	private int idTipoAutorizacion;

	public int getIdTipoAutorizacion() {
		return this.idTipoAutorizacion;
	}

	public void setIdTipoAutorizacion(int idTipoAutorizacion) {
		this.idTipoAutorizacion = idTipoAutorizacion;
	}

	private String rutSolicitante;

	public String getRutSolicitante() {
		return this.rutSolicitante;
	}

	public void setRutSolicitante(String rutSolicitante) {
		this.rutSolicitante = rutSolicitante;
	}

	private String rutCliente;

	public String getRutCliente() {
		return this.rutCliente;
	}

	public void setRutCliente(String rutCliente) {
		this.rutCliente = rutCliente;
	}

	private Object monto;

	public Object getMonto() {
		return this.monto;
	}

	public void setMonto(Object monto) {
		this.monto = monto;
	}

	private Object tipoMoneda;

	public Object getTipoMoneda() {
		return this.tipoMoneda;
	}

	public void setTipoMoneda(Object tipoMoneda) {
		this.tipoMoneda = tipoMoneda;
	}

	private Object tipoPoductoOrigen;

	public Object getTipoPoductoOrigen() {
		return this.tipoPoductoOrigen;
	}

	public void setTipoPoductoOrigen(Object tipoPoductoOrigen) {
		this.tipoPoductoOrigen = tipoPoductoOrigen;
	}

	private Object numeroPoductoOrigen;

	public Object getNumeroPoductoOrigen() {
		return this.numeroPoductoOrigen;
	}

	public void setNumeroPoductoOrigen(Object numeroPoductoOrigen) {
		this.numeroPoductoOrigen = numeroPoductoOrigen;
	}

	private Object tipoPoductoDestino;

	public Object getTipoPoductoDestino() {
		return this.tipoPoductoDestino;
	}

	public void setTipoPoductoDestino(Object tipoPoductoDestino) {
		this.tipoPoductoDestino = tipoPoductoDestino;
	}

	private Object numeroPoductoDestino;

	public Object getNumeroPoductoDestino() {
		return this.numeroPoductoDestino;
	}

	public void setNumeroPoductoDestino(Object numeroPoductoDestino) {
		this.numeroPoductoDestino = numeroPoductoDestino;
	}

	private Object fechaContableString;

	public Object getFechaContableString() {
		return this.fechaContableString;
	}

	public void setFechaContableString(Object fechaContableString) {
		this.fechaContableString = fechaContableString;
	}

	private Object fechaContable;

	public Object getFechaContable() {
		return this.fechaContable;
	}

	public void setFechaContable(Object fechaContable) {
		this.fechaContable = fechaContable;
	}

	private String fechaCreacionString;

	public String getFechaCreacionString() {
		return this.fechaCreacionString;
	}

	public void setFechaCreacionString(String fechaCreacionString) {
		this.fechaCreacionString = fechaCreacionString;
	}

	private long fechaCreacion;

	public long getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(long fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	private Object fechaValorString;

	public Object getFechaValorString() {
		return this.fechaValorString;
	}

	public void setFechaValorString(Object fechaValorString) {
		this.fechaValorString = fechaValorString;
	}

	private Object fechaValor;

	public Object getFechaValor() {
		return this.fechaValor;
	}

	public void setFechaValor(Object fechaValor) {
		this.fechaValor = fechaValor;
	}

	private String idSolicitante;

	public String getIdSolicitante() {
		return this.idSolicitante;
	}

	public void setIdSolicitante(String idSolicitante) {
		this.idSolicitante = idSolicitante;
	}

	private Object detalle;

	public Object getDetalle() {
		return this.detalle;
	}

	public void setDetalle(Object detalle) {
		this.detalle = detalle;
	}

	private String canal;

	public String getCanal() {
		return this.canal;
	}

	public void setCanal(String canal) {
		this.canal = canal;
	}

	private String sistemaOrigen;

	public String getSistemaOrigen() {
		return this.sistemaOrigen;
	}

	public void setSistemaOrigen(String sistemaOrigen) {
		this.sistemaOrigen = sistemaOrigen;
	}

	private String uriOrigen;

	public String getUriOrigen() {
		return this.uriOrigen;
	}

	public void setUriOrigen(String uriOrigen) {
		this.uriOrigen = uriOrigen;
	}

	private String uriDestino;

	public String getUriDestino() {
		return this.uriDestino;
	}

	public void setUriDestino(String uriDestino) {
		this.uriDestino = uriDestino;
	}

	private Object ipOrigen;

	public Object getIpOrigen() {
		return this.ipOrigen;
	}

	public void setIpOrigen(Object ipOrigen) {
		this.ipOrigen = ipOrigen;
	}

	private Object nombreMaquina;

	public Object getNombreMaquina() {
		return this.nombreMaquina;
	}

	public void setNombreMaquina(Object nombreMaquina) {
		this.nombreMaquina = nombreMaquina;
	}

	private Object comentario;

	public Object getComentario() {
		return this.comentario;
	}

	public void setComentario(Object comentario) {
		this.comentario = comentario;
	}

	private String nombreCliente;

	public String getNombreCliente() {
		return this.nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	private ArrayList<Autorizadores> autorizadores;

	public ArrayList<Autorizadores> getAutorizadores() {
		return this.autorizadores;
	}

	public void setAutorizadores(ArrayList<Autorizadores> autorizadores) {
		this.autorizadores = autorizadores;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accion == null) ? 0 : accion.hashCode());
		result = prime * result + ((autorizadores == null) ? 0 : autorizadores.hashCode());
		result = prime * result + ((canal == null) ? 0 : canal.hashCode());
		result = prime * result + ((codigoTipoOperacion == null) ? 0 : codigoTipoOperacion.hashCode());
		result = prime * result + ((comentario == null) ? 0 : comentario.hashCode());
		result = prime * result + ((detalle == null) ? 0 : detalle.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((fechaContable == null) ? 0 : fechaContable.hashCode());
		result = prime * result + ((fechaContableString == null) ? 0 : fechaContableString.hashCode());
		result = prime * result + (int) (fechaCreacion ^ (fechaCreacion >>> 32));
		result = prime * result + ((fechaCreacionString == null) ? 0 : fechaCreacionString.hashCode());
		result = prime * result + ((fechaValor == null) ? 0 : fechaValor.hashCode());
		result = prime * result + ((fechaValorString == null) ? 0 : fechaValorString.hashCode());
		result = prime * result + ((glosaTipoOperacion == null) ? 0 : glosaTipoOperacion.hashCode());
		result = prime * result + ((idSolicitante == null) ? 0 : idSolicitante.hashCode());
		result = prime * result + idSolicitud;
		result = prime * result + idTipoAutorizacion;
		result = prime * result + ((ipOrigen == null) ? 0 : ipOrigen.hashCode());
		result = prime * result + ((monto == null) ? 0 : monto.hashCode());
		result = prime * result + ((nombreCliente == null) ? 0 : nombreCliente.hashCode());
		result = prime * result + ((nombreMaquina == null) ? 0 : nombreMaquina.hashCode());
		result = prime * result + ((numeroPoductoDestino == null) ? 0 : numeroPoductoDestino.hashCode());
		result = prime * result + ((numeroPoductoOrigen == null) ? 0 : numeroPoductoOrigen.hashCode());
		result = prime * result + ((oficinaOrigen == null) ? 0 : oficinaOrigen.hashCode());
		result = prime * result + ((rutCliente == null) ? 0 : rutCliente.hashCode());
		result = prime * result + ((rutSolicitante == null) ? 0 : rutSolicitante.hashCode());
		result = prime * result + ((sistemaOrigen == null) ? 0 : sistemaOrigen.hashCode());
		result = prime * result + ((tipoMoneda == null) ? 0 : tipoMoneda.hashCode());
		result = prime * result + ((tipoPoductoDestino == null) ? 0 : tipoPoductoDestino.hashCode());
		result = prime * result + ((tipoPoductoOrigen == null) ? 0 : tipoPoductoOrigen.hashCode());
		result = prime * result + ((trxIdOperacion == null) ? 0 : trxIdOperacion.hashCode());
		result = prime * result + ((uriDestino == null) ? 0 : uriDestino.hashCode());
		result = prime * result + ((uriOrigen == null) ? 0 : uriOrigen.hashCode());
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
		Response other = (Response) obj;
		if (accion == null) {
			if (other.accion != null)
				return false;
		} else if (!accion.equals(other.accion))
			return false;
		if (autorizadores == null) {
			if (other.autorizadores != null)
				return false;
		} else if (!autorizadores.equals(other.autorizadores))
			return false;
		if (canal == null) {
			if (other.canal != null)
				return false;
		} else if (!canal.equals(other.canal))
			return false;
		if (codigoTipoOperacion == null) {
			if (other.codigoTipoOperacion != null)
				return false;
		} else if (!codigoTipoOperacion.equals(other.codigoTipoOperacion))
			return false;
		if (comentario == null) {
			if (other.comentario != null)
				return false;
		} else if (!comentario.equals(other.comentario))
			return false;
		if (detalle == null) {
			if (other.detalle != null)
				return false;
		} else if (!detalle.equals(other.detalle))
			return false;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		if (fechaContable == null) {
			if (other.fechaContable != null)
				return false;
		} else if (!fechaContable.equals(other.fechaContable))
			return false;
		if (fechaContableString == null) {
			if (other.fechaContableString != null)
				return false;
		} else if (!fechaContableString.equals(other.fechaContableString))
			return false;
		if (fechaCreacion != other.fechaCreacion)
			return false;
		if (fechaCreacionString == null) {
			if (other.fechaCreacionString != null)
				return false;
		} else if (!fechaCreacionString.equals(other.fechaCreacionString))
			return false;
		if (fechaValor == null) {
			if (other.fechaValor != null)
				return false;
		} else if (!fechaValor.equals(other.fechaValor))
			return false;
		if (fechaValorString == null) {
			if (other.fechaValorString != null)
				return false;
		} else if (!fechaValorString.equals(other.fechaValorString))
			return false;
		if (glosaTipoOperacion == null) {
			if (other.glosaTipoOperacion != null)
				return false;
		} else if (!glosaTipoOperacion.equals(other.glosaTipoOperacion))
			return false;
		if (idSolicitante == null) {
			if (other.idSolicitante != null)
				return false;
		} else if (!idSolicitante.equals(other.idSolicitante))
			return false;
		if (idSolicitud != other.idSolicitud)
			return false;
		if (idTipoAutorizacion != other.idTipoAutorizacion)
			return false;
		if (ipOrigen == null) {
			if (other.ipOrigen != null)
				return false;
		} else if (!ipOrigen.equals(other.ipOrigen))
			return false;
		if (monto == null) {
			if (other.monto != null)
				return false;
		} else if (!monto.equals(other.monto))
			return false;
		if (nombreCliente == null) {
			if (other.nombreCliente != null)
				return false;
		} else if (!nombreCliente.equals(other.nombreCliente))
			return false;
		if (nombreMaquina == null) {
			if (other.nombreMaquina != null)
				return false;
		} else if (!nombreMaquina.equals(other.nombreMaquina))
			return false;
		if (numeroPoductoDestino == null) {
			if (other.numeroPoductoDestino != null)
				return false;
		} else if (!numeroPoductoDestino.equals(other.numeroPoductoDestino))
			return false;
		if (numeroPoductoOrigen == null) {
			if (other.numeroPoductoOrigen != null)
				return false;
		} else if (!numeroPoductoOrigen.equals(other.numeroPoductoOrigen))
			return false;
		if (oficinaOrigen == null) {
			if (other.oficinaOrigen != null)
				return false;
		} else if (!oficinaOrigen.equals(other.oficinaOrigen))
			return false;
		if (rutCliente == null) {
			if (other.rutCliente != null)
				return false;
		} else if (!rutCliente.equals(other.rutCliente))
			return false;
		if (rutSolicitante == null) {
			if (other.rutSolicitante != null)
				return false;
		} else if (!rutSolicitante.equals(other.rutSolicitante))
			return false;
		if (sistemaOrigen == null) {
			if (other.sistemaOrigen != null)
				return false;
		} else if (!sistemaOrigen.equals(other.sistemaOrigen))
			return false;
		if (tipoMoneda == null) {
			if (other.tipoMoneda != null)
				return false;
		} else if (!tipoMoneda.equals(other.tipoMoneda))
			return false;
		if (tipoPoductoDestino == null) {
			if (other.tipoPoductoDestino != null)
				return false;
		} else if (!tipoPoductoDestino.equals(other.tipoPoductoDestino))
			return false;
		if (tipoPoductoOrigen == null) {
			if (other.tipoPoductoOrigen != null)
				return false;
		} else if (!tipoPoductoOrigen.equals(other.tipoPoductoOrigen))
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
		if (uriOrigen == null) {
			if (other.uriOrigen != null)
				return false;
		} else if (!uriOrigen.equals(other.uriOrigen))
			return false;
		return true;
	}

}