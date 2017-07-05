package model;

import scala.xml.dtd.PEReference;

/**
 * Created by rapap on 01/07/2017.
 */
public class Condicion {

    public Indicador indicador1;
    public Indicador indicador2;

    public Condicion(){}


    public Condicion(Indicador _indicador1, Indicador _indicador2){
        this.indicador1 = _indicador1;
        this.indicador2 = _indicador2;
    }

    public Indicador getIndicador1() {
        return indicador1;
    }

    public void setIndicador1(Indicador indicador1) {
        this.indicador1 = indicador1;
    }

    public Indicador getIndicador2() {
        return indicador2;
    }

    public void setIndicador2(Indicador indicador2) {
        this.indicador2 = indicador2;
    }

    public boolean MayorQue(Empresa empresa, double valor, Periodo perido){
        return this.indicador1.aplicar(empresa, perido)> valor;
    }

    public boolean MenorQue(Empresa empresa, double valor, Periodo perido){
        return this.indicador1.aplicar(empresa, perido)< valor;
    }


    public boolean MayorQueEnUnLapsoDeTiempo(Empresa empresa, int year, double valor){

        Periodo perido = new Periodo( 2017 - year , 1);

        Double valorConsultado = 0.0;

        valorConsultado = indicador1.aplicar(empresa, perido);

        while(perido.SiguienteSemestre()) { //Aca estyo suponiendo que un indicador no tiene valor hasta haber terminado el perido
            if (valorConsultado >valor) {
                valorConsultado = indicador1.aplicar(empresa, perido);
            }else {
                return false;
            }
        }
        return true;
    }


    public boolean CrecienteEnUnLapsoDeTiempo(Empresa empresa, int year){

        Periodo perido = new Periodo( 2017 - year , 1);
        Double valorMayor = 0.0;
        Double valorConsultado = 0.0;

        valorMayor = indicador1.aplicar(empresa, perido);

        while(perido.SiguienteSemestre()) { //Aca estyo suponiendo que un indicador no tiene valor hasta haber terminado el perido
            valorConsultado = indicador1.aplicar(empresa, perido);
            if (valorMayor < valorConsultado) {
                valorMayor = valorConsultado;
            }else {
                return false;
            }
        }
        return true;
    }

    public boolean DecrecienteEnUnLapsoDeTiemp(Empresa empresa, int year){
        return true;
    }


}
