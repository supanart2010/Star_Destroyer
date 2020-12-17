package exception;

import application.SceneManager;

public class SceneChangingException extends GameException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9107197163021617917L;

	protected SceneManager.State prev;
	protected SceneManager.State next;

	public SceneChangingException() {
		super();
		this.prev = null;
		this.next = null;
	}

	public SceneChangingException(String message) {
		super(message);
		this.prev = null;
		this.next = null;
	}

	public SceneChangingException(SceneManager.State prev, SceneManager.State next) {
		super();
		this.prev = prev;
		this.next = next;
	}

	public SceneChangingException(String message, SceneManager.State prev, SceneManager.State next) {
		super(message);
		this.prev = prev;
		this.next = next;
	}

	@Override
	public void print() {
		if (prev == null || next == null) {
			super.print();
		} else {
			if (this.getMessage() == null) {
				System.out.println("A " + this.getClass().toString() + " occurred during changing from " + this.prev
						+ " to " + this.next);
			} else {
				System.out.println("A " + this.getClass().toString() + " occurred during changing from " + this.prev
						+ " to " + this.next + ": " + this.getMessage());
			}
		}
	}

}
