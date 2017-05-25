package vo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import administradores.AdministradorDeArcas;
import administradores.AdministradorDeEspirales;
import administradores.AdministradorDeProducto;

public class Maquina {
	
	private boolean fueraDeServicio;
	private AdministradorDeProducto administradorDeProducto;
	private AdministradorDeEspirales administradorDeEspirales;
	private AdministradorDeArcas administradorDeArcas;
	private List<Integer> listaSaldo;
	
	public Maquina(){
		this.fueraDeServicio=true;
		administradorDeArcas = new AdministradorDeArcas();
		administradorDeProducto = new AdministradorDeProducto();
		administradorDeEspirales = new AdministradorDeEspirales();
		listaSaldo = new ArrayList<Integer>();
	}
	
	public String cancelarCompra() {
		String compraCancelada="";
		List<Arca> arcas = this.administradorDeArcas.listarTodasLasArcas();
		
		for (Iterator iterator = this.listaSaldo.iterator(); iterator.hasNext();) {
			Integer integer = (Integer) iterator.next();
			for (int i = 0; i < arcas.size(); i++) {
				if(integer==arcas.get(i).getValorMoneda()){
					compraCancelada=compraCancelada+integer+" ";
					arcas.get(i).setCantidad(arcas.get(i).getCantidad()-1);
					break;
				}
			}
		}
		this.listaSaldo.clear();
		return compraCancelada;
	}
	
	public String comprarProducto(Espiral espiral) {
		String compra = "";
		int vueltas = this.getSaldo()-espiral.getProducto().getPrecioProducto();
		List<Arca> arcas = this.administradorDeArcas.listarTodasLasArcas();
		List<Espiral> espirales = this.administradorDeEspirales.listarTodasLasEspirales();
		for (int i = 0; i < espirales.size(); i++) {
			if(espirales.get(i).equals(espiral)){
				espirales.get(i).setCantidad(espirales.get(i).getCantidad()-1);
				if(espirales.get(i).getCantidad()==0)
					espirales.remove(espirales.get(i));
				break;
			}			
		}
		for (Iterator iterator = arcas.iterator(); iterator.hasNext();) {
			Arca arca = (Arca) iterator.next();
			while(arca.getCantidad()>0&&vueltas>=arca.getValorMoneda()){
				arca.setCantidad(arca.getCantidad()-1);
				compra = compra+arca.getValorMoneda()+" ";
				vueltas = vueltas-arca.getValorMoneda();
				if(vueltas<=0){
					this.listaSaldo=new ArrayList<Integer>();
					return compra;
				}
			}
		}
		this.listaSaldo.clear();
		return compra;
	}
	
	public boolean mirarSiHayCambio(int precioProducto) {
		int vueltas = this.getSaldo()-precioProducto;
		List<Arca> arcas = this.administradorDeArcas.listarTodasLasArcas();
		for (Iterator iterator = arcas.iterator(); iterator.hasNext();) {
			Arca arca = (Arca) iterator.next();
			int cantidad = arca.getCantidad();
			while(cantidad>0&&vueltas>=arca.getValorMoneda()){
				cantidad--;
				vueltas = vueltas-arca.getValorMoneda();
				if(vueltas<=0)
					return true;
			}
		}
		return false;
	}	
	
	public boolean validarDenominacion(int saldo) {
		if(saldo==50||saldo==100||saldo==200||saldo==500||saldo==1000||saldo==2000||saldo==5000){
			return true;
		}
		return false;
	}
		
	public int getSaldo() {
		int saldo=0;
		for (Iterator iterator = listaSaldo.iterator(); iterator.hasNext();) {
			Integer saldoElemento = (Integer) iterator.next();
			saldo = saldo+saldoElemento;
		}
		return saldo;
	}

	public boolean agregarSaldo(int saldo) {
		this.listaSaldo.add(saldo);
		return true;
	}

	public AdministradorDeArcas getAdministradorDeArcas() {
		return administradorDeArcas;
	}

	public void setAdministradorDeArcas(AdministradorDeArcas administradorDeArcas) {
		this.administradorDeArcas = administradorDeArcas;
	}

	public AdministradorDeEspirales getAdministradorDeEspirales() {
		return administradorDeEspirales;
	}

	public void setAdministradorDeEspirales(AdministradorDeEspirales administradorDeEspirales) {
		this.administradorDeEspirales = administradorDeEspirales;
	}

	public AdministradorDeProducto getAdministradorDeProducto() {
		return administradorDeProducto;
	}

	public void setAdministradorDeProducto(AdministradorDeProducto administradorDeProducto) {
		this.administradorDeProducto = administradorDeProducto;
	}

	public boolean isFueraDeServicio() {
		return fueraDeServicio;
	}

	public void setFueraDeServicio(boolean fueraDeServicio) {
		this.fueraDeServicio = fueraDeServicio;
	}
	
	public void cambiarEstado(){
		if(this.fueraDeServicio){
			this.fueraDeServicio=false;
		}else{
			this.fueraDeServicio=true;
		}		
	}
}