package cl.bancochile.automatizador.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cl.bancochile.automatizador.rest.RestOportunidad;

@SuppressWarnings({ "unchecked", "rawtypes", "unused" })
public final class JsonUtils {
     private final static Logger log = Logger.getLogger(JsonUtils.class);
	private static final String PREFIJO_PLATAFORMABASE = "PLAT";

	public JsonUtils() {
	}

	public static JsonUtils jsonUtilsGetClass() {
		return new JsonUtils();
	}

	public static byte[] transformToJsonByte(final Object obj) {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			return mapper.writeValueAsBytes(obj);
		} catch (Exception e) {
			log.error(e.getMessage());

		}
		return new byte[0];
	}

	public static String transformToJsonString(final Object obj) {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			return mapper.writeValueAsString(obj);
		} catch (Exception e) {
			log.error(e.getMessage());

		}
		return null;
	}

	public static Object parseString(String json) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			return mapper.readValue(json, Object.class);
		} catch (Exception e) {
			log.error(e.getMessage());
			return null;
		}
	}

	public static String uuidGenerator() {
		return getId("CDN");
	}

	public static String getId(String code) {
		if (code == null || code.length() != 3) {
			throw new IllegalArgumentException("Se debe especificar un código de largo tres");
		} else {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddhhmmssSSS");
			int random = ThreadLocalRandom.current().nextInt(1, 1000000);
			return (new StringBuilder()).append(code.toUpperCase()).append(simpleDateFormat.format(new Date()))
					.append(PREFIJO_PLATAFORMABASE).append(String.format("%05d", Integer.valueOf(random))).toString();
		}
	}

	public static boolean isJSONValid(String jsonInString) {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			mapper.readTree(jsonInString);
			return true;
		} catch (Exception e) {
			log.error(e.getMessage());
			return false;
		}
	}

	public static byte[] ObjectToJson(final Object obj) {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			// mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
			final byte[] jsonContent = mapper.writeValueAsBytes(obj);
			// log.info(new String(jsonContent,
			// StandardCharsets.UTF_8));
			return jsonContent;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static String ObjectToJsonString(final Object obj) {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			// mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
			final byte[] jsonContent = mapper.writeValueAsBytes(obj);
			return (new String(jsonContent, StandardCharsets.UTF_8));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static Object parseStringObj(String json, Class obj) {
		try {

			ObjectMapper mapper = new ObjectMapper();
			return mapper.readValue(json, obj);
		} catch (Exception e) {
			log.error(e.getMessage());
			System.exit(0);
			return null;
		}
	}

	public List tomarKeyJson(String jsonString, String nombrekey) throws JSONException {
		List responseLog = new ArrayList<String>();
		String valorAux = "";
		JSONArray jsonArray = new JSONArray(jsonString);
		int elemento = 0;
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject object = jsonArray.getJSONObject(i);

			valorAux = object.getString(nombrekey);
			char primerElemento = valorAux.charAt(0);
			if (primerElemento == '[') {
				responseLog.add(valorAux);
				//log.info("tomarKeyJson: " + responseLog.get(elemento));
				elemento++;
			}
		}
		return responseLog;
	}

	public String entregaKeyJson(String jsonString, String nombrekey) throws JSONException {
		List responseLog = new ArrayList<String>();
		String valueJson = "";
		JSONArray jsonArray = new JSONArray(jsonString);
		int elemento = 0;
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject object = jsonArray.getJSONObject(i);
			valueJson = object.getString(nombrekey);
		}
		return valueJson;
	}
	public static  Properties leerArchivo(String archivo) {
         Properties propiedades = new Properties();
         try {

              /* Creamos un Objeto de tipo Properties */

              log.info(System.getProperty("user.dir"));
              /* Cargamos el archivo desde la ruta especificada */
              File file = new File(archivo);
              propiedades.load(new FileInputStream(file));

         } catch (FileNotFoundException e) {
              log.error("Error, El archivo no existe" + e);
         } catch (IOException e) {
              log.error("Error, No se puede leer el archivo" + e);
         }
         return propiedades;
    }
	public static String jsonProperties(String archivo, String property){
	     Properties propiedades = leerArchivo(archivo);
	     return propiedades.get(property).toString();
	    
	}
	
}