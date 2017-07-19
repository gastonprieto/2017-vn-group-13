package window;

import model.Indicador;
import model.Periodo;
import org.uqbar.arena.bindings.PropertyAdapter;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.*;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.arena.windows.MessageBox;

import scala.Array;
import scala.collection.immutable.*;
import viewmodel.VerCuentasViewModel;
import model.Cuenta;
import model.Empresa;

import java.awt.*;
import java.util.Collection;
import java.util.Iterator;
import org.uqbar.commons.model.UserException;

public class VerCuentasView extends SimpleWindow<VerCuentasViewModel> {
	
	private static final long serialVersionUID = 1L;
	private Button menu;
	private Button AplicarIndicador;
	WindowOwner parent;
	private  static VerCuentasViewModel  creadorVM = new VerCuentasViewModel();
	
	
	public VerCuentasView(WindowOwner parent) {
		super(parent, new VerCuentasViewModel());
		this.parent = parent;
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		
		this.setTitle("Ver Cuentas");

		mainPanel.setLayout(new VerticalLayout());

		Panel OpcionesPanel = new Panel(mainPanel).setLayout(new HorizontalLayout());

		Panel CuentasPanel = new Panel(mainPanel).setLayout(new VerticalLayout());

		Panel IndicadoresPanel = new Panel(mainPanel).setLayout(new VerticalLayout());


		/* Contenido OpcionesPanel*/
		new Label(OpcionesPanel).setText("Seleccione una empresa: ");

		Selector<Empresa> selectorEmpresas = new Selector<Empresa>(OpcionesPanel);
		selectorEmpresas.allowNull(false);
		selectorEmpresas.bindValueToProperty("empresaSeleccionada");
		selectorEmpresas.bindItemsToProperty("empresas").setAdapter(new PropertyAdapter(Empresa.class, "name"));

		menu = new Button(OpcionesPanel).setCaption("Volver al menu");
		//new Button(OpcionesPanel).setCaption("Agregar Indicador");

		/* Contenido CuentasPanel*/

		Label TituloCuentas = new Label(CuentasPanel).setText("CUENTAS");
		TituloCuentas.setBackground(Color.WHITE);
		TituloCuentas.setWidth(500);

		Table<Cuenta> table = new Table<Cuenta>(CuentasPanel, Cuenta.class);
		table.bindItemsToProperty("empresaSeleccionada.cuentas");

		new Column<Cuenta>(table).setTitle("Nombre").setFixedSize(150).bindContentsToProperty("name");
		new Column<Cuenta>(table).setTitle("Valor").setFixedSize(75).bindContentsToProperty("value");
		new Column<Cuenta>(table).setTitle("A�o").setFixedSize(75).bindContentsToProperty("periodo.year");
		new Column<Cuenta>(table).setTitle("Semestre").setFixedSize(75).bindContentsToProperty("periodo.semester");

		/* Contenido IndicadoresPanel*/

		Label TituloIndicadores = new Label(IndicadoresPanel).setText("INDICADORES");
		TituloIndicadores.setBackground(Color.WHITE);
		TituloIndicadores.setWidth(500);

		/* Contenido IndicadoresOpcionesPanel*/

			Panel IndicadoresOpcionesPanel = new Panel(IndicadoresPanel).setLayout(new HorizontalLayout());

			new Label(IndicadoresOpcionesPanel).setText("Seleccione un perido");

			Selector<Indicador> selectorIndicador = new Selector<Indicador>(IndicadoresOpcionesPanel);
			selectorIndicador.allowNull(false);
			selectorIndicador.bindValueToProperty("indicadorSeleccionado");
			selectorIndicador.bindItemsToProperty("indicadores").setAdapter(new PropertyAdapter(Indicador.class, "nombre"));

			TextBox peridoYear = new TextBox(IndicadoresOpcionesPanel);
			peridoYear.bindValueToProperty("peridoSeleccionadao.year");
			peridoYear.withFilter(TextFilter.NUMERIC_TEXT_FILTER);

			TextBox peridoSemestre = new TextBox(IndicadoresOpcionesPanel);
			peridoSemestre.bindValueToProperty("peridoSeleccionadao.semester");
			peridoSemestre.withFilter(TextFilter.NUMERIC_TEXT_FILTER);

			AplicarIndicador = new Button(IndicadoresOpcionesPanel).setCaption("Aplicar");

			new Label(IndicadoresOpcionesPanel).setText("Resultado");
			Label Resultado = new Label(IndicadoresOpcionesPanel).setText("Resultado");
			Resultado.bindValueToProperty("resultadoDeAplicarIndiador");
	}
	
	@Override
	protected void addActions(Panel actionsPanel) {

		menu.onClick(this::abrirMenu);
		AplicarIndicador.onClick(this::AplicarIndicadorAempresaSeleccionada);

	}
	
	public void abrirMenu() {
		MenuView menuView = new MenuView(this.parent, false);
		this.close();
		menuView.open();
	}

	public void AplicarIndicadorAempresaSeleccionada() {
		try{
			getCreadorVM().AplicarIndicadorEnPerido();
			showErrorMessageBox("No hace nada");
		}catch(UserException e){
			showErrorMessageBox("Tal vez si hace algo y mal ensima");

		}
	}

	public VerCuentasViewModel getCreadorVM() {
		return creadorVM;
	}

	protected void showErrorMessageBox(String message) {
		MessageBox messageBox = new MessageBox(this, MessageBox.Type.Error);
		messageBox.setMessage(message);
		messageBox.open();
	}

}





