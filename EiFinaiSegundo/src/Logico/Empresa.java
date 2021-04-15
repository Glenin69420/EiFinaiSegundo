package Logico;

import java.io.Serializable;
import java.util.ArrayList;

public class Empresa implements Serializable {

	private static final long serialVersionUID = -4736481894836561533L;
	private ArrayList<Trabajadora> MisTrabajadores;
	private ArrayList<Cliente> MisClientes;
	private ArrayList<Contrato> MisContratos;
	private ArrayList<Proyecto> MisProyectos;
	private static Empresa Centro = null;
	private static Cliente loginCliente;
	public static int ProyectoCod = 1;
	public static int ContratoCod = 1;

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
	public void InsertarProyecto(Proyecto proyecto) {
		MisProyectos.add(proyecto);
	} 
	public void InsertarContrato(Contrato contrato) {
		MisContratos.add(contrato);
	} 
	public boolean EliminarTrabajador(Trabajadora T) {
		return MisTrabajadores.remove(T);
	}
	public boolean ElimininarProyectos(Proyecto P) {
		return MisProyectos.remove(P);
	}
	public void InsertarCliente(Cliente C) {
		MisClientes.add(C);
	} 
	
	public Trabajadora BuscarTrabajador(String Nombre) {

		for(Trabajadora T:MisTrabajadores) {
			if(T!=null) {
				if(T.getNombre().equalsIgnoreCase(Nombre)) {
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
	public Proyecto BuscarProyecto(String Nombre) {

		for(Proyecto P:MisProyectos) {
			if(P!=null) {
				if(P.getNombre().equalsIgnoreCase(Nombre)) {
					return P;
				}
			}
		}
		return null;
	}
	public Contrato BuscarContrato(String Nombre) {

		for(Contrato C:MisContratos) {
			if(C!=null) {
				if(C.getNombre().equalsIgnoreCase(Nombre)) {
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
