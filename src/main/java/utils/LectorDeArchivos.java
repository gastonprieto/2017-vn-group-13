package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import exception.ParserException;

public class LectorDeArchivos {
	
	public String leerArchivo(String filePath) {
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
}