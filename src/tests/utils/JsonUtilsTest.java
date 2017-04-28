package utils;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

import model.Cuenta;
import model.Empresa;

public class JsonUtilsTest {

	@Test
	public void readCuentasTest() throws IOException {
		List<Empresa> empresas = JsonUtils.readCuentasFromFile(System.getProperty("user.dir") + "/assets/Cuentas.txt");
		for(Empresa empresa : empresas) {
			System.out.println("Empresa: " + empresa.getName());
			for(Cuenta cuenta : empresa.getCuentas()) {
				System.out.println("Cuenta: " + cuenta.getName() + ". Valor: " + cuenta.getValue() + ". Semestre: "
									+ cuenta.getSemester() + ". Anio: " + cuenta.getYear());
			}
		}
		assertEquals(5, empresas.size());
	}
	
	@Test(expected = IOException.class)
	public void readCuentasFileNotFoundTest() throws IOException {
		JsonUtils.readCuentasFromFile(System.getProperty("user.dir") + "/tests/assets/CuentasOtro.txt");		
	}
}
