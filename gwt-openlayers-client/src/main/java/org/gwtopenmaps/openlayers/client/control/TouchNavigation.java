package org.gwtopenmaps.openlayers.client.control;

import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 * This control is added to OpenLayers mobile maps by default.
 *
 * Other controls that are added by default are the {@link PanZoom},
 * {@link ArgParser}, and {@link Attribution}.
 *
 * @author Jon Britton
 */
public class TouchNavigation extends Control
{

    protected TouchNavigation(JSObject element)
    {
        super(element);
    }

    public TouchNavigation()
    {
        this(TouchNavigationImpl.create());
    }

    public TouchNavigation(TouchNavigationOptions options)
    {
        this(TouchNavigationImpl.create(options.getJSObject()));
    }
}
