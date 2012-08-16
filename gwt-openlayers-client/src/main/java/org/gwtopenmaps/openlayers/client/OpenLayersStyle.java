package org.gwtopenmaps.openlayers.client;

import org.gwtopenmaps.openlayers.client.util.JSObject;
import org.gwtopenmaps.openlayers.client.util.JSObjectWrapper;

/**
 * Implementation of the OpenLayers style object. nameed "OpenLayersStyle" just
 * because there is already a Style class in this package.
 * TODO: fix this
 * @author Jon Britton, SpiffyMap Ltd (jonb@spiffymap.net)
 */
public class OpenLayersStyle extends JSObjectWrapper
{

    protected OpenLayersStyle(JSObject jsObject)
    {
        super(jsObject);
    }
    
    public OpenLayersStyle(StyleRules rules, StyleOptions options) {
        this(OpenLayersStyleImpl.create(rules.getJSObject(), options.getJSObject()));
    }

}
