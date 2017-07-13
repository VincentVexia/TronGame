package model;

import java.util.ArrayList;
import java.util.Observable;

public class TronModel extends Observable implements ITronModel {
	private TheGrid					theGrid;
	private final ArrayList<IMobile> mobiles;

	public TronModel() {
		this.mobiles = new ArrayList<IMobile>();
	}

	public IArea getArea() {
		return this.theGrid;
	}

	public void buildArea(final Dimension dimension) {
		this.theGrid = new TheGrid(dimension);
	}

	public void addMobile(final IMobile mobile) {
		this.mobiles.add(mobile);
		mobile.setTronModel(this);
	}

	public void removeMobile(final IMobile mobile) {
		this.mobiles.remove(mobile);
	}

	public ArrayList<IMobile> getMobiles() {
		return this.mobiles;
	}

	public IMobile getMobileByPlayer(final int player) {
		for (final IMobile mobile : this.mobiles) {
			if (mobile.isPlayer(player)) {
				return mobile;
			}
		}
		return null;
	}

	public void setMobilesHavesMoved() {
		this.setChanged();
		this.notifyObservers();
	}
}
