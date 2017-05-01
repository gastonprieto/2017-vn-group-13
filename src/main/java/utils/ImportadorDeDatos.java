package utils;

import java.io.IOException;

import com.google.gson.Gson;

import model.CarteraDeEmpresas;

public class ImportadorDeDatos {
	private LectorDeArchivos lectorDeArchivos;
	
	public ImportadorDeDatos() {
		this.lectorDeArchivos = new LectorDeArchivos();
	}
	
	public void importarCarteraDeEmpresas(String filePath) throws IOException {
		String datosLeidos = this.lectorDeArchivos.leerArchivo(filePath);
		Gson gson = new Gson();
		CarteraDeEmpresas.setCartera(gson.fromJson(datosLeidos, CarteraDeEmpresas.class));
	}
}
