package cl.bancochile.automatizador.model;

public class Beneficiario extends Persona {

	private static final long serialVersionUID = 8915845638893596712L;

	private String rut;

	private String nroContacto;

	private String email;

	private String parentesco;

	private String prcBeneficio;

	// atributo que debe ser removido una vez agregada la relacion
	// TarjetaAdicional / Beneficiario
	private String direccion;

	// atributo que debe ser removido una vez agregada la relacion
	// TarjetaAdicional / Beneficiario
	private String comuna;

	// atributo que debe ser removido una vez agregada la relacion
	// TarjetaAdicional / Beneficiario
	private String nombreRegion;

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getNroContacto() {
		return nroContacto;
	}

	public void setNroContacto(String nroContacto) {
		this.nroContacto = nroContacto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getParentesco() {
		return parentesco;
	}

	public void setParentesco(String parentesco) {
		this.parentesco = parentesco;
	}

	public String getPrcBeneficio() {
		return prcBeneficio;
	}

	public void setPrcBeneficio(String prcBeneficio) {
		this.prcBeneficio = prcBeneficio;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getComuna() {
		return comuna;
	}

	public void setComuna(String comuna) {
		this.comuna = comuna;
	}

	public String getNombreRegion() {
		return nombreRegion;
	}

	public void setNombreRegion(String nombreRegion) {
		this.nombreRegion = nombreRegion;
	}

}