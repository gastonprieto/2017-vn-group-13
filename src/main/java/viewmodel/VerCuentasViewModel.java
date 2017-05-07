package viewmodel;

import java.util.Collection;

import org.uqbar.commons.utils.Observable;

import model.CarteraDeEmpresas;
import model.Empresa;
import utils.ImportadorDeDatos;

@Observable
public class VerCuentasViewModel {
	private Empresa empresaSeleccionada;
	
	public VerCuentasViewModel() { 		
		ImportadorDeDatos importador = new ImportadorDeDatos();
		importador.importarCarteraDeEmpresas(System.getProperty("user.dir") + "/src/test/assets/Cuentas.txt"); 		
	}
	
	public Collection<Empresa> getEmpresas(){
		return CarteraDeEmpresas.getInstance().getEmpresas();
	}
	
	public Empresa getEmpresaSeleccionada() {
		return empresaSeleccionada;
	}

	public void setEmpresaSeleccionada(Empresa empresaSeleccionada) {
		this.empresaSeleccionada = empresaSeleccionada;
	}
}