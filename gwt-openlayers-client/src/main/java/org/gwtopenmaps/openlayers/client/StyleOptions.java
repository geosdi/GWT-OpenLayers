package org.gwtopenmaps.openlayers.client;

import org.gwtopenmaps.openlayers.client.util.JSObject;
import org.gwtopenmaps.openlayers.client.util.JSObjectWrapper;

/**
 * Stores style options for the OpenLayersStyle class
 * @author Jon Britton, SpiffyMap Ltd (jonb@spiffymap.net)
 */
public class StyleOptions extends JSObjectWrapper {

	protected StyleOptions(JSObject jsObject) {
		super(jsObject);
	}

	public StyleOptions(){
		this(JSObject.createJSObject());
	}
    
    public void addContextStyleCallback(String id, ContextStyler styler) {
        JSObject context = getJSObject().getProperty("context");
        if (context == null) {
            getJSObject().setProperty("context", JSObject.createJSObject());
            context = getJSObject().getProperty("context");
        }
        context.setProperty(id, StyleOptionsImpl.createContextStylerCallback(styler));
    }
}
