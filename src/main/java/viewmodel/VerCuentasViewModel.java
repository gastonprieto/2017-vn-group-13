package viewmodel;

import java.util.Collection;

import org.uqbar.commons.utils.Observable;

import model.Empresa;
import model.RepositorioDeEmpresas;
import utils.ImportadorDeDatos;

@Observable
public class VerCuentasViewModel {
	private Empresa empresaSeleccionada;
	
	public VerCuentasViewModel() { 		
		ImportadorDeDatos importador = new ImportadorDeDatos();
		importador.importarRepositorioDeEmpresas(System.getProperty("user.dir") + "/src/test/assets/Cuentas.txt"); 		
	}
	
	public Collection<Empresa> getEmpresas(){
		return RepositorioDeEmpresas.getInstance().getEmpresas();
	}
	
	public Empresa getEmpresaSeleccionada() {
		return empresaSeleccionada;
	}

	public void setEmpresaSeleccionada(Empresa empresaSeleccionada) {
		this.empresaSeleccionada = empresaSeleccionada;
	}
}