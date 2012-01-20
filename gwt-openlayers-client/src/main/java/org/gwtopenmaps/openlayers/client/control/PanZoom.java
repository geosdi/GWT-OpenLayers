package org.gwtopenmaps.openlayers.client.control;

import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 * Pan and Zoom control.
 *
 * This control is added to OpenLayers maps by default.
 * Remove this control from the map when using the PanZoomBar.
 *
 * Other controls that are added by default are the {@link Attribution},
 * {@link Navigation} and {@link ArgParser}.
 *
 * @author Edwin Commandeur
 * @since GWT-OL 0.4
 */
public class PanZoom extends Control
{

    protected PanZoom(JSObject element)
    {
        super(element);
    }

    public PanZoom()
    {
        this(PanZoomImpl.create());
    }

    public PanZoom(PanZoomOptions options)
    {
        this(PanZoomImpl.create(options.getJSObject()));
    }

}
