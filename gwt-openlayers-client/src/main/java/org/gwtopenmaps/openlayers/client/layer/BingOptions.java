package org.gwtopenmaps.openlayers.client.layer;

/**
 *
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email  giuseppe.lascaleia@geosdi.org
 */
public class BingOptions extends XYZOptions {

    /**
     * Required configuration properties:
     * 
     * key - {String} Bing Maps API key for your application. Get one at
     *     http://bingmapsportal.com/.
     * 
     * type - {String} The layer identifier.  Any non-birdseye imageryType
     *     from http://msdn.microsoft.com/en-us/library/ff701716.aspx can be
     *     used.
     * 
     * @param name
     * @param key 
     * @param type
     */
    public BingOptions(String name, String key, BingType type) {
        if (key == null) {
            throw new NullPointerException("PARAM Key must not be null.");
        }
        getJSObject().setProperty("name", name);
        getJSObject().setProperty("key", key);
        getJSObject().setProperty("type", type == null
                ? BingType.ROAD.toString() : type.toString());
    }

    /**
     * 
     * @return Key Registration
     */
    public String getKey() {
        return getJSObject().getPropertyAsString("key");
    }

    /**
     * 
     * @return Bing Layer Type
     */
    public String getType() {
        return getJSObject().getPropertyAsString("type");
    }

    /**
     * 
     * @return Bing Layer Name
     */
    public String getName() {
        return getJSObject().getPropertyAsString("name");
    }

	@Override
	public void setAttribution(String attribution) {
        getJSObject().setProperty("attributionTemplate", attribution);
	}
}
