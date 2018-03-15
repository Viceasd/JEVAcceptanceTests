package cl.bancochile.automatizador.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class OportunidadResumenClte implements Serializable {

	private static final long serialVersionUID = 5520939601701144690L;

	private int nroReg;
	private String ejecutivo;
	private String estado;
	private String rutCliente;
	private String nombreCliente;
	private String canal;
	private Date fechaCreacion;
	private String uuidOportunidad;
	private String codOficina;
	private BigDecimal monto;
    private transient Object productos;

	public int getNroReg() {
		return nroReg;
	}

	public void setNroReg(int nroReg) {
		this.nroReg = nroReg;
	}

	public String getEjecutivo() {
		return ejecutivo;
	}

	public void setEjecutivo(String ejecutivo) {
		this.ejecutivo = ejecutivo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getRutCliente() {
		return rutCliente;
	}

	public void setRutCliente(String rutCliente) {
		this.rutCliente = rutCliente;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getCanal() {
		return canal;
	}

	public void setCanal(String canal) {
		this.canal = canal;
	}

	public Date getFechaCreacion() {
		return (Date) fechaCreacion.clone();
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = (Date) fechaCreacion.clone();
	}

	public String getUuidOportunidad() {
		return uuidOportunidad;
	}

	public void setUuidOportunidad(String uuidOportunidad) {
		this.uuidOportunidad = uuidOportunidad;
	}

	public String getCodOficina() {
		return codOficina;
	}

	public void setCodOficina(String codOficina) {
		this.codOficina = codOficina;
	}

	public BigDecimal getMonto() {
		return monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	public Object getProductos() {
		return productos;
	}

	public void setProductos(Object productos) {
		this.productos = productos;
	}

	
}
