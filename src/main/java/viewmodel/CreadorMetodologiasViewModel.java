package viewmodel;

import Repositorio.RepositorioDeIndicadores;
import Repositorio.RepositorioDeMetodologias;
import model.Condicion.Condicion;
import model.Condicion.Prioridad.CondicionPrioridad;
import model.Condicion.Taxativa.CondicionTaxativa;
import model.Indicador;
import model.Metodologia;
import org.uqbar.commons.utils.Observable;
import utils.File.ExportadorDeDatos;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by rapap on 09/09/2017.
 */

@Observable
public class CreadorMetodologiasViewModel {
    private Metodologia metodologia = null;
    private String nombreMetodologia;
    private String listaSuperTiposCondiciones;
    private String cantidadDePeriodos;
    private boolean estadoPanteallaFiltro = false;
    private String valorDeReferencia;
    private boolean estadoPanteallaOrden = true;
    private String nombreCondicion;
    private Collection<Condicion> condicionesCreadas = new ArrayList<Condicion>();
    private String tipoCalculoeleccionada ;
    private Indicador indicadorSeleccionado ;
    private String condicionSeleccionadaPrioridad;
    private String condicionSeleccionadaTaxativa;
    private ExportadorDeDatos manejadorDeArchivos = new ExportadorDeDatos();

    private Collection<String> tiposCondiciones;

    /* FUNCIONES */

    public void cambiarEstadoPantalla(){
        estadoPanteallaOrden = invertirEstadoPantallaOrden();
        estadoPanteallaFiltro = invertirEstadoPanteallaFiltro();
    }

    private boolean invertirEstadoPantallaOrden(){return estadoPanteallaOrden ? false : true;}
    private boolean invertirEstadoPanteallaFiltro(){return estadoPanteallaFiltro ? false : true;}

    public void cambiar(){
        tiposCondiciones= new ArrayList<>();
        if(estadoPanteallaFiltro == true) {
            tiposCondiciones.add("Mayor");
            tiposCondiciones.add("Menor");
        }else if(estadoPanteallaOrden == true){
            tiposCondiciones.add("Creciente");
            tiposCondiciones.add("Decreciente");
            tiposCondiciones.add("Maximizar");
        }
    }


    public void AgregarCondicionOrden(){
        metodologia.addCondicionPrioridad( condicionSeleccionadaPrioridad ,nombreCondicion, indicadorSeleccionado.getNombre(), cantidadDePeriodos);
    }

    public void AgregarCondicionFiltro(){
        metodologia.addCondicionTaxativa(condicionSeleccionadaTaxativa ,nombreCondicion, indicadorSeleccionado.getNombre(), tipoCalculoeleccionada, cantidadDePeriodos, valorDeReferencia);
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

    public Collection<CondicionPrioridad> getCondicionesPrioridadMetodologia(){
        return metodologia.getCondicionesPrioridad();
    }

    public Metodologia getMetodologia() {
        return metodologia;
    }

    public void setMetodologia(Metodologia metodologia) {
        this.metodologia = metodologia;
    }

    public String getListaSuperTiposCondiciones() {
        return listaSuperTiposCondiciones;
    }

    public void setListaSuperTiposCondiciones(String listaSuperTiposCondiciones) {
        this.listaSuperTiposCondiciones = listaSuperTiposCondiciones;
    }

    public boolean isEstadoPanteallaFiltro() {
        return estadoPanteallaFiltro;
    }

    public void setEstadoPanteallaFiltro(boolean estadoPanteallaFiltro) {
        this.estadoPanteallaFiltro = estadoPanteallaFiltro;
    }

    public boolean isEstadoPanteallaOrden() {
        return estadoPanteallaOrden;
    }

    public void setEstadoPanteallaOrden(boolean estadoPanteallaOrden) {
        this.estadoPanteallaOrden = estadoPanteallaOrden;
    }

    public String getCondicionSeleccionadaTaxativa() {
        return condicionSeleccionadaTaxativa;
    }

    public void setCondicionSeleccionadaTaxativa(String condicionSeleccionadaTaxativa) {
        this.condicionSeleccionadaTaxativa = condicionSeleccionadaTaxativa;
    }

    public String getNombreCondicion() {
        return nombreCondicion;
    }

    public void setNombreCondicion(String nombreCondicion) {
        this.nombreCondicion = nombreCondicion;
    }

    public String getCantidadDePeriodos() {
        return cantidadDePeriodos;
    }

    public void setCantidadDePeriodos(String cantidadDePeriodos) {
        this.cantidadDePeriodos = cantidadDePeriodos;
    }

    public Collection<String> getTiposCondiciones() {
        return tiposCondiciones;
    }

    public void setTiposCondiciones(Collection<String> tiposCondiciones) {
        this.tiposCondiciones = tiposCondiciones;
    }

    public String getValorDeReferencia() {
        return valorDeReferencia;
    }

    public void setValorDeReferencia(String valorDeReferencia) {
        this.valorDeReferencia = valorDeReferencia;
    }

    public String getTipoCalculoeleccionada() {
        return tipoCalculoeleccionada;
    }

    public void setTipoCalculoeleccionada(String tipoCalculoeleccionada) {
        this.tipoCalculoeleccionada = tipoCalculoeleccionada;
    }

    public Indicador getIndicadorSeleccionado() {
        return indicadorSeleccionado;
    }

    public void setIndicadorSeleccionado(Indicador indicadorSeleccionado) {
        this.indicadorSeleccionado = indicadorSeleccionado;
    }


    public String getCondicionSeleccionadaPrioridad() {
        return condicionSeleccionadaPrioridad;
    }

    public void setCondicionSeleccionadaPrioridad(String condicionSeleccionadaPrioridad) {
        this.condicionSeleccionadaPrioridad = condicionSeleccionadaPrioridad;
    }

    public Collection<Condicion> getCondicionesCreadas() {
        return condicionesCreadas;
    }

    public void setCondicionesCreadas(Collection<Condicion> condicionesCreadas) {
        this.condicionesCreadas = condicionesCreadas;
    }

    public String getNombreMetodologia() {
        return nombreMetodologia;
    }

    public void setNombreMetodologia(String nombreMetodologia) {
        this.nombreMetodologia = nombreMetodologia;
    }

    public Collection<String> getSuperTiposCondiciones(){
        Collection<String> superTiposCondisiones = new ArrayList<>();
        superTiposCondisiones.add("Filtro");
        superTiposCondisiones.add("Orden");
        return superTiposCondisiones;
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
        Collection<String> tiposIndicadores = new ArrayList<>();
        tiposIndicadores.add("Promedio");
        tiposIndicadores.add("Sumatoria");
        tiposIndicadores.add("Media");

        return tiposIndicadores;
    }

    public Collection<Indicador> getIndicadores(){
        return RepositorioDeIndicadores.getInstance().getIndicadores();
    }


}
