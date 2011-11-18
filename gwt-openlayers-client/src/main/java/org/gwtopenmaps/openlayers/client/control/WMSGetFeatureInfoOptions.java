package org.gwtopenmaps.openlayers.client.control;

import org.gwtopenmaps.openlayers.client.layer.WMS;
import org.gwtopenmaps.openlayers.client.util.JObjectArray;
import org.gwtopenmaps.openlayers.client.util.JSObject;
import org.gwtopenmaps.openlayers.client.util.JSObjectWrapper;
import org.gwtopenmaps.openlayers.client.util.JStringArray;


/**
 * @author Dave Potts
 * @author Lukas Johansson
 */
public class WMSGetFeatureInfoOptions extends JSObjectWrapper {

	public enum GetFeatureInfoFormat {
		HTML("text/html"), GML("application/vnd.ogc.gml");

		private String value;

		GetFeatureInfoFormat(String theValue) {
			this.value = theValue;
		}

		public String toString() {
			return value;
		}
	}
	
	protected WMSGetFeatureInfoOptions(JSObject jsObject) {
		super(jsObject);
	}

	public WMSGetFeatureInfoOptions(){
		this(JSObject.createJSObject());
	}

	public void setHover(boolean hover){
		getJSObject().setProperty("hover", hover);
	}

	public boolean getHover(){
		return getJSObject().getPropertyAsBoolean("hover");
	}

	public void setMaxFeaturess(int maxFeatures){
		getJSObject().setProperty("maxFeatures", maxFeatures);
	}

	public int getMaxFeatures(){
		return getJSObject().getPropertyAsInt("maxFeatures");
	}

	/**
	 * The URL of the WMS service to use.  If not provided, the url
	 * of the first eligible layer will be used.
	 * @param url The url to which the WmsGetFeatureInfo will be called against
	 */
	public void setURL(String url){
		getJSObject().setProperty("url", url);
	}

	public void setTitle(String title){
		getJSObject().setProperty("title", title);
	}

	public void setQueryVisible(Boolean qvis){
		getJSObject().setProperty("queryVisible", qvis);
	}

	/**
 	 * The layers to query for feature info.
 	 * If omitted, all map WMS layers with a url that matches this <url> or
 	 * <layerUrls> will be considered.
	 * @param layers The layers to query
	 */
	public void setLayers(WMS[] layers){
		JObjectArray jsArray = JObjectArray.narrowToJObjectArray(JSObject.createJSArray());
		for (int i = 0; layers != null && i < layers.length; i++) {
			jsArray.set(i, layers[i].getJSObject());
	    }
		getJSObject().setProperty("layers", jsArray.getJSObject());
	}

	/**
	 * Optional list of urls for layers that should be queried.
	 * This can be used when the layer url differs from the url used for
	 * making GetFeatureInfo requests (in the case of a layer using cached
	 * tiles).
	 *
	 * Notice that this will not cause a WmsGetFeatureInfo request to be sent
	 * to all urls, its merely to include layers that don't match this.url.
	 * For a a request to be sent to each url the propery drillDown must be set
	 * to true.
	 * @param urls urls that should be considered
	 */
	public void setLayerUrls(String[] urls){
		getJSObject().setProperty("layerUrls", new JStringArray(urls).getJSObject());
	}
	/**
	 * Drill down over all WMS layers in the map. When
     * using drillDown mode, hover is not possible, and an infoFormat that
	 * returns parseable features is required. Default is false.
	 * @param value indicates whether drillDown should be enabled or not
	 */
	public void setDrillDown(boolean value){
		getJSObject().setProperty("drillDown", value);
	}

	/**
	 * The mimetype to request from the server
	 * defaults to 'text/html'
	 */
	public void setInfoFormat(String infoFormat){
		getJSObject().setProperty("infoFormat", infoFormat);
	}
}
