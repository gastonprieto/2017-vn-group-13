package utils.File;

import java.util.Collection;

import Repositorio.RepositorioDeEmpresas;
import Repositorio.RepositorioDeIndicadores;
import Repositorio.RepositorioDeMetodologias;
import org.apache.commons.lang.StringUtils;
import com.google.gson.Gson;
import model.*;
import utils.DB.PersistenciaDB;
import utils.Deserializadores.DeserializadorDeMetodologias;

public class ImportadorDeDatos {
	private ManejadorDeArchivos lectorDeArchivos;
	PersistenciaDB persistencia;
	
	public ImportadorDeDatos() {
		this.lectorDeArchivos = new ManejadorDeArchivos();
	}
	
	public void importarRepositorioDeEmpresas(String filePath) {
		String datosLeidos = this.lectorDeArchivos.leerArchivoJson(filePath);
		Gson gson = new Gson();
		RepositorioDeEmpresas.getInstance().setEmpresas(gson.fromJson(datosLeidos, RepositorioDeEmpresas.class).getEmpresas());		
		RepositorioDeEmpresas.getInstance().PerisistrEmprasasDelRepositorio(gson.fromJson(datosLeidos, RepositorioDeEmpresas.class).getEmpresas());
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

	public void importarDeMetodologiasConCondiciones(String filePath) {
		Metodologia NuevaMetodologia = null;
		DeserializadorDeMetodologias Dererializador = null;
		String [] condicion = null;
		Collection<String> lineasLeidas = this.lectorDeArchivos.leerArchivoCSV(filePath);


		if(!lineasLeidas.isEmpty()) { //--> Controlo que el archivo no esta vacio al memoento de levantar la persistencia

			for(String line : lineasLeidas) { //-->Recorro las lineas leidas del archivo

				Dererializador = new DeserializadorDeMetodologias(line);
				//NuevaMetodologia = new Metodologia(Dererializador.getNombreMetodologia());

				while (Dererializador.deserializacionCondicionesTaxativasFinalizada()){
					condicion = Dererializador.obtenerCondicionTaxativa();
				//	NuevaMetodologia.addCondicionTaxativa(condicion[0], condicion[1], condicion[2], condicion[3], condicion[4], condicion[5]);
				}

				while (Dererializador.deserializacionCondicionesDePrioridadFinalizada()){
					condicion = Dererializador.obtenerCondicionDePrioridad();
			//		NuevaMetodologia.addCondicionPrioridad(condicion[0], condicion[1], condicion[2], condicion[3]);
				}

				//RepositorioDeMetodologias.getInstance().registrarMetodologia(NuevaMetodologia);
			}
		}
	}
	
	public void importarEmpresasDeDB() {		
		RepositorioDeEmpresas.getInstance().setEmpresas(RepositorioDeEmpresas.getInstance().LeerEmpresasDeDB());
	}
	
	public void importarIndicadoresDeDB() {		
		RepositorioDeIndicadores.getInstance().setIndicadores(RepositorioDeIndicadores.getInstance().LeerIndicadoresDeDB());
	}
	
	public void importarMetodologiasYCondicionesDeDB() {		
		RepositorioDeMetodologias.getInstance().setMetodologias(persistencia.LeerMetodologiasYCondicionesDeDB());
	}

}
