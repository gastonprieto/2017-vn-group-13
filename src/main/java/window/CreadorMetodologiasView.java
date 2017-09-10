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

/**
 * Created by rapap on 09/09/2017.
 */
public class CreadorMetodologiasView extends SimpleWindow<CreadorMetodologiasViewModel> {

    private static final long serialVersionUID = 1L;


    private Button menu;
    private Button NuevaMetodologia;
    private Button GuardarMetodologia;
    private Button AgregarCondicionFiltro;
    private Button AgregarCondicionOrden;
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

        Panel panelDeBotones = new Panel(mainPanel).setLayout(new HorizontalLayout());
                menu = new Button(panelDeBotones).setCaption("Volver al menu");
                NuevaMetodologia = new Button(panelDeBotones).setCaption("Nueva Metodologia");

        Panel panelCreacion = new Panel(mainPanel).setLayout(new HorizontalLayout());

        /* --- PANEL DE CONDICIONES ---*/

        Panel panelCondiciones = new Panel(panelCreacion).setLayout(new HorizontalLayout());
        panelCondiciones.setLayout(new ColumnLayout(2));

            new Label(panelCondiciones).setText("Tipo de condicion: ");
            superTiposDeCondicion =  new Selector<String>(panelCondiciones);
            superTiposDeCondicion.bindItemsToProperty("superTiposCondiciones");

            new Label(panelCondiciones).setText("Tipo de condicion: ");

            Panel panelTipoDeCondiciones = new Panel(panelCondiciones).setLayout(new HorizontalLayout());
                Selector<String> tiposDeCondicionPrioridad=  new Selector<>(panelTipoDeCondiciones);
                tiposDeCondicionPrioridad.allowNull(false);
                tiposDeCondicionPrioridad.bindValueToProperty("condicionSeleccionadaPrioridad");
                tiposDeCondicionPrioridad.bindItemsToProperty("tiposCondicionesOrden");
                tiposDeCondicionPrioridad.bindVisible(new ObservableProperty("estadoPanteallaOrden"));

                Selector<String> tiposDeCondicionTaxativas =  new Selector<String>(panelTipoDeCondiciones);
                tiposDeCondicionTaxativas.allowNull(false);
                tiposDeCondicionTaxativas.bindValueToProperty("condicionSeleccionadaTaxativa");
                tiposDeCondicionTaxativas.bindItemsToProperty("tiposCondicionesFiltro");
                tiposDeCondicionTaxativas.bindVisible(new ObservableProperty("estadoPanteallaFiltro"));

            new Label(panelCondiciones).setText("Nombre : ");
            TextBox nombreCondicion= new TextBox(panelCondiciones);
            nombreCondicion.bindValueToProperty("nombreCondicion");

            new Label(panelCondiciones).setText("Seleccione un indicador: ");
            Selector<Indicador> selectorIndicador = new Selector<Indicador>(panelCondiciones);
            selectorIndicador.allowNull(false);
            selectorIndicador.bindValueToProperty("indicadorSeleccionado");
            selectorIndicador.bindItemsToProperty("indicadores").setAdapter(new PropertyAdapter(Indicador.class, "nombre"));

            new Label(panelCondiciones).setText("Cantidad de periodos: ");
            TextBox CantidadDePeridos= new TextBox(panelCondiciones);
            CantidadDePeridos.bindValueToProperty("cantidadDePeriodos");
            CantidadDePeridos.withFilter(TextFilter.NUMERIC_TEXT_FILTER);

            new Label(panelCondiciones).setText("Seleccione un calculo: ").bindVisible(new ObservableProperty("estadoPanteallaFiltro"));
            Selector<String> selectorCalculo = new Selector<String>(panelCondiciones);
            selectorCalculo.allowNull(false);
            selectorCalculo.bindValueToProperty("tipoCalculoeleccionada");
            selectorCalculo.bindItemsToProperty("tiposCalculo");
            selectorCalculo.bindVisible(new ObservableProperty("estadoPanteallaFiltro"));

            new Label(panelCondiciones).setText("Valor de referencia: ").bindVisible(new ObservableProperty("estadoPanteallaFiltro"));
            TextBox VaLorDeReferencia= new TextBox(panelCondiciones);
            VaLorDeReferencia.bindValueToProperty("valorDeReferencia");
            VaLorDeReferencia.withFilter(TextFilter.NUMERIC_TEXT_FILTER);
            VaLorDeReferencia.bindVisible(new ObservableProperty("estadoPanteallaFiltro"));

            new Label(panelCondiciones).setText(" "); // Esto es porque si no queda mal acomodada la tabla

            Panel panelBotones = new Panel(panelCondiciones).setLayout(new VerticalLayout());

            AgregarCondicionOrden = new Button(panelBotones).setCaption("Agregar Condicion");
            AgregarCondicionOrden.bindVisible(new ObservableProperty("estadoPanteallaOrden"));


            AgregarCondicionFiltro = new Button(panelBotones).setCaption("Agregar Condicion");
                AgregarCondicionFiltro.bindVisible(new ObservableProperty("estadoPanteallaFiltro"));



        /* --- PANEL DE CONDICIONES ---*/

        Panel panelMetodologia = new Panel(panelCreacion).setLayout(new VerticalLayout());

            new Label(panelMetodologia).setText("Nombre :");
            TextBox NombreMetodologia= new TextBox(panelMetodologia);
            NombreMetodologia.bindValueToProperty("nombreMetodologia");

            new Label(panelMetodologia).setText("Condiciones de filtro: ");
            Table<CondicionTaxativa> table = new Table<CondicionTaxativa>(panelMetodologia, CondicionTaxativa.class);
            table.bindItemsToProperty("metodologia.condicionesTaxativas");
            new Column<CondicionTaxativa>(table).setTitle("Nombre").setFixedSize(150).bindContentsToProperty("name");

            new Label(panelMetodologia).setText("Condiciones de orden: ");
            Table<CondicionPrioridad> table2 = new Table<CondicionPrioridad>(panelMetodologia, CondicionPrioridad.class);
            table2.bindItemsToProperty("metodologia.condicionesPrioridad");
            new Column<CondicionPrioridad>(table2).setTitle("Nombre").setFixedSize(150).bindContentsToProperty("name");


        GuardarMetodologia = new Button(panelMetodologia).setCaption("Guardar Metodologia");



    }


    @Override
    protected void addActions(Panel actionsPanel) {
        menu.onClick(this::abrirMenu);
        AgregarCondicionFiltro.onClick(this::AgregarCondicionFiltro);
        AgregarCondicionOrden.onClick(this::AgregarCondicionOrden);
        superTiposDeCondicion.onSelection(this::cambiarEstadoPantall);
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


    public void cambiarEstadoPantall(){
        getCreadorVM().cambiarEstadoPantalla();
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
