/**
 * 
 */
package org.gwtopenmaps.openlayers.client.strategy;

import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 * @author lorenzo
 *
 */
public class FixedStrategyImpl {
	
	public native static JSObject create(JSObject options)/*-{
	return new $wnd.OpenLayers.Strategy.Fixed();
}-*/;

}
