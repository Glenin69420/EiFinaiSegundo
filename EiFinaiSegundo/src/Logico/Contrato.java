package Logico;

import java.util.ArrayList;
import java.util.Date;

public class Contrato {
	
	private Date fechaInicio;
	private Date fechaDeExpiro;
	private String identificador;
	private ArrayList<Cliente> clientes;
	private String nombre;
	private float penalidad;
	private int prorroga;
	private Cliente cliente;
	
	public Contrato(String Nombre, String identificador , Cliente cliente, Date fechaInicio, Date fechaDeExpiro
			) {
		super();
		this.fechaInicio = new java.util.Date();
		this.fechaDeExpiro = fechaDeExpiro;
		this.identificador = identificador;
		this.cliente = cliente;
		this.nombre = nombre;
		this.prorroga = 0;
		//this.penalidad = 0;
		this.penalidad = 1000;
		//this.prorroga = prorroga;

	}

	public Date getFechaInicio() {
		return fechaInicio;
	}
	

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaDeExpiro() {
		return fechaDeExpiro;
	}

	public void setFechaDeExpiro(Date fechaDeExpiro) {
		this.fechaDeExpiro = fechaDeExpiro;
	}

	public String getIdentificador() {
		return identificador;
	}

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getPenalidad() {
		return penalidad;
	}

	public void setPenalidad(float penalidad) {
		this.penalidad = penalidad;
	}

	public int getProrroga() {
		return prorroga;
	}

	public void setProrroga(int prorroga) {
		this.prorroga = prorroga;
	}
	
	

}
