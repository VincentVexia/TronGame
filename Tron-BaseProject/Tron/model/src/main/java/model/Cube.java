package model;

public class Cube extends Mobile {
	private static int		SPEED									= 4;
	private static int		WIDTH									= 16;
	private static int		HEIGHT								= 16;
	private static int		MAX_DISTANCE_TRAVELED	= 1400;
	private static String	IMAGE									= "cube";

	private int						distanceTraveled			= 0;

	public Cube(final Direction direction, final Position position) {
		super(direction, position, new Dimension(WIDTH, HEIGHT), SPEED, IMAGE);
	}

	public static int getWidthWithADirection(final Direction direction) {
		switch (direction) {
			case UP:
			case DOWN:
				return HEIGHT;
			case RIGHT:
			case LEFT:
			default:
				return WIDTH;
		}
	}

	public static int getHeightWithADirection(final Direction direction) {
		switch (direction) {
			case UP:
			case DOWN:
				return WIDTH;
			case RIGHT:
			case LEFT:
			default:
				return HEIGHT;
		}
	}

	@Override
	public void move() {
		this.distanceTraveled += SPEED;
		if (this.distanceTraveled >= MAX_DISTANCE_TRAVELED) {
			this.getTronModel().removeMobile(this);
		}
		super.move();
	}

	@Override
	public boolean isWeapon() {
		return true;
	}

}
