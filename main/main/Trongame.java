package main;

import controller.TronController;
import model.Dimension;
import model.Direction;
import model.TronModel;
import model.Lightcircle;
import model.Position;
import view.TronView;

// TODO: Auto-generated Javadoc
/**
 * The Class Trongame.
 */
public abstract class Trongame {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(final String[] args) {
		final TronModel tronModel = new TronModel();

		tronModel.buildArea(new Dimension(600, 400));
		tronModel.addMobile(new Lightcircle(0, Direction.RIGHT, new Position(30, 200), "BlueLightcircle"));
		tronModel.addMobile(new Lightcircle(1, Direction.LEFT, new Position(550, 200), "RedLightcircle"));

		final TronController tronController = new TronController(tronModel);
		final TronView tronView = new TronView(tronController, tronModel, tronModel);
		tronController.setViewSystem(tronView);
		tronController.play();
	}

}
/