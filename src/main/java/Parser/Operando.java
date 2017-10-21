package Parser;

import model.Empresa;
import model.Periodo;

public interface Operando {
	public Double resultado(Empresa empresa, Periodo periodo);
}
