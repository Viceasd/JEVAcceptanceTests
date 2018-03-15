package cl.bancochile.automatizador.model;

/*import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)*/
public class PlanBPM {

	private Plan[] plan;

	public Plan[] getPlan() {
		return plan;
	}

	public void setPlan(Plan[] plan) {
		this.plan = plan;
	}

	@Override
	public String toString() {
		return "ClassPojo [plan = " + plan + "]";
	}
}
