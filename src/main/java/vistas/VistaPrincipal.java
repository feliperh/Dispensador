package vistas;

import controladores.ControladorAdministrador;
import controladores.ControladorCliente;
import herramientas.IOUsuario;
/**
 * Hello world!
 *
 */
public class VistaPrincipal 
{
	private VistaCliente vistaCliente;
	private VistaAdministrador VistaAdministrador;
	private static boolean controlMenu;
	
    public VistaPrincipal(ControladorAdministrador controladorAdministrador, ControladorCliente controladorCliente) {
    	this.vistaCliente = new VistaCliente(controladorCliente);
    	this.VistaAdministrador = new VistaAdministrador(controladorAdministrador);
	}

	public void cargarVistaPrincipal()
    {
    	controlMenu = true;
    	System.out.println( "\nMAQUINA DE CHUCHERIAS" );
        System.out.println( "\nBIENVENIDO" );
    	while(controlMenu){
            System.out.println( "\nMENU PRINCIPAL:" );
            System.out.println( "------------------------------------------------------------" );
            System.out.println( "1. Cliente." );
            System.out.println( "2. Administrador." );
            System.out.println( "3. Salir." );
            try {
            	int opcion = Integer.parseInt(IOUsuario.lecturaTeclado.readLine());

                switch (opcion) {
        		case 1:
        			vistaCliente.ingresarVistaCliente();
        			break;
        		case 2:
        			VistaAdministrador.ingresarVistaAdministrador();
        			break;
        		case 3:
        			controlMenu = false;
        			System.out.println("\nHasta pronto.");
        			break;
        		default:
        			System.out.println( "\nIntenta nuevamente." );
        			break;
        		}

    		} catch (Exception e) {
    			System.out.println( "\n¡Digita un entero por favor!" );
    		}
      	}       
    }
}
