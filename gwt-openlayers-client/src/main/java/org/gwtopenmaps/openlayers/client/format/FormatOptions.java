package org.gwtopenmaps.openlayers.client.format;

import org.gwtopenmaps.openlayers.client.Projection;
import org.gwtopenmaps.openlayers.client.util.JSObject;
import org.gwtopenmaps.openlayers.client.util.JSObjectWrapper;

/**
 *
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class FormatOptions extends JSObjectWrapper {

    protected FormatOptions(JSObject jsObject) {
        super(jsObject);
    }

    public FormatOptions() {
        this(JSObject.createJSObject());
    }

    /**
     *
     * @param projection
     */
    public void setInternalProjection(Projection projection) {
        getJSObject().setProperty("internalProjection", projection.getJSObject());
    }

    /**
     *
     * @param projection
     */
    public void setExternalProjection(Projection projection) {
        getJSObject().setProperty("externalProjection", projection.getJSObject());
    }
}
