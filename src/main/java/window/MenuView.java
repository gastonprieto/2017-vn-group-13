package window;

import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

import viewmodel.MenuViewModel;

public class MenuView extends SimpleWindow<MenuViewModel> {

	private static final long serialVersionUID = 1L;
	
	WindowOwner parent;
	
	public MenuView(WindowOwner parent, boolean noCargarDatos) {
		super(parent, new MenuViewModel(noCargarDatos));
		this.parent = parent;
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		this.setTitle("Menu");
		mainPanel.setLayout(new HorizontalLayout());
	}

	@Override
	protected void addActions(Panel actionsPanel) {
		actionsPanel.setLayout(new VerticalLayout());
		new Button(actionsPanel).setCaption("Ver Cuentas").onClick(this::abrirCuentas).setWidth(200);
		new Button(actionsPanel).setCaption("Aplicar Indicadores").onClick(this::abrirIndicadores);
		new Button(actionsPanel).setCaption("Aplicar Metodologia").onClick(this::abrirMetodologias);
		new Button(actionsPanel).setCaption("Crear Indicador").onClick(this::abrirCreadorDeIndicadores);
		new Button(actionsPanel).setCaption("Crear Metodologias y Condiciones").onClick(this::abrirCreadorDeMetodologiasYCondiciones);
	}
	
	public void abrirCuentas() {
		VerCuentasView cuentasView = new VerCuentasView(this.parent);
		this.close();
		cuentasView.open();
	}
	
	public void abrirIndicadores() {
		IndicadoresView indicadoresView = new IndicadoresView(this.parent);
		this.close();
		indicadoresView.open();
	}

	public void abrirMetodologias() {
		VentanaMetodologia metodologiaView = new VentanaMetodologia(this.parent);
		this.close();
		metodologiaView.open();
	}

	public void abrirCreadorDeIndicadores() {
		CreadorDeIndicadoresView creadorView = new CreadorDeIndicadoresView(this.parent);
		this.close();
		creadorView.open();
	}
	
	public void abrirCreadorDeMetodologiasYCondiciones() {
		CreadorDeMetodologiasView creadorView = new CreadorDeMetodologiasView(this.parent);
		this.close();
		creadorView.open();
	}
}
