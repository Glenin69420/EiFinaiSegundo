package Logico;

import java.util.ArrayList;

public class Proyecto {
	private ArrayList<Trabajadora> empleados;
	private String descripcion;
	private Trabajadora jefe; //Todavia en duda
	private String Nombre;
	private int TipoDeProyecto; //1. Web 2. Movil 3. Desktop 
	
	
	public Proyecto(String Nombre, String descripcion, ArrayList<Trabajadora> Trabajadores, int TipoDeProyecto) {
		super();
		this.empleados = Trabajadores;
		this.descripcion = descripcion;
		this.setNombre(Nombre);
		this.TipoDeProyecto = TipoDeProyecto;
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

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public int getTipoDeProyecto() {
		return TipoDeProyecto;
	}

	public void setTipoDeProyecto(int tipoDeProyecto) {
		TipoDeProyecto = tipoDeProyecto;
	}
	//comentario xd
}
