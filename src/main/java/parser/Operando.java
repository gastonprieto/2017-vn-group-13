package parser;

import model.Empresa;
import model.Periodo;
import model.Usuario;

public interface Operando {
	public Double resultado(Empresa empresa, Periodo periodo, Usuario usuario);
}
