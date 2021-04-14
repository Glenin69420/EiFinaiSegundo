package Logico;

public class JefeProyecto extends Trabajadora {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4782701182423736502L;
	protected int CantidadDeTrabajadores;
	protected float Salario;
	
	public JefeProyecto(String identificador, String nombre, String apellido, int edad, String sexo, String direccion,
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