package model;

public class Periodo {
	private Integer year;
	private Integer semester;
	
	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getSemester() {
		return semester;
	}

	public void setSemester(Integer semester) {
		this.semester = semester;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		/*if (!Periodo.class.isAssignableFrom(obj.getClass())) {
			return false;
		}*/

		final Periodo periodoAComparar = (Periodo) obj;

		if (!this.year.equals(periodoAComparar.year))
			return false;	
		
		if (!this.semester.equals(periodoAComparar.semester))
			return false;	
								
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 3;
		hash = 53 * hash + (this.year != null ? this.year.hashCode() : 0);		
		return hash;
	}
}
