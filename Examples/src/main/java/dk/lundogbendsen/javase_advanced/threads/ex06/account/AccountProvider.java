package dk.lundogbendsen.javase_advanced.threads.ex06.account;

public class AccountProvider extends Thread {
	private Account account;
	private int amount;

	public AccountProvider(Account account, int amount, String name) {
		super(name);
		this.account = account;
		this.amount = amount;
	}

	@Override
	public void run() {
		// This thread adds money to the account
		while (true) {
			// for (int i = 0; i < 5; i++) {//Try to change the while so that it only adds something to the account 5 times.
			System.out.println(getName() + " forsøger at få fat i account objektets lås");
			// We synchronize on account object and ensure that the code in it can only be run by one thread at a time!
			synchronized (account) {
				System.out.println(getName() + ": NOW HAS THE LOCK");
				int saldo = account.getSaldo();
				System.out.println(getName() + ": Læser saldo, der er " + saldo + " kr.");
				System.out.println(getName() + ": Tilføjer " + amount + " til kontoen");
				account.setSaldo(saldo + amount);
				System.out.println(getName() + ": Saldo er nu " + account.getSaldo() + " kr.");
				account.notifyAll();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
				}
			}
			// }
		}
	}
}
