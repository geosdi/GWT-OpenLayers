package org.gwtopenmaps.openlayers.client.layer;

import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 * Wrapper for OpenLayers.Layer.XYZ which is typically used to
 * add an ESRI Cached Map Service.
 *
 * @see XYZOptions
 * @author Andrew Hughes
 */
public class XYZ extends GridLayer {

    protected XYZ(JSObject xyzLayer) {
        super(xyzLayer);
    }

    /**
     * Constructor with specified options.
     * @param name the layer name
     * @param url example http://sampleserver1.arcgisonline.com/ArcGIS/rest/services/Portland/ESRI_LandBase_WebMercator/MapServer/tile/${z}/${y}/${x}
     * @param options constructor options
     */
    public XYZ(String name, String url, XYZOptions options) {
        this(XYZImpl.create(name, url, options.getJSObject()));
    }

    public XYZ narrowToXYZ(JSObject xyzLayer) {
        return (xyzLayer == null) ? null : new XYZ(xyzLayer);
    }
}
