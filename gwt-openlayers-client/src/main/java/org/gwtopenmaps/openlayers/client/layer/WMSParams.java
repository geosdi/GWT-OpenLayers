package org.gwtopenmaps.openlayers.client.layer;

import org.gwtopenmaps.openlayers.client.Bounds;
import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 * The WMSParams correspond with parameters that can be specified
 * in the WMS request.
 *
 * This differs from {@link WMSOptions}, which are options
 * that are set on the OL concept of a layer.
 *
 * @author Erdem Gunay
 * @author Edwin Commandeur
 *
 */
public class WMSParams extends Params {

    protected WMSParams(JSObject jsObject) {
        super(jsObject);
    }

    public WMSParams() {
        this(JSObject.createJSObject());
    }

    public void setLayers(String layers) {
        getJSObject().setProperty("layers", layers);
    }

    public String getLayers() {
        return getJSObject().getPropertyAsString("layers");
    }

    public void setStyles(String styles) {
        getJSObject().setProperty("styles", styles);
    }

    public String getStyles() {
        return getJSObject().getPropertyAsString("styles");
    }

    public void setFormat(String styles) {
        getJSObject().setProperty("format", styles);
    }

    public String getFormat() {
        return getJSObject().getPropertyAsString("format");
    }

    public void setMaxExtent(Bounds bounds) {
        getJSObject().setProperty("maxExtent", bounds.getJSObject());
    }

    public Bounds getMaxExtent() {
        return Bounds.narrowToBounds(getJSObject().getProperty("maxExtent"));
    }
    

    /**
     * Set transparent parameter in WMS request. Default is false.
     *
     * Within this method the value of the parameter will be set in uppercase,
     * since at least IONIC's WMS requires it to be in uppercase, in
     * accordance with the WMS Specification
     *
     * The WMS 1.1.1 spec states:
     *  "TRANSPARENT can take on two values, "TRUE" or "FALSE"."
     *  and
     *  "Parameter names shall not be case sensitive,
     *  but parameter values shall be case sensitive."
     *
     */
    public void setIsTransparent(boolean isTransparent) {
        if (isTransparent) {
            getJSObject().setProperty("transparent", "TRUE");
        } else {
            getJSObject().setProperty("transparent", "FALSE");
        }
    }
}
