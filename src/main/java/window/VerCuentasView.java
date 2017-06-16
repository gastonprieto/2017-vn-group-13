package window;

import org.uqbar.arena.bindings.PropertyAdapter;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
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
	private Button menu;
	WindowOwner parent;
	
	
	public VerCuentasView(WindowOwner parent) {
		super(parent, new VerCuentasViewModel());
		this.parent = parent;
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		
		this.setTitle("Ver Cuentas");
		mainPanel.setLayout(new VerticalLayout());

		Panel OpcionesPanel = new Panel(mainPanel).setLayout(new HorizontalLayout());

		Panel CuentasPanel = new Panel(mainPanel).setLayout(new VerticalLayout());

		Panel IndicadoresPanel = new Panel(mainPanel).setLayout(new VerticalLayout());
		
		new Label(CuentasPanel).setText("Cuentas");

		/* Contenido OpcionesPanel*/
		new Label(CuentasPanel).setText("Seleccione una empresa: ");

		Selector<Empresa> selector = new Selector<Empresa>(OpcionesPanel);
		selector.allowNull(false);
		selector.bindValueToProperty("empresaSeleccionada");
		selector.bindItemsToProperty("empresas").setAdapter(new PropertyAdapter(Empresa.class, "name"));

		menu = new Button(OpcionesPanel).setCaption("Volver al menu");
		new Button(OpcionesPanel).setCaption("Agregar Indicador");

		/* Contenido CuentasPanel*/

		Table<Cuenta> table = new Table<Cuenta>(CuentasPanel, Cuenta.class);
		table.bindItemsToProperty("empresaSeleccionada.cuentas");

		new Column<Cuenta>(table).setTitle("Nombre").setFixedSize(150).bindContentsToProperty("name");
		new Column<Cuenta>(table).setTitle("Valor").setFixedSize(75).bindContentsToProperty("value");
		new Column<Cuenta>(table).setTitle("A�o").setFixedSize(75).bindContentsToProperty("periodo.year");
		new Column<Cuenta>(table).setTitle("Semestre").setFixedSize(75).bindContentsToProperty("periodo.semester");

		/* Contenido IndicadoresPanel*/

		Table<Cuenta> table2 = new Table<Cuenta>(IndicadoresPanel, Cuenta.class);
		table.bindItemsToProperty("empresaSeleccionada.cuentas");

		new Column<Cuenta>(table2).setTitle("Nombre").setFixedSize(150).bindContentsToProperty("name");
		new Column<Cuenta>(table2).setTitle("Calculo").setFixedSize(75).bindContentsToProperty("value");
		new Column<Cuenta>(table2).setTitle("Resultado").setFixedSize(75).bindContentsToProperty("periodo.year");
	}
	
	@Override
	protected void addActions(Panel actionsPanel) {
		menu.onClick(this::abrirMenu);
	}
	
	public void abrirMenu() {
		MenuView menuView = new MenuView(this.parent, false);
		this.close();
		menuView.open();
	}

	
}





