package utils;

import java.io.IOException;
import java.util.TimerTask;

import com.google.gson.Gson;

import model.Empresa;
import repositorios.RepositorioDeEmpresas;

public class ImportadorDeDatos extends TimerTask {
	
	@Override
	public void run() {
		try {
			LectorDeArchivos lectorDeArchivos = new LectorDeArchivos();
			while(!lectorDeArchivos.lecturaFinalizada()) {
				Gson gson = new Gson();
				Empresa empresa = gson.fromJson(lectorDeArchivos.leerSiguiente(), Empresa.class);
				RepositorioDeEmpresas.getInstance().guardarEmpresa(empresa);
			}
			lectorDeArchivos.cerrar();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
