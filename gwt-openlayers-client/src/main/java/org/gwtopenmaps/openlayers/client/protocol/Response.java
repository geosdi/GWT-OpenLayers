package org.gwtopenmaps.openlayers.client.protocol;

import org.gwtopenmaps.openlayers.client.feature.VectorFeature;
import org.gwtopenmaps.openlayers.client.util.JObjectArray;
import org.gwtopenmaps.openlayers.client.util.JSObject;
import org.gwtopenmaps.openlayers.client.util.JSObjectWrapper;

/**
 * A wrapper for the response object returned by any CRUD action performed by
 * the protocol.
 *
 * @author Mikael Couzic
 *
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
public class Response extends JSObjectWrapper {

    public static Response narrowToResponse(JSObject response) {
        return (response == null) ? null : new Response(response);
    }

    protected Response(JSObject jsObject) {
        super(jsObject);
    }

    public VectorFeature[] getFeatures() {
        JSObject out = ResponseImpl.getFeatures(this.getJSObject());
        JObjectArray jObjectArray = JObjectArray.narrowToJObjectArray(
                out.ensureOpaqueArray());
        int nr = jObjectArray.length();
        VectorFeature[] vfs = new VectorFeature[nr];
        for (int i = 0; i < nr; i++) {
            // get objects and narrow them to vector features
            vfs[i] = VectorFeature.narrowToVectorFeature(jObjectArray.get(i));
        }

        return vfs;
    }

    /**
     * Property: requestType
     *
     * {String} The type of request this response corresponds to. Either
     * "create", "read", "update" or "delete".
     */
    public String getRequestType() {
        return ResponseImpl.getRequestType(getJSObject());
    }

    /**
     * Method: success
     *
     * Returns: {Boolean} - true on success, false otherwise
     */
    public boolean success() {
        return ResponseImpl.success(getJSObject());
    }
}
