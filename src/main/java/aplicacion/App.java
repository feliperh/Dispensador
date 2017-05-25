package aplicacion;

import controladores.ControladorAdministrador;
import controladores.ControladorCliente;
import vistas.VistaPrincipal;
import vo.Maquina;

public class App {

	private static Maquina maquina;
	private static VistaPrincipal vistaPrincipal;
	private static ControladorAdministrador controladorAdministrador;
	private static ControladorCliente controladorCliente;
	
	public static void main(String[] args) {
		maquina = new Maquina();
		controladorAdministrador = new ControladorAdministrador();
		controladorCliente = new ControladorCliente();
		controladorAdministrador.setMaquina(maquina);
		controladorCliente.setMaquina(maquina);
		
		vistaPrincipal = new VistaPrincipal(controladorAdministrador,controladorCliente);
		vistaPrincipal.cargarVistaPrincipal();
	}

}
