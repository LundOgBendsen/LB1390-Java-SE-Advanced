package dk.lundogbendsen.javase_advanced.threads.utils;

public class CreatorIsDeadException extends Exception {
	private static final long serialVersionUID = 1L;

	CreatorIsDeadException(final String s) {
		super(s);
	}

	CreatorIsDeadException() {
		super();
	}
}