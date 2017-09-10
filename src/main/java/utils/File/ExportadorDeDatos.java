package utils.File;

import model.Metodologia;
import utils.Serializadores.SerializadorDeMetodologias;


/**
 * Created by rapap on 03/09/2017.
 */
public class ExportadorDeDatos {

    private ManejadorDeArchivos EscritorDeArchivos;

    public ExportadorDeDatos() {
        this.EscritorDeArchivos = new ManejadorDeArchivos();
    }

    public void ExportadorDeMetodologia(String filePath, Metodologia metodologia){
       SerializadorDeMetodologias SerializadorM = new SerializadorDeMetodologias(metodologia);
       EscritorDeArchivos.escribirArchivo(filePath, SerializadorM.SerializarMe());
    }

}
