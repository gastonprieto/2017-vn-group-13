package viewmodel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.uqbar.commons.utils.Observable;

import model.CarteraDeEmpresas;
import model.Cuenta;
import model.Empresa;
import utils.ImportadorDeDatos;


@Observable
public class VentanaPrincipalViewModel {

	private Empresa empresaSeleccionada;
	private List<Cuenta> cuentasSeleccionadas;
	
	public VentanaPrincipalViewModel() { 		
		
		ImportadorDeDatos importador = new ImportadorDeDatos();
		importador.importarCarteraDeEmpresas(System.getProperty("user.dir") + "/src/test/assets/Cuentas.txt"); 		
	}
	
	public Collection<Empresa> getEmpresas(){
		
		return CarteraDeEmpresas.getInstance().getEmpresas();
		
	}
	
	public Empresa getEmpresaSeleccionada() {
		
		return empresaSeleccionada;
		
	}

	
   public String getNombreEmpresa() {
		
		return empresaSeleccionada.getName();
		
	}
	
	public void setEmpresaSeleccionada(Empresa empresaSeleccionada) {
		
		this.empresaSeleccionada = empresaSeleccionada;
		System.out.println(empresaSeleccionada.getName()); 
		
	}
	
	
	public Collection<Cuenta> getCuentasSeleccionadas(){
		
		return this.empresaSeleccionada.getCuentas(); 
	}
	
	
}