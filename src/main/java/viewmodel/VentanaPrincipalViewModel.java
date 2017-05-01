package viewmodel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.uqbar.commons.utils.Observable;

import model.Empresa;
import utils.LectorDeArchivos;

@Observable
public class VentanaPrincipalViewModel {

	private List<Empresa> empresasuax;
	
	public void recibirEmpresasConCuentas() throws IOException {
		//empresasuax = LectorDeArchivos.readCuentasFromFile(System.getProperty("user.dir") + "/tests/assets/Cuentas.txt");
	}
	
	public List<Empresa> getAsignaciones() {
		List<Empresa> empresas = new ArrayList<>();
		for(Empresa empresa : empresasuax) {
			empresas.add(empresa);
		}
		return empresas;
	}
	
	
}
