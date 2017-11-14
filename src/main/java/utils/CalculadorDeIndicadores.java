package utils;

import java.util.Collection;
import java.util.Iterator;

import model.Empresa;
import model.Indicador;
import model.Periodo;
import model.Resultado;
import repositorios.RepositorioDeIndicadores;
import repositorios.RepositorioDeResultados;

public class CalculadorDeIndicadores {
	
	public void calcular(Collection<Empresa> empresas, Periodo periodo) {
		Collection<Indicador> indicadores = RepositorioDeIndicadores.getInstance().getIndicadores();
		
		for (Empresa empresa : empresas) {
			for (Indicador indicador : indicadores) {
				Resultado resultado = new Resultado();
				resultado.setEmpresa(empresa);
				resultado.setIndicador(indicador);
				resultado.setPeriodo(periodo);
				resultado.setValor(indicador.aplicar(empresa, periodo));
				
				RepositorioDeResultados.getInstance().registrarResultado(resultado);
			}			
		}						
	}

}
