package viewmodel;

import java.util.ArrayList;
import java.util.List;

import org.uqbar.commons.utils.Observable;

import com.google.gson.Gson;

import model.Empresa;

@Observable
public class VentanaPrincipalViewModel {

	private List<Empresa> empresasuax;
	
	private void recibirEmpresasConCuentas() {
		 List<Empresa> empresasaux = JsonUtils.readCuentasFromFile(System.getProperty("user.dir") + "/tests/assets/Cuentas.txt");
	}
	
	public List<Empresa> getAsignaciones() {
		List<Empresa> empresas = new List<>();
		for(Empresa empresa : empresasaux) {
			empresas.add(empresa);
		}
		return empresas;
	}
	
	
}
