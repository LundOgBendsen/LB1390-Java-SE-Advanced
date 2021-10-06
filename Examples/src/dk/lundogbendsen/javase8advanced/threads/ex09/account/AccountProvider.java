package dk.lundogbendsen.javase8advanced.threads.ex09.account;

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
		// Denne tråd lægger penge på kontoen
		while (true) {
			// for (int i = 0; i < 5; i++) {//Forsøg at lave while om, så den kun lægger
			// noget på kontoen 5 gange.
			System.out.println(getName() + " forsøger at få fat i account objektets lås");
			// Vi synkroniserer account objektet og sikrer, at koden i den synkroniserede
			// blok kun kan køres af en tråd!
			synchronized (account) {
				System.out.println(getName() + ": HAR NU LÅSEN");
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
		}
	}
}
