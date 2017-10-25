package window;

import org.uqbar.arena.bindings.PropertyAdapter;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.widgets.TextFilter;
import org.uqbar.arena.windows.MessageBox;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

import exception.IndicadorException;
import model.Empresa;
import model.Indicador;
import viewmodel.IndicadoresViewModel;

public class IndicadoresView extends SimpleWindow<IndicadoresViewModel>  {

	private static final long serialVersionUID = 1L;

	public IndicadoresView(WindowOwner parent) {
		super(parent, new IndicadoresViewModel());
	}
	
	@Override
	protected void createFormPanel(Panel mainPanel) {
		this.setTitle("Aplicar Indicadores");
		mainPanel.setLayout(new VerticalLayout());
		
		Panel firstPanel = new Panel(mainPanel);
		firstPanel.setLayout(new HorizontalLayout());
		new Label(firstPanel).setText("Seleccione un indicador: ");
		Selector<Indicador> selectorIndicador = new Selector<Indicador>(firstPanel);
		selectorIndicador.allowNull(false);
		selectorIndicador.setWidth(150);
		selectorIndicador.bindValueToProperty("indicadorSeleccionado");
		selectorIndicador.bindItemsToProperty("indicadores").setAdapter(new PropertyAdapter(Indicador.class, "nombre"));
		new Label(firstPanel).setText("Seleccione una empresa: ");
		Selector<Empresa> selectorEmpresas = new Selector<Empresa>(firstPanel);
		selectorEmpresas.allowNull(false);
		selectorEmpresas.setWidth(150);
		selectorEmpresas.bindValueToProperty("empresaSeleccionada");
		selectorEmpresas.bindItemsToProperty("empresas").setAdapter(new PropertyAdapter(Empresa.class, "name"));
		
		Panel secondPanel = new Panel(mainPanel);
		secondPanel.setLayout(new HorizontalLayout());
		new Label(secondPanel).setText("Ingrese el año: ");
		TextBox yearTextBox = new TextBox(secondPanel);
		yearTextBox.bindValueToProperty("selectedYear");
		yearTextBox.setWidth(150);
		yearTextBox.withFilter(TextFilter.NUMERIC_TEXT_FILTER);
		new Label(secondPanel).setText("Ingrese el semestre: ");
		TextBox semesterTextBox = new TextBox(secondPanel);
		semesterTextBox.bindValueToProperty("selectedSemester");
		semesterTextBox.setWidth(150);
		semesterTextBox.withFilter(TextFilter.NUMERIC_TEXT_FILTER);
	}

	@Override
	protected void addActions(Panel actionsPanel) {
		Button aplicarIndicador = new Button(actionsPanel).setCaption("Aplicar");
		aplicarIndicador.onClick(this::aplicarIndicador);
		
		Button menu = new Button(actionsPanel).setCaption("Volver al menu");
		menu.onClick(this::abrirMenu);
		
		new Label(actionsPanel).setText("Resultado: ");
		Label resultado = new Label(actionsPanel);
		resultado.bindValueToProperty("resultado");
	}

	public void aplicarIndicador() {
		try {
			this.getModelObject().aplicarIndicador();
		}catch (IndicadorException e){
			showErrorMessageBox(e.getMessage());
		}
	}
	
	protected void showErrorMessageBox(String message) {
		MessageBox messageBox = new MessageBox(this, MessageBox.Type.Error);
		messageBox.setMessage(message);
		messageBox.open();
	}
	
	public void abrirMenu() {
		MenuView menuView = new MenuView(this.getOwner());
		this.close();
		menuView.open();
	}
}
