package exception;

public class GameException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2048416760537782547L;

	public GameException() {
		super();
	}

	public GameException(String message) {
		super(message);
	}

	public void print() {
		if (this.getMessage() == null) {
			System.out.println("A " + this.getClass().toString() + " occured with no message");
		} else {
			System.out.println(this.getClass().toString() + ": " + this.getMessage());
		}
	}

}
