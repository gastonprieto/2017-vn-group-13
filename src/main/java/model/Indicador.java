package model;

public class Indicador {

	private String nombre;
	private Operando operacion;
	
	public Indicador(String nombre, Operando operacion) {
		this.nombre = nombre;
		this.operacion = operacion;
	}
	
	public Double aplicar() {
		return operacion.resultado();
	}

	public String getNombre() {
		return nombre;
	}
}
