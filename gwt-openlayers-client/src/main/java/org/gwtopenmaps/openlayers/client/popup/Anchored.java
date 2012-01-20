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
public class Anchored extends Popup
{

    protected Anchored(JSObject element)
    {
        super(element);
    }

    /*
     * Constructor also taking a CloseListener callback as suggested by the original OpenLayers
     * JavaScript constructor.
     *
     * Added by Digpro.
     */
    public Anchored(String id, LonLat lonlat, Size size, String html,
        OpenLayersObjectWrapper anchor, boolean closeBox,
        CloseListener closeBoxCallback)
    {
        this(AnchoredImpl.create(id,
                lonlat.getJSObject(),
                (size != null) ? size.getJSObject() : null,
                html,
                (anchor != null) ? anchor.getJSObject() : null,
                closeBox,
                (closeBoxCallback != null) ? closeBoxCallback : null));
    }

    public Anchored(String id, LonLat lonlat, Size size, String html,
        OpenLayersObjectWrapper anchor, boolean closeBox)
    {
        this(AnchoredImpl.create(id,
                lonlat.getJSObject(),
                (size != null) ? size.getJSObject() : null,
                html,
                (anchor != null) ? anchor.getJSObject() : null,
                closeBox));
    }
}
