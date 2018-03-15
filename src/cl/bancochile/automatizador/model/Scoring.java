package cl.bancochile.automatizador.model;

import java.io.Serializable;

public class Scoring implements Serializable {

	private static final long serialVersionUID = -6533542976368255023L;
	private String id;

	public String getId() {
          return id;
     }

     public void setId(String id) {
          this.id = id;
     }

     private String tipoVenta;

	private String nivelAtribuciones;

	private String pautaEvaluacion;

	private String consumo;

	private String totalEvaluacion;

	private String nivelRiesgo;

	private String scoring;

	private String politicaProducto;

	private String coutaMaximo;

	private String parametros;

	private String politicaRiesgo;

	private String montoMaximo;

	private String rotativo;
	
	private String fecha;
	
	private String evaluador;
	
	private String politica;
	
	private String productos;
	
	private String procesoCreditos;
	
	private String pauta;
	
	private String resultado;
	
	private String aprobacionCLP;
	
	private String aprobacionUF;
		
	private String error;
	
	private String nivelComercial;

	public String getResultado() {
          return resultado;
     }

     public void setResultado(String resultado) {
          this.resultado = resultado;
     }

     public String getAprobacionCLP() {
          return aprobacionCLP;
     }

     public void setAprobacionCLP(String aprobacionCLP) {
          this.aprobacionCLP = aprobacionCLP;
     }

     public String getAprobacionUF() {
          return aprobacionUF;
     }

     public void setAprobacionUF(String aprobacionUF) {
          this.aprobacionUF = aprobacionUF;
     }

     public String getError() {
          return error;
     }

     public void setError(String error) {
          this.error = error;
     }

     public String getNivelComercial() {
          return nivelComercial;
     }

     public void setNivelComercial(String nivelComercial) {
          this.nivelComercial = nivelComercial;
     }

     public String getPauta() {
          return pauta;
     }

     public void setPauta(String pauta) {
          this.pauta = pauta;
     }

     public String getProcesoCreditos() {
          return procesoCreditos;
     }

     public void setProcesoCreditos(String procesoCreditos) {
          this.procesoCreditos = procesoCreditos;
     }

     public String getProductos() {
          return productos;
     }

     public void setProductos(String productos) {
          this.productos = productos;
     }

     public String getPolitica() {
          return politica;
     }

     public void setPolitica(String politica) {
          this.politica = politica;
     }

     public String getEvaluador() {
          return evaluador;
     }

     public void setEvaluador(String evaluador) {
          this.evaluador = evaluador;
     }

     public String getFecha() {
          return fecha;
     }

     public void setFecha(String fecha) {
          this.fecha = fecha;
     }

     public String getTipoVenta() {
		return tipoVenta;
	}

	public void setTipoVenta(String tipoVenta) {
		this.tipoVenta = tipoVenta;
	}

	public String getNivelAtribuciones() {
		return nivelAtribuciones;
	}

	public void setNivelAtribuciones(String nivelAtribuciones) {
		this.nivelAtribuciones = nivelAtribuciones;
	}

	public String getPautaEvaluacion() {
		return pautaEvaluacion;
	}

	public void setPautaEvaluacion(String pautaEvaluacion) {
		this.pautaEvaluacion = pautaEvaluacion;
	}

	public String getConsumo() {
		return consumo;
	}

	public void setConsumo(String consumo) {
		this.consumo = consumo;
	}

	public String getTotalEvaluacion() {
		return totalEvaluacion;
	}

	public void setTotalEvaluacion(String totalEvaluacion) {
		this.totalEvaluacion = totalEvaluacion;
	}

	public String getNivelRiesgo() {
		return nivelRiesgo;
	}

	public void setNivelRiesgo(String nivelRiesgo) {
		this.nivelRiesgo = nivelRiesgo;
	}

	public String getScoring() {
		return scoring;
	}

	public void setScoring(String scoring) {
		this.scoring = scoring;
	}

	public String getPoliticaProducto() {
		return politicaProducto;
	}

	public void setPoliticaProducto(String politicaProducto) {
		this.politicaProducto = politicaProducto;
	}

	public String getCoutaMaximo() {
		return coutaMaximo;
	}

	public void setCoutaMaximo(String coutaMaximo) {
		this.coutaMaximo = coutaMaximo;
	}

	public String getParametros() {
		return parametros;
	}

	public void setParametros(String parametros) {
		this.parametros = parametros;
	}

	public String getPoliticaRiesgo() {
		return politicaRiesgo;
	}

	public void setPoliticaRiesgo(String politicaRiesgo) {
		this.politicaRiesgo = politicaRiesgo;
	}

	public String getMontoMaximo() {
		return montoMaximo;
	}

	public void setMontoMaximo(String montoMaximo) {
		this.montoMaximo = montoMaximo;
	}

	public String getRotativo() {
		return rotativo;
	}

	public void setRotativo(String rotativo) {
		this.rotativo = rotativo;
	}
}