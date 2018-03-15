package cl.bancochile.automatizador.model;

import java.io.Serializable;

public class DireccionDelivery implements Serializable{

     /**
      * 
      */
     private static final long serialVersionUID = 5603029486216391348L;

     private String nombre;

     private String id;

     private String nombreConcat;

     public String getNombre() {
          return nombre;
     }

     public void setNombre(String nombre) {
          this.nombre = nombre;
     }

     public String getId() {
          return id;
     }

     public void setId(String id) {
          this.id = id;
     }

     public String getNombreConcat() {
          return nombreConcat;
     }

     public void setNombreConcat(String nombreConcat) {
          this.nombreConcat = nombreConcat;
     }
     
     
     
     
}
