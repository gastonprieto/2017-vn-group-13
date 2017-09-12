package model.metodologias;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import model.Metodologia;
import model.condiciones.taxativas.CondicionDecrecienteTaxativa;
import model.condiciones.taxativas.CondicionTaxativa;

public class CondicionDecrecienteTaxativaTest extends CondicionTest {

	@Test
	public void condicionDecrecienteTaxativaConAplicacionPorConsistenciaTest() {
		CondicionTaxativa condicionDecrecienteTaxativa = new CondicionDecrecienteTaxativa(indicador, null, 3);
		Metodologia metodologia = new Metodologia("Cuenta 1 decreciente en los ultimos 3 periodos", null, condicionDecrecienteTaxativa);
		
		assertEquals(1, metodologia.evaluar(empresas).size());
	}
}
