package org.gwtopenmaps.openlayers.client.layer;

import org.gwtopenmaps.openlayers.client.LonLat;
import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 *
 * @author Erdem Gunay
 * @author Aaron Novstrup - Stottler Henke Associates, Inc.
 *
 */
public class Google extends Layer
{

    // In OpenLayers this class inherits from both EventPane
    // and FixedZoomLevels

    protected Google(JSObject element)
    {
        super(element);
    }

    public Google(String name)
    {
        this(GoogleImpl.create(name));
    }

    public Google(String name, GoogleOptions params)
    {
        this(GoogleImpl.create(name, params.getJSObject()));
    }

    public Google narrowToGoogle(JSObject google)
    {
        return (google == null) ? null : new Google(google);
    }

    public LonLat forwardMercator(double lon, double lat)
    {
        return LonLat.narrowToLonLat(GoogleImpl.forwardMercator(getJSObject(), lon, lat));
    }

}
