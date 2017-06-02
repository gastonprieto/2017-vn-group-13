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
	WindowOwner parent;
	private static CreadorDeIndicadoresViewModel creadorVM = new CreadorDeIndicadoresViewModel();
	
	public CreadorDeIndicadoresView(WindowOwner parent) {
		super(parent,creadorVM);
		this.parent = parent;
		
	}

	
	
	@Override
	protected void createFormPanel(Panel mainPanel) {
		
		
		this.setTitle("Creador de indicadores");
		
		mainPanel.setLayout(new HorizontalLayout());
		
		Panel panel = new Panel(mainPanel).setLayout(new VerticalLayout());
		Panel panel2 = new Panel(mainPanel).setLayout(new VerticalLayout());
		
		new Label(panel).setText("Nombre del nuevo indicador:");
		new TextBox(panel).bindValueToProperty("nombre");
		
		new Label(panel2).setText("Calculo del nuevo indicador:");
		new TextBox(panel2).bindValueToProperty("operacion");
		
		crearIndicador = new Button(mainPanel).setCaption("Crear Indicador");
		
	}
	
	
	
	@Override
	protected void addActions(Panel actionsPanel) {

		//crearIndicador.onClick(this::guardarIndicador());
		
	}
	
	
	public void guardarIndicador() {
		getCreadorVM();
		this.close();
		//menuView.open(this.parent);
	}
	public CreadorDeIndicadoresViewModel getCreadorVM() {
		return creadorVM;
	}
	
	
}
