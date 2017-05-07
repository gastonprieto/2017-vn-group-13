package utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

import model.CarteraDeEmpresas;
import model.Cuenta;
import model.Empresa;

public class JsonUtilsTest {

	@Test
	public void readCuentasTest() throws IOException {
		//LectorDeArchivos lector = new LectorDeArchivos();
		//String datosLeidos = lector.leerArchivo(System.getProperty("user.dir") + "/src/test/assets/Cuentas.txt");
		//System.out.println(datosLeidos);
		
		ImportadorDeDatos importador = new ImportadorDeDatos();
		importador.importarCarteraDeEmpresas(System.getProperty("user.dir") + "/src/test/assets/Cuentas.txt");
		assertEquals(5, CarteraDeEmpresas.getInstance().getEmpresas().size());
	}
	
	@Test(expected = IOException.class)
	public void readCuentasFileNotFoundTest() throws IOException {
		//LectorDeArchivos.readCuentasFromFile(System.getProperty("user.dir") + "/tests/assets/CuentasOtro.txt");		
	}
	
	@Test
	public void leerEmpresaTest() throws IOException {				
		Cuenta cuenta1 = new Cuenta();
		cuenta1.setName("Cuenta 1");
		cuenta1.setValue((double) 1);			
		
		Cuenta cuenta2 = new Cuenta();
		cuenta2.setName("Cuenta 2");
		cuenta2.setValue((double) 5);		
		
		ArrayList<Cuenta> listaCuentasEmpresa1 = new ArrayList<Cuenta>();
		listaCuentasEmpresa1.add(cuenta1);
		listaCuentasEmpresa1.add(cuenta2);
		
		Empresa retornoEsperadoEmpresa = new Empresa();
		retornoEsperadoEmpresa.setName("Empresa 1");
		retornoEsperadoEmpresa.setCuentas(listaCuentasEmpresa1);					
						
		ImportadorDeDatos importador = new ImportadorDeDatos();
		importador.importarCarteraDeEmpresas(System.getProperty("user.dir") + "/src/test/assets/Cuentas.txt");
		
		assertTrue(CarteraDeEmpresas.getInstance().getEmpresas().contains(retornoEsperadoEmpresa));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
