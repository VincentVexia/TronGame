package model;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

// TODO: Auto-generated Javadoc
/**
 * The Class Mobile.
 */
public class Mobile implements IMobile {
	
	/** The direction. */
	private Direction				direction;
	
	/** The position. */
	private final Position	position;
	
	/** The dimension. */
	private final Dimension	dimension;
	
	/** The speed. */
	private final int				speed;
	
	/** The tron model. */
	private ITronModel	   tronModel;
	
	/** The images. */
	private Image						images[];

	/**
	 * Instantiates a new mobile.
	 *
	 * @param direction the direction
	 * @param position the position
	 * @param dimension the dimension
	 * @param speed the speed
	 * @param image the image
	 */
	public Mobile(final Direction direction, final Position position, final Dimension dimension, final int speed, final String image) {
		this.direction = direction;
		this.position = position;
		this.dimension = dimension;
		this.speed = speed;
		try {
			this.buildAllimages(image);
		} catch (final IOException e) {
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see model.IMobile#getDirection()
	 */
	public Direction getDirection() {
		return this.direction;
	}

	/* (non-Javadoc)
	 * @see model.IMobile#setDirection(model.Direction)
	 */
	public void setDirection(final Direction direction) {
		this.direction = direction;
	}

	/* (non-Javadoc)
	 * @see model.IMobile#getPosition()
	 */
	public Position getPosition() {
		return this.position;
	}

	/* (non-Javadoc)
	 * @see model.IMobile#getDimension()
	 */
	public Dimension getDimension() {
		return this.dimension;
	}

	/* (non-Javadoc)
	 * @see model.IMobile#placeInArea(model.IArea)
	 */
	public void placeInArea(final IArea area) {
		this.position.setMaxX(area.getDimension().getWidth());
		this.position.setMaxY(area.getDimension().getHeight());
	}

	/* (non-Javadoc)
	 * @see model.IMobile#move()
	 */
	public void move() {
		switch (this.direction) {
			case UP:
				this.moveUp();
				break;
			case RIGHT:
				this.moveRight();
				break;
			case DOWN:
				this.moveDown();
				break;
			case LEFT:
				this.moveLeft();
				break;
			default:
				break;
		}
	}

	/**
	 * Move up.
	 */
	private void moveUp() {
		this.position.setY(this.position.getY() - this.speed);
	}

	/**
	 * Move right.
	 */
	private void moveRight() {
		this.position.setX(this.position.getX() + this.speed);
	}

	/**
	 * Move down.
	 */
	private void moveDown() {
		this.position.setY(this.position.getY() + this.speed);
	}

	/**
	 * Move left.
	 */
	private void moveLeft() {
		this.position.setX(this.position.getX() - this.speed);
	}

	/* (non-Javadoc)
	 * @see model.IMobile#isPlayer(int)
	 */
	public boolean isPlayer(final int player) {
		return false;
	}

	/**
	 * Gets the tron model.
	 *
	 * @return the tron model
	 */
	public ITronModel getTronModel() {
		return this.tronModel;
	}

	/* (non-Javadoc)
	 * @see model.IMobile#setTronModel(model.ITronModel)
	 */
	public void setTronModel(final ITronModel tronModel) {
		this.tronModel = tronModel;
		this.getPosition().setMaxX(this.getTronModel().getArea().getDimension().getWidth());
		this.getPosition().setMaxY(this.getTronModel().getArea().getDimension().getHeight());
	}

	/* (non-Javadoc)
	 * @see model.IMobile#hit()
	 */
	public boolean hit() {
		return false;
	}

	/* (non-Javadoc)
	 * @see model.IMobile#isWeapon()
	 */
	public boolean isWeapon() {
		return false;
	}

	/* (non-Javadoc)
	 * @see model.IMobile#getWidth()
	 */
	public int getWidth() {
		switch (this.direction) {
			case UP:
			case DOWN:
				return this.getDimension().getHeight();
			case RIGHT:
			case LEFT:
			default:
				return this.getDimension().getWidth();
		}
	}

	/* (non-Javadoc)
	 * @see model.IMobile#getHeight()
	 */
	public int getHeight() {
		switch (this.direction) {
			case UP:
			case DOWN:
				return this.getDimension().getWidth();
			case RIGHT:
			case LEFT:
			default:
				return this.getDimension().getHeight();
		}
	}

	/* (non-Javadoc)
	 * @see model.IMobile#getSpeed()
	 */
	public int getSpeed() {
		return this.speed;
	}

	/**
	 * Builds the allimages.
	 *
	 * @param imageName the image name
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private void buildAllimages(final String imageName) throws IOException {
		this.images = new Image[5];
		this.images[Direction.UP.ordinal()] = ImageIO.read(new File("images/" + imageName + "_UP.png"));
		this.images[Direction.RIGHT.ordinal()] = ImageIO.read(new File("images/" + imageName + "_RIGHT.png"));
		this.images[Direction.DOWN.ordinal()] = ImageIO.read(new File("images/" + imageName + "_DOWN.png"));
		this.images[Direction.LEFT.ordinal()] = ImageIO.read(new File("images/" + imageName + "_LEFT.png"));
	}

	/* (non-Javadoc)
	 * @see model.IMobile#getImage()
	 */
	public Image getImage() {
		return this.images[this.direction.ordinal()];
	}
}


