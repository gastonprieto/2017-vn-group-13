package window;

import model.Condicion;
import model.Cuenta;
import model.Empresa;
import model.Indicador;
import org.uqbar.arena.bindings.PropertyAdapter;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.*;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.MessageBox;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.commons.model.UserException;
import viewmodel.CreadorDeMetodologiasYCondicionesViewModel;
/**
 * Created by rapap on 27/07/2017.
 */
public class CreadorDeMetodologiasYCondicionesView  extends SimpleWindow<CreadorDeMetodologiasYCondicionesViewModel> {

    private static final long serialVersionUID = 1L;
    private Button menu;
    private Button AgregarCondicion;
    private Button GuardarMetodologia;
    WindowOwner parent;
    private  static CreadorDeMetodologiasYCondicionesViewModel  creadorVM = new CreadorDeMetodologiasYCondicionesViewModel();


    public CreadorDeMetodologiasYCondicionesView(WindowOwner parent) {
        super(parent, creadorVM);
        this.parent = parent;
    }

    @Override
    protected void createFormPanel(Panel mainPanel) {
        this.setTitle("Creador de Metodologias y condiciones");

        mainPanel.setLayout(new HorizontalLayout());

        Panel panel = new Panel(mainPanel).setLayout(new VerticalLayout());
        Panel panel2 = new Panel(mainPanel).setLayout(new VerticalLayout());

        menu = new Button(panel).setCaption("Volver al menu");

        /* ---  TODO LO CORRESPONDIENTE A LA CREACION DE LA METODOLOGIA ---*/

        new Label(panel).setText("Nombre de la metodologia");
        TextBox NombreMetodologia= new TextBox(panel);
        NombreMetodologia.bindValueToProperty("nombreMetodologia");

        Table<Condicion> table = new Table<Condicion>(panel, Condicion.class);
        table.bindItemsToProperty("condicionesCreadas");
        new Column<Condicion>(table).setTitle("Nombre").setFixedSize(150).bindContentsToProperty("name");

        GuardarMetodologia = new Button(panel).setCaption("Guardar Metodologia");

        /* --- TODO LO CORRESPONDIENTE A LA CREACION DE CONDICIONES  ---*/


        new Label(panel2).setText("Nombre de la metodologia");
        TextBox NombreCondicion= new TextBox(panel2);
        NombreCondicion.bindValueToProperty("nombreCondicion");

        new Label(panel2).setText("Seleccione indicador: ");
        Selector<Indicador> selectorIndicador = new Selector<Indicador>(panel2);
        selectorIndicador.allowNull(false);
        selectorIndicador.bindValueToProperty("indicadorSeleccionado");
        selectorIndicador.bindItemsToProperty("indicadores").setAdapter(new PropertyAdapter(Indicador.class, "nombre"));


        new Label(panel2).setText("Seleccione un tipo de indicador: ");
        Selector<String> selectorTiposIndicadores = new Selector<String>(panel2);
        selectorTiposIndicadores.allowNull(false);
        selectorTiposIndicadores.bindValueToProperty("tipoIndicadorSeleccionada");
        selectorTiposIndicadores.bindItemsToProperty("tiposIndicador");


        new Label(panel2).setText("Seleccione el tipo: ");
        Selector selectorTiposCondiciones = new Selector(panel2);
        selectorTiposCondiciones.allowNull(false);
        selectorTiposCondiciones.bindValueToProperty("tipoCondicionSeleccionada");
        selectorTiposCondiciones.bindItemsToProperty("tipos");

        new Label(panel2).setText("Cantidad de periodos: ");
        TextBox CantidadDePeridos= new TextBox(panel2);
        CantidadDePeridos.bindValueToProperty("cantidadDePeriodos");
        CantidadDePeridos.withFilter(TextFilter.NUMERIC_TEXT_FILTER);

        new Label(panel2).setText("Valor de referencia: ");
        TextBox VaLorDeReferencia= new TextBox(panel2);
        VaLorDeReferencia.bindValueToProperty("valorDeReferencia");
        VaLorDeReferencia.withFilter(TextFilter.NUMERIC_TEXT_FILTER);

        AgregarCondicion = new Button(panel2).setCaption("Agregar Condicion");

    }

    @Override
    protected void addActions(Panel actionsPanel) {
        menu.onClick(this::abrirMenu);
        AgregarCondicion.onClick(this::AgregarCondicion);
        GuardarMetodologia.onClick(this::CrearMetodologia);
    }

    public void abrirMenu() {
        MenuView menuView = new MenuView(this.parent, false);
        this.close();
        menuView.open();
    }

    public void AgregarCondicion(){
        try {
            getCreadorVM().AgregarCondicion();
        }catch (UserException e){
            showErrorMessageBox("No se puedo crear la condicion");
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
    protected void showErrorMessageBox(String message) {
        MessageBox messageBox = new MessageBox(this, MessageBox.Type.Error);
        messageBox.setMessage(message);
        messageBox.open();
    }

    public CreadorDeMetodologiasYCondicionesViewModel getCreadorVM() {
        return creadorVM;
    }

}
