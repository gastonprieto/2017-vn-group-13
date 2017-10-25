package window;

import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.MessageBox;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

import exception.IndicadorException;
import viewmodel.CreadorDeIndicadoresViewModel;

public class CreadorDeIndicadoresView extends SimpleWindow<CreadorDeIndicadoresViewModel> {
	
	private static final long serialVersionUID = 1L;
	
	private Button crearIndicador;
	private Button volverAlMenu;
	
	public CreadorDeIndicadoresView(WindowOwner parent) {
		super(parent, new CreadorDeIndicadoresViewModel());
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		this.setTitle("Creador de indicadores");

		mainPanel.setLayout(new HorizontalLayout());
		Panel panel2 = new Panel(mainPanel).setLayout(new VerticalLayout());

		new Label(panel2).setText("Nombre: ").setWidth(150);
		new TextBox(panel2).bindValueToProperty("nombre");
		new Label(panel2).setText("Calculo: ").setWidth(150);
		new TextBox(panel2).bindValueToProperty("operacion");

		crearIndicador = new Button(panel2).setCaption("Crear Indicador");
		volverAlMenu = new Button(panel2).setCaption("Volver al menu");
	}
	
	@Override
	protected void addActions(Panel actionsPanel) {
		crearIndicador.onClick(this::guardarIndicador);
		volverAlMenu.onClick(this::volverAlMenu);
	}
	
	public void guardarIndicador() {
		try {
			getModelObject().guardarIndicador();;
			volverAlMenu();
		} catch(IndicadorException e) {
			showErrorMessageBox(e.getMessage());
		}
	}
	
	protected void showErrorMessageBox(String message) {
		MessageBox messageBox = new MessageBox(this, MessageBox.Type.Error);
		messageBox.setMessage(message);
		messageBox.open();
	}

	public void volverAlMenu() {
		MenuView menuView = new MenuView(this.getOwner());
		this.close();
		menuView.open();
	}
}
