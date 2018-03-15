package cl.bancochile.automatizador.controlador;

import cl.bancochile.automatizador.model.Oportunidad;

public interface IConfCallOp {

     public Oportunidad crearOportunidad(String jsonOportunidad);
     
     public String agregarProducto(String idOportunidad, String jsonProducto);
     
     public String actualizarScoring(String idOportunidad,
               String usuario, String jsonScoring);
     
     public String actualizarDatosAdicionales(String idOportunidad,
               String idProducto, String jsonDatosAdicionales);
     
     public String actualizarRepLegal(String idOportunidad, String idProducto,
               String usuario, String jsonRepLegal);
     
     public String actualizaReferencias(String idOportunidad, String idProducto,
               String usuario, String jsonReferencias);
     
     public String agregarComentarios(String idOportunidad, String jsonComentarios);
     
     public Oportunidad getOportunidad(String idOportunidad);

     public Oportunidad flujosOportunidad(String jsonOportunidadS);
}
