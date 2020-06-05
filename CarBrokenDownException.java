package Alpha;

public class CarBrokenDownException extends Exception {
    
	private static final long serialVersionUID = 1L;
	private static String message;

	public CarBrokenDownException(String message) {
    	 super(message);
     }
}
