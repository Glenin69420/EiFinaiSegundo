package Logico;

public class Planificadores extends Trabajadora {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 571373952529166578L;
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

	@Override
	public float Sueldo() {
		float Total = 1200;
		return Total;
	}
	
	

}