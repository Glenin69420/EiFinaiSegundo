package Logico;

public class Diseñador extends Trabajadora {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 5548943361023490025L;
	protected float Salario;


	public Diseñador(String identificador, String nombre, String apellido, String direccion, String sexo, int edad) {
		super(identificador, nombre, apellido, direccion, sexo, edad);
		this.Salario= 0;
		
	}


	public float getSalario() {
		return Salario;
	}


	public void setSalario(float salario) {
		Salario = salario;
	}


	@Override
	public float Sueldo() {
		float Total = 1000;
		setSalario(Total);
		return Salario;
	}

	
	
	
	

}