package window;

import model.condiciones.prioritarias.CondicionPrioritaria;
import model.condiciones.taxativas.CondicionTaxativa;
import model.Indicador;
import org.uqbar.arena.bindings.PropertyAdapter;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.commons.model.UserException;
import org.uqbar.arena.windows.MessageBox;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.*;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;
import viewmodel.CreadorMetodologiasViewModel;

import java.awt.*;

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
    Table<CondicionPrioritaria> tablePrioridad;
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

        new Label(mainPanel).setText("Metodologia").setBackground(Color.ORANGE);
        Panel panelMetodologia = new Panel(mainPanel).setLayout(new HorizontalLayout());
            new Label(panelMetodologia).setText("Nombre :");
            TextBox NombreMetodologia= new TextBox(panelMetodologia);
            NombreMetodologia.bindValueToProperty("nombreMetodologia");

        new Label(mainPanel).setText("Condiciones de Orden ").setBackground(Color.ORANGE);
        Panel panelCondicionesDeOrden = new Panel(mainPanel).setLayout(new HorizontalLayout());
            Panel panelCamposCondicionDeOrden = new Panel(panelCondicionesDeOrden).setLayout(new VerticalLayout());
            panelCamposCondicionDeOrden.setLayout(new ColumnLayout(2));
                new Label(panelCamposCondicionDeOrden).setText("Nombre : ");
                TextBox nombreCondicionPrioridad = new TextBox(panelCamposCondicionDeOrden);
                nombreCondicionPrioridad.setWidth(100);
                nombreCondicionPrioridad.bindValueToProperty("nombreCondicionPrioridad");

                new Label(panelCamposCondicionDeOrden).setText("Tipo de condicion: ");
                Selector<String> tiposDeCondicionPrioridad=  new Selector<>(panelCamposCondicionDeOrden);
                tiposDeCondicionPrioridad.allowNull(false);
                tiposDeCondicionPrioridad.setWidth(100);
                tiposDeCondicionPrioridad.bindValueToProperty("condicionSeleccionadaPrioridad");
                tiposDeCondicionPrioridad.bindItemsToProperty("tiposCondicionesOrden");

                new Label(panelCamposCondicionDeOrden).setText("Seleccione un indicador: ");
                Selector<Indicador> selectorIndicadorPrioridad = new Selector<Indicador>(panelCamposCondicionDeOrden);
                selectorIndicadorPrioridad.allowNull(false);
                selectorIndicadorPrioridad.setWidth(100);
                selectorIndicadorPrioridad.bindValueToProperty("indicadorSeleccionadoPrioridad");
                selectorIndicadorPrioridad.bindItemsToProperty("indicadores").setAdapter(new PropertyAdapter(Indicador.class, "nombre"));

                new Label(panelCamposCondicionDeOrden).setText("Cantidad de periodos: ");
                TextBox CantidadDePeridosPrioridad = new TextBox(panelCamposCondicionDeOrden);
                CantidadDePeridosPrioridad.setWidth(100);
                CantidadDePeridosPrioridad.bindValueToProperty("cantidadDePeriodosPrioridad");
                CantidadDePeridosPrioridad.withFilter(TextFilter.NUMERIC_TEXT_FILTER);

                new Label(panelCamposCondicionDeOrden).setText("  "); // Este label vacio es para que el boton se acomode en la segunda columna de la tabla
                AgregarCondicionPrioridad = new Button(panelCamposCondicionDeOrden).setCaption("Agregar Condicion");


            Panel panelTablaCondicionDeOrden = new Panel(panelCondicionesDeOrden).setLayout(new VerticalLayout());
                tablePrioridad = new Table<CondicionPrioritaria>(panelTablaCondicionDeOrden, CondicionPrioritaria.class);
                tablePrioridad.bindItemsToProperty("metodologia.condicionesPrioridad");
                new Column<CondicionPrioritaria>(tablePrioridad).setTitle("Nombre").setFixedSize(150).bindContentsToProperty("name");
                new Column<CondicionPrioritaria>(tablePrioridad).setTitle("Cantidad de periodos").setFixedSize(150).bindContentsToProperty("cantidadDePeriodos");
                new Column<CondicionPrioritaria>(tablePrioridad).setTitle("indicador").setFixedSize(150).bindContentsToProperty("indicador.nombre");




        new Label(mainPanel).setText("Condiciones de Filtro ").setBackground(Color.ORANGE);
        Panel panelCondicionesDeFiltro = new Panel(mainPanel).setLayout(new HorizontalLayout());
            Panel panelCamposCondicionDeFiltro = new Panel(panelCondicionesDeFiltro).setLayout(new VerticalLayout());
            panelCamposCondicionDeFiltro.setLayout(new ColumnLayout(2));
                new Label(panelCamposCondicionDeFiltro).setText("Nombre : ");
                TextBox nombreCondicionTaxativa = new TextBox(panelCamposCondicionDeFiltro);
                nombreCondicionTaxativa.setWidth(100);
                nombreCondicionTaxativa.bindValueToProperty("nombreCondicionTaxativa");

                new Label(panelCamposCondicionDeFiltro).setText("Tipo de condicion: ");
                Selector<String> tiposDeCondicionTaxativas=  new Selector<>(panelCamposCondicionDeFiltro);
                tiposDeCondicionTaxativas.allowNull(false);
                tiposDeCondicionTaxativas.setWidth(100);
                tiposDeCondicionTaxativas.bindValueToProperty("condicionSeleccionadaTaxativa");
                tiposDeCondicionTaxativas.bindItemsToProperty("tiposCondicionesFiltro");

                new Label(panelCamposCondicionDeFiltro).setText("Seleccione un indicador: ");
                Selector<Indicador> selectorIndicadorTaxativa = new Selector<Indicador>(panelCamposCondicionDeFiltro);
                selectorIndicadorTaxativa.allowNull(false);
                selectorIndicadorTaxativa.setWidth(100);
                selectorIndicadorTaxativa.bindValueToProperty("indicadorSeleccionadoTaxativa");
                selectorIndicadorTaxativa.bindItemsToProperty("indicadores").setAdapter(new PropertyAdapter(Indicador.class, "nombre"));

                new Label(panelCamposCondicionDeFiltro).setText("Cantidad de periodos: ");
                TextBox CantidadDePeridosTaxativa = new TextBox(panelCamposCondicionDeFiltro);
                CantidadDePeridosTaxativa.setWidth(100);
                CantidadDePeridosTaxativa.bindValueToProperty("cantidadDePeriodosTaxativa");
                CantidadDePeridosTaxativa.withFilter(TextFilter.NUMERIC_TEXT_FILTER);

                new Label(panelCamposCondicionDeFiltro).setText("Seleccione un calculo: ");
                Selector<String> selectorCalculoTaxativa = new Selector<String>(panelCamposCondicionDeFiltro);
                selectorCalculoTaxativa.allowNull(false);
                selectorCalculoTaxativa.setWidth(100);
                selectorCalculoTaxativa.bindValueToProperty("tipoCalculoSeleccionadoTaxativa");
                selectorCalculoTaxativa.bindItemsToProperty("tiposCalculo");

                new Label(panelCamposCondicionDeFiltro).setText("Valor de referencia: ");
                TextBox VaLorDeReferenciaTaxativa = new TextBox(panelCamposCondicionDeFiltro);
                VaLorDeReferenciaTaxativa.setWidth(100);
                VaLorDeReferenciaTaxativa.bindValueToProperty("valoreDeReferenciaTaxativa");
                VaLorDeReferenciaTaxativa.withFilter(TextFilter.NUMERIC_TEXT_FILTER);

                new Label(panelCamposCondicionDeFiltro).setText("  "); // Este label vacio es para que el boton se acomode en la segunda columna de la tabla
                AgregarCondicionTaxativa = new Button(panelCamposCondicionDeFiltro).setCaption("Agregar Condicion");

        Panel panelTablasCondicionDeFiltro = new Panel(panelCondicionesDeFiltro).setLayout(new VerticalLayout());
            Table<CondicionTaxativa> tableTaxativa = new Table<CondicionTaxativa>(panelTablasCondicionDeFiltro, CondicionTaxativa.class);
            tableTaxativa.bindItemsToProperty("metodologia.condicionesTaxativas");
            new Column<CondicionTaxativa>(tableTaxativa).setTitle("Nombre").setFixedSize(150).bindContentsToProperty("name");
            new Column<CondicionTaxativa>(tableTaxativa).setTitle("Cant de periodos").setFixedSize(150).bindContentsToProperty("cantidadDePeriodos");
            new Column<CondicionTaxativa>(tableTaxativa).setTitle("Indicador").setFixedSize(150).bindContentsToProperty("calculo.indicador.nombre");
            new Column<CondicionTaxativa>(tableTaxativa).setTitle("Calculo").setFixedSize(150).bindContentsToProperty("calculo.getClassClean();");
            new Column<CondicionTaxativa>(tableTaxativa).setTitle("Valor de referencia").setFixedSize(150).bindContentsToProperty("valorDeReferencia");



        Panel panelDeBotonesInferior = new Panel(mainPanel).setLayout(new HorizontalLayout());
            GuardarMetodologia = new Button(panelDeBotonesInferior).setCaption("Guardar Metodologia");



       // Panel panelCondiciones = new Panel(panelCreacion).setLayout(new HorizontalLayout());
       // panelCondiciones.setLayout(new ColumnLayout(2));

    }


    @Override
    protected void addActions(Panel actionsPanel) {
        menu.onClick(this::abrirMenu);
        AgregarCondicionTaxativa.onClick(this::AgregarCondicionFiltro);
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
      /*  try {
            getCreadorVM().NuevaMetodologia();

        }catch (UserException e) {
            showErrorMessageBox("No se puedo crear la metodologia");
        }*/
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
