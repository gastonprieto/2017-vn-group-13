package Parser;

import Parser.Operando;
import model.Empresa;
import model.Periodo;

public class Constante implements Operando {

	private String valor;
	
	public Constante(String valor) {
		this.valor = valor;
	}
	
	@Override
	public Double resultado(Empresa empresa, Periodo periodo) {
		return Double.valueOf(valor);
	}
}
