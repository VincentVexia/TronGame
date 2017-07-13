package model;

// TODO: Auto-generated Javadoc
/**
 * The Class Cube.
 */
public class Cube extends Mobile {
	
	/** The speed. */
	private static int		SPEED									= 0;
	
	/** The width. */
	private static int		WIDTH									= 16;
	
	/** The height. */
	private static int		HEIGHT								= 16;
		
	/** The image. */
	private static String	IMAGE									= "cube";


	/**
	 * Instantiates a new cube.
	 *
	 * @param direction the direction
	 * @param position the position
	 */
	public Cube(final Direction direction, final Position position) {
		super(direction, position, new Dimension(WIDTH, HEIGHT), SPEED, IMAGE);
	}

	/**
	 * Gets the width with A direction.
	 *
	 * @param direction the direction
	 * @return the width with A direction
	 */
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

	/**
	 * Gets the height with A direction.
	 *
	 * @param direction the direction
	 * @return the height with A direction
	 */
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


	/* (non-Javadoc)
	 * @see model.Mobile#isWeapon()
	 */
	@Override
	public boolean isWeapon() {
		return true;
	}

}
