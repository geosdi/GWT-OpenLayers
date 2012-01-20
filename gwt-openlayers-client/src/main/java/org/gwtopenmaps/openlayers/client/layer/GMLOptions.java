/**
 *
 */
package org.gwtopenmaps.openlayers.client.layer;

import org.gwtopenmaps.openlayers.client.StyleMap;
import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 * @author Francesco
 *
 */
public class GMLOptions extends LayerOptions
{


    public void setStyleMap(StyleMap styleMap)
    {
        getJSObject().setProperty("styleMap", styleMap.getJSObject());
    }

    public JSObject getStyleMap()
    {
        return getJSObject().getProperty("styleMap");
    }

}
