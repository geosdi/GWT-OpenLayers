/**
 * 
 */
package org.gwtopenmaps.openlayers.client.strategy;

import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 * @author lorenzo
 *
 */
public class FixedStrategy extends Strategy{

	protected FixedStrategy(JSObject strategy) {
		super(strategy);
		// TODO Auto-generated constructor stub
	}
	
	public FixedStrategy(FixedStrategyOptions options){
		this(FixedStrategyImpl.create(options.getJSObject()));
	}
}
