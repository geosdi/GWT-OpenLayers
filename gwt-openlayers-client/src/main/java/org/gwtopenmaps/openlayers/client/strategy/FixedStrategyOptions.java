/**
 *
 */
package org.gwtopenmaps.openlayers.client.strategy;

import org.gwtopenmaps.openlayers.client.util.JSObject;
import org.gwtopenmaps.openlayers.client.util.JSObjectWrapper;


/**
 * @author lorenzo
 *
 */
public class FixedStrategyOptions extends JSObjectWrapper
{

    protected FixedStrategyOptions(JSObject jsObject)
    {
        super(jsObject);
        // TODO Auto-generated constructor stub
    }


    public FixedStrategyOptions()
    {
        // TODO Auto-generated constructor stub
        this(JSObject.createJSObject());
    }


    /**
     * APIProperty: preload
     * {Boolean} Load data before layer made visible. Enabling this may result
     *   in considerable overhead if your application loads many data layers
     *   that are not visible by default. Default is false.
     */

    public void setPreload(boolean preload)
    {
        getJSObject().setProperty("preload", preload);
    }
}
