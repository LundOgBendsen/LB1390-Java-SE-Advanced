package dk.lundogbendsen.javase_advanced.threads.utils;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

@SuppressWarnings("deprecation")
public class View implements Observer {

	private Model model = Model.getModel();

	private Controller controller = Controller.getController();

	private String title = "Thread Investigator";

	private JFrame frame = new JFrame(title);

	private JList<String> snapshotList;

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
		this.snapshotList = new JList<String>(this.snapshotListModel);
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
		Investigator.makeSnapshot("After User Interface");
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
		LinkedList<TreeNode> list = new LinkedList<TreeNode>();
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