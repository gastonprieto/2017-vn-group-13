package viewmodel;

import utils.ImportadorDeDatos;

public class MenuViewModel {

	public MenuViewModel(boolean cargarDatos) {
		if(cargarDatos) {
			ImportadorDeDatos importador = new ImportadorDeDatos();
			importador.importarRepositorioDeEmpresas(System.getProperty("user.dir") + "/src/test/assets/Cuentas.txt");
			importador.importarIndicadores(System.getProperty("user.dir") + "/src/test/assets/Indicadores.csv");
			importador.importarDeMetodologiasConCondiciones(System.getProperty("user.dir") + "/src/test/assets/Metodologias.csv");

		}
	}
}
