package utils;

import org.apache.commons.lang.StringUtils;

import com.google.gson.Gson;

import model.RepositorioDeEmpresas;
import model.RepositorioDeIndicadores;

public class ImportadorDeDatos {
	private ManejadorDeArchivos lectorDeArchivos;
	
	public ImportadorDeDatos() {
		this.lectorDeArchivos = new ManejadorDeArchivos();
	}
	
	public void importarRepositorioDeEmpresas(String filePath) {
		String datosLeidos = this.lectorDeArchivos.leerArchivoJson(filePath);
		Gson gson = new Gson();
		RepositorioDeEmpresas.getInstance().setEmpresas(gson.fromJson(datosLeidos, RepositorioDeEmpresas.class).getEmpresas());
	}
	
	public void importarIndicadores(String filePath) {
		InterpretadorDeIndicadores interpretador = new InterpretadorDeIndicadores();
		for(String line : this.lectorDeArchivos.leerArchivoCSV(filePath)) {
			String[] indicador = StringUtils.splitByWholeSeparator(line, ",");
			RepositorioDeIndicadores.getInstance().registrarIndicador(interpretador.interpretar(indicador[0], indicador[1]));
		}
	}
}
