package cl.bancochile.automatizador.model;

import java.io.Serializable;

public class DireccionPostalCliente implements Serializable{

     private static final long serialVersionUID = -463940674226579491L;
     
     private String region;

     private String direccion;

     private String comuna;

     private String correoElectronico;

     private String ciudad;

     private String dirCompleta;

     private String normalizada;

     private String departamento;

     private String numero;

     public String getRegion() {
          return region;
     }

     public void setRegion(String region) {
          this.region = region;
     }

     public String getDireccion() {
          return direccion;
     }

     public void setDireccion(String direccion) {
          this.direccion = direccion;
     }

     public String getComuna() {
          return comuna;
     }

     public void setComuna(String comuna) {
          this.comuna = comuna;
     }

     public String getCorreoElectronico() {
          return correoElectronico;
     }

     public void setCorreoElectronico(String correoElectronico) {
          this.correoElectronico = correoElectronico;
     }

     public String getCiudad() {
          return ciudad;
     }

     public void setCiudad(String ciudad) {
          this.ciudad = ciudad;
     }

     public String getDirCompleta() {
          return dirCompleta;
     }

     public void setDirCompleta(String dirCompleta) {
          this.dirCompleta = dirCompleta;
     }

     public String getNormalizada() {
          return normalizada;
     }

     public void setNormalizada(String normalizada) {
          this.normalizada = normalizada;
     }

     public String getDepartamento() {
          return departamento;
     }

     public void setDepartamento(String departamento) {
          this.departamento = departamento;
     }

     public String getNumero() {
          return numero;
     }

     public void setNumero(String numero) {
          this.numero = numero;
     }

     

}
