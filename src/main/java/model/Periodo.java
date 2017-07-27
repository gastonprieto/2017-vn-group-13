package model;

import com.ibm.icu.util.Calendar;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;

//import java.sql.Date;
import javax.rmi.CORBA.Tie;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import java.time.format.DateTimeFormatter;

public class Periodo {
	private Integer year;
	private Integer semester;
	
	public Periodo() {}
	
	public Periodo(Integer year, Integer semester) {
		this.year = year;
		this.semester = semester;
	}

	public Periodo(int CantidadDePeriodos){

	}
	
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

		if (!Periodo.class.isAssignableFrom(obj.getClass())) {
			return false;
		}

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

	public boolean SiguienteSemestre(){
		if(this.semester == 1){
			this.semester = 2;
		}else {
			this.semester = 1;
			this.year =+ 1;
		}
		return EsYearActual();
	}

	public boolean EsYearActual(){
		Date TiempoActual = new Date();
		return this.year == TiempoActual.getYear();
	}


	public Collection<Periodo> ConvertYearToPeriodos(int cantidad) {
		Collection<Periodo> periodos = new ArrayList<>();
		int year = Calendar.getInstance().get(Calendar.YEAR);
		int semester = (Calendar.getInstance().get(Calendar.MONTH) / 6) + 1;
		for(int i = 0; i < cantidad; i ++) {
			if(semester == 1) {
				semester ++;
				year --;
			} else {
				semester --;
			}
			periodos.add(new Periodo(year, semester));
		}
		return periodos;
	}
}
