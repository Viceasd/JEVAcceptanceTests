package cl.bancochile.automatizador.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Producto implements Serializable {

	private static final long serialVersionUID = -4561014066892959143L;

	private String idOportunidad;

	private String idBPMProducto;

	private String idProducto;

	private String idReserva;

	private long idFamilia;

	private String nombreFamilia;

	private String nombre;

	private String descripcion;

	private Boolean previsado;

	private String estado;

	private transient Object atributos;

	private String nroFolio;

	private transient Object datosAdicionales;

	private Date fechaCreacion;

	private String usuario;

	private List<Tarea> tareas;

	private String tareaActual;

	private String idReferencia;

	private transient Object representantesLegales;

	private transient Object estadoPrevisado;

	private transient Object titularesAdicionales; 
	
	private String idProductoTaller;
	
	private String idFlujoOriginacion;
	
	private String avales;
	
	private transient Object reglasBPM;
	

	public Object getReglasBPM() {
		return reglasBPM;
	}

	public void setReglasBPM(Object reglasBPM) {
		this.reglasBPM = reglasBPM;
	}

	public String getAvales() {
          return avales;
     }

     public void setAvales(String avales) {
          this.avales = avales;
     }

     public String getIdFlujoOriginacion() {
          return idFlujoOriginacion;
     }

     public void setIdFlujoOriginacion(String idFlujoOriginacion) {
          this.idFlujoOriginacion = idFlujoOriginacion;
     }

     public String getIdProductoTaller() {
          return idProductoTaller;
     }

     public void setIdProductoTaller(String idProductoTaller) {
          this.idProductoTaller = idProductoTaller;
     }

     public String getIdOportunidad() {
		return idOportunidad;
	}

	public void setIdOportunidad(String idOportunidad) {
		this.idOportunidad = idOportunidad;
	}

	public String getIdBPMProducto() {
		return idBPMProducto;
	}

	public void setIdBPMProducto(String idBPMProducto) {
		this.idBPMProducto = idBPMProducto;
	}

	public String getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}

	public String getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(String idReserva) {
		this.idReserva = idReserva;
	}

	public long getIdFamilia() {
		return idFamilia;
	}

	public void setIdFamilia(long idFamilia) {
		this.idFamilia = idFamilia;
	}

	public String getNombreFamilia() {
		return nombreFamilia;
	}

	public void setNombreFamilia(String nombreFamilia) {
		this.nombreFamilia = nombreFamilia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Boolean getPrevisado() {
		return previsado;
	}

	public void setPrevisado(Boolean previsado) {
		this.previsado = previsado;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Object getAtributos() {
		return atributos;
	}

	public void setAtributos(Object atributos) {
		this.atributos = atributos;
	}

	public String getNroFolio() {
		return nroFolio;
	}

	public void setNroFolio(String nroFolio) {
		this.nroFolio = nroFolio;
	}

	public Object getDatosAdicionales() {
		return datosAdicionales;
	}

	public void setDatosAdicionales(Object datosAdicionales) {
		this.datosAdicionales = datosAdicionales;
	}

	public Date getFechaCreacion() {
		return (Date) fechaCreacion.clone();
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = (Date) fechaCreacion.clone();
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public List<Tarea> getTareas() {
		return tareas;
	}

	public void setTareas(List<Tarea> tareas) {
		this.tareas = tareas;
	}

	public String getTareaActual() {
		return tareaActual;
	}

	public void setTareaActual(String tareaActual) {
		this.tareaActual = tareaActual;
	}

	public String getIdReferencia() {
		return idReferencia;
	}

	public void setIdReferencia(String idReferencia) {
		this.idReferencia = idReferencia;
	}

	public Object getRepresentantesLegales() {
		return representantesLegales;
	}

	public void setRepresentantesLegales(Object representantesLegales) {
		this.representantesLegales = representantesLegales;
	}



	public Object getEstadoPrevisado() {
		return estadoPrevisado;
	}

	public void setEstadoPrevisado(Object estadoPrevisado) {
		this.estadoPrevisado = estadoPrevisado;
	}

	public Object getTitularesAdicionales() {
		return titularesAdicionales;
	}

	public void setTitularesAdicionales(Object titularesAdicionales) {
		this.titularesAdicionales = titularesAdicionales;
	}




}