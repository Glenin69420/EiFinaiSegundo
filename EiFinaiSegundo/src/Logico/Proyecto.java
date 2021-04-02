package Logico;

import java.util.ArrayList;

public class Proyecto {
	private ArrayList<Trabajadora> empleados;
	private String descripcion;
	private Trabajadora jefe; //Todavia en duda
	
	public Proyecto(ArrayList<Trabajadora> empleados, String descripcion, Trabajadora jefe) {
		super();
		this.empleados = empleados;
		this.descripcion = descripcion;
		this.jefe = jefe;
	}

	public ArrayList<Trabajadora> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(ArrayList<Trabajadora> empleados) {
		this.empleados = empleados;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Trabajadora getJefe() {
		return jefe;
	}

	public void setJefe(Trabajadora jefe) {
		this.jefe = jefe;
	}
}
