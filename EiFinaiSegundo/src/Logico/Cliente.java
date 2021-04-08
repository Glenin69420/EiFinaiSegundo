package Logico;

import java.util.ArrayList;

public class Cliente {
	private String identificacion;
	private String nombre;
	private String direccion;
	private String Apellidos;
	private String Telefono;
	private ArrayList<Contrato> cantProyecto;
	public static int Codigo=1;
	
	public Cliente(String identificacion, String nombre, String Apelidos, String Telefono, String direccion) {
		super();
		this.identificacion = identificacion;
		this.nombre = nombre;
		this.direccion = direccion;
		this.cantProyecto = new ArrayList<Contrato>();
		this.Codigo++;
		this.Telefono = Telefono;
		this.Apellidos = Apelidos;
	}
	
	
	public String getApellidos() {
		return Apellidos;
	}


	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}


	public String getTelefono() {
		return Telefono;
	}


	public void setTelefono(String telefono) {
		Telefono = telefono;
	}


	public String getIdentificacion() {
		return identificacion;
	}
	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public ArrayList<Contrato> getCantProyecto() {
		return cantProyecto;
	}
	public void setCantProyecto(ArrayList<Contrato> cantProyecto) {
		this.cantProyecto = cantProyecto;
	}	
}
