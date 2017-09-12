package model.metodologias;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import model.Metodologia;
import model.condiciones.prioritarias.CondicionMenorPrioritaria;
import model.condiciones.prioritarias.CondicionPrioritaria;
import model.formas.de.aplicacion.AplicacionPorConsistencia;
import model.formas.de.aplicacion.AplicacionPorMediana;
import model.formas.de.aplicacion.AplicacionPorPromedio;
import model.formas.de.aplicacion.AplicacionPorSumatoria;
import model.formas.de.aplicacion.AplicacionSimple;
import model.formas.de.aplicacion.FormaAplicacion;

public class CondicionMenorPrioritariaTest extends CondicionTest {
	
	@Test
	public void condicionMenorPrioritariaConAplicacionSimpleTest() {
		FormaAplicacion aplicacionSimple = new AplicacionSimple();
		CondicionPrioritaria condicionMenorPrioritaria = new CondicionMenorPrioritaria(indicador, aplicacionSimple, null);
		Metodologia metodologia = new Metodologia("Ordena de mayor a menor por el valor de la Cuenta 1", condicionMenorPrioritaria, null);
		
		assertEquals("Empresa 1", metodologia.evaluar(empresas).get(0).getName());
	}
	
	@Test
	public void condicionMenorPrioritariaConAplicacionPorSumatoriaTest() {
		FormaAplicacion aplicacionPorSumatoria = new AplicacionPorSumatoria(3);
		CondicionPrioritaria condicionMenorPrioritaria = new CondicionMenorPrioritaria(indicador, aplicacionPorSumatoria, null);
		Metodologia metodologia = new Metodologia("Ordena de mayor a menor por la sumatoria de la Cuenta 1 en los ultimos 3 periodos",
				condicionMenorPrioritaria, null);
		
		assertEquals("Empresa 1", metodologia.evaluar(empresas).get(0).getName());
	}
	
	@Test
	public void condicionMenorPrioritariaConAplicacionPorPromedioTest() {
		FormaAplicacion aplicacionPorPromedio = new AplicacionPorPromedio(3);
		CondicionPrioritaria condicionMenorPrioritaria = new CondicionMenorPrioritaria(indicador, aplicacionPorPromedio, null);
		Metodologia metodologia = new Metodologia("Ordena de mayor a menor por el promedio de la Cuenta 1 en los ultimos 3 periodos",
				condicionMenorPrioritaria, null);
		
		assertEquals("Empresa 1", metodologia.evaluar(empresas).get(0).getName());
	}
	
	@Test
	public void condicionMenorPrioritariaConAplicacionPorMedianaTest() {
		FormaAplicacion aplicacionPorMediana = new AplicacionPorMediana(3);
		CondicionPrioritaria condicionMenorPrioritaria = new CondicionMenorPrioritaria(indicador, aplicacionPorMediana, null);
		Metodologia metodologia = new Metodologia("Ordena de mayor a menor por el promedio de la Cuenta 1 en los ultimos 3 periodos",
				condicionMenorPrioritaria, null);
		
		assertEquals("Empresa 1", metodologia.evaluar(empresas).get(0).getName());
	}
	
	@Test
	public void condicionMenorPrioritariaConAplicacionPorConsistenciaTest() {		
		FormaAplicacion aplicacionPorConsistencia = new AplicacionPorConsistencia(3);
		CondicionPrioritaria condicionMenorPrioritaria = new CondicionMenorPrioritaria(indicador, aplicacionPorConsistencia, null);
		Metodologia metodologia = new Metodologia("Ordena de mayor a menor por la consistencia de la Cuenta 1 en los ultimos 3 periodos",
				condicionMenorPrioritaria, null);
		
		assertEquals("Empresa 1", metodologia.evaluar(empresas).get(0).getName());
	}
}
