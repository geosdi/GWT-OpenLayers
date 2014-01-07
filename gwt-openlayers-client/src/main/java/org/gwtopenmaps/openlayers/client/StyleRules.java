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
package org.gwtopenmaps.openlayers.client;

import org.gwtopenmaps.openlayers.client.util.JSObject;
import org.gwtopenmaps.openlayers.client.util.JSObjectWrapper;

/**
 * Stores style rules for the OpenLayers style.
 * Just a Java wrapper for the style rules passed into a OpenLayers.Style object
 * @author Jon Britton, SpiffyMap Ltd (jonb@spiffymap.net)
 */
public class StyleRules extends JSObjectWrapper {

	protected StyleRules(JSObject jsObject) {
		super(jsObject);
	}

	public StyleRules(){
		this(JSObject.createJSObject());
	}
    
    /**
	 * Hex fill color. Default is '#ee9900'.
	 *
	 * @param c hexidecimal color code or a W3C standard color name
	 */
	public void setFillColor(String c) {
		getJSObject().setProperty("fillColor", c);
	}

	/** Fill opacity (0-1). Default is 0.4 */
	public void setFillOpacity(double o) {
        getJSObject().setProperty("fillOpacity", o);
	}

	/** Pixel point radius. Default is 6. */
	public void setPointRadius(double r) {
        getJSObject().setProperty("pointRadius", r);
	}
    
    /**
	 * The passed String is the name of the attribute whose value will determine
	 * the point radius
	 */
    
    /**
     * Set point radius as a string. Useful for context styling.
     * @param r the point radius
     */
	public void setPointRadius(String r) {
		getJSObject().setProperty("pointRadius", r);
	}

	/**
	 * Hex stroke color. Default is '#ee9900'.
	 *
	 * @param c
	 *            - see setFillColor
	 */
	public void setStrokeColor(String c) {
		getJSObject().setProperty("strokeColor", c);
	}

	/** Pixel stroke width. Default is 1. */
	public void setStrokeWidth(double w) {
        getJSObject().setProperty("strokeWidth", w);
	}

	/** Cursor. Default is ''. */
	public void setCursor(String cursor) {
        getJSObject().setProperty("cursor", cursor);
	}
    
    public void setLabel(String label) {
        getJSObject().setProperty("label", label);
	}
    
    /** The font size for the label, to be provided like in CSS. */
	public void setFontSize(String fontSize) {
        getJSObject().setProperty("fontSize", fontSize);
	}

	/** The font family for the label, to be provided like in CSS. */
	public void setFontFamily(String fontFamily) {
        getJSObject().setProperty("fontFamily", fontFamily);
	}

	/** The font weight for the label, to be provided like in CSS. */
	public void setFontWeight(String fontWeight) {
        getJSObject().setProperty("fontWeight", fontWeight);
	}
}
