package dk.lundogbendsen.javase_advanced.threads.utils;

import javax.swing.AbstractListModel;

public class SnapshotListModel extends AbstractListModel<String> {
	private static final long serialVersionUID = 1L;
	private Model model = Model.getModel();

	@Override
	public String getElementAt(final int index) {
		return model.getSnapshot(index).getName();
	}

	@Override
	public int getSize() {
		return model.getNumberOfSnapshots();
	}

	void fireContentsChanged() {
		int lastIndex = model.getNumberOfSnapshots() - 1;
		this.fireContentsChanged(this, lastIndex, lastIndex);
	}
}