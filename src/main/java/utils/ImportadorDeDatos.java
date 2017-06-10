package utils;

import java.util.Collection;

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
		Collection<String> lineasLeidas = this.lectorDeArchivos.leerArchivoCSV(filePath);
		if(!lineasLeidas.isEmpty()) {
			for(String line : lineasLeidas) {
				if(line.contains(",")) {
					String[] indicador = StringUtils.splitByWholeSeparator(line, ",");
					RepositorioDeIndicadores.getInstance().registrarIndicador(interpretador.interpretar(indicador[0], indicador[1]));
				}
			}
		}
	}
}
