package controladores;

import java.util.List;

import vo.Arca;
import vo.Espiral;
import vo.Maquina;
import vo.Producto;

public class ControladorAdministrador {
	
	private Maquina maquina;

	public void setMaquina(Maquina maquina) {
		this.maquina = maquina;
	}

	public Maquina getMaquina() {
		return maquina;
	}

	public boolean maquinaIsFueraDeServicio() {
		return maquina.isFueraDeServicio();
	}

	public void maquinaCambiarEstado() {
		maquina.cambiarEstado();
	}

	public boolean agregarProductoALaMaquina(Producto producto) {
		return maquina.getAdministradorDeProducto().agregarProductoALaMaquina(producto);
	}

	public boolean agregarEspiralALaMaquina(Espiral espiral) {
		return maquina.getAdministradorDeEspirales().agregarEspiralALaMaquina(espiral);
	}

	public Producto obtenerProducto(String nombre) {
		return maquina.getAdministradorDeProducto().obtenerProducto(nombre);
	}

	public List<Producto> listarTodosLosProductos() {
		return maquina.getAdministradorDeProducto().listarTodosLosProductos();
	}

	public List<Espiral> listarTodasLasEspirales() {
		return maquina.getAdministradorDeEspirales().listarTodasLasEspirales();
	}

	public Espiral obtenerEspiralPorFilaYColumna(char fila, int columna) {
		return maquina.getAdministradorDeEspirales().getEspiral(fila, columna);
	}

	public boolean editarEspiral(char fila, int columna, Producto producto, int cantidad) {
		return maquina.getAdministradorDeEspirales().editarEspiral(fila, columna, producto,cantidad);
	}

	public boolean agregarArca(String nombre, int valor, int cantidad) {
		return maquina.getAdministradorDeArcas().agregarArca(nombre,valor,cantidad);
	}

	public List<Arca> obtenerArcas() {
		return maquina.getAdministradorDeArcas().listarTodasLasArcas();
	}

	public Arca obtenerArcaPorIndice(int arcaIdentificador) {
		return maquina.getAdministradorDeArcas().obtenerArcaPorIndiceDeIdentificador(arcaIdentificador);
	}

	public boolean editarArca(int arcaIdentificador, Arca arca) {
		return maquina.getAdministradorDeArcas().editarArca(arcaIdentificador,arca);		
	}
}
