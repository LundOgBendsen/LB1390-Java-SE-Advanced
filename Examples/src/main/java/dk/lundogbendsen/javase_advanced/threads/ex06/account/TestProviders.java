package dk.lundogbendsen.javase_advanced.threads.ex06.account;

public class TestProviders {
	public static void main(String[] args) {
		// We create an Account object that by default has DKK 500 in the account (see Account
		// the class)
		Account account = new Account();
		AccountProvider t1 = new AccountProvider(account, 100, "AccountProvider-tråden");
		AccountConsumer t2 = new AccountConsumer(account, 500, "AccountConsumer-tråden");
		t1.start();
		t2.start();
	}
}
