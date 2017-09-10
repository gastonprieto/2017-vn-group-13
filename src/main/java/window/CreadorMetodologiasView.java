package window;

import model.Condicion.Condicion;
import model.Condicion.Prioridad.CondicionPrioridad;
import model.Condicion.Taxativa.CondicionTaxativa;
import model.Indicador;
import model.Metodologia;
import org.uqbar.arena.bindings.ObservableProperty;
import org.uqbar.arena.bindings.PropertyAdapter;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.widgets.tree.ObservableTwoProperty;
import org.uqbar.commons.model.UserException;
import org.uqbar.commons.utils.Observable.*;
import org.uqbar.arena.windows.MessageBox;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.*;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;
import viewmodel.CreadorMetodologiasViewModel;

import javax.swing.*;

/**
 * Created by rapap on 09/09/2017.
 */
public class CreadorMetodologiasView extends SimpleWindow<CreadorMetodologiasViewModel> {

    private static final long serialVersionUID = 1L;


    private Button menu;
    private Button NuevaMetodologia;
    private Button GuardarMetodologia;
    private Button AgregarCondicionTaxativa;
    private Button AgregarCondicionPrioridad;
    Selector<String> superTiposDeCondicion;
    Selector<String> tiposDeCondicion;
    WindowOwner parent;
    private  static CreadorMetodologiasViewModel  creadorVM = new CreadorMetodologiasViewModel();


    public CreadorMetodologiasView(WindowOwner parent) {
        super(parent, creadorVM);
        this.parent = parent;
    }


    @Override
    protected void createFormPanel(Panel mainPanel) {

        mainPanel.setLayout(new VerticalLayout());

        Panel panelDeBotonesSuperior = new Panel(mainPanel).setLayout(new HorizontalLayout());
                menu = new Button(panelDeBotonesSuperior).setCaption("Volver al menu");
                NuevaMetodologia = new Button(panelDeBotonesSuperior).setCaption("Nueva Metodologia");

        new Label(mainPanel).setText("Metodologia ");
        Panel panelMetodologia = new Panel(mainPanel).setLayout(new HorizontalLayout());
            new Label(panelMetodologia).setText("Nombre :");
            TextBox NombreMetodologia= new TextBox(panelMetodologia);
            NombreMetodologia.bindValueToProperty("nombreMetodologia");

        Panel panelSuperCondiciones = new Panel(mainPanel) .setLayout(new HorizontalLayout());
            Panel panelCondicionesDeOrden = new Panel(panelSuperCondiciones).setLayout(new HorizontalLayout());
                new Label(panelCondicionesDeOrden).setText("Condiciones de Orden ");
                Panel panelCamposCondicionDeOrden = new Panel(panelCondicionesDeOrden).setLayout(new VerticalLayout());
                panelCamposCondicionDeOrden.setLayout(new ColumnLayout(2));
                    new Label(panelCamposCondicionDeOrden).setText("Nombre : ");
                    TextBox nombreCondicionPrioridad = new TextBox(panelCamposCondicionDeOrden);
                    nombreCondicionPrioridad.bindValueToProperty("nombreCondicionPrioridad");

                    new Label(panelCamposCondicionDeOrden).setText("Tipo de condicion: ");
                    Selector<String> tiposDeCondicionPrioridad=  new Selector<>(panelCamposCondicionDeOrden);
                    tiposDeCondicionPrioridad.allowNull(false);
                    tiposDeCondicionPrioridad.bindValueToProperty("condicionSeleccionadaPrioridad");
                    tiposDeCondicionPrioridad.bindItemsToProperty("tiposCondicionesOrden");

                    new Label(panelCamposCondicionDeOrden).setText("Seleccione un indicador: ");
                    Selector<Indicador> selectorIndicadorPrioridad = new Selector<Indicador>(panelCamposCondicionDeOrden);
                    selectorIndicadorPrioridad.allowNull(false);
                    selectorIndicadorPrioridad.bindValueToProperty("indicadorSeleccionadoPrioridad");
                    selectorIndicadorPrioridad.bindItemsToProperty("indicadores").setAdapter(new PropertyAdapter(Indicador.class, "nombre"));

                    new Label(panelCamposCondicionDeOrden).setText("Cantidad de periodos: ");
                    TextBox CantidadDePeridosPrioridad = new TextBox(panelCamposCondicionDeOrden);
                    CantidadDePeridosPrioridad.bindValueToProperty("cantidadDePeriodosPrioridad");
                    CantidadDePeridosPrioridad.withFilter(TextFilter.NUMERIC_TEXT_FILTER);

                    AgregarCondicionPrioridad = new Button(panelCamposCondicionDeOrden).setCaption("Agregar Condicion");


                Panel panelTablaCondicionDeOrden = new Panel(panelCondicionesDeOrden).setLayout(new VerticalLayout());
                    new Label(panelTablaCondicionDeOrden).setText("Condiciones de orden: ");
                    Table<CondicionPrioridad> tablePrioridad = new Table<CondicionPrioridad>(panelTablaCondicionDeOrden, CondicionPrioridad.class);
                    tablePrioridad.bindItemsToProperty("metodologia.condicionesPrioridad");
                    new Column<CondicionPrioridad>(tablePrioridad).setTitle("Nombre").setFixedSize(150).bindContentsToProperty("name");


            Panel panelCondicionesDeFiltro = new Panel(panelSuperCondiciones).setLayout(new HorizontalLayout());
                new Label(panelCondicionesDeFiltro).setText("Condiciones de Filtro ");
                Panel panelCamposCondicionDeFiltro = new Panel(panelCondicionesDeFiltro).setLayout(new VerticalLayout());
                panelCamposCondicionDeFiltro.setLayout(new ColumnLayout(2));
                    new Label(panelCamposCondicionDeFiltro).setText("Nombre : ");
                    TextBox nombreCondicionTaxativa = new TextBox(panelCamposCondicionDeFiltro);
                    nombreCondicionTaxativa.bindValueToProperty("nombreCondicionTaxativa");

                    new Label(panelCamposCondicionDeFiltro).setText("Tipo de condicion: ");
                    Selector<String> tiposDeCondicionTaxativas=  new Selector<>(panelCamposCondicionDeFiltro);
                    tiposDeCondicionTaxativas.allowNull(false);
                    tiposDeCondicionTaxativas.bindValueToProperty("condicionSeleccionadaTaxativa");
                    tiposDeCondicionTaxativas.bindItemsToProperty("tiposCondicionesFiltro");

                    new Label(panelCamposCondicionDeFiltro).setText("Seleccione un indicador: ");
                    Selector<Indicador> selectorIndicadorTaxativa = new Selector<Indicador>(panelCamposCondicionDeFiltro);
                    selectorIndicadorTaxativa.allowNull(false);
                    selectorIndicadorTaxativa.bindValueToProperty("indicadorSeleccionadoTaxativa");
                    selectorIndicadorTaxativa.bindItemsToProperty("indicadores").setAdapter(new PropertyAdapter(Indicador.class, "nombre"));

                    new Label(panelCamposCondicionDeFiltro).setText("Cantidad de periodos: ");
                    TextBox CantidadDePeridosTaxativa = new TextBox(panelCamposCondicionDeFiltro);
                    CantidadDePeridosTaxativa.bindValueToProperty("cantidadDePeriodosTaxativa");
                    CantidadDePeridosTaxativa.withFilter(TextFilter.NUMERIC_TEXT_FILTER);

                    new Label(panelCamposCondicionDeFiltro).setText("Seleccione un calculo: ");
                    Selector<String> selectorCalculoTaxativa = new Selector<String>(panelCamposCondicionDeFiltro);
                    selectorCalculoTaxativa.allowNull(false);
                    selectorCalculoTaxativa.bindValueToProperty("tipoCalculoSeleccionadoTaxativa");
                    selectorCalculoTaxativa.bindItemsToProperty("tiposCalculo");

                    new Label(panelCamposCondicionDeFiltro).setText("Valor de referencia: ");
                    TextBox VaLorDeReferenciaTaxativa = new TextBox(panelCamposCondicionDeFiltro);
                    VaLorDeReferenciaTaxativa.bindValueToProperty("valoreDeReferenciaTaxativa");
                    VaLorDeReferenciaTaxativa.withFilter(TextFilter.NUMERIC_TEXT_FILTER);

                    AgregarCondicionTaxativa = new Button(panelCamposCondicionDeFiltro).setCaption("Agregar Condicion");

                Panel panelTablasCondicionDeFiltro = new Panel(panelCondicionesDeFiltro).setLayout(new VerticalLayout());
                    new Label(panelTablasCondicionDeFiltro).setText("Condiciones de filtro: ");
                    Table<CondicionTaxativa> tableTaxativa = new Table<CondicionTaxativa>(panelTablasCondicionDeFiltro, CondicionTaxativa.class);
                    tableTaxativa.bindItemsToProperty("metodologia.condicionesTaxativas");
                    new Column<CondicionTaxativa>(tableTaxativa).setTitle("Nombre").setFixedSize(150).bindContentsToProperty("name");

        Panel panelDeBotonesInferior = new Panel(mainPanel).setLayout(new HorizontalLayout());
            GuardarMetodologia = new Button(panelDeBotonesInferior).setCaption("Guardar Metodologia");



       // Panel panelCondiciones = new Panel(panelCreacion).setLayout(new HorizontalLayout());
       // panelCondiciones.setLayout(new ColumnLayout(2));

    }


    @Override
    protected void addActions(Panel actionsPanel) {
        menu.onClick(this::abrirMenu);
//        AgregarCondicionTaxativa.onClick(this::AgregarCondicionFiltro);
        AgregarCondicionPrioridad.onClick(this::AgregarCondicionOrden);
        GuardarMetodologia.onClick(this::CrearMetodologia);
        NuevaMetodologia.onClick(this::NuevaMetodologia);
    }

    public void abrirMenu() {
        MenuView menuView = new MenuView(this.parent, false);
        this.close();
        menuView.open();
    }

    public void AgregarCondicionOrden(){
        try {
            getCreadorVM().AgregarCondicionOrden();
        }catch (Exception e){
            showErrorMessageBox("No se puedo crear la condicion porque " + e.getMessage());
        }
    }

    public void AgregarCondicionFiltro(){
        try {
            getCreadorVM().AgregarCondicionFiltro();
        }catch (Exception e){
            showErrorMessageBox("No se puedo crear la condicion porque " + e.getMessage());
        }
    }

    public void NuevaMetodologia(){
        try {
            getCreadorVM().NuevaMetodologia();

        }catch (UserException e) {
            showErrorMessageBox("No se puedo crear la metodologia");
        }
    }

    public void CrearMetodologia(){
        try {
            getCreadorVM().GuardarMetodologia();
            showErrorMessageBox("Se creo la Metodologia sadisfactoriaente");
        }catch (UserException e) {
            showErrorMessageBox("No se puedo crear la metodologia");
        }
    }



    public CreadorMetodologiasViewModel getCreadorVM() {
        return creadorVM;
    }

    protected void showErrorMessageBox(String message) {
        MessageBox messageBox = new MessageBox(this, MessageBox.Type.Error);
        messageBox.setMessage(message);
        messageBox.open();
    }

}
