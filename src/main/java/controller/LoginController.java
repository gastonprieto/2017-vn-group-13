package controller;

import java.util.HashMap;
import java.util.Map;

import model.Usuario;
import repositorios.RepositorioDeUsuarios;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class LoginController {
	
	public static ModelAndView getLogInPage(Request req, Response res) {
		return new ModelAndView(null, "login.hbs");
	}
	
	public static ModelAndView logIn(Request req, Response res) {
		Map<String, Object> model = new HashMap<>();
		Usuario usuario = RepositorioDeUsuarios.getInstance().buscarUsuario(req.queryParams("username"));
		if(usuario != null && usuario.passwordMatches(req.queryParams("password"))) {
			req.session().attribute("user", usuario);
			res.redirect("/");
			return null;
		}
		model.put("loginFailed", true);
		return new ModelAndView(model, "login.hbs");
	}
	
    public static void verificarUsuarioLoggeado(Request req, Response res) {
        if(!req.pathInfo().equals("/login") && req.session().attribute("user") == null) {
            res.redirect("/login");
        }
    }
    
    public static ModelAndView logOut(Request req, Response res) {
    	req.session().removeAttribute("user");
    	res.redirect("/login");
    	return null;
    }
}
