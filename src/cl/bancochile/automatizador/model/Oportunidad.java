package cl.bancochile.automatizador.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Oportunidad implements Serializable {

     private static final long serialVersionUID = -8159085945238871487L;

     private String uuidOportunidad;

     private Date fechaIngreso;

     private String estado;

     private transient Object origen;

     private String sistemaOrigen;

     private long aprobacionSolicitada;

     private List<ComentarioOportunidad> comentarios;

     private List<Producto> productos;

     private transient Object canal;

     private transient Object ejecutivo;

     private transient Object agente;

     private transient Object cliente;

     private transient Object datosAdicionales;

     private transient Object evaluacion;

     private List<Documento> documentos;

     private transient Object representantesLegales;

     private transient Object referencias;

     private transient Object autorizaciones;

     public Object getAutorizaciones() {
          return autorizaciones;
     }

     public void setAutorizaciones(Object autorizaciones) {
          this.autorizaciones = autorizaciones;
     }

     private String metodoVentaCDN;

     public String getMetodoVentaCDN() {
          return metodoVentaCDN;
     }

     public void setMetodoVentaCDN(String metodoVentaCDN) {
          this.metodoVentaCDN = metodoVentaCDN;
     }

     public Object getReferencias() {
          return referencias;
     }

     public void setReferencias(Object referencias) {
          this.referencias = referencias;
     }

     public String getUuidOportunidad() {
          return uuidOportunidad;
     }

     public void setUuidOportunidad(String uuidOportunidad) {
          this.uuidOportunidad = uuidOportunidad;
     }

     public Date getFechaIngreso() {
          return (Date) fechaIngreso.clone();
     }

     public void setFechaIngreso(Date fechaIngreso) {
          this.fechaIngreso = (Date) fechaIngreso.clone();
     }

     public String getEstado() {
          return estado;
     }

     public void setEstado(String estado) {
          this.estado = estado;
     }

     public Object getOrigen() {
          return origen;
     }

     public void setOrigen(Object origen) {
          this.origen = origen;
     }

     public String getSistemaOrigen() {
          return sistemaOrigen;
     }

     public void setSistemaOrigen(String sistemaOrigen) {
          this.sistemaOrigen = sistemaOrigen;
     }

     public long getAprobacionSolicitada() {
          return aprobacionSolicitada;
     }

     public void setAprobacionSolicitada(long aprobacionSolicitada) {
          this.aprobacionSolicitada = aprobacionSolicitada;
     }

     public List<ComentarioOportunidad> getComentarios() {
          return comentarios;
     }

     public void setComentarios(List<ComentarioOportunidad> comentarios) {
          this.comentarios = comentarios;
     }

     public List<Producto> getProductos() {
          return productos;
     }

     public void setProductos(List<Producto> productos) {
          this.productos = productos;
     }

     public Object getCanal() {
          return canal;
     }

     public void setCanal(Object canal) {
          this.canal = canal;
     }

     public Object getDatosAdicionales() {
          return datosAdicionales;
     }

     public void setDatosAdicionales(Object datosAdicionales) {
          this.datosAdicionales = datosAdicionales;
     }

     public List<Documento> getDocumentos() {
          return documentos;
     }

     public void setDocumentos(List<Documento> documentos) {
          this.documentos = documentos;
     }

     public Object getEjecutivo() {
          return ejecutivo;
     }

     public void setEjecutivo(Object ejecutivo) {
          this.ejecutivo = ejecutivo;
     }

     public Object getAgente() {
          return agente;
     }

     public void setAgente(Object agente) {
          this.agente = agente;
     }

     public Object getCliente() {
          return cliente;
     }

     public void setCliente(Object cliente) {
          this.cliente = cliente;
     }

     public Object getEvaluacion() {
          return evaluacion;
     }

     public void setEvaluacion(Object evaluacion) {
          this.evaluacion = evaluacion;
     }

     public Object getRepresentantesLegales() {
          return representantesLegales;
     }

     public void setRepresentantesLegales(Object representantesLegales) {
          this.representantesLegales = representantesLegales;
     }

}