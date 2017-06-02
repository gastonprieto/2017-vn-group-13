package window;

import org.uqbar.arena.bindings.PropertyAdapter;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

import model.Cuenta;
import model.Empresa;
import viewmodel.IndicadoresViewModel;


public class IndicadoresView extends SimpleWindow<IndicadoresViewModel>  {

	private static final long serialVersionUID = 1L;
	private static IndicadoresViewModel menuVM = new IndicadoresViewModel();
	private WindowOwner parent;
	private Button notasButton;
	private Button datosButton;
	
	public IndicadoresView(WindowOwner parent) {
		super(parent, menuVM);
		this.parent = parent;
		
	}
	
	@Override
	protected void createFormPanel(Panel mainPanel) {
		
		this.setTitle("Menu");
		mainPanel.setLayout(new HorizontalLayout());
		Panel izqPanel = new Panel(mainPanel);
		Panel derPanel = new Panel(mainPanel);
		izqPanel.setLayout(new VerticalLayout());
		derPanel.setLayout(new VerticalLayout());
		
		Selector<Empresa> selector = new Selector<Empresa>(izqPanel);
		selector.allowNull(false);
		selector.bindValueToProperty("empresaSeleccionada");
		selector.bindItemsToProperty("empresas").setAdapter(new PropertyAdapter(Empresa.class, "name"));
		
		Table<Cuenta> table = new Table<Cuenta>(mainPanel, Cuenta.class);
		table.bindItemsToProperty("empresaSeleccionada.cuentas");
	}

	@Override
	protected void addActions(Panel actionsPanel) {
		// TODO Auto-generated method stub
		
	}

	
	
}
