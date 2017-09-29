package model.condiciones.prioritarias;

import model.Indicador;
import model.formas.de.aplicacion.AplicacionForma;
import model.formas.de.aplicacion.FormaAplicacion;

import javax.persistence.Entity;

@Entity
public class CondicionMenorPrioritaria extends CondicionPrioritaria {

	public CondicionMenorPrioritaria(Indicador indicador, FormaAplicacion formaAplicacion, CondicionPrioritaria condicionDesempate, int cantPeriodos,
			AplicacionForma aplicacionForma) {
		this.indicador = indicador;
		this.formaAplicacion = formaAplicacion;
		this.condicionDesempate = condicionDesempate;
		this.cantPeriodos = cantPeriodos;
		this.aplicacionForma = aplicacionForma;
	}

	public CondicionMenorPrioritaria(Indicador indicador, FormaAplicacion formaAplicacion, int cantPeriodos, AplicacionForma aplicacionForma) {
		this.indicador = indicador;
		this.formaAplicacion = formaAplicacion;
		this.cantPeriodos = cantPeriodos;
		this.aplicacionForma = aplicacionForma;
	}

	@Override
	public int comparar(double resultadoEmpresa1, double resultadoEmpresa2) {
		// Devuelve un numero positivo si el segundo es el menor, cero si son iguales y un numero negativo si el primero es el menor
		return Double.compare(resultadoEmpresa1, resultadoEmpresa2);
	}
}
