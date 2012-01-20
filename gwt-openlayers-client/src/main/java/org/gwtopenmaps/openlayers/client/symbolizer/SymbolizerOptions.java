/**
 *
 */
package org.gwtopenmaps.openlayers.client.symbolizer;

import org.gwtopenmaps.openlayers.client.util.JSObject;
import org.gwtopenmaps.openlayers.client.util.JSObjectWrapper;


/**
 * @author lorenzo
 *
 */
public class SymbolizerOptions extends JSObjectWrapper
{

    protected SymbolizerOptions(JSObject jsObject)
    {
        super(jsObject);
        // TODO Auto-generated constructor stub
    }

    public SymbolizerOptions()
    {
        // TODO Auto-generated constructor stub
        this(JSObject.createJSObject());
    }

    /**
     * APIProperty: zIndex
     * {Number} The zIndex determines the rendering order for a symbolizer.
     *     Symbolizers with larger zIndex values are rendered over symbolizers
     *     with smaller zIndex values.  Default is 0.
     */

    public void setZindex(int zIndex)
    {
        getJSObject().setProperty("zIndex", zIndex);
    }


}
