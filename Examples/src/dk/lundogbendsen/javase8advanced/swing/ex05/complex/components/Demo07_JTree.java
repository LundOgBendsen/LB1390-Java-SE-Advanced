package dk.lundogbendsen.javase8advanced.swing.ex05.complex.components;

import java.awt.BorderLayout;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.WindowConstants;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

public class Demo07_JTree
{

  public static final String ROOT_PATH = ".";

  public static void main(final String[] args) throws Exception
  {
    // Et vindue med titel-linie
    final JFrame frame = new JFrame("JTable");
    frame.setLayout(new BorderLayout());

    // /////////////////////////////////////////////////////////////////

    // Angiver den mappe, som vi vil vise indholdet af
    File rootFile = new File(ROOT_PATH).getCanonicalFile();

    // Et JTree består af TreeNodes, som tilsammen giver et træ, idet hver
    // node kan have én eller flere child-noder.
    TreeNode rootNode = new FileTreeNode(rootFile);

    // Den TreeNode, der er roden i træet, skal "pakkes ind" i en TreeModel
    // Vi fortæller i øvrigt denne TreeModel, at den kan afgøre om en given
    // node er et blad (dvs. en node uden children) ved at den kalder
    // metoden getAllowsChildren på noden. En node der ikke kan have børn
    // vil den betragte som et blad (og derfor vise med et papir-ikon
    // fremfor med et mappe-ikon).
    TreeModel treeModel = new DefaultTreeModel(rootNode, true);

    // JTree står for at lave den visuelle repræsentation af træet.
    JTree tree = new JTree(treeModel);

    // Vi siger til vores JTree, at brugeren max må kunne selecte én af
    // noderne i træet af gangen
    tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);

    // Vi pakker vores tree ind i et scrollpane og placerer det på framen
    JScrollPane scrollPane = new JScrollPane(tree);
    frame.add(scrollPane, BorderLayout.CENTER);

    // Vi tilføjer en lytter på vores JTree. Lytteren kaldes hver gang
    // brugeren selecter en node i træet
    tree.addTreeSelectionListener(new TreeSelectionListener()
    {
      @Override
      public void valueChanged(final TreeSelectionEvent e)
      {
        String s = "";
        // Her får vi fat i den sti af noder, som leder ned til netop
        // den node, som brugeren selectede
        TreePath pathToSelectedNode = e.getPath();
        for (int n = 0; n < pathToSelectedNode.getPathCount(); n++)
        {
          s += "\\";
          s += pathToSelectedNode.getPathComponent(n);
        }
        System.out.println(s);
      }
    });

    // /////////////////////////////////////////////////////////////////

    // Lad vinduet give sig selv en passende størrelse.
    frame.setSize(250, 400);

    // Sørg for programmet afsluttes, når brugeren klikker luk-vindue.
    // Normalt vil vinduet bare forsvinde, men Swing-tråden køre videre.
    // Brug alternativt frame.addWindowListener(WindowListener listener).
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    // Gør vinduet synligt.
    frame.setVisible(true);
  }
}

class FileTreeNode extends DefaultMutableTreeNode
{

  // Hver instans er en visuel repræsentation af en fil. Da den visuelle
  // repræsentation af filen af og skal vide noget om filen (fx dens navn), er
  // det fint at gemme en reference til filen
  private File file;

  public FileTreeNode(final File file)
  {
    this.file = file;

    // Da vi skal have opbygget et træ af FileTreeNode'er, der passer til
    // træet af mapper og filer, er det vigtigt at en mappe sørger for, også
    // at få lavet en ny FileTreeNode for hver undermappe eller fil der
    // ligger i den selv.
    if (this.file.isDirectory())
    {
      File[] children = file.listFiles();
      for (int i = 0; i < children.length; i++)
      {
        this.add(new FileTreeNode(children[i]));
      }
    }
  }

  // Skal fortælle, om denne node kan have børn (og det kan kun
  // FileTreeNode'er, der repræsenterer mapper).
  @Override
  public boolean getAllowsChildren()
  {
    return this.file.isDirectory();
  }

  // Bruges af JTree til at finde ud af, hvad der skal stå på den node, der
  // vises i JTree'et.
  @Override
  public String toString()
  {
    return this.file.getName(); // bruges som label
  }
}