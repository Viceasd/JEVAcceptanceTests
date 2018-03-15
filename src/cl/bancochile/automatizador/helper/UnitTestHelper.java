package cl.bancochile.automatizador.helper;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.map.ObjectMapper;

import cl.bancochile.automatizador.model.ComentarioOportunidad;
import cl.bancochile.automatizador.model.Comentarios;
import cl.bancochile.automatizador.model.Documento;
import cl.bancochile.automatizador.model.Oportunidad;
import cl.bancochile.automatizador.model.Producto;

public final class UnitTestHelper {

	private static final int LENGTH_REPEAT = 100000;
	private static final String CHAR_REPEAT = "#";
	private static final String FAIL_STR = StringUtils.repeat(CHAR_REPEAT, LENGTH_REPEAT);

	public static final String GOOD_UUID_OPORTUNIDAD = "4a493bfa_15eb977ae8a_-7ffd";
	public static final String GOOD_UUID_PRODUCTO = "-229ed9f6_15eb978ad97_-7fff";
	public static final String GOOD_UUID_TAREA = "111111";
	public static final String GOOD_RUT_CLIENTE = "2-7";
	public static final String GOOD_RUT_EJECUTIVO = "123123";
	public static final String GOOD_USER = "pcalderon";
	public static final String GOOD_CANAL = "PCOMERCIAL";
	public static final String GOOD_OFICINA = "oficina";
	public static final String GOOD_ESTADO = "ACTIVA";
	public static final String GOOD_FECHA = "22-09-1900";
	public static final String GOOD_UUID_LOG_OPORTUNIDAD_JSON = "4f80fa19_15eaaef1423_-7b61";
	public static final String GOOD_UUID_LOG_OPORTUNIDAD_XML = "CDN20170929054803813PLAT344829";
	public static final String BAD_UUID_OPORTUNIDAD = "0000";
	public static final String BAD_UUID_PRODUCTO = "0000";
	public static final String BAD_UUID_TAREA = "0000";
	public static final String BAD_RUT_CLIENTE = "0000";
	public static final String BAD_RUT_EJECUTIVO = "0000";
	public static final String BAD_USER = "0000";
	public static final String BAD_CANAL = "0000";
	public static final String BAD_OFIFINA = "0000";
	public static final String BAD_ESTADO = "0000";
	public static final String BAD_FECHA = "31-12-10000";
	public static final String FAIL_UUID_OPORTUNIDAD = FAIL_STR;
	public static final String FAIL_UUID_PRODUCTO = FAIL_STR;
	public static final String FAIL_UUID_TAREA = FAIL_STR;
	public static final String FAIL_RUT_CLIENTE = FAIL_STR;
	public static final String FAIL_RUT_EJECUTIVO = FAIL_STR;
	public static final String FAIL_USER = FAIL_STR;
	public static final String FAIL_CANAL = FAIL_STR;
	public static final String FAIL_OFICINA = FAIL_STR;
	public static final String FAIL_ESTADO = FAIL_STR;
	public static final String FAIL_FECHA = FAIL_STR;
	public static final String NULL_UUID_OPORTUNIDAD = null;
	public static final String NULL_UUID_PRODUCTO = null;
	public static final String NULL_UUID_TAREA = null;
	public static final String NULL_RUT_CLIENTE = null;
	public static final String NULL_RUT_EJECUTIVO = null;
	public static final String NULL_USER = null;
	public static final String NULL_CANAL = null;
	public static final String NULL_OFICINA = null;
	public static final String NULL_ESTADO = null;
	public static final String NULL_FECHA = null;
	public static final String EMPTY_UUID_OPORTUNIDAD = "";
	public static final String EMPTY_UUID_PRODUCTO = "";
	public static final String EMPTY_UUID_TAREA = "";
	public static final String EMPTY_RUT_CLIENTE = "";
	public static final String EMPTY_RUT_EJECUTIVO = "";
	public static final String EMPTY_USER = "";
	public static final String EMPTY_CANAL = "";
	public static final String EMPTY_OFICINA = "";
	public static final String EMPTY_ESTADO = "";
	public static final String EMPTY_FECHA = "";

	private UnitTestHelper() {
	}

	@SuppressWarnings({ "unchecked", "unused" })
	private static Object agregarFamilia(Object objectJson, String idFamilia, String nombreFamilia) {
		List<Object> objetos = new ArrayList<Object>();
		objetos = (List<Object>) objectJson;
		objetos.add(
				"{\"idAtributo\": \"0\",\"nombre\": \"idFamilia\",\"valor\": \"" + idFamilia + "\",\"entrada\": null}");
		objetos.add("{\"idAtributo\": \"0\",\"nombre\": \"nombreFamilia\",\"valor\": \"" + nombreFamilia
				+ "\",\"entrada\": null}");
		return objectJson;
	}

	public static Date stringToDate(String date) throws Exception {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		String dateInString = date;
		return formatter.parse(dateInString);
	}

	public static String crearScoring() {
		return "{\"scoring\":\"NA\",\"parametros\":\"NA\",\"politicaRiesgo\":\"NA\",\"politicaProducto\":\"S\",\"pautaEvaluacion\":\"000 - No Aplica\",\"totalEvaluacion\":\"123\",\"montoMaximo\":\"123\",\"coutaMaximo\":\"123\",\"consumo\":\"0\",\"rotativo\":\"123\",\"nivelAtribuciones\":\"0\",\"nivelRiesgo\":\"0\",\"tipoVenta\":\"123\"}";
	}

	public static String crearOrigen() {
		return "{\"canal\": \"canal\",\"oficina\": \"oficina\",\"usuario\": \"usuario\",\"ip\": \"ip\",\"fecha\": \"fecha\",\"aplicacion\": \"aplicacion\"}";
	}

	public static String crearRepresentantesLegales() {
		return "[{\"Rut\": \"1-2\",\"esRepresentanteLegal\": \"si\",\"esPatrocinante\": \"no\",\"nombre\": \"rep1\",\"apellidoPaterno\": \"apepat1\",\"apellidoMaterno\": \"apemat1\",\"parentesco\": \"parent1\",\"direccion\": \"dir1\",\"numero\": \"num1\",\"comuna\": \"com1\",\"telefono\": \"111 11 11\",\"email\": \"email@email1.cl\"},{\"Rut\": \"2-2\",\"esRepresentanteLegal\": \"no\",\"esPatrocinante\": \"si\",\"nombre\": \"rep2\",\"apellidoPaterno\": \"apepat2\",\"apellidoMaterno\": \"apemat2\",\"parentesco\": \"parent2\",\"direccion\": \"dir2\",\"numero\": \"num2\",\"comuna\": \"com2\",\"telefono\": \"222 22 22\",\"email\": \"email@email2.cl\"}]";
	}

	public static String crearDatosAdicionales() {
		return "[{\"nombreClienteEmision\":\"nombreClienteEmision\",\"direccionComercialCliente\":\"direccionComercialCliente\",\"direccionPostalCliente\":{\"ciudad\":\"ciudad\",\"comuna\":\"comuna\",\"departamento\":\"departamento\",\"dirCompleta\":\"dirCompleta\",\"direccion\":\"direccion\",\"normalizada\":\"normalizada\",\"numero\":\"numero\",\"region\":\"region\",\"correoElectronico\":\"correo@mail.cl\"},\"direccionDelivery\":{\"id\":\"id\",\"nombre\":\"nombre\",\"nombreConcat\":\"nombreConcat\"},\"ciudadFirma\":\"ciudadFirma\",\"fechaDocumentacion\":1504184560294,\"beneficiarios\":[{\"apellidoPaterno\":\"apellidoPaterno\",\"apellidoMaterno\":\"apellidoMaterno\",\"nombres\":\"nombres\",\"rut\":\"rut\",\"nroContacto\":\"nroContacto\",\"email\":\"email\",\"parentesco\":\"parentesco\",\"prcBeneficio\":\"prcBeneficio\",\"direccion\":null,\"comuna\":null,\"nombreRegion\":null}],\"tarjetasAdicionales\":[{\"rut\":\"rut\",\"nombres\":\"nombres\",\"apellidoPaterno\":\"apellidoPaterno\",\"apellidoMaterno\":\"apellidoMaterno\",\"fechaNacimiento\":1504184560294,\"nombreCompleto\":null,\"tipoTarjeta\":\"tipoTarjeta\"}],\"referencias\":[{\"nombreCompleto\":\"nombreCompleto\",\"telefono\":\"telefono\",\"email\":\"email\",\"parentesco\":\"parentesco\"}]}]";
	}

	public static String crearComentarioTarea() {
		return "{ \"comentario\": \"comentario\", \"usuario\": \"usuario\", \"fecha\": null, \"motivo\": \"motivo comentario\" }";
	}

	public static Producto parseaProducto(String uuid) throws Exception {
		String json = "{\"idProducto\": 241,\"nombre\": \"Cuenta Vista Directa BEC\",\"descripcion\": \"Cuenta Vista Directa BEC\",\"estado\": \"0\",\"idFamilia\": 43,\"fechaCreacion\":0,\"atributos\": [{  \"idAtributo\": 2621, \"nombre\": \"Codigo Plastico\",    \"valor\": \"491\"},{   \"idAtributo\": 2622, \"nombre\": \"Grafica\",    \"valor\": \"496\"},{   \"idAtributo\": 2624, \"nombre\": \"Dia Emision Cartola\",    \"valor\": \"504\"},{   \"idAtributo\": 2625, \"nombre\": \"Moneda\", \"valor\": \"506\"},{   \"idAtributo\": 2626, \"nombre\": \"Caracteristica\", \"valor\": \"480\"},{   \"idAtributo\": 2627, \"nombre\": \"Tipo de Cuenta\", \"valor\": \"471\"},{   \"idAtributo\": 2628, \"nombre\": \"Modalidad\",  \"valor\": \"472\"},{   \"idAtributo\": 2629, \"nombre\": \"Envío de Cartola\",   \"valor\": 484},{ \"idAtributo\": 2631, \"nombre\": \"Frecuencia Emision Cartola\", \"valor\": 488},{ \"idAtributo\": 2632, \"nombre\": \"Codigo Prod Comercial\",  \"valor\": \"497\"},{\"idAtributo\": 2633,\"nombre\": \"Token\",\"valor\": \"JUV\"},{\"idAtributo\": 2623,\"nombre\": \"Venta a menores de edad\",\"valor\": \"true\"},{\"idAtributo\": 2630,\"nombre\": \"Abono de Remuneraciones\",\"valor\": null},{\"idAtributo\": 2634,\"nombre\": \"Permite Finalizar\",\"valor\": \"false\"}]}";
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(json, Producto.class);
	}

	public static Producto crearProducto(String uuidOportunidad) {
		Producto producto = new Producto();
		Object atributos = parseString(
				"[{\"idAtributo\": \"2621\",\"nombre\": \"Codigo Plastico\",\"valor\": \"491\",\"entrada\": null},{\"idAtributo\": \"2622\",\"nombre\": \"Grafica\",\"valor\": \"496\",\"entrada\": null}]");
		producto.setAtributos(atributos);
		producto.setDescripcion("descripcion");
		producto.setEstado("estado");
		producto.setIdBPMProducto("123123123123");
		producto.setIdProducto(cl.bancochile.automatizador.util.JsonUtils.uuidGenerator());
		producto.setNombre("nombre");
		producto.setNroFolio("nroFolio");
		producto.setPrevisado(Boolean.TRUE);
		producto.setFechaCreacion(new Date());
		producto.setIdOportunidad(uuidOportunidad);
		producto.setIdFamilia(123);
		producto.setNombreFamilia("este es el nombre");
		return producto;
	}

	public static Comentarios crearComentario() {
		Comentarios comentario = new Comentarios();
		comentario.setComentario("comentario");
		comentario.setFecha(new Timestamp(System.currentTimeMillis()));
		comentario.setUsuario("usuario");
		comentario.setMotivo("motivo comentario oportunidad");
		return comentario;
	}

	public static Oportunidad creaOportunidad() {
		Oportunidad oportunidad = new Oportunidad();

		// ID Oportunidad
		String uuidOportunidad = cl.bancochile.automatizador.util.JsonUtils.uuidGenerator();
		// JSON values
		oportunidad.setCliente(parseString(
				"{\"apellidoPaterno\": \"apepat\",\"apellidoMaterno\": \"apemat\",\"nombres\": \"nomcli\",\"rut\": \"2-7\",\"marca\": {\"id\": \"1\",\"nombre\": \"nombreMarca\"},\"segmento\": {\"id\": 1,\"nombre\": \"nombreSegmento\"}}"));
		oportunidad.setAgente(parseString(
				"{\"rut\":\"2-7\",\"usuario\":\"a_gente\",\"nombre\":\"agente smith\",\"numeroEmpleado\":\"87364\"}"));
		oportunidad.setEjecutivo(parseString(
				"{\"rut\": \"123123\",\"usuario\": \"pcalderon\",\"nombre\": \"nomejec\",\"numeroEmpleado\": \"123\",\"marca\": {\"id\": \"1\",\"nombre\": \"nombreMarca\"}}"));
		oportunidad.setCanal(parseString("{\"id\": \"1\",\"nombre\": \"nombre_id\"}"));

		oportunidad.setEvaluacion(parseString(
				"{\"scoring\": \"NA\",\"parametros\": \"NA\",\"politicaRiesgo\": \"NA\",\"politicaProducto\": \"S\",\"pautaEvaluacion\": \"000 - No Aplica\",\"totalEvaluacion\": \"123\",\"montoMaximo\": \"123\",\"coutaMaximo\": \"123\",\"consumo\": \"0\",\"rotativo\": \"123\",\"nivelAtribuciones\": \"0\",\"nivelRiesgo\": \"0\",\"tipoVenta\": \"123\"}"));

		oportunidad.setAprobacionSolicitada(0);
		List<ComentarioOportunidad> comentarios = new ArrayList<ComentarioOportunidad>();
		comentarios.add(crearComentarioOportunidad(uuidOportunidad));
		oportunidad.setComentarios(comentarios);
		oportunidad.setDatosAdicionales(crearDatosAdicionales());
		List<Documento> documentos = new ArrayList<Documento>();
		Documento documento = new Documento();
		documento.setFechaExpiracion(new Date());
		documento.setFechaIngreso(new Date());
		documento.setIdDocumento("doc1");
		documento.setNombre("nombre_doc");
		documento.setTipoDirectorio("tipo_doc");
		documento.setTipoMime("tipo_mime");
		documentos.add(documento);
		oportunidad.setDocumentos(documentos);
		oportunidad.setEstado("estado");

		oportunidad.setFechaIngreso(new Date());
		oportunidad.setOrigen(parseString(crearOrigen()));
		List<Producto> productos = new ArrayList<Producto>();
		Producto producto = crearProducto(uuidOportunidad);
		productos.add(producto);
		oportunidad.setProductos(productos);
		oportunidad.setUuidOportunidad(uuidOportunidad);

		return oportunidad;
	}

	public static byte[] ObjectToJson(final Object obj) {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			// mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
			final byte[] jsonContent = mapper.writeValueAsBytes(obj);
			System.out.println(new String(jsonContent, StandardCharsets.UTF_8));
			return jsonContent;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static void printStackTrace(String s, Exception e) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		e.printStackTrace(pw);
		System.out.println(s + " => " + e.getMessage());
	}

	public static ComentarioOportunidad crearComentarioOportunidad(String uuid) {
		ComentarioOportunidad comentarioOportunidad = new ComentarioOportunidad();
		comentarioOportunidad.setComentario("comentario");
		comentarioOportunidad.setFecha(new Date());
		comentarioOportunidad.setUsuario("usuario");
		comentarioOportunidad.setUuidComentario(cl.bancochile.automatizador.util.JsonUtils.uuidGenerator());
		comentarioOportunidad.setUuidOportunidad(uuid);
		return comentarioOportunidad;
	}

	private static Object parseString(String json) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			return mapper.readValue(json, Object.class);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

}