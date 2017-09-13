package model.metodologias;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;

import model.Cuenta;
import model.Empresa;
import model.Indicador;
import model.Periodo;
import utils.File.InterpretadorDeIndicadores;

public abstract class CondicionTest {
	
	protected List<Empresa> empresas;
	protected InterpretadorDeIndicadores interpretadorDeIndicadores = new InterpretadorDeIndicadores();
	protected Indicador indicador = interpretadorDeIndicadores.interpretar("Indicador 1", "Cuenta 1");
	
	@Before
	public void setUp() {
		empresas = new ArrayList<>();
		
		List<Cuenta> cuentasEmpresa1 = new ArrayList<>();
		
		Cuenta cuenta1Empresa1 = new Cuenta();
		cuenta1Empresa1.setName("Cuenta 1");
		cuenta1Empresa1.setPeriodo(new Periodo(2017, 1));
		cuenta1Empresa1.setValue(-2D);
		cuentasEmpresa1.add(cuenta1Empresa1);
		
		Cuenta cuenta2Empresa1 = new Cuenta();
		cuenta2Empresa1.setName("Cuenta 1");
		cuenta2Empresa1.setPeriodo(new Periodo(2016, 2));
		cuenta2Empresa1.setValue(-1D);
		cuentasEmpresa1.add(cuenta2Empresa1);
		
		Cuenta cuenta3Empresa1 = new Cuenta();
		cuenta3Empresa1.setName("Cuenta 1");
		cuenta3Empresa1.setPeriodo(new Periodo(2016, 1));
		cuenta3Empresa1.setValue(0D);
		cuentasEmpresa1.add(cuenta3Empresa1);
		
		Empresa empresa1 = new Empresa();
		empresa1.setName("Empresa 1");
		empresa1.setCuentas(cuentasEmpresa1);
		
		empresas.add(empresa1);

		List<Cuenta> cuentasEmpresa2 = new ArrayList<>();
		
		Cuenta cuenta1Empresa2 = new Cuenta();
		cuenta1Empresa2.setName("Cuenta 1");
		cuenta1Empresa2.setPeriodo(new Periodo(2017, 1));
		cuenta1Empresa2.setValue(5D);
		cuentasEmpresa2.add(cuenta1Empresa2);
		
		Cuenta cuenta2Empresa2 = new Cuenta();
		cuenta2Empresa2.setName("Cuenta 1");
		cuenta2Empresa2.setPeriodo(new Periodo(2016, 2));
		cuenta2Empresa2.setValue(4D);
		cuentasEmpresa2.add(cuenta2Empresa2);
		
		Cuenta cuenta3Empresa2 = new Cuenta();
		cuenta3Empresa2.setName("Cuenta 1");
		cuenta3Empresa2.setPeriodo(new Periodo(2016, 1));
		cuenta3Empresa2.setValue(3D);
		cuentasEmpresa2.add(cuenta3Empresa2);
		
		Empresa empresa2 = new Empresa();
		empresa2.setName("Empresa 2");
		empresa2.setCuentas(cuentasEmpresa2);
		
		empresas.add(empresa2);
	}
}
