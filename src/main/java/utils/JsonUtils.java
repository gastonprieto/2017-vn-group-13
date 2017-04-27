package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import model.Empresa;

public class JsonUtils {
	public static List<Empresa> readCuentasFromFile(String filePath) throws IOException {
		List<Empresa> empresas = new ArrayList<>();
		Gson gson = new Gson();
		File inputFile = new File(filePath);
		FileReader fileReader = new FileReader(inputFile);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String buffer;
		while((buffer = bufferedReader.readLine()) != null) {
			empresas.add(gson.fromJson(buffer, Empresa.class));
		}
		bufferedReader.close();
		return empresas;
	}
}