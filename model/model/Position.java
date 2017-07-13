package model;

// TODO: Auto-generated Javadoc
/**
 * The Class Position.
 */
public class Position {
	
	/** The x. */
	private int	x;
	
	/** The y. */
	private int	y;
	
	/** The max X. */
	private int	maxX	= 1;
	
	/** The max Y. */
	private int	maxY	= 1;

	/**
	 * Instantiates a new position.
	 *
	 * @param x the x
	 * @param y the y
	 */
	public Position(final int x, final int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Instantiates a new position.
	 *
	 * @param position the position
	 */
	public Position(final Position position) {
		this(position.getX(), position.getY());
	}

	/**
	 * Gets the x.
	 *
	 * @return the x
	 */
	public int getX() {
		return this.x;
	}

	/**
	 * Sets the x.
	 *
	 * @param x the new x
	 */
	public void setX(final int x) {
		this.x = (x + this.maxX) % this.maxX;
	}

	/**
	 * Gets the y.
	 *
	 * @return the y
	 */
	public int getY() {
		return this.y;
	}

	/**
	 * Sets the y.
	 *
	 * @param y the new y
	 */
	public void setY(final int y) {
		this.y = (y + this.maxY) % this.maxY;
	}

	/**
	 * Sets the max X.
	 *
	 * @param maxX the new max X
	 */
	protected void setMaxX(final int maxX) {
		this.maxX = maxX;
	}

	/**
	 * Sets the max Y.
	 *
	 * @param maxY the new max Y
	 */
	protected void setMaxY(final int maxY) {
		this.maxY = maxY;
	}
}
