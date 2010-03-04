package org.gwtopenmaps.openlayers.client.format;

import org.gwtopenmaps.openlayers.client.util.JSObject;
import org.gwtopenmaps.openlayers.client.util.JSObjectWrapper;

/**
 * Properties to be initialized for any GML2 by passing this object to the constructor
 * 
 * @author Mikael Couzic
 */
public class GML2Options extends JSObjectWrapper {

	protected GML2Options(JSObject jsObject) {
		super(jsObject);
	}

	/**
	 * There is no no-argument constructor for this class.
	 * The unique constructor takes arguments that are absolutely required for the GML parser to work.
	 * @param featureType
	 * 						Local (without prefix) feature typeName. For example : "states" 
	 * @param featureNS
	 * 						Feature namespace. For example : "http://www.openplans.org/topp"
	 * @author Mikael Couzic
	 */
	public GML2Options(String featureType, String featureNS){
		this(JSObject.createJSObject());
		setFeatureType(featureType);
		setFeatureNS(featureNS);
	}
	
	public void setFeatureType(String featureType) {
		getJSObject().setProperty("featureType", featureType);
	}
	
	public void setFeatureNS(String featureNS) {
		getJSObject().setProperty("featureNS", featureNS);
	}
	
	public void setGeometryName(String geometryName) {
		getJSObject().setProperty("geometryName", geometryName);
	}
	
}
