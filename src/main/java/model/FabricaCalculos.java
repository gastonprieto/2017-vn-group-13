package model;



/**
 * Created by rapap on 29/07/2017.
 */
public class FabricaCalculos {

    protected  String tipoDeCalculo;
    protected Indicador indicador;

    public FabricaCalculos(String _tipoDeCalculo, Indicador _inicador){
        this.tipoDeCalculo = _tipoDeCalculo;
        this.indicador = _inicador;
    }

    public Calculo CrearCalculo() {

        if(this.tipoDeCalculo == "Sumatoria") {
            return new Sumatoria(this.indicador);
        }
        if(this.tipoDeCalculo == "Promedio") {
            return new Promedio(this.indicador);
        }
        if(this.tipoDeCalculo == "Mediana") {
            return new Mediana(this.indicador);
        }
            return null;
    }

}
