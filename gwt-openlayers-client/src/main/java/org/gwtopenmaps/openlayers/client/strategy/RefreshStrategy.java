package org.gwtopenmaps.openlayers.client.strategy;

import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 * 
 * @author Maciej Jezierski - Pinocchio
 *
 */
public class RefreshStrategy extends Strategy {

	public boolean activate() {
		return RefreshStrategyImpl.activate(this.getJSObject());
	}
	
	public boolean deactivate() {
		return RefreshStrategyImpl.deactivate(this.getJSObject());
	}
	
	public void refresh() {
		RefreshStrategyImpl.refresh(this.getJSObject());
	}
	
	public RefreshStrategy(JSObject strategy) {
		super(strategy);
	}
	
	public RefreshStrategy() {
		this(RefreshStrategyImpl.create());
	}
}
