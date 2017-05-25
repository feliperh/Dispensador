package vo;

public class Producto {
	
	private String nombreProducto;
	private int precioProducto;
	
	public Producto(String nombreProducto, int precioProducto) {
		super();
		this.nombreProducto = nombreProducto;
		this.precioProducto = precioProducto;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public int getPrecioProducto() {
		return precioProducto;
	}

	public void setPrecioProducto(int precioProducto) {
		this.precioProducto = precioProducto;
	}
}

