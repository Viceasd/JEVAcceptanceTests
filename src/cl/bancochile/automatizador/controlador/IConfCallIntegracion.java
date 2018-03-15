package cl.bancochile.automatizador.controlador;

public interface IConfCallIntegracion {
     
     public String iniciarProceso(String idOportunidad);
     
     public String avanzarTarea(String tarea,String operacion, String idBpm);
     
     public String agrupamiento(String iOportunidad);
     
     public String avanzarPrevisado(String idSolicitud, String tipoAutorizacion, String mensaje);

}
