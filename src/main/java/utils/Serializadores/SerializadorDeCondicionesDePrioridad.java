package utils.Serializadores;


import java.util.Collection;

import model.Condicion.Prioridad.*;
/**
 * Created by rapap on 08/09/2017.
 */
public class SerializadorDeCondicionesDePrioridad {
    private Collection<CondicionPrioritaria> Lista;
    private String contenido ;

    public SerializadorDeCondicionesDePrioridad(Collection<CondicionPrioritaria> _lista){
        this.Lista = _lista;
        this.contenido = "";
    }

    public String  Serializar(){
        Lista.removeIf(c -> this.sumar(c, this.Lista.size()==1));
        return this.contenido;
    }

    private boolean sumar(CondicionPrioritaria condicionRemovida, boolean UltimoElemento){
        contenido += (condicionRemovida.getClassClean() + "," +
                      condicionRemovida.getName() + "," +
                      condicionRemovida.getIndicador().getNombre() + "," +
                      condicionRemovida.getCantidadDePeriodos()  +
                      (!UltimoElemento ? "&" : "" ) );
        return true;
    }

}
