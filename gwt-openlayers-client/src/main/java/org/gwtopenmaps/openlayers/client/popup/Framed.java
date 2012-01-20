package org.gwtopenmaps.openlayers.client.popup;

import org.gwtopenmaps.openlayers.client.LonLat;
import org.gwtopenmaps.openlayers.client.OpenLayersObjectWrapper;
import org.gwtopenmaps.openlayers.client.Size;
import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 *
 * @author Curtis Jensen
 * @author <a href="mailto:marten.karlberg@digpro.se">Marten Karlberg</a>, Digpro AB
 *
 */
public class Framed extends Popup
{

    protected Framed(JSObject element)
    {
        super(element);
    }

    /*
     * Constructor also taking a CloseListener callback as suggested by the original OpenLayers
     * JavaScript constructor.
     *
     * Added by Digpro.
     */
    public Framed(String id, LonLat lonlat, Size size, String html, OpenLayersObjectWrapper anchor,
        boolean closeBox, CloseListener closeBoxCallback)
    {

        this(FramedImpl.create(id,
                lonlat.getJSObject(),
                (size != null) ? size.getJSObject() : null,
                html,
                (anchor != null) ? anchor.getJSObject() : null,
                closeBox,
                (closeBoxCallback != null) ? closeBoxCallback : null));
    }

    /**
     *
     * Use addCloseListener to respond to popup close event. (Beware! This does not work as
     * expected. Instead pass the CloseListener in the constructor for proper binding. /Digpro)
     *
     * @param anchor - ...
     *
     * For explanation of other parameters see {@link Popup}.
     */
    public Framed(String id, LonLat lonlat, Size size, String html, OpenLayersObjectWrapper anchor,
        boolean closeBox)
    {
        this(FramedImpl.create(id,
                lonlat.getJSObject(),
                (size != null) ? size.getJSObject() : null,
                html,
                (anchor != null) ? anchor.getJSObject() : null,
                closeBox));
    }

    public Framed(String id, LonLat lonlat, Size size, String html, boolean closeBox)
    {
        this(FramedImpl.create(id,
                lonlat.getJSObject(),
                (size != null) ? size.getJSObject() : null,
                html,
                null,
                closeBox));
    }

    public Framed(String id, LonLat lonlat, String html, boolean closeBox)
    {
        this(FramedImpl.create(id,
                lonlat.getJSObject(),
                null,
                html,
                null,
                closeBox));
    }
}
