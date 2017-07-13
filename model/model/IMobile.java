package model;

import java.awt.Image;

// TODO: Auto-generated Javadoc
/**
 * The Interface IMobile.
 */
public interface IMobile {

	/**
	 * Gets the direction.
	 *
	 * @return the direction
	 */
	public Direction getDirection();

	/**
	 * Sets the direction.
	 *
	 * @param direction the new direction
	 */
	public void setDirection(final Direction direction);

	/**
	 * Gets the position.
	 *
	 * @return the position
	 */
	public Position getPosition();

	/**
	 * Gets the dimension.
	 *
	 * @return the dimension
	 */
	public Dimension getDimension();

	/**
	 * Gets the width.
	 *
	 * @return the width
	 */
	public int getWidth();

	/**
	 * Gets the height.
	 *
	 * @return the height
	 */
	public int getHeight();

	/**
	 * Gets the speed.
	 *
	 * @return the speed
	 */
	public int getSpeed();

	/**
	 * Gets the image.
	 *
	 * @return the image
	 */
	public Image getImage();

	/**
	 * Move.
	 */
	public void move();

	/**
	 * Place in area.
	 *
	 * @param area the area
	 */
	public void placeInArea(IArea area);

	/**
	 * Checks if is player.
	 *
	 * @param player the player
	 * @return true, if is player
	 */
	public boolean isPlayer(int player);

	/**
	 * Sets the tron model.
	 *
	 * @param tronModel the new tron model
	 */
	public void setTronModel(ITronModel tronModel);

	/**
	 * Hit.
	 *
	 * @return true, if successful
	 */
	public boolean hit();

	/**
	 * Checks if is weapon.
	 *
	 * @return true, if is weapon
	 */
	public boolean isWeapon();

}