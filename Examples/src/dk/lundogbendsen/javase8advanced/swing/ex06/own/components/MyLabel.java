package dk.lundogbendsen.javase8advanced.swing.ex06.own.components;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.font.FontRenderContext;
import java.awt.font.LineMetrics;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;

import javax.swing.JPanel;

// En JavaBean-Swing-komponent skal være:
// - Serializable
// - Være en subtype af JComponent (og det er JPanel)
@SuppressWarnings("unused")
public class MyLabel extends JPanel implements Serializable {
	private String text;

	private int fontSize;

	private Font font;

	public MyLabel() {
		this("");
	}

	public MyLabel(final String text) {
		setText(text);
		setFontSize(20);
		this.setVisible(true);
	}

	public String getText() {
		return text;
	}

	public void setText(final String text) {
		this.text = text;
	}

	public int getFontSize() {
		return fontSize;
	}

	public void setFontSize(final int fontSize) {
		this.fontSize = fontSize;
	}

	// kaldes når komponenten skal optegne sig selv
	@Override
	protected void paintComponent(final Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		// slå anti alialiasing til
		g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

		// gør fonten bold og størrelse til det brugeren har valgt
		Font font = g2d.getFont();
		String name = font.getFontName();
		font = new Font(name, Font.BOLD, getFontSize());
		g2d.setFont(font);

		// Find ud af hvor vi kan tegne (træk en evt. ramme fra)
		Insets insets = getInsets();
		int currentWidth = getWidth() - insets.left - insets.right;
		int currentHeight = getHeight() - insets.top - insets.bottom;
		int xMin = insets.left;
		int xMax = insets.left + currentWidth;
		int yMin = insets.top;
		int yMax = insets.top + currentHeight;

		// Måling af hvor meget teksten vil fylde
		FontRenderContext frc = g2d.getFontRenderContext();
		Rectangle2D bounds = font.getStringBounds(getText(), frc);
		LineMetrics metrics = font.getLineMetrics(getText(), frc);
		float width = (float) bounds.getWidth(); // bredden på teksten
		float lineheight = metrics.getHeight(); // den totale højde på teksten

		// Skriv label-teksten
		g2d.drawString(getText(), xMin + 5, yMin + lineheight);

		// Man skal enten selv stille g2d's tilstand tilbage
		// til dens tilstand ved metodestarten ELLER kalde
		// disponse() på g2d (den smides ud og en ny laves);
		g2d.dispose();
	}

	// Det er en god idé at override getMinimumSize, getPreferredSize og
	// getMaximumSize, men det er ikke gjort her!!!

}
