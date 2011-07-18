package org.gwtopenmaps.openlayers.client.layer;

import org.gwtopenmaps.openlayers.client.Style;
import org.gwtopenmaps.openlayers.client.StyleMap;
import org.gwtopenmaps.openlayers.client.protocol.Protocol;
import org.gwtopenmaps.openlayers.client.strategy.Strategy;
import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 * Convenience class exposing options that are valid for a vector layer. There's
 * also a Vector constructor that can take an Options object directly.
 *
 * @author Edwin commandeur - Atlis EJS
 * @author Rafael Ceravolo - LOGANN
 */
public class VectorOptions extends LayerOptions {

	public VectorOptions() {
	}

	public void setIsBaseLayer(boolean b) {
		getJSObject().setProperty("isBaseLayer", b);
	}

	public boolean getIsBaseLayer() {
		return getJSObject().getPropertyAsBoolean("isBaseLayer");
	}

	// limit geometry type to a specific geometry type
	public void setGeometryType(String gtype) {
		getJSObject().setProperty("geometryType", gtype);
	}

	public String getGeometryType() {
		return getJSObject().getPropertyAsString("geometryType");
	}

	public void setStyle(Style style) {
		getJSObject().setProperty("style", style.getJSObject());
	}

	public JSObject getStyle(Style style) {
		return getJSObject().getProperty("style");
	}

	public void setRendererOptions(RendererOptions rendererOptions) {
		getJSObject().setProperty("rendererOptions", rendererOptions.getJSObject());
	}

	public JSObject getRendererOptions() {
		return getJSObject().getProperty("rendererOptions");
	}

	/**
	 * Set the StypeMap property. Use StyleMap instead of just setting the
	 * single Style to use different styles for default, selected and temporary
	 * selected features.
	 *
	 * @param styleMap
	 *            The value to set to the property.
	 */
	public void setStyleMap(StyleMap styleMap) {
		getJSObject().setProperty("styleMap", styleMap.getJSObject());
	}

	public JSObject getStyleMap() {
		return getJSObject().getProperty("styleMap");
	}

	public void setProtocol(Protocol protocol){
		getJSObject().setProperty("protocol", protocol.getJSObject());
	}

	public void setStrategies(Strategy[] strategies){
		for(int i=0, max=strategies.length; i < max;i++){
			setStrategy(this.getJSObject(), strategies[i].getJSObject());
		}
	}

	private native void setStrategy(JSObject self, JSObject strategy)/*-{
		if(self.strategies === null || self.strategies === undefined){
			self.strategies = [];
		}
		self.strategies.push(strategy);
	}-*/;
}
