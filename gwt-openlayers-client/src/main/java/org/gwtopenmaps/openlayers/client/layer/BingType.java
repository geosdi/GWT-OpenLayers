package org.gwtopenmaps.openlayers.client.layer;

/**
 *
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email  giuseppe.lascaleia@geosdi.org
 */
public enum BingType {

    ROAD("Road"),
    HYBRID("AerialWithLabels"),
    AERIAL("Aerial");
    //
    private String value;

    private BingType(String theValue) {
        this.value = theValue;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
