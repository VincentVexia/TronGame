package view;

import java.util.Observable;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import controller.IOrderPerformer;
import gameframe.GameFrame;
import model.ITronModel;

// TODO: Auto-generated Javadoc
/**
 * The Class TronView.
 */
public class TronView implements ITronView, Runnable {
	
	/** The graphics builder. */
	private final GraphicsBuilder	graphicsBuilder;
	
	/** The event performer. */
	private final EventPerformer	eventPerformer;
	
	/** The observable. */
	private final Observable			observable;
	
	/** The game frame. */
	private GameFrame							gameFrame;

	/**
	 * Instantiates a new tron view.
	 *
	 * @param orderPerformer the order performer
	 * @param tronModel the tron model
	 * @param observable the observable
	 */
	public TronView(final IOrderPerformer orderPerformer, final ITronModel tronModel, final Observable observable) {
		this.observable = observable;
		this.graphicsBuilder = new GraphicsBuilder(tronModel);
		this.eventPerformer = new EventPerformer(orderPerformer);
		SwingUtilities.invokeLater(this);
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		this.gameFrame = new GameFrame("Tron", this.eventPerformer, this.graphicsBuilder, this.observable);
	}

	/* (non-Javadoc)
	 * @see view.ITronView#displayMessage(java.lang.String)
	 */
	public void displayMessage(final String message) {
		JOptionPane.showMessageDialog(null, message);
	}

	/* (non-Javadoc)
	 * @see view.ITronView#closeAll()
	 */
	public void closeAll() {
		this.gameFrame.dispose();
	}
}
