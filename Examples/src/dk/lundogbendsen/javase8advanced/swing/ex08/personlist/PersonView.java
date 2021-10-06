package dk.lundogbendsen.javase8advanced.swing.ex08.personlist;

/**
 * Se beskrivelse i klassen PersonRegister.
 */

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PersonView extends View {
	// show existing person
	public PersonView(final JDesktopPane parentPane, final Person person) {
		this.person = person;
		this.parentPane = parentPane;
		this.frame = createFrame();
		this.frame.setSize(new Dimension(200, 200));
		this.frame.setVisible(true);
	}

	// create new person
	public PersonView(final JDesktopPane parentPane) {
		this.person = null;
		this.parentPane = parentPane;
		this.frame = createFrame();
		this.frame.setVisible(true);
	}

	private JInternalFrame createFrame() {
		String frameTitle = "";
		if (person == null) {
			frameTitle = "Create new person";
		} else {
			frameTitle = "Edit person";
		}
		// JInternalFrame(title, resizable, closable, maximizable)
		JInternalFrame frame = new JInternalFrame(frameTitle, true, true, true);
		parentPane.add(frame);

		JPanel textFieldPanel = new JPanel();
		textFieldPanel.setLayout(new GridLayout(3, 1));
		JPanel labelPanel = new JPanel();
		labelPanel.setLayout(new GridLayout(3, 1));
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(1, 2));

		labelPanel.add(new JLabel("Id"));
		textFieldPanel.add(idTextField);
		labelPanel.add(new JLabel("Full name"));
		textFieldPanel.add(fullNameTextField);
		labelPanel.add(new JLabel("Birth year"));
		textFieldPanel.add(birthYearTextField);
		buttonPanel.add(cancelButton);
		buttonPanel.add(okButton);

		frame.setLayout(new BorderLayout());
		frame.add(labelPanel, BorderLayout.WEST);
		frame.add(textFieldPanel, BorderLayout.CENTER);
		frame.add(buttonPanel, BorderLayout.SOUTH);

		update();

		return frame;
	}

	@Override
	public void update() {
		if (this.person != null) {
			this.idTextField.setText(person.getId() + "");
			this.idTextField.setEditable(false);
			this.fullNameTextField.setText(person.getFullName());
			this.fullNameTextField.setEditable(true);
			this.birthYearTextField.setText(person.getBirthYear() + "");
			this.birthYearTextField.setEditable(false);
			this.okButton.setEnabled(true);
			this.cancelButton.setEnabled(true);
			this.okButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(final ActionEvent ae) {
					int id = person.getId();
					String fullName = fullNameTextField.getText();
					getModel().setFullNameOfPerson(id, fullName);
					killFrame();
				}
			});
			this.cancelButton.addActionListener(ae -> killFrame());
		} else {
			final Person person = new Person("Ib", 1999);
			this.idTextField.setText(person.getId() + "");
			this.idTextField.setEditable(false);
			this.fullNameTextField.setText(person.getFullName());
			this.fullNameTextField.setEditable(true);
			this.birthYearTextField.setText(person.getBirthYear() + "");
			this.birthYearTextField.setEditable(false);
			this.okButton.setEnabled(true);
			this.cancelButton.setEnabled(true);
			this.okButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(final ActionEvent ae) {
					int id = person.getId();
					String fullName = fullNameTextField.getText();
					getModel().setFullNameOfPerson(id, fullName);
					killFrame();
				}
			});
			this.cancelButton.addActionListener(ae -> killFrame());
			/*
			 * this.idTextField.setText( "???" ); this.idTextField.setEditable( false );
			 * this.fullNameTextField.setText( "" ); this.fullNameTextField.setEditable(
			 * true ); this.birthYearTextField.setText( "" );
			 * this.birthYearTextField.setEditable( true ); this.okButton.setEnabled( false
			 * ); this.cancelButton.setEnabled( true ); KeyListener keyListener = new
			 * KeyAdapter(){ public void keyTyped(KeyEvent e){ String fullName =
			 * fullNameTextField.getText( ); String birthYearAsString =
			 * birthYearTextField.getText( ); try{ int birthYear = Integer.parseInt(
			 * birthYearAsString ); if( getModel( ).isValidPerson( fullName, birthYear )){
			 * okButton.setEnabled( true ); } else{ okButton.setEnabled( false ); } } catch(
			 * NumberFormatException ex ){ okButton.setEnabled( false ); } } };
			 *
			 * this.fullNameTextField.addKeyListener( keyListener );
			 * this.birthYearTextField.addKeyListener( keyListener );
			 *
			 * this.okButton.addActionListener( new ActionListener(){ public void
			 * actionPerformed(ActionEvent ae){ String fullName = fullNameTextField.getText(
			 * ); String birthYearAsString = birthYearTextField.getText( ); try{ int
			 * birthYear = Integer.parseInt( birthYearAsString ); getModel( ).createPerson(
			 * fullName, birthYear ); } catch( NumberFormatException ex ){ // Should never
			 * happen } killFrame(); } } ); this.cancelButton.addActionListener( new
			 * ActionListener(){ public void actionPerformed(ActionEvent ae){ killFrame(); }
			 * } );
			 */
		}
	}

	private void killFrame() {
		frame.dispose();
	}

	// private
	private final Person person;
	private JInternalFrame frame;
	private JDesktopPane parentPane;
	private JTextField idTextField = new JTextField();
	private JTextField fullNameTextField = new JTextField();
	private JTextField birthYearTextField = new JTextField();
	private JButton cancelButton = new JButton("Cancel");
	private JButton okButton = new JButton("OK");
}
