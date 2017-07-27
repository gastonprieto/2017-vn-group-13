package window;

import model.Indicador;
import model.Metodologia;
import org.uqbar.arena.bindings.PropertyAdapter;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;
import viewmodel.AplicarMetodologiaViewModel;


/**
 * Created by rapap on 27/07/2017.
 */
public class AplicarMetodologiaView extends SimpleWindow<AplicarMetodologiaViewModel> {

    private static final long serialVersionUID = 1L;
    private  static AplicarMetodologiaViewModel  creadorVM = new AplicarMetodologiaViewModel();

    WindowOwner parent;

    public AplicarMetodologiaView(WindowOwner parent) {
        super(parent, creadorVM);
        this.parent = parent;
    }

    @Override
    protected void createFormPanel(Panel mainPanel) {
        this.setTitle("Menu");
        mainPanel.setLayout(new HorizontalLayout());

        Panel panel = new Panel(mainPanel);
        Panel panel2 = new Panel(mainPanel);

        panel.setLayout(new VerticalLayout());
        new Label(panel).setText("Seleccione una Metodologia: ");
        Selector<Metodologia> selectorMetodologia= new Selector<Metodologia>(panel);
        selectorMetodologia.allowNull(false);
        selectorMetodologia.bindValueToProperty("metodologiaSeleccionada");
        selectorMetodologia.bindItemsToProperty("metodologias").setAdapter(new PropertyAdapter(Metodologia.class, "nombre"));


    }

    @Override
    protected void addActions(Panel actionsPanel) {
        actionsPanel.setLayout(new VerticalLayout());
    }

    public AplicarMetodologiaViewModel getCreadorVM() {
        return creadorVM;
    }
}
