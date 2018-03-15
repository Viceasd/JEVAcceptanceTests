package cl.bancochile.automatizador.controlador;

import cl.bancochile.automatizador.constantes.Constantes;
import cl.bancochile.automatizador.model.Oportunidad;
import cl.bancochile.automatizador.model.Producto;

public class ConfCallOp implements IConfCallOp {
     
     @Override
     public Oportunidad crearOportunidad(String jsonOportunidad) {
          // TODO Auto-generated method stub
          return null;
     }

     @Override
     public String agregarProducto(String idOportunidad, String jsonProducto) {
          // TODO Auto-generated method stub
          return null;
     }

     @Override
     public String actualizarScoring(String idOportunidad, String usuario, String jsonScoring) {
          // TODO Auto-generated method stub
          return null;
     }

     @Override
     public String actualizarDatosAdicionales(String idOportunidad, String idProducto, String jsonDatosAdicionales) {
          // TODO Auto-generated method stub
          return null;
     }

     @Override
     public String actualizarRepLegal(String idOportunidad, String idProducto, String usuario, String jsonRepLegal) {
          // TODO Auto-generated method stub
          return null;
     }

     @Override
     public String actualizaReferencias(String idOportunidad, String idProducto, String usuario,
               String jsonReferencias) {
          // TODO Auto-generated method stub
          return null;
     }

     @Override
     public String agregarComentarios(String idOportunidad, String jsonComentarios) {
          // TODO Auto-generated method stub
          return null;
     }

     @Override
     public Oportunidad getOportunidad(String idOportunidad) {
          // TODO Auto-generated method stub
          return null;
     }
     @Override
     public Oportunidad flujosOportunidad(String jsonOportunidad) {
          String[] datosAdicionales;
          String[] repLegales;
          String[] referencias;
          int i = 0;
          Oportunidad oportunidad;
          ConfCallOp confOp = new ConfCallOp();
          oportunidad = confOp.crearOportunidad(jsonOportunidad);
          confOp.agregarProducto(oportunidad.getUuidOportunidad(), Constantes.JSON_PRODUCTO);
          confOp.actualizarScoring(oportunidad.getUuidOportunidad(),
                    Constantes.USUARIO, Constantes.JSON_SCORING);
          confOp.agregarComentarios(oportunidad.getUuidOportunidad(),
                    Constantes.JSON_COMENTARIOS);
          oportunidad = new Oportunidad();
          oportunidad = confOp.getOportunidad(oportunidad.getUuidOportunidad());
          
          referencias = Constantes.REFERENCIAS.split("****");
          repLegales = Constantes.JSON_REPLEGALES.split("****");
          datosAdicionales = Constantes.JSON_DATOS_ADICIONALES.split("****");
          
          for(Producto idProducto : oportunidad.getProductos() ){
               confOp.actualizarDatosAdicionales(oportunidad.getUuidOportunidad(),
                         idProducto.getIdProducto(),
                         datosAdicionales[i]);
               confOp.actualizarRepLegal(oportunidad.getUuidOportunidad(),
                         idProducto.getIdProducto(), Constantes.USUARIO, repLegales[i]);
               confOp.actualizaReferencias(oportunidad.getUuidOportunidad(), 
                         idProducto.getIdProducto(), Constantes.USUARIO, referencias[i]);
               i++;
          }
          return oportunidad;
     }

}
