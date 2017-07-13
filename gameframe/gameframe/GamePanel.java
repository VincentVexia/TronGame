package gameframe;

import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

// TODO: Auto-generated Javadoc
/**
 * The Class GamePanel.
 */
class GamePanel extends JPanel implements Observer {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The graphics builder. */
	private final IGraphicsBuilder	graphicsBuilder;

	/**
	 * Instantiates a new game panel.
	 *
	 * @param graphicsBuilder the graphics builder
	 */
	public GamePanel(final IGraphicsBuilder graphicsBuilder) {
		this.graphicsBuilder = graphicsBuilder;
	}

	/* (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	public void update(final Observable arg0, final Object arg1) {
		this.repaint();
	}

	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	protected void paintComponent(final Graphics graphics) {
		this.graphicsBuilder.applyModelToGraphic(graphics, this);
	}

}
