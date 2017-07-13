import controller.TronController;
import model.Dimension;
import model.Direction;
import model.TronModel;
import model.Lightcircle;
import model.Position;
import view.TronView;

public abstract class Trongame {

	public static void main(final String[] args) {
		final TronModel tronModel = new TronModel();

		tronModel.buildArea(new Dimension(600, 400));
		tronModel.addMobile(new Lightcircle(0, Direction.RIGHT, new Position(10, 60), "BlueLightcircle"));
		tronModel.addMobile(new Lightcircle(1, Direction.LEFT, new Position(10, 330), "RedLightcircle"));

		final TronController tronController = new TronController(tronModel);
		final TronView tronView = new TronView(tronController, tronModel, tronModel);
		tronController.setViewSystem(tronView);
		tronController.play();
	}

}
