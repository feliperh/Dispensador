package controladores;

import java.util.List;

import vo.Espiral;
import vo.Maquina;

public class ControladorCliente {

	private Maquina maquina;

	public void setMaquina(Maquina maquina) {
		this.maquina = maquina;
	}
	public Maquina getMaquina() {
		return maquina;
	}
	public List<Espiral> obtenerEspiralesDisponibles() {
		return this.maquina.getAdministradorDeEspirales().listarTodasLasEspirales();
	}
	public int obtenerSaldoDisponible() {
		return this.maquina.getSaldo();
	}
	public boolean ingresarDineroEnLaMaquina(int saldo) {
		return this.maquina.agregarSaldo(saldo);
	}
	public boolean validarDenominacion(int saldo) {
		return this.maquina.validarDenominacion(saldo);
	}
	public boolean verificarDisponibilidadEnArca(int saldo) {
		return this.maquina.getAdministradorDeArcas().verificarDisponibilidadEnArca(saldo);
	}
	public boolean validarFilaColumnaEspiral(char fila, int columna) {
		return this.maquina.getAdministradorDeEspirales().validarExistenciaDeEspiral(fila,columna);
	}
	public Espiral obtenerEspiral(char fila, int columna) {
		// TODO Auto-generated method stub
		return this.maquina.getAdministradorDeEspirales().getEspiral(fila, columna);
	}
	public boolean hayVueltasDisponibles(int precioProducto) {
		return this.maquina.mirarSiHayCambio(precioProducto);
	}
	public String comprarProducto(Espiral espiral) {
		return this.maquina.comprarProducto(espiral);
	}
	public String cancelarCompra() {
		return this.maquina.cancelarCompra();
	}
	
}
