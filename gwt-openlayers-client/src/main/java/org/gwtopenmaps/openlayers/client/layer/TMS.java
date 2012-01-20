package org.gwtopenmaps.openlayers.client.layer;

import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 * @author Amr Alam - Refractions Research
 *
 */
public class TMS extends GridLayer
{

    protected TMS(JSObject element)
    {
        super(element);
    }

    public TMS(String name, String url, TMSOptions options)
    {
        this(TMSImpl.create(name, url, options.getJSObject()));
    }

    public int getNumLoadingTiles()
    {
        return TMSImpl.getNumLoadingTiles(this.getJSObject());
    }
}
