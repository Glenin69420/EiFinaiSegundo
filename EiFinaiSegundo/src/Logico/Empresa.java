package Logico;

import java.io.Serializable;
import java.util.ArrayList;

public class Empresa implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4736481894836561533L;
	private ArrayList<Trabajadora> MisTrabajadores;
	private ArrayList<Cliente> MisClientes;
	private ArrayList<Contrato> MisContratos;
	private ArrayList<Proyecto> MisProyectos;
	private static Empresa Centro = null;
	private static Cliente loginCliente;

	public Empresa() {
		super();
		this.MisTrabajadores = new ArrayList<Trabajadora>();
		this.MisClientes = new ArrayList<Cliente>();
		this.MisContratos = new ArrayList<Contrato>();
		this.MisProyectos = new ArrayList<Proyecto>();
	}
	
	public static Empresa getInstance() {
		if(Centro == null) {
			Centro = new Empresa();
		}
		return Centro;
	}
	

	public static Empresa getCentro() {
		return Centro;
	}

	public static void setCentro(Empresa centro) {
		Centro = centro;
	}

	public ArrayList<Cliente> getMisClientes() {
		return MisClientes;
	}

	public ArrayList<Contrato> getMisContratos() {
		return MisContratos;
	}

	public ArrayList<Proyecto> getMisProyectos() {
		return MisProyectos;
	}

	public ArrayList<Trabajadora> getMisTrabajadores() {
		return MisTrabajadores;
	}

	public void setMisTrabajadores(ArrayList<Trabajadora> misTrabajadores) {
		MisTrabajadores = misTrabajadores;
	}
	public void InsertarTrabajador(Trabajadora Trabajador) {
		MisTrabajadores.add(Trabajador);
	} 
	public boolean EliminarTrabajador(Trabajadora Trabajador) {
		return MisTrabajadores.remove(Trabajador);
	}
	public void InsertarCliente(Cliente C) {
		MisClientes.add(C);
	} 
	
	public Trabajadora BuscarTrabajador(String Codigo) {

		for(Trabajadora T:MisTrabajadores) {
			if(T!=null) {
				if(T.getIdentificador().equalsIgnoreCase(Codigo)) {
					return T;
				}
			}
		}
		return null;
	}
	public Cliente BuscarCliente(String Codigo) {

		for(Cliente C:MisClientes) {
			if(C!=null) {
				if(C.getIdentificacion().equalsIgnoreCase(Codigo)) {
					return C;
				}
			}
		}
		return null;
	}
	public static String TipoDeTrabajador(Trabajadora T) {
		if(T instanceof JefeProyecto) {
			return "Jefe.Proyecto";
		}
		if(T instanceof Programadores) {
			return "Programador";
		}
		else if(T instanceof Planificadores) {
			return "Planificador";

		}
		else {
			return "Diseñador";
		}

	}
	public static String TipoDeProyecto(Proyecto P) {
		if(P.getTipoDeProyecto() == 1) {
			return "Web";
		}
		if(P.getTipoDeProyecto() == 2) {
			return "Movil";
		}
		 if(P.getTipoDeProyecto() == 3) {
			return "Desktop";

		}
		return null;
		
		

	}
	public boolean confirmLogin(String Nombre, String Contraseña) {
		boolean login = false;
		for (Cliente C : MisClientes) {
			if(C.getNombre().equalsIgnoreCase(Nombre) && C.getIdentificacion().equalsIgnoreCase(Contraseña)){
				loginCliente = C;
				login = true;
			}
		}
		return login;
	}
}
