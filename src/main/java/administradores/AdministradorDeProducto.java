package administradores;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import vo.Producto;

public class AdministradorDeProducto {
	
	private List<Producto> productos;

	public AdministradorDeProducto() {
		this.productos = new ArrayList<Producto>();
	}
	
	public boolean agregarProductoALaMaquina(Producto productoNuevo){
		if(productoNuevo.getPrecioProducto()%50!=0)
			return false;
		for (Iterator iterator = productos.iterator(); iterator.hasNext();) {
			Producto producto = (Producto) iterator.next();
			if(producto.getNombreProducto().toLowerCase().equals(productoNuevo.getNombreProducto().toLowerCase()))
				return false;
		}
		this.productos.add(productoNuevo);
		return true;
	}	
	
	public Producto obtenerProducto(String nombre){
		for (Iterator iterator = productos.iterator(); iterator.hasNext();) {
			Producto producto = (Producto) iterator.next();
			if(producto.getNombreProducto().toLowerCase().equals(nombre.toLowerCase()))
				return producto;
		}
		return null;
	}
	
	public List<Producto> listarTodosLosProductos(){
		return this.productos;
	}
}
