package org.gwtopenmaps.openlayers.client.layer;

import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 * For displaying FeatureCollection data requested from a Web Feature Service (WFS)
 * server.
 *
 * Link to Open Geospatial Consortium website and WFS info.
 *
 * @author Edwin Commandeur - Atlis EJS
 * @since GWT-OL 0.4, OL 2.2
 *
 */
public class WFS extends Vector
{

    protected WFS(JSObject element)
    {
        super(element);
    }

    public WFS(String name, String url, WFSParams params, WFSOptions options)
    {
        this(WFSImpl.create(name, url, params.getJSObject(), options.getJSObject()));
    }

}
