package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LectorDeArchivos {
	
	private File archivo;
	private FileReader fileReader;
	private BufferedReader bufferedReader;
	
	public LectorDeArchivos() throws FileNotFoundException {
		archivo = new File(System.getProperty("user.dir") + "/src/main/resources/json/cuentas.json");
		fileReader = new FileReader(archivo);
		bufferedReader = new BufferedReader(fileReader);
	}

	public boolean lecturaFinalizada() throws IOException {
		return !bufferedReader.ready();
	}

	public String leerSiguiente() throws IOException {
		return bufferedReader.readLine();
	}
	
	public void cerrar( ) throws IOException {
		bufferedReader.close();
		fileReader.close();
		archivo.delete();
	}
}
