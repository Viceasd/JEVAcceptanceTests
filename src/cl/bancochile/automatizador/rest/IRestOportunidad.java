package cl.bancochile.automatizador.rest;

import java.io.IOException;

import cl.bancochile.automatizador.model.IdOportunidad;
import cl.bancochile.automatizador.model.Oportunidad;

public interface IRestOportunidad {

     String agregaProducto(String idOportunidad, String nFolio);

     IdOportunidad llamadoCreaOportunidad(String jsonOportunidad);

     String actualizarScoring(String username, String idOportunidad);

     String agregarComentarioOportunidad(String idOportunidad, String comentario);

     String getOportunidadIdProducto(String idOportunidad);

     String actualizarDatosAdicionales(String idOportunidad, String idProducto);

     String actualizarRepresentanteLegal(String idOportunidad, String userName);

     String anulaOportunidad(String idOportunidad);

     Oportunidad getOportunidad(String idOportunidad) throws InterruptedException;

     String comprobarRespuestaServicio(String respuesta);

     String avanzaTarea(String idBpmProducto, String accion, String idSolicitud);

     String llamadoNumeroFolio();

     String avanzarTareaFront(String idTarea, String accion);

     String iniciarProceso(String idOportunidad);

     String anularOportunidad(String direccion,String idOportunidad,String usuario, String rut);

     String eliminarProductos(String direccion, String jsonProductos, String usuario, String rut);

     String consumirRest3(String direccion, String metodo, String json);

     String logOportunidad(String idOportunidad);

     String mensajeIMQA(String set_id, String bpm_id, String estado) throws IOException;

     String avanzarTareasAgrupadas(String idSolicitud, String trxIdOperacion, String estado) throws IOException;

     String selectIdSolicitud(String idBpm) throws Exception;



}