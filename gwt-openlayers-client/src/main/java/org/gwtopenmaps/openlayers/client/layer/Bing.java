package org.gwtopenmaps.openlayers.client.layer;

import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 *
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email  giuseppe.lascaleia@geosdi.org
 */
public class Bing extends XYZ {
    
    protected Bing(JSObject xyzLayer) {
        super(xyzLayer);
    }
    
    public Bing(BingOptions options) {
        this(BingImpl.create(options.getJSObject()));
    }
    
    @Override
    public Bing narrowToXYZ(JSObject bingLayer) {
        return (bingLayer == null) ? null : new Bing(bingLayer);
    }
}
