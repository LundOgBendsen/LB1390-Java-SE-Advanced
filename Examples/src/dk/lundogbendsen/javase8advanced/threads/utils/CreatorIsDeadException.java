package dk.lundogbendsen.javase8advanced.threads.utils;

public class CreatorIsDeadException extends Exception {
	CreatorIsDeadException(final String s) {
		super(s);
	}

	CreatorIsDeadException() {
		super();
	}
}