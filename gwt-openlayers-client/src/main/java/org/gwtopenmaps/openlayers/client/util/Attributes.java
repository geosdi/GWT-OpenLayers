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
package org.gwtopenmaps.openlayers.client.util;

import java.util.Arrays;
import java.util.List;

import org.gwtopenmaps.openlayers.client.util.JSObject;
import org.gwtopenmaps.openlayers.client.util.JSObjectWrapper;

/**
 * Class to hold arbitrary attributes. More constrained than JSObject.
 *
 * @author Rafael Ceravolo - LOGANN
 */
public class Attributes extends JSObjectWrapper {

    public static Attributes narrowToAttributes(JSObject attributes) {
        return (attributes == null) ? null : new Attributes(attributes);
    }

    public Attributes() {
        this(JSObject.createJSObject());
    }

    protected Attributes(JSObject jsObject) {
        super(jsObject);
    }

    /**
     * Unset/Clear the property with the given name. Uses the javascript operator delete
     * @param name - Name of the attribute
     */
    public void unsetAttribute(String name) {
        this.getJSObject().unsetProperty(name);
    }

    /**
     * Sets a String value to the arbitrary attribute.
     *
     * @param name - Name of the attribute
     * @param value - String value of the attribute
     */
    public void setAttribute(String name, String value) {
        this.getJSObject().setProperty(name, value);
    }

    /**
     * Sets an integer value to the arbitrary attribute.
     *
     * @param name - Name of the attribute
     * @param value - Integer value of the attribute
     */
    public void setAttribute(String name, int value) {
        this.getJSObject().setProperty(name, value);
    }

    /**
     * Sets a long value to the arbitrary attribute.
     *
     * @param name - Name of the attribute
     * @param value - Long value of the attribute
     */
    public void setAttribute(String name, long value) {
        this.getJSObject().setProperty(name, value);
    }

    /**
     * Sets a boolean value to the arbitrary attribute.
     *
     * @param name
     *            Name of the attribute
     * @param value
     *            Value of the attribute
     */
    public void setAttribute(String name, boolean value) {
        this.getJSObject().setProperty(name, value);
    }

    /**
     * Sets a float value to the arbitrary attribute.
     *
     * @param name - Name of the attribute
     * @param value - Value of the attribute
     */
    public void setAttribute(String name, float value) {
        this.getJSObject().setProperty(name, value);
    }

    /**
     * Sets a double value to the arbitrary attribute.
     *
     * @param name - Name of the attribute
     * @param value - Value of the attribute
     */
    public void setAttribute(String name, double value) {
        this.getJSObject().setProperty(name, value);
    }

    /**
     * Allows nesting attribute objects.
     *
     */
    public void setAttribute(String name, Attributes attributes) {
        this.getJSObject().setProperty(name, attributes.getJSObject());
    }

    /**
     * Get the value of an attribute as a String
     *
     * @param name - name of the attribute
     * @return the attribute as String
     */
    public String getAttributeAsString(String name) {
        return this.getJSObject().getPropertyAsString(name);
    }

    /**
     * Get the value of an attribute as an integer.
     *
     * @param name - name of the attribute
     * @return the attribute as integer
     */
    public int getAttributeAsInt(String name) {
        return this.getJSObject().getPropertyAsInt(name);
    }

    /**
     * Get the value of an attribute as a boolean.
     *
     * @param name - name of the attribute
     * @return the attribute as boolean
     */
    public boolean getAttributeAsBoolean(String name) {
        return this.getJSObject().getPropertyAsBoolean(name);
    }

    /**
     * Get the value of an attribute as a float.
     *
     * @param name - name of the attribute
     * @return the attribute as float
     */
    public float getAttributeAsFloat(String name) {
        return this.getJSObject().getPropertyAsFloat(name);
    }

    /**
     * Get the value of an attribute as a double.
     *
     * @param name - name of the attribute
     * @return the attribute as double
     */
    public double getAttributeAsDouble(String name) {
        return this.getJSObject().getPropertyAsDouble(name);
    }

    /**
     * Get a nested attribute object.
     *
     * @param name - name of the attribute holding the attributes object
     * @return nested attributes object
     */
    public Attributes getAttributes(String name) {
        return Attributes.narrowToAttributes(this.getJSObject().getProperty(name));
    }

    /**
     * Gets all the names of the attributes.
     * @return The names of all attributes.
     */
    public List<String> getAttributeNames() {
        return Arrays.asList(this.getJSObject().getPropertyNames().split(","));
    }

    /**
     * Gets all the values of the attributes.
     * @return The names of all attributes.
     */
    public List<String> getAttributeValues() {
        return Arrays.asList(this.getJSObject().getPropertyValues().split(","));
    }

}
