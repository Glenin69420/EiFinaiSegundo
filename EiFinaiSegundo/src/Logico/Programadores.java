package Logico;

public class Programadores extends Trabajadora {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -634640157192238885L;
	protected String LenguajeDeProgramacion;
	protected float Salario;
	
	public Programadores(String identificador, String nombre, String apellido, String direccion, String sexo, int edad,
			String lenguajeDeProgramacion) {
		super(identificador, nombre, apellido, direccion, sexo, edad);
		LenguajeDeProgramacion = lenguajeDeProgramacion;
		this.Salario = 0;
	}

	public String getLenguajeDeProgramacion() {
		return LenguajeDeProgramacion;
	}

	public void setLenguajeDeProgramacion(String lenguajeDeProgramacion) {
		LenguajeDeProgramacion = lenguajeDeProgramacion;
	}

	public float getSalario() {
		return Salario;
	}
	
	
	
	

}
