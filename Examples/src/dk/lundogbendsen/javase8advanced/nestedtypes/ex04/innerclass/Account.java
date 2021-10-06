package dk.lundogbendsen.javase8advanced.nestedtypes.ex04.innerclass;

import java.util.ArrayList;

public class Account {
	private long id;

	public long getId() {
		return id;
	}

	private long balance;

	public long getBalance() {
		return balance;
	}

	private ArrayList<Action> actions = new ArrayList<>();

	public Account(int id) {
		this.id = id;
	}

	public class Action {
		private long amount;

		public long getAmount() {
			return amount;
		}

		public Action(long amount) {
			Account.this.actions.add(Action.this);
			Action.this.amount = amount;
			// Eller evt. bare:
			// this.amount = amount;
		}

		public Account getAccount() {
			return Account.this;
		}
	}

	public Action deposit(long amount) {
		Account.this.balance += amount;
		return Account.this.new Action(amount);
	}

	public Action withdraw(long amount) {
		Account.this.balance -= amount;
		return Account.this.new Action(-amount);
	}
}