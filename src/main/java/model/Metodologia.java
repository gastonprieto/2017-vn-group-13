package model;

public class Metodologia {

    public String nombre;
    public Condicion condicion;

    public Metodologia(String _nombre, Condicion _condicion){
        this.nombre = _nombre;
        this.condicion = _condicion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Condicion getCondicion() {
        return condicion;
    }

    public void setCondicion(Condicion condicion) {
        this.condicion = condicion;
    }


}
