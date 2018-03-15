package cl.bancochile.automatizador.model;

import java.io.Serializable;

public class Beneficiarios implements Serializable {

     private static final long serialVersionUID = -419402128939409096L;

     private String comuna;

     private String direccion;

     private String parentesco;

     private String nombres;

     private String email;

     private String rut;

     private String apellidoMaterno;

     private String apellidoPaterno;

     private String nroContacto;

     private String nombreRegion;

     private String prcBeneficio;

     public String getComuna() {
          return comuna;
     }

     public void setComuna(String comuna) {
          this.comuna = comuna;
     }

     public String getDireccion() {
          return direccion;
     }

     public void setDireccion(String direccion) {
          this.direccion = direccion;
     }

     public String getParentesco() {
          return parentesco;
     }

     public void setParentesco(String parentesco) {
          this.parentesco = parentesco;
     }

     public String getNombres() {
          return nombres;
     }

     public void setNombres(String nombres) {
          this.nombres = nombres;
     }

     public String getEmail() {
          return email;
     }

     public void setEmail(String email) {
          this.email = email;
     }

     public String getRut() {
          return rut;
     }

     public void setRut(String rut) {
          this.rut = rut;
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

     public String getNroContacto() {
          return nroContacto;
     }

     public void setNroContacto(String nroContacto) {
          this.nroContacto = nroContacto;
     }

     public String getNombreRegion() {
          return nombreRegion;
     }

     public void setNombreRegion(String nombreRegion) {
          this.nombreRegion = nombreRegion;
     }

     public String getPrcBeneficio() {
          return prcBeneficio;
     }

     public void setPrcBeneficio(String prcBeneficio) {
          this.prcBeneficio = prcBeneficio;
     }
     

}
