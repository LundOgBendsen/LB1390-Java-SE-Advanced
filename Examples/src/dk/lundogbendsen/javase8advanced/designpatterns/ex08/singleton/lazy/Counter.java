package dk.lundogbendsen.javase8advanced.designpatterns.ex08.singleton.lazy;

public class Counter {
	// ***** SINGLETON PATTERN CODE *****

	// prevent other from instantiating the class
	private Counter() {
	}

	// keep reference to the singleton-instance
	private static Counter singleton;

	// enable clients to get a hold on the singleton
	public static Counter getSingleton() {
		// lazily instantiate singleton if it hasn't been created already
		if (Counter.singleton == null) {
			Counter.singleton = new Counter();
		}
		return Counter.singleton;
	}

	// ***** ORDINARY CODE *****
	private int count;

	public void increment() {
		count++;
	}

	public int getCurrentCount() {
		return count;
	}
}