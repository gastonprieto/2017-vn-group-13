package utils.Converts;

import Repositorio.RepositorioDeIndicadores;
import model.Indicador;
import exception.FabricaException;
import model.Condicion.Prioridad.*;

/**
 * Created by rapap on 08/09/2017.
 */
public class ConvertToCondicionPrioridad {

    protected String name;
    protected String indicador;
    protected String cantidadDePeriodos;
    protected String tipoCondicionPrioridad;

    public ConvertToCondicionPrioridad(String name, String indicador, String cantidadDePeriodos, String tipoCondicionPrioridad){
        this.name = name;
        this.indicador = indicador;
        this.cantidadDePeriodos = cantidadDePeriodos;
        this.tipoCondicionPrioridad = tipoCondicionPrioridad;
    }


    public CondicionPrioritaria Convertit() {
        Indicador indicador  = RepositorioDeIndicadores.getInstance().buscarIndicador(this.indicador);
        int CantidadDePeriodosParseada = Integer.parseInt(this.cantidadDePeriodos);
        if (this.tipoCondicionPrioridad.equals("Creciente")){
            return new CondicionCreciente(name, indicador, CantidadDePeriodosParseada);
        }else if (this.tipoCondicionPrioridad.equals("Decreciente")) {
            return new CondicionDecreciente(name, indicador, CantidadDePeriodosParseada);
        }else if (this.tipoCondicionPrioridad.equals("Maximizar")) {
            return new CondicionMaximizar(name, indicador, CantidadDePeriodosParseada);
        }else{
            throw new FabricaException("El Tipo de condiciones no corresponde a una Condicion de Prioridad, su valor es :" + this.tipoCondicionPrioridad);
        }
    }
}
