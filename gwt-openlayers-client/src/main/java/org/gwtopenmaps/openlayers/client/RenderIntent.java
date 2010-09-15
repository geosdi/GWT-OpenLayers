/**
 * @author Rafael Ceravolo - LOGANN Special Solutions
 */
package org.gwtopenmaps.openlayers.client;

/**
 * RenderIntent is used to indicate which of the know render intents is to be
 * used. According to OpenLayers Documentation there are three known render
 * intents: (default, select, temporary), and they are used mainly for chosing
 * which style should be used for rendering features
 */
public enum RenderIntent {

    DEFAULT("default"), SELECT("select"), TEMPORARY("temporary");

    /**
     * The value to attribute to this enum constant. This should be the value
     * that OpenLayers JavaScript uses for defining properties passed as
     * strings.
     * */
    private String value;

    /**
     * Constructor
     * 
     * @param value
     *            The value to attribute to this enum constant. This should be
     *            the value that OpenLayers JavaScript uses for defining
     *            properties passed as strings.
     */
    private RenderIntent(String value) {
	this.value = value;
    }

    /**
     * Gets the value property: The value to attribute to this enum constant.
     * This should be the value that OpenLayers JavaScript uses for defining
     * properties passed as strings.
     * */
    public String getValue() {
	return value;
    }

}
