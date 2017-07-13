package model;

// TODO: Auto-generated Javadoc
/**
 * The Class Lightcircle.
 */
public class Lightcircle extends Mobile {
	
	/** The speed. */
	private static int	SPEED		= 2;
	
	/** The width. */
	private static int	WIDTH		= 16;
	
	/** The height. */
	private static int	HEIGHT	= 16;

	/** The player. */
	private final int		player;

	/**
	 * Instantiates a new lightcircle.
	 *
	 * @param player the player
	 * @param direction the direction
	 * @param position the position
	 * @param image the image
	 */
	public Lightcircle(final int player, final Direction direction, final Position position, final String image) {
		super(direction, position, new Dimension(WIDTH, HEIGHT), SPEED, image);
		this.player = player;
	}

	/* (non-Javadoc)
	 * @see model.Mobile#isPlayer(int)
	 */
	@Override
	public boolean isPlayer(final int player) {
		return this.player == player;
	}

	/* (non-Javadoc)
	 * @see model.Mobile#hit()
	 */
	@Override
	public boolean hit() {
		this.getTronModel().removeMobile(this);
		return true;
	}
}
