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
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;
import viewmodel.CreadorDeMetodologiasYCondicionesViewModel;
/**
 * Created by rapap on 27/07/2017.
 */
public class CreadorDeMetodologiasYCondicionesView  extends SimpleWindow<CreadorDeMetodologiasYCondicionesViewModel> {

    private static final long serialVersionUID = 1L;
    private Button menu;
    private Button AgregarCondicion;
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

        new Label(panel).setText("Nombre de la metodologia");
        TextBox NombreMetodologia= new TextBox(panel);
        NombreMetodologia.bindValueToProperty("nombreMetodologia");

        Table<Condicion> table = new Table<Condicion>(panel, Condicion.class);
        table.bindItemsToProperty("condicionesCreadas");

        new Column<Condicion>(table).setTitle("Nombre").setFixedSize(150).bindContentsToProperty("name");

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

        AgregarCondicion = new Button(panel2).setCaption("Agregar Condicion");



    }

    @Override
    protected void addActions(Panel actionsPanel) {
        menu.onClick(this::abrirMenu);
        AgregarCondicion.onClick(this::AgregarCondicion);
    }

    public void abrirMenu() {
        MenuView menuView = new MenuView(this.parent, false);
        this.close();
        menuView.open();
    }

    public void AgregarCondicion(){
        getCreadorVM().AgregarCondicion();
    }

    public CreadorDeMetodologiasYCondicionesViewModel getCreadorVM() {
        return creadorVM;
    }

}
