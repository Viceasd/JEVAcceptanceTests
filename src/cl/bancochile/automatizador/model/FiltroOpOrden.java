package cl.bancochile.automatizador.model;

import java.io.Serializable;

public class FiltroOpOrden implements Serializable{

	private static final long serialVersionUID = 2631147041583981073L;
	private FiltroListaOportunidadExt[] filtroOportunidad;
	private Ordenamiento[] ordenamiento;
	
	public FiltroListaOportunidadExt[] getFiltroOportunidad() {
		return filtroOportunidad.clone();
	}
	public void setFiltroOportunidad(FiltroListaOportunidadExt[] filtroOportunidad) {
		this.filtroOportunidad = filtroOportunidad.clone();
	}
	public Ordenamiento[] getOrdenamiento() {
		return ordenamiento.clone();
	}
	public void setOrdenamiento(Ordenamiento[] ordenamiento) {
		this.ordenamiento = ordenamiento.clone();
	}
}
