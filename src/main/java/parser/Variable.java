package parser;

import model.Empresa;
import model.Indicador;
import model.Periodo;
import model.Usuario;

public class Variable implements Operando {

	private String nombre;
	private Indicador indicador;
	
	public Variable(String nombre, Indicador indicador) {
		this.nombre = nombre;
		this.indicador = indicador;
	}
	
	@Override
	public Double resultado(Empresa empresa, Periodo periodo, Usuario usuario) {
		return indicador.buscarValor(nombre, empresa, periodo, usuario);
	}
}
