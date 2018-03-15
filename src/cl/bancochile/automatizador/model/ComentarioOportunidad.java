package cl.bancochile.automatizador.model;

import java.io.Serializable;
import java.util.Date;

public class ComentarioOportunidad extends IdOportunidad implements Serializable {

	private static final long serialVersionUID = -4518098848825650363L;

	private String usuario;

	private String uuidComentario;

	private Date fecha;

	private String comentario;

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getUuidComentario() {
		return uuidComentario;
	}

	public void setUuidComentario(String uuidComentario) {
		this.uuidComentario = uuidComentario;
	}

	public Date getFecha() {
		return (Date) fecha.clone();
	}

	public void setFecha(Date fecha) {
		this.fecha = (Date) fecha.clone();
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

}
