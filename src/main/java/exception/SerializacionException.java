package exception;

/**
 * Created by rapap on 08/09/2017.
 */
public class SerializacionException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public SerializacionException(String message) {
        super(message);
    }

    public SerializacionException(String nombre, String clase) {
        super("La condicion '" + nombre + "' es del subtipo '" + clase + "' No se puedo serializar");
    }
}