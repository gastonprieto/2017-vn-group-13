package model;

public class Variable implements Operando {

	private String codigo;
	
	public Variable(String codigo) {
		this.codigo = codigo;
	}
	
	@Override
	public Double resultado() {
		return 0D;
	}

	public String getCodigo() {
		return codigo;
	}
}
