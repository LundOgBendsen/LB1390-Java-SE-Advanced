/*
 * Viser JTable.print()-metoden. Metoden findes i øvrigt i en række overloadede
 * versioner, der kan tage diverse parametre.
 */
package dk.lundogbendsen.javase8advanced.swing.ex05.complex.components;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.AbstractTableModel;

public class Demo06b_JTable
{

  public static void main(final String[] args)
  {

    // Et vindue med titel-linie
    final JFrame frame = new JFrame("JTable");
    frame.setLayout(new BorderLayout());

    final JTable table = new JTable(new MyTableModel(3, 30));
    JScrollPane scrollPane = new JScrollPane(table);
    frame.add(scrollPane, BorderLayout.CENTER);

    // *********************************************************************
    // * Vi tilføjer en knap til udskrivning af tabellen
    // *********************************************************************
    JButton printButton = new JButton("Print table");
    printButton.addActionListener(new ActionListener()
    {
      @Override
      public void actionPerformed(final ActionEvent event)
      {
        try
        {
          table.print();
        }
        catch (PrinterException e)
        {
          throw new RuntimeException(e);
        }
      }
    });
    frame.add(printButton, BorderLayout.SOUTH);

    // *********************************************************************

    // Lad vinduet give sig selv en passende størrelse.
    frame.pack();

    // Sørg for programmet afsluttes, når brugeren klikker luk-vindue.
    // Normalt vil vinduet bare forsvinde, men Swing-tråden køre videre.
    // Brug alternativt frame.addWindowListener(WindowListener listener).
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    // Gør vinduet synligt.
    frame.setVisible(true);

  }

  @SuppressWarnings("serial")
  private static class MyTableModel extends AbstractTableModel
  {
    private String[][] cells;

    private static Random r = new Random();

    // Constructor'en er irrelevant mht. at forstå TableModel
    MyTableModel(final int width, final int height)
    {
      if (width < 1 || height < 1)
      {
        String msg = "Width and height must be > 0";
        throw new IllegalArgumentException(msg);
      }
      // Fyld alle celler med tilfældige strings
      cells = new String[width][height];
      for (int x = 0; x < width; x++)
      {
        for (int y = 0; y < height; y++)
        {
          cells[x][y] = makeGibberish();
        }
      }
    }

    // Generer en tilfældig streng
    // Metodeen er irrelevant mht. at forstå TableModel
    private static String makeGibberish()
    {
      StringBuffer sb = new StringBuffer();
      while (true)
      {
        sb.append((char) (r.nextInt(122 - 97) + 97));
        if (Math.random() < 0.33)
        {
          break;
        }
      }
      return sb.toString();
    }

    @Override
    public int getColumnCount()
    {
      return cells.length;
    }

    @Override
    public int getRowCount()
    {
      return cells[0].length;
    }

    @Override
    public Object getValueAt(final int rowIndex, final int columnIndex)
    {
      return cells[columnIndex][rowIndex];
    }

    @Override
    public String getColumnName(final int col)
    {
      return "Kolonne " + col;
    }

    @Override
    public boolean isCellEditable(final int row, final int col)
    {
      return true;
    }

    @Override
    public void setValueAt(final Object value, final int row, final int col)
    {
      cells[col][row] = (String) value;
      System.out.println("Cell[" + col + "," + row + "] -> " + value);
    }
  }
}
