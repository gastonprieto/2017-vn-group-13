package utils.Serializadores;

import model.Metodologia;

import java.util.ArrayList;

/**
 * Created by rapap on 08/09/2017.
 */
public class SerializadorDeMetodologias {


    private Metodologia metodologia;
    private ArrayList<String> CondicionesSerializadas ;

    public SerializadorDeMetodologias(Metodologia _metodologia){
        this.metodologia = _metodologia;
        this.CondicionesSerializadas  = new ArrayList<String>();
    }

    public String  SerializarMe(){
//        SerializadorDeCondicionesTaxativas SerializadorT = new SerializadorDeCondicionesTaxativas(this.metodologia.getCondicionesTaxativas());
//        SerializadorDeCondicionesDePrioridad SerializadorP = new SerializadorDeCondicionesDePrioridad(this.metodologia.getCondicionesPrioridad());
//        return  this.metodologia.getNombre() + "/" + SerializadorT.Serializar() + "/" + SerializadorP.Serializar();
    	return "a";
    }
}
