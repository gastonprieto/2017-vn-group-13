package window;

import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;


import viewmodel.MenuViewModel;



public class MenuView extends SimpleWindow<MenuViewModel> {


	private static final long serialVersionUID = 1L;
	WindowOwner parent;
	private static MenuViewModel menuVM = new MenuViewModel();
	private Button cuentasButton;
	private Button indicadorButton;
	private Button creadorButton;

	
	public MenuView(WindowOwner parent) {
		super(parent, menuVM);
		this.parent= parent;
		
	}
	
	

	@Override
	protected void createFormPanel(Panel mainPanel) {
		this.setTitle("Menu");
		
		Panel panel = new Panel(mainPanel);
		panel.setLayout(new VerticalLayout());
		
		cuentasButton = new Button(panel).setCaption("Ver Cuentas");
		indicadorButton = new Button(panel).setCaption("Aplicar Indicadores");
		creadorButton = new Button(panel).setCaption("Crear Indicador");
	}

	@Override
	protected void addActions(Panel actionsPanel) {
		// TODO Auto-generated method stub
		cuentasButton.onClick(this::abrirCuentas);
		indicadorButton.onClick(this::abrirIndicadores);
		creadorButton.onClick(this::abrirCreadorDeIndicadores);
	}
	
	public void abrirCuentas() {
		VerCuentasView cuentasView = new VerCuentasView(this.parent);
		this.close();
		cuentasView.open();
	}
	
	public void abrirCreadorDeIndicadores() {
		IndicadoresView indicadoresView = new IndicadoresView(this.parent);
		this.close();
		indicadoresView.open();
	}

	public void abrirIndicadores() {
		CreadorDeIndicadoresView creadorView = new CreadorDeIndicadoresView(this.parent);
		this.close();
		creadorView.open();
	}


}
