package window;

import java.util.Collection;

import org.uqbar.arena.bindings.PropertyAdapter;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.widgets.Spinner;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

import model.Condicion;
import model.Indicador;
import viewmodel.CreadorDeMetodologiasViewModel;

public class CreadorDeMetodologiasView extends SimpleWindow<CreadorDeMetodologiasViewModel> {
	
	private static final long serialVersionUID = 1L;
	
	private Button crearIndicador;
	private Button volverAlMenu;
	private Button siguiente;
	private Button finalizar;
	private Button cancelar;
	
	Selector selectorTipos;
	Selector<String> selectorModo;
	Collection<Condicion> condiciones;
	
	WindowOwner parent;
	
	private static CreadorDeMetodologiasViewModel creadorVM = new CreadorDeMetodologiasViewModel();	
	
	public CreadorDeMetodologiasView(WindowOwner parent) {
		super(parent, creadorVM);
		this.parent = parent;
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		this.setTitle("Creador de Metodologia");
		
		mainPanel.setLayout(new HorizontalLayout());
		Panel panel1 = new Panel(mainPanel).setLayout(new VerticalLayout());
		Panel panel2 = new Panel(mainPanel).setLayout(new VerticalLayout());
		Panel panel3 = new Panel(mainPanel).setLayout(new VerticalLayout());
		Panel panel4 = new Panel(mainPanel).setLayout(new VerticalLayout());
		Panel panel5 = new Panel(mainPanel).setLayout(new VerticalLayout());
		
		new Label(panel1).setText("Seleccione el tipo: ");
		Selector selectorTipos = new Selector(panel1);
		selectorTipos.allowNull(false);
		selectorTipos.bindItemsToProperty("tipos");
		selectorTipos.bindValueToProperty("tipoCondicionSeleccionado");		
		
		new Label(panel2).setText("Seleccione el Modo: ");
		Selector<String> selectorModo = new Selector<String>(panel2);
		selectorModo.allowNull(false);
		selectorModo.bindItemsToProperty("modo");
		selectorModo.bindValueToProperty("modoCondicionSeleccionado");
		

		
		new Label(panel3).setText("Seleccione el indicador: ");
		Selector<Indicador> selectorIndicadores = new Selector<Indicador>(panel3);
		selectorIndicadores.allowNull(false);
		selectorIndicadores.bindValueToProperty("indicadorSeleccionado");
		selectorIndicadores.bindItemsToProperty("indicadores").setAdapter(new PropertyAdapter(Indicador.class, "nombre"));
		
		new Label(panel4).setText("Seleccione periodo: ").setWidth(150);
		
		Spinner periodo = new Spinner(panel4); 
		periodo.bindValueToProperty("periodoSeleccionado");
		
		cancelar = new Button(panel1).setCaption("Cancelar");
		siguiente = new Button(panel3).setCaption("Siguiente");
		finalizar = new Button(panel4).setCaption("Finalizar");
		volverAlMenu = new Button(panel5).setCaption("Volver al menu");
	}
	
	@Override
	protected void addActions(Panel actionsPanel) {
		volverAlMenu.onClick(this::volverAlMenu);
		siguiente.onClick(this::agregarCondicion);
		selectorTipos.onSelection(this::seleccionarTipo);
		selectorModo.onSelection(this::seleccionarModo);
	}
	
	public void volverAlMenu() {
		MenuView menuView = new MenuView(this.parent, false);
		this.close();
		menuView.open();
	}
	
	public void seleccionarTipo() {
		System.out.println(creadorVM.getTipoCondicionSeleccionado());
	}
	
	public void seleccionarModo() {
		System.out.println(creadorVM.getModoCondicionSeleccionado());
	}
	public CreadorDeMetodologiasViewModel getCreadorVM() {
		return creadorVM;
	}
	
	public void agregarCondicion(){
		
	}

}