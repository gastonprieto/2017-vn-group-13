package model.metodologias;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import model.Metodologia;
import model.condiciones.prioritarias.CondicionMenorPrioritaria;
import model.condiciones.prioritarias.CondicionPrioritaria;
import model.formas.de.aplicacion.FormaAplicacionEnum;

public class CondicionMenorPrioritariaTest extends CondicionTest {
	
	@Test
	public void condicionMenorPrioritariaConAplicacionSimpleTest() {
		CondicionPrioritaria condicionMenorPrioritaria =
				new CondicionMenorPrioritaria(indicador, FormaAplicacionEnum.AplicacionSimple, null, 1);
		Metodologia metodologia = new Metodologia("Ordena de mayor a menor por el valor de la Cuenta 1", condicionMenorPrioritaria, null);
		
		assertEquals("Empresa 1", metodologia.evaluar(empresas).iterator().next().getName());
	}
	
	@Test
	public void condicionMenorPrioritariaConAplicacionPorSumatoriaTest() {
		CondicionPrioritaria condicionMenorPrioritaria =
				new CondicionMenorPrioritaria(indicador, FormaAplicacionEnum.AplicacionPorSumatoria, null, 3);
		Metodologia metodologia = new Metodologia("Ordena de mayor a menor por la sumatoria de la Cuenta 1 en los ultimos 3 periodos",
				condicionMenorPrioritaria, null);
		
		assertEquals("Empresa 1", metodologia.evaluar(empresas).iterator().next().getName());
	}
	
	@Test
	public void condicionMenorPrioritariaConAplicacionPorPromedioTest() {
		CondicionPrioritaria condicionMenorPrioritaria = 
				new CondicionMenorPrioritaria(indicador, FormaAplicacionEnum.AplicacionPorPromedio, null, 3);
		Metodologia metodologia = new Metodologia("Ordena de mayor a menor por el promedio de la Cuenta 1 en los ultimos 3 periodos",
				condicionMenorPrioritaria, null);
		
		assertEquals("Empresa 1", metodologia.evaluar(empresas).iterator().next().getName());
	}
	
	@Test
	public void condicionMenorPrioritariaConAplicacionPorMedianaTest() {
		CondicionPrioritaria condicionMenorPrioritaria = 
				new CondicionMenorPrioritaria(indicador, FormaAplicacionEnum.AplicacionPorMediana, null, 3);
		Metodologia metodologia = new Metodologia("Ordena de mayor a menor por el promedio de la Cuenta 1 en los ultimos 3 periodos",
				condicionMenorPrioritaria, null);
		
		assertEquals("Empresa 1", metodologia.evaluar(empresas).iterator().next().getName());
	}
	
	@Test
	public void condicionMenorPrioritariaConAplicacionPorConsistenciaTest() {
		CondicionPrioritaria condicionMenorPrioritaria = 
				new CondicionMenorPrioritaria(indicador, FormaAplicacionEnum.AplicacionPorConsistencia, null, 3);
		Metodologia metodologia = new Metodologia("Ordena de mayor a menor por la consistencia de la Cuenta 1 en los ultimos 3 periodos",
				condicionMenorPrioritaria, null);
		
		assertEquals("Empresa 1", metodologia.evaluar(empresas).iterator().next().getName());
	}
}
