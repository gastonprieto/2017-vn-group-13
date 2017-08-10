package exception;

public class EmpresaException  extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public EmpresaException(String message) {
		super(message);
	}
}
