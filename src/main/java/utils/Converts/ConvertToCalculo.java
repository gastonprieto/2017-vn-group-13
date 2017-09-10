package utils.Converts;

import model.Calculo.Calculo;
import model.Calculo.Mediana;
import model.Calculo.Promedio;
import model.Calculo.Sumatoria;
import model.Indicador;

/**
 * Created by rapap on 08/09/2017.
 */
public class ConvertToCalculo {
    protected  String tipoDeCalculo;
    protected Indicador indicador;

    public ConvertToCalculo(String _tipoDeCalculo, Indicador _inicador){
        this.tipoDeCalculo = _tipoDeCalculo;
        this.indicador = _inicador;
    }

    public Calculo Convertir() {

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
