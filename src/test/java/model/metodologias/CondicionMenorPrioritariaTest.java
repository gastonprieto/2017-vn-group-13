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
		CondicionPrioritaria condicionMenorPrioritaria = new CondicionMenorPrioritaria(indicador, aplicacionSimple, null, 1);
		Metodologia metodologia = new Metodologia("Ordena de mayor a menor por el valor de la Cuenta 1", condicionMenorPrioritaria, null);
		
		assertEquals("Empresa 1", metodologia.evaluar(empresas).iterator().next().getName());
	}
	
	@Test
	public void condicionMenorPrioritariaConAplicacionPorSumatoriaTest() {
		FormaAplicacion aplicacionPorSumatoria = new AplicacionPorSumatoria();
		CondicionPrioritaria condicionMenorPrioritaria = new CondicionMenorPrioritaria(indicador, aplicacionPorSumatoria, null, 3);
		Metodologia metodologia = new Metodologia("Ordena de mayor a menor por la sumatoria de la Cuenta 1 en los ultimos 3 periodos",
				condicionMenorPrioritaria, null);
		
		assertEquals("Empresa 1", metodologia.evaluar(empresas).iterator().next().getName());
	}
	
	@Test
	public void condicionMenorPrioritariaConAplicacionPorPromedioTest() {
		FormaAplicacion aplicacionPorPromedio = new AplicacionPorPromedio();
		CondicionPrioritaria condicionMenorPrioritaria = new CondicionMenorPrioritaria(indicador, aplicacionPorPromedio, null, 3);
		Metodologia metodologia = new Metodologia("Ordena de mayor a menor por el promedio de la Cuenta 1 en los ultimos 3 periodos",
				condicionMenorPrioritaria, null);
		
		assertEquals("Empresa 1", metodologia.evaluar(empresas).iterator().next().getName());
	}
	
	@Test
	public void condicionMenorPrioritariaConAplicacionPorMedianaTest() {
		FormaAplicacion aplicacionPorMediana = new AplicacionPorMediana();
		CondicionPrioritaria condicionMenorPrioritaria = new CondicionMenorPrioritaria(indicador, aplicacionPorMediana, null, 3);
		Metodologia metodologia = new Metodologia("Ordena de mayor a menor por el promedio de la Cuenta 1 en los ultimos 3 periodos",
				condicionMenorPrioritaria, null);
		
		assertEquals("Empresa 1", metodologia.evaluar(empresas).iterator().next().getName());
	}
	
	@Test
	public void condicionMenorPrioritariaConAplicacionPorConsistenciaTest() {		
		FormaAplicacion aplicacionPorConsistencia = new AplicacionPorConsistencia();
		CondicionPrioritaria condicionMenorPrioritaria = new CondicionMenorPrioritaria(indicador, aplicacionPorConsistencia, null, 3);
		Metodologia metodologia = new Metodologia("Ordena de mayor a menor por la consistencia de la Cuenta 1 en los ultimos 3 periodos",
				condicionMenorPrioritaria, null);
		
		assertEquals("Empresa 1", metodologia.evaluar(empresas).iterator().next().getName());
	}
}
