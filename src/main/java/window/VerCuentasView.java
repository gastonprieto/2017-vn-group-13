package window;

import org.uqbar.arena.bindings.PropertyAdapter;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

import viewmodel.VerCuentasViewModel;
import model.Cuenta;
import model.Empresa;

public class VerCuentasView extends SimpleWindow<VerCuentasViewModel> {
	private static final long serialVersionUID = 1L;
	
	public VerCuentasView(WindowOwner parent) {
		super(parent, new VerCuentasViewModel());
	}

	@Override
	protected void addActions(Panel actionsPanel) {
		
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		
		this.setTitle("Ver Cuentas");
		mainPanel.setLayout(new HorizontalLayout());
		
		Panel verticalPanel = new Panel(mainPanel).setLayout(new VerticalLayout());
		
		new Label(verticalPanel).setText("Seleccione una empresa: ");
		
		Selector<Empresa> selector = new Selector<Empresa>(verticalPanel);
		selector.allowNull(false);
		selector.bindValueToProperty("empresaSeleccionada");
		selector.bindItemsToProperty("empresas").setAdapter(new PropertyAdapter(Empresa.class, "name"));
		
		Table<Cuenta> table = new Table<Cuenta>(mainPanel, Cuenta.class);
		table.bindItemsToProperty("empresaSeleccionada.cuentas");

		new Column<Cuenta>(table).setTitle("Nombre").setFixedSize(150).bindContentsToProperty("name");
		new Column<Cuenta>(table).setTitle("Valor").setFixedSize(75).bindContentsToProperty("value");
		new Column<Cuenta>(table).setTitle("Año").setFixedSize(75).bindContentsToProperty("periodo.year");
		new Column<Cuenta>(table).setTitle("Semestre").setFixedSize(75).bindContentsToProperty("periodo.semester");
	}
}





