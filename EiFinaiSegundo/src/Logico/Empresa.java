package Logico;

import java.util.ArrayList;

public class Empresa {
	
	private ArrayList<Trabajadora> MisTrabajadores;
	private ArrayList<Cliente> MisClientes;
	private ArrayList<Contrato> MisContratos;
	private ArrayList<Proyecto> MisProyectos;
	private static Empresa Centro = null;

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
			return "Dise�ador";
		}

}
}