package utils.Converts;

import Repositorio.RepositorioDeIndicadores;
import model.Indicador;
import model.condiciones.taxativas.*;
import exception.FabricaException;


/**
 * Created by rapap on 08/09/2017.
 */
public class ConvertToCondicionTaxativa {

    protected String name;
    protected String calculo;
    protected Indicador indicador;
    protected int cantidadDePeriodos;
    protected String tipoCondicionTaxativa;
    protected Double valorDeReferencia;

    public ConvertToCondicionTaxativa(String _name, String _calculo, String _indiador, String _cantidadDePeriodos, String _tipoCondicionTaxativa, String _valorDeReferencia){
        this.name = _name;
        this.calculo = _calculo;
        this.indicador =  RepositorioDeIndicadores.getInstance().buscarIndicador(_indiador);
        this.cantidadDePeriodos = Integer.parseInt(_cantidadDePeriodos);
        this.tipoCondicionTaxativa = _tipoCondicionTaxativa;
        this.valorDeReferencia = Double.parseDouble(_valorDeReferencia);
    }


    public CondicionTaxativa Convertit() {
//        ConvertToCalculo convertCalculo = new ConvertToCalculo(this.calculo, this.indicador);
//        if(this.tipoCondicionTaxativa.equals("Mayor")) {
//            return new CondicionMayor(this.name, this.valorDeReferencia, this.cantidadDePeriodos, convertCalculo.Convertir());
//        }
//        if(this.tipoCondicionTaxativa.equals("Menor")){
//            return  new CondicionMenor(this.name, this.valorDeReferencia, this.cantidadDePeriodos, convertCalculo.Convertir());
//        }else{
//            throw new FabricaException("El Tipo de condiciones no corresponde a una Condicion Taxativa, su valor es :" + this.tipoCondicionTaxativa);
//        }
    	return null;
    }
}
