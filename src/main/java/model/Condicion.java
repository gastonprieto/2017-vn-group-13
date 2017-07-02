package model;

import scala.xml.dtd.PEReference;

/**
 * Created by rapap on 01/07/2017.
 */
public class Condicion {

    public Indicador indicador1;
    public Indicador indicador2;


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

    public boolean MayorQueUnValor(Empresa empresa, double valor, Periodo perido){
        if(this.indicador1.aplicar(empresa, perido)> valor){
            return false;
        }
        return  true;
    }

    public boolean MayorQueEntreIndicadores(Empresa empresa, Periodo perido){
        if(this.indicador1.aplicar(empresa, perido)> this.indicador2.aplicar(empresa, perido)){
            return false;
        }
        return  true;
    }



    public boolean MenorQueValor(){
        return true;
    }

    public boolean CrecienteEnUnLapzoDeTiempo(Empresa empresa, int LosUltimosNanios){

        Periodo perido = new Periodo( 2017 - LosUltimosNanios , 1);
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
}
