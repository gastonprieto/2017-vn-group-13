package model.Condicion.Prioridad;

import model.Empresa;
import model.Indicador;
import model.Periodo;
import model.formasDeAplicacion.FormaAplicacion;

public class CondicionMayorPrioritaria extends CondicionPrioritaria {
	
	public CondicionMayorPrioritaria(Indicador indicador, FormaAplicacion formaAplicacion, CondicionPrioritaria condicionDesempate) {
		this.indicador = indicador;
		this.formaAplicacion = formaAplicacion;
		this.condicionDesempate = condicionDesempate;
	}

	@Override
	public int comparar(Empresa empresa1, Empresa empresa2, Periodo periodo) {
		// Devuelve un numero negativo si el primero es el menor, cero si son iguales y un numero postivo si el segundo es el menor
		return Double.compare(this.indicador.aplicar(empresa1, periodo), this.indicador.aplicar(empresa2, periodo));
	}
}
