package window;

import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

import viewmodel.CrearMetodologiaViewModel;

public class CrearMetodologiaView extends SimpleWindow<CrearMetodologiaViewModel> {

	private static final long serialVersionUID = 1L;

	public CrearMetodologiaView(WindowOwner parent) {
		super(parent, new CrearMetodologiaViewModel());
	}
	
	@Override
	protected void createFormPanel(Panel mainPanel) {
		this.setTitle("Crear Metodologia");
		mainPanel.setLayout(new VerticalLayout());
		
		Panel topRow = new Panel(mainPanel).setLayout(new HorizontalLayout());
		
		Label labelNombre = new Label(topRow).setText("Nombre: ");
		labelNombre.setWidth(65);
		
		TextBox textBoxNombre = new TextBox(topRow);
		textBoxNombre.bindValueToProperty("nombre");
		textBoxNombre.setWidth(130);
	}
	
	@Override
	protected void addActions(Panel actionsPanel) {
		actionsPanel.setLayout(new HorizontalLayout());
		
		Button cancelar = new Button(actionsPanel);
		cancelar.setWidth(105);
		cancelar.setCaption("Cancelar");
		cancelar.onClick(this::cancelarCreacion);
		
		Button crearCondiciones = new Button(actionsPanel);
		crearCondiciones.setWidth(105);
		crearCondiciones.setCaption("Crear condiciones");
		crearCondiciones.onClick(this::abrirCrearCondicionView);
	}
	
	private void cancelarCreacion() {
		MenuView menuView = new MenuView(this.getOwner(), false);
		this.close();
		menuView.open();
	}
	
	private void abrirCrearCondicionView() {
		CrearCondicionView crearCondicionView = new CrearCondicionView(this.getOwner(), this.getModelObject().getBuilder());
		this.close();
		crearCondicionView.open();
	}
}
