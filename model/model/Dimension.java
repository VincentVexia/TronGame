package model;

// TODO: Auto-generated Javadoc
/**
 * The Class Dimension.
 */
public class Dimension {
	
	/** The width. */
	private int	width;
	
	/** The height. */
	private int	height;

	/**
	 * Instantiates a new dimension.
	 *
	 * @param width the width
	 * @param height the height
	 */
	public Dimension(final int width, final int height) {
		this.width = width;
		this.height = height;
	}

	/**
	 * Instantiates a new dimension.
	 *
	 * @param dimension the dimension
	 */
	public Dimension(final Dimension dimension) {
		this(dimension.getWidth(), dimension.getHeight());
	}

	/**
	 * Gets the width.
	 *
	 * @return the width
	 */
	public int getWidth() {
		return this.width;
	}

	/**
	 * Sets the width.
	 *
	 * @param width the new width
	 */
	public void setWidth(final int width) {
		this.width = width;
	}

	/**
	 * Gets the height.
	 *
	 * @return the height
	 */
	public int getHeight() {
		return this.height;
	}

	/**
	 * Sets the height.
	 *
	 * @param height the new height
	 */
	public void setHeight(final int height) {
		this.height = height;
	}

}
