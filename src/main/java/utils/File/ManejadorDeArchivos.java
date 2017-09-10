package utils.File;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;

import exception.ParserException;

public class ManejadorDeArchivos {
	
	public String leerArchivoJson(String filePath) {
		try {
			StringBuilder builder = new StringBuilder();
			for(String lineaLeida : Files.readAllLines(Paths.get(filePath))) {
				builder.append(lineaLeida);
			}
			return builder.toString();
		} catch (IOException e) {
			throw new ParserException("Error leyendo el archivo: " + filePath);
		}
	}

	public Collection<String> leerArchivoCSV(String filePath) {
		try {
			File file = new File(filePath);
			if(file.exists()) {
				return Files.readAllLines(file.toPath());
			}
			return new ArrayList<>();
		} catch (IOException e) {
			throw new ParserException("Error leyendo el archivo: " + filePath);
		}
	}
	
	public void escribirArchivo(String filePath, String aEscribir) {
		try {
			File archivo = new File(filePath);
			if (!archivo.exists()) {
				archivo.createNewFile();
			}
			FileWriter writer = new FileWriter(filePath, true);
			writer.append(aEscribir);
			writer.append("\n");
			writer.flush();
		    writer.close();
		} catch (IOException e) {
			throw new ParserException("Error escribiendo el archivo: " + filePath);
		}
	}
}