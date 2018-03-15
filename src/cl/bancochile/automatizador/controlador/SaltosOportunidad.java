package cl.bancochile.automatizador.controlador;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONException;

import cl.bancochile.automatizador.Main;
import cl.bancochile.automatizador.model.ComentarioOportunidad;
import cl.bancochile.automatizador.model.FiltroListaOportunidad;
import cl.bancochile.automatizador.model.FiltroOpOrden;
import cl.bancochile.automatizador.model.LogOportunidadRoot;
import cl.bancochile.automatizador.model.Oportunidad;
import cl.bancochile.automatizador.model.OportunidadLista;
import cl.bancochile.automatizador.model.PlanBPM;
import cl.bancochile.automatizador.model.Producto;
import cl.bancochile.automatizador.model.Productos;
import cl.bancochile.automatizador.model.ProductosEliminar;
import cl.bancochile.automatizador.model.Referencia;
import cl.bancochile.automatizador.model.RepLegalProd;
import cl.bancochile.automatizador.model.RepresentanteLegal;
import cl.bancochile.automatizador.model.Scoring;
import cl.bancochile.automatizador.rest.IRestOportunidad;
import cl.bancochile.automatizador.rest.RestOportunidad;
import cl.bancochile.automatizador.util.JsonUtils;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class SaltosOportunidad implements ISaltosOportunidad {
     private final   Logger log = Logger.getLogger(SaltosOportunidad.class);

     @Override
     public   boolean validarAccion(String arrayCaso, int contadorCaso) {
          String accion = "";
          boolean volver = true;
          accion = arrayCaso.substring(arrayCaso.indexOf("[") + 1, arrayCaso.indexOf("]"));

          if (accion.toUpperCase().equals("AUTORIZAR") || accion.toUpperCase().equals("RECHAZAR")
                    || accion.toUpperCase().equals("ANULAR") || accion.toUpperCase().equals("REPARAR")
                    || accion.toUpperCase().equals("ENVIARASCORING") || accion.toUpperCase().equals("ELIMINAR")) {
               volver = true;
          } else {
               if(!"PREVISADO".equals(arrayCaso.substring(0, arrayCaso.indexOf("[")))){
                    log.info(
                              "No se reconoce accion de caso " + contadorCaso + ": " + arrayCaso.toUpperCase().toString().trim());
                    volver = false;
               }
          }
          return volver;
     }
     @Override
     public   void actualizarRepresentanteLegal(String idOportunidad, String endpointWebLogic,
               String userNameProper, String urlRepresentanteLegal, String jsonRepresentanteLegal) {
          urlRepresentanteLegal = urlRepresentanteLegal.replace("idOportunidad", idOportunidad);
          urlRepresentanteLegal = urlRepresentanteLegal.replace("userName", userNameProper);
          RepresentanteLegal representanteLegal = new RepresentanteLegal();
          representanteLegal = (RepresentanteLegal) cl.bancochile.automatizador.util.JsonUtils
                    .parseStringObj(jsonRepresentanteLegal, RepresentanteLegal.class);
          IRestOportunidad restOp = new RestOportunidad();
          restOp.consumirRest3(endpointWebLogic + urlRepresentanteLegal, "POST",
                    cl.bancochile.automatizador.util.JsonUtils.ObjectToJsonString(representanteLegal));
     }
     @Override
     public   void repLegalProd(String idOportunidad,String idProducto, String endpointWebLogic,
               String userNameProper, String urlRepresentanteLegal, String jsonRepresentanteLegal) {
          urlRepresentanteLegal = urlRepresentanteLegal.replace("idOportunidad", idOportunidad);
          urlRepresentanteLegal = urlRepresentanteLegal.replace("idProducto", idProducto);
          urlRepresentanteLegal = urlRepresentanteLegal.replace("userName", userNameProper);
          RepLegalProd[] representanteLegal;
          representanteLegal = (RepLegalProd[]) cl.bancochile.automatizador.util.JsonUtils
                    .parseStringObj(jsonRepresentanteLegal, RepLegalProd[].class);
          IRestOportunidad restOp = new RestOportunidad();
          restOp.consumirRest3(endpointWebLogic + urlRepresentanteLegal, "POST",
                    cl.bancochile.automatizador.util.JsonUtils.ObjectToJsonString(representanteLegal));
     }
     @Override
     public   void eliminarProductos(String jsonProductos, String rut, String nombre,
               String endpointWebLogic, String urlEliminarProductos) {
          urlEliminarProductos = urlEliminarProductos.replace("rut", rut);
          urlEliminarProductos = urlEliminarProductos.replace("nombre", nombre);
          ProductosEliminar productos;
          productos = (ProductosEliminar) cl.bancochile.automatizador.util.JsonUtils
                    .parseStringObj(jsonProductos, ProductosEliminar.class);
          IRestOportunidad restOp = new RestOportunidad();
          restOp.consumirRest3(endpointWebLogic + urlEliminarProductos,"POST",
                    cl.bancochile.automatizador.util.JsonUtils.ObjectToJsonString(productos));

     }
     @Override
     public   void listaAllOpExt(String jsonOp, String endpointWebLogic, String urlListaAllExt) {
          FiltroOpOrden opLista;
          opLista =  (FiltroOpOrden) cl.bancochile.automatizador.util.JsonUtils
                    .parseStringObj(jsonOp, FiltroOpOrden.class);
          IRestOportunidad restOp = new RestOportunidad();
          restOp.consumirRest3(endpointWebLogic + urlListaAllExt,"POST",
                    cl.bancochile.automatizador.util.JsonUtils.ObjectToJsonString(opLista));
     }
     @Override
     public   void listaAllOp(String jsonOp, String endpointWebLogic, String urlListaAllExt) {
          FiltroListaOportunidad listaFiltro;
          listaFiltro = (FiltroListaOportunidad) cl.bancochile.automatizador.util.JsonUtils
                    .parseStringObj(jsonOp, FiltroListaOportunidad.class);
          IRestOportunidad restOp = new RestOportunidad();
          restOp.consumirRest3(endpointWebLogic + urlListaAllExt,"POST",
                    cl.bancochile.automatizador.util.JsonUtils.ObjectToJsonString(listaFiltro));
     }
     @Override
     public   void actualizaReferencias(String idOportunidad, String usuario, String jsonReferencia,
               String endpointWebLogic, String urlReferencias) {

          urlReferencias = urlReferencias.replace("uuid", idOportunidad);
          urlReferencias = urlReferencias.replace("usuario", usuario);
          Referencia[] referencias;
          referencias = (Referencia[]) cl.bancochile.automatizador.util.JsonUtils.parseStringObj(jsonReferencia, Referencia[].class);
          IRestOportunidad restOp = new RestOportunidad();
          restOp.consumirRest3(endpointWebLogic + urlReferencias,"POST" ,
                    cl.bancochile.automatizador.util.JsonUtils.ObjectToJsonString(referencias));

     }
     @Override
     public   String actualizarDatosAdicionales(String idOportunidad, String idProducto,
               String endpointWebLogic, String urlDatosAdicionales, String jsonDatosAdicionales) {       
          Oportunidad _oportunidad;
          urlDatosAdicionales = urlDatosAdicionales.replace("{uuid}", idOportunidad);
          urlDatosAdicionales = urlDatosAdicionales.replace("{idProd}", idProducto);
          IRestOportunidad restOp = new RestOportunidad();
          String oportunidad_rest = restOp.consumirRest3(endpointWebLogic + urlDatosAdicionales, "POST", jsonDatosAdicionales);
          return oportunidad_rest;
     }
     @Override
     public   Oportunidad datosOportunidad(String idOportunidad, String endpointWebLogic,
               String urlOportunidad) {
          Oportunidad _oportunidad;
          urlOportunidad = urlOportunidad.replace("idOportunidad", idOportunidad);
          IRestOportunidad restOp = new RestOportunidad();
          String oportunidad_rest = restOp.consumirRest3(endpointWebLogic + urlOportunidad, "GET", null);
          _oportunidad = (Oportunidad) cl.bancochile.automatizador.util.JsonUtils.parseStringObj(oportunidad_rest,
                    Oportunidad.class);
          return _oportunidad;
     }
     @Override
     public   void agregarComentario(String comentario, String idOportunidad, String endpointWebLogic,
               String urlAgregarComentario, String comentarioOportunidadProper) {
          urlAgregarComentario = urlAgregarComentario.replace("idOportunidad", idOportunidad);
          ComentarioOportunidad comentarioOportunidad = new ComentarioOportunidad();
          comentarioOportunidad = (ComentarioOportunidad) cl.bancochile.automatizador.util.JsonUtils
                    .parseStringObj(comentarioOportunidadProper, ComentarioOportunidad.class);
          comentarioOportunidad.setUuidOportunidad(idOportunidad);
          comentarioOportunidad.setComentario(comentario);

          IRestOportunidad restOp = new RestOportunidad();
          restOp.consumirRest3(endpointWebLogic + urlAgregarComentario, "POST",
                    cl.bancochile.automatizador.util.JsonUtils.ObjectToJsonString(comentarioOportunidad));
     }
     @Override
     public   void actualizarScoring(String idOportunidad, String endpointWebLogic, String urlScoring,
               String userNameProper, String scoring_proper) {
          urlScoring = urlScoring.replace("idOportunidad", idOportunidad);
          urlScoring = urlScoring.replace("username", userNameProper);
          Scoring scoring = new Scoring();
          scoring = (Scoring) cl.bancochile.automatizador.util.JsonUtils.parseStringObj(scoring_proper, Scoring.class);
          IRestOportunidad restOp = new RestOportunidad();
          restOp.consumirRest3(endpointWebLogic + urlScoring, "POST",
                    cl.bancochile.automatizador.util.JsonUtils.ObjectToJsonString(scoring));
     }
     @Override
     public   void agregarProducto(String idOportunidad, String endpointWebLogic, String agregaProducto,
               String urlAgregaProducto,String tipoCuenta) {
          Producto producto = new Producto();
          producto = (Producto) cl.bancochile.automatizador.util.JsonUtils.parseStringObj(agregaProducto, Producto.class);
          urlAgregaProducto = urlAgregaProducto.replace("idOportunidad", idOportunidad);
          //  producto.setNombreFamilia(tipoCuenta);
          IRestOportunidad restOp = new RestOportunidad();
          restOp.consumirRest3(endpointWebLogic + urlAgregaProducto, "POST",
                    cl.bancochile.automatizador.util.JsonUtils.ObjectToJsonString(producto));
     }
     @Override
     public   Oportunidad creaOportunidad(String endpointWebLogic, String creaOportunidad,
               String oportunidadProper) {
          Oportunidad _oportunidad = new Oportunidad();
          String jsonOportunidad;
          _oportunidad = (Oportunidad) cl.bancochile.automatizador.util.JsonUtils.parseStringObj(oportunidadProper,
                    Oportunidad.class);
          IRestOportunidad restOp = new RestOportunidad();
          jsonOportunidad = restOp.consumirRest3(endpointWebLogic + creaOportunidad, "POST",
                    oportunidadProper);
          // cl.bancochile.automatizador.util.JsonUtils.ObjectToJsonString(_oportunidad)
          _oportunidad = (Oportunidad) cl.bancochile.automatizador.util.JsonUtils.parseStringObj(jsonOportunidad,
                    Oportunidad.class);
          return _oportunidad;
     }
     @Override
     public   void testDePruebas(String idBpmProducto, String idOportunidad, String[] arrayCaso, int contProducto) throws Exception {
          // boolean obenterIdSolicitud = false;
          String idSolicitud, idSolicitudBD = "";
          String idTarea, idTareaActual = "";
          String accion, tarea, trxIdOperacion = "";
          String logOportunidad = "";
          List responseOportunidad = new ArrayList<String>();
          for (int i = 0; i < arrayCaso.length; i++) {// verificar objeto con arreglo de caso
               JsonUtils jsonObject = new JsonUtils();
               Oportunidad oportunidad = null;
               String idSolicitudJson, nombreTareaActual = "";
               int cont = 0, idSolicitudAux=0;
               tarea = arrayCaso[i].substring(0, arrayCaso[i].indexOf("["));
               // se identifica accion que  debe tomar tarea...	
               accion = identificaAccion(arrayCaso[i]);
               IRestOportunidad respOp = new RestOportunidad();
               oportunidad = respOp.getOportunidad(idOportunidad);
               idTareaActual = oportunidad.getProductos().get(contProducto).getTareaActual();
               trxIdOperacion = avanceBPM(idBpmProducto, idOportunidad, contProducto, idTareaActual, accion, tarea,
                         trxIdOperacion, jsonObject, oportunidad, nombreTareaActual, idSolicitudAux);
               tiempoEntreLlamados(Main.delaySegundos);
               idSolicitudJson = "";
               logOportunidad = "";
               jsonObject = null;
               //responseOportunidad = null;
               oportunidad = null;
          }

          responseOportunidad = null;
     }
     @Override
     public   String avanceBPM(String idBpmProducto, String idOportunidad, int contProducto, String idTareaActual,
               String accion, String tarea, String trxIdOperacion, JsonUtils jsonObject, Oportunidad oportunidad,
               String nombreTareaActual, int idSolicitudAux) throws JSONException, InterruptedException, IOException {
          String idTarea;
          String logOportunidad;
          List responseOportunidad;
          String idSolicitudJson;   
          String usuario;
          String rut;
          if (!tarea.equals("REGULARIZAR_REPARO") && !tarea.equals("OPORTUNIDAD") && !tarea.equals("PRODUCTO")) {         
               avanzarTareaBack(idBpmProducto, idOportunidad, contProducto, idTareaActual, accion, tarea,
                         trxIdOperacion, jsonObject, oportunidad, nombreTareaActual, idSolicitudAux);
          }else if(tarea.equals("OPORTUNIDAD")){// aca se hace el cambio para que anule la oportunidad segun sea el caso (tarea)
               anularOportunidad( oportunidad);
          }else if (tarea.equals("PRODUCTO")){
               eliminarProductos(oportunidad);
          }else {
               avanzarTareaPorFront(idBpmProducto, idOportunidad, contProducto, accion, tarea, jsonObject, oportunidad,
                         nombreTareaActual, idSolicitudAux);        	         	
          }
          return trxIdOperacion;
     }
     @Override
     public   void anularOportunidad(Oportunidad oportunidad) {
          String usuario;
          String rut;
          HashMap<String,String> mapEjecutivo = (HashMap<String, String>) (oportunidad.getEjecutivo());
          HashMap<String,String> mapCliente = (HashMap<String, String>) (oportunidad.getCliente());
          usuario = mapEjecutivo.get("usuario");
          rut = mapCliente.get("rut");  
          IRestOportunidad restOp = new RestOportunidad();
          restOp.anularOportunidad(Main.direccionAnular, oportunidad.getUuidOportunidad(),usuario, rut);
     }
     @Override
     public   void eliminarProductos( Oportunidad oportunidad) {
          String usuario;
          String rut;
          HashMap<String,String> mapEjecutivo = (HashMap<String, String>) (oportunidad.getEjecutivo());
          HashMap<String,String> mapCliente = (HashMap<String, String>) (oportunidad.getCliente());
          String producto = (String) (oportunidad.getProductos().get(0).getIdProducto());
          usuario = mapEjecutivo.get("usuario");
          rut = mapCliente.get("rut");  
          ProductosEliminar productos = new ProductosEliminar();             
          Productos[] prod = new Productos[1];
          Productos prodEliminar = new Productos();
          prodEliminar.setIdProducto(producto);
          prod[0] = prodEliminar;
          productos.setProductos(prod);

          IRestOportunidad restOp = new RestOportunidad();
          restOp.eliminarProductos(Main.direccionEliminarProducto,
                    cl.bancochile.automatizador.util.JsonUtils.ObjectToJsonString(productos), usuario, rut);
     }
     @Override
     public   void avanzarTareaPorFront(String idBpmProducto, String idOportunidad, int contProducto,
               String accion, String tarea, JsonUtils jsonObject, Oportunidad oportunidad, String nombreTareaActual,
               int idSolicitudAux) throws InterruptedException, JSONException {
          String idTareaActual;
          String idTarea;
          String idSolicitudJson;
          idTarea = oportunidad.getProductos().get(contProducto).getTareaActual();
          nombreTareaActual = getNomTareaActual(idTarea, oportunidad, nombreTareaActual,contProducto);
          log.info(tarea.toUpperCase() + ", Nombre de la tarea: " + nombreTareaActual +", idTarea :" +idTarea);
          IRestOportunidad respOp = new RestOportunidad();
          String respServicioFront = respOp.avanzarTareaFront(idTarea, accion);
          while(respServicioFront.equals("reintento")){
               oportunidad = respOp.getOportunidad(idOportunidad);
               idTareaActual = oportunidad.getProductos().get(contProducto).getTareaActual();
               nombreTareaActual = getNomTareaActual(idTareaActual, oportunidad, nombreTareaActual,contProducto);
               idTarea = oportunidad.getProductos().get(contProducto).getTareaActual();
               idSolicitudJson = getIdsolicitud(idBpmProducto, idOportunidad, jsonObject, idSolicitudAux,tarea);
               log.info(tarea.toUpperCase() + ", Nombre de la tarea: " + nombreTareaActual +", idTarea :" +idTarea);
               respServicioFront = respOp.avanzarTareaFront(idTarea, accion);
          }
     }
     @Override
     public   void avanzarTareaBack(String idBpmProducto, String idOportunidad, int contProducto,
               String idTareaActual, String accion, String tarea, String trxIdOperacion, JsonUtils jsonObject,
               Oportunidad oportunidad, String nombreTareaActual, int idSolicitudAux)
                         throws JSONException, InterruptedException, IOException {
          String idSolicitudJson = "0";
          nombreTareaActual = getNomTareaActual(idTareaActual, oportunidad, nombreTareaActual,contProducto);

          if (tarea.contains("AGRUPAMIENTO")){
               trxIdOperacion = getTrxIdOperacion(idBpmProducto, idOportunidad, jsonObject, idSolicitudAux,tarea,accion);
               return;
          }else{
               idSolicitudJson = getIdsolicitud(idBpmProducto, idOportunidad, jsonObject, idSolicitudAux,tarea);   
          }

          log.info(tarea.toUpperCase() + ", Nombre de la tarea: " + nombreTareaActual +", idSolicitudJson :" +
                    idSolicitudJson+", trxIdOperacion: "+trxIdOperacion+", idTareaActual: "+idTareaActual+", IdBPMProducto: "+idBpmProducto);
          String respuestaServicio = "";        
          if(accion.contains("PREVISADO")){
               accion = accion.substring(accion.indexOf("[") + 1, accion.indexOf("]"));
               IRestOportunidad restOp = new RestOportunidad();
               String respPrevisado = restOp.mensajeIMQA(idSolicitudJson,idBpmProducto,accion); 
               log.debug("actualizaestadoim: "+respPrevisado);
          }else{
               IRestOportunidad respOp = new RestOportunidad();
               respuestaServicio = respOp.avanzaTarea(idBpmProducto,accion, idSolicitudJson);
          }
          while(respuestaServicio.equals("reintento")){
               IRestOportunidad respOp = new RestOportunidad();
               oportunidad = respOp.getOportunidad(idOportunidad);
               idTareaActual = oportunidad.getProductos().get(contProducto).getTareaActual();
               nombreTareaActual = getNomTareaActual(idTareaActual, oportunidad, nombreTareaActual,contProducto);
               idSolicitudJson = getIdsolicitud(idBpmProducto, idOportunidad, jsonObject, idSolicitudAux,tarea);
               log.info(tarea.toUpperCase() + ", Nombre de la tarea: " + nombreTareaActual +", idSolicitudJson :" +idSolicitudJson+", trxIdOperacion: "+trxIdOperacion+", idTareaActual: "+idTareaActual+", IdBPMProducto: "+idBpmProducto);
               respOp = new RestOportunidad();
               respuestaServicio = respOp.avanzaTarea(idBpmProducto,accion, idSolicitudJson);
          }
     }
     @Override
     public   String getIdsolicitud(String idBpmProducto, String idOportunidad, JsonUtils jsonObject,
               int idSolicitudAux,String tarea) throws JSONException {
          String logOportunidad;
          List responseOportunidad;
          String idSolicitudJson;
          String trxIdOperacion;
          IRestOportunidad respOp = new RestOportunidad();
          logOportunidad = respOp.logOportunidad(idOportunidad);
          responseOportunidad = jsonObject.tomarKeyJson(logOportunidad,"response");       	
          for (int cont=0; cont < responseOportunidad.size(); cont++) {
               trxIdOperacion=jsonObject.entregaKeyJson(responseOportunidad.get(cont).toString(), "trxIdOperacion");
               //    if(trxIdOperacion.equals(idBpmProducto)) {
               idSolicitudJson = jsonObject.entregaKeyJson(responseOportunidad.get(cont).toString(), "idSolicitud");
               //se busca el mayor id de solicitud...
               if (Integer.parseInt(idSolicitudJson) > idSolicitudAux) {
                    idSolicitudAux = Integer.parseInt(idSolicitudJson);
               }
               //      }					
          } 
          idSolicitudJson = String.valueOf(idSolicitudAux);
          if (tarea.toUpperCase().equals("ORIGINACION")) {                  
               idSolicitudJson = "CURSE";     
          }
          return idSolicitudJson;
     }
     @Override
     public   String getTrxIdOperacion(String idBpmProducto, String idOportunidad, JsonUtils jsonObject,
               int idSolicitudAux,String tarea,String accion) throws JSONException, IOException {
          String logOportunidad;
          List responseOportunidad;
          String idSolicitudJson = "";
          String trxIdOperacion = "";
          IRestOportunidad respOp = new RestOportunidad();
          logOportunidad = respOp.logOportunidad(idOportunidad);
          responseOportunidad = jsonObject.tomarKeyJson(logOportunidad,"response");         
          for (int cont=0; cont < responseOportunidad.size(); cont++) {
               trxIdOperacion=jsonObject.entregaKeyJson(responseOportunidad.get(cont).toString(), "trxIdOperacion");
               idSolicitudJson = jsonObject.entregaKeyJson(responseOportunidad.get(cont).toString(), "idSolicitud");
               if (Integer.parseInt(idSolicitudJson) > idSolicitudAux) {
                    idSolicitudAux = Integer.parseInt(idSolicitudJson);
               }                    
          } 
          IRestOportunidad restOp = new RestOportunidad();
          String respPrevisado = restOp.avanzarTareasAgrupadas(idSolicitudJson,trxIdOperacion,accion); 


          return trxIdOperacion;
     }
     @Override
     public   String getNomTareaActual(String idTareaActual, Oportunidad oportunidad,
               String nombreTareaActual, int contProducto) {
          for (int contTarea = 0; contTarea < oportunidad.getProductos()
                    .get(contProducto).getTareas().size(); contTarea++ ) {
               if (oportunidad.getProductos().get(contProducto).getTareas()
                         .get(contTarea).getIdTarea().equals(idTareaActual)) {
                    nombreTareaActual=oportunidad.getProductos().get(contProducto)
                              .getTareas().get(contTarea).getNombreTarea();
                    break;
               }

          }
          return nombreTareaActual;
     }
     @Override
     public   String identificaAccion(String accion) {
          String accionARealizar = "";
          String tarea = "";
          tarea = accion.substring(0, accion.indexOf("["));
          //log.info(tarea + ", ");
          accionARealizar = accion.substring(accion.indexOf("[") + 1, accion.indexOf("]"));
          //log.info("accion: " + accionARealizar + " ");
          if (tarea.equals("REGULARIZAR_REPARO")) {
               accion = accionARealizar.toUpperCase().trim();
          } else {
               if (accionARealizar.toUpperCase().equals("AUTORIZAR")) {
                    accion = "5";
               } else if (accionARealizar.toUpperCase().equals("RECHAZAR")) {
                    accion = "4";
               } else if (accionARealizar.toUpperCase().equals("REPARAR")) {
                    accion = "6";
               } else if (accionARealizar.toUpperCase().equals("ANULAR")) {
                    accion = accionARealizar.toUpperCase().trim();
               } else if (accionARealizar.toUpperCase().equals("ELIMINAR")) {
                    accion = accionARealizar.toUpperCase().trim();
               }
          }
          return accion;
     }
     @Override
     public   void casoFeliz(String idBpmProducto, List<String> accion, String idSolicitud) {
          if (idBpmProducto != null) {
               for (int i = 1; 5 >= i; i++) {
                    log.info(accion.get(i - 1));
                    tiempoEntreLlamados(Main.delaySegundos);
                    IRestOportunidad respOp = new RestOportunidad();
                    String respuestaServicio = respOp.avanzaTarea(idBpmProducto, "5", idSolicitud);
               }
          }
     }
     @Override
     public   void tiempoEntreLlamados(int segundos) {
          if (Main.modoAutomatico == 0 ){
               String entradaTeclado = "";
               log.info ("Presione Enter para continuar.");
               Scanner entradaEscaner = new Scanner (System.in); //Creación de un objeto Scanner
               entradaTeclado = entradaEscaner.nextLine (); //Invocamos un método sobre un objeto Scanner
          }else{
               try {
                    Thread.sleep(segundos * 1000);
               } catch (InterruptedException e1) {
                    e1.printStackTrace();
               }
          }
     }
     @Override
     public   void leerArchivo() {
          try {

               /* Creamos un Objeto de tipo Properties */
               Properties propiedades = new Properties();
               log.info(System.getProperty("user.dir"));
               /* Cargamos el archivo desde la ruta especificada */
               File file = new File("entrada.properties");
               propiedades.load(new FileInputStream(file));

               /* Obtenemos los parametros definidos en el archivo */
               String nombre = propiedades.getProperty("nombre");
               String pagina = propiedades.getProperty("pagina");

               /* Imprimimos los valores */
               log.info("Nombre: " + nombre + "\n" + "Pagina: " + pagina);

          } catch (FileNotFoundException e) {
               log.error("Error, El archivo no existe" + e);
          } catch (IOException e) {
               log.error("Error, No se puede leer el archivo" + e);
          }
     }
     @Override
     public   Properties leerArchivo2() {
          Properties propiedades = new Properties();
          try {

               /* Creamos un Objeto de tipo Properties */

               log.info(System.getProperty("user.dir"));
               /* Cargamos el archivo desde la ruta especificada */
               File file = new File("entrada.properties");
               propiedades.load(new FileInputStream(file));

          } catch (FileNotFoundException e) {
               log.error("Error, El archivo no existe" + e);
          } catch (IOException e) {
               log.error("Error, No se puede leer el archivo" + e);
          }
          return propiedades;
     }
     @Override
     public   void listarOportunidades() {
          OkHttpClient client = new OkHttpClient();

          MediaType mediaType = MediaType.parse("application/json");
          RequestBody body = RequestBody.create(mediaType,
                    "{\n \"uuidOp\": null,\n \"codOficina\": null,\n \"usuario\": \"pcalderon\",\n \"rutCliente\": null,\n \"canal\": null,\n \"fechaCreacion\": -2186162234000,\n \"pagina\": 1,\n \"regsPag\": 10,\n \"estado\": null,\n \"flag\": null\n}");
          Request request = new Request.Builder()
                    .url("http://portalcomercial.qa.labchile.cl:8888/miplataforma/bpm-oportunidad-rest/oportunidad/lista").put(body)
                    .addHeader("Cookie",
                              "OAM_REQ_0=invalid; OAM_REQ_COUNT=VERSION_4~1; OAM_JSESSIONID=4i4M8E-o6NH40lT651zeH_XPvV1ftYoWgGhlLJL0zUzqz76_QhIl!2071472000; JSESSIONID=w3YM8dZQB6Mv1Ec31aaC5MJyGnVvoxOCFIGnm5CmPDMKIsc5ClAf!-1902067499; OAM_ID=VERSION_4~iM/Eex5CZmGsGmbLHkRDzA==~5g/pgiumVFnrvKusbPFf5h5J/PvIQ8M5ZiucPUJ/rQWsf5Ok9qmoP24itQV3JysIqH5LFQGI8KDgmQT6GmlhFRLiH3h8lLpzzTUWtl8XFe/8SJh+qCY9fJuJsyytlQUwUnDTjchi5J13qcFfh0C0Ig+CF6MgC84+o6XHihlwe6FyxAZNBNZpGMwnEzW3AbUK3dtwdxi48xAn0JK1hntMstwbrbMdRQAikmm41SWNRlNK7gmQP1eNWzoKXOSXH+aXKXjgnFSmH0uomXw8rfn+gwTO5VwSu0EPCBWOuehE7XjKW7JRkcDZBZskvsS9tEhHtDYCeSFwiecj3yWASsA4zw==; OAMAuthnCookie_portalcomercial.qa.labchile.cl:8888=yQ5xPYxbshzFeX5GmD%2FPORvV1pG%2BeH%2FFW3mfTZ2PfM73Wwa%2FXmZ0NgL5ljBGmW8Yqb9O8TclXur%2FZfa92l9QBc3A8yfER3vTUBH%2BcSPISTIovRlPkB7P%2Fr1jZ%2FTJ3%2FGUx8eGLxbtppVq4kmB%2BsnlMvBqW9YSPkq17axzgFljPd6lD8h3U2EZI0WbZgEwNEpgQM%2FfWGsCRj9t4%2FMdU9QtXM1Nn4ithyAE0l9T%2FzhocYwRcSMbxNjLqRzqmj9zEZasQ4zHyqWsb%2BBxktKwvOx66IbRRPq%2FmSXpwtZ%2Bk3%2BJC%2FdjdQYqDjaFScWD0u%2FfK1makXjC%2BtAqn2RlhrHM8iwhQZNPVlhv%2FSXltl8IaUHLXaxxFKpiOlafzTVIipbP65OvVtL6GjBbk00yjhz6kpPKPvGV9TtOrlC%2FN16ptMMeP0%2F%2BPBZ6wtF1UGEDwEsx3tkMJKCyha9NOMOQoAgf9NdDuTsaEk7fT9wAsud1GHXAjzNZSi7Q6795dHVIqtrpqJSdW7DguP6zDzc2Ig8nC4IycCXtdb3OIHQuLSKoIc7ZQA%2BUQevbU9NJ0ItXlHOhCGuee19nWQAHLYIkO5CQgPKwow%3D%3D; ORA_OTD_JROUTE=ruwsc8bxY9E1es54")
                    .addHeader("cache-control", "no-cache")
                    .addHeader("postman-token", "401bcd05-dbba-8ee4-cdfd-f985b8bf31b1").build();

          try {
               Response response = client.newCall(request).execute();
               log.info("Lista: " + response.body().string());
          } catch (IOException e) {
               e.printStackTrace();
          }
     }
     @Override
     public   PlanBPM obtenerPlanPrueba(String planDePruebas) {
          PlanBPM planesPrueba = new PlanBPM();
          try {
               ObjectMapper mapper = new ObjectMapper();
               planesPrueba = mapper.readValue(new File(planDePruebas), PlanBPM.class);
          } catch (JsonParseException e1) {
               e1.printStackTrace();
          } catch (JsonMappingException e1) {
               e1.printStackTrace();
          } catch (IOException e1) {
               e1.printStackTrace();
          }
          return planesPrueba;
     }
     @Override
     public   String flujoBPM(Oportunidad _oportunidad, String idBpmProducto, String idOportunidad,
               boolean estadoCasos, String stringCasos, String[] arrayCaso, int contadorCaso) {
          if (estadoCasos) {
               ISaltosOportunidad saltOP = new SaltosOportunidad();
               saltOP.tiempoEntreLlamados(Main.delaySegundos);
               IRestOportunidad respOp = new RestOportunidad();
               respOp.iniciarProceso(idOportunidad);
               saltOP.tiempoEntreLlamados(Main.delaySegundos);
               try {
                    _oportunidad = respOp.getOportunidad(idOportunidad);
               } catch (InterruptedException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                    log.error("error al llamar al getOportunidad");
               }
               try {

                    idBpmProducto = recorridoPruebasPorProducto(_oportunidad, idBpmProducto,
                              idOportunidad, stringCasos,
                              arrayCaso, contadorCaso);             

               } catch (IndexOutOfBoundsException e) {
                    log.error("no se encuentra : el IdBpmPRoducto o la tarea ",e);
                   
                    System.exit(0);
               } catch (Exception e) {
                   
                    log.error("no se encuentra : el IdBpmPRoducto o la tarea ",e);
                    System.exit(0);
               }

          }
          return idBpmProducto;
     }
     @Override
     public  String recorridoPruebasPorProducto(Oportunidad _oportunidad, String idBpmProducto,
               String idOportunidad, String stringCasos, String[] arrayCaso, int contadorCaso)
                         throws InterruptedException, Exception {
          for(int contProd = 0; contProd < _oportunidad.getProductos().size(); contProd++) {
               try{
                    _oportunidad.getProductos().get(contProd).getTareas().get(0).getIdTarea();
               } catch (IndexOutOfBoundsException e) {

                    _oportunidad = callOportunidad(_oportunidad, idOportunidad,contProd);

               }
               idBpmProducto = _oportunidad.getProductos().get(contProd).getIdBPMProducto();
               log.info("Caso de prueba: " + contadorCaso + " Casos: " + stringCasos);

               testDePruebas(idBpmProducto, idOportunidad, arrayCaso,contProd);

               log.info("Caso de Prueba " + contadorCaso + " Ejecutado");
          }
          return idBpmProducto;
     }
     @Override
     public Oportunidad callOportunidad(Oportunidad _oportunidad, String idOportunidad,int contProd)
               throws InterruptedException {
          log.info("no se encuentra : el IdBpmPRoducto o la tarea ");
          log.info("¿Reintentar? S/N");
          Scanner entradaEscaner = new Scanner (System.in); //Creación de un objeto Scanner
          String entradaTeclado = entradaEscaner.nextLine (); //Invocamos un método sobre un objeto Scanner
          if (entradaTeclado.toUpperCase().equals("S")){
               IRestOportunidad restOp = new RestOportunidad();
               _oportunidad = restOp.getOportunidad(idOportunidad); 
               try{
                    if( _oportunidad.getProductos().get(contProd).getTareas().get(0).getIdTarea() == null){
                         callOportunidad(_oportunidad, idOportunidad, contProd);
                    }
               }catch(IndexOutOfBoundsException e){
                    log.error("no se encuentra : el IdBpmPRoducto o la tarea");
                    callOportunidad(_oportunidad, idOportunidad, contProd);
               }
          }else{
               log.error("no se encuentra : el IdBpmPRoducto o la tarea");
               System.exit(0);
          }
          return _oportunidad;
     }
     @Override
     public  boolean validarCasoPruebas(boolean estadoCasos, String[] arrayCaso, int contadorCaso) {
          for (int p = 0; p < arrayCaso.length; p++) {// Se realiza
               // validacion de
               // acciones para
               // caso de prueba...
               ISaltosOportunidad saltOp = new SaltosOportunidad();
               if (!saltOp.validarAccion(arrayCaso[p], contadorCaso)) {
                    estadoCasos = false;
                    break;
               } else {
                    estadoCasos = true;
               }
          }
          return estadoCasos;
     }

}
