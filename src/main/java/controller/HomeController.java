package controller;

import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class HomeController {
	
	public static ModelAndView home(Request req, Response res) {
		return new ModelAndView(null, "Home.hbs");
	}
	
	public static ModelAndView success(Request req, Response res) {
		Map<String, Boolean> model = new HashMap<>();
		model.put("success", true);
		return new ModelAndView(model, "Home.hbs");
	}
	
	public static ModelAndView error(Request req, Response res) {
		Map<String, Boolean> model = new HashMap<>();
		model.put("error", true);
		return new ModelAndView(model, "Home.hbs");
	}
}
