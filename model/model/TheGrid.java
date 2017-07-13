package model;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

// TODO: Auto-generated Javadoc
/**
 * The Class TheGrid.
 */
class TheGrid implements IArea {
	
	/** The image. */
	private static String		IMAGE	= "TheGrid.png";
	
	/** The dimension. */
	private final Dimension	dimension;
	
	/** The image. */
	private Image						image;

	/**
	 * Instantiates a new the grid.
	 *
	 * @param dimension the dimension
	 */
	public TheGrid(final Dimension dimension) {
		this.dimension = dimension;
		try {
			this.image = ImageIO.read(new File("images/" + IMAGE));
		} catch (final IOException e) {
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see model.IArea#getDimension()
	 */
	public Dimension getDimension() {
		return this.dimension;
	}

	/* (non-Javadoc)
	 * @see model.IArea#getWidth()
	 */
	public int getWidth() {
		return this.getDimension().getWidth();
	}

	/* (non-Javadoc)
	 * @see model.IArea#getHeight()
	 */
	public int getHeight() {
		return this.getDimension().getHeight();
	}

	/* (non-Javadoc)
	 * @see model.IArea#getImage()
	 */
	public Image getImage() {
		return this.image;
	}
}
