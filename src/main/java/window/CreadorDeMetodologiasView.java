package window;

import org.uqbar.arena.bindings.PropertyAdapter;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

import model.Indicador;
import viewmodel.CreadorDeMetodologiasYCondicionesViewModel;

public class CreadorDeMetodologiasYCondicionesView extends SimpleWindow<CreadorDeMetodologiasYCondicionesViewModel> {
	
	private static final long serialVersionUID = 1L;
	
	private Button crearIndicador;
	private Button volverAlMenu;
	private Button siguiente;
	private Button finalizar;
	private Button cancelar;
	
	Selector selectorTipos;
	
	WindowOwner parent;
	
	private static CreadorDeMetodologiasYCondicionesViewModel creadorVM = new CreadorDeMetodologiasYCondicionesViewModel();	
	
	public CreadorDeMetodologiasYCondicionesView(WindowOwner parent) {
		super(parent, creadorVM);
		this.parent = parent;
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		this.setTitle("Creador de indicadores");
		
		mainPanel.setLayout(new HorizontalLayout());
		Panel panel = new Panel(mainPanel).setLayout(new VerticalLayout());
		Panel panel2 = new Panel(mainPanel).setLayout(new VerticalLayout());
		Panel panel3 = new Panel(mainPanel).setLayout(new VerticalLayout());
		Panel panel4 = new Panel(mainPanel).setLayout(new VerticalLayout());
		
		new Label(panel).setText("Seleccione el tipo: ");
		selectorTipos = new Selector(panel);
		selectorTipos.allowNull(false);
		selectorTipos.bindItemsToProperty("tipos");
		selectorTipos.bindValueToProperty("tipoCondicionSeleccionado");		
			
		new Label(panel2).setText("Seleccione el indicador: ");
		Selector selectorIndicadores = new Selector(panel2);
		selectorIndicadores.allowNull(false);
		selectorIndicadores.bindValueToProperty("indicadorSeleccionado");
		selectorIndicadores.bindItemsToProperty("indicadores").setAdapter(new PropertyAdapter(Indicador.class, "nombre"));
		
		new Label(panel3).setText("Seleccione periodo: ").setWidth(150);
		new TextBox(panel3);		
		
		cancelar = new Button(panel).setCaption("Cancelar");
		siguiente = new Button(panel2).setCaption("Siguiente");
		finalizar = new Button(panel3).setCaption("Finalizar");
		volverAlMenu = new Button(panel4).setCaption("Volver al menu");
	}
	
	@Override
	protected void addActions(Panel actionsPanel) {
		volverAlMenu.onClick(this::volverAlMenu);
		selectorTipos.onSelection(this::seleccionarTipo);
	}
	
	public void volverAlMenu() {
		MenuView menuView = new MenuView(this.parent, false);
		this.close();
		menuView.open();
	}
	
	public void seleccionarTipo() {
		System.out.println(creadorVM.getTipoCondicionSeleccionado());
	}
	
	public CreadorDeMetodologiasYCondicionesViewModel getCreadorVM() {
		return creadorVM;
	}
	

}
