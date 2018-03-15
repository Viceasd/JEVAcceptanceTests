package cl.bancochile.automatizador.model;

import java.io.Serializable;

public class FiltroListaOportunidadExt implements Serializable{

	private static final long serialVersionUID = 3960692255537445970L;
	private String fechaDesde;
    private String fechaHasta;
    private String codTarea;
    private String estado;
    private String flagHist;
    private String rutCliente;
    private String codOficina;
    private int pagina;
    private String uuidOp;    
    private String usuario;
    private int regsPag;
    private String canal;
    
	public String getFechaDesde() {
		return fechaDesde;
	}
	public void setFechaDesde(String fechaDesde) {
		this.fechaDesde = fechaDesde;
	}
	public String getFechaHasta() {
		return fechaHasta;
	}
	public void setFechaHasta(String fechaHasta) {
		this.fechaHasta = fechaHasta;
	}
	public String getCodTarea() {
		return codTarea;
	}
	public void setCodTarea(String codTarea) {
		this.codTarea = codTarea;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getFlagHist() {
		return flagHist;
	}
	public void setFlagHist(String flagHist) {
		this.flagHist = flagHist;
	}
	public String getRutCliente() {
		return rutCliente;
	}
	public void setRutCliente(String rutCliente) {
		this.rutCliente = rutCliente;
	}
	public String getCodOficina() {
		return codOficina;
	}
	public void setCodOficina(String codOficina) {
		this.codOficina = codOficina;
	}
	public int getPagina() {
		return pagina;
	}
	public void setPagina(int pagina) {
		this.pagina = pagina;
	}
	public String getUuidOp() {
		return uuidOp;
	}
	public void setUuidOp(String uuidOp) {
		this.uuidOp = uuidOp;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public int getRegsPag() {
		return regsPag;
	}
	public void setRegsPag(int regsPag) {
		this.regsPag = regsPag;
	}
	public String getCanal() {
		return canal;
	}
	public void setCanal(String canal) {
		this.canal = canal;
	}
    
    
}
