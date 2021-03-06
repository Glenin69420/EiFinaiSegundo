package Logico;

import java.io.Serializable;
import java.util.ArrayList;

public class Proyecto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6451712052890475645L;
	private ArrayList<Trabajadora> empleados;
	private String descripcion;
	private Trabajadora jefe; //Todavia en duda
	private String Nombre;
	private String TipoDeProyecto; //1. Web 2. Movil 3. Desktop 
	private static int codigo = 1;
	private String Indentificacion;
	private Trabajadora Trabajador;
	private float Total;
	
	
	public Proyecto(String Nombre, String Indentificacion, String descripcion, ArrayList<Trabajadora> Trabajadores, String TipoDeProyecto) {
		super();
		this.empleados = Trabajadores;
		this.descripcion = descripcion;
		this.Nombre = Nombre;
		this.TipoDeProyecto = TipoDeProyecto;
		this.codigo++;
		this.Indentificacion = Indentificacion;
		this.Total = 0;
		
	}

	public ArrayList<Trabajadora> getEmpleados() {
		return empleados;
	}
	
	
	public static int getCodigo() {
		return codigo;
	}

	public static void setCodigo(int codigo) {
		Proyecto.codigo = codigo;
	}

	public float getTotal() {
		return Total;
	}

	public void setTotal(float total) {
		Total = total;
	}

	public Trabajadora getTrabajador() {
		return Trabajador;
	}

	public void setTrabajador(Trabajadora trabajador) {
		Trabajador = trabajador;
	}

	public String getIndentificacion() {
		return Indentificacion;
	}

	public void setIndentificacion(String indentificacion) {
		Indentificacion = indentificacion;
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

	public String getTipoDeProyecto() {
		return TipoDeProyecto;
	}

	public void setTipoDeProyecto(String tipoDeProyecto) {
		TipoDeProyecto = tipoDeProyecto;
	}
	
}
