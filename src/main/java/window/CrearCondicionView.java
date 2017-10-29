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
import model.builders.MetodologiaBuilder;
import viewmodel.CrearCondicionViewModel;

public class CrearCondicionView extends SimpleWindow<CrearCondicionViewModel>{

	private static final long serialVersionUID = 1L;

	public CrearCondicionView(WindowOwner parent, MetodologiaBuilder builder) {
		super(parent, new CrearCondicionViewModel());
		this.getModelObject().setBuilder(builder);
	}
	
	@Override
	protected void createFormPanel(Panel mainPanel) {
		this.setTitle("Crear Condicion");
		mainPanel.setLayout(new VerticalLayout());
		
		// Selector de tipo de condicion
		Panel firstRow = new Panel(mainPanel).setLayout(new HorizontalLayout());

		Label labelCondicion = new Label(firstRow).setText("Condicion: ");
		labelCondicion.setWidth(120);
		
		Selector<String> selectorCondicion = new Selector<>(firstRow);
		selectorCondicion.bindItemsToProperty("tiposDeCondicion");
		selectorCondicion.bindValueToProperty("tipoDeCondicionSeleccionada");
		selectorCondicion.setWidth(170);
		
		// Selector de indicador
		Panel secondRow = new Panel(mainPanel).setLayout(new HorizontalLayout());
		
		Label labelIndicador = new Label(secondRow).setText("Indicador: ");
		labelIndicador.setWidth(120);
		
		Selector<Indicador> selectorIndicador = new Selector<>(secondRow);
		selectorIndicador.bindItemsToProperty("indicadores").setAdapter(new PropertyAdapter(Indicador.class, "nombre"));
		selectorIndicador.bindValueToProperty("indicadorSeleccionado");
		selectorIndicador.setWidth(170);
		
		// Selector de forma de aplicacion
		Panel thirdRow = new Panel(mainPanel).setLayout(new HorizontalLayout());
		
		Label labelFormaAplicacion = new Label(thirdRow).setText("Forma de aplicacion: ");
		labelFormaAplicacion.setWidth(120);
		
		Selector<String> selectorFormaAplicacion = new Selector<>(thirdRow);
		selectorFormaAplicacion.bindItemsToProperty("formasDeAplicacion");
		selectorFormaAplicacion.bindValueToProperty("formaDeAplicacionSeleccionada");
		selectorFormaAplicacion.setWidth(170);

		// Input de cantidad de periodos
		Panel fourthRow = new Panel(mainPanel).setLayout(new HorizontalLayout());
		
		Label labelPeriodos = new Label(fourthRow).setText("Periodos: ");
		labelPeriodos.setWidth(120);
		
		TextBox inputPeriodos = new TextBox(fourthRow);
		inputPeriodos.setWidth(185);
		inputPeriodos.bindValueToProperty("cantPeriodos");
		
		// Input de valor de referencia
		Panel fifthRow = new Panel(mainPanel).setLayout(new HorizontalLayout());
		
		Label labelValorReferencia = new Label(fifthRow).setText("Valor de referencia: ");
		labelValorReferencia.setWidth(120);
		
		TextBox inputValorReferencia = new TextBox(fifthRow);
		inputValorReferencia.setWidth(185);
		inputValorReferencia.bindValueToProperty("valorDeReferencia");
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
		MenuView menuView = new MenuView(this.getOwner());
		this.close();
		menuView.open();
	}
	
	private void abrirCrearCondicionView() {
		try {
			CrearCondicionView crearCondicionView = new CrearCondicionView(this.getOwner(), this.getModelObject().getBuilder());
			this.close();
			crearCondicionView.open();
		} catch(RuntimeException e) {
			showError(e.getMessage());
		}
	}
	
	private void finalizarCreacion() {
		try {
			this.getModelObject().crearMetodologia();
			this.volverAlMenu();
		} catch(RuntimeException e) {
			showError(e.getMessage());
		}
	}
}
