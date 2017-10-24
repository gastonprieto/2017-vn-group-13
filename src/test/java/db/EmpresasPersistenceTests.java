package db;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

import Repositorio.RepositorioDeEmpresas;
import model.Cuenta;
import model.Empresa;
import model.Periodo;
import static org.junit.Assert.assertEquals;

public class EmpresasPersistenceTests {

	private EntityManager em = PerThreadEntityManagers.getEntityManager();
	
	@Before
	public void setUp() {
		em.getTransaction().begin();
	}
	
	@After
	public void tearDown() {
		em.getTransaction().rollback();
	}
	
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
