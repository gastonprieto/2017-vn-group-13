package model.metodologias;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import model.Metodologia;
import model.condiciones.taxativas.CondicionMenorTaxativa;
import model.condiciones.taxativas.CondicionTaxativa;
import model.formas.de.aplicacion.AplicacionPorConsistencia;
import model.formas.de.aplicacion.AplicacionPorMediana;
import model.formas.de.aplicacion.AplicacionPorPromedio;
import model.formas.de.aplicacion.AplicacionPorSumatoria;
import model.formas.de.aplicacion.AplicacionSimple;
import model.formas.de.aplicacion.FormaAplicacion;

public class CondicionMenorTaxativaTest extends CondicionTest {
	
	@Test
	public void condicionMenorTaxativaConAplicacionSimpleTest() {
		FormaAplicacion aplicacionSimple = new AplicacionSimple();
		CondicionTaxativa condicionMenorTaxativa = new CondicionMenorTaxativa(indicador, aplicacionSimple, null, 2);
		Metodologia metodologia = new Metodologia("Cuenta 1 menor a 2 en el ultimo periodo", null, condicionMenorTaxativa);
		
		assertEquals(1, metodologia.evaluar(empresas).size());
	}
	
	@Test
	public void condicionMenorTaxativaConAplicacionPorSumatoriaTest() {
		FormaAplicacion aplicacionPorSumatoria = new AplicacionPorSumatoria(3);
		CondicionTaxativa condicionMenorTaxativa = new CondicionMenorTaxativa(indicador, aplicacionPorSumatoria, null, 7);
		Metodologia metodologia = new Metodologia("Sumatoria en los ultimos 3 periodos de la Cuenta 1 menor a 7", null, condicionMenorTaxativa);
		
		assertEquals(1, metodologia.evaluar(empresas).size());
	}
	
	@Test
	public void condicionMenorTaxativaConAplicacionPorPromedioTest() {
		FormaAplicacion aplicacionPorPromedio = new AplicacionPorPromedio(3);
		CondicionTaxativa condicionMenorTaxativa = new CondicionMenorTaxativa(indicador, aplicacionPorPromedio, null, 2);
		Metodologia metodologia = new Metodologia("Promedio de los ultimos 3 periodos de la Cuenta 1 menor a 2", null, condicionMenorTaxativa);
		
		assertEquals(1, metodologia.evaluar(empresas).size());
	}
	
	@Test
	public void condicionMenorTaxativaConAplicacionPorMedianaTest() {
		FormaAplicacion aplicacionPorMediana = new AplicacionPorMediana(3);
		CondicionTaxativa condicionMenorTaxativa = new CondicionMenorTaxativa(indicador, aplicacionPorMediana, null, 3);
		Metodologia metodologia = new Metodologia("Mediana de los ultimos 3 periodos de la Cuenta 1 menor a 3", null, condicionMenorTaxativa);
		
		assertEquals(1, metodologia.evaluar(empresas).size());
	}
	
	@Test
	public void condicionMenorTaxativaConAplicacionPorConsistenciaTest() {
		FormaAplicacion aplicacionPorConsistencia = new AplicacionPorConsistencia(3);
		CondicionTaxativa condicionMenorTaxativa = new CondicionMenorTaxativa(indicador, aplicacionPorConsistencia, null, 3.5);
		Metodologia metodologia = new Metodologia("Cuenta 1 menor a 3.5 en los ultimos 3 periodos", null, condicionMenorTaxativa);
		
		assertEquals(1, metodologia.evaluar(empresas).size());
	}
}
