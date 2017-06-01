package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.Collection;

import exception.ParserException;

public class ImportadorDeIndicadores {
	
	private static final char DEFAULT_SEPARATOR = ',';
	private static final String ARCHIVO_INDICADORES = System.getProperty("user.dir") + "/src/test/assets/Indicadores.csv";
	
	private void guardarIndicador(String nombreIndicador, String calculo) {		
		try {					       		    
		    File file = new File(ARCHIVO_INDICADORES);

			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter writer = new FileWriter(file.getPath(), true);
			
			writeLine(writer, Arrays.asList(nombreIndicador, calculo));
		    
		    writer.flush();
		    writer.close();
					
		} catch (IOException e) {
			throw new ParserException("Error escribiendo el archivo: " + ARCHIVO_INDICADORES);
		}				
	}	
	
	private String leerIndicadores() {
		String line = ""; 
		StringBuilder builder = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO_INDICADORES))) {        	        

            while ((line = br.readLine()) != null) {

            	builder.append(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return builder.toString();
	}

    public static void writeLine(Writer w, Collection<String> values) throws IOException {
        writeLine(w, values, DEFAULT_SEPARATOR, ' ');
    }

    public static void writeLine(Writer w, Collection<String> values, char separators) throws IOException {
        writeLine(w, values, separators, ' ');
    }

    private static String followCVSformat(String value) {

        String result = value;
        if (result.contains("\"")) {
            result = result.replace("\"", "\"\"");
        }
        return result;

    }

    public static void writeLine(Writer w, Collection<String> values, char separators, char customQuote) throws IOException {

        boolean first = true;

        if (separators == ' ') {
            separators = DEFAULT_SEPARATOR;
        }

        StringBuilder sb = new StringBuilder();
        for (String value : values) {
            if (!first) {
                sb.append(separators);
            }
            if (customQuote == ' ') {
                sb.append(followCVSformat(value));
            } else {
                sb.append(customQuote).append(followCVSformat(value)).append(customQuote);
            }

            first = false;
        }
        sb.append("\n");
        w.append(sb.toString());
    }

}
