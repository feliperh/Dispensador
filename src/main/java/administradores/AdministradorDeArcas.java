package administradores;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import vo.Arca;

public class AdministradorDeArcas {
	private List<Arca> arcas;

	public AdministradorDeArcas() {
		this.arcas = new ArrayList<Arca>();
	}
	
	public List<Arca> listarTodasLasArcas(){
		return this.arcas;
	}

	public boolean agregarArca(String nombre, int valor, int cantidad) {
		compruebaQueNoSea0LaCantidadYQueSeaUnaDenominacionValida(valor);
		if (cantidad<=0 ||cantidad>100) 
			return false;
		if(valor==50||valor==100||valor==200||valor==500||valor==1000||valor==2000||valor==5000){
			this.arcas.add(new Arca(nombre, valor, cantidad));
			ordenarArcas();
			return true;
		}
		return false;
	}
	
	public boolean compruebaQueNoSea0LaCantidadYQueSeaUnaDenominacionValida(int valor){
		if(valor<0)
			return false;
		if(valor%50!=0)
			return false;
		return false;
	}

	public Arca obtenerArcaPorIndiceDeIdentificador(int arcaIdentificador) {
		if(arcaIdentificador<0)
			return null;
		if(arcaIdentificador>=this.arcas.size())
			return null;
		return this.arcas.get(arcaIdentificador);
	}

	public boolean editarArca(int arcaIdentificador, Arca arca) {
		if(arca.getCantidad()<=0 || arca.getCantidad()>100)
			return false;
		if(arca.getValorMoneda()==50||arca.getValorMoneda()==100||arca.getValorMoneda()==200||arca.getValorMoneda()==500||arca.getValorMoneda()==1000||arca.getValorMoneda()==2000||arca.getValorMoneda()==5000){
			this.arcas.remove(arcaIdentificador);
			this.arcas.add(arca);
			ordenarArcas();
			return true;
		}
		return false;
	}

	public boolean verificarDisponibilidadEnArca(int saldo) {
		for (int i = 0;i<this.arcas.size();i++) {
			if(this.arcas.get(i).getValorMoneda()==saldo){
				if(this.arcas.get(i).getCantidad()<this.arcas.get(i).getCantidadMaxima()){
					this.arcas.get(i).setCantidad(this.arcas.get(i).getCantidad()+1);
					return true;	
				}
			}
		}
		return false;
	}	
	
	private void ordenarArcas(){
		this.arcas.sort(new Comparator<Arca>() {
			public int compare(Arca arca1, Arca arca2) {
				if(arca1.getValorMoneda()<arca2.getValorMoneda())
					return 0;
				return -1;
			}
		});
	}
}
