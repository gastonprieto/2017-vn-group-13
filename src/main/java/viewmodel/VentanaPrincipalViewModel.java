package viewmodel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.uqbar.commons.utils.Observable;

import model.CarteraDeEmpresas;
import model.Empresa;


@Observable
public class VentanaPrincipalViewModel {

	private Empresa empresaSeleccionada;
	
	public List<Empresa> getEmpresas(){
		
		return CarteraDeEmpresas.getCartera().getEmpresas();
		
	}
	
	public Empresa getEmpresaSeleccionada() {
		return empresaSeleccionada;
	}


	public void setEmpresaSeleccionada(Empresa empresaSeleccionada) {
		this.empresaSeleccionada = empresaSeleccionada;
	}

}