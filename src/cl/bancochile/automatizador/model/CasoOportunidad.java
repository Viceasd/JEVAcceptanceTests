package cl.bancochile.automatizador.model;

import java.io.Serializable;

public class CasoOportunidad implements Serializable{
     
     private static final long serialVersionUID = 629517964599376984L;
     
     private String accion;

     public String getAccion() {
          return accion;
     }

     public void setAccion(String accion) {
          this.accion = accion;
     }
     
     

}
