package model;

public class Cuenta {
	private String name;
	private Double value;
	private Periodo periodo;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Double getValue() {
		return value;
	}
	
	public void setValue(Double value) {
		this.value = value;
	}

	public Periodo getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		/*if (!Cuenta.class.isAssignableFrom(obj.getClass())) {
			return false;
		}*/

		final Cuenta cuentaAComparar = (Cuenta) obj;

		if (!this.name.equals(cuentaAComparar.name))
			return false;	
		
		if (!this.value.equals(cuentaAComparar.value))
			return false;	
		
		if (!this.periodo.equals(cuentaAComparar.periodo))
			return false;				

		return true;
	}

	@Override
	public int hashCode() {
		int hash = 3;
		hash = 53 * hash + (this.name != null ? this.name.hashCode() : 0);		
		return hash;
	}
}
