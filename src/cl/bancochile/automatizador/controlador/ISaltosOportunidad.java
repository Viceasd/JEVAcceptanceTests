package cl.bancochile.automatizador.controlador;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.json.JSONException;

import cl.bancochile.automatizador.model.Oportunidad;
import cl.bancochile.automatizador.model.PlanBPM;
import cl.bancochile.automatizador.util.JsonUtils;

public interface ISaltosOportunidad {

     boolean validarAccion(String arrayCaso, int contadorCaso);

     void actualizarRepresentanteLegal(String idOportunidad, String endpointWebLogic, String userNameProper,
               String urlRepresentanteLegal, String jsonRepresentanteLegal);

     void repLegalProd(String idOportunidad, String idProducto, String endpointWebLogic, String userNameProper,
               String urlRepresentanteLegal, String jsonRepresentanteLegal);

     void eliminarProductos(String jsonProductos, String rut, String nombre, String endpointWebLogic,
               String urlEliminarProductos);

     void listaAllOpExt(String jsonOp, String endpointWebLogic, String urlListaAllExt);

     void listaAllOp(String jsonOp, String endpointWebLogic, String urlListaAllExt);

     void actualizaReferencias(String idOportunidad, String usuario, String jsonReferencia, String endpointWebLogic,
               String urlReferencias);

     String actualizarDatosAdicionales(String idOportunidad, String idProducto, String endpointWebLogic,
               String urlDatosAdicionales, String jsonDatosAdicionales);

     Oportunidad datosOportunidad(String idOportunidad, String endpointWebLogic, String urlOportunidad);

     void agregarComentario(String comentario, String idOportunidad, String endpointWebLogic,
               String urlAgregarComentario, String comentarioOportunidadProper);

     void actualizarScoring(String idOportunidad, String endpointWebLogic, String urlScoring, String userNameProper,
               String scoring_proper);

     void agregarProducto(String idOportunidad, String endpointWebLogic, String agregaProducto,
               String urlAgregaProducto, String tipoCuenta);

     Oportunidad creaOportunidad(String endpointWebLogic, String creaOportunidad, String oportunidadProper);

     void testDePruebas(String idBpmProducto, String idOportunidad, String[] arrayCaso, int contProducto)
               throws Exception;

     String avanceBPM(String idBpmProducto, String idOportunidad, int contProducto, String idTareaActual, String accion,
               String tarea, String trxIdOperacion, JsonUtils jsonObject, Oportunidad oportunidad,
               String nombreTareaActual, int idSolicitudAux) throws JSONException, InterruptedException, IOException;

     void anularOportunidad(Oportunidad oportunidad);

     void eliminarProductos(Oportunidad oportunidad);

     void avanzarTareaPorFront(String idBpmProducto, String idOportunidad, int contProducto, String accion,
               String tarea, JsonUtils jsonObject, Oportunidad oportunidad, String nombreTareaActual,
               int idSolicitudAux) throws InterruptedException, JSONException;

     void avanzarTareaBack(String idBpmProducto, String idOportunidad, int contProducto, String idTareaActual,
               String accion, String tarea, String trxIdOperacion, JsonUtils jsonObject, Oportunidad oportunidad,
               String nombreTareaActual, int idSolicitudAux) throws JSONException, InterruptedException, IOException;

     String getIdsolicitud(String idBpmProducto, String idOportunidad, JsonUtils jsonObject, int idSolicitudAux,
               String tarea) throws JSONException;

     String getTrxIdOperacion(String idBpmProducto, String idOportunidad, JsonUtils jsonObject, int idSolicitudAux,
               String tarea, String accion) throws JSONException, IOException;

     String getNomTareaActual(String idTareaActual, Oportunidad oportunidad, String nombreTareaActual,
               int contProducto);

     String identificaAccion(String accion);

     void casoFeliz(String idBpmProducto, List<String> accion, String idSolicitud);

     void tiempoEntreLlamados(int segundos);

     Properties leerArchivo2();

     void listarOportunidades();

     PlanBPM obtenerPlanPrueba(String planDePruebas);

     String flujoBPM(Oportunidad _oportunidad, String idBpmProducto, String idOportunidad, boolean estadoCasos,
               String stringCasos, String[] arrayCaso, int contadorCaso);

     String recorridoPruebasPorProducto(Oportunidad _oportunidad, String idBpmProducto, String idOportunidad,
               String stringCasos, String[] arrayCaso, int contadorCaso) throws InterruptedException, Exception;

     Oportunidad callOportunidad(Oportunidad _oportunidad, String idOportunidad, int contProd)
               throws InterruptedException;

     boolean validarCasoPruebas(boolean estadoCasos, String[] arrayCaso, int contadorCaso);

     void leerArchivo();

}