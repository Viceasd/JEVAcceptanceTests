package cl.bancochile.automatizador.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class Comentarios implements Serializable {

	private static final long serialVersionUID = -4824740948099500512L;

	private String usuario;

	private Timestamp fecha;

	private String comentario;

	private String motivo;

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Timestamp getFecha() {
		return (Timestamp) fecha.clone();
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = (Timestamp) fecha.clone();
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

}
