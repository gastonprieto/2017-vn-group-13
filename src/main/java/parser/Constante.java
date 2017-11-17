package parser;

import model.Empresa;
import model.Periodo;
import model.Usuario;
import parser.Operando;

public class Constante implements Operando {

	private String valor;
	
	public Constante(String valor) {
		this.valor = valor;
	}
	
	@Override
	public Double resultado(Empresa empresa, Periodo periodo, Usuario usuario) {
		return Double.valueOf(valor);
	}
}
