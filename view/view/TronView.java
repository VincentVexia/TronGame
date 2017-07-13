package view;

import java.util.Observable;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import controller.IOrderPerformer;
import gameframe.GameFrame;
import model.ITronModel;

public class TronView implements ITronView, Runnable {
	private final GraphicsBuilder	graphicsBuilder;
	private final EventPerformer	eventPerformer;
	private final Observable			observable;
	private GameFrame							gameFrame;

	public TronView(final IOrderPerformer orderPerformer, final ITronModel tronModel, final Observable observable) {
		this.observable = observable;
		this.graphicsBuilder = new GraphicsBuilder(tronModel);
		this.eventPerformer = new EventPerformer(orderPerformer);
		SwingUtilities.invokeLater(this);
	}

	public void run() {
		this.gameFrame = new GameFrame("Tron", this.eventPerformer, this.graphicsBuilder, this.observable);
	}

	public void displayMessage(final String message) {
		JOptionPane.showMessageDialog(null, message);
	}

	public void closeAll() {
		this.gameFrame.dispose();
	}
}
