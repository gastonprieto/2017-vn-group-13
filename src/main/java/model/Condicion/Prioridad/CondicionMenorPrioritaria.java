package model.Condicion.Prioridad;

import model.Indicador;
import model.formasDeAplicacion.FormaAplicacion;

public class CondicionMenorPrioritaria extends CondicionPrioritaria {

	public CondicionMenorPrioritaria(Indicador indicador, FormaAplicacion formaAplicacion, CondicionPrioritaria condicionDesempate) {
		this.indicador = indicador;
		this.formaAplicacion = formaAplicacion;
		this.condicionDesempate = condicionDesempate;
	}

	@Override
	public int comparar(double resultadoEmpresa1, double resultadoEmpresa2) {
		// Devuelve un numero negativo si el segundo es el menor, cero si son iguales y un numero postivo si el primero es el menor
		return 0 - Double.compare(resultadoEmpresa1, resultadoEmpresa2);
	}
}
