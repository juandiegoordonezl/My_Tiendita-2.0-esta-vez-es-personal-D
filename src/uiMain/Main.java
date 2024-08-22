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
	public static void generarPasillosYProductos() {
	    ArrayList<Tienda> tiendas = Tienda.getTiendas();

	    for (int i = 0; i < tiendas.size(); i++) {
	        Tienda tienda = tiendas.get(i);
	        
	        // Crear pasillos con productos para cada tienda
	        switch (i) {
	            case 0: // Tienda 1
	                crearPasilloConProductos(tienda, "Pasillo Alimentos", Categoria.ALIMENTO, generarProductosAlimentos());
	                crearPasilloConProductos(tienda, "Pasillo Bebidas", Categoria.BEBIDA, generarProductosBebidas());
	                break;
	                
	            case 1: // Tienda 2
	                crearPasilloConProductos(tienda, "Pasillo Limpieza", Categoria.LIMPIEZA, generarProductosLimpieza());
	                crearPasilloConProductos(tienda, "Pasillo Personal", Categoria.PERSONAL, generarProductosPersonal());
	                break;
	                
	            case 2: // Tienda 3
	                crearPasilloConProductos(tienda, "Pasillo Hogar", Categoria.HOGAR, generarProductosHogar());
	                crearPasilloConProductos(tienda, "Pasillo Electrónico", Categoria.ELECTRONICO, generarProductosElectronicos());
	                break;
	                
	            case 3: // Tienda 4
	                crearPasilloConProductos(tienda, "Pasillo Alimentos", Categoria.ALIMENTO, generarProductosAlimentos());
	                crearPasilloConProductos(tienda, "Pasillo Hogar", Categoria.HOGAR, generarProductosHogar());
	                break;
	                
	            case 4: // Tienda 5
	                crearPasilloConProductos(tienda, "Pasillo Bebidas", Categoria.BEBIDA, generarProductosBebidas());
	                crearPasilloConProductos(tienda, "Pasillo Electrónico", Categoria.ELECTRONICO, generarProductosElectronicos());
	                break;
	                
	            case 5: // Tienda 6
	                crearPasilloConProductos(tienda, "Pasillo Limpieza", Categoria.LIMPIEZA, generarProductosLimpieza());
	                crearPasilloConProductos(tienda, "Pasillo Personal", Categoria.PERSONAL, generarProductosPersonal());
	                break;
	                
	            case 6: // Tienda 7
	                crearPasilloConProductos(tienda, "Pasillo Alimentos", Categoria.ALIMENTO, generarProductosAlimentos());
	                crearPasilloConProductos(tienda, "Pasillo Bebidas", Categoria.BEBIDA, generarProductosBebidas());
	                break;
	                
	            case 7: // Tienda 8
	                crearPasilloConProductos(tienda, "Pasillo Hogar", Categoria.HOGAR, generarProductosHogar());
	                crearPasilloConProductos(tienda, "Pasillo Electrónico", Categoria.ELECTRONICO, generarProductosElectronicos());
	                break;
	        }
	}
	}

	// Método para crear un pasillo y asignarlo a una tienda
	public static void crearPasilloConProductos(Tienda tienda, String nombrePasillo, Categoria categoria, ArrayList<Producto> productos) {
	    Pasillo pasillo = new Pasillo(nombrePasillo, productos, categoria, tienda);
	    tienda.getPasillos().add(pasillo);
	    for (Producto producto : productos) {
	        producto.setPasillo(pasillo);
	        producto.setTienda(tienda);
	    }
	}

	// Métodos para generar productos de diferentes categorías
	public static ArrayList<Producto> generarProductosAlimentos() {
	    ArrayList<Producto> productos = new ArrayList<>();
	    productos.add(new Producto("Arroz", "Diana", 5000, Tamaño.GRANDE, Edades.ADULTOS, 1, Categoria.ALIMENTO, "Arroz blanco", LocalDate.of(2025, 8, 1)));
	    productos.add(new Producto("Frijoles", "La Fama", 4500, Tamaño.MEDIANO, Edades.ADULTOS, 2, Categoria.ALIMENTO, "Frijoles rojos", LocalDate.of(2024, 12, 1)));
	    productos.add(new Producto("Arroz Blanco", "Doña Pepa", 4500, Tamaño.GRANDE, Edades.MENORES, 101, Categoria.ALIMENTO, "Arroz de calidad superior", LocalDate.of(2025, 6, 30)));
	    productos.add(new Producto("Frijoles Rojos", "La Abuela", 3800, Tamaño.MEDIANO, Edades.MENORES, 102, Categoria.ALIMENTO, "Frijoles seleccionados", LocalDate.of(2024, 12, 15)));
	    productos.add(new Producto("Lentejas", "NutriFit", 3200, Tamaño.PEQUEÑO, Edades.MENORES, 103, Categoria.ALIMENTO, "Lentejas saludables", LocalDate.of(2024, 11, 10)));
	    productos.add(new Producto("Avena", "Delicia", 2500, Tamaño.GRANDE, Edades.MENORES, 104, Categoria.ALIMENTO, "Avena integral", LocalDate.of(2025, 4, 20)));
	    productos.add(new Producto("Pasta Integral", "VitaPasta", 5500, Tamaño.MEDIANO, Edades.MENORES, 105, Categoria.ALIMENTO, "Pasta saludable", LocalDate.of(2024, 9, 5)));
	    productos.add(new Producto("Maíz Dulce", "Golden Corn", 2900, Tamaño.PEQUEÑO, Edades.MENORES, 106, Categoria.ALIMENTO, "Maíz enlatado", LocalDate.of(2025, 1, 25)));
	    
	    return productos;
	}

	public static ArrayList<Producto> generarProductosBebidas() {
	    ArrayList<Producto> productos = new ArrayList<>();
	    productos.add(new Producto("Coca-Cola", "Coca-Cola", 3000, Tamaño.PEQUEÑO, Edades.MENORES, 3, Categoria.BEBIDA, "Bebida gaseosa", LocalDate.of(2024, 6, 1)));
	    productos.add(new Producto("Agua", "Postobón", 2000, Tamaño.MEDIANO, Edades.ADULTOS, 4, Categoria.BEBIDA, "Agua sin gas", LocalDate.of(2025, 1, 1)));
	    productos.add(new Producto("Jugo de Naranja", "Sunny", 4500, Tamaño.GRANDE, Edades.MENORES, 201, Categoria.BEBIDA, "Jugo natural", LocalDate.of(2024, 9, 1)));
	    productos.add(new Producto("Gaseosa Cola", "MegaCola", 2500, Tamaño.MEDIANO, Edades.MENORES, 202, Categoria.BEBIDA, "Refresco sabor cola", LocalDate.of(2024, 12, 31)));
	    productos.add(new Producto("Agua Mineral", "PureLife", 1800, Tamaño.PEQUEÑO, Edades.MENORES, 203, Categoria.BEBIDA, "Agua purificada", LocalDate.of(2025, 7, 10)));
	    productos.add(new Producto("Bebida Energética", "PowerUp", 5200, Tamaño.MEDIANO, Edades.ADULTOS, 204, Categoria.BEBIDA, "Energía instantánea", LocalDate.of(2024, 10, 15)));
	    productos.add(new Producto("Té Frío", "CoolTea", 3500, Tamaño.GRANDE, Edades.MENORES, 205, Categoria.BEBIDA, "Té con limón", LocalDate.of(2025, 3, 18)));
	    productos.add(new Producto("Vino Tinto", "Bodega Real", 12500, Tamaño.GRANDE, Edades.ADULTOS, 206, Categoria.BEBIDA, "Vino de calidad", LocalDate.of(2028, 12, 31)));
	    return productos;
	}

	public static ArrayList<Producto> generarProductosLimpieza() {
	    ArrayList<Producto> productos = new ArrayList<>();
	    productos.add(new Producto("Jabón en polvo", "Ariel", 15000, Tamaño.GRANDE, Edades.ADULTOS, 5, Categoria.LIMPIEZA, "Detergente para ropa", LocalDate.of(2026, 5, 1)));
	    productos.add(new Producto("Desinfectante", "Lysol", 8000, Tamaño.MEDIANO, Edades.ADULTOS, 6, Categoria.LIMPIEZA, "Limpia superficies", LocalDate.of(2025, 3, 1)));
	    productos.add(new Producto("Detergente Líquido", "CleanForce", 7800, Tamaño.GRANDE, Edades.MENORES, 301, Categoria.LIMPIEZA, "Para ropa", LocalDate.of(2027, 6, 30)));
	    productos.add(new Producto("Limpiador Multiuso", "Mr. Clean", 5500, Tamaño.MEDIANO, Edades.MENORES, 302, Categoria.LIMPIEZA, "Para todo tipo de superficies", LocalDate.of(2026, 12, 31)));
	    productos.add(new Producto("Jabón de Manos", "PureHands", 1800, Tamaño.PEQUEÑO, Edades.MENORES, 303, Categoria.LIMPIEZA, "Jabón líquido antibacterial", LocalDate.of(2025, 9, 15)));
	    productos.add(new Producto("Cloro", "Blanco Puro", 3200, Tamaño.GRANDE, Edades.MENORES, 304, Categoria.LIMPIEZA, "Desinfectante", LocalDate.of(2026, 4, 20)));
	    productos.add(new Producto("Esponjas", "LimpiaMax", 2500, Tamaño.PEQUEÑO, Edades.MENORES, 305, Categoria.LIMPIEZA, "Esponjas de cocina", LocalDate.of(2028, 1, 15)));
	    productos.add(new Producto("Desinfectante de Aire", "AromaPuro", 9200, Tamaño.MEDIANO, Edades.MENORES, 306, Categoria.LIMPIEZA, "Elimina olores", LocalDate.of(2027, 10, 30)));
	    return productos;
	}

	public static ArrayList<Producto> generarProductosPersonal() {
	    ArrayList<Producto> productos = new ArrayList<>();
	    productos.add(new Producto("Shampoo", "Head & Shoulders", 12000, Tamaño.GRANDE, Edades.ADULTOS, 7, Categoria.PERSONAL, "Shampoo anticaspa", LocalDate.of(2026, 11, 1)));
	    productos.add(new Producto("Jabón de baño", "Dove", 4000, Tamaño.PEQUEÑO, Edades.MENORES, 8, Categoria.PERSONAL, "Jabón en barra", LocalDate.of(2025, 8, 1)));
	    productos.add(new Producto("Champú", "Silky Hair", 7500, Tamaño.GRANDE, Edades.MENORES, 401, Categoria.PERSONAL, "Cabello suave y sedoso", LocalDate.of(2025, 12, 31)));
	    productos.add(new Producto("Desodorante", "Fresh", 5800, Tamaño.MEDIANO, Edades.ADULTOS, 402, Categoria.PERSONAL, "Protección 48 horas", LocalDate.of(2026, 1, 20)));
	    productos.add(new Producto("Jabón líquido", "Pure Skin", 9500, Tamaño.GRANDE, Edades.MENORES, 403, Categoria.PERSONAL, "Limpieza profunda", LocalDate.of(2025, 8, 15)));
	    productos.add(new Producto("Crema corporal", "Smooth Touch", 6800, Tamaño.MEDIANO, Edades.ADULTOS, 404, Categoria.PERSONAL, "Hidratación profunda", LocalDate.of(2026, 3, 10)));
	    productos.add(new Producto("Toallas húmedas", "Clean & Soft", 4500, Tamaño.PEQUEÑO, Edades.MENORES, 405, Categoria.PERSONAL, "Cuidado delicado", LocalDate.of(2025, 6, 1)));
	    productos.add(new Producto("Pasta dental", "Bright Smile", 3200, Tamaño.PEQUEÑO, Edades.MENORES, 406, Categoria.PERSONAL, "Blanqueamiento", LocalDate.of(2025, 7, 22)));

	    return productos;
	}

	public static ArrayList<Producto> generarProductosHogar() {
	    ArrayList<Producto> productos = new ArrayList<>();
	    productos.add(new Producto("Sartén", "Imusa", 25000, Tamaño.MEDIANO, Edades.ADULTOS, 9, Categoria.HOGAR, "Sartén antiadherente", LocalDate.of(2027, 2, 1)));
	    productos.add(new Producto("Tostadora", "Oster", 90000, Tamaño.GRANDE, Edades.ADULTOS, 10, Categoria.HOGAR, "Tostadora de pan", LocalDate.of(2028, 12, 1)));
	    productos.add(new Producto("Detergente", "Clean Home", 12500, Tamaño.GRANDE, Edades.ADULTOS, 501, Categoria.HOGAR, "Limpieza profunda para ropa", LocalDate.of(2025, 11, 15)));
	    productos.add(new Producto("Esponja", "Soft Scrub", 1500, Tamaño.PEQUEÑO, Edades.MENORES, 502, Categoria.HOGAR, "Esponja multiuso", LocalDate.of(2026, 2, 25)));
	    productos.add(new Producto("Fregona", "Quick Mop", 17000, Tamaño.GRANDE, Edades.ADULTOS, 503, Categoria.HOGAR, "Limpieza eficiente", LocalDate.of(2025, 12, 5)));
	    productos.add(new Producto("Jabón para platos", "Dish Clean", 4800, Tamaño.MEDIANO, Edades.MENORES, 504, Categoria.HOGAR, "Elimina grasa", LocalDate.of(2025, 10, 18)));
	    productos.add(new Producto("Ambientador", "Fresh Home", 6200, Tamaño.PEQUEÑO, Edades.MENORES, 505, Categoria.HOGAR, "Aroma floral", LocalDate.of(2025, 9, 10)));
	    productos.add(new Producto("Plumero", "Dust Away", 3400, Tamaño.PEQUEÑO, Edades.MENORES, 506, Categoria.HOGAR, "Remueve polvo", LocalDate.of(2025, 11, 20)));
	    return productos;
	}

	public static ArrayList<Producto> generarProductosElectronicos() {
	    ArrayList<Producto> productos = new ArrayList<>();
	    productos.add(new Producto("Televisor", "Samsung", 1500000, Tamaño.GRANDE, Edades.ADULTOS, 11, Categoria.ELECTRONICO, "Televisor LED 50\"", LocalDate.of(2030, 12, 1)));
	    productos.add(new Producto("Celular", "Xiaomi", 800000, Tamaño.MEDIANO, Edades.ADULTOS, 12, Categoria.ELECTRONICO, "Celular inteligente", LocalDate.of(2029, 8, 1)));
	    productos.add(new Producto("Audífonos", "Bass Boost", 58000, Tamaño.PEQUEÑO, Edades.ADULTOS, 601, Categoria.ELECTRONICO, "Sonido de alta calidad", LocalDate.of(2028, 12, 30)));
	    productos.add(new Producto("Televisor", "SuperView", 1850000, Tamaño.GRANDE, Edades.ADULTOS, 602, Categoria.ELECTRONICO, "4K Ultra HD", LocalDate.of(2030, 5, 15)));
	    productos.add(new Producto("Teléfono móvil", "SmartOne", 899000, Tamaño.MEDIANO, Edades.ADULTOS, 603, Categoria.ELECTRONICO, "Última generación", LocalDate.of(2030, 8, 22)));
	    productos.add(new Producto("Portátil", "LightBook", 2200000, Tamaño.GRANDE, Edades.ADULTOS, 604, Categoria.ELECTRONICO, "Ultra ligero", LocalDate.of(2030, 6, 14)));
	    productos.add(new Producto("Mouse inalámbrico", "FastClick", 35000, Tamaño.PEQUEÑO, Edades.ADULTOS, 605, Categoria.ELECTRONICO, "Alta precisión", LocalDate.of(2029, 1, 10)));
	    productos.add(new Producto("Cámara digital", "ProCam", 650000, Tamaño.MEDIANO, Edades.ADULTOS, 606, Categoria.ELECTRONICO, "Fotos profesionales", LocalDate.of(2031, 4, 2)));
	    return productos;
	}
	
	
	public static void main(String[] args){
//		Deserializador.deserializarListas();
		Main.generarPasillosYProductos();
		for(Tienda t:Tienda.getTiendas()) {
			System.out.println(t.getPasillos().get(0).getProductos());
		}
//	Serializador.serializarTodo();	

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
