package dk.lundogbendsen.javase8advanced.threads.utils;

import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.tree.TreeNode;

public class ThreadGroupNode implements TreeNode
{

  private TreeNode parent;

  private TreeNode[] children;

  private String name;

  ThreadGroupNode(final ThreadGroup threadGroup)
  {
    // sæt nodens navn
    this.name = threadGroup.getName();
    // find de aktive undertråde
    int numberOfThreads = threadGroup.activeCount();
    Thread[] childThreads = new Thread[numberOfThreads];
    threadGroup.enumerate(childThreads, false);
    ArrayList<TreeNode> arrayList = new ArrayList<TreeNode>();
    for (int n = 0; n < numberOfThreads; n++)
    {
      if (childThreads[n] != null)
      {
        ThreadNode tn = new ThreadNode(childThreads[n]);
        arrayList.add(tn);
        tn.parent = this;
      }
    }
    // find de aktive undergrupper
    int numberOfGroups = threadGroup.activeGroupCount();
    ThreadGroup[] childGroups = new ThreadGroup[numberOfGroups];
    threadGroup.enumerate(childGroups, false);
    for (int n = 0; n < numberOfGroups; n++)
    {
      if (childGroups[n] != null)
      {
        ThreadGroupNode tgn = new ThreadGroupNode(childGroups[n]);
        arrayList.add(tgn);
        tgn.parent = this;
      }
    }
    // kopier undergrupper og undertråde over i children-array
    children = new TreeNode[arrayList.size()];
    for (int n = 0; n < arrayList.size(); n++)
    {
      children[n] = arrayList.get(n);
    }
  }

  @Override
  public boolean getAllowsChildren()
  {
    return true;
  }

  @Override
  public TreeNode getChildAt(final int index)
  {
    return children[index];
  }

  @Override
  public int getChildCount()
  {
    return children.length;
  }

  @Override
  public TreeNode getParent()
  {
    return parent;
  }

  @Override
  public boolean isLeaf()
  {
    return false;
  } // children.length == 0; }

  @Override
  public String toString()
  {
    return this.name;
  }

  @Override
  public Enumeration<?> children()
  {
    return new Enumeration<Object>()
    {
      TreeNode[] children = this.children.clone();

      int pointer = -1;

      @Override
      public boolean hasMoreElements()
      {
        return pointer < children.length;
      }

      @Override
      public Object nextElement()
      {
        return children[++pointer];
      }
    };
  }

  @Override
  public int getIndex(final TreeNode treeNode)
  {
    for (int n = 0; n < children.length; n++)
    {
      if (children[n] == treeNode) { return n; }
    }
    return -1;
  }
}