package window;

import java.awt.Color;

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

import model.Cuenta;
import model.Empresa;
import viewmodel.VerCuentasViewModel;

public class VerCuentasView extends SimpleWindow<VerCuentasViewModel> {
	
	private static final long serialVersionUID = 1L;

	public VerCuentasView(WindowOwner parent) {
		super(parent, new VerCuentasViewModel());
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		this.setTitle("Ver Cuentas");
		mainPanel.setLayout(new VerticalLayout());
		Panel opcionesPanel = new Panel(mainPanel).setLayout(new HorizontalLayout());
		Panel cuentasPanel = new Panel(mainPanel).setLayout(new VerticalLayout());

		new Label(opcionesPanel).setText("Seleccione una empresa: ").setWidth(150);
		Selector<Empresa> selectorEmpresas = new Selector<Empresa>(opcionesPanel);
		selectorEmpresas.allowNull(false);
		selectorEmpresas.setWidth(200);
		selectorEmpresas.bindValueToProperty("empresaSeleccionada");
		selectorEmpresas.bindItemsToProperty("empresas").setAdapter(new PropertyAdapter(Empresa.class, "name"));

		Label TituloCuentas = new Label(cuentasPanel).setText("CUENTAS");
		TituloCuentas.setBackground(Color.WHITE);
		TituloCuentas.setWidth(375);

		Table<Cuenta> table = new Table<Cuenta>(cuentasPanel, Cuenta.class);
		table.bindItemsToProperty("empresaSeleccionada.cuentas");

		new Column<Cuenta>(table).setTitle("Nombre").setFixedSize(150).bindContentsToProperty("name");
		new Column<Cuenta>(table).setTitle("Valor").setFixedSize(75).bindContentsToProperty("value");
		new Column<Cuenta>(table).setTitle("Año").setFixedSize(75).bindContentsToProperty("periodo.year");
		new Column<Cuenta>(table).setTitle("Semestre").setFixedSize(75).bindContentsToProperty("periodo.semester");
	}
	
	@Override
	protected void addActions(Panel actionsPanel) {
		Button menu = new Button(actionsPanel).setCaption("Volver al menu");
		menu.setWidth(375);
		menu.onClick(this::abrirMenu);
	}
	
	public void abrirMenu() {
		MenuView menuView = new MenuView(this.getOwner());
		this.close();
		menuView.open();
	}
}
