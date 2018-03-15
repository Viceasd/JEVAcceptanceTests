package cl.bancochile.automatizador.model;

import java.io.Serializable;
import java.util.List;

public class OportunidadLista implements Serializable{

	private static final long serialVersionUID = 8404735018682057126L;
	private int cantOportunidades;
	private List<OportunidadResumenClte> oportunidades;
	
	public int getCantOportunidades() {
		return cantOportunidades;
	}
	public void setCantOportunidades(int cantOportunidades) {
		this.cantOportunidades = cantOportunidades;
	}
	public List<OportunidadResumenClte> getOportunidades() {
		return oportunidades;
	}
	public void setOportunidades(List<OportunidadResumenClte> oportunidades) {
		this.oportunidades = oportunidades;
	}
	
	
}
