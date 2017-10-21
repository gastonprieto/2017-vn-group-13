package window;

import org.uqbar.arena.bindings.PropertyAdapter;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.MessageBox;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

import model.Empresa;
import model.Metodologia;
import viewmodel.AplicarMetodologiaViewModel;

public class AplicarMetodologiaView extends SimpleWindow<AplicarMetodologiaViewModel> {

	private static final long serialVersionUID = 1L;

	public AplicarMetodologiaView(WindowOwner parent) {
		super(parent, new AplicarMetodologiaViewModel());
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		this.setTitle("Aplicar Metodologia");
		mainPanel.setLayout(new VerticalLayout());
		
		new Label(mainPanel).setText("Seleccione metodologia: ");
		Selector<Metodologia> selectorMetodologia = new Selector<>(mainPanel);
		selectorMetodologia.bindValueToProperty("metodologiaSeleccionada");
		selectorMetodologia.bindItemsToProperty("metodologias").setAdapter(new PropertyAdapter(Metodologia.class, "nombre"));

		Table<Empresa> tablaResultado = new Table<>(mainPanel, Empresa.class);
		tablaResultado.bindItemsToProperty("resultadoEmpresasEvaluadas");
		new Column<Empresa>(tablaResultado).setTitle("Nombre").setWeight(150).bindContentsToProperty("name");
	}

	@Override
	protected void addActions(Panel actionsPanel) {
		actionsPanel.setLayout(new HorizontalLayout());
		new Button(actionsPanel).setCaption("Volver a menu").onClick(this::abrirMenu);
		new Button(actionsPanel).setCaption("Evaluar").onClick(this::aplicarMetodologiaSeleccionada);
	}

	public void abrirMenu() {
		MenuView menuView = new MenuView(this.getOwner(), false);
		this.close();
		menuView.open();
	}

	// TODO este try-catch es feisimo, hay que hacer que se pueda aplicar igual la metodologia pero que no tome
	// en cuenta a esa empresa o algo asi.
	// RESUELTO, pero por las dudas, por ahora vamos a dejar la excepcion. Al menos hasta estar seguros de contemplamos
	//las expeciones bien mas abajo.
	public void aplicarMetodologiaSeleccionada(){
		try {
			this.getModelObject().aplicarMetodologiaSeleccionada();
		} catch(Exception e) {
			if(e.getMessage() == null){
				e.printStackTrace();
			}
			showErrorMessageBox(e.getMessage());
		}
	}

	protected void showErrorMessageBox(String message) {
		MessageBox messageBox = new MessageBox(this, MessageBox.Type.Error);
		messageBox.setMessage("");
		messageBox.open();
	}
}
