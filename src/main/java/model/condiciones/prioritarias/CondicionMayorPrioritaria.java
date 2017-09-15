package model.condiciones.prioritarias;

import model.Indicador;
import model.formas.de.aplicacion.FormaAplicacion;

public class CondicionMayorPrioritaria extends CondicionPrioritaria {
	
	public CondicionMayorPrioritaria(Indicador indicador, FormaAplicacion formaAplicacion, CondicionPrioritaria condicionDesempate) {
		this.indicador = indicador;
		this.formaAplicacion = formaAplicacion;
		this.condicionDesempate = condicionDesempate;
	}

	public CondicionMayorPrioritaria(Indicador indicador, FormaAplicacion formaAplicacion) {
		this.indicador = indicador;
		this.formaAplicacion = formaAplicacion;
	}

	@Override
	public int comparar(double resultadoEmpresa1, double resultadoEmpresa2) {
		// Devuelve un numero postivo si el primero es el menor, cero si son iguales y un numero negativo si el segundo es el menor
		return 0 - Double.compare(resultadoEmpresa1, resultadoEmpresa2);
	}
}
