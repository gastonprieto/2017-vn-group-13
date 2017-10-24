package db;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Repositorio.RepositorioDeIndicadores;
import model.Indicador;
import utils.File.InterpretadorDeIndicadores;

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
