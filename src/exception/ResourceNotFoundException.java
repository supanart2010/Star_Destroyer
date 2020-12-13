package exception;

public class ResourceNotFoundException extends Exception{
	public ResourceNotFoundException() {
		super("Resources not found.");
	}
}
