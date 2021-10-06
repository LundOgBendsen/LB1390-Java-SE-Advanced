package dk.lundogbendsen.javase8advanced.swing.ex08.personlist;

/**
 * Se beskrivelse i klassen PersonRegister.
 */

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.AbstractAction;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class MainView extends View {

	public MainView() {
		menuBar = createMenuBar();
		desktopPane = createDesktopPane();
		frame = createFrame();
		show();
	}

	@Override
	public void update() {
		updateWindowTitle();
	}

	private void show() {
		update();
		frame.setVisible(true);
		desktopPane.revalidate();
	}

	private JDesktopPane createDesktopPane() {
		return new JDesktopPane();
	}

	private JFrame createFrame() {
		JFrame frame = new JFrame();
		frame.setJMenuBar(this.menuBar);
		frame.setLayout(new BorderLayout());
		frame.add(desktopPane, BorderLayout.CENTER);
		frame.setSize(new Dimension(600, 600));
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(final WindowEvent e) {
				System.exit(0);
			}
		});
		return frame;
	}

	private JMenuBar createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(createFileMenu());
		menuBar.add(createPersonsMenu());
		return menuBar;
	}

	private JMenu createFileMenu() {
		JMenu fileMenu = new JMenu("File");
		fileMenu.add(new AbstractAction("New register") {
			@Override
			public void actionPerformed(final ActionEvent ae) {
				getModel().clear();
			}
		});
		fileMenu.add(new AbstractAction("Load register ...") {
			@Override
			public void actionPerformed(final ActionEvent ae) {
				File userChoise = showLoadFileChooser();
				if (userChoise != null) {
					try {
						getModel().load(userChoise);
					} catch (Exception e) {
					}
				}
			}
		});
		fileMenu.add(new AbstractAction("Save register as ...") {
			@Override
			public void actionPerformed(final ActionEvent ae) {
				File userChoise = showSaveFileChooser();
				if (userChoise != null) {
					try {
						getModel().saveAs(userChoise);
					} catch (Exception e) {
					}
				}
			}
		});
		fileMenu.add(new AbstractAction("Exit program") {
			@Override
			public void actionPerformed(final ActionEvent ae) {
				System.exit(0);
			}
		});
		return fileMenu;
	}

	private JMenu createPersonsMenu() {
		JMenu personsMenu = new JMenu("Persons");
		personsMenu.add(new AbstractAction("Show all persons") {
			@Override
			public void actionPerformed(final ActionEvent ae) {
				new AllPersonsView(desktopPane);
			}
		});
		personsMenu.add(new AbstractAction("Create new person") {
			@Override
			public void actionPerformed(final ActionEvent ae) {
				new CreatePersonView(desktopPane);
			}
		});
		return personsMenu;
	}

	private void updateWindowTitle() {
		String title = "Register of Persons";
		if (!getModel().getCurrentFileName().equals("")) {
			title += " [" + getModel().getCurrentFileName() + "]";
		}
		frame.setTitle(title);
	}

	private File showLoadFileChooser() {
		JFileChooser fileChooser = new JFileChooser(".");
		int returnVal = fileChooser.showOpenDialog(frame);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			return fileChooser.getSelectedFile();
		} else {
			return null;
		}
	}

	private File showSaveFileChooser() {
		JFileChooser fileChooser = new JFileChooser(".");
		int returnVal = fileChooser.showSaveDialog(frame);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			return fileChooser.getSelectedFile();
		} else {
			return null;
		}
	}

	private JFrame frame;
	private JDesktopPane desktopPane;
	private JMenuBar menuBar;

}