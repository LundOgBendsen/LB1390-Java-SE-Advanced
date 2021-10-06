package dk.lundogbendsen.javase8advanced.threads.utils;

import java.util.ArrayList;
import java.util.Observable;

public class Model extends Observable {
	// Implements Model as Singleton (design pattern)
	private static Model theModel;

	private Model() {
		makeSnapshot("Before User Interface");
	}

	public static Model getModel() {
		if (theModel == null) {
			theModel = new Model();
		}
		return theModel;
	}

	// Compose Model of ArrayList to keep track of Snapshots
	private ArrayList<Snapshot> snapshots = new ArrayList<Snapshot>();

	private void addSnapshot(final Snapshot snapshot) {
		this.snapshots.add(snapshot);
		// notify observers of the change
		// (methods inherited from Observable)
		this.setChanged();
		this.notifyObservers();
	}

	Snapshot getSnapshot(final int index) {
		Object object = this.snapshots.get(index);
		Snapshot snapshot = (Snapshot) object;
		return snapshot;
	}

	int getNumberOfSnapshots() {
		return snapshots.size();
	}

	// Make creation of new Snapshots possible
	void makeSnapshot(final String name) {
		if (name == null) {
			throw new IllegalArgumentException("null not allowed as name");
		} else if (name.trim().equals("")) {
			throw new IllegalArgumentException("empty String not allowed as name");
		}
		this.addSnapshot(new Snapshot(name));
	}

}