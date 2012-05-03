package org.gwtopenmaps.openlayers.client.control;

import org.gwtopenmaps.openlayers.client.layer.Params;
import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 * @author Nazzareno Sileno - CNR IMAA geoSDI Group
 * @email nazzareno.sileno@geosdi.org
 */
public class GetFeatureInfoVendorParam extends Params {

    public static GetFeatureInfoVendorParam narrowToAttributes(JSObject vendorParam) {
        return (vendorParam == null) ? null : new GetFeatureInfoVendorParam(vendorParam);
    }

    protected GetFeatureInfoVendorParam(JSObject jsObject) {
        super(jsObject);
    }

    public GetFeatureInfoVendorParam() {
        this(JSObject.createJSObject());
    }
}
