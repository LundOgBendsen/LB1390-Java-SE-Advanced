package dk.lundogbendsen.javase8advanced.threads.utils;

import java.lang.ref.WeakReference;
import java.util.Date;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;

public class Snapshot {
	private String name;

	private Date timeStamp;

	private WeakReference<Thread> madeBy;

	private TreeModel threadTree;

	private TableModel threadInfoTable;

	private TableModel threadGroupInfoTable;

	Snapshot(final String name) {
		this.name = name;
		this.timeStamp = new Date(); // now!
		Thread maker = Thread.currentThread();
		this.madeBy = new WeakReference<Thread>(maker);
		this.threadTree = createTreeModel();
		this.threadInfoTable = createThreadInfoTableModel();
		this.threadGroupInfoTable = createThreadGroupInfoTableModel();
	}

	// accessor-methods
	String getName() {
		return this.name;
	}

	Date getTimeStamp() {
		return this.timeStamp;
	}

	Thread getMadeBy() throws CreatorIsDeadException {
		if (madeBy.get() == null) {
			String msg = "Creating thread has been Garbage Collected";
			throw new CreatorIsDeadException(msg);
		} else {
			return madeBy.get();
		}
	}

	TreeModel getThreadTree() {
		return this.threadTree;
	}

	TableModel getThreadInfoTable() {
		return this.threadInfoTable;
	}

	TableModel getThreadGroupInfoTable() {
		return this.threadGroupInfoTable;
	}

	// helper methods
	private TreeModel createTreeModel() {
		ThreadGroup rootThreadGroup = ThreadUtil.getRootThreadGroup();
		ThreadGroupNode rootNode = new ThreadGroupNode(rootThreadGroup);
		return new DefaultTreeModel(rootNode);
	}

	private TableModel createThreadInfoTableModel() {
		String[] tableTitles = new String[] { "Threads", "priority", "is alive", "is daemon", "is interrupted" };
		Thread[] currentThreads = ThreadUtil.getCurrentThreads();

		// [ row index ][ column index ]
		String[][] tableData = new String[currentThreads.length][tableTitles.length];
		for (int n = 0; n < currentThreads.length; n++) {
			tableData[n][0] = currentThreads[n].getName();
			tableData[n][1] = currentThreads[n].getPriority() + "";
			tableData[n][2] = currentThreads[n].isAlive() + "";
			tableData[n][3] = currentThreads[n].isDaemon() + "";
			tableData[n][4] = currentThreads[n].isInterrupted() + "";
		}

		TableModel tableModel = new DefaultTableModel(tableData, tableTitles);
		return tableModel;
	}

	private TableModel createThreadGroupInfoTableModel() {
		String[] tableTitles = new String[] { "ThreadGroups", "max priority", "is daemon", };
		ThreadGroup[] currentGroups = ThreadUtil.getCurrentThreadGroups();

		// [ row index ][ column index ]
		String[][] tableData = new String[currentGroups.length][tableTitles.length];
		for (int n = 0; n < currentGroups.length; n++) {
			tableData[n][0] = currentGroups[n].getName();
			tableData[n][1] = currentGroups[n].getMaxPriority() + "";
			tableData[n][2] = currentGroups[n].isDaemon() + "";
		}

		TableModel tableModel = new DefaultTableModel(tableData, tableTitles);
		return tableModel;
	}
}