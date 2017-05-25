package vo;

public class Espiral {
	private Producto producto;
	private int cantidad;
	private char fila;
	private int columna;
	
	
	public Espiral(Producto producto, int cantidad, char fila, int columna) {
		super();
		this.producto = producto;
		this.cantidad = cantidad;
		this.fila = fila;
		this.columna = columna;
	}
	public char getFila() {
		return fila;
	}
	public void setFila(char fila) {
		this.fila = fila;
	}
	public int getColumna() {
		return columna;
	}
	public void setColumna(int columna) {
		this.columna = columna;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidadProducto(int cantidad) {
		this.cantidad = cantidad;
	}
}
