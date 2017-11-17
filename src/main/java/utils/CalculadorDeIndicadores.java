package utils;

import java.util.Collection;

import model.Empresa;
import model.Indicador;
import model.Periodo;
import model.Resultado;
import model.Usuario;
import repositorios.RepositorioDeIndicadores;
import repositorios.RepositorioDeResultados;
import repositorios.RepositorioDeUsuarios;

public class CalculadorDeIndicadores {
	
	public void calcular(Collection<Empresa> empresas, Periodo periodo) {
		Collection<Usuario> usuarios = RepositorioDeUsuarios.getInstance().buscarTodos();
		usuarios.stream().forEach(usuario -> aplicarIndicadores(empresas, periodo, usuario));
	}

	public void aplicarIndicadores(Collection<Empresa> empresas, Periodo periodo, Usuario usuario) {
		Collection<Indicador> indicadores = RepositorioDeIndicadores.getInstance().getIndicadores(usuario);
		for (Empresa empresa : empresas) {
			for (Indicador indicador : indicadores) {
				Resultado resultado = new Resultado();
				resultado.setEmpresa(empresa);
				resultado.setIndicador(indicador);
				resultado.setPeriodo(periodo);
				resultado.setValor(indicador.aplicar(empresa, periodo, usuario));
				RepositorioDeResultados.getInstance().registrarResultado(resultado);
			}	
		}
	}
}
