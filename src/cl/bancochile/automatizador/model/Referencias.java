package cl.bancochile.automatizador.model;

import java.io.Serializable;

public class Referencias implements Serializable{
     
     /**
      * 
      */
     private static final long serialVersionUID = -2552580087639336208L;

     private String parentesco;

     private String email;

     private String telefono;

     private String nombreCompleto;

     public String getParentesco() {
          return parentesco;
     }

     public void setParentesco(String parentesco) {
          this.parentesco = parentesco;
     }

     public String getEmail() {
          return email;
     }

     public void setEmail(String email) {
          this.email = email;
     }

     public String getTelefono() {
          return telefono;
     }

     public void setTelefono(String telefono) {
          this.telefono = telefono;
     }

     public String getNombreCompleto() {
          return nombreCompleto;
     }

     public void setNombreCompleto(String nombreCompleto) {
          this.nombreCompleto = nombreCompleto;
     }
     
     

}
