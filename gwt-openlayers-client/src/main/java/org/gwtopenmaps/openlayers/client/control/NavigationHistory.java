package org.gwtopenmaps.openlayers.client.control;

import org.gwtopenmaps.openlayers.client.control.Control;
import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 * 
 * @author Maciej Jezierski - Pinocchio
 *
 */
public class NavigationHistory extends Control {

	public NavigationHistory(JSObject element) {
		super(element);
	}
		
	public NavigationHistory() {
		this(NavigationHistoryImpl.create());
	}

	/**
	 * Switch map view to a previous step in browser's history. 
	 *
	 */		
	public void previous() {
		NavigationHistoryImpl.previous(this.getJSObject());
	}
	/**
	 * Switch map view to next step in browser's history.
	 *  
	*/	
	public void next() {
		NavigationHistoryImpl.next(this.getJSObject());
	}
	
	/**
	 * Optional limit on the number of history items to retain.
	 * If null, there is no limit.  Default is 50.
	 *
	 * @param limit		- number of items 
	 * @return void  
	*/		
	public void limit(int limit) {
		NavigationHistoryImpl.limit(this.getJSObject(), limit);
	}

	/**
	 * Activate the control when it is added to a map.
	 * Default is true. If set to false, activate() method must
	 * be fired in order to use the control with map.
	 *
	 * @param autoActivate	-  set automatic activation true or false
	 * @return void  
	*/	
	public void autoActivate(boolean autoActivate) {
		NavigationHistoryImpl.autoActivate(this.getJSObject(), autoActivate);
	}

	/**
	 * Restore the next state. If no items are in the next history
	 * stack, this has no effect. The next history stack is populated
	 * as states are restored from the previous history stack.
	 * 
	 *
	 * @param void
	 * @return JSObject	- Item representing state that was restored.  Undefined if no items are in the next history stack.  
	*/	
	public JSObject nextTrigger() {
		return NavigationHistoryImpl.nextTrigger(this.getJSObject());		
	}		
}