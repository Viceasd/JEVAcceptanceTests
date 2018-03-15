package cl.bancochile.automatizador.model;

public class Plan {
	private Caso[] casos;

	private String rut;

	private String planPrueba;
	
    private CasoOportunidad[] casoOportunidad;

	private String tipoCuenta;

	public Caso[] getCasos() {
		return casos;
	}

	public void setCasos(Caso[] casos) {
		this.casos = casos;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getPlanPrueba() {
		return planPrueba;
	}

	public void setPlanPrueba(String planPrueba) {
		this.planPrueba = planPrueba;
	}

	public String getTipoCuenta() {
		return tipoCuenta;
	}

	public void setTipoCuenta(String tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}
	public CasoOportunidad[] getCasoOportunidad() {
         return casoOportunidad;
    }

    public void setCasoOportunidad(CasoOportunidad[] casoOportunidad) {
         this.casoOportunidad = casoOportunidad;
    }

}
