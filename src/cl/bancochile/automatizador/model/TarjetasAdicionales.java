package cl.bancochile.automatizador.model;

import java.io.Serializable;

public class TarjetasAdicionales implements Serializable{
     
     private static final long serialVersionUID = -4983877065224510811L;

     private String nombres;

     private String rut;

     private String tipoTarjeta;

     private String apellidoMaterno;

     private String apellidoPaterno;

     private String nombreCompleto;

     private String fechaNacimiento;

     public String getNombres() {
          return nombres;
     }

     public void setNombres(String nombres) {
          this.nombres = nombres;
     }

     public String getRut() {
          return rut;
     }

     public void setRut(String rut) {
          this.rut = rut;
     }

     public String getTipoTarjeta() {
          return tipoTarjeta;
     }

     public void setTipoTarjeta(String tipoTarjeta) {
          this.tipoTarjeta = tipoTarjeta;
     }

     public String getApellidoMaterno() {
          return apellidoMaterno;
     }

     public void setApellidoMaterno(String apellidoMaterno) {
          this.apellidoMaterno = apellidoMaterno;
     }

     public String getApellidoPaterno() {
          return apellidoPaterno;
     }

     public void setApellidoPaterno(String apellidoPaterno) {
          this.apellidoPaterno = apellidoPaterno;
     }

     public String getNombreCompleto() {
          return nombreCompleto;
     }

     public void setNombreCompleto(String nombreCompleto) {
          this.nombreCompleto = nombreCompleto;
     }

     public String getFechaNacimiento() {
          return fechaNacimiento;
     }

     public void setFechaNacimiento(String fechaNacimiento) {
          this.fechaNacimiento = fechaNacimiento;
     }
     
     

}
