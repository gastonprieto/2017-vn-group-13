package utils;

import com.google.gson.Gson;

import model.CarteraDeEmpresas;

public class ImportadorDeDatos {
	private LectorDeArchivos lectorDeArchivos;
	
	public ImportadorDeDatos() {
		this.lectorDeArchivos = new LectorDeArchivos();
	}
	
	public void importarCarteraDeEmpresas(String filePath) {
		String datosLeidos = this.lectorDeArchivos.leerArchivo(filePath);
		Gson gson = new Gson();
		CarteraDeEmpresas.getInstance().setEmpresas(gson.fromJson(datosLeidos, CarteraDeEmpresas.class).getEmpresas());
	}
}
