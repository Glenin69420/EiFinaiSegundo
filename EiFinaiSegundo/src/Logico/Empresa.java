package Logico;

import java.util.ArrayList;

public class Empresa {
	
	private ArrayList<Trabajadora> MisTrabajadores;
	//private ArrayList<Cliente> MisClientes;
	//private ArrayList<Contrato> MisContratos;
	//private ArrayList<Proyectos> MisProyectos;
	private static Empresa Centro = null;

	public Empresa() {
		super();
		this.MisTrabajadores = new ArrayList<>();
		//this.MisClientes = new ArrayList<>();
		//this.MisContratos = new ArrayList<>();
		//this.MisProyectos = new ArrayList<>();
	}
	
	public static Empresa getInstance() {
		if(Centro == null) {
			Centro = new Empresa();
		}
		return Centro;
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
}
