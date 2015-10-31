package exceptions;

public class CommandFormatException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 359247206532070035L;

	@Override
	public String getMessage() {
		return "Error en formato de comando";
	}

}
