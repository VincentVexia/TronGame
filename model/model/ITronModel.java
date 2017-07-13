package model;

import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Interface ITronModel.
 */
public interface ITronModel {
	
	/**
	 * Builds the area.
	 *
	 * @param dimension the dimension
	 */
	public void buildArea(final Dimension dimension);

	/**
	 * Gets the area.
	 *
	 * @return the area
	 */
	public IArea getArea();

	/**
	 * Adds the mobile.
	 *
	 * @param mobile the mobile
	 */
	public void addMobile(final IMobile mobile);

	/**
	 * Removes the mobile.
	 *
	 * @param mobile the mobile
	 */
	public void removeMobile(final IMobile mobile);

	/**
	 * Gets the mobiles.
	 *
	 * @return the mobiles
	 */
	public ArrayList<IMobile> getMobiles();

	/**
	 * Gets the mobile by player.
	 *
	 * @param player the player
	 * @return the mobile by player
	 */
	public IMobile getMobileByPlayer(int player);

	/**
	 * Sets the mobiles haves moved.
	 */
	public void setMobilesHavesMoved();
}