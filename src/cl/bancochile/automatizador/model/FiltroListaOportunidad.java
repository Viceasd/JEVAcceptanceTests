package cl.bancochile.automatizador.model;

import java.io.Serializable;

public class FiltroListaOportunidad implements Serializable{

	private static final long serialVersionUID = 796869676057187056L;

	private String uuidOp;
	private String codOficina;
	private String usuario;
	private String rutCliente;
	private String canal;
	private java.util.Date fechaCreacion;
	private int pagina;
	private int regsPag;
	private String estado;
	private String flag;
	
	public String getUuidOp() {
		return uuidOp;
	}
	public void setUuidOp(String uuidOp) {
		this.uuidOp = uuidOp;
	}
	public String getCodOficina() {
		return codOficina;
	}
	public void setCodOficina(String codOficina) {
		this.codOficina = codOficina;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getRutCliente() {
		return rutCliente;
	}
	public void setRutCliente(String rutCliente) {
		this.rutCliente = rutCliente;
	}
	public String getCanal() {
		return canal;
	}
	public void setCanal(String canal) {
		this.canal = canal;
	}
	public java.util.Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(java.util.Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public int getPagina() {
		return pagina;
	}
	public void setPagina(int pagina) {
		this.pagina = pagina;
	}
	public int getRegsPag() {
		return regsPag;
	}
	public void setRegsPag(int regsPag) {
		this.regsPag = regsPag;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}

	
	
}
