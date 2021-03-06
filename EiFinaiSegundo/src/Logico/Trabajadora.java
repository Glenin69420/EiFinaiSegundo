package Logico;

import java.io.Serializable;

public abstract class Trabajadora implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2609429704855546833L;
	protected String Identificador;
	protected String Nombre;
	protected String Apellido;
	protected String Direccion;
	protected String Sexo;
	protected float Sueldo;
	//protected int Dias;
	protected int Edad;// Puede ser un string
	//protected float Salario;//Voy hacer que cada herencia tenga este atributo para que la clase diseno no este sola.
	protected int Proyecto;
	protected int Evaluacion;
	public static int Codigo = 1;
	public int Total = 1;
	
	public Trabajadora(String identificador, String nombre, String apellido, String direccion, String sexo, int edad) {
		super();
		Identificador = identificador;
		Nombre = nombre;
		Apellido = apellido;
		Direccion = direccion;
		Sexo = sexo;
		Edad = edad;
		this.Proyecto++;
		this.Codigo++;
		this.Evaluacion = 0;
		//this.Sueldo = 0;
	}

	public String getIdentificador() {
		return Identificador;
	}
	
	public float getSueldo() {
		return Sueldo;
	}

	public void setSueldo(float sueldo) {
		Sueldo = sueldo;
	}

	public void setIdentificador(String identificador) {
		Identificador = identificador;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellido() {
		return Apellido;
	}

	public void setApellido(String apellido) {
		Apellido = apellido;
	}

	public String getDireccion() {
		return Direccion;
	}

	public void setDireccion(String direccion) {
		Direccion = direccion;
	}

	public String getSexo() {
		return Sexo;
	}

	public void setSexo(String sexo) {
		Sexo = sexo;
	}

	public int getEdad() {
		return Edad;
	}

	public void setEdad(int edad) {
		Edad = edad;
	}

	public int getProyecto() {
		return Proyecto;
	}

	public int getEvaluacion() {
		return Evaluacion;
	}
	
	
	public abstract float Sueldo();
	
	public float CalculoSueldo(){
		return Sueldo();
		
	}
	
	
	

}