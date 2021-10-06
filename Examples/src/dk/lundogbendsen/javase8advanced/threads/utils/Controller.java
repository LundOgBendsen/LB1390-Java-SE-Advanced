package dk.lundogbendsen.javase8advanced.threads.utils;

public class Controller {

	// Implements Controller as Singleton (design pattern)
	private static Controller theController;

	public static Controller getController() {
		if (theController == null) {
			theController = new Controller();
		}
		return theController;
	}

	private Controller() {
	}

	void userIsClosingWindow() {
		System.exit(1);
	}

	void userSelectedSnapshot(final int index) {
		Model model = Model.getModel();
		View view = View.getView();
		Snapshot snapshot = model.getSnapshot(index);
		view.setSelectedSnapshot(snapshot);
	}
}
/** **************************************************************** */
// CONTROLLER ENDS HERE (part of Investigator)
/** **************************************************************** */