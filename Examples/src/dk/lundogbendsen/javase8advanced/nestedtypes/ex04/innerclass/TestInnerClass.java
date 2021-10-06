package dk.lundogbendsen.javase8advanced.nestedtypes.ex04.innerclass;

public class TestInnerClass {

	public static void main(final String[] args) {
		Account account01 = new Account(1);
		Account account02 = new Account(2);

		Account.Action action01 = account01.withdraw(1200);
		Account.Action action02 = account02.deposit(1300);

		System.out.print("action01.getAccount() == account01 giver: ");
		System.out.println(action01.getAccount() == account01);

		System.out.print("action01.getAccount() == account02 giver: ");
		System.out.println(action01.getAccount() == account02);

		System.out.print("action02.getAccount() == account01 giver: ");
		System.out.println(action02.getAccount() == account01);

		System.out.print("action02.getAccount() == account02 giver: ");
		System.out.println(action02.getAccount() == account02);
	}
}