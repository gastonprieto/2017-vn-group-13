package controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import model.Metodologia;
import repositorios.RepositorioDeEmpresas;
import repositorios.RepositorioDeMetodologias;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class MetodologiasController {
	public ModelAndView evaluar(Request req, Response res) {
		Map<String, Object> model = new HashMap<>();
		model.put("metodologias", RepositorioDeMetodologias.getInstance().getMetodologias());
		String nombre = req.params("nombre");
		Metodologia metodologiaAEvaluar = RepositorioDeMetodologias.getInstance().getMetodologias().stream()
											.filter(e -> e.getNombre().equals(nombre)).findFirst().get();
		model.put("empresas", metodologiaAEvaluar.evaluar(RepositorioDeEmpresas.getInstance().getEmpresas()));
		return new ModelAndView(model, "AplicarMetodologias.hbs");
	}
	
	public ModelAndView aplicar(Request req, Response res) {
		Map<String, Collection<Metodologia>> model = new HashMap<>();		
		model.put("metodologias", RepositorioDeMetodologias.getInstance().getMetodologias());		
		return new ModelAndView(model, "AplicarMetodologias.hbs");
	}
}
