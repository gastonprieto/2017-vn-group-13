package window;

import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;
import viewmodel.VentanaPrincipalViewModel;


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
		Panel verticalPanel = new Panel(mainPanel);
		verticalPanel.setLayout(new VerticalLayout());
		
		/*Table<Asignacion> assignmentsTable = new Table<>(verticalPanel, Asignacion.class);
		assignmentsTable.bindItemsToProperty("asignaciones");
		
		Column<Asignacion> idsColumn = new Column<Asignacion>(assignmentsTable);
		idsColumn.setTitle("Titulo").setFixedSize(100).bindContentsToProperty("title");
	
		Column<Asignacion> descriptionsColumn = new Column<Asignacion>(assignmentsTable);
		descriptionsColumn.setTitle("Descripcion").setFixedSize(200).bindContentsToProperty("description");
		
		Column<Asignacion> gradesColumn = new Column<Asignacion>(assignmentsTable);
		gradesColumn.setTitle("Nota").setFixedSize(100).bindContentsToProperty("lastGrade");*/
		new Label(derPanel).setText("Resultado de aplicar indicadores en un periodo");
		new Label(derPanel).setText("Graficar de periodo de la empresa seleccionada");
	}
	
	public VentanaPrincipalViewModel getDatosVM() {
		return ventanaVM;
	}
}
