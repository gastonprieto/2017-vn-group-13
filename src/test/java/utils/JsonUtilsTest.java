package utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import exception.ParserException;
import model.CarteraDeEmpresas;
import model.Cuenta;
import model.Empresa;
import model.Periodo;

public class JsonUtilsTest {	
	ImportadorDeDatos importador;
	
	Empresa retornoEsperadoEmpresa;
	
	private Cuenta cuenta1;
	private Cuenta cuenta2;
	private Cuenta cuenta3;
	
	private Periodo periodo1;
	private Periodo periodo2;
	private Periodo periodo3;
	
	@Before
	public void setUp() {
		
		importador = new ImportadorDeDatos();
		importador.importarCarteraDeEmpresas(System.getProperty("user.dir") + "/src/test/assets/Cuentas.txt");
		
		retornoEsperadoEmpresa = new Empresa();
		
		cuenta1 = new Cuenta();
		cuenta1.setName("Cuenta 1");
		cuenta1.setValue((double) 1);
		
		Periodo periodo1 = new Periodo();
		periodo1.setSemester(2);
		periodo1.setYear(2016);
		cuenta1.setPeriodo(periodo1);
		
		cuenta2 = new Cuenta();
		cuenta2.setName("Cuenta 2");
		cuenta2.setValue((double) 5);
		
		periodo2 = new Periodo();
		periodo2.setSemester(2);
		periodo2.setYear(2016);
		cuenta2.setPeriodo(periodo2);
				
		cuenta3 = new Cuenta();
		cuenta3.setName("Cuenta 1");
		cuenta3.setValue((double) 5);
		
		periodo3 = new Periodo();	
		periodo3.setSemester(0);
		periodo3.setYear(0);
		cuenta3.setPeriodo(periodo3);
	}
	
	@After
    public void tearDown() {
		CarteraDeEmpresas.getInstance().getEmpresas().clear();
	}		
	
	@Test
	public void leerEmpresaTest() throws ParserException {								
		ArrayList<Cuenta> listaCuentasEmpresa1 = new ArrayList<Cuenta>();
		listaCuentasEmpresa1.add(cuenta1);
		listaCuentasEmpresa1.add(cuenta2);
				
		retornoEsperadoEmpresa.setName("Empresa 1");
		retornoEsperadoEmpresa.setCuentas(listaCuentasEmpresa1);													
		
		assertTrue(CarteraDeEmpresas.getInstance().getEmpresas().contains(retornoEsperadoEmpresa));
	}
	
	@Test
	public void leerEmpresaSinCuentasTest() throws ParserException {
		ArrayList<Cuenta> listaCuentasEmpresa6 = new ArrayList<Cuenta>();		
				
		retornoEsperadoEmpresa.setName("Empresa 6");			
		retornoEsperadoEmpresa.setCuentas(listaCuentasEmpresa6);
		
		assertTrue(CarteraDeEmpresas.getInstance().getEmpresas().contains(retornoEsperadoEmpresa));
	}
	
	@Test
	public void leerEmpresaConUnaCuentaSinPeriodoTest() throws ParserException {
		ArrayList<Cuenta> listaCuentasEmpresa7 = new ArrayList<Cuenta>();
		listaCuentasEmpresa7.add(cuenta3);
				
		retornoEsperadoEmpresa.setName("Empresa 7");					
		retornoEsperadoEmpresa.setCuentas(listaCuentasEmpresa7);
		
		assertTrue(CarteraDeEmpresas.getInstance().getEmpresas().contains(retornoEsperadoEmpresa));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
