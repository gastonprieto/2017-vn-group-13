package window;

import model.Empresa;
import org.uqbar.arena.bindings.PropertyAdapter;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;
import viewmodel.VentanaMetodologiaViewModel;

/**
 * Created by rapap on 02/07/2017.
 */
public class VentanaMetodologia extends SimpleWindow<VentanaMetodologiaViewModel> {
    private static final long serialVersionUID = 1L;

    WindowOwner parent;

    public VentanaMetodologia(WindowOwner parent) {
        super(parent, new VentanaMetodologiaViewModel());
        this.parent = parent;
    }

    @Override
    protected void createFormPanel(Panel mainPanel) {
        this.setTitle("Menu");
        mainPanel.setLayout(new HorizontalLayout());

        Panel panelIndicadores = new Panel(mainPanel);
        panelIndicadores.setLayout(new VerticalLayout());
        new Label(panelIndicadores).setText("Seleccione una empresa: ");

        Selector<Empresa> selectorEmpresas = new Selector<Empresa>(panelIndicadores);
        selectorEmpresas.allowNull(false);
        selectorEmpresas.bindValueToProperty("empresaSeleccionada");
        selectorEmpresas.bindItemsToProperty("empresas").setAdapter(new PropertyAdapter(Empresa.class, "name"));


    }

    @Override
    protected void addActions(Panel actionsPanel) {
        actionsPanel.setLayout(new HorizontalLayout());




    }

    public void abrirCuentas() {
        VerCuentasView cuentasView = new VerCuentasView(this.parent);
        this.close();
        cuentasView.open();
    }

    public void abrirIndicadores() {
//		IndicadoresView indicadoresView = new IndicadoresView(this.parent);
//		this.close();
//		indicadoresView.open();
    }

    public void abrirCreadorDeIndicadores() {
        CreadorDeIndicadoresView creadorView = new CreadorDeIndicadoresView(this.parent);
        this.close();
        creadorView.open();
    }
}
