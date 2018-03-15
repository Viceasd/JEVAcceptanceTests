package cl.bancochile.automatizador;

import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import cl.bancochile.automatizador.controlador.ISaltosOportunidad;
import cl.bancochile.automatizador.controlador.SaltosOportunidad;
import cl.bancochile.automatizador.model.Caso;
import cl.bancochile.automatizador.model.Oportunidad;
import cl.bancochile.automatizador.model.Plan;
import cl.bancochile.automatizador.model.PlanBPM;
import cl.bancochile.automatizador.rest.RestOportunidad;
import cl.bancochile.automatizador.util.JsonUtils;

public class Main {
     private final static Logger log = Logger.getLogger(Main.class);
     public static Properties propiedades;
     public static int delaySegundos = 30;
     public static int modoAutomatico = 0;
     public static String direccionAnular = "";
     public static String direccionEliminarProducto ="";

     public static void main(String[] args) {
          
          JsonUtils.jsonProperties("json-oportunidad.properties",
                    "oportunidad_ctacorriente_ahorro");
          PropertyConfigurator.configure("log4j.properties");
 
          propiedades = new Properties();
          ISaltosOportunidad saltOp = new SaltosOportunidad();
          propiedades = saltOp.leerArchivo2();
          Oportunidad _oportunidad = new Oportunidad();
          String oportunidadProper = propiedades.getProperty("oportunidad_ctacorriente_ahorro");
          String agregaProducto = propiedades.getProperty("produccto_cc_12032018");
          String comentario = propiedades.getProperty("comentario");
          String idBpmProducto = "";
          String idOportunidad = "";
          String entorno = propiedades.getProperty("entorno");
          String endpointWebLogic = propiedades
                    .getProperty(entorno.equals("DESA") ? "end_point_weblogic_desa" : "end_point_weblogic_qa");
          String endpointBPM = propiedades
                    .getProperty(entorno.equals("DESA")? "end_point_BPM_desa" : "end_point_BPM_qa_balan");
          String cookies = propiedades.getProperty("cookies");          
          String urlAgregaProducto = propiedades.getProperty("agregar_producto_url");
          String urlScoring = propiedades.getProperty("scoring_url");
          String userNameProper = propiedades.getProperty("user_name");
          String scoring_proper = propiedades.getProperty("scoring_previsado");
          String urlAgregarComentario = propiedades.getProperty("comentario_oportunidad_url");
          String comentarioOportunidadProper = propiedades.getProperty("comentario_oportunidad");
          String datosAdicionales = propiedades.getProperty("datos_adicionales");
          String urlOportunidad = propiedades.getProperty("oportunidad_url");
          String urlRepresentanteLegal = propiedades.getProperty("representante_legal_url");
          String jsonRepresentanteLegal = propiedades.getProperty("representante_legal");
          String jsonRepLegalProd = propiedades.getProperty("rep_legal_prod");
          String urlRepLegalProd = propiedades.getProperty("rep_legal_prod_url");
          String creaOportunidad = propiedades.getProperty("crea_oportunidad_url");          
          String jsonReferencias = propiedades.getProperty("referencias");
          String urlReferencias = propiedades.getProperty("referencias_url");
          direccionAnular = propiedades.getProperty("anula_oportunidad_url");
          direccionEliminarProducto = propiedades.getProperty("eliminar_productos_url");
          String jsonEliminarProductos = propiedades.getProperty("eliminar_productos");
          String rut = propiedades.getProperty("rutUsuarioEjecutivo");
          Arrays.asList("PATROCINIO", "CUMPLIMIENTO", "PEP", "VISAR", "ORIGINACION");
          modoAutomatico = Integer.valueOf(propiedades.getProperty("proceso_automatico"));
          delaySegundos = Integer.valueOf(propiedades.getProperty("delay_segundos"));
          String jsonOpExt = propiedades.getProperty("lista_All_Exp");
          String urlListaAllExt = propiedades.getProperty("listar_all_ext_url");
          String jsonOp = propiedades.getProperty("lista_All");
          String urlListaAll = propiedades.getProperty("listar_all_url");
          String urlDatosAdicionales = propiedades.getProperty("datos_adicionales_url");

          boolean estadoCasos = false;

          RestOportunidad.endPoint = endpointWebLogic;
          RestOportunidad.endPointIniProce = "http://otd-priv:20015";
          RestOportunidad.cookies = cookies;
          RestOportunidad.ambiente = entorno;

          // RestOportunidad.listaOportunidad();
          String planesCuentas = propiedades.getProperty("planEjecucionPruebas");

          String ctaPlanes[] = planesCuentas.split(",");
          boolean pruebasManual = false;
          if(pruebasManual){
               try {
                    RestOportunidad restOp = new RestOportunidad();
                    restOp.selectIdSolicitud("55774");
               } catch (Exception e) {     
                    log.error("error al seleccionar idSolicitud "+e);
               }
          }
          else{
               for (int ctaAux = 0; ctaAux < ctaPlanes.length ; ctaAux++){
                    saltOp = new SaltosOportunidad();
                    PlanBPM planesPrueba = saltOp.obtenerPlanPrueba(ctaPlanes[ctaAux].trim());
                    
                    Plan[] plan = planesPrueba.getPlan();
                    String stringCasos = "";
                    String[] arrayCaso = null;
                    int contadorPlan, contadorCaso = 0;

                    // log.info(log[0].getResponse().get(0).getIdSolicitud());
                    // Se crea ciclo para recorrer arreglo de planes de prueba a ejecutar...

                    //
                    for (int k = 0; k < plan.length; k++) {
                         contadorPlan = k + 1;
                         log.info("Plan de prueba: " + contadorPlan);
                         Caso[] casos = plan[k].getCasos();
                         log.info("Tipo de Cuenta: "+plan[k].getTipoCuenta());
                         for (int l = 0; l < casos.length; l++) {
                              // Paso 1 Crear Oportunidad
                              contadorCaso++;
                              //http://portalcomercial.qa.labchile.cl:8888/http://portalcomercial.qa.labchile.cl:8888/miplataforma/bpm-rest/oportunidad/CDN20180108110522232PLAT564951/anula/10953289-4/Daniza Marcela Paredes Zepeda
                              //  RestOportunidad.anularOportunidad(Main.direccionAnular, "CDN20180104105643260PLAT184671","dparedes","1-9");
                              //        SaltosOportunidad.listaAllOp(jsonOp, endpointWebLogic, urlListaAll);O
                              saltOp = new SaltosOportunidad();
                              _oportunidad = saltOp.creaOportunidad(endpointWebLogic, creaOportunidad, oportunidadProper);
                              idOportunidad = _oportunidad.getUuidOportunidad();


                              // Paso 1.1 Llamado Folio
                              // RestOportunidad.llamadoNumeroFolio();

                              // Paso 2 Agregar Producto
                              // public static String endPoint = endPointDesa;                   
                              //  SaltosOportunidad.agregarProducto(idOportunidad, endpointWebLogic, agregaProducto, urlAgregaProducto,plan[k].getTipoCuenta());
                              saltOp.agregarProducto(idOportunidad, endpointWebLogic,
                                        agregaProducto, urlAgregaProducto,"Cuenta Corriente");
//                              SaltosOportunidad.agregarProducto(idOportunidad, endpointWebLogic,
//                                        propiedades.getProperty("producto_cvista"), urlAgregaProducto,plan[k].getTipoCuenta());
//                              
                              saltOp.agregarProducto(idOportunidad, endpointWebLogic,
                                        propiedades.getProperty("producto_cvista"), urlAgregaProducto,"Cuenta Vista");
                              // Paso 3 Actualizar Scoring
                              saltOp.actualizarScoring(idOportunidad, endpointWebLogic, urlScoring, userNameProper,scoring_proper);
                              // //Paso 4 Agregar Comentario
                              saltOp.agregarComentario(comentario, idOportunidad, endpointWebLogic, urlAgregarComentario,
                                        comentarioOportunidadProper);    
                              // //Paso 5 Actualizar Datos Adicionales
                              _oportunidad = saltOp.datosOportunidad(idOportunidad, endpointWebLogic,
                                        urlOportunidad);
                              _oportunidad.getProductos().get(0).getIdProducto();
                              saltOp.actualizarDatosAdicionales(idOportunidad,_oportunidad.getProductos().get(0).getIdProducto(),
                                        endpointWebLogic,urlDatosAdicionales,datosAdicionales);
                              // //Paso 6 Actualizar Representante Legal
                              saltOp.repLegalProd(idOportunidad,_oportunidad.getProductos().get(0).getIdProducto(),
                                        endpointWebLogic, userNameProper, urlRepLegalProd, jsonRepLegalProd);

                              saltOp.actualizaReferencias(idOportunidad, userNameProper, jsonReferencias, endpointWebLogic, urlReferencias);
                              //                  SaltosOportunidad.actualizarRepresentanteLegal(idOportunidad, endpointWebLogic, userNameProper,
                              //                            urlRepresentanteLegal, jsonRepresentanteLegal);    
                              // //Paso 7 Iniciar Proceso -> BPM

                              //descomentar para ejecutar servicio eliminar productos en base a jsoneliminarProductos 
                              //desde properties cuando se quiera eliminar antes de iniciar proceso BPM


                              //  SaltosOportunidad.eliminarProductos(jsonEliminarProductos, rut, userNameProper, endpointWebLogic, direccionEliminarProducto);
                              String accion = plan[k].getCasoOportunidad()[0].getAccion();
                              if( (accion.contains("PRODUCTO[eliminar]" )) && ((int) 10 == l)){
                                   saltOp.eliminarProductos(_oportunidad);
                              }
                              if( (accion.contains("OPORTUNIDAD[anular]" )) && ((int) 10 == l)){
                                   saltOp. anularOportunidad(_oportunidad);
                              } 

                              stringCasos = casos[l].getValor();// {"reparar",
                              // "patrocinio","cumplimiento","pep","visar","reparar","visar","esperar
                              // curse
                              // producto","autorizar"};
                              arrayCaso = stringCasos.split(",");
                              estadoCasos = saltOp.validarCasoPruebas(estadoCasos, arrayCaso, contadorCaso);                   
                              idBpmProducto = saltOp.flujoBPM(_oportunidad, idBpmProducto, idOportunidad, estadoCasos, stringCasos,
                                        arrayCaso, contadorCaso);                    
                         }
                         log.info("Finalizo plan de prueba: " + contadorPlan);
                    }
               }  
               log.info("Fin de ejecucion");
          }
     }





}