package utils;

import com.google.gson.Gson;

import model.RepositorioDeEmpresas;

public class ImportadorDeDatos {
	private LectorDeArchivos lectorDeArchivos;
	
	public ImportadorDeDatos() {
		this.lectorDeArchivos = new LectorDeArchivos();
	}
	
	public void importarRepositorioDeEmpresas(String filePath) {
		String datosLeidos = this.lectorDeArchivos.leerArchivo(filePath);
		Gson gson = new Gson();
		RepositorioDeEmpresas.getInstance().setEmpresas(gson.fromJson(datosLeidos, RepositorioDeEmpresas.class).getEmpresas());
	}
}
