package Logico;

public class Diseñador extends Trabajadora {
	

	protected float Salario;

	public Diseñador(String identificador, String nombre, String apellido, String direccion, String sexo, int edad) {
		super(identificador, nombre, apellido, direccion, sexo, edad);
		this.Salario = 0;
	}

	public float getSalario() {
		return Salario;
	}
	
	
	

}