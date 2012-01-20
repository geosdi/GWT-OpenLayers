package org.gwtopenmaps.openlayers.client.popup;

import org.gwtopenmaps.openlayers.client.LonLat;
import org.gwtopenmaps.openlayers.client.OpenLayersObjectWrapper;
import org.gwtopenmaps.openlayers.client.Size;
import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 *
 * @author Erdem Gunay
 * @author <a href="mailto:marten.karlberg@digpro.se">Marten Karlberg</a>, Digpro AB
 *
 */
public class AnchoredBubble extends Popup
{

    protected AnchoredBubble(JSObject element)
    {
        super(element);
    }

    /**
     * Constructor also taking a CloseListener callback as suggested by the original OpenLayers
     * JavaScript constructor.
     */
    public AnchoredBubble(String id, LonLat lonlat, Size size, String html,
        OpenLayersObjectWrapper anchor, boolean closeBox,
        CloseListener closeBoxCallback)
    {
        this(AnchoredBubbleImpl.create(id,
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
     * For explanation of parameters see {@link Popup}.
     */
    public AnchoredBubble(String id, LonLat lonlat, Size size, String html,
        OpenLayersObjectWrapper anchor, boolean closeBox)
    {
        this(AnchoredBubbleImpl.create(id,
                lonlat.getJSObject(),
                (size != null) ? size.getJSObject() : null,
                html,
                (anchor != null) ? anchor.getJSObject() : null,
                closeBox));
    }
}
