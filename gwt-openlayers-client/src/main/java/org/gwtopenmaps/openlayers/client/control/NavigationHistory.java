package org.gwtopenmaps.openlayers.client.control;

import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 * 
 * @author giuseppe
 * 
 */
public class NavigationHistory extends Control {

	protected NavigationHistory(JSObject element) {
		super(element);
		// TODO Auto-generated constructor stub
	}

	public NavigationHistory() {
		this(NavigationHistoryImpl.create());
	}

	public NavigationHistory(NavigationHistoryOptions options) {
		this(NavigationHistoryImpl.create(options.getJSObject()));
	}

	/**
	 * 
	 * @return Previous Control
	 */
	public Control getPrevious() {
		return Control.narrowToControl(NavigationHistoryImpl
				.getPrevious(getJSObject()));
	}

	/**
	 * 
	 * @return Next Control
	 */
	public Control getNext() {
		return Control.narrowToControl(NavigationHistoryImpl
				.getNext(getJSObject()));
	}

	/**
	 * APIMethod: nextTrigger Restore the next state. If no items are in the
	 * next history stack, this has no effect. The next history stack is
	 * populated as states are restored from the previous history stack.
	 * 
	 * Returns: {Object} Item representing state that was restored. Undefined if
	 * no items are in the next history stack.
	 */
	public void nextTrigger() {
		NavigationHistoryImpl.nextTrigger(getJSObject());
	}

	/**
	 * Method: previousTrigger Restore the previous state. If no items are in
	 * the previous history stack, this has no effect.
	 * 
	 * Returns: {Object} Item representing state that was restored. Undefined if
	 * no items are in the previous history stack.
	 */
	public void previousTrigger() {
		NavigationHistoryImpl.previousTrigger(getJSObject());
	}

	/**
	 * APIMethod: clear Clear history.
	 */
	public void clear() {
		NavigationHistoryImpl.clear(getJSObject());
	}
}
