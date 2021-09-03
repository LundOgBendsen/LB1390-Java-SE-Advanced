package dk.lundogbendsen.javase8advanced.swing.ex08.personlist;

/**
 * Se beskrivelse i klassen PersonRegister.
 */

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CreatePersonView extends View
{

  public CreatePersonView(final JDesktopPane parentPane)
  {
    this.parentPane = parentPane;
    this.frame = createFrame();
    this.frame.pack();
    this.frame.setVisible(true);
  }

  private JInternalFrame createFrame()
  {
    String frameTitle = "New person";
    // JInternalFrame(title, resizable, closable, maximizable)
    JInternalFrame frame = new JInternalFrame(frameTitle, true, true, true);
    parentPane.add(frame);

    JPanel labelPanel = new JPanel();
    labelPanel.setLayout(new GridLayout(2, 1));
    labelPanel.add(new JLabel("Full name"));
    labelPanel.add(new JLabel("Birth year"));

    JPanel textFieldPanel = new JPanel();
    textFieldPanel.setLayout(new GridLayout(2, 1));
    textFieldPanel.add(fullNameTextField);
    textFieldPanel.add(birthYearTextField);

    JPanel buttonPanel = new JPanel();
    buttonPanel.setLayout(new GridLayout(1, 2));
    buttonPanel.add(cancelButton);
    buttonPanel.add(okButton);

    frame.setLayout(new BorderLayout());
    frame.add(labelPanel, BorderLayout.WEST);
    frame.add(textFieldPanel, BorderLayout.CENTER);
    frame.add(buttonPanel, BorderLayout.SOUTH);

    okButton.setEnabled(false);

    KeyListener keyListener = new KeyAdapter()
    {
      @Override
      public void keyReleased(final KeyEvent e)
      {
        String fullName = fullNameTextField.getText();
        String birthYearAsString = birthYearTextField.getText();
        try
        {
          int birthYear = Integer.parseInt(birthYearAsString);
          if (getModel().isValidPerson(fullName, birthYear))
          {
            okButton.setEnabled(true);
          }
          else
          {
            okButton.setEnabled(false);
          }
        }
        catch (NumberFormatException ex)
        {
          okButton.setEnabled(false);
        }
      }
    };

    this.fullNameTextField.addKeyListener(keyListener);
    this.birthYearTextField.addKeyListener(keyListener);

    this.okButton.addActionListener(ae ->
    {
      createPerson();
      killFrame();
    });
    this.cancelButton.addActionListener(ae -> killFrame());

    frame.setVisible(true);

    update();

    return frame;
  }

  private void createPerson()
  {
    String fullName = fullNameTextField.getText();
    String birthYearAsString = birthYearTextField.getText();
    try
    {
      int birthYear = Integer.parseInt(birthYearAsString);
      getModel().createPerson(fullName, birthYear);
    }
    catch (NumberFormatException ex)
    {
      // Should never happen
    }
  }

  @Override
  public void update()
  {

  }

  private void killFrame()
  {
    frame.dispose();
  }

  private JInternalFrame frame;

  private JDesktopPane parentPane;

  private JTextField fullNameTextField = new JTextField();

  private JTextField birthYearTextField = new JTextField();

  private JButton cancelButton = new JButton("Cancel");

  private JButton okButton = new JButton("OK");
}