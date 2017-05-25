package administradores;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import vo.Espiral;
import vo.Producto;

public class AdministradorDeEspirales {

	private List<Espiral> espirales;

	public AdministradorDeEspirales() {
		this.espirales = new ArrayList<Espiral>();
	}
	
	public boolean agregarEspiralALaMaquina(Espiral espiral){
		if(espiral.getCantidad()>20)
			return false;
		if(espiral.getCantidad()<0)
			return false;
		int filaEnEntero=Integer.valueOf(espiral.getFila());
		filaEnEntero=filaEnEntero-97;
		if(filaEnEntero>=0 && filaEnEntero<27){
			if (espiral.getColumna()>=0 && espiral.getColumna()<100) {
				this.espirales.add(espiral);
				return true;
			}
		}
		return false;
		
	}	
	
	public List<Espiral> listarTodasLasEspirales(){
		return this.espirales;
	}

	public Espiral getEspiral(char fila, int columna) {
		for (Iterator iterator = espirales.iterator(); iterator.hasNext();) {
			Espiral espiral = (Espiral) iterator.next();
			if (espiral.getFila()==fila&&espiral.getColumna()==columna) {
				return espiral;
			}
		}
		return null;
	}

	public boolean editarEspiral(char fila, int columna, Producto producto, int cantidad) {
		if(cantidad<=0||cantidad>100)
			return false;
		for (Iterator iterator = espirales.iterator(); iterator.hasNext();) {
			Espiral espiral = (Espiral) iterator.next();
			if(fila == espiral.getFila()&&columna == espiral.getColumna()){
				espiral.setProducto(producto);
				espiral.setCantidadProducto(cantidad);
				return true;
			}
		}
		return false;
	}

	public boolean validarExistenciaDeEspiral(char fila, int columna) {
		for (Iterator iterator = espirales.iterator(); iterator.hasNext();) {
			Espiral espiral = (Espiral) iterator.next();
			if (espiral.getFila()==fila&&espiral.getColumna()==columna) {
				return true;
			}
		}
		return false;
	}
}
