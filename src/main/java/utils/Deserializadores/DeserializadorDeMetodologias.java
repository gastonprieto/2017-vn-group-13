package utils.Deserializadores;

import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;

/**
 * Created by rapap on 09/09/2017.
 */
public class DeserializadorDeMetodologias {

    private String nombreMetodologia;
    private ArrayList<String> condcionesTaxativas;
    private ArrayList<String> condcionesDePrioridad;

    public DeserializadorDeMetodologias(String metodologiaLeida){

        String[] metdologiaLeida = StringUtils.splitByWholeSeparator(metodologiaLeida, "/");

        this.nombreMetodologia = metdologiaLeida[0];
        this.condcionesTaxativas = new ArrayList<>();
        this.condcionesDePrioridad = new ArrayList<>();

        String[] ListaCondicionesTaxativas = StringUtils.splitByWholeSeparator(metdologiaLeida[1], "&");

        for (int i = 0; i < ListaCondicionesTaxativas.length ; i++){
            this.condcionesTaxativas.add(ListaCondicionesTaxativas[i]);
        }

        String[] ListaCondicionesDePrioridad = StringUtils.splitByWholeSeparator(metdologiaLeida[1], "&");

        for (int i = 0; i < ListaCondicionesDePrioridad.length ; i++){
            this.condcionesDePrioridad.add(ListaCondicionesDePrioridad[i]);
        }
    }

    public String [] obtenerCondicionTaxativa(){
         String [] condicion = StringUtils.splitByWholeSeparator(this.condcionesTaxativas.iterator().next(), ",");
        this.condcionesTaxativas.iterator().remove();
        return condicion;
    }

    public String [] obtenerCondicionDePrioridad(){
        String [] condicion = StringUtils.splitByWholeSeparator(this.condcionesDePrioridad.iterator().next() /*.iterator().next()*/, ",");
        this.condcionesDePrioridad.iterator().remove();
        return condicion;
    }

    public boolean deserializacionCondicionesTaxativasFinalizada(){
        return this.condcionesTaxativas.isEmpty();
    }

    public boolean deserializacionCondicionesDePrioridadFinalizada(){
        return this.condcionesDePrioridad.isEmpty();
    }

    public String getNombreMetodologia() {
        return nombreMetodologia;
    }
}
