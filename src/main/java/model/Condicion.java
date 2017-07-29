package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Stream;

import com.ibm.icu.util.Calendar;

public interface  Condicion {

	public  void setName(String name);
	public  String getName();
	public Indicador getIndicador();

	public Stream<Empresa> aplicar(Stream<Empresa> streamEmpresas);
}
