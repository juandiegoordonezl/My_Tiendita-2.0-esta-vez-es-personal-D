package gestorAplicación.sujetos;

import java.io.Serializable;

import gestorAplicación.servicios.Enums.Genero;
import gestorAplicación.servicios.Enums.TipoEmpleado;
import gestorAplicación.servicios.Tienda;

public abstract class Empleado extends Persona implements Serializable{
//Atributos----------------------------------------------------------------------------------------------------
	
	private static final long serialVersionUID = 1006554030509380019L;
	protected double liquidacion;
	protected boolean prestacionSalud;
	protected boolean prestacionPension;
	protected int experiencia;
	private Tienda tienda;
	private TipoEmpleado tipo;
	
//-------------------------------------------------------------------------------------------------------------

//Getters and Setters------------------------------------------------------------------------------------------
	
//-------------------------------------------------------------------------------------------------------------

//Constructores------------------------------------------------------------------------------------------------
	
	protected Empleado(){
		super();
	}
	
	protected Empleado(String nombre, int id, int edad, Genero genero, double liquidacion, Tienda tienda, 
			boolean prestacionSalud, boolean prestacionPension,TipoEmpleado tipo, int experiencia2) {
		super(nombre, id, edad, genero);
		this.liquidacion=liquidacion;
		this.prestacionSalud=prestacionSalud;
		this.prestacionPension=prestacionPension;
		this.experiencia=experiencia2;
		this.setTipo(tipo);
	}
	
//-------------------------------------------------------------------------------------------------------------
	
//Metodos------------------------------------------------------------------------------------------------------
	
	public TipoEmpleado getTipo() {
		return tipo;
	}

	public double getLiquidacion() {
		return liquidacion;
	}

	public void setLiquidacion(double liquidacion) {
		this.liquidacion = liquidacion;
	}

	/**
	 * @return the tienda
	 */
	public Tienda getTienda() {
		return tienda;
	}

	/**
	 * @param tienda the tienda to set
	 */
	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}

	public boolean isPrestacionSalud() {
		return prestacionSalud;
	}

	public void setPrestacionSalud(boolean prestacionSalud) {
		this.prestacionSalud = prestacionSalud;
	}

	public boolean isPrestacionPension() {
		return prestacionPension;
	}

	public void setPrestacionPension(boolean prestacionPension) {
		this.prestacionPension = prestacionPension;
	}

	public int getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(int experiencia) {
		this.experiencia = experiencia;
	}

	public void setTipo(TipoEmpleado tipo) {
		this.tipo = tipo;
	}
	
	protected abstract void buscoChamba();
	protected abstract double cantidadPago();
	public abstract boolean validarCriterios();
	
//-------------------------------------------------------------------------------------------------------------
}
