package org.gwtopenmaps.openlayers.client.control;

import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 *
 *
 * This control is added to OpenLayers maps by default.
 *
 * Other controls that are added by default are the {@link PanZoom},
 * {@link ArgParser}, and {@link Attribution}.
 *
 * @author Edwin Commandeur
 * @since GWT-OL 0.4, OL ...
 */
public class Navigation extends Control
{

    protected Navigation(JSObject element)
    {
        super(element);
    }

    public Navigation()
    {
        this(NavigationImpl.create());
    }

    public Navigation(NavigationOptions options)
    {
        this(NavigationImpl.create(options.getJSObject()));
    }
}
