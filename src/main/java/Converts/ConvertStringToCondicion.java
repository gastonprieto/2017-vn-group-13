package Converts;

import model.Condicion;
import model.FabricaCondicion;
import model.FabricaCondicionTaxativas;
import model.FabricaCondicionesDePrioridad;

/**
 * Created by rapap on 03/09/2017.
 */
public  class ConvertStringToCondicion {

    private DatoCompatable CondicionLeida;

    public ConvertStringToCondicion(String _lineaLeida){
        this.CondicionLeida = new DatoCompatable(_lineaLeida);
    }

    public Condicion Convertir(){
        FabricaCondicion fabricaCondicion = null;
        if(this.CondicionLeida.getSuperClassCondicion() == "CondicionDePrioridad"){
            fabricaCondicion = new FabricaCondicionesDePrioridad(this.CondicionLeida);
        }else if (this.CondicionLeida.getSuperClassCondicion() == "CondicionTaxativa"){
            fabricaCondicion = new FabricaCondicionTaxativas(this.CondicionLeida);
        }else {
            //Mandar excepcion
        }
        return fabricaCondicion.ObtenerCondicion();
    }

}
