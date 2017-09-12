package utils.Serializadores;

import java.util.Collection;

import model.condiciones.taxativas.*;

/**
 * Created by rapap on 08/09/2017.
 */
public class  SerializadorDeCondicionesTaxativas {

    private Collection<CondicionTaxativa> Lista;
    private String contenido ;

    public SerializadorDeCondicionesTaxativas(Collection<CondicionTaxativa> _lista){
        this.Lista = _lista;
        this.contenido = "";
    }

    public String  Serializar(){
        Lista.removeIf(c -> this.sumar(c, this.Lista.size()==1));
        return this.contenido;
    }

    private boolean sumar(CondicionTaxativa condicionRemovida, boolean UltimoElemento){
        contenido += (condicionRemovida.getClassClean() + "," +
                      condicionRemovida.getName() + "," +
                      condicionRemovida.getCalculo().getIndicador().getNombre() + "," +
                      condicionRemovida.getClassClean() + "," +
                      condicionRemovida.getCantidadDePeriodos() + "," +
                      condicionRemovida.getValorDeReferencia().toString() +
                      (!UltimoElemento ? "&" : "" ) );
        return true;

    }
}
