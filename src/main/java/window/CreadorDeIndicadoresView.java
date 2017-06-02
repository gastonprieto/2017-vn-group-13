package window;

import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

import viewmodel.CreadorDeIndicadoresViewModel;

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
		
		new Label(panel).setText("Nombre: ").setWidth(150);
		new TextBox(panel).bindValueToProperty("nombre");
		crearIndicador = new Button(panel).setCaption("Crear Indicador");
		
		new Label(panel2).setText("Calculo: ").setWidth(150);
		new TextBox(panel2).bindValueToProperty("operacion");
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
