package model;

import exception.ConvertsException;
import exception.FabricaException;
import model.Condicion.Prioridad.CondicionPrioridad;
import model.Condicion.Taxativa.CondicionTaxativa;
import org.uqbar.commons.utils.Observable;
import utils.Converts.ConvertToCondicionPrioridad;
import utils.Converts.ConvertToCondicionTaxativa;

import java.util.Collection;
import java.util.ArrayList;

@Observable
public class Metodologia {

    private String nombre;
    private Collection<CondicionPrioridad> condicionesPrioridad;
    private Collection<CondicionTaxativa> condicionesTaxativas;

    public Metodologia(String nombre){
        this.nombre = nombre;
        this.condicionesPrioridad = new ArrayList<CondicionPrioridad>();
        this.condicionesTaxativas = new ArrayList<CondicionTaxativa>();
    }

    public Metodologia(){
        this.nombre = "";
        this.condicionesPrioridad = new ArrayList<CondicionPrioridad>();
        this.condicionesTaxativas = new ArrayList<CondicionTaxativa>();
    }

    public void addCondicionTaxativa(String _classCondicion,
                             String _nameCondicion,
                             String _nameIndicador,
                             String _classCalculo,
                             String _cantidadDePeriodos,
                             String _valorDeReferencia){
        ConvertToCondicionTaxativa NuevoConvertTaxativa = new ConvertToCondicionTaxativa(_nameCondicion, _classCalculo, _nameIndicador, _cantidadDePeriodos, _classCondicion, _valorDeReferencia);
        try {
            this.condicionesTaxativas.add(NuevoConvertTaxativa.Convertit());
        }catch (Exception a){
            throw new ConvertsException("Aaa No se pudo convertir a ningun tipo de subcondicion de Taxativa a '" +  _classCondicion + "' del nombre : " + _nameCondicion + "Porque  " + a.getMessage());
        }

    }

    public void addCondicionPrioridad(String _classCondicion,
                                     String _nameCondicion,
                                     String _nameIndicador,
                                     String _cantidadDePeriodos){
        ConvertToCondicionPrioridad NuevoConvertPrioridad = new ConvertToCondicionPrioridad( _nameCondicion, _nameIndicador, _cantidadDePeriodos,_classCondicion);;
        if(this.condicionesPrioridad.size() < 2){
            try{
                this.condicionesPrioridad.add(NuevoConvertPrioridad.Convertit());
            }catch (ConvertsException e){
                throw e;
            }
        }else {
            throw new ConvertsException("No se pudo crear la condicion de orden, debido a que ya llegaste al tope, mejorar este mensaje");
        }
    }


    public void removeCondicion(Object condicion){
        this.condicionesTaxativas.removeIf(c -> c.equals(condicion));
        this.condicionesPrioridad.removeIf(c -> c.equals(condicion));
    }

	public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Collection<CondicionTaxativa> getCondicionesTaxativas() {
        return condicionesTaxativas;
    }

    public Collection<CondicionPrioridad> getCondicionesPrioridad() {
        return condicionesPrioridad;
    }

    public void setCondicionesTaxativas(Collection<CondicionTaxativa> condicionesTaxativas) {
        this.condicionesTaxativas = condicionesTaxativas;
    }

    public void setCondicionesPrioridad(Collection<CondicionPrioridad> condicionesPrioridad) {
        this.condicionesPrioridad = condicionesPrioridad;
    }
}
