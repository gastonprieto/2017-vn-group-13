package viewmodel;

import Repositorio.RepositorioDeIndicadores;
import Repositorio.RepositorioDeMetodologias;
import model.Indicador;
import model.Metodologia;
import model.condiciones.prioritarias.CondicionPrioritaria;

import org.uqbar.commons.utils.Observable;
import utils.File.ExportadorDeDatos;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by rapap on 09/09/2017.
 */

@Observable
public class CreadorMetodologiasViewModel {

    private ExportadorDeDatos manejadorDeArchivos = new ExportadorDeDatos();

    //Panel de Botones Sueprior
    private Metodologia metodologia = null;

    //Panel Metodologia
    private String nombreMetodologia;

    //Panel Condiciones Orden
    private String nombreCondicionPrioridad;
    private String condicionSeleccionadaPrioridad;
    private Indicador indicadorSeleccionadoPrioridad;
    private String cantidadDePeriodosPrioridad;
    private CondicionPrioritaria condicioneTablaPrioridadSeleccionada;

    //Panel Condiciones Filtro
    private String nombreCondicionTaxativa;
    private String condicionSeleccionadaTaxativa;
    private Indicador indicadorSeleccionadoTaxativa;
    private String cantidadDePeriodosTaxativa;
    private String tipoCalculoSeleccionadoTaxativa;
    private String valoreDeReferenciaTaxativa;





    private Collection<String> tiposCondiciones;

    /* FUNCIONES */

    public void AgregarCondicionOrden(){
        metodologia.addCondicionPrioridad( condicionSeleccionadaPrioridad ,nombreCondicionPrioridad, indicadorSeleccionadoPrioridad.getNombre(), cantidadDePeriodosPrioridad);
    }

    public void AgregarCondicionFiltro(){
        metodologia.addCondicionTaxativa(condicionSeleccionadaTaxativa ,nombreCondicionTaxativa, indicadorSeleccionadoTaxativa.getNombre(), tipoCalculoSeleccionadoTaxativa, cantidadDePeriodosTaxativa, valoreDeReferenciaTaxativa);
    }

    public void NuevaMetodologia(){
        metodologia = new Metodologia();
    }

    public void GuardarMetodologia(){
        metodologia.setNombre(nombreMetodologia);
        manejadorDeArchivos.ExportadorDeMetodologia(System.getProperty("user.dir") + "/src/test/assets/Metodologias.csv", metodologia);
        RepositorioDeMetodologias.getInstance().registrarMetodologia(metodologia);
        metodologia = new Metodologia();
    }

    /* GETTERS AND SETTERS*/

    public CondicionPrioritaria getCondicioneTablaPrioridadSeleccionada() {

        return condicioneTablaPrioridadSeleccionada;
    }

    public void setCondicioneTablaPrioridadSeleccionada(CondicionPrioritaria condicioneTablaPrioridadSeleccionada) {
        this.condicioneTablaPrioridadSeleccionada = condicioneTablaPrioridadSeleccionada;
    }

    public Collection<CondicionPrioritaria> getCondicionesPrioridadMetodologia(){
        return metodologia.getCondicionesPrioridad();
    }

    public Metodologia getMetodologia() {
        return metodologia;
    }

    public void setMetodologia(Metodologia metodologia) {
        this.metodologia = metodologia;
    }


    public ExportadorDeDatos getManejadorDeArchivos() {
        return manejadorDeArchivos;
    }

    public void setManejadorDeArchivos(ExportadorDeDatos manejadorDeArchivos) {
        this.manejadorDeArchivos = manejadorDeArchivos;
    }

    public String getNombreCondicionPrioridad() {
        return nombreCondicionPrioridad;
    }

    public void setNombreCondicionPrioridad(String nombreCondicionPrioridad) {
        this.nombreCondicionPrioridad = nombreCondicionPrioridad;
    }

    public Indicador getIndicadorSeleccionadoPrioridad() {
        return indicadorSeleccionadoPrioridad;
    }

    public void setIndicadorSeleccionadoPrioridad(Indicador indicadorSeleccionadoPrioridad) {
        this.indicadorSeleccionadoPrioridad = indicadorSeleccionadoPrioridad;
    }

    public Indicador getIndicadorSeleccionadoTaxativa() {
        return indicadorSeleccionadoTaxativa;
    }

    public void setIndicadorSeleccionadoTaxativa(Indicador indicadorSeleccionadoTaxativa) {
        this.indicadorSeleccionadoTaxativa = indicadorSeleccionadoTaxativa;
    }

    public String getCantidadDePeriodosPrioridad() {
        return cantidadDePeriodosPrioridad;
    }

    public void setCantidadDePeriodosPrioridad(String cantidadDePeriodosPrioridad) {
        this.cantidadDePeriodosPrioridad = cantidadDePeriodosPrioridad;
    }

    public String getNombreCondicionTaxativa() {
        return nombreCondicionTaxativa;
    }

    public void setNombreCondicionTaxativa(String nombreCondicionTaxativa) {
        this.nombreCondicionTaxativa = nombreCondicionTaxativa;
    }



    public String getTipoCalculoSeleccionadoTaxativa() {
        return tipoCalculoSeleccionadoTaxativa;
    }

    public void setTipoCalculoSeleccionadoTaxativa(String tipoCalculoSeleccionadoTaxativa) {
        this.tipoCalculoSeleccionadoTaxativa = tipoCalculoSeleccionadoTaxativa;
    }

    public String getCantidadDePeriodosTaxativa() {
        return cantidadDePeriodosTaxativa;
    }

    public void setCantidadDePeriodosTaxativa(String cantidadDePeriodosTaxativa) {
        this.cantidadDePeriodosTaxativa = cantidadDePeriodosTaxativa;
    }

    public String getValoreDeReferenciaTaxativa() {
        return valoreDeReferenciaTaxativa;
    }

    public void setValoreDeReferenciaTaxativa(String valoreDeReferenciaTaxativa) {
        this.valoreDeReferenciaTaxativa = valoreDeReferenciaTaxativa;
    }

    public Collection<String> getTiposCondiciones() {
        return tiposCondiciones;
    }

    public void setTiposCondiciones(Collection<String> tiposCondiciones) {
        this.tiposCondiciones = tiposCondiciones;
    }

    public String getCondicionSeleccionadaTaxativa() {
        return condicionSeleccionadaTaxativa;
    }

    public void setCondicionSeleccionadaTaxativa(String condicionSeleccionadaTaxativa) {
        this.condicionSeleccionadaTaxativa = condicionSeleccionadaTaxativa;
    }


    public String getCondicionSeleccionadaPrioridad() {
        return condicionSeleccionadaPrioridad;
    }

    public void setCondicionSeleccionadaPrioridad(String condicionSeleccionadaPrioridad) {
        this.condicionSeleccionadaPrioridad = condicionSeleccionadaPrioridad;
    }




    public String getNombreMetodologia() {
        return nombreMetodologia;
    }

    public void setNombreMetodologia(String nombreMetodologia) {
        this.nombreMetodologia = nombreMetodologia;
    }

    public Collection<String> getTiposCondicionesFiltro(){
        Collection<String> tiposCondisionesTaxativas = new ArrayList<>();
            tiposCondisionesTaxativas.add("Mayor");
            tiposCondisionesTaxativas.add("Menor");
        return tiposCondisionesTaxativas;
    }

    public Collection<String> getTiposCondicionesOrden(){
        Collection<String> tiposCondisionesTaxativas = new ArrayList<>();
        tiposCondisionesTaxativas.add("Creciente");
        tiposCondisionesTaxativas.add("Decreciente");
        tiposCondisionesTaxativas.add("Maximizar");
        return tiposCondisionesTaxativas;
    }

    public Collection<String> getTiposCalculo(){
        Collection<String> tiposCalculo = new ArrayList<>();
        tiposCalculo.add("Promedio");
        tiposCalculo.add("Sumatoria");
        tiposCalculo.add("Media");

        return tiposCalculo;
    }

    public Collection<Indicador> getIndicadores(){
        return RepositorioDeIndicadores.getInstance().getIndicadores();
    }


}
