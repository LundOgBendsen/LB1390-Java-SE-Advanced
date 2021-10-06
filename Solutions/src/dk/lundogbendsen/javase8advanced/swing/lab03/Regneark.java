package dk.lundogbendsen.javase8advanced.swing.lab03;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

/*
 * Løsningen demonstrerer at det vigtigste element, når tabeller tilføjes,
 * egentlig er en implementation af en table model. Det er i denne alt arbejdet ligger.
 * Læg mærke til at implementationen af en tabel model indeholder værdierne i tabellen.
 * JTable klassens ansvar er hovedsageligt visningen af tabellen og værdierne table modellen.
 */
public class Regneark
{

  public static void main(final String[] args)
  {
    JFrame frame = new JFrame("Regneark");

    JTable table = new JTable(new RegneArkModel());

    frame.add(table);

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
  }

  static class RegneArkModel extends AbstractTableModel
  {
		private static final long serialVersionUID = 1L;
    private String[][] fields = new String[4][4];

    public RegneArkModel()
    {
      for (String[] row : fields)
      {
        for (int i = 0; i < row.length; i++)
        {
          // row[i] = "";
        }
      }
    }

    @Override
    public boolean isCellEditable(final int rowIndex, final int columnIndex)
    {
      return rowIndex < 3;
    }

    @Override
    public int getColumnCount()
    {
      return fields[0].length;
    }

    @Override
    public int getRowCount()
    {
      return fields.length;
    }

    @Override
    public Object getValueAt(final int rowIndex, final int columnIndex)
    {
      return fields[rowIndex][columnIndex];
    }

    @Override
    public void setValueAt(final Object value, final int rowIndex, final int columnIndex)
    {
      fields[rowIndex][columnIndex] = value.toString();

      int sum = 0;
      for (int i = 0; i < fields.length - 1; i++)
      {
        try
        {
          sum += Integer.parseInt(fields[i][columnIndex]);
        }
        catch (NumberFormatException e)
        {
          // do nothing. vi ignorerer bare felter og undlader at
          // inkluderer det i summen
        }
      }

      fields[fields.length - 1][columnIndex] = Integer.toString(sum);
      // fireTableDataChanged skal kaldes for at tabellen opdaterer
      // sig selv på skærmen.
      // Hvis metoden ikke kaldes vil den ændrede sum ikke blive vist.
      fireTableDataChanged();
    }
  }
}
