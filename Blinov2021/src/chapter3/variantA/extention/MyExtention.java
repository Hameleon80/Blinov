package chapter3.variantA.extention;

/**
 * Class that realizes exceptions for this chapter.
 * 
 * @author јхтырский ёрий
 *
 */

public class MyExtention extends Throwable {

	private static final long serialVersionUID = -9033481122496722040L;
	
	public MyExtention() {
		super();
	}
	
	public MyExtention(String message) {
		super(message);
	}
	
	public MyExtention(String message, Throwable cause) {
		super(message, cause);
	}

}
