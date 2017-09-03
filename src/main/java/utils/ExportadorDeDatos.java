package utils;

import Converts.ConvertCondicionToString;
import model.Condicion;
import model.Metodologia;


/**
 * Created by rapap on 03/09/2017.
 */
public class ExportadorDeDatos {

    private ManejadorDeArchivos EscritorDeArchivos;

    public ExportadorDeDatos() {
        this.EscritorDeArchivos = new ManejadorDeArchivos();
    }

    public void ExportadorDeMetodologia(String filePath, Metodologia metodologia){
        ConvertCondicionToString conversor;

        StringBuilder builderCondiciones = new StringBuilder();

        builderCondiciones.append(": ");
        for(Condicion condicion : metodologia.condiciones) {
            conversor = new ConvertCondicionToString(condicion);
            builderCondiciones.append(conversor.Convertir());
            builderCondiciones.append("&");
        }

        builderCondiciones.toString();

        EscritorDeArchivos.escribirArchivo(filePath,metodologia.getNombre() + builderCondiciones);

    }

}
