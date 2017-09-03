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
        mainPanel.setLayout(new VerticalLayout());

        Panel panel = new Panel(mainPanel);
        Panel panel2 = new Panel(mainPanel);

        panel.setLayout(new HorizontalLayout());

        menu = new Button(panel).setCaption("Volver al menu");

        new Label(panel).setText("Seleccione una Metodologia: ");
        Selector<Metodologia> selectorMetodologia= new Selector<Metodologia>(panel);
        selectorMetodologia.allowNull(false);
        selectorMetodologia.bindValueToProperty("metodologiaSeleccionada");
        selectorMetodologia.bindItemsToProperty("metodologias").setAdapter(new PropertyAdapter(Metodologia.class, "nombre"));

        aplicarMetodologia = new Button(panel).setCaption("Aplicar");

        new Label(panel2).setText("Resultado de aplicar metodologia ");

        Table<Empresa> table = new Table<Empresa>(panel2, Empresa.class);
        table.bindItemsToProperty("resultadoEmpresasEvaluadas");

        new Column<Empresa>(table).setTitle("Nombre").setFixedSize(150).bindContentsToProperty("name");



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
