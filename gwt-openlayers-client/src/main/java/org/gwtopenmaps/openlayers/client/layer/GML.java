/**
 *
 */
package org.gwtopenmaps.openlayers.client.layer;

import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 * @author Francesco
 *
 */
public class GML extends Vector
{

    protected GML(JSObject gml)
    {
        super(gml);
    }

    public GML(String name, String url)
    {
        this(GMLImpl.create(name, url));
    }

    public GML(String name, String url, GMLOptions options)
    {
        this(GMLImpl.create(name, url, options.getJSObject()));
    }

    public void loadGML()
    {
        GMLImpl.loadGML(getJSObject());
    }

}
