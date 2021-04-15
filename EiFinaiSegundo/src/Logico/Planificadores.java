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

	public void setSalario(float salario) {
		Salario = salario;
	}
	public float Sueldo() {
		float Total = 3000;
		setSalario(Total);
		return Salario;
	}
	
	
	

}