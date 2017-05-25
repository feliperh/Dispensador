package vistas;

import java.util.Iterator;
import java.util.List;
import controladores.ControladorAdministrador;
import herramientas.IOUsuario;
import vo.Arca;
import vo.Espiral;
import vo.Producto;

public class VistaAdministrador {
	
	private ControladorAdministrador controladorAdministrador;
	private boolean controlMenu;

	public VistaAdministrador(ControladorAdministrador controladorAdministrador) {
		this.controladorAdministrador = controladorAdministrador;
	}
	
	public void ingresarVistaAdministrador(){
		controlMenu = true;
    	while(controlMenu){
            System.out.println( "\nMENU ADMINISTRADOR:" );
            System.out.println( "1. Cambiar Servicio." );
            System.out.println( "2. Agregar Producto" );
            System.out.println( "3. Agregar Espiral." );
            System.out.println( "4. Agregar Arca." );
            System.out.println( "5. Listar Productos." );
            System.out.println( "6. Listar Espirales." );
            System.out.println( "7. Listar Arca." );
            System.out.println( "8. Modificar espirales." );
            System.out.println( "9. Modificar Arca." );
            System.out.println( "10. Salir." );
            try {
            	int opcion = Integer.parseInt(IOUsuario.lecturaTeclado.readLine());

                switch (opcion) {
        		case 1:
        			cambiarServicio();
        			break;
        		case 2:
        			seSeleccionaLaOpcion2EnElAdministrador();
        			break;
        		case 3:
        			seSeleccionaLaOpcion3EnElAdministrador();
        			break;
        		case 4:
        			seSeleccionaLaOpcion4EnElAdministrador();
        			break;
        		case 5:
        			seSeleccionaLaOpcion5EnElAdministrador();
        			break;
        		case 6:
        			seSeleccionaLaOpcion6EnElAdministrador();
        			break;
        		case 7:
        			seSeleccionaLaOpcion7EnElAdministrador();
        			break;
        		case 8:
        			seSeleccionaLaOpcion8EnElAdministrador();
        			break;
        		case 9:
        			seSeleccionaLaOpcion9EnElAdministrador();
        			break;
        		case 10:
        			System.out.println("sale");
        			controlMenu = false;
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
	
	private void seSeleccionaLaOpcion2EnElAdministrador(){
		if(!controladorAdministrador.getMaquina().isFueraDeServicio()){
			System.out.println("La maquina esta en servicio.");
			System.out.println("Para utilizar esta opción cambia a fuera de servicio.");
		}else{
			agregarProducto();
		}
	}
	
	private void seSeleccionaLaOpcion3EnElAdministrador(){
		if(!controladorAdministrador.getMaquina().isFueraDeServicio()){
			System.out.println("La maquina esta en servicio.");
			System.out.println("Para utilizar esta opción cambia a fuera de servicio.");
		}else{
			agregarEspiral();
		}

	}
	
	private void seSeleccionaLaOpcion4EnElAdministrador(){
		if(!controladorAdministrador.getMaquina().isFueraDeServicio()){
			System.out.println("La maquina esta en servicio.");
			System.out.println("Para utilizar esta opción cambia a fuera de servicio.");
		}else{
			agregarArca();
		}
	}
	
	private void seSeleccionaLaOpcion5EnElAdministrador(){
		if(!controladorAdministrador.getMaquina().isFueraDeServicio()){
			System.out.println("La maquina esta en servicio.");
			System.out.println("Para utilizar esta opción cambia a fuera de servicio.");
		}else{
			listarProductosDisponibles();
		}
	}
	
	private void seSeleccionaLaOpcion6EnElAdministrador(){
		if(!controladorAdministrador.getMaquina().isFueraDeServicio()){
			System.out.println("La maquina esta en servicio.");
			System.out.println("Para utilizar esta opción cambia a fuera de servicio.");
		}else{
			listarEspirales();
		}
	}
	
	private void seSeleccionaLaOpcion7EnElAdministrador(){
		if(!controladorAdministrador.getMaquina().isFueraDeServicio()){
			System.out.println("La maquina esta en servicio.");
			System.out.println("Para utilizar esta opción cambia a fuera de servicio.");
		}else{
			listarArca();
		}
	}
	
	private void seSeleccionaLaOpcion8EnElAdministrador(){
		if(!controladorAdministrador.getMaquina().isFueraDeServicio()){
			System.out.println("La maquina esta en servicio.");
			System.out.println("Para utilizar esta opción cambia a fuera de servicio.");
		}else{
			modificarEspirales();
		}
	}
	
	private void seSeleccionaLaOpcion9EnElAdministrador(){
		if(!controladorAdministrador.getMaquina().isFueraDeServicio()){
			System.out.println("La maquina esta en servicio.");
			System.out.println("Para utilizar esta opción cambia a fuera de servicio.");
		}else{
			modificarArca();
		}
	}

	private void listarArca() {
		System.out.println("Listado de arcas");
		List<Arca> arcas = controladorAdministrador.obtenerArcas();
		for (Iterator iterator = arcas.iterator(); iterator.hasNext();) {
			Arca arca = (Arca) iterator.next();
			System.out.println(arca.getNombre()+" "+arca.getValorMoneda()+" "+arca.getCantidad());
		}
		
	}

	private void modificarArca() {
		System.out.println("Editar arca");
		List<Arca> arcas = controladorAdministrador.obtenerArcas();
		if(arcas.isEmpty()){
			System.out.println("No hay arcas.");
			return;
		}	
		for (int i = 0; i < arcas.size(); i++) {
			System.out.println("arca "+i+" "+arcas.get(i).getNombre()+" "+arcas.get(i).getCantidad());
		}
		System.out.println("Seleccion un arca. Digita su numero respectivo.");
		try {
			int arcaIdentificador = Integer.parseInt(IOUsuario.lecturaTeclado.readLine());
			Arca arca = controladorAdministrador.obtenerArcaPorIndice(arcaIdentificador);
			if(arca==null){
				System.out.println("Identificador de arca invalido.");
				return;
			}
			System.out.println("Digita el nombre del arca");
			String nombre = IOUsuario.lecturaTeclado.readLine();
			System.out.println("Digita el valor del arca.");
			int valorDenominacion = Integer.parseInt(IOUsuario.lecturaTeclado.readLine());
			System.out.println("Digita la cantidad");
			int cantidad = Integer.parseInt(IOUsuario.lecturaTeclado.readLine());
			Arca arcaModificada = new Arca(nombre, valorDenominacion, cantidad);
			if(controladorAdministrador.editarArca(arcaIdentificador,arcaModificada))
				System.out.println("Arca editada.");
			else
				System.out.println("Error en cantidad o valor denominacion.");
		} catch (Exception e) {
			System.out.println("digita valores enteros para la denominacion, cantidad e indice.");
		}
		
	}

	private void agregarArca() {
		boolean controlCiclo = true;
		System.out.println("Agregar Arca.");		
		while(controlCiclo){
			try {
				System.out.println("Digita el nombre de la denominacion.");
				String nombre = IOUsuario.lecturaTeclado.readLine();
				System.out.println("Digita el valor.");
				int valor = Integer.parseInt(IOUsuario.lecturaTeclado.readLine());
				System.out.println("Digita la cantidad");
				int cantidad = Integer.parseInt(IOUsuario.lecturaTeclado.readLine());
				
				if (controladorAdministrador.agregarArca(nombre,valor,cantidad)) {
					System.out.println("Arca agregada.");
					controlCiclo=false;
				}else{
					System.out.println("No se creo el arca. Intenta otra vez");
				}
			} catch (Exception e) {
				System.out.println("Digita valor de moneda divisible por 50 no negativo.");
			}
		}
		
	}

	private void modificarEspirales() {
		boolean controlCiclo = true;
		System.out.println("Modificar espiral.");		
		while(controlCiclo){
			try {
				System.out.println("Digita la fila (letra).");
				char fila = IOUsuario.lecturaTeclado.readLine().charAt(0);
				System.out.println("Digita la columna.");
				int columna = Integer.parseInt(IOUsuario.lecturaTeclado.readLine());
				
				Espiral espiral = controladorAdministrador.obtenerEspiralPorFilaYColumna(fila,columna);
				
				if(espiral==null){
					System.out.println("La espiral no existe.");
					return;
				}
				System.out.println("La espiral a modificar es:");
				System.out.println(espiral.getFila()+" "+espiral.getColumna()+" "+espiral.getProducto().getNombreProducto()+" "+espiral.getCantidad());
				System.out.println("Digita el nombre del producto nuevo.");
				
				String nombre = IOUsuario.lecturaTeclado.readLine();
				Producto producto = controladorAdministrador.obtenerProducto(nombre);
				
				if(producto==null){
					System.out.println("No se ha encontrado el producto.");
					return;
				}
				
				System.out.println("Digita la cantidad de nuevo producto");
				int cantidad = Integer.parseInt(IOUsuario.lecturaTeclado.readLine());
				
				if (controladorAdministrador.editarEspiral(fila, columna, producto,cantidad)) {
					System.out.println("Has editado la espiral.");
				}else{
					System.out.println("Error en cantidad, no la as editado.");
				}
				
				controlCiclo=false;
			} catch (Exception e) {
				System.out.println("Digita entero para cantidad y columna, caracter para fila.");
			}
		}
		
	}

	private void listarEspirales() {
		System.out.println("Las espirales son:");
		List<Espiral> espirales = controladorAdministrador.listarTodasLasEspirales();
		for (Iterator iterator = espirales.iterator(); iterator.hasNext();) {
			Espiral espiral = (Espiral) iterator.next();
			System.out.println(espiral.getFila()+" "+espiral.getColumna()+" "+espiral.getProducto().getNombreProducto()+" "+espiral.getCantidad());
		}
	}

	private void listarProductosDisponibles() {
		System.out.println("Los productos disponibles son:");
		List<Producto> productos = controladorAdministrador.listarTodosLosProductos();
		for (Iterator iterator = productos.iterator(); iterator.hasNext();) {
			Producto producto = (Producto) iterator.next();
			System.out.println(producto.getNombreProducto()+" "+producto.getPrecioProducto());
		}
	}

	private void agregarEspiral() {
		boolean controlCiclo = true;
		System.out.println("Agregar Espiral a la maquina.");		
		while(controlCiclo){
			try {
				System.out.println("Digita el nombre del producto a ingresar en la espiral.");
				String nombre = IOUsuario.lecturaTeclado.readLine().toLowerCase();
				Producto producto = controladorAdministrador.obtenerProducto(nombre);
				if(producto==null){
					System.out.println("El producto no existe.");
					return;
				}
				System.out.println("Digita la cantidad.");
				int cantidad = Integer.parseInt(IOUsuario.lecturaTeclado.readLine());
				System.out.println("Digita la fila (letra).");
				char fila = IOUsuario.lecturaTeclado.readLine().charAt(0);
				System.out.println("Digita la columna.");
				int columna = Integer.parseInt(IOUsuario.lecturaTeclado.readLine());
				if(controladorAdministrador.agregarEspiralALaMaquina(new Espiral(producto, cantidad, fila, columna))){
					System.out.println("Espiral agregado correctamente.");
				}else{
					System.out.println("Fila debe ser una letra y columna de 0 a 99");
				}
				controlCiclo=false;
			} catch (Exception e) {
				System.out.println("Digita entero para cantidad y columna, caracter para fila.");
			}
		}
	}

	private void agregarProducto() {
		boolean controlCiclo = true;
		System.out.println("Agregar Producto a la maquina.");		
		while(controlCiclo){
			try {
				System.out.println("Digita el nombre del producto.");
				String nombre = IOUsuario.lecturaTeclado.readLine().toLowerCase();
				System.out.println("Digita el precio del producto.");
				int precio = Integer.parseInt(IOUsuario.lecturaTeclado.readLine());
				if(controladorAdministrador.agregarProductoALaMaquina(new Producto(nombre, precio))){
					System.out.println("Producto agregado correctamente.");
				}else{
					System.out.println("No se puede repetir o precio debe ser divisible por 50");
				}
				controlCiclo=false;
			} catch (Exception e) {
				System.out.println("El precio es entero.");
			}
		}
		
	}

	private void cambiarServicio() {
		boolean controlCiclo = true;
		System.out.println("Estado actual de la maquina: fuera de servicio = ");
		System.out.println(controladorAdministrador.getMaquina().isFueraDeServicio());
		while(controlCiclo){
			System.out.println("¿Desea cambiar el estado? s o n");
			try {
				char opcion = IOUsuario.lecturaTeclado.readLine().charAt(0);
				if(opcion == 's'){
					controladorAdministrador.maquinaCambiarEstado();
					System.out.println("El estado ha cambiado a:");
					System.out.println(controladorAdministrador.maquinaIsFueraDeServicio());
					return;
				}
				if(opcion == 'n'){
					System.out.println("El estado no se ha cambiado:");
					return;
				}
			} catch (Exception e) {
				System.out.println("Intenta nuevamente.");
			}
		}
	}
}
