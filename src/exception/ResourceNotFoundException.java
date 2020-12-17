package exception;

public class ResourceNotFoundException extends GameException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5261600905049703426L;
	private String resource;

	public ResourceNotFoundException() {
		super();
		resource = null;
	}

	public ResourceNotFoundException(String resource) {
		super();
		this.resource = resource;
	}

	public ResourceNotFoundException(String resource, String message) {
		super(message);
		this.resource = resource;
	}

	public void print() {
		if (resource == null) {
			super.print();
		} else {
			if (this.getMessage() == null) {
				System.out.println("A " + this.getClass().toString() + " occurred during loading " + this.resource);
			} else {
				System.out.println("A " + this.getClass().toString() + " occurred during loading " + this.resource
						+ ": " + this.getMessage());
			}
		}
	}
}
