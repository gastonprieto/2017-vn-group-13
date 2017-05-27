package model;

public class Variable implements Operando {

	private String nombre;
	private Indicador indicador;
	
	public Variable(String nombre, Indicador indicador) {
		this.nombre = nombre;
		this.indicador = indicador;
	}
	
	@Override
	public Double resultado() {
		return indicador.buscarValor(nombre);
	}
}
