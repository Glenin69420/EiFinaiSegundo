package Logico;

public class JefeProyecto extends Trabajadora {
	
	protected int CantidadDeTrabajadores;
	protected float Salario;
	
	public JefeProyecto(String identificador, String nombre, String apellido, String direccion, String sexo, int edad,
			int cantidadDeTrabajadores) {
		super(identificador, nombre, apellido, direccion, sexo, edad);
		CantidadDeTrabajadores = cantidadDeTrabajadores;
		this.Salario = 0;
	}

	public int getCantidadDeTrabajadores() {
		return CantidadDeTrabajadores;
	}

	public float getSalario() {
		return Salario;
	}
	
	
	
	
	

}