package exception;

/**
 * Created by rapap on 04/09/2017.
 */
public class CondicionException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public CondicionException(String message) {
        super(message);
    }

    public CondicionException(String nombre, String clase, String parametro) {
        super("La condicion '" + nombre + "' es del subtipo '" + clase + "' al cual no tiene el atributo '" + parametro +"'");
    }
}