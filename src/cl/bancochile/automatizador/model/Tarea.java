package cl.bancochile.automatizador.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class Tarea implements Serializable {

	private static final long serialVersionUID = 6089906122231951374L;

	private String idTarea;
	private String codTarea;
	private String nombreTarea;
	private Timestamp fechaInicio;
	private Timestamp fechaFin;
	private String idProducto;
	private String idOportunidad;
	private String usuario;
	private Timestamp fechaRegistro;
	private String accion;
	private Timestamp fechaMod;
	private transient Object comentario;
	private transient Object comentariosDocumento;
	private String idAutorizacion;
	
     
    public String getIdAutorizacion() {
          return idAutorizacion;
     }

     public void setIdAutorizacion(String idAutorizacion) {
          this.idAutorizacion = idAutorizacion;
     }

public Object getComentariosDocumento() {
          return comentariosDocumento;
     }

     public void setComentariosDocumento(Object comentariosDocumento) {
          this.comentariosDocumento = comentariosDocumento;
     }

public Object getComentario() {
		return comentario;
	}

	public void setComentario(Object comentario) {
		this.comentario = comentario;
	}

	public String getIdTarea() {
		return idTarea;
	}

	public void setIdTarea(String idTarea) {
		this.idTarea = idTarea;
	}

	public String getCodTarea() {
		return codTarea;
	}

	public void setCodTarea(String codTarea) {
		this.codTarea = codTarea;
	}

	public String getNombreTarea() {
		return nombreTarea;
	}

	public void setNombreTarea(String nombreTarea) {
		this.nombreTarea = nombreTarea;
	}

	public Timestamp getFechaInicio() {
		return (Timestamp) fechaInicio.clone();
	}

	public void setFechaInicio(Timestamp fechaInicio) {
		this.fechaInicio = (Timestamp) fechaInicio.clone();
	}

	public Timestamp getFechaFin() {
		return (Timestamp) fechaFin.clone();
	}

	public void setFechaFin(Timestamp fechaFin) {
		this.fechaFin = (Timestamp) fechaFin.clone();
	}

	public String getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}

	public String getIdOportunidad() {
		return idOportunidad;
	}

	public void setIdOportunidad(String idOportunidad) {
		this.idOportunidad = idOportunidad;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Timestamp getFechaRegistro() {
		return (Timestamp) fechaRegistro.clone();
	}

	public void setFechaRegistro(Timestamp fechaRegistro) {
		this.fechaRegistro = (Timestamp) fechaRegistro.clone();
	}

	public String getAccion() {
		return accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

	public Timestamp getFechaMod() {
		return (Timestamp) fechaMod.clone();
	}

	public void setFechaMod(Timestamp fechaMod) {
		this.fechaMod = (Timestamp) fechaMod.clone();
	}
}
