package org.gwtopenmaps.openlayers.client.protocol;

import org.gwtopenmaps.openlayers.client.feature.VectorFeature;
import org.gwtopenmaps.openlayers.client.layer.WMS;
import org.gwtopenmaps.openlayers.client.util.JObjectArray;

/**
 *
 * WFS Protocol for Vector Layers - intentionally deviates from OpenLayers name.
 * This is basically OpenLayers.Protocol.WFS
 *
 * @author davek<at>komacke<dot>com
 * @author Mikael Couzic
 *
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 *
 */
public class WFSProtocol extends Protocol {

    /**
     * @param options - WFSProtocolOptions used to configure this protocol
     * @return WFSProtocol object
     */
    public WFSProtocol(WFSProtocolOptions options) {
        super(WFSProtocolImpl.create(options.getJSObject()));
    }

    /**
     * Implements the convenience method OpenLayers.Protocol.WFS.fromWMSLayer().
     * Since it's really a constructor we'll call it the proper java constructor
     * name with a layer object.
     *
     * The convenience method uses a WMS Layer to populate a bunch of values
     * under the assumption that the WFS query will be done to the same layer at
     * the server
     *
     * @param layer - WMS Layer to get properties from to configure protocol
     * @param options - WFSProtocolOptions used to configure this protocol
     * @return WFSProtocol object
     */
    public WFSProtocol(WMS layer,
            WFSProtocolOptions options) {
        super(WFSProtocolImpl.create(layer.getJSObject(), options.getJSObject()));
    }

    /**
     * Performs a GetFeature request on the WFS service.
     *
     * Due to the asymetric callback system, the return type of the method has
     * been set to void. The results are accessed by the
     * <code>Callback.computeResult()</code> method.
     *
     * @param options - Options object, encapsulating the callback
     *
     */
    @Override
    public void read(CRUDOptions options) {
        WFSProtocolImpl.read(this.getJSObject(), options.getJSObject());
    }

    /**
     * @param url - the url of the WFS
     */
    public void setUrl(String url) {
        getJSObject().setProperty("url", url);
    }

    /**
     * @param geometryName - set the geometry name
     */
    public void setGeometryName(String geometryName) {
        getJSObject().setProperty("geometryName", geometryName);
    }

    /**
     * @param feature namespace - the namespace of the feature schema
     */
    public void setFeatureNameSpace(String featureNS) {
        getJSObject().setProperty("featureNS", featureNS);
    }

    /**
     * @param feature type - the type of feature, for example: roads, lakes,
     * cities
     */
    public void setFeatureType(String featureType) {
        getJSObject().setProperty("featureType", featureType);
    }

    /**
     * @return url - the url of the WFS
     */
    public String getUrl() {
        return getJSObject().getPropertyAsString("url");
    }

    /**
     * @return geometryName - the name of the geometry
     */
    public String getGeometryName() {
        return getJSObject().getPropertyAsString("geometryName");
    }

    /**
     * @return feature namespace - the namespace of the feature schema
     */
    public String getFeatureNameSpace() {
        return getJSObject().getPropertyAsString("featureNS");
    }

    /**
     * @return feature type - the type of feature, for example: roads, lakes,
     * cities
     */
    public String getFeatureType() {
        return getJSObject().getPropertyAsString("featureType");
    }

    /**
     * Given a list of feature, assemble a batch request for update, create, and
     * delete transactions. A commit call on the prototype amounts to writing a
     * WFS transaction - so the write method on the format is used.
     *
     * @param features
     * @param options
     */
    public void commit(VectorFeature[] features,
            CRUDOptions options) {
        WFSProtocolImpl.commit(getJSObject(),
                               (new JObjectArray(features)).getJSObject(),
                               options.getJSObject());
    }

    /**
     *
     * @param feature
     * @param options
     */
    public void commit(VectorFeature feature,
            CRUDOptions options) {
        VectorFeature[] features = new VectorFeature[1];
        features[0] = feature;
        WFSProtocolImpl.commit(getJSObject(),
                               (new JObjectArray(features)).getJSObject(),
                               options.getJSObject());
    }
}
