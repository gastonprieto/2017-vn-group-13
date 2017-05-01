package utils;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import model.CarteraDeEmpresas;

public class JsonUtilsTest {

	@Test
	public void readCuentasTest() throws IOException {
		//LectorDeArchivos lector = new LectorDeArchivos();
		//String datosLeidos = lector.leerArchivo(System.getProperty("user.dir") + "/src/test/assets/Cuentas.txt");
		//System.out.println(datosLeidos);
		
		ImportadorDeDatos importador = new ImportadorDeDatos();
		importador.importarCarteraDeEmpresas(System.getProperty("user.dir") + "/src/test/assets/Cuentas.txt");
		assertEquals(5, CarteraDeEmpresas.getCartera().getEmpresas().size());
	}
	
	@Test(expected = IOException.class)
	public void readCuentasFileNotFoundTest() throws IOException {
		//LectorDeArchivos.readCuentasFromFile(System.getProperty("user.dir") + "/tests/assets/CuentasOtro.txt");		
	}
}
