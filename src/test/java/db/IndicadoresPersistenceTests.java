package db;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import model.Indicador;
import repositorios.RepositorioDeIndicadores;
import utils.InterpretadorDeIndicadores;

public class IndicadoresPersistenceTests extends PersistenceTests {

	@Test
	public void buscarIndicadorTest() {
		
		InterpretadorDeIndicadores interpretador = new InterpretadorDeIndicadores();
		Indicador indicador = interpretador.interpretar("Indicador Test", "1");
		
		em.persist(indicador);
		
		Indicador indicadorRecuperado = RepositorioDeIndicadores.getInstance().buscarIndicador(indicador.getNombre());
		assertEquals(indicador.getNombre(), indicadorRecuperado.getNombre());
		assertEquals(indicador.aplicar(null, null), indicadorRecuperado.aplicar(null, null));
	}
}
