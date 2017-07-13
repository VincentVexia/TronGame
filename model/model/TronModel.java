package model;

import java.util.ArrayList;
import java.util.Observable;

public class TronModel extends Observable implements ITronModel {
	private TheGrid					theGrid;
	private final ArrayList<IMobile> mobiles;

	public TronModel() {
		this.mobiles = new ArrayList<IMobile>();
	}

	@Override
	public IArea getArea() {
		return this.theGrid;
	}

	@Override
	public void buildArea(final Dimension dimension) {
		this.theGrid = new TheGrid(dimension);
	}

	@Override
	public void addMobile(final IMobile mobile) {
		this.mobiles.add(mobile);
		mobile.setTronModel(this);
	}

	@Override
	public void removeMobile(final IMobile mobile) {
		this.mobiles.remove(mobile);
	}

	@Override
	public ArrayList<IMobile> getMobiles() {
		return this.mobiles;
	}

	@Override
	public IMobile getMobileByPlayer(final int player) {
		for (final IMobile mobile : this.mobiles) {
			if (mobile.isPlayer(player)) {
				return mobile;
			}
		}
		return null;
	}

	@Override
	public void setMobilesHavesMoved() {
		this.setChanged();
		this.notifyObservers();
	}
}
