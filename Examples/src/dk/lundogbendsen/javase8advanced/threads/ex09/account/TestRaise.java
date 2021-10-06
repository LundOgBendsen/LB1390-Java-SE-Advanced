package dk.lundogbendsen.javase8advanced.threads.ex09.account;

public class TestRaise {
	public static void main(final String[] args) {
		// Vi opretter et Account objekt, der default har 500 kr. på kontoen (se Account
		// klassen)
		Account account = new Account();
		RaceCondition t1 = new RaceCondition(account, 100, "Hæv med 100-tråden");
		RaceCondition t2 = new RaceCondition(account, 200, "Hæv med 200-tråden");
		t1.start();
		t2.start();
	}
}
