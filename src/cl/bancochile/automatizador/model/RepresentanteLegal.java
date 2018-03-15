package cl.bancochile.automatizador.model;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RepresentanteLegal implements Serializable {
	private static final long serialVersionUID = -8152167346506602896L;

	private String nombre;

	private String comuna;

	private String direccion;

	private String parentesco;

	private String email;

	private String Rut;

	private String telefono;

	private String apellidoMaterno;

	private String apellidoPaterno;

	private String esRepresentanteLegal;

	private String esPatrocinante;

	private String numero;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getComuna() {
		return comuna;
	}

	public void setComuna(String comuna) {
		this.comuna = comuna;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getParentesco() {
		return parentesco;
	}

	public void setParentesco(String parentesco) {
		this.parentesco = parentesco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRut() {
		return Rut;
	}

	public void setRut(String Rut) {
		this.Rut = Rut;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getEsRepresentanteLegal() {
		return esRepresentanteLegal;
	}

	public void setEsRepresentanteLegal(String esRepresentanteLegal) {
		this.esRepresentanteLegal = esRepresentanteLegal;
	}

	public String getEsPatrocinante() {
		return esPatrocinante;
	}

	public void setEsPatrocinante(String esPatrocinante) {
		this.esPatrocinante = esPatrocinante;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

}
