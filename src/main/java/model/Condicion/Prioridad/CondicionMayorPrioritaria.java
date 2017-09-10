package model.Condicion.Prioridad;

import model.Indicador;
import model.formasDeAplicacion.FormaAplicacion;

public class CondicionMayorPrioritaria extends CondicionPrioritaria {
	
	public CondicionMayorPrioritaria(Indicador indicador, FormaAplicacion formaAplicacion, CondicionPrioritaria condicionDesempate) {
		this.indicador = indicador;
		this.formaAplicacion = formaAplicacion;
		this.condicionDesempate = condicionDesempate;
	}

	@Override
	public int comparar(double resultadoEmpresa1, double resultadoEmpresa2) {
		// Devuelve un numero negativo si el primero es el menor, cero si son iguales y un numero postivo si el segundo es el menor
		return Double.compare(resultadoEmpresa1, resultadoEmpresa2);
	}
}
