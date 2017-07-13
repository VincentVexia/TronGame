package controller;

import java.io.IOException;
import java.util.ArrayList;

import model.Cube;
import model.Direction;
import model.IMobile;
import model.ITronModel;
import model.Position;
import view.ITronView;

public class TronController implements IOrderPerformer {
	private static int						TIME_SLEEP	= 30;
	private final ITronModel	tronModel;
	private boolean								isGameOver	= false;
	private ITronView						viewSystem;
	
	public TronController(final ITronModel tronModel) {
		this.tronModel = tronModel;
	}

	public void orderPerform(final IUserOrder userOrder) {
		if (userOrder != null) {
			final IMobile lightcircle = this.tronModel.getMobileByPlayer(userOrder.getPlayer());
			if (lightcircle != null) {
				Direction direction;
				switch (userOrder.getOrder()) {
					case UP:
						direction = Direction.UP;
						break;
					case RIGHT:
						direction = Direction.RIGHT;
						break;
					case DOWN:
						direction = Direction.DOWN;
						break;
					case LEFT:
						direction = Direction.LEFT;
						break;
					case SHOOT:
						try {
							this.lauchMissile(userOrder.getPlayer());
						} catch (final IOException e) {
							e.printStackTrace();
						}
					case NOP:
					default:
						direction = this.tronModel.getMobileByPlayer(userOrder.getPlayer()).getDirection();
						break;
				}
				lightcircle.setDirection(direction);
			}
		}
	}

//	private void buildAllimages(final String imageName) throws IOException {
//		this.images = new Image[1];
//		this.images = ImageIO.read("images/" + imageName + ".png");
//	
	private void lauchMissile(final int player) throws IOException {
		final IMobile lightcircle = this.tronModel.getMobileByPlayer(player);
		if (lightcircle != null) {
			final Position position = new Position(lightcircle.getPosition().getX() + ((lightcircle.getWidth() - Cube.getWidthWithADirection(lightcircle.getDirection())) / 2),
					lightcircle.getPosition().getY() + ((lightcircle.getHeight() - Cube.getHeightWithADirection(lightcircle.getDirection())) / 2));
			this.tronModel.addMobile(new Cube(lightcircle.getDirection(), position));
//			Position(lightcircle.getPosition().getX() + ((lightcircle.getWidth() - Cube.getWidthWithADirection(lightcircle.getDirection())) / 2),
//					lightcircle.getPosition().getY() + ((lightcircle.getHeight() - Cube.getHeightWithADirection(lightcircle.getDirection())) / 2)) = "cube";
			switch (lightcircle.getDirection()) {
			
				case UP:
					position.setY(position.getY() - lightcircle.getHeight() - lightcircle.getSpeed());
					break;
				case RIGHT:
					position.setX(position.getX() + lightcircle.getWidth() + lightcircle.getSpeed());
					break;
				case DOWN:
					position.setY(position.getY() + lightcircle.getHeight() + lightcircle.getSpeed());
					break;
				case LEFT:
					position.setX(position.getX() - lightcircle.getWidth() - lightcircle.getSpeed());
					break;
				default:
					break;
			}
		}
	}

	private boolean isWeaponOnMobile(final IMobile mobile, final IMobile weapon) {
		if (((weapon.getPosition().getX() / weapon.getWidth()) >= (mobile.getPosition().getX() / weapon.getWidth()))
				&& ((weapon.getPosition().getX() / weapon.getWidth()) <= ((mobile.getPosition().getX() + mobile.getWidth()) / weapon.getWidth()))) {
			if (((weapon.getPosition().getY() / weapon.getHeight()) >= (mobile.getPosition().getY() / weapon.getHeight()))
					&& ((weapon.getPosition().getY() / weapon.getHeight()) <= ((mobile.getPosition().getY() + mobile.getHeight()) / weapon.getHeight()))) {
				return true;
			}
		}
		return false;
	}

	private void manageCollision(final IMobile weapon) {
		final ArrayList<IMobile> target = new ArrayList<IMobile>();
		boolean isTargetHit = false;

		for (final IMobile mobile : this.tronModel.getMobiles()) {
			if (this.isWeaponOnMobile(mobile, weapon)) {
				target.add(mobile);
			}
		}
		for (final IMobile mobile : target) {
			isTargetHit = isTargetHit || mobile.hit();
		}
		if (isTargetHit) {
			this.tronModel.removeMobile(weapon);
			this.isGameOver = true;
		}
	}

	public void play() {
		this.gameLoop();
		this.viewSystem.displayMessage("Game Over !");
		this.viewSystem.closeAll();
	}

	private void gameLoop() {
		while (!this.isGameOver) {
			try {
				Thread.sleep(TIME_SLEEP);
			} catch (final InterruptedException ex) {
				Thread.currentThread().interrupt();
			}

			final ArrayList<IMobile> initialMobiles = new ArrayList<IMobile>();
			for (final IMobile mobile : this.tronModel.getMobiles()) {
				initialMobiles.add(mobile);
			}
			for (final IMobile mobile : initialMobiles) {
				mobile.move();
				if (mobile.isWeapon()) {
					this.manageCollision(mobile);
				}
			}
			this.tronModel.setMobilesHavesMoved();
		}
	}

	public void setViewSystem(final ITronView viewSystem) {
		this.viewSystem = viewSystem;
	}
}
