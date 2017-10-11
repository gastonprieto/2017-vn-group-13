package viewmodel;

import utils.DB.PersistenciaDB;
import utils.File.ImportadorDeDatos;

public class MenuViewModel {

	public MenuViewModel(boolean cargarDatos) {
		if(cargarDatos) {
			ImportadorDeDatos importador = new ImportadorDeDatos();
			importador.importarRepositorioDeEmpresas(System.getProperty("user.dir") + "/src/test/assets/Cuentas.txt");
			importador.importarIndicadores(System.getProperty("user.dir") + "/src/test/assets/Indicadores.csv");
			importador.importarDeMetodologiasConCondiciones(System.getProperty("user.dir") + "/src/test/assets/Metodologias.csv");
			
			PersistenciaDB persistencia = new PersistenciaDB();
			persistencia.persistirMetodologiaYCondiciones();
			
			
			/*Collection<Metodologia> metodologias = RepositorioDeMetodologias.getInstance().getMetodologias();
			int x = 0;*/
		}
	}
}
