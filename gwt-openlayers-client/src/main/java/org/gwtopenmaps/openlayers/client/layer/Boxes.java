package org.gwtopenmaps.openlayers.client.layer;

import org.gwtopenmaps.openlayers.client.marker.Box;
import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
* <p>
* Boxes is only maintained for backwards compatibility, as explained <a href="http://docs.openlayers.org/library/layers.html">here<a>.
*  Alternatively, use Vector Layers, as described <a href="http://docs.openlayers.org/library/overlays.html">here</a>.
* </p>
*
* @author Michel Vitor A Rodrigues
*/
public class Boxes extends Markers
{

    protected Boxes(JSObject boxes)
    {
        super(boxes);
    }

    public Boxes(String name, BoxesMarkersOptions options)
    {
        this(BoxesImpl.create(name, options.getJSObject()));
    }

    public Boxes(String name)
    {
        this(BoxesImpl.create(name));
    }

    public Boxes narrowToBoxes(JSObject boxes)
    {
        return (boxes == null) ? null : new Boxes(boxes);
    }

    public void drawMarker(Box marker)
    {
        BoxesImpl.drawMarker(getJSObject(), marker);
    }

    public void removeMarker(Box marker)
    {
        BoxesImpl.removeMarker(getJSObject(), marker);
    }

}
