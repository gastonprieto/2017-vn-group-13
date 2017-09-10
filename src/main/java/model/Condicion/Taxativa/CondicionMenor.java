package model.Condicion.Taxativa;

import model.Calculo.Calculo;
import model.Empresa;
import org.uqbar.commons.utils.Observable;

@Observable
public class CondicionMenor extends CondicionMayor  {

	public CondicionMenor(String name, double valorDeReferencia, int cantidadDePeriodos, Calculo calculo) {
		this.name = name;
		this.valorDeReferencia = valorDeReferencia;
		this.cantidadDePeriodos = cantidadDePeriodos;
		this.calculo = calculo;
	}

	@Override
	public boolean aplicar(Empresa empresa) {
		return !super.aplicar(empresa);
	}

	//public void aplicar() {
		//Collection<Periodo> periodos = new ConversorYearToPeriodos(this.cantidadDePeriodos).Convertir();
	//	Resultado.getInstance().getResultadoEmpresas().filter(empresa -> this.calculo.aplicar(empresa, periodos) < valorDeReferencia);
	//}

}
