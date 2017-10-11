package model.metodologias;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import model.Metodologia;
import model.condiciones.taxativas.CondicionMenorTaxativa;
import model.condiciones.taxativas.CondicionTaxativa;
import model.formas.de.aplicacion.FormaAplicacionEnum;

public class CondicionMenorTaxativaTest extends CondicionTest {
	
	@Test
	public void condicionMenorTaxativaConAplicacionSimpleTest() {
		CondicionTaxativa condicionMenorTaxativa = 
				new CondicionMenorTaxativa(indicador, FormaAplicacionEnum.AplicacionSimple, null, 2, 1);
		Metodologia metodologia = new Metodologia("Cuenta 1 menor a 2 en el ultimo periodo", null, condicionMenorTaxativa);
		
		assertEquals(1, metodologia.evaluar(empresas).size());
	}
	
	@Test
	public void condicionMenorTaxativaConAplicacionPorSumatoriaTest() {
		CondicionTaxativa condicionMenorTaxativa =
				new CondicionMenorTaxativa(indicador, FormaAplicacionEnum.AplicacionPorSumatoria, null, 7, 3);
		Metodologia metodologia = new Metodologia("Sumatoria en los ultimos 3 periodos de la Cuenta 1 menor a 7", null, condicionMenorTaxativa);
		
		assertEquals(1, metodologia.evaluar(empresas).size());
	}
	
	@Test
	public void condicionMenorTaxativaConAplicacionPorPromedioTest() {
		CondicionTaxativa condicionMenorTaxativa =
				new CondicionMenorTaxativa(indicador, FormaAplicacionEnum.AplicacionPorPromedio, null, 2, 3);
		Metodologia metodologia = new Metodologia("Promedio de los ultimos 3 periodos de la Cuenta 1 menor a 2", null, condicionMenorTaxativa);
		
		assertEquals(1, metodologia.evaluar(empresas).size());
	}
	
	@Test
	public void condicionMenorTaxativaConAplicacionPorMedianaTest() {
		CondicionTaxativa condicionMenorTaxativa =
				new CondicionMenorTaxativa(indicador, FormaAplicacionEnum.AplicacionPorMediana, null, 3, 3);
		Metodologia metodologia = new Metodologia("Mediana de los ultimos 3 periodos de la Cuenta 1 menor a 3", null, condicionMenorTaxativa);
		
		assertEquals(1, metodologia.evaluar(empresas).size());
	}
	
	@Test
	public void condicionMenorTaxativaConAplicacionPorConsistenciaTest() {
		CondicionTaxativa condicionMenorTaxativa =
				new CondicionMenorTaxativa(indicador, FormaAplicacionEnum.AplicacionPorConsistencia, null, 3.5, 3);
		Metodologia metodologia = new Metodologia("Cuenta 1 menor a 3.5 en los ultimos 3 periodos", null, condicionMenorTaxativa);
		
		assertEquals(1, metodologia.evaluar(empresas).size());
	}
}
