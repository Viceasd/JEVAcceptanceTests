package cl.bancochile.automatizador.model;

import java.io.Serializable;

public class Autorizacion implements Serializable {

	private static final long serialVersionUID = -7202116534237073305L;

	private String codigo;

	private String mensaje;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

}
