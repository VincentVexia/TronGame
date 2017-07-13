package gameframe;

import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

class GamePanel extends JPanel implements Observer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final IGraphicsBuilder	graphicsBuilder;

	public GamePanel(final IGraphicsBuilder graphicsBuilder) {
		this.graphicsBuilder = graphicsBuilder;
	}

	public void update(final Observable arg0, final Object arg1) {
		this.repaint();
	}

	protected void paintComponent(final Graphics graphics) {
		this.graphicsBuilder.applyModelToGraphic(graphics, this);
	}

}
