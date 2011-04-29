package org.gwtopenmaps.openlayers.client.strategy;

import org.gwtopenmaps.openlayers.client.strategy.Strategy;
import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 * 
 * @author Maciej Jezierski - Pinocchio
 * A simple strategy that requests features once and never requests new data
 * 
 */
public class FixedStrategy extends Strategy{
	
	/**
	 * Clean up the strategy.
	 */
	public void destroy() {
		FixedStrategyImpl.destroy(this.getJSObject());
	}
	
	/**
	 * Load data before layer made visible.  Enabling this may result in considerable overhead if your application loads many data layers that are not visible by default.  Default is false.
	 * @param preload
	 */
	public void preload(boolean preload) {
		FixedStrategyImpl.preload(this.getJSObject(), preload);
	}
	
	public FixedStrategy(JSObject strategy, boolean preload) {
		super(strategy);
		preload(preload);
	}
	
	public FixedStrategy(JSObject strategy) {
		super(strategy);
	}
	
	public FixedStrategy(boolean preload) {
		this(FixedStrategyImpl.create(), preload);
	}
	
	public FixedStrategy() {
		this(FixedStrategyImpl.create());
	}
}