package org.gwtopenmaps.openlayers.client.control;

import org.gwtopenmaps.openlayers.client.OpenLayersEObjectWrapper;
import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 * Options specific to Control widgets.
 *
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class ControlOptions extends OpenLayersEObjectWrapper
{

    protected ControlOptions(JSObject jsObject)
    {
        super(jsObject);
    }

    public ControlOptions()
    {
        this(JSObject.createJSObject());
    }
    
    public void setAutoActivate(boolean autoActivate)
    {
        getJSObject().setProperty("autoActivate", autoActivate);
    }
}
