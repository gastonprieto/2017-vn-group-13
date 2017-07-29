package model;


/**
 * Created by rapap on 29/07/2017.
 */
public abstract class FabricaCondicionTaxativas extends FabricaCondicion {

    protected String name;
    protected String calculo;
    protected Indicador indicador;
    protected int cantidadDePeriodos;
    protected String tipoCondicionTaxativa;
    protected  Double valorDeReferencia;

    public FabricaCondicionTaxativas(String _name, String _calculo, Indicador _indiador, int _cantidadDePeriodos, String _tipoCondicionTaxativa, Double _valorDeReferencia){
        this.name = _name;
        this.calculo = _calculo;
        this.indicador = _indiador;
        this.cantidadDePeriodos = _cantidadDePeriodos;
        this.tipoCondicionTaxativa = _tipoCondicionTaxativa;
        this.valorDeReferencia = _valorDeReferencia;
    }

    @Override
    protected Condicion CrearCondicion() {
        FabricaCalculos fabrica = new FabricaCalculos(this.calculo, this.indicador);
        if(this.tipoCondicionTaxativa == "Mayor") {
            return new CondicionMayor(this.name, this.valorDeReferencia, this.cantidadDePeriodos, fabrica.CrearCalculo());
        }
         if(this.tipoCondicionTaxativa == "Menor"){
            return  new CondicionMenor(this.name, this.valorDeReferencia, this.cantidadDePeriodos, fabrica.CrearCalculo());
        }
        return null;
    }
}
