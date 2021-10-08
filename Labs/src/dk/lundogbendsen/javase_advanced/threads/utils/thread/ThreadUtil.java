/*
 * ThreadUtil er en hjælpeklasse, der kan bruges til at få bedre overblik over
 * tråde i Java. Klassen kan bruges til to forskellige ting:
 *
 *
 * (1) VISNING AF HVILKE TRÅDE DER UDSKRIVER HVAD PÅ SYSTEM.OUT OG SYSTEM.ERR:
 *
 * Metoden ThreadUtil.printThreadNames() ændrer System.out og System.err, så
 * metoderne print og println prepender navnet på tråden til det udskrevne.
 * Kalder fx en tråd med navnet "MyThread" metoden System.out.println("Hej"),
 * udskrives: "[MyThread] Hej".
 *
 * Se også demo-klassen: threadutil.demo1.WhichThreadIsPrintingWhat.
 *
 *
 * (2) VISNING AF TRÅDSITUATIONENS UDVIKLING I PROGRAMMET OVER TID:
 *
 * Metoden ThreadUtil.showInvestigator(), frembringer et grafisk vindue, hvor
 * man kan se hvordan tråd-situationen har været på alle de tidspunkter hvor
 * den tilhørende metode kaldet ThreadUtil.makeSnapShot( String snapShotName )
 * er blevet kaldt. Dvs. kald først showInvestigator, og herefter makeSnapShot
 * alle de steder i din kode, hvor du efterfølgende kunne tænke dig at vide
 * hvordan trådsituationen så ud.
 */
package dk.lundogbendsen.javase_advanced.threads.utils.thread;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.AbstractListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

@SuppressWarnings("deprecation")
public class ThreadUtil {
	static private boolean investigatorIsShowing = false;

	public static void printThreadNames() {
		System.setOut(new PrintStreamShowingThreadNames(System.out));
		System.setErr(new PrintStreamShowingThreadNames(System.err));
	}

	public static void showInvestigator() {
		if (investigatorIsShowing == false) {
			Investigator.show();
			investigatorIsShowing = true;
		}
	}

	public static void makeSnapshot(final String snapShotName) {
		if (investigatorIsShowing == true) {
			Investigator.makeSnapShot(snapShotName);
		} else {
			String msg = "Code must call ThreadUtil.showInvestigator( )";
			msg += ", before any calls to ThreadUtil.makeSnapshot";
			msg += "( String snapshotName ) can be made";
			throw new IllegalStateException(msg);
		}
	}

	static public ThreadGroup getRootThreadGroup() {
		Thread thread = Thread.currentThread();
		ThreadGroup group = thread.getThreadGroup();
		while (group.getParent() != null) {
			group = group.getParent();
		}
		return group;
	}

	static public Thread[] getCurrentThreads() {
		ThreadGroup root = getRootThreadGroup();
		int numberOfThreads = root.activeCount();
		Thread[] childThreads = new Thread[numberOfThreads];
		root.enumerate(childThreads, true);
		int notNullsInChildThreads = 0;
		for (int n = 0; n < childThreads.length; n++) {
			if (childThreads[n] != null) {
				notNullsInChildThreads++;
			}
		}
		Thread[] compactedArray = new Thread[notNullsInChildThreads];
		for (int n = 0; n < notNullsInChildThreads; n++) {
			compactedArray[n] = childThreads[n];
		}
		return compactedArray;
	}

	static public ThreadGroup[] getCurrentThreadGroups() {
		ThreadGroup root = getRootThreadGroup();
		// antal sub-grupper + 1 for root-gruppen selv
		int numberOfThreadGroups = root.activeGroupCount() + 1;
		ThreadGroup[] threadGroups = new ThreadGroup[numberOfThreadGroups];
		root.enumerate(threadGroups, true);
		for (int n = (threadGroups.length - 1); n > 0; n--) {
			threadGroups[n] = threadGroups[n - 1];
		}
		threadGroups[0] = root;
		int notNullsInThreadGroups = 0;
		for (int n = 0; n < threadGroups.length; n++) {
			if (threadGroups[n] != null) {
				notNullsInThreadGroups++;
			}
		}
		ThreadGroup[] compactedArray = new ThreadGroup[notNullsInThreadGroups];
		for (int n = 0; n < notNullsInThreadGroups; n++) {
			compactedArray[n] = threadGroups[n];
		}
		return compactedArray;
	}

	public static void main(final String[] args) {
		ThreadUtil.showInvestigator();
		new Thread("R-1") {
			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(1000);
					} catch (Exception e) {
					}
				}
			}
		}.start();
		ThreadUtil.makeSnapshot("Made thread R-1");
		ThreadGroup group = new ThreadGroup("R-2");
		ThreadUtil.makeSnapshot("Made group R-2");
		Thread t = new Thread(group, "R-3") {
			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(1000);
					} catch (Exception e) {
					}
				}
			}
		};
		t.start();
		ThreadUtil.makeSnapshot("Made thread R-3");
		Thread t2 = new Thread(group, "R-4") {
			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(1000);
					} catch (Exception e) {
					}
				}
			}
		};
		t2.setDaemon(true);
		t2.start();
		t2.setPriority(3);
		ThreadUtil.makeSnapshot("Made thread R-4");
		t2.setPriority(4);
		ThreadUtil.makeSnapshot("Set priority of R-4");
	}
}

class PrintStreamShowingThreadNames extends PrintStream {
	PrintStreamShowingThreadNames(final PrintStream printStream) {
		super(printStream);
	}

	@Override
	public void print(final String s) {
		String threadName = Thread.currentThread().getName();
		((PrintStream) out).print("[" + threadName + "] " + s);
		try {
			out.flush();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void print(final boolean value) {
		print("" + value);
	}

	@Override
	public void print(final char value) {
		print("" + value);
	}

	@Override
	public void print(final char[] value) {
		print(new String(value));
	}

	@Override
	public void print(final double value) {
		print("" + value);
	}

	@Override
	public void print(final float value) {
		print("" + value);
	}

	@Override
	public void print(final int value) {
		print("" + value);
	}

	@Override
	public void print(final long value) {
		print("" + value);
	}

	@Override
	public void print(final Object value) {
		print(value.toString());
	}

	@Override
	public void println(final String s) {
		print(s + "\n");
	}

	@Override
	public void println() {
		println("");
	}

	@Override
	public void println(final boolean value) {
		println("" + value);
	}

	@Override
	public void println(final char value) {
		println("" + value);
	}

	@Override
	public void println(final char[] value) {
		println(new String(value));
	}

	@Override
	public void println(final double value) {
		println("" + value);
	}

	@Override
	public void println(final float value) {
		println("" + value);
	}

	@Override
	public void println(final int value) {
		println("" + value);
	}

	@Override
	public void println(final long value) {
		println("" + value);
	}

	@Override
	public void println(final Object value) {
		println(value.toString());
	}
}

/*
 * Investigator is a simple Facade to the ThreadInvestigator, and furthermore
 * Investigator acts as single point of entry to the ThreadInvestigator, only
 * giving access to one Thread at a time
 */
class Investigator {
	synchronized static void makeSnapShot(final String snapShotName) {
		Model.getModel().makeSnapShot(snapShotName);
	}

	synchronized static void show() {
		View.getView();
	}
}

@SuppressWarnings("deprecation")
class Model extends Observable {
	// Implements Model as Singleton (design pattern)
	private static Model theModel;

	private Model() {
		makeSnapShot("Before User Interface");
	}

	public static Model getModel() {
		if (theModel == null) {
			theModel = new Model();
		}
		return theModel;
	}

	// Compose Model of ArrayList to keep track of Snapshots
	private ArrayList<Snapshot> snapshots = new ArrayList<>();

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
	void makeSnapShot(final String name) {
		if (name == null) {
			throw new IllegalArgumentException("null not allowed as name");
		} else if (name.trim().equals("")) {
			String msg = "empty String not allowed as name";
			throw new IllegalArgumentException(msg);
		}
		this.addSnapshot(new Snapshot(name));
	}

}

class Snapshot {
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

	@SuppressWarnings("removal")
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

class ThreadGroupNode implements TreeNode {

	private TreeNode parent;
	private TreeNode[] children;
	private String name;

	ThreadGroupNode(final ThreadGroup threadGroup) {
		// sæt nodens navn
		this.name = threadGroup.getName();
		// find de aktive undertråde
		int numberOfThreads = threadGroup.activeCount();
		Thread[] childThreads = new Thread[numberOfThreads];
		threadGroup.enumerate(childThreads, false);
		ArrayList<TreeNode> arrayList = new ArrayList<>();
		for (int n = 0; n < numberOfThreads; n++) {
			if (childThreads[n] != null) {
				ThreadNode tn = new ThreadNode(childThreads[n]);
				arrayList.add(tn);
				tn.parent = this;
			}
		}
		// find de aktive undergrupper
		int numberOfGroups = threadGroup.activeGroupCount();
		ThreadGroup[] childGroups = new ThreadGroup[numberOfGroups];
		threadGroup.enumerate(childGroups, false);
		for (int n = 0; n < numberOfGroups; n++) {
			if (childGroups[n] != null) {
				ThreadGroupNode tgn = new ThreadGroupNode(childGroups[n]);
				arrayList.add(tgn);
				tgn.parent = this;
			}
		}
		// kopier undergrupper og undertråde over i children-array
		children = new TreeNode[arrayList.size()];
		for (int n = 0; n < arrayList.size(); n++) {
			children[n] = arrayList.get(n);
		}
	}

	@Override
	public boolean getAllowsChildren() {
		return true;
	}

	@Override
	public TreeNode getChildAt(final int index) {
		return children[index];
	}

	@Override
	public int getChildCount() {
		return children.length;
	}

	@Override
	public TreeNode getParent() {
		return parent;
	}

	@Override
	public boolean isLeaf() {
		return false;
	} // children.length == 0; }

	@Override
	public String toString() {
		return this.name;
	}

	@Override
	public Enumeration<? extends TreeNode> children() {
		return new Enumeration<TreeNode>() {
			TreeNode[] children = this.children.clone();
			int pointer = -1;

			@Override
			public boolean hasMoreElements() {
				return pointer < children.length;
			}

			@Override
			public TreeNode nextElement() {
				return children[++pointer];
			}
		};
	}

	@Override
	public int getIndex(final TreeNode treeNode) {
		for (int n = 0; n < children.length; n++) {
			if (children[n] == treeNode) {
				return n;
			}
		}
		return -1;
	}
}

class ThreadNode implements TreeNode {

	TreeNode parent;
	String name;

	ThreadNode(final Thread thread) {
		// sæt nodens navn
		this.name = thread.getName();
	}

	@Override
	public String toString() {
		return this.name;
	}

	@Override
	public Enumeration<? extends TreeNode> children() {
		return new Enumeration<TreeNode>() {
			@Override
			public boolean hasMoreElements() {
				return false;
			}

			@Override
			public TreeNode nextElement() {
				return null;
			}
		};
	}

	@Override
	public boolean getAllowsChildren() {
		return false;
	}

	@Override
	public TreeNode getChildAt(final int index) {
		return null;
	}

	@Override
	public int getChildCount() {
		return 0;
	}

	@Override
	public int getIndex(final TreeNode treeNode) {
		return -1;
	}

	@Override
	public TreeNode getParent() {
		return parent;
	}

	@Override
	public boolean isLeaf() {
		return true;
	}
}

class CreatorIsDeadException extends Exception {
	private static final long serialVersionUID = 1L;

	CreatorIsDeadException(final String s) {
		super(s);
	}

	CreatorIsDeadException() {
		super();
	}
}

@SuppressWarnings("deprecation")
class View implements Observer {

	private Model model = Model.getModel();
	private Controller controller = Controller.getController();
	private String title = "Thread Investigator   © Rasmus Lund (rasmus@it.edu)";
	private JFrame frame = new JFrame(title);
	private JList<?> snapshotList;
	private SnapshotListModel snapshotListModel;
	private JTree threadTree = new JTree();
	private JTable threadInfoTable = new JTable();
	private JTable threadGroupInfoTable = new JTable();
	private Snapshot currentSnapshot;

	// Implements View as Singleton (design pattern)
	private static View theView;

	public static View getView() {
		if (theView == null) {
			theView = new View();
		}
		return theView;
	}

	private View() {
		// register this as listener on model
		model.addObserver(this);

		// prepare snapshot-list
		this.snapshotListModel = new SnapshotListModel();
		this.snapshotList = new JList<Object>(this.snapshotListModel);
		this.snapshotList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		// initialise start-up models for tree and tables
		Snapshot initialSnapshot = model.getSnapshot(0);
		this.setSelectedSnapshot(initialSnapshot);

		this.frame.setSize(800, 600);

		// put components on frame
		this.addComponentsToFrame();

		this.addListeners();

		this.frame.setVisible(true);
	}

	private void addListeners() {
		this.frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(final WindowEvent e) {
				controller.userIsClosingWindow();
			}
		});
		this.snapshotList.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(final ListSelectionEvent e) {
				int selectedIndex = snapshotList.getSelectedIndex();

				controller.userSelectedSnapshot(selectedIndex);
			}
		});

	}

	void setSelectedSnapshot(final Snapshot snapshot) {
		this.currentSnapshot = snapshot;
		this.threadTree.setModel(snapshot.getThreadTree());
		this.threadInfoTable.setModel(snapshot.getThreadInfoTable());
		this.threadGroupInfoTable.setModel(snapshot.getThreadGroupInfoTable());
		this.expandThreadTree();
	}

	private void addComponentsToFrame() {
		JScrollPane snapshotList = new JScrollPane(this.snapshotList);
		JScrollPane threadTree = new JScrollPane(this.threadTree);
		JScrollPane threadGroupInfoTable = new JScrollPane(this.threadGroupInfoTable);
		JScrollPane threadInfoTable = new JScrollPane(this.threadInfoTable);
		JSplitPane bottomRight = new JSplitPane(JSplitPane.VERTICAL_SPLIT, threadGroupInfoTable, threadInfoTable);
		JSplitPane right = new JSplitPane(JSplitPane.VERTICAL_SPLIT, threadTree, bottomRight);
		JSplitPane outer = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, snapshotList, right);
		outer.setDividerLocation(160);
		right.setDividerLocation(270);
		bottomRight.setDividerLocation(80);
		frame.setContentPane(outer);
		this.snapshotList.setSelectedIndex(0);
		Investigator.makeSnapShot("After User Interface");
	}

	// Implement View as Observer (design pattern)
	@Override
	public void update(final Observable o, final Object arg) {
		this.snapshotListModel.fireContentsChanged();
	}

	private void expandThreadTree() {
		TreeModel treeModel = currentSnapshot.getThreadTree();
		TreeNode root = (TreeNode) treeModel.getRoot();
		expandTreeNode(root);
	}

	private void expandTreeNode(final TreeNode treeNode) {
		if (treeNode instanceof ThreadGroupNode) {
			ThreadGroupNode node = (ThreadGroupNode) treeNode;
			threadTree.expandPath(findTreePath(node));
			for (int n = 0; n < node.getChildCount(); n++) {
				expandTreeNode(node.getChildAt(n));
			}
		}
	}

	private TreePath findTreePath(ThreadGroupNode node) {
		LinkedList<TreeNode> list = new LinkedList<>();
		list.addFirst(node);
		while (node.getParent() != null) {
			list.add(0, node.getParent());
			node = (ThreadGroupNode) node.getParent();
		}
		Object[] o = new Object[list.size()];
		for (int n = 0; n < list.size(); n++) {
			o[n] = list.get(n);
		}
		return new TreePath(o);
	}
}

class SnapshotListModel extends AbstractListModel<Object> {
	private static final long serialVersionUID = 1L;
	private Model model = Model.getModel();

	@Override
	public Object getElementAt(final int index) {
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

class Controller {

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
