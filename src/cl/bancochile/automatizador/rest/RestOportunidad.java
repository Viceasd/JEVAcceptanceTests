package cl.bancochile.automatizador.rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;

import cl.bancochile.automatizador.helper.HelperStringJson;
import cl.bancochile.automatizador.model.IdOportunidad;
import cl.bancochile.automatizador.model.Oportunidad;
import cl.bancochile.automatizador.model.RespuestaGenerica;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class RestOportunidad implements IRestOportunidad {
     private final static Logger log = Logger.getLogger(RestOportunidad.class);
     // EndPoint para Weblogic
     public static String endPointDesa = "http://200.14.166.72:7011";
     public static String endPointQa = "http://portalcomercial.qa.labchile.cl:8888";

     // EndPoint para BPM
     public static String endPointIniProceQaBalan = "http://152.139.147.198"; // balanceador
     public static String endPointIniProceQa = "http://152.139.147.152:9081";
     public static String endPointIniProceDesa = "http://200.14.147.133:9080";

     public static String endPoint = endPointDesa;
     public static String endPointIniProce = endPointIniProceDesa;
     public static String cookies = "OAM_REQ_0=invalid; OAM_REQ_COUNT=VERSION_4~1; OAM_JSESSIONID=4i4M8E-o6NH40lT651zeH_XPvV1ftYoWgGhlLJL0zUzqz76_QhIl!2071472000; OAM_ID=VERSION_4~l1+bCTjUaCPQPn6iOG6gsw==~a8vj9LMawCK1f5UbItlq85P3l2lBSqU3d9EaHK0GVSqrfWosHGPIfV7TAPxiMTXk8l6JgpjwXLbgOGLLsXGV8nocNoLNI80QQ4SsQe9+eESkuFx+3GFuOXIl52JpHSObvrSL86v+RNXLOcuecBYTZWSBve5uWTIvCkIo65iTYrutbh1AZvr0l7zXCj1BGjA96B8p0nG+kx3iyFKaoffcRvTQc7N6YVaExwfY8M2xXwf52EN+N2zYMG0c+l/Eq73Z+Himt3dWHkQNrX6snvNlqMabdBr+2y5A9BUx3be8ecifIzgrwY4igNheIANipQQlsozPI4k6P2d5Y6Q/qiKQIQ==; OAMAuthnCookie_portalcomercial.qa.labchile.cl:8888=BMaBKuJkbX58euqChOc6xgp7%2BnGmi55NTTswvJab4LaC6r5D%2Bd0vF%2B7CLluyZ0xQEUTTcneCLyAbemE%2F%2B6yI47Y9108IbWEEQQpl55gvXpXZPxxqyf7JgvZuhvsuCuelgt5k57%2Bv2OWeiSYifpXxxbT8JILjX5f%2FZ2NL7E7dG0uTy9FdxVbvIAEbskwormdRxFzF5%2FrUZvsHd1%2Bvv1Xh6qUvKA1%2B7kRydjlH7bTF%2Bj3nT2HczPeNwIi9T3HwsPoBsE%2BDyT2%2BkHvGAnUmlVtzv9W5otqG4mzQObFzN6haHRdCulcKHf0JF1uEgHOkJjW4mLdprSp0QPj8sIqjSCKGRXyGiJ1Wk9pXoSxKcQFCIwdANe0z3SoJ67eGunNgYCqM8oe3euFPUraglwvKbqjRJeJAHTJ3oPuRpbej9JeVeBkVdEOHfaLlUr6RZB0LyntIcE6jUb98BYQLvKJ4sZ75CIsiID6Lx56g%2FWOsGyB9QOLOPPeQiaNVqlYw%2BIOZyTS%2BGUniWF3s8TuWyi%2B0XuoSVusefBlqjn%2BF43mxmSOu%2BCZgxx3erMMF2PZd3xMQ4vHuK1l1h1KbVHkYGKzNlSgcEw%3D%3D; JSESSIONID=w3YM8dZQB6Mv1Ec31aaC5MJyGnVvoxOCFIGnm5CmPDMKIsc5ClAf!-1902067499; ORA_OTD_JROUTE=ruwsc8bxY9E1es54";
     public static String ambiente = "";
     
     @Override
     public  IdOportunidad llamadoCreaOportunidad(String jsonOportunidad) {
          String respuesta = "";
          Oportunidad oportunidad = new Oportunidad();
          oportunidad = (Oportunidad) cl.bancochile.automatizador.util.JsonUtils.parseStringObj(jsonOportunidad,
                    Oportunidad.class);
          OkHttpClient client = new OkHttpClient();
          MediaType mediaType = MediaType.parse("application/json");
          RequestBody body = RequestBody.create(mediaType,
                    cl.bancochile.automatizador.util.JsonUtils.ObjectToJson(oportunidad));
          Request request = new Request.Builder().url(endPoint + "/miplataforma/bpm-oportunidad-rest/oportunidad/crea").post(body)
                    .addHeader("content-type", "application/json").addHeader("cache-control", "no-cache")
                    .addHeader("postman-token", "dc77e159-5a35-5f12-7237-1f66f1790b80").addHeader("Cookie", cookies)
                    .build();
          Response response = null;
          IdOportunidad oP = new IdOportunidad();
          List<IdOportunidad> oPs = new ArrayList<IdOportunidad>();
          try {
               response = client.newCall(request).execute();
               respuesta = response.body().string();
               log.info(respuesta);
               oP = parseString(respuesta);
          } catch (IOException e) {

               log.error("error en el cliente"+e);
          } finally {
               response.body().close();
          }
          return oP;
     }
     @Override
     public String agregaProducto(String idOportunidad, String nFolio) {
          String respuesta = "";
          OkHttpClient client = new OkHttpClient();

          MediaType mediaType = MediaType.parse("application/json");
          RequestBody body = RequestBody.create(mediaType, HelperStringJson.jsonAgregarProducto);
          Request request = new Request.Builder()
                    .url(endPoint + "/miplataforma/bpm-oportunidad-rest/oportunidad/" + idOportunidad + "/producto").post(body)
                    .addHeader("content-type", "application/json").addHeader("cache-control", "no-cache")
                    .addHeader("postman-token", "7934f8b7-4bbd-c511-b561-bca017183088").addHeader("Cookie", cookies)
                    .build();
          Response response = null;
          try {
               response = client.newCall(request).execute();
          } catch (IOException e) {

               log.error("error en el cliente"+e);
          }
          try {
               respuesta = response.body().string();
               log.info("agregaProducto: " + respuesta);
          } catch (IOException e) {

               log.error("error en el cliente"+e);
          } finally {
               response.body().close();
          }
          return respuesta;
     }
     @Override
     public  String actualizarScoring(String username, String idOportunidad) {
          String respuesta = "";
          OkHttpClient client = new OkHttpClient();

          MediaType mediaType = MediaType.parse("application/json");
          RequestBody body = RequestBody.create(mediaType,
                    "{\r\n \"scoring\": \"NA\",\r\n \"parametros\": \"NA\",\r\n \"politicaRiesgo\": \"NA\",\r\n \"politicaProducto\": \"S\",\r\n \"pautaEvaluacion\": \"000 - No Aplica\",\r\n \"totalEvaluacion\": \"123\",\r\n \"montoMaximo\": \"123\",\r\n \"coutaMaximo\": \"123\",\r\n \"consumo\": \"0\",\r\n \"rotativo\": \"123\",\r\n \"nivelAtribuciones\": \"0\",\r\n \"nivelRiesgo\": \"0\",\r\n \"tipoVenta\": \"123\"\r\n}");
          Request request = new Request.Builder()
                    .url(endPoint + "/miplataforma/bpm-oportunidad-rest/oportunidad/" + idOportunidad + "/" + username + "/scoring")
                    .post(body).addHeader("content-type", "application/json").addHeader("cache-control", "no-cache")
                    .addHeader("postman-token", "7823f0f9-e6c8-ddbe-34fa-b8efe44c40f4").addHeader("Cookie", cookies)
                    .build();

          Response response = null;

          try {
               response = client.newCall(request).execute();
          } catch (IOException e) {

               log.error("error en el cliente"+e);
          }
          try {
               respuesta = response.body().string();
               log.info("actualizarScoring: " + respuesta);
          } catch (IOException e) {

               log.error("error en el cliente"+e);
          } finally {
               response.body().close();
          }

          return respuesta;
     }
     @Override
     public  String agregarComentarioOportunidad(String idOportunidad, String comentario) {
          String respuesta = "";
          OkHttpClient client = new OkHttpClient();

          MediaType mediaType = MediaType.parse("application/json");
          RequestBody body = RequestBody.create(mediaType,
                    "{\r\n \"uuidOportunidad\": \" " + idOportunidad
                    + " \",\r\n \"usuario\": \"user-name\",\r\n \"uuidComentario\": \"72448a94:15e7186168c:-8000\",\r\n \"fecha\": 1505143166604,\r\n \"comentario\": \" "
                    + comentario + " \"\r\n}");
          Request request = new Request.Builder()
                    .url(endPoint + "/miplataforma/bpm-oportunidad-rest/oportunidad/" + idOportunidad + "/comentario").post(body)
                    .addHeader("content-type", "application/json").addHeader("cache-control", "no-cache")
                    .addHeader("postman-token", "1dc524fd-4a94-0197-d534-51d1e469123f").addHeader("Cookie", cookies)
                    .build();
          Response response = null;

          try {
               response = client.newCall(request).execute();
          } catch (IOException e) {

               log.error("error en el cliente"+e);
          }
          try {
               respuesta = response.body().string();
               log.info("agregarComentarioOportunidad: " + respuesta);
          } catch (IOException e) {

               log.error("error en el cliente"+e);
          } finally {
               response.body().close();
          }
          return respuesta;
     }
     @Override
     public String getOportunidadIdProducto(String idOportunidad) {
          String respuestaServicio = "";
          String idProducto = "";
          OkHttpClient client = new OkHttpClient();

          Request request = new Request.Builder().url(endPoint + "/miplataforma/bpm-oportunidad-rest/oportunidad/" + idOportunidad)
                    .get().addHeader("cache-control", "no-cache")
                    .addHeader("postman-token", "27186237-1f79-ed73-737d-b8f97f293abf").addHeader("Cookie", cookies)
                    .build();
          Response response = null;
          try {
               response = client.newCall(request).execute();
          } catch (IOException e) {
               log.error("error en el cliente"+e);
          }
          try {
               respuestaServicio = response.body().string();
               ObjectMapper mapper = new ObjectMapper();
               Oportunidad oportunidad = mapper.readValue(respuestaServicio, Oportunidad.class);
               idProducto = oportunidad.getProductos().get(0).getIdProducto();
               log.info("getOportunidadIdProducto : " + idProducto);
          } catch (IOException e) {
               log.error("error en el cliente"+e);
          } finally {
               response.body().close();
          }
          return idProducto;
     }
     @Override
     public String actualizarDatosAdicionales(String idOportunidad, String idProducto) {
          String respuesta = "";

          OkHttpClient client = new OkHttpClient();

          MediaType mediaType = MediaType.parse("application/json");
          RequestBody body = RequestBody.create(mediaType,
                    "[{\r\n \"nombreClienteEmision\": \"nombreClienteEmision\",\r\n \"direccionComercialCliente\": \"direccionComercialCliente\",\r\n \"direccionPostalCliente\": {\r\n  \"ciudad\": \"ciudad\",\r\n  \"comuna\": \"comuna\",\r\n  \"departamento\": \"departamento\",\r\n  \"dirCompleta\": \"dirCompleta\",\r\n  \"direccion\": \"direccion\",\r\n  \"normalizada\": \"normalizada\",\r\n  \"numero\": \"numero\",\r\n  \"region\": \"region\",\r\n  \"correoElectronico\": \"correoElectronico@test.cl\"\r\n },\r\n \"direccionDelivery\": {\r\n  \"id\": \"id\",\r\n  \"nombre\": \"nombre\",\r\n  \"nombreConcat\": \"nombreConcat\"\r\n },\r\n \"ciudadFirma\": \"ciudadFirma\",\r\n \"fechaDocumentacion\": 1505223482196,\r\n \"beneficiarios\": [{\r\n  \"apellidoPaterno\": \"apellidoPaterno\",\r\n  \"apellidoMaterno\": \"apellidoMaterno\",\r\n  \"nombres\": \"nombres\",\r\n  \"rut\": \"rut\",\r\n  \"nroContacto\": \"nroContacto\",\r\n  \"email\": \"email\",\r\n  \"parentesco\": \"parentesco\",\r\n  \"prcBeneficio\": \"prcBeneficio\",\r\n  \"direccion\": \"direccion\",\r\n  \"comuna\": \"comuna\",\r\n  \"nombreRegion\": \"nombreRegion\"\r\n }],\r\n \"tarjetasAdicionales\": [{\r\n  \"rut\": \"rut\",\r\n  \"nombres\": \"nombres\",\r\n  \"apellidoPaterno\": \"apellidoPaterno\",\r\n  \"apellidoMaterno\": \"apellidoMaterno\",\r\n  \"fechaNacimiento\": 1505223482204,\r\n  \"nombreCompleto\": \"nombreCompleto\",\r\n  \"tipoTarjeta\": \"tipoTarjeta\"\r\n }],\r\n \"referencias\": [{\r\n  \"nombreCompleto\": \"nombreCompleto\",\r\n  \"telefono\": \"telefono\",\r\n  \"email\": \"email\",\r\n  \"parentesco\": \"parentesco\"\r\n }]\r\n}]\r\n");
          Request request = new Request.Builder()
                    .url(endPoint + "/miplataforma/bpm-oportunidad-rest/oportunidad/" + idOportunidad + "/" + idProducto
                              + "/datos-adicionales")
                    .post(body).addHeader("content-type", "application/json").addHeader("cache-control", "no-cache")
                    .addHeader("postman-token", "74940a36-7205-0217-9958-943646ef8ba4").addHeader("Cookie", cookies)
                    .build();
          Response response = null;
          try {
               response = client.newCall(request).execute();
               respuesta = response.body().string();
          } catch (IOException e) {

               log.error("error en el cliente"+e);
          } finally {
               response.body().close();
          }
          log.info("actualizarDatosAdicionales: " + respuesta);
          return respuesta;
     }
     @Override
     public String actualizarRepresentanteLegal(String idOportunidad, String userName) {
          String respuesta = "";
          OkHttpClient client = new OkHttpClient();

          MediaType mediaType = MediaType.parse("application/json");
          RequestBody body = RequestBody.create(mediaType,
                    "[{\r\n \"Rut\": \"1-2\",\r\n \"esRepresentanteLegal\": \"si\",\r\n \"esPatrocinante\": \"no\",\r\n \"nombre\": \"rep1\",\r\n \"apellidoPaterno\": \"apepat1\",\r\n \"apellidoMaterno\": \"apemat1\",\r\n \"parentesco\": \"parent1\",\r\n \"direccion\": \"dir1\",\r\n \"numero\": \"num1\",\r\n \"comuna\": \"com1\",\r\n \"telefono\": \"111 11 11\",\r\n \"email\": \"email@email1.cl\"\r\n},\r\n{\r\n \"Rut\": \"2-2\",\r\n \"esRepresentanteLegal\": \"no\",\r\n \"esPatrocinante\": \"si\",\r\n \"nombre\": \"rep2\",\r\n \"apellidoPaterno\": \"apepat2\",\r\n \"apellidoMaterno\": \"apemat2\",\r\n \"parentesco\": \"parent2\",\r\n \"direccion\": \"dir2\",\r\n \"numero\": \"num2\",\r\n \"comuna\": \"com2\",\r\n \"telefono\": \"222 22 22\",\r\n \"email\": \"email@email2.cl\"\r\n}]");
          Request request = new Request.Builder()
                    .url(endPoint + "/miplataforma/bpm-oportunidad-rest/oportunidad/" + idOportunidad + "/" + userName + "/rep-legales")
                    .post(body).addHeader("content-type", "application/json").addHeader("cache-control", "no-cache")
                    .addHeader("postman-token", "d4d09a5b-59ed-76b2-42cc-9dd760e06e4a").addHeader("Cookie", cookies)
                    .build();
          Response response = null;
          try {
               response = client.newCall(request).execute();
               respuesta = response.body().string();
          } catch (IOException e) {

               log.error("error en el cliente"+e);
          } finally {
               response.body().close();
          }
          log.info("actualizarRepresentanteLegal: " + respuesta);
          return respuesta;
     }
     @Override
     public String anulaOportunidad(String idOportunidad) {
          String respuesta = "";
          OkHttpClient client = new OkHttpClient();
          RequestBody emptyBody = RequestBody.create(null, new byte[0]);
          Request request = new Request.Builder()
                    .url(endPoint + "/miplataforma/bpm-integracion-rest/oportunidad/" + idOportunidad + "/anula").post(emptyBody)
                    .addHeader("cache-control", "no-cache")
                    .addHeader("postman-token", "7baabea6-50dc-4103-2940-45f52480cfed").addHeader("Cookie", cookies)
                    .build();
          Response response = null;
          try {
               response = client.newCall(request).execute();
               respuesta = response.body().string();
          } catch (IOException e) {

               log.error("error en el cliente"+e);
          } finally {
               response.body().close();
          }
          log.info("anulaOportunidad: " + respuesta);
          return respuesta;
     }
     @Override
     public Oportunidad getOportunidad(String idOportunidad) throws InterruptedException {
          String respuestaServicio = "";
          String idProducto = "";
          OkHttpClient client = new OkHttpClient().newBuilder().connectTimeout(300, TimeUnit.SECONDS)
                    .writeTimeout(300, TimeUnit.SECONDS)
                    .readTimeout(300, TimeUnit.SECONDS)
                    .build();
          Request request = new Request.Builder().url(endPoint + "/miplataforma/bpm-oportunidad-rest/oportunidad/" + idOportunidad)
                    .get().addHeader("cache-control", "no-cache")
                    .addHeader("postman-token", "27186237-1f79-ed73-737d-b8f97f293abf").addHeader("Cookie", cookies)
                    .build();
          Response response = null;
          Oportunidad oportunidad = new Oportunidad();
          try {
               response = client.newCall(request).execute();
          } catch (IOException e) {

               log.error("error en el cliente"+e);
          }

          try {
               respuestaServicio = response.body().string();
               log.debug("getOportunidad: "+respuestaServicio.substring(0, 50));
               ObjectMapper mapper = new ObjectMapper();
               oportunidad = mapper.readValue(respuestaServicio, Oportunidad.class);
               idProducto = oportunidad.getProductos().get(0).getIdProducto();						
               //log.info("Nombre Tarea : " + respuestaServicio);
          } catch (IOException e) {

               log.error("error en el cliente"+e);
          } finally {
               response.body().close();
          }
          return oportunidad;
     }
     @Override
     public String comprobarRespuestaServicio(String output) {
          String respuesta = "";
          RespuestaGenerica respuestaGenerica = new RespuestaGenerica();
          respuestaGenerica = parseStringRG(output);
          String volver ="";
          if(respuestaGenerica.getCodigo() == null) {
               respuestaGenerica.setCodigo("-1");
               respuestaGenerica.setMensaje("CWTBG0045E");
          }
          if ( respuestaGenerica.getCodigo().compareTo("-1") == 0) {
               log.error("Error");
               if(respuestaGenerica.getMensaje().equals("CWTBG0045E") ||
                         respuestaGenerica.getMensaje().equals("Operacion NOK: No se encontro o autorizo siguiente tarea.") ||
                         respuestaGenerica.getMensaje().contains("Error querying database")){
                    log.debug("¿Reintentar? S/N");
                    Scanner entradaEscaner = new Scanner (System.in); //Creación de un objeto Scanner
                    String entradaTeclado = entradaEscaner.nextLine (); //Invocamos un método sobre un objeto Scanner
                    if (entradaTeclado.toUpperCase().equals("S")){
                         respuesta = "reintento";   
                    }else{
                         respuesta = "terminar";
                         System.exit(0);    
                    }
               }else{
                    respuesta = "terminar";
                    System.exit(0);
               }
          }
          return respuesta;

     }

     private  IdOportunidad parseString(String json) {
          try {
               ObjectMapper mapper = new ObjectMapper();
               return mapper.readValue(json, IdOportunidad.class);
          } catch (Exception e) {
               log.error(e.getMessage());
               return null;
          }
     }
     
     private  RespuestaGenerica parseStringRG(String json) {
          try {
               ObjectMapper mapper = new ObjectMapper();
               return mapper.readValue(json, RespuestaGenerica.class);
          } catch (Exception e) {
               log.error(e.getMessage());
               return null;
          }
     }
     @Override
     public  String avanzaTarea(String idBpmProducto, String accion, String idSolicitud) {

          log.debug("url autorizacion response: "+endPoint + "/miplataforma/bpm-integracion-rest/autorizacion/response" );
          log.debug("idBpmProducto: "+idBpmProducto+" accion: "+accion+" idSolicitud: "+idSolicitud);


          String respuesta = "";
          OkHttpClient client = new OkHttpClient().newBuilder().connectTimeout(300, TimeUnit.SECONDS)
                    .writeTimeout(300, TimeUnit.SECONDS)
                    .readTimeout(300, TimeUnit.SECONDS)
                    .build();
          MediaType mediaType = MediaType.parse("application/json");
          // Simulador de respuesta desde Everis
          RequestBody body = RequestBody.create(mediaType, "{\n  \"idRespuesta\": null,\n  \"idSolicitud\": \""+idSolicitud+"\",  \"idEstado\": null,\n  \"idAccion\": \""+accion+"\",\n  \"trxIdOperacion\": \""+idBpmProducto+"\",\n  \"rutEjecutivo\": null,\n  \"rutCliente\": null,\n  \"fechaSolicitud\": null,\n  \"uriDestino\": null,\n  \"comentario\": null,\n  \"excepcion\": null,\n  \"usuarioAutorizador\": null\n}");
          Request request = new Request.Builder().url(endPoint + "/miplataforma/bpm-integracion-rest/autorizacion/response")
                    .post(body).addHeader("content-type", "application/json").addHeader("cache-control", "no-cache")
                    .addHeader("postman-token", "73e746b4-e0ab-6b51-e327-d79d095bf4da").build();
          Response response = null;
          try {

               response = client.newCall(request).execute();
               respuesta = response.body().string();
               log.info("avanzaTarea: " + respuesta);
               IRestOportunidad asd = new RestOportunidad();
               if(asd.comprobarRespuestaServicio(respuesta).equals("reintento")){
                    respuesta = "reintento";
               }			
          } catch (IOException e) {
               log.error("error en el cliente"+e);
          } finally {
               response.body().close();
          }
          return respuesta;

     }
     @Override
     public  String llamadoNumeroFolio() {
          String respuesta = "";
          OkHttpClient client = new OkHttpClient();

          MediaType mediaType = MediaType.parse("application/json");
          RequestBody body = RequestBody.create(mediaType,
                    "\n{\n\t \"usuario\": \"rsantoroo\",\n\t \"codOficina\": \"107\",\n\t \"cantCuentas\": 1,\n\t \"tipoCuenta\": \"JUV\",\n\t \"pathService\": \"/cdn-venta-productos-api/folio-service/obtenerFolios\",\n\t \"idCanal\": \"PCOMERCIAL\"\n}");
          Request request = new Request.Builder()
                    .url("http://otd-priv:20015/miplataforma/cdn-venta-productos-api/folio-service/obtenerFolios")
                    .post(body).addHeader("content-type", "application/json").addHeader("cache-control", "no-cache")
                    .addHeader("postman-token", "2d7240bd-a2c4-53f2-200b-b81196abe04b").build();
          Response response = null;
          try {
               response = client.newCall(request).execute();
               respuesta = response.body().string();

          } catch (IOException e) {
               log.error("error en el cliente"+e);
          } finally {
               response.body().close();
          }
          log.debug("llamadoNumeroFolio: " + respuesta);
          return respuesta;
     }
     @Override
     public String avanzarTareaFront(String idTarea, String accion) {
          String respuesta = "";
          OkHttpClient client = new OkHttpClient().newBuilder().connectTimeout(300, TimeUnit.SECONDS)
                    .writeTimeout(300, TimeUnit.SECONDS)
                    .readTimeout(300, TimeUnit.SECONDS)
                    .build();
          RequestBody emptyBody = RequestBody.create(null, new byte[0]);
          Request request = new Request.Builder()
                    .url(endPoint + "/miplataforma/bpm-integracion-rest/avanzaTarea/" + idTarea + "/decision/decision/" + accion)
                    .post(emptyBody).addHeader("cache-control", "no-cache")
                    .addHeader("postman-token", "2b891811-d3d4-6615-6fd0-aade18f12ff6").build();
          Response response = null;
          try {
               response = client.newCall(request).execute();
               respuesta = response.body().string();
               log.info("avanzarTareaFront: " + respuesta);
               IRestOportunidad respOp = new RestOportunidad();
               if(respOp.comprobarRespuestaServicio(respuesta).equals("reintento")){
                    respuesta = "reintento";
               }
          } catch (IOException e) {
               log.error("error en el cliente"+e);
          } finally {
               response.body().close();
          }
          return respuesta;

     }
     @Override
     public  String iniciarProceso(String idOportunidad) {
          String respuesta = "";
          String direc = endPoint + "/miplataforma/bpm-integracion-rest/iniciarProceso/" + idOportunidad;
          URL url = null;
          try {
               url = new URL(direc);
          } catch (MalformedURLException e) {

               log.error("error en el cliente"+e);
          }
          HttpURLConnection conn = null;
          try {
               conn = (HttpURLConnection) url.openConnection();
          } catch (IOException e1) {

               e1.printStackTrace();
          }
          try {
               conn.setRequestMethod("POST");
          } catch (ProtocolException e) {

               log.error("error en el cliente"+e);
          }
          conn.setRequestProperty("Accept", "application/json");
          try {
               log.info(conn.getResponseCode());
          } catch (IOException e) {

               log.error("error en el cliente"+e);
          }
          BufferedReader br = null;
          try {
               br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
          } catch (IOException e) {
               log.error("error en el cliente"+e);
          }

          String output = null;
          log.info("iniciarProceso: "+direc);
          log.info("Output from Server .... \n");
          try {
               while ((output = br.readLine()) != null) {
                    log.info(output);
                    IRestOportunidad respOp = new RestOportunidad();
                    //comprobarRespuestaServicio(output);
                    if (respOp.comprobarRespuestaServicio(output).equals("reintento")) {
                         iniciarProceso(idOportunidad);
                    }

               }
          } catch (IOException e) {

               log.error("error en el cliente"+e);
          }
          return output;
     }
     @Override
     public  String anularOportunidad(String direccion,String idOportunidad,String usuario, String rut){
          direccion=direccion.replace("{uuid}", idOportunidad);
          direccion=direccion.replace("{nombre}", usuario);
          direccion=direccion.replace("{rut}", rut);
          return consumirRest3(endPoint+direccion,"POST",null);
     }
     @Override
     public  String eliminarProductos(String direccion,String jsonProductos,String usuario, String rut) {		
          direccion=direccion.replace("{nombre}", usuario);
          direccion=direccion.replace("{rut}", rut);
          return consumirRest3(endPoint+direccion,"POST",jsonProductos);
     }


     @Override
     public  String consumirRest3(String direccion, String metodo, String json) {
          // log.info("Ejecutando: "+direccion);
          String respuesta = "";
          OkHttpClient client = new OkHttpClient().newBuilder().connectTimeout(300, TimeUnit.SECONDS)
                    .writeTimeout(300, TimeUnit.SECONDS)
                    .readTimeout(300, TimeUnit.SECONDS)
                    .build();

          MediaType mediaType = MediaType.parse("application/json");
          Request request = null;
          if (metodo.toUpperCase().equals("POST")) {	     
               RequestBody body = (json != null) ?
                         RequestBody.create(mediaType, json) : RequestBody.create(null, new byte[0]);			
                         request = new Request.Builder().url(direccion).post(body).addHeader("content-type", "application/json")
                                   .addHeader("cache-control", "no-cache")
                                   .addHeader("postman-token", "7934f8b7-4bbd-c511-b561-bca017183088").addHeader("Cookie", cookies)
                                   .addHeader("bpm_user", "bpmadmin")
                                   .addHeader("bpm_passwd", "bpmadmin")
                                   .build();
          } else {
               request = new Request.Builder().url(direccion).get().addHeader("content-type", "application/json")
                         .addHeader("cache-control", "no-cache")
                         .addHeader("postman-token", "7934f8b7-4bbd-c511-b561-bca017183088").addHeader("Cookie", cookies)
                         .build();
          }
          Response response = null;
          try {
               response = client.newCall(request).execute();
          } catch (IOException e) {

               log.error("error en el cliente"+e);
          }
          try {
               respuesta = response.body().string();
               log.info(direccion + " \n " + respuesta);
          } catch (IOException e) {

               log.error("error en el cliente"+e);
          } finally {
               response.body().close();
          }
          return respuesta;
     }
     @Override
     public  String logOportunidad(String idOportunidad) {
          String respuesta = "";
          OkHttpClient client = new OkHttpClient().newBuilder().connectTimeout(300, TimeUnit.SECONDS)
                    .writeTimeout(300, TimeUnit.SECONDS)
                    .readTimeout(300, TimeUnit.SECONDS)
                    .build();

          Request request = new Request.Builder()
                    // .url("http://portalcomercial.qa.labchile.cl:8888/miplataforma/bpm-oportunidad-rest/oportunidad/log/CDN20171018045732293PLAT530181")
                    .url(endPoint + "/miplataforma/bpm-integracion-rest/oportunidad/log/" + idOportunidad).get()
                    .addHeader("cookie", cookies).addHeader("cache-control", "no-cache")
                    .addHeader("postman-token", "32ced730-fec8-6144-1dc1-8676ce2f23e2").build();

          try {
               Response response = client.newCall(request).execute();
               respuesta = response.body().string();
          } catch (IOException e) {
               log.error("error en el cliente"+e);
          }
          //log.info("logOportunidad: " + respuesta);
          return respuesta;
     }
     @Override
     public  String mensajeIMQA(String set_id,String bpm_id,String estado) throws IOException{
          log.debug("set_id: "+set_id+" bpm_id: "+bpm_id+" estado: "+estado);
          OkHttpClient client = new OkHttpClient();
          MediaType mediaType = MediaType.parse("application/json");// "{\n   \"set_id\": \"0\",\n   \"bpm_id\": \"55445\",\n   \"estado\": \"en proceso\",\n   \"mensaje\": [{\n       \"valor\": \"valor\"\n   }]\n}"
          RequestBody body = RequestBody.create(mediaType, "{\n   \"set_id\": \""+set_id+"\",\n   \"bpm_id\": \""+bpm_id+"\",\n   \"estado\": \""+estado+"\",\n   \"mensaje\": [{\"operation\":\"objection\",\"success\":true,\"action\":\"show\",\"errorMessage\":null,\"objectResponse\":[{\"setId\":7529,\"ruleId\":21,\"productId\":103,\"productName\":\"CUENTA VISTA\",\"docTypeId\":53,\"docTypeName\":\"FOTOCOPIA CÉDULA DE IDENTIDAD DE CLIENTE\",\"errorTypeId\":1466,\"errorTypeName\":\"Falta Adjuntar Fotocopia de Cédula de Identidad del Cliente.\"},{\"setId\":7529,\"ruleId\":21,\"productId\":103,\"productName\":\"CUENTA VISTA\",\"docTypeId\":130,\"docTypeName\":\"CONTRATO ÚNICO DE CUENTA VISTA\",\"errorTypeId\":1471,\"errorTypeName\":\"Falta Firma del Cliente en el Contrato Único de Cuenta Vista\"},{\"setId\":7529,\"ruleId\":22,\"productId\":103,\"productName\":\"CUENTA VISTA\",\"docTypeId\":130,\"docTypeName\":\"CONTRATO ÚNICO DE CUENTA VISTA\",\"errorTypeId\":1470,\"errorTypeName\":\"Falta Firma del Ejecutivo en el Contrato Único de Cuenta Vista\"},{\"setId\":7529,\"ruleId\":23,\"productId\":103,\"productName\":\"CUENTA VISTA\",\"docTypeId\":131,\"docTypeName\":\"SOLICITUD ÚNICA DE CUENTA VISTA\",\"errorTypeId\":1476,\"errorTypeName\":\"Falta Firma del Representante Legal en la Solicitud Única de Cuenta Vista\"},{\"setId\":7529,\"ruleId\":24,\"productId\":103,\"productName\":\"CUENTA VISTA\",\"docTypeId\":131,\"docTypeName\":\"SOLICITUD ÚNICA DE CUENTA VISTA\",\"errorTypeId\":1475,\"errorTypeName\":\"Falta Firma del ejecutivo en la Solicitud Única de Cuenta Vista\"},{\"setId\":7529,\"ruleId\":21,\"productId\":103,\"productName\":\"CUENTA VISTA\",\"docTypeId\":131,\"docTypeName\":\"SOLICITUD ÚNICA DE CUENTA VISTA\",\"errorTypeId\":1473,\"errorTypeName\":\"Falta Firma del Cliente en la Solicitud Única de Cuenta Vista\"},{\"setId\":7529,\"ruleId\":21,\"productId\":103,\"productName\":\"CUENTA VISTA\",\"docTypeId\":112,\"docTypeName\":\"INFORMACIÓN AL USUARIO PARA EL MANEJO Y UTILIZACIÓN DE TARJETAS BANCARIAS\",\"errorTypeId\":1467,\"errorTypeName\":\"Falta Firma del Cliente en Información usuario para el manejo de Tarjetas Bancarias\"},{\"setId\":7529,\"ruleId\":21,\"productId\":103,\"productName\":\"CUENTA VISTA\",\"docTypeId\":132,\"docTypeName\":\"HOJA RESUMEN CUENTA VISTA – CUENTA DIRECTA\",\"errorTypeId\":1483,\"errorTypeName\":\"Falta Firma del Cliente en Hoja Resumen - Cuenta Directa\"},{\"setId\":7529,\"ruleId\":22,\"productId\":103,\"productName\":\"CUENTA VISTA\",\"docTypeId\":132,\"docTypeName\":\"HOJA RESUMEN CUENTA VISTA – CUENTA DIRECTA\",\"errorTypeId\":1482,\"errorTypeName\":\"Falta Firma del Ejecutivo en Hoja Resumen - Cuenta Directa\"},{\"setId\":7529,\"ruleId\":21,\"productId\":103,\"productName\":\"CUENTA VISTA\",\"docTypeId\":137,\"docTypeName\":\"DECLARACIÓN JURADA 2\",\"errorTypeId\":1494,\"errorTypeName\":\"Falta Firma del Representante Legal en la Declaración Jurada\"}],\"listPages\":[{\"id\":45359,\"setId\":7529,\"docTypeId\":1000,\"statusId\":3,\"name\":\"002C5D09.pdf\",\"pageNumber\":1,\"batchId\":271040,\"orderType\":0,\"objectId\":\"idd_DFE8F643-869B-48CA-9A66-AE404EF525B2\"},{\"id\":45375,\"setId\":7529,\"docTypeId\":53,\"statusId\":10,\"name\":\"002C5D33.pdf\",\"pageNumber\":1,\"batchId\":271040,\"orderType\":1,\"objectId\":\"idd_7A7E517D-BD1B-4953-B6E4-46A4E3452835\"},{\"id\":45367,\"setId\":7529,\"docTypeId\":112,\"statusId\":3,\"name\":\"002C5D11.pdf\",\"pageNumber\":1,\"batchId\":271040,\"orderType\":1,\"objectId\":\"idd_43302028-114A-4E22-9D07-4EFC732D54B0\"},{\"id\":45368,\"setId\":7529,\"docTypeId\":112,\"statusId\":10,\"name\":\"002C5D12.pdf\",\"pageNumber\":2,\"batchId\":271040,\"orderType\":1,\"objectId\":\"idd_489284E4-9DCA-4AA7-ABF3-638966270EA0\"},{\"id\":45361,\"setId\":7529,\"docTypeId\":130,\"statusId\":10,\"name\":\"002C5D0B.pdf\",\"pageNumber\":11,\"batchId\":271040,\"orderType\":1,\"objectId\":\"idd_946293C3-3E0B-4DF1-A656-17F2BD414587\"},{\"id\":45363,\"setId\":7529,\"docTypeId\":131,\"statusId\":3,\"name\":\"002C5D0D.pdf\",\"pageNumber\":1,\"batchId\":271040,\"orderType\":1,\"objectId\":\"idd_824B2B5A-8738-4ECA-A072-4DC008949111\"},{\"id\":45364,\"setId\":7529,\"docTypeId\":131,\"statusId\":3,\"name\":\"002C5D0E.pdf\",\"pageNumber\":2,\"batchId\":271040,\"orderType\":1,\"objectId\":\"idd_1002C770-FF3A-4CD6-992E-877D8B401BCC\"},{\"id\":45365,\"setId\":7529,\"docTypeId\":131,\"statusId\":10,\"name\":\"002C5D0F.pdf\",\"pageNumber\":3,\"batchId\":271040,\"orderType\":1,\"objectId\":\"idd_F1111E66-FD36-4E11-952A-7F817C655CDF\"},{\"id\":45366,\"setId\":7529,\"docTypeId\":131,\"statusId\":10,\"name\":\"002C5D10.pdf\",\"pageNumber\":4,\"batchId\":271040,\"orderType\":1,\"objectId\":\"idd_98167E25-C6FB-4E4C-A04B-4D5743C52A12\"},{\"id\":45369,\"setId\":7529,\"docTypeId\":132,\"statusId\":10,\"name\":\"002C5D13.pdf\",\"pageNumber\":1,\"batchId\":271040,\"orderType\":1,\"objectId\":\"idd_12F3626E-4EE0-4810-8F70-04EC1FC9BCBC\"},{\"id\":45373,\"setId\":7529,\"docTypeId\":137,\"statusId\":10,\"name\":\"002C5D27.pdf\",\"pageNumber\":1,\"batchId\":271040,\"orderType\":1,\"objectId\":\"idd_28D68054-F40C-438F-B579-C2E68FECA1B4\"},{\"id\":45360,\"setId\":7529,\"docTypeId\":1001,\"statusId\":3,\"name\":\"002C5D0A.pdf\",\"pageNumber\":1,\"batchId\":271040,\"orderType\":3,\"objectId\":\"idd_D191159F-B057-4BCA-BBA2-C491FF91FB87\"},{\"id\":45362,\"setId\":7529,\"docTypeId\":1001,\"statusId\":3,\"name\":\"002C5D0C.pdf\",\"pageNumber\":1,\"batchId\":271040,\"orderType\":3,\"objectId\":\"idd_FE1F4E43-B874-47D7-A787-9B2F13BB8F87\"},{\"id\":45370,\"setId\":7529,\"docTypeId\":1001,\"statusId\":3,\"name\":\"002C5D16.pdf\",\"pageNumber\":1,\"batchId\":271040,\"orderType\":3,\"objectId\":\"idd_E9053671-83C8-4B91-87DD-3ADFA7EA03E9\"},{\"id\":45371,\"setId\":7529,\"docTypeId\":1001,\"statusId\":3,\"name\":\"002C5D1A.pdf\",\"pageNumber\":1,\"batchId\":271040,\"orderType\":3,\"objectId\":\"idd_68E3C1A7-5F17-4CC4-89D4-07D1E4AB73FC\"},{\"id\":45372,\"setId\":7529,\"docTypeId\":1001,\"statusId\":3,\"name\":\"002C5D1F.pdf\",\"pageNumber\":1,\"batchId\":271040,\"orderType\":3,\"objectId\":\"idd_296A374C-BAF4-4C13-AF2E-266848199C48\"},{\"id\":45374,\"setId\":7529,\"docTypeId\":1001,\"statusId\":3,\"name\":\"002C5D2E.pdf\",\"pageNumber\":1,\"batchId\":271040,\"orderType\":3,\"objectId\":\"idd_957F6FF9-49CD-497F-B0D7-F6E62A8C0F92\"},{\"id\":45376,\"setId\":7529,\"docTypeId\":1001,\"statusId\":3,\"name\":\"002C5D34.pdf\",\"pageNumber\":1,\"batchId\":271040,\"orderType\":3,\"objectId\":\"idd_C205311E-3EA5-41D6-85A7-821522EFAAFB\"}]}]\n}");
          Request request = new Request.Builder()
                    .url(endPoint + "/miplataforma/bpm-previsado-rest/previsado/actualizaestadoim")
                    .post(body)
                    .addHeader("content-type", "application/json")
                    .addHeader("cache-control", "no-cache")
                    .addHeader("postman-token", "f6511507-d760-e4d0-7f1e-a82b08092c03")
                    .build();

          Response response = client.newCall(request).execute();
          return response.body().string();
     }
     @Override
     public  String avanzarTareasAgrupadas(String idSolicitud,String trxIdOperacion,String estado) throws IOException{

          OkHttpClient client = new OkHttpClient();

          MediaType mediaType = MediaType.parse("application/json");
          RequestBody body = RequestBody.create(mediaType, "{\"idRespuesta\":11,\n\"idSolicitud\":\""+idSolicitud+"\",\n\"idEstado\":7,\n\"idAccion\":5,\n\"trxIdOperacion\":\""+trxIdOperacion+"\", \n\"rutEjecutivo\":\"1-9\",\n\"rutCliente\":\"1-9\",\n\"fechaSolicitud\":\"2017-08-29T17:35:41\",\n\"uriDestino\":\"http://localhost:8082/solicitud/\",\n\"comentario\":\"algun comentario\",\n\"excepcion\":\"algun problema\",\n\"usuarioAutorizador\":\"autorizador\"\n}");
          Request request = new Request.Builder()
                    .url(endPoint + "/miplataforma/bpm-integracion-rest/avanzar-tareas-agrupadas")
                    .post(body)
                    .addHeader("content-type", "application/json")
                    .addHeader("cache-control", "no-cache")
                    .addHeader("postman-token", "b2ffe604-f667-a972-8f18-6e5a8f1830d0")
                    .build();

          Response response = client.newCall(request).execute();

          log.info(endPoint + "/miplataforma/bpm-integracion-rest/avanzar-tareas-agrupadas" + " \n " + response);
          return response.body().string();
     }
     @Override
     public  String selectIdSolicitud(String idBpm) throws Exception {
          DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
          Connection c = null;
          if ("DESA".equals(ambiente)){

               c = DriverManager.getConnection(
                         "jdbc:oracle:thin:@200.14.166.106:1521:ORION", "VENTA_CN", "VENTA_CN");
          }else{  //durbaneja/Team_IBM_S36  200.14.169.236
               c = DriverManager.getConnection(
                         "jdbc:oracle:thin:@200.14.169.236:1521:ORION", "durbaneja", "Team_IBM_S36");
          }

          Statement stmt = c.createStatement();
          ResultSet rs = stmt.executeQuery(
                    "SELECT tk.ID_AUTORIZACION FROM bpm_operaciones op,"
                              + " bpm_tareas tk WHERE op.ID_TAREA_ACTUAL = tk.ID_TAREA AND op.id_bpm='"+idBpm+"'");
          rs.next();
          String idAutorizacion = rs.getString("ID_AUTORIZACION");
          log.info("ID_AUTORIZACION: "+idAutorizacion);
          rs.close();
          stmt.close();
          c.close();
          return idAutorizacion;
     }

}
