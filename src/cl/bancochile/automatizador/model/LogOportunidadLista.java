package cl.bancochile.automatizador.model;

import java.io.Serializable;
import java.util.List;

public class LogOportunidadLista implements Serializable {

	private static final long serialVersionUID = 38687305139229400L;

	private List<LogOportunidadRoot> LogOportunidadRoots;

	public List<LogOportunidadRoot> getLogOportunidadRoots() {
		return LogOportunidadRoots;
	}

	public void setLogOportunidadRoots(List<LogOportunidadRoot> logOportunidadRoots) {
		LogOportunidadRoots = logOportunidadRoots;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
