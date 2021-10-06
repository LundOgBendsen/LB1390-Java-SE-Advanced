package dk.lundogbendsen.javase8advanced.threads.ex09.account;

public class AccountConsumer extends Thread {
	private Account account;
	private int amount;

	public AccountConsumer(final Account account, final int amount, final String name) {
		super(name);
		this.account = account;
		this.amount = amount;
	}

	@Override
	public void run() {
		// Denne tråd hæver penge på kontoen
		while (true) {
			System.out.println(getName() + " forsøger at få fat i account objektets lås");
			// Vi synkroniserer account objektet og sikrer, at koden i den synkroniserede
			// blok kun kan køres af en tråd!
			synchronized (account) {
				System.out.println(getName() + ": HAR NU LÅSEN");
				int saldo = account.getSaldo();
				if (saldo >= amount) {
					System.out.println(getName() + ": Læser saldo, der er " + saldo + " kr.");
					System.out.println(getName() + ": Hæver " + amount + " på kontoen");
					account.setSaldo(saldo - amount);
					System.out.println(getName() + ": Saldo er nu " + account.getSaldo() + " kr.");
					account.notifyAll();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} else {
					try {
						System.out.println(
								getName() + ": Saldoen er mindre end " + amount + " kr., så jeg kalder account.wait()");
						account.wait();
					} catch (InterruptedException e) {
					}
				}
			}
		}
	}
}
