package dk.lundogbendsen.javase8advanced.threads.utils;

import java.util.Enumeration;

import javax.swing.tree.TreeNode;

public class ThreadNode implements TreeNode {

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