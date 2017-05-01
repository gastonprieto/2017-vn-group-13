package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LectorDeArchivos {
	public String leerArchivo(String filePath) throws IOException {
		StringBuilder builder = new StringBuilder();
		for(String lineaLeida : Files.readAllLines(Paths.get(filePath))) {
			builder.append(lineaLeida);
		}
		return builder.toString();
	}
}