package db;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;

import model.Cuenta;
import model.Empresa;
import model.Periodo;
import repositorios.RepositorioDeEmpresas;

public class EmpresasPersistenceTests extends PersistenceTests {
	
	@Test
	public void findCuentaByEmpresaAndPeriodoAndNombreTest() {
		
		Empresa empresa = new Empresa();
		empresa.setName("Empresa Test");
		
		Cuenta cuenta = new Cuenta("Cuenta Test", 10.0, new Periodo(2017, 2));
		cuenta.setEmpresa(empresa);
		Collection<Cuenta> cuentas = new ArrayList<>();
		cuentas.add(cuenta);
		empresa.setCuentas(cuentas);
		
		em.persist(empresa);

		Cuenta cuentaRecuperada = RepositorioDeEmpresas.getInstance()
				.findCuentaByEmpresaAndPeriodoAndNombre(empresa, cuenta.getPeriodo(), cuenta.getName());
		assertEquals(cuenta.getValue(), cuentaRecuperada.getValue());
		assertEquals(cuenta.getName(), cuentaRecuperada.getName());
		assertEquals(cuenta.getPeriodo().getSemester(), cuentaRecuperada.getPeriodo().getSemester());
		assertEquals(cuenta.getPeriodo().getYear(), cuentaRecuperada.getPeriodo().getYear());
	}
}
