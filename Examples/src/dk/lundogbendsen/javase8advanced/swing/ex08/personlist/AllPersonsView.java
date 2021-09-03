package dk.lundogbendsen.javase8advanced.swing.ex08.personlist;

/**
 * Se beskrivelse i klassen PersonRegister.
 */

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.AbstractTableModel;

public class AllPersonsView extends View
{

  public AllPersonsView(final JDesktopPane parentPane)
  {
    this.parentPane = parentPane;
    this.tableModel = createTableModel();
    this.table = createTable();
    this.frame = createFrame();
    this.frame.setVisible(true);
  }

  @Override
  public void update()
  {
    this.tableModel.fireTableDataChanged();
  }

  private JTable createTable()
  {
    JTable table = new JTable(tableModel);
    table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    return table;
  }

  private AbstractTableModel createTableModel()
  {
    return new AbstractTableModel()
    {
      @Override
      public int getColumnCount()
      {
        return 3;
      }

      @Override
      public String getColumnName(final int col)
      {
        if (col == 0)
        {
          return "Id";
        }
        else
          if (col == 1)
          {
            return "Full name";
          }
          else
          {
            return "Birth year";
          }
      }

      @Override
      public int getRowCount()
      {
        return Model.getAllPersons().size();
      }

      @Override
      public Object getValueAt(final int row, final int col)
      {
        Person person = Model.getPersonWithId(row);
        if (col == 0)
        {
          return "" + person.getId();
        }
        else
          if (col == 1)
          {
            return person.getFullName();
          }
          else
          {
            return "" + person.getBirthYear();
          }
      }

      @Override
      public boolean isCellEditable(final int row, final int col)
      {
        if (col == 1)
        {
          return true;
        }
        else
        {
          return false;
        }
      }

      @Override
      public void setValueAt(final Object value, final int row, final int col)
      {
        if (col == 1)
        {
          String newFullName = (String) value;
          if (!newFullName.equals(""))
          {
            // row matcher person-id da de begge er fortløbende startende fra 0
            getModel().setFullNameOfPerson(row, newFullName);
          }
        }
      }
    };
  }

  private JInternalFrame createFrame()
  {
    // JInternalFrame(title, resizable, closable, maximizable)
    JInternalFrame frame = new JInternalFrame("Persons", true, true, true);
    frame.setSize(new Dimension(200, 200));
    parentPane.add(frame);
    frame.setLayout(new BorderLayout());
    JScrollPane scrollPane = new JScrollPane(table);
    frame.add(scrollPane, BorderLayout.CENTER);
    return frame;
  }

  private JInternalFrame frame;
  private AbstractTableModel tableModel;
  private JTable table;
  private JDesktopPane parentPane;
}