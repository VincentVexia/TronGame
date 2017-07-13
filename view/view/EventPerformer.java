package view;

import java.awt.event.KeyEvent;

import controller.IOrderPerformer;
import controller.IUserOrder;
import controller.Order;
import controller.UserOrder;
import gameframe.IEventPerformer;

// TODO: Auto-generated Javadoc
/**
 * The Class EventPerformer.
 */
class EventPerformer implements IEventPerformer {
	
	/** The order performer. */
	private final IOrderPerformer orderPerformer;

	/**
	 * Instantiates a new event performer.
	 *
	 * @param orderPerformer the order performer
	 */
	public EventPerformer(final IOrderPerformer orderPerformer) {
		this.orderPerformer = orderPerformer;
	}
	
	/* (non-Javadoc)
	 * @see gameframe.IEventPerformer#eventPerform(java.awt.event.KeyEvent)
	 */
	public void eventPerform(final KeyEvent keyCode) {
		final IUserOrder userOrder = this.keyCodeToUserOrder(keyCode.getKeyCode());
		if (userOrder != null) {
			this.orderPerformer.orderPerform(userOrder);
		}
	}

	/**
	 * Key code to user order.
	 *
	 * @param keyCode the key code
	 * @return the i user order
	 */
	private IUserOrder keyCodeToUserOrder(final int keyCode) {
		IUserOrder userOrder;
		switch (keyCode) {
			case KeyEvent.VK_UP:
				userOrder = new UserOrder(0, Order.UP);
				break;
			case KeyEvent.VK_RIGHT:
				userOrder = new UserOrder(0, Order.RIGHT);
				break;
			case KeyEvent.VK_DOWN:
				userOrder = new UserOrder(0, Order.DOWN);
				break;
			case KeyEvent.VK_LEFT:
				userOrder = new UserOrder(0, Order.LEFT);
				break;
			case KeyEvent.VK_CONTROL:
				userOrder = new UserOrder(0, Order.SHOOT);
				break;

			case KeyEvent.VK_Z:
				userOrder = new UserOrder(1, Order.UP);
				break;
			case KeyEvent.VK_D:
				userOrder = new UserOrder(1, Order.RIGHT);
				break;
			case KeyEvent.VK_S:
				userOrder = new UserOrder(1, Order.DOWN);
				break;
			case KeyEvent.VK_Q:
				userOrder = new UserOrder(1, Order.LEFT);
				break;
			case KeyEvent.VK_SHIFT:
				userOrder = new UserOrder(1, Order.SHOOT);
				break;
			default:
				userOrder = null;
		}
		return userOrder;
	}
}
