package model.metodologias;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import model.Metodologia;
import model.condiciones.taxativas.CondicionCrecienteTaxativa;
import model.condiciones.taxativas.CondicionTaxativa;

public class CondicionCrecienteTaxativaTest extends CondicionTest {

	@Test
	public void condicionMenorTaxativaConAplicacionPorConsistenciaTest() {
		CondicionTaxativa condicionCrecienteTaxativa = new CondicionCrecienteTaxativa(indicador, null, 3);
		Metodologia metodologia = new Metodologia("Cuenta 1 creciente en los ultimos 3 periodos", null, condicionCrecienteTaxativa);
		
		assertEquals(1, metodologia.evaluar(empresas).size());
	}
}
