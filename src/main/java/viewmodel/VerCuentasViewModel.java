package viewmodel;

import java.util.Collection;

import org.uqbar.commons.utils.Observable;

import model.Empresa;
import model.RepositorioDeEmpresas;

@Observable
public class VerCuentasViewModel {
	private Empresa empresaSeleccionada;
	
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