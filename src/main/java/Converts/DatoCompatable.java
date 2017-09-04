package Converts;

import model.Condicion;
import org.apache.commons.lang.StringUtils;

/**
 * Created by rapap on 03/09/2017.
 */
public class DatoCompatable {

    private String SuperClassCondicion;
    private String ClassCondicion;
    private String NameCondicion;
    private String NameIndicador;
    private String ClassCalculo;
    private String CantDePeriodos;
    private String ValorDeReferencia;

    public DatoCompatable(String _lineaLeida){

        String [] coleccionDeString = StringUtils.splitByWholeSeparator(_lineaLeida, ",");
        String[] superClassCondicion = StringUtils.splitByWholeSeparator(coleccionDeString[0], ".");
        String[] classCondicion = StringUtils.splitByWholeSeparator(coleccionDeString[1], ".");

        this.SuperClassCondicion = superClassCondicion[2];
        this.ClassCondicion = classCondicion[1];
        this.NameCondicion = coleccionDeString[2];
        this.NameIndicador = coleccionDeString[3];
        this.ClassCalculo = coleccionDeString[4];
        this.CantDePeriodos = coleccionDeString[5];
        this.ValorDeReferencia = coleccionDeString[6];
    }

    public DatoCompatable(Condicion condicion){
        this.SuperClassCondicion = condicion.getClass().getSuperclass().toString();
        this.ClassCondicion = condicion.getClass().toString();
        this.NameCondicion = condicion.getName();
        this.CantDePeriodos = condicion.getCantDePeriodos().toString();

        if(this.SuperClassCondicion.equals("CondicionTaxativa")){
            this.NameIndicador = condicion.getCalculo().getIndicador().getNombre().toString();
            this.ClassCalculo = condicion.getCalculo().getClass().toString();
            this.ValorDeReferencia = condicion.getValorDeReferencia().toString();
        }else if (this.SuperClassCondicion.equals("CondicionPrioridad")){
            this.NameIndicador = condicion.getIndicador().getNombre();
            this.ClassCalculo = "NULL";
            this.ValorDeReferencia = "NULL";
        }else{
            /*Aca debiera haber una excepcion*/
        }

    }

    public String Compatame(){
        return SuperClassCondicion + ClassCondicion + NameCondicion + NameIndicador + ClassCalculo + CantDePeriodos + ValorDeReferencia;
    }


    public String getSuperClassCondicion() {
        return SuperClassCondicion;
    }

    public String getClassCondicion() {
        return ClassCondicion;
    }

    public String getNameCondicion() {
        return NameCondicion;
    }

    public String getNameIndicador() {
        return NameIndicador;
    }

    public String getClassCalculo() {
        return ClassCalculo;
    }

    public String getCantDePeriodos() {
        return CantDePeriodos;
    }

    public String getValorDeReferencia() {
        return ValorDeReferencia;
    }


}
