package cl.bancochile.automatizador.model;

import java.io.Serializable;

public class Telefono implements Serializable{

	private static final long serialVersionUID = -8377730837754710901L;
	
	private int codigoArea;
	private String numero;
	private String msisdn;
	public int getCodigoArea() {
		return codigoArea;
	}
	public void setCodigoArea(int codigoArea) {
		this.codigoArea = codigoArea;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getMsisdn() {
		return msisdn;
	}
	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}
	
	
	

}
