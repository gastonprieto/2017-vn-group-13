package viewmodel;

import java.util.Collection;

import model.Empresa;
import utils.DB.PersistenciaDB;
import utils.File.ImportadorDeDatos;

public class MenuViewModel {

	public MenuViewModel(boolean cargarDatos) {				
		if(cargarDatos) {			
			ImportadorDeDatos importador = new ImportadorDeDatos();
			importador.importarEmpresasDeDB();
			importador.importarIndicadoresDeDB();
			importador.importarMetodologiasYCondicionesDeDB();						
		}
	}
}
