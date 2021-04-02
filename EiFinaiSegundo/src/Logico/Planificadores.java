package Logico;

public class Planificadores extends Trabajadora {
	
	protected int CantidadDeDias;
	protected float Salario;
	
	public Planificadores(String identificador, String nombre, String apellido, String direccion, String sexo, int edad,
			int cantidadDeDias) {
		super(identificador, nombre, apellido, direccion, sexo, edad);
		CantidadDeDias = cantidadDeDias;
		this.Salario = 0;
	}

	public int getCantidadDeDias() {
		return CantidadDeDias;
	}

	public float getSalario() {
		return Salario;
	}
	
	

}