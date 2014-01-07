/**
 *
 *   Copyright 2014 sourceforge.
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */
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
