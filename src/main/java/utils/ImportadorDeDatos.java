package utils;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import Converts.ConvertStringToCondicion;
import model.*;
import org.apache.commons.lang.StringUtils;

import com.google.gson.Gson;

import javax.persistence.Convert;

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

	public void importarDeMetodologiasConCondiciones(String filePath) {
		//FabricaCondicion fabrica = null;
		//FabricaMetodologia fabricaMetodologia = null;
		ArrayList<Condicion> CondicionesCreadas = new ArrayList<>();
		//Indicador indicador;
		ConvertStringToCondicion Coversor;

		//Calculo calculo;
		Collection<String> lineasLeidas = this.lectorDeArchivos.leerArchivoCSV(filePath);
		if(!lineasLeidas.isEmpty()) {
			for(String line : lineasLeidas) {
				if(line.contains(":")) {
					String[] metdologiaLeida = StringUtils.splitByWholeSeparator(line, ":");
					String[] ListaCondiciones = StringUtils.splitByWholeSeparator(metdologiaLeida[1], "&");
					for (String unaCondicion : ListaCondiciones){
						if(unaCondicion == ""){ // para que era esta linea??
							Coversor = new ConvertStringToCondicion(unaCondicion);
							CondicionesCreadas.add(Coversor.Convertir());
						}

						/*if(unaCondicion == "") {
							String[] nuevaCondicion = StringUtils.splitByWholeSeparator(unaCondicion, ",");
							String[] tipoCondicion = StringUtils.splitByWholeSeparator(nuevaCondicion[1], ".");

							if (tipoCondicion[1] == "CondicionMayor" || tipoCondicion[1] == "CondicionMenor") {
								indicador = RepositorioDeIndicadores.getInstance().buscarIndicador(nuevaCondicion[3]);

								fabrica = new FabricaCondicionTaxativas(nuevaCondicion[0], nuevaCondicion[2], indicador, Integer.valueOf(nuevaCondicion[5]), tipoCondicion[1], Double.valueOf(nuevaCondicion[4]));
							}
							if (nuevaCondicion[1] == "CondicionTaxativa") {

								indicador = RepositorioDeIndicadores.getInstance().buscarIndicador(nuevaCondicion[2]);
								fabrica = new FabricaCondicionesDePrioridad(nuevaCondicion[0], indicador, Integer.valueOf(nuevaCondicion[3]), tipoCondicion[1]);
							}
							CondicionesCreadas.add(fabrica.ObtenerCondicion());
						}*/
					}

					//FabricaMetodologia = new FabricaMetodologia( metdologiaLeida[0] , CondicionesCreadas );
					RepositorioDeMetodologias.getInstance().registrarMetodologia(new Metodologia( metdologiaLeida[0] , CondicionesCreadas));

				}
			}
		}
	}
}
