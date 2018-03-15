package cl.bancochile.automatizador.model;

import java.io.Serializable;

public class ProductosEliminar implements Serializable{

	private static final long serialVersionUID = -3132376872754299424L;
	
	private Productos[] productos;

	public Productos[] getProductos() {
		return productos;
	}

	public void setProductos(Productos[] productos) {
		this.productos = productos;
	}
	 
	 
}
