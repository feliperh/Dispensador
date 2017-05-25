package vo;

public class Arca {
	
	private String nombre;
	private int valorMoneda;
	private int cantidad;
	private int cantidadMaxima;
	
	public Arca(String nombre, int valorMoneda, int cantidad) {
		super();
		this.nombre = nombre;
		this.valorMoneda = valorMoneda;
		this.cantidad = cantidad;
		this.cantidadMaxima = 100;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getValorMoneda() {
		return valorMoneda;
	}

	public void setValorMoneda(int valorMoneda) {
		this.valorMoneda = valorMoneda;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getCantidadMaxima() {
		return cantidadMaxima;
	}

	public void setCantidadMaxima(int cantidadMaxima) {
		this.cantidadMaxima = cantidadMaxima;
	}	
}
