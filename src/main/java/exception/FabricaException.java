package exception;

/**
 * Created by rapap on 03/09/2017.
 */
public class FabricaException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public FabricaException(String message) {
        super(message);
    }
}
