package org.gwtopenmaps.openlayers.client.layer;

import org.gwtopenmaps.openlayers.client.Bounds;
import org.gwtopenmaps.openlayers.client.Marker;
import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 *
 * <p>
 * Markers is the non-preferred way to create marker layers.
 * Alternatively, use Vector Layers, as explained
 * <a href="http://docs.openlayers.org/library/overlays.html">here</a>.
 * </p>
 *
 * @author Erdem Gunay
 * @author Wayne Fang - Refractions Research
 * @author Aaron Novstrup - Stottler Henke Associates, Inc.
 *
 */
public class Markers extends Layer
{

    protected Markers(JSObject markersLayer)
    {
        super(markersLayer);
    }

    public Markers(String name)
    {
        this(MarkersImpl.create(name));
    }

    public Markers(String name, MarkersOptions options)
    {
        this(MarkersImpl.create(name, options.getJSObject()));
    }

    public Markers narrowToMarkers(JSObject markersLayer)
    {
        return (markersLayer == null) ? null : new Markers(markersLayer);
    }

    public void addMarker(Marker marker)
    {
        MarkersImpl.addMarker(getJSObject(), marker.getJSObject());
    }

    public void removeMarker(Marker marker)
    {
        MarkersImpl.removeMarker(getJSObject(), marker.getJSObject());
    }

    public void clearMarkers()
    {
        MarkersImpl.clearMarkers(getJSObject());
    }

    public JSObject[] getMarkers()
    {
        return getJSObject().getPropertyAsArray("markers");
    }

    public Bounds getDataExtent()
    {
        return Bounds.narrowToBounds(MarkersImpl.getDataExtent(getJSObject()));
    }

    public void destroy()
    {
        MarkersImpl.destroy(getJSObject());
    }
}
