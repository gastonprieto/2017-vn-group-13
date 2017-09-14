package window;

import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

import model.builders.MetodologiaBuilder;
import viewmodel.CrearCondicionViewModel;

public class CrearCondicionView extends SimpleWindow<CrearCondicionViewModel>{

	private static final long serialVersionUID = 1L;

	public CrearCondicionView(WindowOwner parent, MetodologiaBuilder builder) {
		super(parent, new CrearCondicionViewModel());
	}
	
	@Override
	protected void createFormPanel(Panel mainPanel) {
		this.setTitle("Crear Condicion");
		mainPanel.setLayout(new VerticalLayout());
		
		// Selector de tipo de condicion
		Panel topRow = new Panel(mainPanel).setLayout(new HorizontalLayout());

		Label labelCondicion = new Label(topRow).setText("Condicion: ");
		labelCondicion.setWidth(120);
		
		// Selector de indicador
		Panel secondRow = new Panel(mainPanel).setLayout(new HorizontalLayout());
		
		Label labelIndicador = new Label(secondRow).setText("Indicador: ");
		labelIndicador.setWidth(120);
		
		// Selector de forma de aplicacion
		Panel thirdRow = new Panel(mainPanel).setLayout(new HorizontalLayout());
		
		Label labelFormaAplicacion = new Label(thirdRow).setText("Forma de aplicacion: ");
		labelFormaAplicacion.setWidth(120);

		// Selector de cantidad de periodos
		Panel bottomRow = new Panel(mainPanel).setLayout(new HorizontalLayout());
		
		Label labelPeriodos = new Label(bottomRow).setText("Periodos: ");
		labelPeriodos.setWidth(120);
		
		TextBox inputPeriodos = new TextBox(bottomRow);
		inputPeriodos.setWidth(185);
		inputPeriodos.bindValueToProperty("cantPeriodos");
	}

	@Override
	protected void addActions(Panel actionsPanel) {
		actionsPanel.setLayout(new HorizontalLayout());
		
		Button cancelar = new Button(actionsPanel);
		cancelar.setWidth(105);
		cancelar.setCaption("Cancelar");
		cancelar.onClick(this::volverAlMenu);
		
		Button sigCondicion = new Button(actionsPanel);
		sigCondicion.setWidth(105);
		sigCondicion.setCaption("Sig. Condicion");
		sigCondicion.onClick(this::abrirCrearCondicionView);
		
		Button finalizar = new Button(actionsPanel);
		finalizar.setWidth(105);
		finalizar.setCaption("Finalizar");
		finalizar.onClick(this::finalizarCreacion);
	}
	
	private void volverAlMenu() {
		MenuView menuView = new MenuView(this.getOwner(), false);
		this.close();
		menuView.open();
	}
	
	private void abrirCrearCondicionView() {
		CrearCondicionView crearCondicionView = new CrearCondicionView(this.getOwner(), this.getModelObject().getBuilder());
		this.close();
		crearCondicionView.open();
	}
	
	private void finalizarCreacion() {
		this.getModelObject().crearMetodologia();
		this.volverAlMenu();
	}
}
