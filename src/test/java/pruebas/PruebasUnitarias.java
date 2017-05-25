package pruebas;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import administradores.AdministradorDeProducto;
import controladores.ControladorAdministrador;
import controladores.ControladorCliente;
import vistas.VistaAdministrador;
import vo.Arca;
import vo.Espiral;
import vo.Maquina;
import vo.Producto;

public class PruebasUnitarias {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void insertarProductoPaqueteDePapasYObtenerNombre() {
		AdministradorDeProducto administradorDeProducto = new AdministradorDeProducto();
		administradorDeProducto.agregarProductoALaMaquina(new Producto("Paquete de Papas", 750));
		assertEquals("Paquete de Papas", administradorDeProducto.listarTodosLosProductos().get(0).getNombreProducto());
		
	}
	
	@Test
	public void insertar2ProductoPaqueteDePapasYObtenerNombre() {
		AdministradorDeProducto administradorDeProducto = new AdministradorDeProducto();
		administradorDeProducto.agregarProductoALaMaquina(new Producto("Paquete de Papas", 750));
		administradorDeProducto.agregarProductoALaMaquina(new Producto("Paquete de tajadas naturales", 1550));
		assertEquals("Paquete de tajadas naturales", administradorDeProducto.listarTodosLosProductos().get(1).getNombreProducto());
		
	}
	
	@Test
	public void encontrarProductoEnAdministradorDeProductosPorNombre() {
		AdministradorDeProducto administradorDeProducto = new AdministradorDeProducto();
		administradorDeProducto.agregarProductoALaMaquina(new Producto("Paquete de Papas".toLowerCase(), 750));
		assertEquals("paquete de papas", administradorDeProducto.obtenerProducto("paquete de papas").getNombreProducto());
	}
	
	@Test
	public void encontrarProductoEnAdministradorDeProductosPorObjeto() {
		AdministradorDeProducto administradorDeProducto = new AdministradorDeProducto();
		Producto p = new Producto("paquete de papas", 750);
		administradorDeProducto.agregarProductoALaMaquina(p);
		assertEquals(p, administradorDeProducto.obtenerProducto("paquete de papas"));
	}
	
	@Test
	public void noEncontrarProductoEnAdministradorDeProductos() {
		AdministradorDeProducto administradorDeProducto = new AdministradorDeProducto();
		administradorDeProducto.agregarProductoALaMaquina(new Producto("Paquete de Papas", 750));
		assertNull(administradorDeProducto.obtenerProducto("paquete"));
	}
	
	@Test
	public void errorAlAgregarEspiralFueraDeRangoColumna100() {
		Maquina maquina = new Maquina();
		boolean agregado = maquina.getAdministradorDeEspirales().agregarEspiralALaMaquina(new Espiral(new Producto("Galletas", 1000), 1000, 'a', 100));
		assertFalse(agregado);
	}
	
	@Test
	public void errorAlAgregarEspiralEnFilaFueraDeRangoEnFilaArroba() {
		Maquina maquina = new Maquina();
		boolean agregado = maquina.getAdministradorDeEspirales().agregarEspiralALaMaquina(new Espiral(new Producto("Galletas", 1000), 1000, '@', 10));
		assertFalse(agregado);
	}
	
	@Test
	public void agregarEspiralDentroDeRangoTrue() {
		Maquina maquina = new Maquina();
		boolean agregado = maquina.getAdministradorDeEspirales().agregarEspiralALaMaquina(new Espiral(new Producto("Galletas", 1000), 10, 'z', 10));
		assertTrue(agregado);
	}
	
	@Test
	public void agregarEspiralCantidadExcedida() {
		Maquina maquina = new Maquina();
		boolean agregado = maquina.getAdministradorDeEspirales().agregarEspiralALaMaquina(new Espiral(new Producto("Galletas", 1000), 21, 'z', 10));
		assertFalse(agregado);
	}
	
	@Test
	public void agregarArcaDesdeControladorAdministradorDenominacion1000True() {
		Maquina maquina = new Maquina();
		ControladorAdministrador controladorAdministrador = new ControladorAdministrador();
		controladorAdministrador.setMaquina(maquina);
		boolean agregado = controladorAdministrador.agregarArca("billete", 1000, 20);
		assertTrue(agregado);
	}
	
	@Test
	public void agregarArcaDesdeControladorAdministradorDenominacion2000True() {
		Maquina maquina = new Maquina();
		ControladorAdministrador controladorAdministrador = new ControladorAdministrador();
		controladorAdministrador.setMaquina(maquina);
		boolean agregado = controladorAdministrador.agregarArca("billete", 2000, 20);
		assertTrue(agregado);
	}
	
	@Test
	public void agregarArcaDesdeControladorAdministradorCantidadExedida101False() {
		Maquina maquina = new Maquina();
		ControladorAdministrador controladorAdministrador = new ControladorAdministrador();
		controladorAdministrador.setMaquina(maquina);
		boolean agregado = controladorAdministrador.agregarArca("billete", 2000, 101);
		assertFalse(agregado);
	}
	
	@Test
	public void agregarArcaDesdeControladorAdministradorCantidadMenoraCeroFalse() {
		Maquina maquina = new Maquina();
		ControladorAdministrador controladorAdministrador = new ControladorAdministrador();
		controladorAdministrador.setMaquina(maquina);
		boolean agregado = controladorAdministrador.agregarArca("billete", 2000, -1);
		assertFalse(agregado);
	}
	
	@Test
	public void agregarArcaDesdeControladorAdministradorCantidadCeroFalse() {
		Maquina maquina = new Maquina();
		ControladorAdministrador controladorAdministrador = new ControladorAdministrador();
		controladorAdministrador.setMaquina(maquina);
		boolean agregado = controladorAdministrador.agregarArca("billete", 2000, 0);
		assertFalse(agregado);
	}
	
	@Test
	public void agregarArcaDesdeControladorAdministradorDenominacionMayorA5000() {
		Maquina maquina = new Maquina();
		ControladorAdministrador controladorAdministrador = new ControladorAdministrador();
		controladorAdministrador.setMaquina(maquina);
		boolean agregado = controladorAdministrador.agregarArca("billete", 5001, 1);
		assertFalse(agregado);
	}
	
	@Test
	public void agregarArcaDesdeControladorAdministradorDenominacion0() {
		Maquina maquina = new Maquina();
		ControladorAdministrador controladorAdministrador = new ControladorAdministrador();
		controladorAdministrador.setMaquina(maquina);
		boolean agregado = controladorAdministrador.agregarArca("billete", 0, 1);
		assertFalse(agregado);
	}
	
	@Test
	public void obtenerArcaDigitandoIndiceMenorACero() {
		Maquina maquina = new Maquina();
		ControladorAdministrador controladorAdministrador = new ControladorAdministrador();
		controladorAdministrador.setMaquina(maquina);
		controladorAdministrador.agregarArca("billete", 0, 1);
		Arca agregado = controladorAdministrador.obtenerArcaPorIndice(-1);
		assertNull(agregado);
	}
	
	@Test
	public void obtenerArcaDigitandoIndiceMayorALaCantidadTotalDeArcas() {
		Maquina maquina = new Maquina();
		ControladorAdministrador controladorAdministrador = new ControladorAdministrador();
		controladorAdministrador.setMaquina(maquina);
		controladorAdministrador.agregarArca("billete", 0, 1);
		Arca agregado = controladorAdministrador.obtenerArcaPorIndice(1);
		assertNull(agregado);
	}
	
	@Test
	public void obtenerArcaDigitandoIndice() {
		Maquina maquina = new Maquina();
		ControladorAdministrador controladorAdministrador = new ControladorAdministrador();
		controladorAdministrador.setMaquina(maquina);
		controladorAdministrador.agregarArca("billete", 50, 1);
		Arca agregado = controladorAdministrador.obtenerArcaPorIndice(0);
		assertEquals("billete", agregado.getNombre());
	}
	
	@Test
	public void obtenerArcaDigitandoIndiceTercerArca() {
		Maquina maquina = new Maquina();
		ControladorAdministrador controladorAdministrador = new ControladorAdministrador();
		controladorAdministrador.setMaquina(maquina);
		controladorAdministrador.agregarArca("billete 1", 50, 1);
		controladorAdministrador.agregarArca("billete 2", 500, 1);
		controladorAdministrador.agregarArca("billete 3", 1000, 1);
		Arca agregado = controladorAdministrador.obtenerArcaPorIndice(2);
		assertEquals("billete 1", agregado.getNombre());
	}
	
	@Test
	public void obtenerArcaDigitandoIndiceTerc() {
		Maquina maquina = new Maquina();
		ControladorAdministrador controladorAdministrador = new ControladorAdministrador();
		controladorAdministrador.setMaquina(maquina);
		controladorAdministrador.agregarArca("billete 1", 50, 1);
		controladorAdministrador.agregarArca("billete 2", 500, 1);
		controladorAdministrador.agregarArca("billete 3", 1000, 1);
		Arca agregado = controladorAdministrador.obtenerArcaPorIndice(2);
		assertEquals("billete 1", agregado.getNombre());
	}
	
	@Test
	public void editarArcaConCantidadErronea() {
		Maquina maquina = new Maquina();
		ControladorAdministrador controladorAdministrador = new ControladorAdministrador();
		controladorAdministrador.setMaquina(maquina);
		Arca arca = new Arca("billete 2", 100, -1);
		controladorAdministrador.agregarArca("billete 1", 50, 1);
		assertFalse(controladorAdministrador.editarArca(0,arca ));
	}
	
	@Test
	public void editarArcaConCantidadMayorA100() {
		Maquina maquina = new Maquina();
		ControladorAdministrador controladorAdministrador = new ControladorAdministrador();
		controladorAdministrador.setMaquina(maquina);
		controladorAdministrador.agregarArca("billete 1", 50, 1);
		Arca arca = new Arca("billete 2", 100, 101);
		assertFalse(controladorAdministrador.editarArca(0,arca));
	}
	
	@Test
	public void editarArcaConCantidadcero() {
		Maquina maquina = new Maquina();
		ControladorAdministrador controladorAdministrador = new ControladorAdministrador();
		controladorAdministrador.setMaquina(maquina);
		controladorAdministrador.agregarArca("billete 1", 50, 1);
		Arca arca = new Arca("billete 2", 50, 0);
		assertFalse(controladorAdministrador.editarArca(0, arca));
	}
	
	@Test
	public void editarArcaConDenominacion1040False() {
		Maquina maquina = new Maquina();
		ControladorAdministrador controladorAdministrador = new ControladorAdministrador();
		controladorAdministrador.setMaquina(maquina);
		controladorAdministrador.agregarArca("billete 1", 50, 1);
		Arca arca = new Arca("billete 2", 1040, 1);
		assertFalse(controladorAdministrador.editarArca(0, arca));
	}
	
	@Test
	public void editarArcaConDenominacion500() {
		Maquina maquina = new Maquina();
		ControladorAdministrador controladorAdministrador = new ControladorAdministrador();
		controladorAdministrador.setMaquina(maquina);
		controladorAdministrador.agregarArca("billete 1", 50, 1);
		Arca arca = new Arca("billete 2", 500, 1);
		assertTrue(controladorAdministrador.editarArca(0, arca));
	}
	
	@Test
	public void editarArcaConDenominacion1000() {
		Maquina maquina = new Maquina();
		ControladorAdministrador controladorAdministrador = new ControladorAdministrador();
		controladorAdministrador.setMaquina(maquina);
		controladorAdministrador.agregarArca("billete 1", 50, 1);
		Arca arca = new Arca("billete 2", 1000, 1);
		assertTrue(controladorAdministrador.editarArca(0, arca));
	}
	
	@Test
	public void editarArcaConDenominacion2000() {
		Maquina maquina = new Maquina();
		ControladorAdministrador controladorAdministrador = new ControladorAdministrador();
		controladorAdministrador.setMaquina(maquina);
		controladorAdministrador.agregarArca("billete 1", 50, 1);
		Arca arca = new Arca("billete 2", 2000, 11);
		assertTrue(controladorAdministrador.editarArca(0,arca));
	}
	
	@Test
	public void editarArcaConDenominacion5000() {
		Maquina maquina = new Maquina();
		ControladorAdministrador controladorAdministrador = new ControladorAdministrador();
		controladorAdministrador.setMaquina(maquina);
		controladorAdministrador.agregarArca("billete 1", 50, 1);
		Arca arca = new Arca("billete 2", 5000, 1);
		assertTrue(controladorAdministrador.editarArca(0, arca));
	}
	
	@Test
	public void modificarEspiral() {
		Maquina maquina = new Maquina();
		ControladorAdministrador controladorAdministrador = new ControladorAdministrador();
		controladorAdministrador.setMaquina(maquina);
		controladorAdministrador.agregarEspiralALaMaquina(new Espiral(new Producto("Galletas", 1000), 10, 'a', 0));
		assertTrue(controladorAdministrador.editarEspiral('a', 0, new Producto("Galletas", 1000), 20));
	}
	
	@Test
	public void modificarEspiralCantidadCero() {
		Maquina maquina = new Maquina();
		ControladorAdministrador controladorAdministrador = new ControladorAdministrador();
		controladorAdministrador.setMaquina(maquina);
		controladorAdministrador.agregarEspiralALaMaquina(new Espiral(new Producto("Galletas", 1000), 10, 'a', 0));
		assertFalse(controladorAdministrador.editarEspiral('a', 0, new Producto("Galletas", 1000), 0));
	}
	
	@Test
	public void modificarEspiralCantidadSuperioA100() {
		Maquina maquina = new Maquina();
		ControladorAdministrador controladorAdministrador = new ControladorAdministrador();
		controladorAdministrador.setMaquina(maquina);
		controladorAdministrador.agregarEspiralALaMaquina(new Espiral(new Producto("Galletas", 1000), 10, 'a', 0));
		assertFalse(controladorAdministrador.editarEspiral('a', 0, new Producto("Galletas", 1000), 101));
	}
	
	@Test
	public void modificarEspiralFilaErronea() {
		Maquina maquina = new Maquina();
		ControladorAdministrador controladorAdministrador = new ControladorAdministrador();
		controladorAdministrador.setMaquina(maquina);
		controladorAdministrador.agregarEspiralALaMaquina(new Espiral(new Producto("Galletas", 1000), 10, 'a', 0));
		assertFalse(controladorAdministrador.editarEspiral('b', 0, new Producto("Galletas", 1000), 101));
	}
	
	@Test
	public void modificarEspiralFilaColumnaErronea() {
		Maquina maquina = new Maquina();
		ControladorAdministrador controladorAdministrador = new ControladorAdministrador();
		controladorAdministrador.setMaquina(maquina);
		controladorAdministrador.agregarEspiralALaMaquina(new Espiral(new Producto("Galletas", 1000), 10, 'a', 0));
		assertFalse(controladorAdministrador.editarEspiral('a', 1, new Producto("Galletas", 1000), 101));
	}
	
	@Test
	public void clienteValidarDenominacion() {
		Maquina maquina = new Maquina();
		ControladorCliente controladorCliente = new ControladorCliente();
		controladorCliente.setMaquina(maquina);
		assertTrue(controladorCliente.validarDenominacion(1000));
	}
	
	@Test
	public void clienteFallarValidarDenominacion() {
		Maquina maquina = new Maquina();
		ControladorCliente controladorCliente = new ControladorCliente();
		controladorCliente.setMaquina(maquina);
		assertFalse(controladorCliente.validarDenominacion(1010));
	}
	
	@Test
	public void clienteFallarValidarDenominacion5000() {
		Maquina maquina = new Maquina();
		ControladorCliente controladorCliente = new ControladorCliente();
		controladorCliente.setMaquina(maquina);
		assertTrue(controladorCliente.validarDenominacion(5000));
	}
	
	@Test
	public void clienteFallarValidarDenominacion50() {
		Maquina maquina = new Maquina();
		ControladorCliente controladorCliente = new ControladorCliente();
		controladorCliente.setMaquina(maquina);
		assertTrue(controladorCliente.validarDenominacion(50));
	}
	
	@Test
	public void clienteVerificarDisponibilidadEnElArca() {
		Maquina maquina = new Maquina();
		ControladorAdministrador controladorAdministrador = new ControladorAdministrador();
		ControladorCliente controladorCliente = new ControladorCliente();
		controladorAdministrador.setMaquina(maquina);
		controladorCliente.setMaquina(maquina);
		controladorAdministrador.agregarArca("mil", 1000, 1);
		assertTrue(controladorCliente.verificarDisponibilidadEnArca(1000));
	}
	
	@Test
	public void clienteVerificarNoDisponibilidadEnElArca() {
		Maquina maquina = new Maquina();
		ControladorAdministrador controladorAdministrador = new ControladorAdministrador();
		ControladorCliente controladorCliente = new ControladorCliente();
		controladorAdministrador.setMaquina(maquina);
		controladorCliente.setMaquina(maquina);
		controladorAdministrador.agregarArca("mil", 1000, 100);
		assertFalse(controladorCliente.verificarDisponibilidadEnArca(1000));
	}
	
	@Test
	public void clienteVerificarDisponibilidadEnElArcaCon99() {
		Maquina maquina = new Maquina();
		ControladorAdministrador controladorAdministrador = new ControladorAdministrador();
		ControladorCliente controladorCliente = new ControladorCliente();
		controladorAdministrador.setMaquina(maquina);
		controladorCliente.setMaquina(maquina);
		controladorAdministrador.agregarArca("mil", 1000, 99);
		assertTrue(controladorCliente.verificarDisponibilidadEnArca(1000));
	}
	
	@Test
	public void clienteVerificarDisponibilidadEnArcaQueNoExiste() {
		Maquina maquina = new Maquina();
		ControladorAdministrador controladorAdministrador = new ControladorAdministrador();
		ControladorCliente controladorCliente = new ControladorCliente();
		controladorAdministrador.setMaquina(maquina);
		controladorCliente.setMaquina(maquina);
		controladorAdministrador.agregarArca("mil", 1000, 99);
		assertFalse(controladorCliente.verificarDisponibilidadEnArca(500));
	}
	
	@Test
	public void clienteObtenerSaldoTotal() {
		Maquina maquina = new Maquina();
		ControladorCliente controladorCliente = new ControladorCliente();
		controladorCliente.setMaquina(maquina);
		controladorCliente.ingresarDineroEnLaMaquina(500);
		controladorCliente.ingresarDineroEnLaMaquina(500);
		controladorCliente.ingresarDineroEnLaMaquina(1000);
		assertEquals(2000, controladorCliente.obtenerSaldoDisponible());
	}
	
	@Test
	public void clienteObtenerSaldoEquivocado() {
		Maquina maquina = new Maquina();
		ControladorCliente controladorCliente = new ControladorCliente();
		controladorCliente.setMaquina(maquina);
		controladorCliente.ingresarDineroEnLaMaquina(500);
		controladorCliente.ingresarDineroEnLaMaquina(500);
		controladorCliente.ingresarDineroEnLaMaquina(1000);
		assertNotEquals(200, controladorCliente.obtenerSaldoDisponible());
	}
	
	@Test
	public void vueltasComprarProductode1000ConSaldoDe1100() {
		Maquina maquina = new Maquina();
		ControladorAdministrador controladorAdministrador = new ControladorAdministrador();
		ControladorCliente controladorCliente = new ControladorCliente();
		controladorAdministrador.setMaquina(maquina);
		controladorCliente.setMaquina(maquina);
		Espiral espiral = new Espiral(new Producto("Galletas", 1000), 10, 'a', 0);
		controladorAdministrador.agregarEspiralALaMaquina(espiral);
		controladorAdministrador.agregarArca("cincuenta", 50, 50);
		controladorCliente.ingresarDineroEnLaMaquina(1100);
		assertEquals("50 50 ", controladorCliente.comprarProducto(espiral));
	}
	
	@Test
	public void vueltasComprarProductode1050ConSaldoDe4000() {
		Maquina maquina = new Maquina();
		ControladorAdministrador controladorAdministrador = new ControladorAdministrador();
		ControladorCliente controladorCliente = new ControladorCliente();
		controladorAdministrador.setMaquina(maquina);
		controladorCliente.setMaquina(maquina);
		Espiral espiral = new Espiral(new Producto("Galletas", 1050), 10, 'a', 0);
		controladorAdministrador.agregarEspiralALaMaquina(espiral);
		controladorAdministrador.agregarArca("mil", 1000, 50);
		controladorAdministrador.agregarArca("quini", 500, 50);
		controladorAdministrador.agregarArca("cincuenta", 50, 50);
		controladorCliente.ingresarDineroEnLaMaquina(4000);
		controladorCliente.hayVueltasDisponibles(1050);
		assertEquals("1000 1000 500 50 50 50 50 50 50 50 50 50 ", controladorCliente.comprarProducto(espiral));
	}
	
	@Test
	public void vueltasComprarProductode1000ArcasDeSolo500() {
		Maquina maquina = new Maquina();
		ControladorAdministrador controladorAdministrador = new ControladorAdministrador();
		ControladorCliente controladorCliente = new ControladorCliente();
		controladorAdministrador.setMaquina(maquina);
		controladorCliente.setMaquina(maquina);
		Espiral espiral = new Espiral(new Producto("Galletas", 1000), 10, 'a', 0);
		controladorAdministrador.agregarEspiralALaMaquina(espiral);
		controladorAdministrador.agregarArca("cincuenta", 50, 50);
		controladorAdministrador.agregarArca("cincuenta1", 50, 50);
		controladorAdministrador.agregarArca("cincuenta2", 50, 50);
		controladorCliente.ingresarDineroEnLaMaquina(1500);
		assertEquals("50 50 50 50 50 50 50 50 50 50 ", controladorCliente.comprarProducto(espiral));
	}
	
	@Test
	public void vueltasComprarProductode100ConSaldoDe1100() {
		Maquina maquina = new Maquina();
		ControladorAdministrador controladorAdministrador = new ControladorAdministrador();
		ControladorCliente controladorCliente = new ControladorCliente();
		controladorAdministrador.setMaquina(maquina);
		controladorCliente.setMaquina(maquina);
		Espiral espiral = new Espiral(new Producto("Galletas", 1000), 10, 'a', 0);
		controladorAdministrador.agregarEspiralALaMaquina(espiral);
		controladorAdministrador.agregarArca("cien", 100, 50);
		controladorAdministrador.agregarArca("cincuenta", 50, 50);
		controladorCliente.ingresarDineroEnLaMaquina(1100);
		assertEquals("100 ", controladorCliente.comprarProducto(espiral));
	}
	
	@Test
	public void vueltasComprarProductode1000ConSaldoDe1200ConUnaUnidadDeCienEnArca() {
		Maquina maquina = new Maquina();
		ControladorAdministrador controladorAdministrador = new ControladorAdministrador();
		ControladorCliente controladorCliente = new ControladorCliente();
		controladorAdministrador.setMaquina(maquina);
		controladorCliente.setMaquina(maquina);
		Espiral espiral = new Espiral(new Producto("Galletas", 1000), 10, 'a', 0);
		controladorAdministrador.agregarEspiralALaMaquina(espiral);
		controladorAdministrador.agregarArca("cien", 100, 1);
		controladorAdministrador.agregarArca("cincuenta", 50, 50);
		controladorCliente.ingresarDineroEnLaMaquina(1200);
		assertEquals("100 50 50 ", controladorCliente.comprarProducto(espiral));
	}
	
	@Test
	public void cantidadProductoCompradoDisminuyeEnEspiralEn1() {
		Maquina maquina = new Maquina();
		ControladorAdministrador controladorAdministrador = new ControladorAdministrador();
		ControladorCliente controladorCliente = new ControladorCliente();
		controladorAdministrador.setMaquina(maquina);
		controladorCliente.setMaquina(maquina);
		Espiral espiral = new Espiral(new Producto("Galletas", 1000), 20, 'a', 0);
		controladorAdministrador.agregarEspiralALaMaquina(espiral);
		controladorAdministrador.agregarArca("cien", 100, 1);
		controladorAdministrador.agregarArca("cincuenta", 50, 50);
		controladorCliente.ingresarDineroEnLaMaquina(1200);
		controladorCliente.comprarProducto(espiral);
		assertEquals(19, controladorAdministrador.obtenerEspiralPorFilaYColumna('a', 0).getCantidad());
	}
	
	@Test
	public void cantidadProductoCompradoDisminuyeEnEspiralEn2() {
		Maquina maquina = new Maquina();
		ControladorAdministrador controladorAdministrador = new ControladorAdministrador();
		ControladorCliente controladorCliente = new ControladorCliente();
		controladorAdministrador.setMaquina(maquina);
		controladorCliente.setMaquina(maquina);
		Espiral espiral = new Espiral(new Producto("Galletas", 1000), 20, 'a', 0);
		controladorAdministrador.agregarEspiralALaMaquina(espiral);
		controladorAdministrador.agregarArca("cien", 100, 1);
		controladorAdministrador.agregarArca("cincuenta", 50, 50);
		controladorCliente.ingresarDineroEnLaMaquina(2000);
		controladorCliente.comprarProducto(espiral);
		controladorCliente.ingresarDineroEnLaMaquina(2000);
		controladorCliente.comprarProducto(espiral);
		assertEquals(18, controladorAdministrador.obtenerEspiralPorFilaYColumna('a', 0).getCantidad());
	}
	

}
