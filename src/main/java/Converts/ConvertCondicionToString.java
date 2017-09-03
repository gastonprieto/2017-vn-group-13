package Converts;

import model.Condicion;
import model.FabricaCondicion;
import model.FabricaCondicionTaxativas;
import model.FabricaCondicionesDePrioridad;

/**
 * Created by rapap on 03/09/2017.
 */
public class ConvertCondicionToString {
    private DatoCompatable CondicionLeida;

    public ConvertCondicionToString(Condicion condicion){
        this.CondicionLeida = new DatoCompatable(condicion);
    }

    public String Convertir(){
        return CondicionLeida.Compatame();
    }

}
