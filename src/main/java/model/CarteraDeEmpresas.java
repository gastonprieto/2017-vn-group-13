package model;

import java.util.List;

public class CarteraDeEmpresas {
	private static CarteraDeEmpresas cartera;
	private List<Empresa> empresas;
	
	public static CarteraDeEmpresas getCartera() {
		return CarteraDeEmpresas.cartera;
	}
	
	public static void setCartera(CarteraDeEmpresas cartera) {
		CarteraDeEmpresas.cartera = cartera;
	}
	
	public List<Empresa> getEmpresas() {
		return empresas;
	}

	public  void setEmpresas(List<Empresa> empresas) {
		this.empresas = empresas;
	}
}
