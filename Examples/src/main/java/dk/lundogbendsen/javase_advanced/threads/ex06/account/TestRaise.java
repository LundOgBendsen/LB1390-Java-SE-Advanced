package dk.lundogbendsen.javase_advanced.threads.ex06.account;

public class TestRaise {
	public static void main(final String[] args) {
		// We create an Account object that by default has DKK 500 in the account (see Account
		// the class)
		Account account = new Account();
		RaceCondition t1 = new RaceCondition(account, 100, "Hæv med 100-tråden");
		RaceCondition t2 = new RaceCondition(account, 200, "Hæv med 200-tråden");
		t1.start();
		t2.start();
	}
}
