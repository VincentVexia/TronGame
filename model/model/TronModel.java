package model;

import java.util.ArrayList;
import java.util.Observable;

// TODO: Auto-generated Javadoc
/**
 * The Class TronModel.
 */
public class TronModel extends Observable implements ITronModel {
	
	/** The grid. */
	private TheGrid					theGrid;
	
	/** The mobiles. */
	private final ArrayList<IMobile> mobiles;

	/**
	 * Instantiates a new tron model.
	 */
	public TronModel() {
		this.mobiles = new ArrayList<IMobile>();
	}

	/* (non-Javadoc)
	 * @see model.ITronModel#getArea()
	 */
	public IArea getArea() {
		return this.theGrid;
	}

	/* (non-Javadoc)
	 * @see model.ITronModel#buildArea(model.Dimension)
	 */
	public void buildArea(final Dimension dimension) {
		this.theGrid = new TheGrid(dimension);
	}

	/* (non-Javadoc)
	 * @see model.ITronModel#addMobile(model.IMobile)
	 */
	public void addMobile(final IMobile mobile) {
		this.mobiles.add(mobile);
		mobile.setTronModel(this);
	}

	/* (non-Javadoc)
	 * @see model.ITronModel#removeMobile(model.IMobile)
	 */
	public void removeMobile(final IMobile mobile) {
		this.mobiles.remove(mobile);
	}

	/* (non-Javadoc)
	 * @see model.ITronModel#getMobiles()
	 */
	public ArrayList<IMobile> getMobiles() {
		return this.mobiles;
	}

	/* (non-Javadoc)
	 * @see model.ITronModel#getMobileByPlayer(int)
	 */
	public IMobile getMobileByPlayer(final int player) {
		for (final IMobile mobile : this.mobiles) {
			if (mobile.isPlayer(player)) {
				return mobile;
			}
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see model.ITronModel#setMobilesHavesMoved()
	 */
	public void setMobilesHavesMoved() {
		this.setChanged();
		this.notifyObservers();
	}
}
