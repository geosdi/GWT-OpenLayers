/**
 *
 */
package org.gwtopenmaps.openlayers.client.control;

import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 * @author lorenzo - CNR IMAA geoSDI Group
 * email: lorenzo.amato@geosdi.org
 *
 */
public class Graticule extends Control
{

    protected Graticule(JSObject element)
    {
        super(element);
        // TODO Auto-generated constructor stub
    }

    public Graticule()
    {
        this(GraticuleImpl.create());
    }

    public Graticule(GraticuleOptions options)
    {
        this(GraticuleImpl.create(options.getJSObject()));
    }
}
