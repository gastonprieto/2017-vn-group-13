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

	public Integer getYear() {
		return periodo.getYear();
	}

	public void setYear(Integer year) {
		periodo.setYear(year);
	}

	public Integer getSemester() {
		return periodo.getSemester();
	}

	public void setSemester(Integer semester) {
		periodo.setSemester(semester);
	}
}
