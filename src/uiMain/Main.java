package uiMain;
import java.time.LocalDate;
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
import gestorAplicación.servicios.Enums.TipoCaja;
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
//	public static void generarPasillosYProductos() {
//	    ArrayList<Tienda> tiendas = Tienda.getTiendas();
//
//	    for (int i = 0; i < tiendas.size(); i++) {
//	        Tienda tienda = tiendas.get(i);
//	        
//	        // Crear pasillos con productos para cada tienda
//	        switch (i) {
//	            case 0: // Tienda 1
//	                crearPasilloConProductos(tienda, "Pasillo Alimentos", Categoria.ALIMENTO, generarProductosAlimentos());
//	                crearPasilloConProductos(tienda, "Pasillo Bebidas", Categoria.BEBIDA, generarProductosBebidas());
//	                break;
//	                
//	            case 1: // Tienda 2
//	                crearPasilloConProductos(tienda, "Pasillo Limpieza", Categoria.LIMPIEZA, generarProductosLimpieza());
//	                crearPasilloConProductos(tienda, "Pasillo Personal", Categoria.PERSONAL, generarProductosPersonal());
//	                break;
//	                
//	            case 2: // Tienda 3
//	                crearPasilloConProductos(tienda, "Pasillo Hogar", Categoria.HOGAR, generarProductosHogar());
//	                crearPasilloConProductos(tienda, "Pasillo Electrónico", Categoria.ELECTRONICO, generarProductosElectronicos());
//	                break;
//	                
//	            case 3: // Tienda 4
//	                crearPasilloConProductos(tienda, "Pasillo Alimentos", Categoria.ALIMENTO, generarProductosAlimentos());
//	                crearPasilloConProductos(tienda, "Pasillo Hogar", Categoria.HOGAR, generarProductosHogar());
//	                break;
//	                
//	            case 4: // Tienda 5
//	                crearPasilloConProductos(tienda, "Pasillo Bebidas", Categoria.BEBIDA, generarProductosBebidas());
//	                crearPasilloConProductos(tienda, "Pasillo Electrónico", Categoria.ELECTRONICO, generarProductosElectronicos());
//	                break;
//	                
//	            case 5: // Tienda 6
//	                crearPasilloConProductos(tienda, "Pasillo Limpieza", Categoria.LIMPIEZA, generarProductosLimpieza());
//	                crearPasilloConProductos(tienda, "Pasillo Personal", Categoria.PERSONAL, generarProductosPersonal());
//	                break;
//	                
//	            case 6: // Tienda 7
//	                crearPasilloConProductos(tienda, "Pasillo Alimentos", Categoria.ALIMENTO, generarProductosAlimentos());
//	                crearPasilloConProductos(tienda, "Pasillo Bebidas", Categoria.BEBIDA, generarProductosBebidas());
//	                break;
//	                
//	            case 7: // Tienda 8
//	                crearPasilloConProductos(tienda, "Pasillo Hogar", Categoria.HOGAR, generarProductosHogar());
//	                crearPasilloConProductos(tienda, "Pasillo Electrónico", Categoria.ELECTRONICO, generarProductosElectronicos());
//	                break;
//	        }
//	}
//	}
//
//	// Método para crear un pasillo y asignarlo a una tienda
//	public static void crearPasilloConProductos(Tienda tienda, String nombrePasillo, Categoria categoria, ArrayList<Producto> productos) {
//	    Pasillo pasillo = new Pasillo(nombrePasillo, productos, categoria, tienda);
//	    tienda.getPasillos().add(pasillo);
//	    for (Producto producto : productos) {
//	        producto.setPasillo(pasillo);
//	        producto.setTienda(tienda);
//	    }
//	}
//
//	// Métodos para generar productos de diferentes categorías
//	public static ArrayList<Producto> generarProductosAlimentos() {
//	    ArrayList<Producto> productos = new ArrayList<>();
//	    productos.add(new Producto("Arroz", "Diana", 5000, Tamaño.GRANDE, Edades.ADULTOS, 1, Categoria.ALIMENTO, "Arroz blanco", LocalDate.of(2025, 8, 1)));
//	    productos.add(new Producto("Frijoles", "La Fama", 4500, Tamaño.MEDIANO, Edades.ADULTOS, 2, Categoria.ALIMENTO, "Frijoles rojos", LocalDate.of(2024, 12, 1)));
//	    productos.add(new Producto("Arroz Blanco", "Doña Pepa", 4500, Tamaño.GRANDE, Edades.MENORES, 101, Categoria.ALIMENTO, "Arroz de calidad superior", LocalDate.of(2025, 6, 30)));
//	    productos.add(new Producto("Frijoles Rojos", "La Abuela", 3800, Tamaño.MEDIANO, Edades.MENORES, 102, Categoria.ALIMENTO, "Frijoles seleccionados", LocalDate.of(2024, 12, 15)));
//	    productos.add(new Producto("Lentejas", "NutriFit", 3200, Tamaño.PEQUEÑO, Edades.MENORES, 103, Categoria.ALIMENTO, "Lentejas saludables", LocalDate.of(2024, 11, 10)));
//	    productos.add(new Producto("Avena", "Delicia", 2500, Tamaño.GRANDE, Edades.MENORES, 104, Categoria.ALIMENTO, "Avena integral", LocalDate.of(2025, 4, 20)));
//	    productos.add(new Producto("Pasta Integral", "VitaPasta", 5500, Tamaño.MEDIANO, Edades.MENORES, 105, Categoria.ALIMENTO, "Pasta saludable", LocalDate.of(2024, 9, 5)));
//	    productos.add(new Producto("Maíz Dulce", "Golden Corn", 2900, Tamaño.PEQUEÑO, Edades.MENORES, 106, Categoria.ALIMENTO, "Maíz enlatado", LocalDate.of(2025, 1, 25)));
//	    
//	    return productos;
//	}
//
//	public static ArrayList<Producto> generarProductosBebidas() {
//	    ArrayList<Producto> productos = new ArrayList<>();
//	    productos.add(new Producto("Coca-Cola", "Coca-Cola", 3000, Tamaño.PEQUEÑO, Edades.MENORES, 3, Categoria.BEBIDA, "Bebida gaseosa", LocalDate.of(2024, 6, 1)));
//	    productos.add(new Producto("Agua", "Postobón", 2000, Tamaño.MEDIANO, Edades.ADULTOS, 4, Categoria.BEBIDA, "Agua sin gas", LocalDate.of(2025, 1, 1)));
//	    productos.add(new Producto("Jugo de Naranja", "Sunny", 4500, Tamaño.GRANDE, Edades.MENORES, 201, Categoria.BEBIDA, "Jugo natural", LocalDate.of(2024, 9, 1)));
//	    productos.add(new Producto("Gaseosa Cola", "MegaCola", 2500, Tamaño.MEDIANO, Edades.MENORES, 202, Categoria.BEBIDA, "Refresco sabor cola", LocalDate.of(2024, 12, 31)));
//	    productos.add(new Producto("Agua Mineral", "PureLife", 1800, Tamaño.PEQUEÑO, Edades.MENORES, 203, Categoria.BEBIDA, "Agua purificada", LocalDate.of(2025, 7, 10)));
//	    productos.add(new Producto("Bebida Energética", "PowerUp", 5200, Tamaño.MEDIANO, Edades.ADULTOS, 204, Categoria.BEBIDA, "Energía instantánea", LocalDate.of(2024, 10, 15)));
//	    productos.add(new Producto("Té Frío", "CoolTea", 3500, Tamaño.GRANDE, Edades.MENORES, 205, Categoria.BEBIDA, "Té con limón", LocalDate.of(2025, 3, 18)));
//	    productos.add(new Producto("Vino Tinto", "Bodega Real", 12500, Tamaño.GRANDE, Edades.ADULTOS, 206, Categoria.BEBIDA, "Vino de calidad", LocalDate.of(2028, 12, 31)));
//	    return productos;
//	}
//
//	public static ArrayList<Producto> generarProductosLimpieza() {
//	    ArrayList<Producto> productos = new ArrayList<>();
//	    productos.add(new Producto("Jabón en polvo", "Ariel", 15000, Tamaño.GRANDE, Edades.ADULTOS, 5, Categoria.LIMPIEZA, "Detergente para ropa", LocalDate.of(2026, 5, 1)));
//	    productos.add(new Producto("Desinfectante", "Lysol", 8000, Tamaño.MEDIANO, Edades.ADULTOS, 6, Categoria.LIMPIEZA, "Limpia superficies", LocalDate.of(2025, 3, 1)));
//	    productos.add(new Producto("Detergente Líquido", "CleanForce", 7800, Tamaño.GRANDE, Edades.MENORES, 301, Categoria.LIMPIEZA, "Para ropa", LocalDate.of(2027, 6, 30)));
//	    productos.add(new Producto("Limpiador Multiuso", "Mr. Clean", 5500, Tamaño.MEDIANO, Edades.MENORES, 302, Categoria.LIMPIEZA, "Para todo tipo de superficies", LocalDate.of(2026, 12, 31)));
//	    productos.add(new Producto("Jabón de Manos", "PureHands", 1800, Tamaño.PEQUEÑO, Edades.MENORES, 303, Categoria.LIMPIEZA, "Jabón líquido antibacterial", LocalDate.of(2025, 9, 15)));
//	    productos.add(new Producto("Cloro", "Blanco Puro", 3200, Tamaño.GRANDE, Edades.MENORES, 304, Categoria.LIMPIEZA, "Desinfectante", LocalDate.of(2026, 4, 20)));
//	    productos.add(new Producto("Esponjas", "LimpiaMax", 2500, Tamaño.PEQUEÑO, Edades.MENORES, 305, Categoria.LIMPIEZA, "Esponjas de cocina", LocalDate.of(2028, 1, 15)));
//	    productos.add(new Producto("Desinfectante de Aire", "AromaPuro", 9200, Tamaño.MEDIANO, Edades.MENORES, 306, Categoria.LIMPIEZA, "Elimina olores", LocalDate.of(2027, 10, 30)));
//	    return productos;
//	}
//
//	public static ArrayList<Producto> generarProductosPersonal() {
//	    ArrayList<Producto> productos = new ArrayList<>();
//	    productos.add(new Producto("Shampoo", "Head & Shoulders", 12000, Tamaño.GRANDE, Edades.ADULTOS, 7, Categoria.PERSONAL, "Shampoo anticaspa", LocalDate.of(2026, 11, 1)));
//	    productos.add(new Producto("Jabón de baño", "Dove", 4000, Tamaño.PEQUEÑO, Edades.MENORES, 8, Categoria.PERSONAL, "Jabón en barra", LocalDate.of(2025, 8, 1)));
//	    productos.add(new Producto("Champú", "Silky Hair", 7500, Tamaño.GRANDE, Edades.MENORES, 401, Categoria.PERSONAL, "Cabello suave y sedoso", LocalDate.of(2025, 12, 31)));
//	    productos.add(new Producto("Desodorante", "Fresh", 5800, Tamaño.MEDIANO, Edades.ADULTOS, 402, Categoria.PERSONAL, "Protección 48 horas", LocalDate.of(2026, 1, 20)));
//	    productos.add(new Producto("Jabón líquido", "Pure Skin", 9500, Tamaño.GRANDE, Edades.MENORES, 403, Categoria.PERSONAL, "Limpieza profunda", LocalDate.of(2025, 8, 15)));
//	    productos.add(new Producto("Crema corporal", "Smooth Touch", 6800, Tamaño.MEDIANO, Edades.ADULTOS, 404, Categoria.PERSONAL, "Hidratación profunda", LocalDate.of(2026, 3, 10)));
//	    productos.add(new Producto("Toallas húmedas", "Clean & Soft", 4500, Tamaño.PEQUEÑO, Edades.MENORES, 405, Categoria.PERSONAL, "Cuidado delicado", LocalDate.of(2025, 6, 1)));
//	    productos.add(new Producto("Pasta dental", "Bright Smile", 3200, Tamaño.PEQUEÑO, Edades.MENORES, 406, Categoria.PERSONAL, "Blanqueamiento", LocalDate.of(2025, 7, 22)));
//
//	    return productos;
//	}
//
//	public static ArrayList<Producto> generarProductosHogar() {
//	    ArrayList<Producto> productos = new ArrayList<>();
//	    productos.add(new Producto("Sartén", "Imusa", 25000, Tamaño.MEDIANO, Edades.ADULTOS, 9, Categoria.HOGAR, "Sartén antiadherente", LocalDate.of(2027, 2, 1)));
//	    productos.add(new Producto("Tostadora", "Oster", 90000, Tamaño.GRANDE, Edades.ADULTOS, 10, Categoria.HOGAR, "Tostadora de pan", LocalDate.of(2028, 12, 1)));
//	    productos.add(new Producto("Detergente", "Clean Home", 12500, Tamaño.GRANDE, Edades.ADULTOS, 501, Categoria.HOGAR, "Limpieza profunda para ropa", LocalDate.of(2025, 11, 15)));
//	    productos.add(new Producto("Esponja", "Soft Scrub", 1500, Tamaño.PEQUEÑO, Edades.MENORES, 502, Categoria.HOGAR, "Esponja multiuso", LocalDate.of(2026, 2, 25)));
//	    productos.add(new Producto("Fregona", "Quick Mop", 17000, Tamaño.GRANDE, Edades.ADULTOS, 503, Categoria.HOGAR, "Limpieza eficiente", LocalDate.of(2025, 12, 5)));
//	    productos.add(new Producto("Jabón para platos", "Dish Clean", 4800, Tamaño.MEDIANO, Edades.MENORES, 504, Categoria.HOGAR, "Elimina grasa", LocalDate.of(2025, 10, 18)));
//	    productos.add(new Producto("Ambientador", "Fresh Home", 6200, Tamaño.PEQUEÑO, Edades.MENORES, 505, Categoria.HOGAR, "Aroma floral", LocalDate.of(2025, 9, 10)));
//	    productos.add(new Producto("Plumero", "Dust Away", 3400, Tamaño.PEQUEÑO, Edades.MENORES, 506, Categoria.HOGAR, "Remueve polvo", LocalDate.of(2025, 11, 20)));
//	    return productos;
//	}
//
//	public static ArrayList<Producto> generarProductosElectronicos() {
//	    ArrayList<Producto> productos = new ArrayList<>();
//	    productos.add(new Producto("Televisor", "Samsung", 1500000, Tamaño.GRANDE, Edades.ADULTOS, 11, Categoria.ELECTRONICO, "Televisor LED 50\"", LocalDate.of(2030, 12, 1)));
//	    productos.add(new Producto("Celular", "Xiaomi", 800000, Tamaño.MEDIANO, Edades.ADULTOS, 12, Categoria.ELECTRONICO, "Celular inteligente", LocalDate.of(2029, 8, 1)));
//	    productos.add(new Producto("Audífonos", "Bass Boost", 58000, Tamaño.PEQUEÑO, Edades.ADULTOS, 601, Categoria.ELECTRONICO, "Sonido de alta calidad", LocalDate.of(2028, 12, 30)));
//	    productos.add(new Producto("Televisor", "SuperView", 1850000, Tamaño.GRANDE, Edades.ADULTOS, 602, Categoria.ELECTRONICO, "4K Ultra HD", LocalDate.of(2030, 5, 15)));
//	    productos.add(new Producto("Teléfono móvil", "SmartOne", 899000, Tamaño.MEDIANO, Edades.ADULTOS, 603, Categoria.ELECTRONICO, "Última generación", LocalDate.of(2030, 8, 22)));
//	    productos.add(new Producto("Portátil", "LightBook", 2200000, Tamaño.GRANDE, Edades.ADULTOS, 604, Categoria.ELECTRONICO, "Ultra ligero", LocalDate.of(2030, 6, 14)));
//	    productos.add(new Producto("Mouse inalámbrico", "FastClick", 35000, Tamaño.PEQUEÑO, Edades.ADULTOS, 605, Categoria.ELECTRONICO, "Alta precisión", LocalDate.of(2029, 1, 10)));
//	    productos.add(new Producto("Cámara digital", "ProCam", 650000, Tamaño.MEDIANO, Edades.ADULTOS, 606, Categoria.ELECTRONICO, "Fotos profesionales", LocalDate.of(2031, 4, 2)));
//	    return productos;
//	}
//	
//	
	public static void main(String[] args){
		Deserializador.deserializarListas();
////		new Tienda("juan");
////		new Tienda("pepe");
////		new Tienda("hola");
//		
//		Cliente cliente1 = new Cliente("Laura Martínez", 101, 30, Genero.M);
//		Cliente cliente2 = new Cliente("Carlos Pérez", 102, 25, Genero.H);
//
//		// Más clientes
//		Cliente cliente3 = new Cliente("Ana Torres", 103, 28, Genero.M );
//		Cliente cliente4 = new Cliente("Javier Fernández", 104, 35, Genero.H);
//		
//		
//		// Crear administradores usando el constructor
//		Administrador admin1 = new Administrador("Beatriz Gómez", 201, 40, Genero.M , 12000.0);
//		Administrador admin2 = new Administrador("Ricardo Díaz", 202, 45, Genero.H, 15000.0);
//
//		// Más administradores
//		Administrador admin3 = new Administrador("Sofía Sánchez", 203, 38, Genero.M , 11000.0);
//		Administrador admin4 = new Administrador("Miguel Ramírez", 204, 50, Genero.H, 16000.0);
//		
//		
//		Tienda tienda9 = new Tienda(
//			    "1234567890", // NIT
//			    admin1,       // Dueño
//			    "Tienda Digital", // Nombre
//			    25000.0,      // Saldo inicial
//			    "abierto"     // Estado
//			);
//
//			Tienda tienda10 = new Tienda(
//			    "0987654321", // NIT
//			    admin2,       // Dueño
//			    "Tienda Elegante", // Nombre
//			    30000.0,      // Saldo inicial
//			    "cerrado"     // Estado
//			);
//
//			Tienda tienda11 = new Tienda(
//			    "1122334455", // NIT
//			    admin3,       // Dueño
//			    "Tienda Económica", // Nombre
//			    18000.0,      // Saldo inicial
//			    "abierto"     // Estado
//			);
//
//			Tienda tienda12 = new Tienda(
//			    "5544332211", // NIT
//			    admin4,       // Dueño
//			    "Tienda Familiar", // Nombre
//			    22000.0,      // Saldo inicial
//			    "cerrado"     // Estado
//			);
//
//			Tienda tienda13 = new Tienda(
//			    "6677889900", // NIT
//			    null,       // Dueño
//			    "Tienda Retro", // Nombre
//			    27000.0,      // Saldo inicial
//			    "abierto"     // Estado
//			);
//
//			Tienda tienda14 = new Tienda(
//			    "8899001122", // NIT
//			    null,       // Dueño
//			    "Tienda Gourmet", // Nombre
//			    35000.0,      // Saldo inicial
//			    "abierto"     // Estado
//			);
//
//			Tienda tienda15 = new Tienda(
//			    "2233445566", // NIT
//			    null,       // Dueño
//			    "Tienda de Lujo", // Nombre
//			    40000.0,      // Saldo inicial
//			    "cerrado"     // Estado
//			);
//
//			Tienda tienda16 = new Tienda(
//			    "5566778899", // NIT
//			    null,       // Dueño
//			    "Tienda Outlet", // Nombre
//			    15000.0,      // Saldo inicial
//			    "abierto"     // Estado
//			);
//			
//			Caja caja1 = new Caja("Caja 1", TipoCaja.RAPIDA, tienda9);
//			Caja caja2 = new Caja("Caja 2", TipoCaja.NORMAL, tienda9);
//			Caja caja3 = new Caja("Caja 3", TipoCaja.RAPIDA, tienda10);
//			Caja caja4 = new Caja("Caja 4", TipoCaja.NORMAL, tienda10);
//			Caja caja5 = new Caja("Caja 5", TipoCaja.RAPIDA,tienda11 );
//			// Crear más cajas con diferentes tiendas y tipos
//			Caja caja6 = new Caja("Caja 6", TipoCaja.RAPIDA, tienda12);
//			Caja caja7 = new Caja("Caja 7", TipoCaja.NORMAL, tienda12);
//			Caja caja8 = new Caja("Caja 8", TipoCaja.RAPIDA, tienda13);
//			Caja caja9 = new Caja("Caja 9", TipoCaja.NORMAL, tienda13);
//			Caja caja10 = new Caja("Caja 10", TipoCaja.RAPIDA, tienda14);
//			Caja caja11 = new Caja("Caja 11", TipoCaja.NORMAL, tienda14);
//			Caja caja12 = new Caja("Caja 12", TipoCaja.RAPIDA, tienda15);
//			Caja caja13 = new Caja("Caja 13", TipoCaja.NORMAL, tienda15);
//			Caja caja14 = new Caja("Caja 14", TipoCaja.RAPIDA, tienda16);
//			Caja caja15 = new Caja("Caja 15", TipoCaja.NORMAL, tienda16);
//
//			
//			Cajero cajero1 = new Cajero("Miguel Ángel", 301, 28, Genero.H, 8000.0, tienda9, true, false, 5, caja1);
//			Cajero cajero2 = new Cajero("Paola Ruiz", 302, 32, Genero.M, 8500.0, tienda9, true, false, 3, caja2);
//			Cajero cajero3 = new Cajero("Luis Gómez", 303, 26, Genero.H, 7800.0, tienda10, true, false, 2, caja3);
//			Cajero cajero4 = new Cajero("Elena Martínez", 304, 29, Genero.M, 8200.0, tienda10, true, false, 4, caja4);
//			Cajero cajero5 = new Cajero("Javier Fernández", 305, 35, Genero.H, 8300.0, tienda11, true, false, 6, caja5);
//			// Crear más cajeros y asignarles las cajas correspondientes
//			Cajero cajero6 = new Cajero("Sofía Sánchez", 306, 30, Genero.M, 8600.0, tienda12, true, false, 5, caja6);
//			Cajero cajero7 = new Cajero("Andrés Vargas", 307, 33, Genero.H, 8800.0, tienda12, true, false, 3, caja7);
//			Cajero cajero8 = new Cajero("Camila Ramírez", 308, 27, Genero.M, 7900.0, tienda13, true, false, 2, caja8);
//			Cajero cajero9 = new Cajero("Roberto Mendoza", 309, 31, Genero.H, 8200.0, tienda13, true, false, 4, caja9);
//			Cajero cajero10 = new Cajero("Isabel Fernández", 310, 29, Genero.M, 8400.0, tienda14, true, false, 6, caja10);
//			Cajero cajero11 = new Cajero("Felipe Torres", 311, 34, Genero.H, 8700.0, tienda14, true, false, 7, caja11);
//			Cajero cajero12 = new Cajero("Laura Jiménez", 312, 28, Genero.M, 8000.0, tienda15, true, false, 3, caja12);
//			Cajero cajero13 = new Cajero("David López", 313, 36, Genero.H, 8300.0, tienda15, true, false, 5, caja13);
//			Cajero cajero14 = new Cajero("Natalia Morales", 314, 25, Genero.M, 7800.0, tienda16, true, false, 4, caja14);
//			Cajero cajero15 = new Cajero("Antonio Salazar", 315, 32, Genero.H, 8500.0, tienda16, true, false, 6, caja15);
//			
//			
//			Proveedor proveedorAlimento = new Proveedor("Proveedor Alimentos",generarProductosAlimentos(), Categoria.ALIMENTO, Tienda.getTiendas());
//			Proveedor proveedorBebida = new Proveedor("Proveedor Bebidas", generarProductosBebidas(), Categoria.BEBIDA, Tienda.getTiendas());
//			Proveedor proveedorLimpieza = new Proveedor("Proveedor Limpieza", generarProductosLimpieza(), Categoria.LIMPIEZA, Tienda.getTiendas());
//			Proveedor proveedorPersonal = new Proveedor("Proveedor Personal", generarProductosPersonal(), Categoria.PERSONAL, Tienda.getTiendas());
//			Proveedor proveedorHogar = new Proveedor("Proveedor Hogar", generarProductosHogar(), Categoria.HOGAR, Tienda.getTiendas());
//			Proveedor proveedorElectronico = new Proveedor("Proveedor Electrónico", generarProductosElectronicos(),Categoria.ELECTRONICO, Tienda.getTiendas());
//		Main.generarPasillosYProductos();
//		Serializador.serializarTodo();	
	escogerFuncionalidad();
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
