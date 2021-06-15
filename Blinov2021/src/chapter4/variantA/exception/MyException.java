package chapter4.variantA.exception;

/**
 * Class that realizes exceptions for this chapter.
 * 
 * @author јхтырский ёрий
 *
 */

public class MyException extends Throwable {

	private static final long serialVersionUID = -9033481122496722040L;
	
	public MyException() {
		super();
	}
	
	public MyException(String message) {
		super(message);
	}
	
	public MyException(String message, Throwable cause) {
		super(message, cause);
	}

}
