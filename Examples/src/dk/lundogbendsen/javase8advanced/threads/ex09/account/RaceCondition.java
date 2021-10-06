package dk.lundogbendsen.javase8advanced.threads.ex09.account;

public class RaceCondition extends Thread {

	private Account konto;
	private int addAmount;

	public RaceCondition(final Account konto, final int addAmount, final String name) {
		super(name);
		this.konto = konto;
		this.addAmount = addAmount;
	}

	@Override
	public void run() {
		// Hvis ikke vi synkroniserer på konto objektet, så kan der opstå en
		// race-condition (inkonsistens)
		// synchronized (konto) {
		int saldo = konto.getSaldo();
		System.out.println(this.getName() + ": Læser saldo, der er " + saldo + " kr.");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(this.getName() + ": Tilføjer " + addAmount + " kr. til saldoen");
		konto.setSaldo(saldo + addAmount);
		System.out.println(this.getName() + ": Saldo er nu " + konto.getSaldo() + " kr.");

		// }
	}
}
