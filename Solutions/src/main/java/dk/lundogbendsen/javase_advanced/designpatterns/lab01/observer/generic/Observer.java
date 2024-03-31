package dk.lundogbendsen.javase_advanced.designpatterns.lab01.observer.generic;

public class Observer implements ListObserver {

	private String message;

	public Observer(final String message) {
		super();
		this.message = message;
	}

	@Override
	public void notifyListChanged() {
		System.out.println(message);
	}

}
