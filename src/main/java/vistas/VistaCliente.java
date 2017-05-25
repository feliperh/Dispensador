package vistas;

import java.util.Iterator;
import java.util.List;
import controladores.ControladorCliente;
import herramientas.IOUsuario;
import vo.Espiral;

public class VistaCliente {
	
	private ControladorCliente controladorCliente;
	private boolean controlMenu;
	
	public VistaCliente(ControladorCliente controladorCliente) {
		this.controladorCliente = controladorCliente;
	}

	public void ingresarVistaCliente(){
		controlMenu = true;
		while(controlMenu){
            System.out.println( "\nMENU CLIENTE:" );
            System.out.println( "1. Listar productos en espirales." );
            System.out.println( "2. insertar dinero." );
            System.out.println( "3. Mostrar saldo disponible." );
            System.out.println( "4. Comprar producto." );
            System.out.println( "5. Cancelar compra." );
            System.out.println( "6. Salir." );
            try {
            	int opcion = Integer.parseInt(IOUsuario.lecturaTeclado.readLine());
            	if(controladorCliente.getMaquina().isFueraDeServicio()){
    				System.out.println("La maquina esta fuera de servicio.");
    				System.out.println("Contacte el administrador.");
    				controlMenu=false;
    			}else{
    				 switch (opcion) {
    	        		case 1:
    	        			listarProductosEnEspirales();
    	        			break;
    	        		case 2:
    	        			insertarDineroEnLaMaquina();
    	        			break;
    	        		case 3:
    	        			mostrarSaldoDisponible();
    	        			break;
    	        		case 4:
    	        			comprarProducto();
    	        			break;
    	        		case 5:
    	        			cancelarCompra();
    	        			break;
    	        		case 6:
    	        			controlMenu = false;
    	        			break;
    	        		default:
    	        			System.out.println( "\nIntenta nuevamente." );
    	        			break;
    				 	}
    				}
    			} catch (Exception e) {
    			System.out.println( "\n¡Digita un entero por favor!" );
    		}
      	} 
	}

	private void cancelarCompra() {
		System.out.println("Compra Cancelada.");
		System.out.println("Recibe tu dinero.");
		System.out.println("$"+controladorCliente.obtenerSaldoDisponible());
		String compraCancelada = controladorCliente.cancelarCompra();	
		System.out.println("-> "+compraCancelada);
	}

	private void comprarProducto() {
		System.out.println("Comprar producto.");
		try {
			System.out.println("Ingresa la fila");
			char fila = IOUsuario.lecturaTeclado.readLine().charAt(0);
			System.out.println("Ingresa la columna");
			int columna = Integer.parseInt(IOUsuario.lecturaTeclado.readLine());
			if(!controladorCliente.validarFilaColumnaEspiral(fila,columna)){
				System.out.println("Has ingresado coordenadas incorrectas.");
				return;
			}
			Espiral espiral = controladorCliente.obtenerEspiral(fila,columna);
			
			if(espiral.getProducto().getPrecioProducto()>controladorCliente.obtenerSaldoDisponible()){
				System.out.println("No te alcanza el dinero. Ingresa mas moneditas o billeticos.");
				return;
			}
			 if(!controladorCliente.hayVueltasDisponibles(espiral.getProducto().getPrecioProducto())){
				System.out.println("No te podemos dar cambio. Elige un producto diferente o cancela la compra.");
				return;
			 }
			 System.out.println("Has comprado:");
			 System.out.println(espiral.getProducto().getNombreProducto());
			 System.out.println("Cantidad = 1");
			 System.out.println("Precio   = "+espiral.getProducto().getPrecioProducto());
			 System.out.println("Vueltas ");
			 int totalVueltas = controladorCliente.getMaquina().getSaldo()-espiral.getProducto().getPrecioProducto();
			 System.out.println("$"+totalVueltas);
			 String vueltas = controladorCliente.comprarProducto(espiral);
			 System.out.print(vueltas+"\n");
		} catch (Exception e) {
			System.out.println("Verifica el tipo de dato.");
		}
	}

	private void mostrarSaldoDisponible() {
		System.out.println("Tu saldo es:");
		System.out.println("$"+controladorCliente.obtenerSaldoDisponible());
		
	}

	private void insertarDineroEnLaMaquina() {
		try {
			System.out.println("Insertar denominaciones conocidas menores a 10000 pesos.");
			int saldo = Integer.parseInt(IOUsuario.lecturaTeclado.readLine());
			if(controladorCliente.validarDenominacion(saldo)){
				if(controladorCliente.verificarDisponibilidadEnArca(saldo)){
					System.out.println("Se ha agregado el saldo.");
					controladorCliente.ingresarDineroEnLaMaquina(saldo);
					return;
				}else{
					System.out.println("No se puede recibir esta denominacion.");
					return;
				}
			}else{
				System.out.println("Denominacion incorrecta. Intenta nuevamente.");
				return;
			}
		} catch (Exception e) {
			System.out.println("Denominacion incorrecta intenta nuevamente.");
		}
		
	}

	private void listarProductosEnEspirales() {
		System.out.println("Los productos disponibles son:");
		List<Espiral> espirales = controladorCliente.obtenerEspiralesDisponibles();
		for (Iterator iterator = espirales.iterator(); iterator.hasNext();) {
			Espiral espiral = (Espiral) iterator.next();
			System.out.println(espiral.getFila()+""+espiral.getColumna()+" "+espiral.getProducto().getNombreProducto()+" $"+espiral.getProducto().getPrecioProducto()+" cant. "+espiral.getCantidad());
		}
	}

}
