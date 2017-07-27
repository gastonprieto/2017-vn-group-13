package window;

import model.Cuenta;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;
import model.*;
import org.uqbar.arena.bindings.PropertyAdapter;
import org.uqbar.arena.widgets.*;

import viewmodel.CreadorDeIndicadoresViewModel;

import java.awt.*;

public class CreadorDeIndicadoresView extends SimpleWindow<CreadorDeIndicadoresViewModel> {
	
	private static final long serialVersionUID = 1L;
	
	private Button crearIndicador;
	private Button volverAlMenu;
	WindowOwner parent;
	private static CreadorDeIndicadoresViewModel creadorVM = new CreadorDeIndicadoresViewModel();
	
	public CreadorDeIndicadoresView(WindowOwner parent) {
		super(parent, creadorVM);
		this.parent = parent;
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		this.setTitle("Creador de indicadores");

		mainPanel.setLayout(new HorizontalLayout());
		Panel panel = new Panel(mainPanel).setLayout(new VerticalLayout());
		Panel panel2 = new Panel(mainPanel).setLayout(new VerticalLayout());

		Selector<Empresa> selectorEmpresas = new Selector<Empresa>(panel);
		selectorEmpresas.allowNull(false);
		selectorEmpresas.bindValueToProperty("empresaSeleccionada");
		selectorEmpresas.bindItemsToProperty("empresas").setAdapter(new PropertyAdapter(Empresa.class, "name"));


		Label TituloCuentas = new Label(panel).setText("CUENTAS");
		TituloCuentas.setBackground(Color.WHITE);
		TituloCuentas.setWidth(500);

		Table<Cuenta> table = new Table<Cuenta>(panel, Cuenta.class);
		table.bindItemsToProperty("empresaSeleccionada.cuentas");

		new Column<Cuenta>(table).setTitle("Nombre").setFixedSize(150).bindContentsToProperty("name");
		new Column<Cuenta>(table).setTitle("Valor").setFixedSize(75).bindContentsToProperty("value");
		new Column<Cuenta>(table).setTitle("A�o").setFixedSize(75).bindContentsToProperty("periodo.year");
		new Column<Cuenta>(table).setTitle("Semestre").setFixedSize(75).bindContentsToProperty("periodo.semester");


		new Label(panel2).setText("Nombre: ").setWidth(150);
		new TextBox(panel2).bindValueToProperty("nombre");
		new Label(panel2).setText("Calculo: ").setWidth(150);
		new TextBox(panel2).bindValueToProperty("operacion");
		
		crearIndicador = new Button(panel2).setCaption("Crear Indicador");
		volverAlMenu = new Button(panel2).setCaption("Volver al menu");
	}
	
	@Override
	protected void addActions(Panel actionsPanel) {
		crearIndicador.onClick(this::guardarIndicador);
		volverAlMenu.onClick(this::volverAlMenu);
	}
	
	public void guardarIndicador() {
		getCreadorVM().guardarIndicador();;
		volverAlMenu();
	}
	
	public void volverAlMenu() {
		MenuView menuView = new MenuView(this.parent, false);
		this.close();
		menuView.open();
	}
	
	public CreadorDeIndicadoresViewModel getCreadorVM() {
		return creadorVM;
	}
}
