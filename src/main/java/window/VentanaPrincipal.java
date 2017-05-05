package window;

import org.uqbar.arena.bindings.ObservableProperty;
import org.uqbar.arena.bindings.PropertyAdapter;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.lacar.ui.model.Action;
import org.uqbar.lacar.ui.model.ListBuilder;
import org.uqbar.lacar.ui.model.bindings.Binding;

import viewmodel.VentanaPrincipalViewModel;
import model.Cuenta;
import model.Empresa;

public class VentanaPrincipal extends SimpleWindow<VentanaPrincipalViewModel> {

	private static final long serialVersionUID = 1L;
	
	WindowOwner parent;
	private static VentanaPrincipalViewModel ventanaVM = new VentanaPrincipalViewModel();
	
	public VentanaPrincipal(WindowOwner parent) {
		
		super(parent, ventanaVM);
		this.parent = parent;
		
	}

	@Override
	protected void addActions(Panel actionsPanel) {
		
		
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		
		this.setTitle("Ventana Principal");
		mainPanel.setLayout(new HorizontalLayout());
		Panel izqPanel = new Panel(mainPanel);
		Panel derPanel = new Panel(mainPanel);
		izqPanel.setLayout(new VerticalLayout());
		derPanel.setLayout(new VerticalLayout());
		new Label(izqPanel).setText("Empresas").setWidth(150);
		new Label(derPanel).setText("Cuentas disponibles");
		mainPanel.setLayout(new HorizontalLayout());
		Panel verticalPanel = new Panel(izqPanel);
		verticalPanel.setLayout(new VerticalLayout());
		Table<Cuenta> cuentasTable = new Table<>(derPanel, Cuenta.class);
		
		Selector<Empresa> selector = new Selector<Empresa>(izqPanel);
		selector.allowNull(false);
		selector.bindValueToProperty("empresaSeleccionada");
		selector.bindItemsToProperty("empresas").setAdapter(new PropertyAdapter(Empresa.class, "name"));
		//new TextBox(izqPanel).bindValueToProperty("nombreEmpresa");
		//selector.onSelection(() -> );
	
		
		
		//Table<Cuenta> cuentasTable = new Table<>(verticalPanel, Cuenta.class);
		cuentasTable.bindItemsToProperty("cuentasSeleccionadas");
		
		Column<Cuenta> namesColumn = new Column<Cuenta>(cuentasTable);
		namesColumn.setTitle("Nombre").setFixedSize(100).bindContentsToProperty("name");
	
		Column<Cuenta> valuesColumn = new Column<Cuenta>(cuentasTable);
		valuesColumn.setTitle("Valor").setFixedSize(200).bindContentsToProperty("value");
		
		Column<Cuenta> yearsColumn = new Column<Cuenta>(cuentasTable);
		yearsColumn.setTitle("Año").setFixedSize(100).bindContentsToProperty("lastGrade");
		
		
		Column<Cuenta> semestersColumn = new Column<Cuenta>(cuentasTable);
		semestersColumn.setTitle("Semestre").setFixedSize(100).bindContentsToProperty("lastGrade");
		
		new Label(derPanel).setText("Resultado de aplicar indicadores en un periodo");
		new Label(derPanel).setText("Graficar de periodo de la empresa seleccionada");
	}
	
	public VentanaPrincipalViewModel getDatosVM() {
		return ventanaVM;
	}
}





