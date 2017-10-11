package viewmodel;

import java.util.Collection;

import model.Empresa;
import utils.DB.PersistenciaDB;
import utils.File.ImportadorDeDatos;

public class MenuViewModel {

	public MenuViewModel(boolean cargarDatos) {
		ImportadorDeDatos importador = new ImportadorDeDatos();
		
		if(cargarDatos) {			
			importador.importarRepositorioDeEmpresas(System.getProperty("user.dir") + "/src/test/assets/Cuentas.txt");			
			importador.importarIndicadores(System.getProperty("user.dir") + "/src/test/assets/Indicadores.csv");
			importador.importarDeMetodologiasConCondiciones(System.getProperty("user.dir") + "/src/test/assets/Metodologias.csv");						
		}
		else {		
			importador.importarEmpresasDeDB();
			importador.importarIndicadoresDeDB();
			importador.importarMetodologiasYCondicionesDeDB();
		}
	}
}
