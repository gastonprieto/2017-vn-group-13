package model;

public class Constante implements Operando {

	private String valor;
	
	public Constante(String valor) {
		this.valor = valor;
	}
	
	@Override
	public Double resultado() {
		return Double.valueOf(valor);
	}
}
