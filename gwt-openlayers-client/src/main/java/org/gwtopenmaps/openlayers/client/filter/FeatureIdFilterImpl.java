package org.gwtopenmaps.openlayers.client.filter;

import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 * @author Mikael Couzic
 */
public class FeatureIdFilterImpl
{

    public static native JSObject create(JSObject fids) /*-{
        // JavaScript can loose the type of objects.
        // the Array that was created in JArrayBaseImpl is reported as an "object"
        // when the OpenLayers code checks for instanceof Array.  Converting the passed in urls Array to a new Array corrects this problem.
        // There may be a better way, until it is figured out, this is what is done.
        
        var newArray = new $wnd.Array(fids.length);
        for (i = 0; i < fids.length; i++) {
        newArray[i] = fids[i];
        }
        return new $wnd.OpenLayers.Filter.FeatureId({fids: newArray});
    }-*/;

}
