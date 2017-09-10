package window;

import model.Empresa;
import model.Metodologia;
import org.uqbar.arena.bindings.PropertyAdapter;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.MessageBox;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;
import viewmodel.AplicarMetodologiaViewModel;
import org.uqbar.arena.widgets.tables.Column;

/**
 * Created by rapap on 27/07/2017.
 */
public class AplicarMetodologiaView extends SimpleWindow<AplicarMetodologiaViewModel> {

    private static final long serialVersionUID = 1L;
    private  static AplicarMetodologiaViewModel  creadorVM = new AplicarMetodologiaViewModel();
    private Button menu;
    private Button aplicarMetodologia;
    WindowOwner parent;

    public AplicarMetodologiaView(WindowOwner parent) {
        super(parent, creadorVM);
        this.parent = parent;
    }

    @Override
    protected void createFormPanel(Panel mainPanel) {
        this.setTitle("Aplicar Metodologia");
        mainPanel.setLayout(new HorizontalLayout());

        menu = new Button(mainPanel).setCaption("Volver a menu");



        Panel panelMetodologia = new Panel(mainPanel);
        panelMetodologia.setLayout(new VerticalLayout());
            new Label(panelMetodologia).setText("Metodologia");
            Selector<Metodologia> selectorMetodologia = new Selector<>(panelMetodologia);
            selectorMetodologia.bindItemsToProperty("metodologiaSeleccionada");
            selectorMetodologia.bindItemsToProperty("metodologias").setAdapter(new PropertyAdapter(Metodologia.class, "nombre"));


        aplicarMetodologia = new Button(panelMetodologia).setCaption("Evaluar");

        Panel panelResultados = new Panel(mainPanel);
        panelResultados.setLayout(new VerticalLayout());
            Table<Empresa> tablaResultado = new Table<>(panelResultados, Empresa.class);
            tablaResultado.bindItemsToProperty("resultadoEmpresasEvaluadas");
            new Column<Empresa>(tablaResultado).setTitle("Nombre").setWeight(150).bindContentsToProperty("name");



    }

    @Override
    protected void addActions(Panel actionsPanel) {
        menu.onClick(this::abrirMenu);
        aplicarMetodologia.onClick(this::AplicarMetodologiaSeleccionada);
        actionsPanel.setLayout(new VerticalLayout());
    }

    public void abrirMenu() {
        MenuView menuView = new MenuView(this.parent, false);
        this.close();
        menuView.open();
    }

    public void AplicarMetodologiaSeleccionada(){
     try{
        getCreadorVM().aplicarMetodologiaSeleccionada();
    }catch (NullPointerException e){
        showErrorMessageBox("Se aplico el indicadr en un periodo en el cual la cuenta no tiene ningun valor");
    }
    }

    protected void showErrorMessageBox(String message) {
        MessageBox messageBox = new MessageBox(this, MessageBox.Type.Error);
        messageBox.setMessage(message);
        messageBox.open();
    }

    public AplicarMetodologiaViewModel getCreadorVM() {
        return creadorVM;
    }
}
