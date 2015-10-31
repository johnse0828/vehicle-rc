package exceptions;

public class InvalidCoordsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7622126727384148597L;

	@Override
	public String getMessage() {
		return "Se ha detenido el avance por salir de los límites";
	}
	
}
