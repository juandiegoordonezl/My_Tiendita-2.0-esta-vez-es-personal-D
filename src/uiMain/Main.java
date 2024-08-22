package uiMain;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import baseDatos.Deserializador;
import baseDatos.Serializador;
import gestorAplicación.servicios.*;
import gestorAplicación.servicios.Enums.Categoria;
import gestorAplicación.servicios.Enums.Edades;
import gestorAplicación.servicios.Enums.Genero;
import gestorAplicación.servicios.Enums.Tamaño;
import gestorAplicación.sujetos.*;

public class Main extends Identidad{
	public static void print(String p) {
		System.out.println(p);
	}
	
	public static void lineas() {
		for (int i=0;i<160;i++) {
			System.out.print("-");
		}
		print("");
	}
	public static Scanner sc = new Scanner(System.in);
	public static int escaner() {
		int p;
		try{
			p=sc.nextInt();
		}
		catch(Exception e) {
			print("Este no es un numero valido");
			System.out.print(" Introduzca otro numero: ");
			sc.nextLine();
			p=escaner();
		}
		return p;
	}
	
	public static int escaner(int rango) {
		int p;
		try{
			p=sc.nextInt();
		}
		catch(Exception e) {
			print("Este no es un numero valido");
			System.out.print(" Introduzca otro numero: ");
			sc.nextLine();
			p=escaner(rango);
		}
		if (p<1 || p>rango) {
			print("Este numero esta fuera del rango");
			System.out.print(" Introduzca otro numero: ");
			sc.nextLine();
			p=escaner(rango);
		}
		return p;
	}
	
	static int [] numeros = {1,2,3,4,5,6};
	static int decision;
//-----------------------------------------------------------------------------------------------------------
	public static void main(String[] args){
		Deserializador.deserializarListas();
//	/*	System.out.println(Tienda.getTiendas());
//		Tienda tienda= new Tienda("apilipona");
//		Cliente cliente = new Cliente(); 
//		Carrito carrito = new Carrito();
//		cliente.setEdad(18);
//		carrito.setCliente(cliente);
//		cliente.setCarrito(carrito);
//		Producto producto = new Producto("Cebolla","Cebollando",0,Categoria.ALIMENTO,tienda,"13/08/2024",1,Edades.MENORES,"",Tamaño.GRANDE);
//		producto.setTamaño(Tamaño.GRANDE);
//		Producto producto12 = new Producto("Cebolla","marquita1",0,Categoria.ALIMENTO,tienda,"13/08/2024",0,Edades.MENORES,"",Tamaño.GRANDE);
//		Producto producto13 = new Producto("Cebolla","marquita2",0,Categoria.ALIMENTO,tienda,"13/08/2024",-1,Edades.MENORES,"",Tamaño.GRANDE);
//		Producto producto14 = new Producto("Cebolla","marquita3",0,Categoria.ALIMENTO,tienda,"13/08/2024",-2,Edades.MENORES,"",Tamaño.GRANDE);
//		//Crear Empleados
//				Empleado juan =new Domiciliario();
//				Empleado pepe =new Domiciliario();
//				Empleado maria =new Domiciliario();
//				Empleado pedro =new Domiciliario();
//				ArrayList<Empleado> duo1= new ArrayList<Empleado>();
//				ArrayList<Empleado> duo2= new ArrayList<Empleado>();
//				duo1.add(juan);
//				duo1.add(pepe);
//				duo2.add(maria);
//				duo2.add(pedro);
//				
//				//Crear Pasillos
//				Pasillo p1 = new Pasillo("A7",Categoria.ALIMENTO);
//				Pasillo p2 = new Pasillo("A8",Categoria.BEBIDA);
//				Pasillo p3 = new Pasillo("A9",Categoria.LIMPIEZA);
//				Pasillo p4 = new Pasillo("A2",Categoria.PERSONAL);
//				Pasillo p5 = new Pasillo("A7",Categoria.HOGAR);
//				Pasillo p6 = new Pasillo("A7",Categoria.ELECTRONICO);
//				
//				// Crear Productos para cada categoria
//
//		//		Producto producto1 = new Producto("Pan",0, Categoria.ALIMENTO,2,Edades.MENORES,"",Tamaño.GRANDE);
//				Producto producto2 = new Producto("Leche", Categoria.BEBIDA);
//				Producto producto3 = new Producto("Detergente", Categoria.LIMPIEZA);
//				Producto producto4 = new Producto("Shampoo", Categoria.PERSONAL);
//				Producto producto5 = new Producto("Mesa", Categoria.HOGAR);
//				Producto producto6 = new Producto("Televisor", Categoria.ELECTRONICO);
//				Producto producto7 = new Producto("Café", Categoria.BEBIDA);
//
//		//		Producto producto8 = new Producto("Manzana",0, Categoria.ALIMENTO,3,Edades.MENORES,"",Tamaño.MEDIANO);
//
//				Producto producto9 = new Producto("Jabón", Categoria.PERSONAL);
//				Producto producto10 = new Producto("Escoba", Categoria.LIMPIEZA);
//	*/
//				// Crear clientes
//	//			Cliente clienteMayor = new Cliente("Ana", 12345, 25, Enums.Genero.M);
//	//			Cliente clienteMenor = new Cliente("Luis", 67890, 15, Enums.Genero.H);				
///*
//				// Crear productos para diferentes categorías y edades
//				Producto producto15 = new Producto("Cereal", "CerealBrand", 2.99, Categoria.ALIMENTO, 101, Enums.Edades.ADULTOS, "Cereal integral saludable",Tamaño.PEQUEÑO);
//				Producto producto16 = new Producto("Leche", "MilkBrand", 1.49, Categoria.BEBIDA, 102, Enums.Edades.MENORES, "Leche para niños",Tamaño.GRANDE);
//				Producto producto17 = new Producto("Jabón", "SoapBrand", 0.99, Categoria.LIMPIEZA, 103, Enums.Edades.ADULTOS, "Jabón de manos antibacterial",Tamaño.MEDIANO);
//				Producto producto18 = new Producto("Shampoo", "ShampooBrand", 4.99, Categoria.PERSONAL, 104, Enums.Edades.MENORES, "Shampoo suave para niños",Tamaño.PEQUEÑO);
//				Producto producto19 = new Producto("Silla", "ChairBrand", 29.99, Categoria.HOGAR, 105, Enums.Edades.ADULTOS, "Silla ergonómica",Tamaño.GRANDE);
//				Producto producto20 = new Producto("Televisor", "TVBrand", 299.99, Categoria.ELECTRONICO, 106, Enums.Edades.ADULTOS, "Televisor LED 40 pulgadas",Tamaño.GRANDE);
//				
//				
//				
//					// Crear listas para cada categoría
//				ArrayList<Producto> alimentos = new ArrayList<Producto>();
//				ArrayList<Producto> bebidas = new ArrayList<Producto>();
//				ArrayList<Producto> limpieza = new ArrayList<Producto>();
//				ArrayList<Producto> personal = new ArrayList<Producto>();
//				ArrayList<Producto> hogar = new ArrayList<Producto>();
//				ArrayList<Producto> electronico = new ArrayList<Producto>();
//
//				// Agregar productos a las listas correspondientes
//		//		alimentos.add(producto1);
//		//		alimentos.add(producto8);
//				alimentos.add(producto15);
//
//				bebidas.add(producto2);
//				bebidas.add(producto7);
//				bebidas.add(producto16);
//
//				limpieza.add(producto3);
//				limpieza.add(producto10);
//				limpieza.add(producto17);
//
//				personal.add(producto4);
//				personal.add(producto9);
//				personal.add(producto18);
//
//				hogar.add(producto5);
//				hogar.add(producto19);
//
//				electronico.add(producto6);
//				electronico.add(producto20);
//				
//				// Asignar las listas de productos a los pasillos correspondientes
//				p1.setProductos(alimentos);      // Pasillo A7 - Alimentos
//				p2.setProductos(bebidas);        // Pasillo A8 - Bebidas
//				p3.setProductos(limpieza);       // Pasillo A9 - Limpieza
//				p4.setProductos(personal);       // Pasillo A2 - Productos de cuidado personal
//				p5.setProductos(hogar);          // Pasillo A7 - Hogar
//				p6.setProductos(electronico);    // Pasillo A7 - Electrónicos
//
//
//				//Crear Tiendas
//				Tienda t1 = new Tienda();
//				Tienda t2= new Tienda();
//				Tienda t3 = new Tienda();
//				Tienda t4 = new Tienda();
//				
//				//Nombrar Tiendas y agregar pasillos y Empleados
//				t1.setNombre("Donde Chucho");
//				t2.setNombre("Los Paisitas");
//				t3.setNombre("La esquina de Luis");
//				t4.setNombre(" D1 ");
//				t1.agregarPasillo(p1);
//				t1.agregarPasillo(p2);
//				t2.agregarPasillo(p2);
//				t2.agregarPasillo(p3);
//				t3.agregarPasillo(p3);
//				t3.agregarPasillo(p4);
//				t4.agregarPasillo(p4);
//				t4.agregarPasillo(p5);
//				t1.agregarPasillo(p5);
//				t2.agregarPasillo(p6);
//				t3.agregarPasillo(p1);
//				t4.agregarPasillo(p2);
//				
//				t1.setEmpleados(duo1);
//				t2.setEmpleados(duo2);
//				t3.setEmpleados(duo1);
//		cliente.setTienda(tienda);
//		tienda.getPasillos().add(p1);
//		tienda.agregarProducto(producto, "A7");
//		tienda.agregarProducto(producto12, "A7");
//		tienda.agregarProducto(producto13, "A7");
//		tienda.agregarProducto(producto14, "A7");
//		ArrayList<Tienda> tiendas=new ArrayList<>();
//		tiendas.add(t1);
//		tiendas.add(t2);
//		tiendas.add(t3);
//		tiendas.add(t4);
//		
//		clienteMayor.getTiendas().add(t1);*/	
//		
////		 Tienda tienda = new Tienda("Supermercado Central");
////
////	        // Crear pasillo
////	        Pasillo pasillo1 = new Pasillo("Pasillo 1", Categoria.ALIMENTO);
////
////	        // Asignar el pasillo a la tienda
////	        pasillo1.asignarTienda(tienda);
////
////	        // Crear productos
////	        Producto producto1 = new Producto(
////	            "Leche Entera", "La Vaquita", 1.50, Tamaño.GRANDE, Edades.MENORES, Categoria.ALIMENTO,
////	            "Leche entera de vaca, fortificada con vitaminas A y D.", "15/10/2024", 101
////	        );
////	        Producto producto12 = new Producto(
////		            "Leche Entera", "La Vaquita", 1.50, Tamaño.GRANDE, Edades.MENORES, Categoria.ALIMENTO,
////		            "Leche entera de vaca, fortificada con vitaminas A y D.", "15/10/2024", 101
////		        );
////	        Producto producto13 = new Producto(
////		            "Leche Entera", "La Vaquita", 1.50, Tamaño.GRANDE, Edades.MENORES, Categoria.ALIMENTO,
////		            "Leche entera de vaca, fortificada con vitaminas A y D.", "15/10/2024", 101
////		        );
////
////	        Producto producto2 = new Producto(
////	            "Pan Integral", "PanRico", 2.00, Tamaño.MEDIANO, Edades.MENORES, Categoria.ALIMENTO,
////	            "Pan integral alto en fibra, ideal para una dieta saludable.", "22/08/2024", 102
////	        );
////
////	        Producto producto3 = new Producto(
////	            "Yogur Natural", "BioLácteos", 3.25, Tamaño.MEDIANO, Edades.ADULTOS, Categoria.ALIMENTO,
////	            "Yogur natural sin azúcar añadido, fuente de probióticos.", "10/09/2024", 103
////	        );
////
////	        Producto producto4 = new Producto(
////	            "Queso Cheddar", "La Gran Quesería", 4.50, Tamaño.MEDIANO, Edades.ADULTOS, Categoria.ALIMENTO,
////	            "Queso cheddar madurado, ideal para sandwiches y gratinados.", "30/09/2024", 104
////	        );
////
////	        Producto producto5 = new Producto(
////	            "Galletas de Avena", "Cerealia", 2.75, Tamaño.PEQUEÑO, Edades.MENORES, Categoria.ALIMENTO,
////	            "Galletas de avena y miel, perfectas para un snack saludable.", "05/11/2024", 105
////	        );
////	        
////	        
////	        Producto productoDevuelto1 = new Producto(
////		            "Queso Cheddar", "La Gran Quesería", 4.50, Tamaño.MEDIANO, Edades.ADULTOS, Categoria.ALIMENTO,
////		            "Queso cheddar madurado, ideal para sandwiches y gratinados.", "30/09/2024", 104
////		        );
////
////		        Producto productoDevuelto2 = new Producto(
////		            "Galletas de Avena", "Cerealia", 2.75, Tamaño.PEQUEÑO, Edades.MENORES, Categoria.ALIMENTO,
////		            "Galletas de avena y miel, perfectas para un snack saludable.", "05/11/2024", 105
////		        );
////	        
////		        Producto productoDevuelto3 = new Producto(
////			            "Leche Entera", "La Vaquita", 1.50, Tamaño.GRANDE, Edades.MENORES, Categoria.ALIMENTO,
////			            "Leche entera de vaca, fortificada con vitaminas A y D.", "15/10/2024", 101
////			        );
////		        
////		        tienda.getProductosDevueltos().add(productoDevuelto3);
////		        tienda.getProductosDevueltos().add(productoDevuelto2);
////		        tienda.getProductosDevueltos().add(productoDevuelto1);
////	        // Asignar productos al pasillo y a la tienda
////	        producto1.asignarPasilloYPonerEnTienda(pasillo1);
////	        producto12.asignarPasilloYPonerEnTienda(pasillo1);
////	        producto13.asignarPasilloYPonerEnTienda(pasillo1);
////	        producto2.asignarPasilloYPonerEnTienda(pasillo1);
////	        producto3.asignarPasilloYPonerEnTienda(pasillo1);
////	        producto4.asignarPasilloYPonerEnTienda(pasillo1);
////	        producto5.asignarPasilloYPonerEnTienda(pasillo1);
////
////	        
////	        // Asignar la tienda a los productos
////	        producto1.asignarTienda(tienda);
////	        producto12.asignarTienda(tienda);
////	        producto13.asignarTienda(tienda);
////	        producto2.asignarTienda(tienda);
////	        producto3.asignarTienda(tienda);
////	        producto4.asignarTienda(tienda);
////	        producto5.asignarTienda(tienda);
////
////	        // Imprimir detalles para verificar la asignación
////	        for (Producto p : pasillo1.getProductos()) {
////	            System.out.println("Producto: " + p.getNombre() + ", Marca: " + p.getMarca() + ", Precio: $" + p.getPrecio() +
////	                               ", Tamaño: " + p.getTamaño() + ", Categoria Edad: " + p.getEdades() +
////	                               ", Categoria Alimento: " + p.getCategoria() + ", ID: " + p.getId() +
////	                               ", Descripción: " + p.getDescripcion() + ", Fecha de Perecer: " + p.getFechaPerecer() +
////	                               ", Pasillo: " + pasillo1.getNombre() + ", Tienda: " + tienda.getNombre());
////	        }
////	       Empleado empleado=new Cajero();
////	  //     Persona.getPersonas().get(0).getTiendas().add(tienda);
////	       tienda.getEmpleados().add(empleado);
////	       Administrador admin = new Administrador("Juan",54321,26,Enums.Genero.M);
////	       Cliente pepe =new Cliente("pepe",9876,18,Enums.Genero.M);
////	       admin.getTiendas().add(tienda);
////	       Carrito carrito1 = new Carrito();
////	       Carrito carrito2 = new Carrito();
////	       Carrito carrito3 = new Carrito();
////	       Carrito carrito4 = new Carrito();
////	       carrito1.getProductos().add(producto1);
////	       carrito1.getProductos().add(producto12);
////	       carrito1.getProductos().add(producto13);
////	       carrito2.getProductos().add(producto4);
////	       carrito2.getProductos().add(producto2);
////	       carrito2.getProductos().add(producto3);
////	       carrito1.getProductos().add(producto5);
////	       carrito3.getProductos().add(producto1);
////	       carrito3.getProductos().add(producto12);
////	       carrito4.getProductos().add(producto4);
////	       carrito4.getProductos().add(producto2);
////	       
////	       for (Tienda tiendas : admin.getTiendas() ) {
////	    	   tiendas.getFacturas().add(carrito1);
////	    	   tiendas.getFacturas().add(carrito2);
////	    	   carrito1.setTienda(tiendas);
////	    	   carrito2.setTienda(tiendas);
////	       }
////	       
////	       pepe.getFacturas().add(carrito3);
////	       pepe.getFacturas().add(carrito4);
////	       carrito3.setTienda(tienda);
////	       carrito4.setTienda(tienda);
////	       carrito3.setCliente(pepe);
////	       carrito4.setCliente(pepe);
////	       Producto producto1 = new Producto(
////		            "Leche Entera", "La Vaquita", 1.50, Tamaño.GRANDE, Edades.MENORES, Categoria.ALIMENTO,
////		            "Leche entera de vaca, fortificada con vitaminas A y D.", "15/10/2024", 101
////		        );
////		Producto producto12 = new Producto(
////		            "Leche Entera", "La Vaquita", 1.50, Tamaño.GRANDE, Edades.MENORES, Categoria.ALIMENTO,
////		            "Leche entera de vaca, fortificada con vitaminas A y D.", "15/10/2024", 101
////		        );
////	        Producto producto13 = new Producto(
////		            "Leche Entera", "La Vaquita", 1.50, Tamaño.GRANDE, Edades.MENORES, Categoria.ALIMENTO,
////		            "Leche entera de vaca, fortificada con vitaminas A y D.", "15/10/2024", 101
////		        );
////
////	        Producto producto2 = new Producto(
////	            "Pan Integral", "PanRico", 2.00, Tamaño.MEDIANO, Edades.MENORES, Categoria.ALIMENTO,
////	            "Pan integral alto en fibra, ideal para una dieta saludable.", "22/08/2024", 102
////	        );
////
////	        Producto producto3 = new Producto(
////	            "Yogur Natural", "BioLácteos", 3.25, Tamaño.MEDIANO, Edades.ADULTOS, Categoria.ALIMENTO,
////	            "Yogur natural sin azúcar añadido, fuente de probióticos.", "10/09/2024", 103
////	        );
////
////	        Producto producto4 = new Producto(
////	            "Queso Cheddar", "La Gran Quesería", 4.50, Tamaño.MEDIANO, Edades.ADULTOS, Categoria.ALIMENTO,
////	            "Queso cheddar madurado, ideal para sandwiches y gratinados.", "30/09/2024", 104
////	        );
////
////	        Producto producto5 = new Producto(
////	            "Galletas de Avena", "Cerealia", 2.75, Tamaño.PEQUEÑO, Edades.MENORES, Categoria.ALIMENTO,
////	            "Galletas de avena y miel, perfectas para un snack saludable.", "05/11/2024", 105
////	        );
////	        ArrayList<Tienda> t=new ArrayList<>();
////	        ArrayList<Producto> entrega=new ArrayList<>();
////	     new Domiciliario("Pablo",10101,20,Genero.H,100000,null,true,true,true,"moto");
////	     new Cajero("Carlos", 3030, 30, Genero.M, 25000, null, true, true);
////	     new Conserje("Sara",1313,21,Genero.M,100000,null,true,false);
//		// Cajero
////		new Cajero("Javier", 4040, 25, Genero.H, 30000, null, true, false, 5,null);
////		new Cajero("Elena", 5050, 26, Genero.M, 28000, null, false, true, 6,null);
////		new Cajero("Fernando", 6060, 24, Genero.H, 29000, null, true, true, 4,null);
////		new Cajero("Sofía", 7070, 27, Genero.M, 31000, null, true, false, 7 ,null);
////		new Cajero("Miguel", 8080, 29, Genero.H, 27000, null, false, true, 8,null);
////		
////		new Conserje("Ana", 1616, 26, Genero.M, 90000, null, false, true, 7);  // Cumple
////		new Conserje("Luis", 2020, 27, Genero.H, 95000, null, true, false, 8);  // Cumple
////		new Conserje("Carmen", 5050, 30, Genero.M, 94000, null, true, false, 9); // Cumple
////		new Conserje("Rosa", 6060, 28, Genero.H, 96000, null, true, true, 3);  
////		new Conserje("Julia", 3030, 24, Genero.M, 92000, null, true, true, 10); 
////		Cliente cliente1 = new Cliente("Carlos", 11001, 30, Genero.H, 50000, null); // Hombre
////		Cliente cliente2 = new Cliente("Ana", 22002, 25, Genero.M, 60000, null);   // Mujer
////		Cliente cliente3 = new Cliente("Luis", 33003, 35, Genero.H, 70000, null); // Hombre
////		Cliente cliente4 = new Cliente("Maria", 44004, 28, Genero.M, 80000, null); // Mujer
////		Cliente cliente5 = new Cliente("Jorge", 55005, 40, Genero.H, 90000, null); 
//
//		Producto producto1 = new Producto(
//	            "Leche Entera", "La Vaquita", 1.50, Tamaño.GRANDE, Edades.MENORES, Categoria.ALIMENTO,
//	            "Leche entera de vaca, fortificada con vitaminas A y D.", "15/10/2024", 101
//	        );
//	Producto producto12 = new Producto(
//	            "Leche Entera", "La Vaquita", 1.50, Tamaño.GRANDE, Edades.MENORES, Categoria.ALIMENTO,
//	            "Leche entera de vaca, fortificada con vitaminas A y D.", "15/10/2024", 101
//	        );
//        Producto producto13 = new Producto(
//	            "Leche Entera", "La Vaquita", 1.50, Tamaño.GRANDE, Edades.MENORES, Categoria.ALIMENTO,
//	            "Leche entera de vaca, fortificada con vitaminas A y D.", "15/10/2024", 101
//	        );
//
//        Producto producto2 = new Producto(
//            "Pan Integral", "PanRico", 2.00, Tamaño.MEDIANO, Edades.MENORES, Categoria.ALIMENTO,
//            "Pan integral alto en fibra, ideal para una dieta saludable.", "22/08/2024", 102
//        );
//
//        Producto producto3 = new Producto(
//            "Yogur Natural", "BioLácteos", 3.25, Tamaño.MEDIANO, Edades.ADULTOS, Categoria.ALIMENTO,
//            "Yogur natural sin azúcar añadido, fuente de probióticos.", "10/09/2024", 103
//        );
//
//        Producto producto4 = new Producto(
//            "Queso Cheddar", "La Gran Quesería", 4.50, Tamaño.MEDIANO, Edades.ADULTOS, Categoria.ALIMENTO,
//            "Queso cheddar madurado, ideal para sandwiches y gratinados.", "30/09/2024", 104
//        );
//
//        Producto producto5 = new Producto(
//            "Galletas de Avena", "Cerealia", 2.75, Tamaño.PEQUEÑO, Edades.MENORES, Categoria.ALIMENTO,
//            "Galletas de avena y miel, perfectas para un snack saludable.", "05/11/2024", 105
//        );
//     ArrayList<Tienda> t=new ArrayList<Tienda>();
//     ArrayList<Producto> entrega=new ArrayList<>();
////     new Domiciliario("Pablo",10101,20,Genero.H,100000,null,true,true,true,"moto");
////     new Cajero("Carlos", 3030, 30, Genero.M, 25000, null, true, true);
////     new Conserje("Sara",1313,21,Genero.M,100000,null,true,false);
////	new Cajero("Javier", 4040, 25, Genero.H, 30000, null, true, false, 5,null);
////	new Cajero("Elena", 5050, 26, Genero.M, 28000, null, false, true, 6,null);
////	new Cajero("Fernando", 6060, 24, Genero.H, 29000, null, true, true, 4,null);
////	new Cajero("Sofía", 7070, 27, Genero.M, 31000, null, true, false, 7 ,null);
////	new Cajero("Miguel", 8080, 29, Genero.H, 27000, null, false, true, 8,null);
////	
////	new Conserje("Ana", 1616, 26, Genero.M, 90000, null, false, true, 7);  // Cumple
////	new Conserje("Luis", 2020, 27, Genero.H, 95000, null, true, false, 8);  // Cumple
////	new Conserje("Carmen", 5050, 30, Genero.M, 94000, null, true, false, 9); // Cumple
////	new Conserje("Rosa", 6060, 28, Genero.H, 96000, null, true, true, 3);  
////	new Conserje("Julia", 3030, 24, Genero.M, 92000, null, true, true, 10); 
//	Cliente cliente1 = new Cliente("Carlos", 11001, 30, Genero.H, 50000, null); // Hombre
//	Cliente cliente2 = new Cliente("Ana", 22002, 25, Genero.M, 60000, null);   // Mujer
//	Cliente cliente3 = new Cliente("Luis", 33003, 35, Genero.H, 70000, null); // Hombre
//	Cliente cliente4 = new Cliente("Maria", 44004, 28, Genero.M, 80000, null); // Mujer
//	Cliente cliente5 = new Cliente("Jorge", 55005, 40, Genero.H, 90000, null); 
//	Administrador adm=new Administrador("Bob", 9898, 20, Genero.H, 20000);
//	
//	Cliente cliente1 = (Cliente) Persona.getPersonas().get(0);
//	Cliente cliente2 = (Cliente) Persona.getPersonas().get(1);
//	Cliente cliente3 = (Cliente) Persona.getPersonas().get(2);
//	Cliente cliente4 = (Cliente) Persona.getPersonas().get(3);
//	Cliente cliente5 = (Cliente) Persona.getPersonas().get(4);
//
//	// Crear carritos con diferentes configuraciones
//	Carrito car1 = new Carrito(cliente1, false, null, Edades.MENORES);
//	Carrito car2 = new Carrito(cliente2, true, null, Edades.ADULTOS);
//	Carrito car3 = new Carrito(cliente3, false, null, Edades.ADULTOS);
//	Carrito car4 = new Carrito(cliente4, true, null, Edades.MENORES);
//	Carrito car5 = new Carrito(cliente5, false, null, Edades.MENORES);
//	Tienda t=new Tienda("NIT123456", adm, "Exito", 1000000, "abierto",car1, null, null, null, null, null);
//	Tienda.getTiendas().add(t);
//		Tienda t1 = new Tienda();
//		Tienda t2= new Tienda();
//		Tienda t3 = new Tienda();
//		Tienda t4 = new Tienda();
//		Tienda t5 = new Tienda();
//		Tienda t6= new Tienda();
//		Tienda t7 = new Tienda();
//		Tienda t8 = new Tienda();
		Tienda.getTiendas().get(1).setNombre("La Esquina");
		Tienda.getTiendas().get(2).setNombre("El Rincón");
		Tienda.getTiendas().get(3).setNombre("La Cima");
		Tienda.getTiendas().get(4).setNombre("La Nueva");
		Tienda.getTiendas().get(5).setNombre("El Refugio");
		Tienda.getTiendas().get(6).setNombre("La Aventura");
		Tienda.getTiendas().get(7).setNombre("El Paseo");
		
		Tienda.getTiendas().get(0).setEstado("abierto");
		Tienda.getTiendas().get(1).setEstado("cerrado");
		Tienda.getTiendas().get(2).setEstado("abierto");
		Tienda.getTiendas().get(3).setEstado("cerrado");
		Tienda.getTiendas().get(4).setEstado("abierto");
		Tienda.getTiendas().get(5).setEstado("abierto");
		Tienda.getTiendas().get(6).setEstado("abierto");
		Tienda.getTiendas().get(7).setEstado("cerrado");
		
		Tienda.getTiendas().get(0).setNit("32112");
		Tienda.getTiendas().get(1).setNit("65432");
		Tienda.getTiendas().get(2).setNit("98765");
		Tienda.getTiendas().get(3).setNit("12345");
		Tienda.getTiendas().get(4).setNit("67890");
		Tienda.getTiendas().get(5).setNit("11223");
		Tienda.getTiendas().get(6).setNit("44556");
		Tienda.getTiendas().get(7).setNit("77889");
		
		Tienda.getTiendas().get(0).setSaldo(100000);
		Tienda.getTiendas().get(1).setSaldo(102000);
		Tienda.getTiendas().get(2).setSaldo(98000);
		Tienda.getTiendas().get(3).setSaldo(99500);
		Tienda.getTiendas().get(4).setSaldo(101500);
		Tienda.getTiendas().get(5).setSaldo(100500);
		Tienda.getTiendas().get(6).setSaldo(98000);
		Tienda.getTiendas().get(7).setSaldo(99000);
        
		for(int i=0;i>8;i++) {
		Tienda.getTiendas().get(i).setCajas((ArrayList<Caja>) List.of(
	            new Caja(),
	            new Caja(),
	            new Caja()));
		}
		
		for(int i=0;i>5;i++) {
			Tienda.getTiendas().get(i).setDueño(new Administrador());
			}
		for(int i=4;i>8;i++) {
			Tienda.getTiendas().get(i).setDueño(null);
			}
		for(int i=4;i>8;i++) {
			Tienda.getTiendas().get(i).setCarrito(new Carrito());
			}
		for(int i=0;i>8;i++) {
		Tienda.getTiendas().get(i).setEmpleados((ArrayList<Empleado>) List.of(
	            new Cajero(),
	            new Domiciliario(),
	            new Conserje()));
		}
		for(int i=0;i>8;i++) {
		Tienda.getTiendas().get(i).setFacturas((ArrayList<Carrito>) List.of(
	            new Carrito(),
	            new Carrito(),
	            new Carrito(),
	            new Carrito()));
		}
		for(int i=0;i>8;i++) {
			Tienda.getTiendas().get(i).setPasillos(((ArrayList<Pasillo>) List.of(
		           new Pasillo(),
		           new Pasillo(),
		           new Pasillo(),
		           new Pasillo(),
		           new Pasillo(),
		           new Pasillo())));
			}
//		for(int i=0;i>8;i++) {
//			Tienda.getTiendas().get(0).set(((ArrayList<Pasillo>) List.of(
//		           new Pasillo(),
//		           new Pasillo(),
//		           new Pasillo(),
//		           new Pasillo(),
//		           new Pasillo(),
//		           new Pasillo()))));
//			}
		
		
	Serializador.serializarTodo();	
//	escogerFuncionalidad();
	}
	
	public static void escogerFuncionalidad() {
		do{
			Scanner sc=new Scanner(System.in);
			boolean boleano=false;
			lineas();
			print("""
				    ______________________________
				   /  /  /   /   /   /   /   /   /|
				  /  /  /   /   /   /   /   /   / |
				 /__/__/___/___/___/___/___/___/__| 
				 |  ______            ______  |   | 
				 | |      |          |      | |   |
				 | |      |          |      | |   |     My_Tiendita
				 | |______|          |______| |   |
				 |            ____            |   |
				 |           |    |           |   |
				 |           |    |           |   /
				 |___________|____|___________|__/
				    """);
			lineas();
			print("Bienvenido a My_Tiendita, ¿que desea hacer?");
			print("");
			print(" 1. Ecosistema de Consultas Personalizadas\n"
					+ " 2. Escoger productos\n"
					+ " 3. Pagar recibos pendientes\n"
					+ " 4. Revisar tienda\n"
					+ " 5. Personalizar y modificar tiendas\n"
					+ " 6. Terminar");
			print("");
			System.out.print("Escoja un numero: ");
			while (!boleano){
				try{
					decision=sc.nextInt();
				}
				catch(Exception e) {
					print(" Este no es un numero valido");
					System.out.print(" Introduzca otro numero: ");
					sc.nextLine();
					continue;
				}
				for (int i:numeros){
					 if (decision==i){
					        boleano=true;
					 }
				}
				if (boleano==false){
					 print(" El numero esta fuera del rango");
					 System.out.print(" Introduzca otro numero: ");
					 continue;
				}
			}
			
			switch(decision){
			case 1:
				Funcionalidad1.consultasEco();
				break;
			case 2:
				Cliente cliente=(Cliente)identificarPersona();
				Funcionalidad2.elegirTipoBusqueda(cliente);
				break;
			case 3:
				
				Funcionalidad3.impresionFacturas();
				break;
			case 4:
				Funcionalidad4.seleccionTienda();
				break;
			case 5:
				Administrador admin=(Administrador)(Persona)identificarPersona();
				Funcionalidad5.personalizarTienda(admin);
				break;
			case 6:
				Serializador.serializarTodo();
				print("Ha salido del programa");
				System.exit(0);
				break;
			}
		 } while (decision!=6);

		}

}
